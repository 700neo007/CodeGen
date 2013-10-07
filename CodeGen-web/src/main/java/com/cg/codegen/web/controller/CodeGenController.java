package com.cg.codegen.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.codegen.model.vo.Table;
import com.cg.codegen.service.CodeGenService;
import com.cg.common.util.JsonUtil;
import com.cg.common.web.controller.BaseController;

/**
 * CodeGen Controller
 * @author Neo
 *
 */
@RequestMapping("codeGen")
@Controller
public class CodeGenController extends BaseController {

	@Autowired
	private CodeGenService codeGenService;
	
	/**
	 * 跳转到代码生成页面
	 * @param request
	 * @return
	 */
	@RequestMapping("toCodeGen")
	public String toCodeGen(HttpServletRequest request) {
		return "toCodeGen";
	}
	
	/**
	 * 获取所有table
	 * @param keyword
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getTables")
	public String getTables(String keyword) {
		String prefix = "getTables#-> ";
		logger.info("{}keyword:{}", prefix, keyword);
		keyword = StringUtils.trimToEmpty(keyword);
		List<Table> tableList = codeGenService.getTables(keyword);
		String result = JsonUtil.toJson(tableList);
		return result;
	}
	
	
}
