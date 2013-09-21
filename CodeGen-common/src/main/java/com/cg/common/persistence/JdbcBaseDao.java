package com.cg.common.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.cg.common.util.JsonUtil;
import com.cg.common.util.SpringContextUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * JDBC dao 基类
 * @author Neo
 *
 */
public abstract class JdbcBaseDao {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 获取连接
	 * @return
	 */
	public Connection getConnection() {
		ComboPooledDataSource dataSource = SpringContextUtil.getBean("masterDataSource");
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		}
		Assert.notNull(connection, "connection is null");
		return connection;
	}
	
	/**
	 * 获取PreparedStatement
	 * @param connection
	 * @param sql
	 * @return
	 */
	public PreparedStatement getPreparedStatement(Connection connection, String sql) {
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		}
		Assert.notNull(pstmt, "PreparedStatement is null");
		return pstmt;
	}
	
	/**
	 * 获取ResultSet
	 * @param preparedStatement
	 * @return
	 */
	public ResultSet getResultSet(PreparedStatement preparedStatement) {
		ResultSet rs = null;
		try {
			rs = preparedStatement.executeQuery();
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		}
		Assert.notNull(rs, "ResultSet is null");
		return rs;
	}
	
	/**
	 * 获取ResultSetMetaData
	 * @param rs
	 * @return
	 */
	public ResultSetMetaData getResultSetMetaData(ResultSet rs) {
		ResultSetMetaData rsMetaData = null;
		try {
			rsMetaData = rs.getMetaData();
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		}
		Assert.notNull(rsMetaData, "ResultSetMetaData is null");
		return rsMetaData;
	}
	
	/**
	 * 获取列名
	 * @param rs
	 * @return
	 */
	public String[] getColumnNames(ResultSet rs) throws SQLException {
		Set<String> columnNameSet = new LinkedHashSet<String>();
		ResultSetMetaData rsMetaData = getResultSetMetaData(rs);
		int columnCount = rsMetaData.getColumnCount();
		String columnName = null;
		for (int i = 0; i < columnCount; i++) {
			columnName = rsMetaData.getColumnName(i + 1);
			columnNameSet.add(columnName);
		}
		if (logger.isDebugEnabled()) 
			logger.debug("getColumns#-> columnNameSet:{}", JsonUtil.toJson(columnNameSet));
		if (columnNameSet.size() != columnCount) {
			throw new SQLException("column name repeat");
		}
		return columnNameSet.toArray(new String[columnNameSet.size()]);
	}
	
	/**
	 * 获取List<Map<列名, 列值>>
	 * @param connection
	 * @param preparedStatement
	 * @return
	 */
	public List<Map<String, Object>> getDataMapList(Connection connection, 
			PreparedStatement preparedStatement) {
		List<Map<String, Object>> dataMapList = new ArrayList<Map<String,Object>>();
		ResultSet rs = getResultSet(preparedStatement);
		try {
			//获取列名
			String[] columnNames = getColumnNames(rs);
			
			Map<String, Object> row = null;
			while (rs.next()) {
				row = new LinkedHashMap<String, Object>(columnNames.length);
				for (String columnName : columnNames) {
					row.put(columnName, rs.getObject(columnName));
				}
				dataMapList.add(row);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		} finally {
			closeConnection(connection, preparedStatement, rs);
		}
		if (logger.isDebugEnabled()) 
			logger.debug("getDataMapList#-> dataMapList:{}", JsonUtil.toJson(dataMapList));
		return dataMapList;
	}
	
	/**
	 * 关闭连接
	 * @param connection 
	 * @param preparedStatement
	 * @param resultSet
	 */
	public void closeConnection(Connection connection, PreparedStatement preparedStatement,
			ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
			}
		}
		
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
			}
		}
		
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
			}
		}
	}
	
}
