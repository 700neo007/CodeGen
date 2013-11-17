package com.cg.codegen.component.generator.nameStrategy.table2Model;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * 表名->实体的命名策略工厂
 * @author Neo
 *
 */
public class Table2ModelStrategyFactory {

	private static final Logger logger = LoggerFactory.getLogger(Table2ModelStrategyFactory.class);
	
	/**
	 * 创建 表名->实体的命名策略
	 * @param table2ModelStrategyClassName 表名->实体的命名策略类名
	 * @param tableNameLeftTrimPrefix 表名待去除的前缀
	 * @return 
	 */
	public static Table2ModelStrategy createTable2ModelStrategy(String table2ModelStrategyClassName, String tableNameLeftTrimPrefix) {
		Table2ModelStrategy table2ModelStrategy = null;
		try {
			@SuppressWarnings("unchecked")
			Class<? extends Table2ModelStrategy> table2ModelStrategyClz = (Class<? extends Table2ModelStrategy>) 
					Class.forName(table2ModelStrategyClassName);
			Method getInstanceMethod = table2ModelStrategyClz.getMethod("getInstance");
			table2ModelStrategy = (Table2ModelStrategy) getInstanceMethod.invoke(table2ModelStrategyClassName);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		Assert.notNull(table2ModelStrategy, "table2ModelStrategy is null");
		table2ModelStrategy.setTableNameLeftTrimPrefix(tableNameLeftTrimPrefix);
		return table2ModelStrategy;
	}
	
	public static void main(String[] args) {
		Table2ModelStrategy table2ModelStrategy = createTable2ModelStrategy("com.cg.codegen.component.generator.nameStrategy.table2Model.TblUnderlineTable2ModelStrategy", "tbl_");
		System.out.println(table2ModelStrategy.getClass());
	}
}
