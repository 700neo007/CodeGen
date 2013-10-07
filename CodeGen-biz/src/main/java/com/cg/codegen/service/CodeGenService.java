package com.cg.codegen.service;

import java.util.List;

import com.cg.codegen.model.vo.Table;

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
	
}
