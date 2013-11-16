package com.cg.codegen.component.generator.nameStrategy.column2Prop;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * DB字段->实体属性的命名策略 工厂
 * @author Neo
 *
 */
public class Column2PropStrategyFactory {

	private static final Logger logger = LoggerFactory.getLogger(Column2PropStrategyFactory.class);
	
	/**
	 * 创建 DB字段->实体属性的命名策略
	 * @param column2PropStrategyClassName DB字段->实体属性的命名策略类名
	 * @return 
	 */
	public static Column2PropStrategy createColumn2PropStrategy(String column2PropStrategyClassName) {
		Column2PropStrategy column2PropStrategy = null;
		try {
			@SuppressWarnings("unchecked")
			Class<? extends Column2PropStrategy> column2PropStrategyClz = (Class<? extends Column2PropStrategy>) 
					Class.forName(column2PropStrategyClassName);
			Method getInstanceMethod = column2PropStrategyClz.getMethod("getInstance");
			column2PropStrategy = (Column2PropStrategy) getInstanceMethod.invoke(column2PropStrategyClassName);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		Assert.notNull(column2PropStrategy, "column2PropStrategy is null");
		return column2PropStrategy;
	}
	
	public static void main(String[] args) {
		Column2PropStrategy column2PropStrategy = createColumn2PropStrategy("com.cg.codegen.component.generator.nameStrategy.column2Prop.UnderlineColumn2PropStrategy");
		System.out.println(column2PropStrategy.getClass());
	}
	
}
