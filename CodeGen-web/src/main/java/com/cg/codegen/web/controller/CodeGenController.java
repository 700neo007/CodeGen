package com.cg.codegen.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.codegen.service.CodeGenService;

/**
 * CodeGen Controller
 * @author Neo
 *
 */
@RequestMapping("codeGen")
@Controller
public class CodeGenController {

	private static final Logger logger = LoggerFactory.getLogger(CodeGenController.class); 
	
	@Autowired
	private CodeGenService codeGenService;
	
	@RequestMapping("toCodeGen")
	public String toCodeGen(HttpServletRequest request) {
		logger.info("toCodeGen#-> {}", codeGenService.getData());
		logger.info("{}", "hello world");
		return "index";
	}
	
}
