package com.cg.codegen.component.generator.mybatisMapperGen;

import java.lang.reflect.Constructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.cg.codegen.model.vo.generator.GeneratorVo;

/**
 * MyBatis Mapper 生成器工厂
 * @author Neo
 *
 */
public class MyBatisMapperGeneratorFactory {

	private static final Logger logger = LoggerFactory.getLogger(MyBatisMapperGeneratorFactory.class);
	
	/**
	 * 创建实体生成器
	 * @param generatorVo 
	 * @return
	 */
	public static MyBatisMapperGenerator createMyBatisMapperGenerator(GeneratorVo generatorVo) {
		MyBatisMapperGenerator myBatisMapperGenerator = null;
		try {
			@SuppressWarnings("unchecked")
			Class<? extends MyBatisMapperGenerator> myBatisMapperGeneratorClz = (Class<? extends MyBatisMapperGenerator>) 
					Class.forName(generatorVo.getMyBatisMapperGeneratorClassName());
			Constructor<? extends MyBatisMapperGenerator> myBatisMapperGeneratorConstructor = 
					myBatisMapperGeneratorClz.getConstructor(GeneratorVo.class);
			myBatisMapperGenerator = myBatisMapperGeneratorConstructor.newInstance(generatorVo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		Assert.notNull(myBatisMapperGenerator, "myBatisMapperGenerator is null");
		return myBatisMapperGenerator;
	}
	
	public static void main(String[] args) {
		GeneratorVo generatorVo = new GeneratorVo();
		generatorVo.setMyBatisMapperGeneratorClassName("com.cg.codegen.component.generator.mybatisMapperGen.MySQLMyBatisMapperGenerator");
		MyBatisMapperGenerator myBatisMapperGenerator = createMyBatisMapperGenerator(generatorVo);
		System.out.println(myBatisMapperGenerator.getClass());
	}
}
