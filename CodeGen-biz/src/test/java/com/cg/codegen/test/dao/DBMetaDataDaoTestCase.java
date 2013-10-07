package com.cg.codegen.test.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.codegen.dao.DBMetaDataDao;
import com.cg.codegen.model.vo.Column;
import com.cg.codegen.model.vo.Table;
import com.cg.codegen.test.BaseTestCase;
import com.cg.common.util.JsonUtil;

public class DBMetaDataDaoTestCase extends BaseTestCase {

	@Autowired
	private DBMetaDataDao dbMetaDataDao;
	
	/**
	 * 获取所有表 测试
	 */
	@Test
	public void testGetTables() {
		List<Table> tableList = dbMetaDataDao.getTables();
		System.out.println("##--tableList:" + JsonUtil.toJson(tableList));
	}
	
	/**
	 * 通过表名获取列 测试
	 */
	@Test
	public void testGetColumnsByTableName() {
		String tableName = "TypeTest";
		List<Column> columnList = dbMetaDataDao.getColumnsByTableName(tableName);
		System.out.println("##--columnList:" + JsonUtil.toJson(columnList));
	}
	
}
