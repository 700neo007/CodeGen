package com.cg.codegen.component.generator.nameStrategy.table2Model;

/**
 * 默认表名->实体名策略
 * @author Neo
 *
 */
public class DefaultTable2ModelStrategy extends Table2ModelStrategy {

	private static DefaultTable2ModelStrategy _strategy = new DefaultTable2ModelStrategy();
	
	private DefaultTable2ModelStrategy() {}
	
	public static DefaultTable2ModelStrategy getInstance(String left) {
		return _strategy;
	}
	
	/**
	 * 获取实体名
	 * @param tableName 表名
	 * @return
	 */
	@Override
	public String getModelName(String tableName) {
		tableName = leftTrimTableName(tableName);
		return tableName;
	}

}
