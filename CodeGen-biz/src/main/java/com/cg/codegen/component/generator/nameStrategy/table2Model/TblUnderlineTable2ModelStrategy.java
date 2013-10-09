package com.cg.codegen.component.generator.nameStrategy.table2Model;

import com.cg.codegen.component.generator.GeneratorUtil;

/**
 * tbl_commodity_style -> CommodityStyle的表名->实体的命名策略
 * @author Neo
 *
 */
public class TblUnderlineTable2ModelStrategy extends Table2ModelStrategy {

	private static TblUnderlineTable2ModelStrategy _strategy = new TblUnderlineTable2ModelStrategy();
	
	private TblUnderlineTable2ModelStrategy() {}
	
	public static TblUnderlineTable2ModelStrategy getInstance() {
		return _strategy;
	}
	
	/**
	 * 获取实体名
	 * @param tableName 表名
	 * @return
	 */
	@Override
	public String getModelName(String tableName) {
		String modelName = tableName.replace("tbl_", "");
		return GeneratorUtil.underline2PascalNaming(modelName);
	}
	
	public static void main(String[] args) {
		System.out.println(_strategy.getModelName("tbl_dms_commodity_style"));;
	}
	
}
