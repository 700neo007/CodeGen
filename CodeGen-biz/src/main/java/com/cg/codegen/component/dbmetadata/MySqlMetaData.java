package com.cg.codegen.component.dbmetadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

import com.cg.codegen.component.typeHandler.MySqlTypeHandler;
import com.cg.codegen.component.typeHandler.TypeHandler;
import com.cg.codegen.model.vo.Column;
import com.cg.codegen.model.vo.Table;
import com.cg.common.util.JdbcUtil;

/**
 * MySQL 元数据
 * @author Neo
 *
 */
public class MySqlMetaData extends DBMetaData {

	/**
	 * 获取所有表
	 * @return
	 */
	@Override
	public List<Table> getTables() {
		String sql = "SHOW TABLE STATUS";
		List<Map<String, Object>> dataList = JdbcUtil.getDataMapList(sql, null);
		
		if (CollectionUtils.isEmpty(dataList)) {
			return Collections.emptyList();
		}
		
		List<Table> tableList = new ArrayList<Table>(dataList.size());
		Table table = null;
		for (Map<String, Object> row : dataList) {
			table = new Table();
			table.setName(MapUtils.getString(row, "TABLE_NAME"));
			table.setDesc(MapUtils.getString(row, "TABLE_COMMENT"));
			tableList.add(table);
		}
		return tableList;
	}

	/**
	 * 通过表名获取列
	 * @param tableName
	 * @return
	 */
	@Override
	public List<Column> getColumnsByTableName(String tableName) {
		String sql = String.format("SHOW FULL FIELDS FROM %s", tableName);
		List<Map<String, Object>> dataList = JdbcUtil.getDataMapList(sql, null);
		
		if (CollectionUtils.isEmpty(dataList)) {
			return Collections.emptyList();
		}
		
		List<Column> columnList = new ArrayList<Column>();
		Column column = null;
		TypeHandler.TypeInfo typeInfo = null;
		for (Map<String, Object> row : dataList) {
			column = new Column();
			column.setName(MapUtils.getString(row, "COLUMN_NAME"));
			column.setDesc(MapUtils.getString(row, "COLUMN_COMMENT"));
			
			String key = MapUtils.getString(row, "COLUMN_KEY");
			if ("PRI".equals(key)) {
				column.setIsPrimaryKey(true);
			}
			
			typeInfo = MySqlTypeHandler.getTypeInfo(MapUtils.getString(row, "COLUMN_TYPE"));
			try {
				PropertyUtils.copyProperties(column, typeInfo);
			} catch(Exception e) {
				throw new IllegalStateException("PropertyUtils.copyProperties(column, typeInfo) fail");
			}
			columnList.add(column);
		}
		return columnList;
	}

}
