package com.cg.codegen.component.generator.nameStrategy.column2Prop;

import com.cg.codegen.component.generator.GeneratorUtil;


/**
 * last_update_time -> lastUpdateTime,DB字段->实体属性的命名策略
 * @author Neo
 *
 */
public class UnderlineColumn2PropStrategy extends Column2PropStrategy {

	private static UnderlineColumn2PropStrategy _strategy = new UnderlineColumn2PropStrategy();
	
	private UnderlineColumn2PropStrategy() {}
	
	public static UnderlineColumn2PropStrategy getInstance() {
		return _strategy;
	}
	
	/**
	 * 获取实体属性名称
	 * @param columnName
	 * @return
	 */
	@Override
	public String getPropName(String columnName) {
		return GeneratorUtil.underline2CamelNaming(columnName);
	}
	
	public static void main(String[] args) {
		System.out.println(_strategy.getPropName("last_update_time"));
	}

}
