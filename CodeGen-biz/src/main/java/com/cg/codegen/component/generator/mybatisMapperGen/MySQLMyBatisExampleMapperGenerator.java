package com.cg.codegen.component.generator.mybatisMapperGen;

import org.apache.commons.beanutils.PropertyUtils;

import com.cg.codegen.model.vo.generator.GeneratorInput;
import com.cg.codegen.model.vo.generator.mybatisMapperGen.MySQLMyBatisExampleMapperGeneratorVo;
import com.cg.common.util.JsonUtil;

/**
 * MySQL MyBatis Example Mapper 生成器
 * @author Neo
 *
 */
public class MySQLMyBatisExampleMapperGenerator extends MySQLMyBatisMapperGenerator {

	public MySQLMyBatisExampleMapperGenerator(GeneratorInput generatorInput) {
		super();
		MySQLMyBatisExampleMapperGeneratorVo myBatisExampleMapperGeneratorVo = new MySQLMyBatisExampleMapperGeneratorVo();
		try {
			PropertyUtils.copyProperties(myBatisExampleMapperGeneratorVo, generatorInput);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("MySQLMyBatisExampleMapperGenerator#-> myBatisExampleMapperGeneratorVo:" + JsonUtil.toJson(myBatisExampleMapperGeneratorVo));
		setGeneratorVo(myBatisExampleMapperGeneratorVo);
	}
	
	/**
	 * 生成MyBatis Mapper
	 */
	@Override
	public void generateMyBatisMapper() {
		
	}

}
