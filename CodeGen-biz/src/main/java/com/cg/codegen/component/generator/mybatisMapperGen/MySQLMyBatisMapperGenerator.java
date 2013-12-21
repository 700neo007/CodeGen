package com.cg.codegen.component.generator.mybatisMapperGen;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.io.FileUtils;

import com.cg.codegen.component.generator.GeneratorUtil;
import com.cg.codegen.component.generator.nameStrategy.column2Prop.Column2PropStrategy;
import com.cg.codegen.component.generator.nameStrategy.column2Prop.Column2PropStrategyFactory;
import com.cg.codegen.component.generator.nameStrategy.table2Model.Table2ModelStrategy;
import com.cg.codegen.component.generator.nameStrategy.table2Model.Table2ModelStrategyFactory;
import com.cg.codegen.component.typeHandler.MySqlTypeHandler;
import com.cg.codegen.model.vo.Table;
import com.cg.codegen.model.vo.generator.GeneratorInput;
import com.cg.codegen.model.vo.generator.mybatisMapperGen.MySQLMyBatisMapperGeneratorVo;
import com.cg.common.util.FreeMarkerUtil;
import com.cg.common.util.JsonUtil;

/**
 * MySQL MyBatis Mapper 生成器
 * @author Neo
 *
 */
public class MySQLMyBatisMapperGenerator extends MyBatisMapperGenerator  {

	protected MySQLMyBatisMapperGenerator() {}
	
	public MySQLMyBatisMapperGenerator(GeneratorInput generatorInput) {
		MySQLMyBatisMapperGeneratorVo mySQLMyBatisMapperGeneratorVo = new MySQLMyBatisMapperGeneratorVo();
		try {
			PropertyUtils.copyProperties(mySQLMyBatisMapperGeneratorVo, generatorInput);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("MySQLMyBatisMapperGenerator#-> mySQLMyBatisMapperGeneratorVo:" + JsonUtil.toJson(mySQLMyBatisMapperGeneratorVo));
		setGeneratorVo(mySQLMyBatisMapperGeneratorVo);
	}

	/**
	 * 生成MyBatis Mapper
	 */
	@Override
	public void generateMyBatisMapper() {
		
	}
	
//	protected Map<String, Object> getModelMap() {
//		Map<String, Object> modelMap 
//		List<Table> tableList = getTableList();
//		for (Table table : tableList) {
//			
//		}
//	}
	
}
