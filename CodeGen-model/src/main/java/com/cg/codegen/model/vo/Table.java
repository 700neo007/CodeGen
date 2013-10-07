package com.cg.codegen.model.vo;

import java.io.Serializable;

/**
 * 表实体
 * @author Neo
 *
 */
public class Table implements Serializable {

	private static final long serialVersionUID = -5983218638989579208L;
	
	/**
	 * 表名
	 */
	private String name;
	/**
	 * 表描述
	 */
	private String desc;

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
	
	
}
