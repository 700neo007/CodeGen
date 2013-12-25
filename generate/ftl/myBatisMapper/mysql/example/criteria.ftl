package ${myBatisCriteriaPackage};

<#assign modelName = table2ModelStrategy.getModelName(table.getName()) >
<#assign criteriaName = modelName + "Criteria" >

import java.util.List;

import ${myBatisBaseCriteriaPackage}.${myBatisBaseCriteriaName};

<#list importList as item>
import ${item};
</#list>

/**
 * ${table.desc} Criteria
 * @author CodeGen
 * ${time}
 */
public class ${criteriaName} extends ${myBatisBaseCriteriaName} {

	<#list table.columnList as column >
	<#assign propPascalName = generatorUtil.underline2PascalNaming(column.name) >
	<#assign propName = column2PropStrategy.getPropName(column.name) >
	<#assign propType = SQL_TYPE_JAVA_TYPE_MAP[column.type] >
	
	//------------------------------ ${propName} ---------------------------------
	
	public ${criteriaName} and${propPascalName}IsNull() {addCriterion("${column.name} is null"); return this;}
	public ${criteriaName} and${propPascalName}IsNotNull() {addCriterion("${column.name} is not null"); return this;}
	public ${criteriaName} and${propPascalName}EqualTo(${propType} value) {addCriterion("${column.name} = ", value, "${propName}"); return this;}
	public ${criteriaName} and${propPascalName}NotEqualTo(${propType} value) {addCriterion("${column.name} <> ", value, "${propName}"); return this;}
	public ${criteriaName} and${propPascalName}GreaterThan(${propType} value) {addCriterion("${column.name} > ", value, "${propName}"); return this;}
	public ${criteriaName} and${propPascalName}GreaterThanOrEqualTo(${propType} value) {addCriterion("${column.name} >= ", value, "${propName}"); return this;}
	public ${criteriaName} and${propPascalName}LessThan(${propType} value) {addCriterion("${column.name} < ", value, "${propName}"); return this;}
	public ${criteriaName} and${propPascalName}LessThanOrEqualTo(${propType} value) {addCriterion("${column.name} <= ", value, "${propName}"); return this;}
	public ${criteriaName} and${propPascalName}Like(${propType} value) {addCriterion("${column.name} like ", value, "${propName}"); return this;}
	public ${criteriaName} and${propPascalName}NotLike(${propType} value) {addCriterion("${column.name} not like ", value, "${propName}"); return this;}
	public ${criteriaName} and${propPascalName}In(List<${propType}> values) {addCriterion("${column.name} in ", values, "${propName}"); return this;}
	public ${criteriaName} and${propPascalName}NotIn(List<${propType}> values) {addCriterion("${column.name} not in ", values, "${propName}"); return this;}
	public ${criteriaName} and${propPascalName}Between(${propType} value1, ${propType} value2) {addCriterion("${column.name} between ", value1, value2, "${propName}"); return this;}
	public ${criteriaName} and${propPascalName}NotBetween(${propType} value1, ${propType} value2) {addCriterion("${column.name} not between ", value1, value2, "${propName}"); return this;}
	</#list>
	
}
