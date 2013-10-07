package com.cg.codegen.dao;

import java.util.List;

import com.cg.codegen.model.vo.Column;
import com.cg.codegen.model.vo.Table;

/**
 * DB 元数据dao
 * @author Neo
 *
 */
public interface DBMetaDataDao {

	/**
	 * 获取所有表
	 * @return
	 */
	public List<Table> getTables();
	
	/**
	 * 通过表名获取列
	 * @param tableName
	 * @return
	 */
	public List<Column> getColumnsByTableName(String tableName);
	
}
