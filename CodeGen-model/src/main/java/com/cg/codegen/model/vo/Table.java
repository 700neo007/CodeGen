package com.cg.codegen.model.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	
	/**
	 * 列list
	 */
	private List<Column> columnList = new ArrayList<Column>();

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

	public List<Column> getColumnList() {
		return columnList;
	}

	public void setColumnList(List<Column> columnList) {
		this.columnList = columnList;
	}
	
	
}
