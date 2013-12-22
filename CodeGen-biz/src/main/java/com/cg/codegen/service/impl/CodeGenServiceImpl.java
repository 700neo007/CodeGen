package com.cg.codegen.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.codegen.component.generator.modelGen.ModelGen;
import com.cg.codegen.component.generator.modelGen.ModelGenFactory;
import com.cg.codegen.component.generator.mybatisGen.mapperGen.MyBatisMapperGen;
import com.cg.codegen.component.generator.mybatisGen.mapperGen.MyBatisMapperGenFactory;
import com.cg.codegen.component.generator.mybatisGen.mapperXmlGen.MyBatisMapperXmlGen;
import com.cg.codegen.component.generator.mybatisGen.mapperXmlGen.MyBatisMapperXmlGenFactory;
import com.cg.codegen.component.generator.vo.GeneratorInput;
import com.cg.codegen.dao.CodeGenDao;
import com.cg.codegen.dao.DBMetaDataDao;
import com.cg.codegen.model.vo.Column;
import com.cg.codegen.model.vo.Table;
import com.cg.codegen.service.CodeGenService;
import com.cg.common.service.BaseService;

/**
 * CodeGen Service Impl
 * @author Neo
 *
 */
@Service
public class CodeGenServiceImpl extends BaseService implements CodeGenService {

	@Autowired
	private CodeGenDao codeGenDao;
	@Autowired
	private DBMetaDataDao dbMetaDataDao;
	
	/**
	 * 获取所有表
	 * @param keyword 关键字
	 * @return
	 */
	public List<Table> getTables(String keyword) {
		List<Table> tableList = dbMetaDataDao.getTables();
		if (StringUtils.isEmpty(keyword)) {
			return tableList;
		}
		
		//最终返回的table列表
		List<Table> finalTableList = new ArrayList<Table>(tableList.size());
		
		Pattern keywordPattern = Pattern.compile(keyword);
		
		String tableName = null;
		Matcher keywordMatcher = null;
		for (Table table : tableList) {
			tableName = table.getName();
			keywordMatcher = keywordPattern.matcher(tableName);
			if (keywordMatcher.find()) {
				finalTableList.add(table);
			}
		}
		tableList.clear();
		return finalTableList;
	}
	
	/**
	 * 通过表名获取表
	 * @param tableName
	 * @return
	 */
	public Table getTableByTableName(String tableName) {
		if (StringUtils.isEmpty(tableName)) {
			return null;
		}
		//最终返回的table
		Table finalTable = null;
		
		//获取所有表
		List<Table> tableList = dbMetaDataDao.getTables();
		String tableNameTmp = null;
		for (Table table : tableList) {
			tableNameTmp = table.getName();
			if (tableNameTmp.equals(tableName)) {
				finalTable = table;
				break;
			}
		}
		if (finalTable == null) {
			return null;
		}
		
		//通过表名获取列
		List<Column> columnList = dbMetaDataDao.getColumnsByTableName(tableName);
		finalTable.setColumnList(columnList);
		
		return finalTable;
	}
	
	/**
	 * 通过表名批量获取表格
	 * @param tableNames 表名数组
	 * @return
	 */
	public List<Table> getTablesByTableNames(String[] tableNames) {
		List<Table> tableList = new ArrayList<Table>();
		
		Table tableTmp = null;
		for (String tableName : tableNames) {
			//通过表名获取表
			tableTmp = getTableByTableName(tableName);
			if (tableTmp != null) {
				tableList.add(tableTmp);
			}
		}
		return tableList;
	}
	
	/**
	 * 生成实体
	 * @param generatorInput 生成器输入参数
	 * @throws Exception
	 */
	public void genModel(GeneratorInput generatorInput) throws Exception {
		ModelGen modelGenerator = ModelGenFactory.createModelGenerator(generatorInput);
		modelGenerator.generate();;
	}
	
	/**
	 * 生成MyBatis的Mapper
	 * @param generatorInput 生成器输入参数
	 */
	public void genMyBatisMapper(GeneratorInput generatorInput) throws Exception {
		MyBatisMapperGen myBatisMapperGenerator = MyBatisMapperGenFactory.createMyBatisMapperGenerator(generatorInput);
		myBatisMapperGenerator.generate();
	}
	
	/**
	 * 生成MyBatis的Mapper XML
	 * @param generatorInput 生成器输入参数
	 */
	public void genMyBatisMapperXml(GeneratorInput generatorInput) throws Exception {
		MyBatisMapperXmlGen myBatisMapperXmlGen = MyBatisMapperXmlGenFactory.createMyBatisMapperXmlGenerator(generatorInput);
		myBatisMapperXmlGen.generate();
	}
	
}
