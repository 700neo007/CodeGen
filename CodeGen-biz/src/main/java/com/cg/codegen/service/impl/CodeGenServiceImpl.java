package com.cg.codegen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.codegen.dao.CodeGenDao;
import com.cg.codegen.service.CodeGenService;
import com.cg.common.service.BaseService;

/**
 * CodeGen Service Impl
 * @author Neo
 *
 */
@Service
public class CodeGenServiceImpl extends BaseService implements CodeGenService {

	@Autowired
	private CodeGenDao codeGenDao;
	
	public String getData() {
		return codeGenDao.getData();
	}
	
	
}
