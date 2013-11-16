package com.cg.codegen.component.generator.modelGen;

import java.lang.reflect.Constructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.cg.codegen.model.vo.generator.GeneratorVo;

/**
 * 实体生成器工厂
 * @author Neo
 *
 */
public class ModelGeneratorFactory {

	private static final Logger logger = LoggerFactory.getLogger(ModelGeneratorFactory.class);
	
	/**
	 * 创建实体生成器
	 * @param generatorVo 
	 * @return
	 */
	public static ModelGenerator createModelGenerator(GeneratorVo generatorVo) {
		ModelGenerator modelGenerator = null;
		try {
			@SuppressWarnings("unchecked")
			Class<? extends ModelGenerator> modelGeneratorClz = (Class<? extends ModelGenerator>) 
					Class.forName(generatorVo.getModelGeneratorClassName());
			Constructor<? extends ModelGenerator> modelGeneratorConstructor = 
					modelGeneratorClz.getConstructor(GeneratorVo.class);
			modelGenerator = modelGeneratorConstructor.newInstance(generatorVo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		Assert.notNull(modelGenerator, "modelGenerator is null");
		return modelGenerator;
	}
	
}
