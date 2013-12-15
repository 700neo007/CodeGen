package com.cg.codegen.component.generator.mybatisMapperGen;

import java.util.List;

import com.cg.codegen.component.generator.CodeGenerator;
import com.cg.codegen.model.vo.Table;
import com.cg.codegen.model.vo.generator.mybatisMapperGen.MyBatisMapperGeneratorVo;

/**
 * MyBatis Mapper 生成器
 * @author Neo
 *
 */
public abstract class MyBatisMapperGenerator extends CodeGenerator {
	
	/**
	 * table列表
	 */
	private List<Table> tableList;
	/**
	 * MyBatis Mapper生成器vo
	 */
	private MyBatisMapperGeneratorVo myBatisMapperGeneratorVo;
	
	/**
	 * 生成MyBatis Mapper
	 */
	public abstract void generateMyBatisMapper();
	
	/**
	 * 获取MyBatis Mapper生成器vo，并转化为子类
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <T extends MyBatisMapperGeneratorVo> T getMyBatisMapperGeneratorVoAsSub() {
		return (T) myBatisMapperGeneratorVo;
	}

	public List<Table> getTableList() {
		return tableList;
	}

	public void setTableList(List<Table> tableList) {
		this.tableList = tableList;
	}

	public MyBatisMapperGeneratorVo getMyBatisMapperGeneratorVo() {
		return myBatisMapperGeneratorVo;
	}

	public void setMyBatisMapperGeneratorVo(MyBatisMapperGeneratorVo myBatisMapperGeneratorVo) {
		this.myBatisMapperGeneratorVo = myBatisMapperGeneratorVo;
	}
	
	
	
}
