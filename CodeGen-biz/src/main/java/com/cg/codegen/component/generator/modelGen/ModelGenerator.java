package com.cg.codegen.component.generator.modelGen;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cg.codegen.model.vo.Table;
import com.cg.codegen.model.vo.generator.GeneratorSubmitVo;
import com.cg.codegen.model.vo.generator.modelGen.ModelGeneratorVo;

/**
 * 实体生成器
 * @author Neo
 *
 */
public abstract class ModelGenerator {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	//----------------数据模型key
	
	public static final String MODEL_MAP_KEY_TABLE = "table";
	
	public static final String MODEL_MAP_KEY_PACKAGE = "package";
	
	//-----------------------------------------
	
	/**
	 * table列表
	 */
	private List<Table> tableList;
	/**
	 * 生成文件提交vo
	 */
	private GeneratorSubmitVo submitVo;
	/**
	 * 实体生成vo
	 */
	private ModelGeneratorVo modelGeneratorVo;
	
	/**
	 * 生成实体
	 * @param tableList 
	 * @param submitVo 
	 */
	public abstract void generateModel();
	
	/**
	 * 实体生成器vo，并转化为子类
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T extends ModelGeneratorVo> T getModelGeneratorVoAsSub() {
		return (T) modelGeneratorVo;
	}

	public List<Table> getTableList() {
		return tableList;
	}

	public void setTableList(List<Table> tableList) {
		this.tableList = tableList;
	}

	public GeneratorSubmitVo getSubmitVo() {
		return submitVo;
	}

	public void setSubmitVo(GeneratorSubmitVo submitVo) {
		this.submitVo = submitVo;
	}

	public ModelGeneratorVo getModelGeneratorVo() {
		return modelGeneratorVo;
	}

	public void setModelGeneratorVo(ModelGeneratorVo modelGeneratorVo) {
		this.modelGeneratorVo = modelGeneratorVo;
	}
	
	
}
