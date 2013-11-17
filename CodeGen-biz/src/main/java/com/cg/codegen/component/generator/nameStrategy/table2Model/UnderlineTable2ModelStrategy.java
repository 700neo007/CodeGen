package com.cg.codegen.component.generator.nameStrategy.table2Model;

import com.cg.codegen.component.generator.GeneratorUtil;

/**
 * 下划线分割的表名->实体的命名策略，例如：去掉的前缀为tbl_，则tbl_commodity_style -> CommodityStyle的
 * @author Neo
 *
 */
public class UnderlineTable2ModelStrategy extends Table2ModelStrategy {

	private static UnderlineTable2ModelStrategy _strategy = new UnderlineTable2ModelStrategy();
	
	private UnderlineTable2ModelStrategy() {}
	
	public static UnderlineTable2ModelStrategy getInstance() {
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
		return GeneratorUtil.underline2PascalNaming(tableName);
	}
	
	public static void main(String[] args) {
		_strategy.setTableNameLeftTrimPrefix("tbl_");
		System.out.println(_strategy.getModelName("tbl_dms_commodity_style"));;
	}

}
