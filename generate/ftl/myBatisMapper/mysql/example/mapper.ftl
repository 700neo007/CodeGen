package ${myBatisMapperPackage};

<#assign modelName = table2ModelStrategy.getModelName(table.getName()) >

import ${package}.${modelName};
import ${myBatisBaseMapperPackage}.${myBatisBaseMapperName};
import ${myBatisCriteriaPackage}.${modelName}Criteria;

/**
 * ${table.desc} mapper
 * @author CodeGen
 * ${time}
 */
public interface ${modelName}Mapper extends ${myBatisBaseMapperName}<${modelName}, ${modelName}Criteria> {
	
	
	
}