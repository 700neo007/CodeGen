package com.cg.codegen.service;

import java.util.List;

import com.cg.codegen.model.vo.Table;
import com.cg.codegen.model.vo.generator.GeneratorInput;

/**
 * CodeGen Service
 * @author Neo
 *
 */
public interface CodeGenService {

	/**
	 * 获取所有表
	 * @param keyword 关键字
	 * @return
	 */
	public List<Table> getTables(String keyword);
	
	/**
	 * 通过表名获取表
	 * @param tableName
	 * @return
	 */
	public Table getTableByTableName(String tableName);
	
	/**
	 * 通过表名批量获取表格
	 * @param tableNames 表名数组
	 * @return
	 */
	public List<Table> getTablesByTableNames(String[] tableNames);
	
	/**
	 * 生成实体
	 * @param generatorInput 生成器输入参数
	 * @throws Exception
	 */
	public void generateModel(GeneratorInput generatorInput) throws Exception;
	
	/**
	 * 生成MyBatis的Mapper
	 * @param generatorInput 生成器输入参数
	 */
	public void generateMyBatisMapper(GeneratorInput generatorInput) throws Exception;
	
}
