package com.cg.codegen.component.generator.modelGen;

import java.lang.reflect.Constructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.cg.codegen.component.generator.vo.GeneratorInput;

/**
 * 实体生成器工厂
 * @author Neo
 *
 */
public class ModelGenFactory {

	private static final Logger logger = LoggerFactory.getLogger(ModelGenFactory.class);
	
	/**
	 * 创建实体生成器
	 * @param generatorInput 
	 * @return
	 */
	public static ModelGen createModelGenerator(GeneratorInput generatorInput) {
		ModelGen modelGenerator = null;
		try {
			@SuppressWarnings("unchecked")
			Class<? extends ModelGen> modelGeneratorClz = (Class<? extends ModelGen>) 
					Class.forName(generatorInput.getModelGeneratorClassName());
			Constructor<? extends ModelGen> modelGeneratorConstructor = 
					modelGeneratorClz.getConstructor(GeneratorInput.class);
			modelGenerator = modelGeneratorConstructor.newInstance(generatorInput);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		Assert.notNull(modelGenerator, "modelGenerator is null");
		return modelGenerator;
	}
	
}
