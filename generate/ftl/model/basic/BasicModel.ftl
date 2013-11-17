package ${package};

import java.io.Serializable;
<#list importList as item>
import ${item};
</#list>

/**
 * ${table.desc}
 * @author CodeGen
 * ${time}
 */
public class ${table2ModelStrategy.getModelName(table.name)} implements Serializable {
	
	private static final long serialVersionUID = -${versionId}L;

	<#list table.columnList as column >
	/**
	 * ${column.desc}
	 */
	private ${SQL_TYPE_JAVA_TYPE_MAP[column.type]} ${column2PropStrategy.getPropName(column.name)};
	</#list>
	
	//--------------Getter/Setter--------------
	<#list table.columnList as column >
	public ${SQL_TYPE_JAVA_TYPE_MAP[column.type]} get${generatorUtil.underline2PascalNaming(column.name)}() {
		return ${column2PropStrategy.getPropName(column.name)};
	}
	
	public void set${generatorUtil.underline2PascalNaming(column.name)}(${SQL_TYPE_JAVA_TYPE_MAP[column.type]} ${column2PropStrategy.getPropName(column.name)}) {
		this.${column2PropStrategy.getPropName(column.name)} = ${column2PropStrategy.getPropName(column.name)};
	}

	</#list>
}