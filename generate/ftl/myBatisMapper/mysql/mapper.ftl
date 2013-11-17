package ${myBatisMapperPackage};

<#assign modelName = table2ModelStrategy.getModelName(table.getName()) >

import ${package}.${modelName};

/**
 * ${table.desc} mapper
 * @author CodeGen
 * ${time}
 */
public interface ${modelName}Mapper {

	/**
	 * 新增一条记录
	 */
	int insert(${modelName} record);
	
	/**
	 * 新增一条记录
	 */
    int insertSelective(${modelName} record);
    
	/**
	 * 删除一条记录
	 */
	int deleteByPrimaryKey(String id);
	
	/**
	 * 修改一条记录
	 */
    int updateByPrimaryKey(${modelName} record);
	
	/**
	 * 修改一条记录
	 */
    int updateByPrimaryKeySelective(${modelName} record);
    
	/**
	 * 通过主键查询一条记录
	 */
	${modelName} selectByPrimaryKey(String id);
	
}