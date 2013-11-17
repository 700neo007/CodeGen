package com.cg.codegen.component.generator.nameStrategy.table2Model;

/**
 * 表名->实体名策略
 * @author Neo
 *
 */
public abstract class Table2ModelStrategy {
	
	/**
	 * 表名待去除的前缀
	 */
	private String tableNameLeftTrimPrefix = "";
	
	/**
	 * 去掉表名前缀
	 * @param tableName 表名
	 * @return
	 */
	protected String leftTrimTableName(String tableName) {
		if (tableNameLeftTrimPrefix != null || tableNameLeftTrimPrefix.length() != 0) {
			return tableName.replace(tableNameLeftTrimPrefix, "");
		}
		return tableName;
	}
	
	/**
	 * 获取实体名
	 * @param tableName 表名
	 * @return
	 */
	public abstract String getModelName(String tableName);

	public String getTableNameLeftTrimPrefix() {
		return tableNameLeftTrimPrefix;
	}

	public void setTableNameLeftTrimPrefix(String tableNameLeftTrimPrefix) {
		this.tableNameLeftTrimPrefix = tableNameLeftTrimPrefix;
	}
	
	
	
}
