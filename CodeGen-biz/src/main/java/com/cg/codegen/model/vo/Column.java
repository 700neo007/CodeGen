package com.cg.codegen.model.vo;

import java.io.Serializable;

/**
 * 列实体
 * @author Neo
 *
 */
public class Column implements Serializable {

	private static final long serialVersionUID = -2544029813902563472L;
	
	/**
	 * 列名
	 */
	private String name;
	/**
	 * 列描述
	 */
	private String desc;
	/**
	 * 类型描述
	 */
	private String typeDesc;
	/**
	 * 类型
	 */
	private String type;
	/**
	 * 长度
	 */
	private Integer length;
	/**
	 * 精度
	 */
	private Integer precision;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getTypeDesc() {
		return typeDesc;
	}
	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public Integer getPrecision() {
		return precision;
	}
	public void setPrecision(Integer precision) {
		this.precision = precision;
	}
	
	
	
}
