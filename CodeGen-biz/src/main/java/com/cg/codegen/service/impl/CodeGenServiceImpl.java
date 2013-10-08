package com.cg.codegen.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.codegen.dao.CodeGenDao;
import com.cg.codegen.dao.DBMetaDataDao;
import com.cg.codegen.model.vo.Table;
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
	@Autowired
	private DBMetaDataDao dbMetaDataDao;
	
	/**
	 * 获取所有表
	 * @param keyword 关键字
	 * @return
	 */
	public List<Table> getTables(String keyword) {
		List<Table> tableList = dbMetaDataDao.getTables();
		if (StringUtils.isEmpty(keyword)) {
			return tableList;
		}
		
		//最终返回的table列表
		List<Table> finalTableList = new ArrayList<Table>(tableList.size());
		
		Pattern keywordPattern = Pattern.compile(keyword);
		
		String tableName = null;
		Matcher keywordMatcher = null;
		for (Table table : tableList) {
			tableName = table.getName();
			keywordMatcher = keywordPattern.matcher(tableName);
			if (keywordMatcher.find()) {
				finalTableList.add(table);
			}
		}
		tableList.clear();
		return finalTableList;
	}
	
	/**
	 * 
	 * @param tableName
	 * @param extParam
	 */
	public void generateModels(String tableName, Map<String, Object> extParam) {
		
	}
	
}
