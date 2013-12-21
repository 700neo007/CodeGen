package com.cg.codegen.component.generator.mybatisMapperGen;

import java.lang.reflect.Constructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.cg.codegen.model.vo.generator.GeneratorInput;

/**
 * MyBatis Mapper 生成器工厂
 * @author Neo
 *
 */
public class MyBatisMapperGeneratorFactory {

	private static final Logger logger = LoggerFactory.getLogger(MyBatisMapperGeneratorFactory.class);
	
	/**
	 * 创建实体生成器
	 * @param generatorInput 
	 * @return
	 */
	public static MyBatisMapperGenerator createMyBatisMapperGenerator(GeneratorInput generatorInput) {
		MyBatisMapperGenerator myBatisMapperGenerator = null;
		try {
			@SuppressWarnings("unchecked")
			Class<? extends MyBatisMapperGenerator> myBatisMapperGeneratorClz = (Class<? extends MyBatisMapperGenerator>) 
					Class.forName(generatorInput.getMyBatisMapperGeneratorClassName());
			Constructor<? extends MyBatisMapperGenerator> myBatisMapperGeneratorConstructor = 
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
		MyBatisMapperGenerator myBatisMapperGenerator = createMyBatisMapperGenerator(generatorInput);
		System.out.println(myBatisMapperGenerator.getClass());
	}
}
