package com.cg.codegen.component.generator.nameStrategy.column2Prop;

/**
 * DB字段->实体属性命名策略
 * @author Neo
 *
 */
public abstract class Column2PropStrategy {

	/**
	 * 获取实体属性名称
	 * @param columnName
	 * @return
	 */
	public abstract String getPropName(String columnName);
	
}
