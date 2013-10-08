package com.cg.codegen.component.generator.nameStrategy.table2Model;

/**
 * 表名->实体名策略
 * @author Neo
 *
 */
public abstract class Table2ModelStrategy {

	/**
	 * 获取实体名
	 * @param tableName 表名
	 * @return
	 */
	public abstract String getModelName(String tableName);
	
}
