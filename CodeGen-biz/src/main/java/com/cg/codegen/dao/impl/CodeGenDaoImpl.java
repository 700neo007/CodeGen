package com.cg.codegen.dao.impl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cg.codegen.dao.CodeGenDao;
import com.cg.common.persistence.JdbcBaseDao;
import com.cg.common.util.JsonUtil;

@Repository
public class CodeGenDaoImpl extends JdbcBaseDao implements CodeGenDao {

//	/**
//	 * 获取所有表名
//	 * @return
//	 */
//	public List<String> getTableNames() {
//		Connection connection = getConnection();
//		
//		try {
//			DatabaseMetaData dbMetaData = connection.getMetaData();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		closeConnection(connection, null, null);
//	}
	
	public String getData() {
		String sql = "SELECT cs.`no`, cs.commodity_name FROM tbl_commodity_style cs LIMIT 100";
		Connection connection = getConnection();
		PreparedStatement pstmt = getPreparedStatement(connection, sql);
		List<Map<String, Object>> list = getDataMapList(connection, pstmt);
		return JsonUtil.toJson(list);
	}
	
}
