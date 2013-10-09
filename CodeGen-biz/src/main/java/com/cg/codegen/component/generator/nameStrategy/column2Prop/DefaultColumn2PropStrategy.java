package com.cg.codegen.component.generator.nameStrategy.column2Prop;


/**
 * 默认的DB字段->实体属性的命名策略
 * @author Neo
 *
 */
public class DefaultColumn2PropStrategy extends Column2PropStrategy {

	private static DefaultColumn2PropStrategy _strategy = new DefaultColumn2PropStrategy();
	
	private DefaultColumn2PropStrategy() {}
	
	public static DefaultColumn2PropStrategy getInstance() {
		return _strategy;
	}
	
	/**
	 * 获取实体属性名称
	 * @param columnName
	 * @return
	 */
	@Override
	public String getPropName(String columnName) {
		return columnName;
	}
	
	public static void main(String[] args) {
		System.out.println(_strategy.getPropName("last_update_time"));
	}
	
}
