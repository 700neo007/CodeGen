package com.cg.codegen.component.generator;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.cg.codegen.component.generator.director.CodeGenDirector;
import com.cg.codegen.component.generator.nameStrategy.column2Prop.Column2PropStrategy;
import com.cg.codegen.component.generator.nameStrategy.column2Prop.Column2PropStrategyFactory;
import com.cg.codegen.component.generator.nameStrategy.table2Model.Table2ModelStrategy;
import com.cg.codegen.component.generator.nameStrategy.table2Model.Table2ModelStrategyFactory;
import com.cg.codegen.component.generator.vo.BaseGeneratorVo;
import com.cg.codegen.component.typeHandler.MySqlTypeHandler;
import com.cg.codegen.model.vo.Table;
import com.cg.common.constant.CommonConstant;
import com.cg.common.util.FreeMarkerUtil;
import com.cg.common.util.FreeMarkerUtil.GenerateInfo;
import com.cg.common.util.JsonUtil;
import com.cg.common.util.ReflectionUtil;

/**
 * 代码生成器
 * 
 * @author Neo
 * 
 */
public abstract class CodeGenerator {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	// ----------------数据模型key

	public static final String MODEL_MAP_KEY_CUR_TIME = "time";
	
	public static final String MODEL_MAP_KEY_TABLE = "table";

	public static final String MODEL_MAP_KEY_PACKAGE = "package";

	public static final String MODEL_MAP_KEY_SQL_TYPE_JAVA_TYPE_MAP = "SQL_TYPE_JAVA_TYPE_MAP";

	public static final String MODEL_MAP_KEY_TABLE_2_MODEL_NAME_STRATEGY = "table2ModelStrategy";

	public static final String MODEL_MAP_KEY_COLUMN_2_PROP_NAME_STRATEGY = "column2PropStrategy";

	public static final String MODEL_MAP_KEY_GENERATOR_UTIL = "generatorUtil";

	public static final String MODEL_MAP_KEY_IMPORT_LIST = "importList";

	public static final String MODEL_MAP_KEY_VERSION_ID = "versionId";
	
	public static final String MODEL_MAP_KEY_MYBATIS_MAPPER_PACKAGE = "myBatisMapperPackage";
	
	public static final String MODEL_MAP_KEY_MYBATIS_MAPPER_XML_PACKAGE = "myBatisMapperXmlPackage";

	public static final String MODEL_MAP_KEY_SQL_TPYE_MYBATIS_JDBC_TYPE_MAP = "SQL_TPYE_MYBATIS_JDBC_TYPE_MAP";

	public static final String MODEL_MAP_KEY_BASE_MAPPER_PACKAGE = "myBatisExampleBaseMapperPackage";

	public static final String MODEL_MAP_KEY_BASE_MAPPER_NAME = "myBatisExampleBaseMapperName";
	
	// -----------------------------------------
	
	/**
	 * 生成器vo
	 */
	private BaseGeneratorVo generatorVo;
	/**
	 * 文件生成信息map，Map<表名, 文件生成信息>，这是建造者模式中的成品
	 */
	private Map<String, FreeMarkerUtil.GenerateInfo> generateInfoMap = new HashMap<String, FreeMarkerUtil.GenerateInfo>();
	// -----------------------------------------
	
	/**
	 * 生成代码
	 */
	public void generate() {
		CodeGenDirector codeGenDirector = new CodeGenDirector(this);
		//创建生成器信息，成品保存在generateInfoMap中
		codeGenDirector.createGeneratorInfo();
		logger.info("generate#-> generateInfoMap: {}", JsonUtil.toJson(generateInfoMap));
		//文件生成信息list
		List<FreeMarkerUtil.GenerateInfo> generateInfoList = new ArrayList<FreeMarkerUtil.GenerateInfo>();
		List<Table> tableList = generatorVo.getTableList();
		for (Table table : tableList) {
			FreeMarkerUtil.GenerateInfo generateInfo = generateInfoMap.get(table.getName());
			Assert.notNull(generateInfo, "generateInfo could not be null");
			generateInfoList.add(generateInfo);
		}
		logger.info("generateInfoList:{}", JsonUtil.toJson(generateInfoList));
		FreeMarkerUtil.generateFiles(generateInfoList);
	}
	
	/**
	 * 获取生成器vo，并转化为子类
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <T extends BaseGeneratorVo> T getGeneratorVoAsSub() {
		return (T) generatorVo;
	}
	
	/**
	 * 获取当前时间
	 * @return
	 */
	protected String getCurTime() {
		Date date = new Date();
		return DateFormatUtils.format(date, CommonConstant.DATE_TIME_FORMAT);
	}
	
	/**
	 * 获取模板模型map
	 * @return 返回Map<表名, Map<key, value>>
	 */
	protected Map<String, Map<String, Object>> getTemplateModelMaps() {
		Map<String, Map<String, Object>> modelMaps = new HashMap<String, Map<String,Object>>();
		
		List<Table> tableList = generatorVo.getTableList();
		Assert.notEmpty(tableList, "tableList could not be empty");
		for (Table table : tableList) {
			//数据模型
			Map<String, Object> modelMap = new HashMap<String, Object>();
			
			//表名->实体名命名策略
			Table2ModelStrategy table2ModelStrategy = getTable2ModelStrategy();
			//DB字段->实体属性命名策略
			Column2PropStrategy column2PropStrategy = getColumn2PropStrategy();
			
			modelMap.put(MODEL_MAP_KEY_CUR_TIME, getCurTime());
			modelMap.put(MODEL_MAP_KEY_TABLE, table);
			modelMap.put(MODEL_MAP_KEY_PACKAGE, generatorVo.getModelPackage());
			//MySQL类型、JAVA类型映射，Map
			modelMap.put(MODEL_MAP_KEY_SQL_TYPE_JAVA_TYPE_MAP, MySqlTypeHandler.SQL_TYPE_JAVA_TYPE_MAP);
			//表名->实体名命名策略
			modelMap.put(MODEL_MAP_KEY_TABLE_2_MODEL_NAME_STRATEGY, table2ModelStrategy);
			//DB字段->实体属性命名策略
			modelMap.put(MODEL_MAP_KEY_COLUMN_2_PROP_NAME_STRATEGY, column2PropStrategy);
			//generatorUtil
			modelMap.put(MODEL_MAP_KEY_GENERATOR_UTIL, GeneratorUtil.getInstance());
			
			modelMaps.put(table.getName(), modelMap);
		}
		Assert.isTrue(modelMaps.size() != 0, "modelMaps could not be empty");
		
		return modelMaps;
	}
	
	/**
	 * 表名->实体名命名策略
	 * @return
	 */
	protected Table2ModelStrategy getTable2ModelStrategy() {
		return Table2ModelStrategyFactory.createTable2ModelStrategy(
				generatorVo.getTable2ModelStrategyClassName(), generatorVo.getTableNameLeftTrimPrefix());
	}
	
	/**
	 * DB字段->实体属性命名策略
	 * @return
	 */
	protected Column2PropStrategy getColumn2PropStrategy() {
		return Column2PropStrategyFactory.createColumn2PropStrategy(
				generatorVo.getColumn2PropStrategyClassName());
	}
	
	// ---------------建造者模式：步骤(Start)--------------------------
	
	/**
	 * 初始化文件生成信息map
	 */
	public void initGeneratorInfoMap() {
		List<Table> tableList = generatorVo.getTableList();
		for (Table table : tableList) {
			generateInfoMap.put(table.getName(), new FreeMarkerUtil.GenerateInfo());
		}
	}
	
	/**
	 * 建造ModelMap
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	public <VoType extends BaseGeneratorVo, GenType extends CodeGenerator> void buildModelMap() {
		final Class<GenType> genTypeClz = (Class<GenType>) getClass();
		logger.info("buildModelMap#-> genTypeClz:{}", genTypeClz.getName());
		final Class<VoType> voTypeClz = (Class<VoType>) generatorVo.getClass();
		iterateBuildPart(new IterateBuildPartCallBack<VoType>() {
			@Override
			public void buildSinglePart(String tableName, GenerateInfo generateInfo, VoType generatorVo) {
				try {
					Method method = ReflectionUtil.getDeclareMethod(genTypeClz.cast(CodeGenerator.this), "getTemplateModelMaps");
					Map<String, Map<String, Object>> modelMaps = 
							(Map<String, Map<String, Object>>) method.invoke(genTypeClz.cast(CodeGenerator.this));
					Map<String, Object> modelMap = modelMaps.get(tableName);
					generateInfo.setModelMap(modelMap);
				} catch (Exception e) {
					logger.error(e.getMessage(), e);
				}
			}
		});
	}
	/**
	 * 建造模板根路径
	 */
	public abstract void buildFtlRoot();
	/**
	 * 建造模板文件名称
	 */
	public abstract void buildFtlFile();
	/**
	 * 建造生成的文件的基路径
	 */
	public abstract void buildTargetRoot();
	/**
	 * 建造生成的文件的名称
	 */
	public abstract void buildTargetFile();
	
	/**
	 * 循环建造部件
	 * @param callBack 循环建造部件回调
	 */
	@SuppressWarnings("unchecked")
	protected <T extends BaseGeneratorVo> void iterateBuildPart(IterateBuildPartCallBack<T> callBack) {
		//转化成具体的生成器vo
		T genVo = (T) generatorVo;
		Map<String, FreeMarkerUtil.GenerateInfo> generatorInfoMap = getGenerateInfoMap();
		List<Table> tableList = getGeneratorVo().getTableList();
		for (Table table : tableList) {
			FreeMarkerUtil.GenerateInfo generateInfo = generatorInfoMap.get(table.getName());
			callBack.buildSinglePart(table.getName(), generateInfo, genVo);
		}
	}
	
	/**
	 * 循环建造部件回调
	 * @author Neo
	 *
	 * @param <T> generatorVo的类型
	 */
	protected static interface IterateBuildPartCallBack<T> {
		/**
		 * 建造单一部件
		 * @param generateInfo 生成文件信息
		 * @param tableName 表名
		 * @param generatorVo 具体的生成器vo
		 */
		void buildSinglePart(String tableName, FreeMarkerUtil.GenerateInfo generateInfo, T generatorVo);
	}
	// ---------------建造者模式：步骤(End)--------------------------
	

	protected BaseGeneratorVo getGeneratorVo() {
		return generatorVo;
	}

	protected void setGeneratorVo(BaseGeneratorVo generatorVo) {
		this.generatorVo = generatorVo;
	}

	protected Map<String, FreeMarkerUtil.GenerateInfo> getGenerateInfoMap() {
		return generateInfoMap;
	}
}
