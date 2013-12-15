package ${myBatisMapperPackage};

<#assign modelName = table2ModelStrategy.getModelName(table.getName()) >

import ${package}.${modelName};
import ${myBatisExampleBaseMapperPackage}.${myBatisExampleBaseMapperName};

/**
 * ${table.desc} mapper
 * @author CodeGen
 * ${time}
 */
public interface ${modelName}Mapper extends ${myBatisExampleBaseMapperName}<${modelName}> {


	
}