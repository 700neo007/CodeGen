package com.cg.codegen.component.generator.modelGen;

import java.io.File;
import java.io.IOException;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.io.FileUtils;

import com.cg.codegen.component.generator.GeneratorUtil;
import com.cg.codegen.component.generator.vo.GeneratorInput;
import com.cg.codegen.component.generator.vo.modelGen.BasicModelGenVo;
import com.cg.common.util.FreeMarkerUtil.GenerateInfo;
import com.cg.common.util.JsonUtil;


/**
 * 基本实体生成器
 * @author Neo
 *
 */
public class BasicModelGen extends ModelGen {

	/**
	 * 
	 * @param generatorInput 生成器输入参数
	 */
	public BasicModelGen(GeneratorInput generatorInput) {
		BasicModelGenVo basicModelGeneratorVo = new BasicModelGenVo();
		try {
			PropertyUtils.copyProperties(basicModelGeneratorVo, generatorInput);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("BasicModelGenerator#-> basicModelGeneratorVo:" + JsonUtil.toJson(basicModelGeneratorVo));
		setGeneratorVo(basicModelGeneratorVo);
	}

	/**
	 * 建造模板根路径
	 */
	@Override
	public void buildFtlRoot() {
		iterateBuildPart(new IterateBuildPartCallBack<BasicModelGenVo>() {
			@Override
			public void buildSinglePart(String tableName, GenerateInfo generateInfo, BasicModelGenVo generatorVo) {
				generateInfo.setFtlRoot(generatorVo.getModelFtlRoot());
			}
		});
	}

	/**
	 * 建造模板文件名称
	 */
	@Override
	public void buildFtlFile() {
		iterateBuildPart(new IterateBuildPartCallBack<BasicModelGenVo>() {
			@Override
			public void buildSinglePart(String tableName, GenerateInfo generateInfo, BasicModelGenVo generatorVo) {
				generateInfo.setFtlFile(generatorVo.getModelFtlFile());
			}
		});
	}

	/**
	 * 建造生成的文件的基路径
	 */
	@Override
	public void buildTargetRoot() {
		iterateBuildPart(new IterateBuildPartCallBack<BasicModelGenVo>() {
			@Override
			public void buildSinglePart(String tableName, GenerateInfo generateInfo, BasicModelGenVo generatorVo) {
				String targetRoot = String.format("%s%s%s", 
						generatorVo.getModelOutputRoot(), File.separator,
						GeneratorUtil.getPathByPackage(generatorVo.getModelPackage()));
				generateInfo.setTargetRoot(targetRoot);
				try {
					FileUtils.forceMkdir(new File(targetRoot));
				} catch (IOException e) {
					logger.error(e.getMessage(), e);
				}
			}
		});
	}

	/**
	 * 建造生成的文件的名称
	 */
	@Override
	public void buildTargetFile() {
		iterateBuildPart(new IterateBuildPartCallBack<BasicModelGenVo>() {
			@Override
			public void buildSinglePart(String tableName, GenerateInfo generateInfo, BasicModelGenVo generatorVo) {
				String targetFile = getTable2ModelStrategy().getModelName(tableName) + ".java";
				generateInfo.setTargetFile(targetFile);
			}
		});
	}
	
	

}
