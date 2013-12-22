package com.cg.codegen.component.generator.mybatisGen.mapperGen;

import java.lang.reflect.Constructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.cg.codegen.component.generator.vo.GeneratorInput;

/**
 * MyBatis Mapper 生成器工厂
 * @author Neo
 *
 */
public class MyBatisMapperGenFactory {

	private static final Logger logger = LoggerFactory.getLogger(MyBatisMapperGenFactory.class);
	
	/**
	 * 创建MyBatis Mapper 生成器
	 * @param generatorInput 
	 * @return
	 */
	public static MyBatisMapperGen createMyBatisMapperGenerator(GeneratorInput generatorInput) {
		MyBatisMapperGen myBatisMapperGenerator = null;
		try {
			@SuppressWarnings("unchecked")
			Class<? extends MyBatisMapperGen> myBatisMapperGeneratorClz = (Class<? extends MyBatisMapperGen>) 
					Class.forName(generatorInput.getMyBatisMapperGeneratorClassName());
			Constructor<? extends MyBatisMapperGen> myBatisMapperGeneratorConstructor = 
					myBatisMapperGeneratorClz.getConstructor(GeneratorInput.class);
			myBatisMapperGenerator = myBatisMapperGeneratorConstructor.newInstance(generatorInput);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		Assert.notNull(myBatisMapperGenerator, "myBatisMapperGenerator is null");
		return myBatisMapperGenerator;
	}
	
	public static void main(String[] args) {
		GeneratorInput generatorInput = new GeneratorInput();
		generatorInput.setMyBatisMapperGeneratorClassName("com.cg.codegen.component.generator.mybatisMapperGen.MySQLMyBatisMapperGenerator");
		MyBatisMapperGen myBatisMapperGenerator = createMyBatisMapperGenerator(generatorInput);
		System.out.println(myBatisMapperGenerator.getClass());
	}
}
