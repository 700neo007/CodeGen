package com.cg.codegen.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cg.codegen.component.dbmetadata.DBMetaData;
import com.cg.codegen.component.dbmetadata.DBMetaDataFactory;
import com.cg.codegen.dao.DBMetaDataDao;
import com.cg.codegen.model.vo.Column;
import com.cg.codegen.model.vo.Table;
import com.cg.common.persistence.JdbcBaseDao;

/**
 * DB 元数据dao impl
 * @author Neo
 *
 */
@Repository
public class DBMetaDataDaoImpl extends JdbcBaseDao implements DBMetaDataDao {
	
	/**
	 * db元数据
	 */
	private DBMetaData dbMetaData;
	
	public DBMetaDataDaoImpl() {
		this.dbMetaData = DBMetaDataFactory.createDBMetaData();
	}
	
	/**
	 * 获取所有表
	 * @return
	 */
	public List<Table> getTables() {
		return dbMetaData.getTables();
	}
	
	/**
	 * 通过表名获取列
	 * @param tableName
	 * @return
	 */
	public List<Column> getColumnsByTableName(String tableName) {
		return dbMetaData.getColumnsByTableName(tableName);
	}
	
}
