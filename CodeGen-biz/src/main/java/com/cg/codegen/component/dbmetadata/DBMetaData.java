package com.cg.codegen.component.dbmetadata;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cg.codegen.model.vo.Column;
import com.cg.codegen.model.vo.Table;

/**
 * DB 元数据
 * @author Neo
 *
 */
public abstract class DBMetaData {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * schema名称
	 */
	private String schema;
	
	/**
	 * 获取所有表
	 * @return
	 */
	public abstract List<Table> getTables();
	
	/**
	 * 通过表名获取列
	 * @param tableName
	 * @return
	 */
	public abstract List<Column> getColumnsByTableName(String tableName);

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}
	
	
	
}
