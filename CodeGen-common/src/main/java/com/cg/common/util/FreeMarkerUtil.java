package com.cg.common.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.cg.common.constant.CommonConstant;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreeMarkerUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(FreeMarkerUtil.class);

	/**
	 * 生成文件
	 * @param generateInfo 生成文件所需信息
	 */
	public static void generateFile(GenerateInfo generateInfo) {
		String prefix = "generateFile#-> ";
		Writer out = null;
		try {
			FreeMarkerConfigurer configurer = SpringContextUtil.getBean("templateConfig");
			Configuration cfg = configurer.getConfiguration();
			cfg.setDirectoryForTemplateLoading(new File(generateInfo.getPathInfo().getFtlRoot()));
			Template template = cfg.getTemplate(generateInfo.getPathInfo().getFtlFile());
			out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(generateInfo.getPathInfo().getTargetRoot() + File.separator + generateInfo.getPathInfo().getTargetFile()), CommonConstant.ENCODING), 4000);
			template.process(generateInfo.getModelMap(), out);
			logger.info("{}generate success-> ftlRoot:{}, ftlFile:{}, targetRoot:{}, targetFile:{}", 
					prefix, generateInfo.getPathInfo().getFtlRoot(), generateInfo.getPathInfo().getFtlFile(),
					generateInfo.getPathInfo().getTargetRoot(), generateInfo.getPathInfo().getTargetFile());
			logger.info("{}generate success-> modelMap:{}", prefix, JsonUtil.toJson(generateInfo.getModelMap()));
			logger.info("{}---------------------------------", prefix);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			if (out != null) {
				try {
					out.flush();
					out.close();
				} catch (IOException e) {
					logger.error(e.getMessage(), e);
				}
			}
		}
	}
	
	/**
	 * 批量生成文件
	 * @param generateInfoList 文件生成信息list
	 */
	public static void generateFiles(List<GenerateInfo> generateInfoList) {
		for (GenerateInfo generateInfo : generateInfoList) {
			generateFile(generateInfo);
		}
	}
	
	/**
	 * 文件生成信息
	 * @author Neo
	 *
	 */
	public static class GenerateInfo {
		
		/**
		 * 数据模型
		 */
		private Map<String, Object> modelMap; 
		/**
		 * 路径信息
		 */
		private GeneratePathInfo pathInfo = new GeneratePathInfo();

		public Map<String, Object> getModelMap() {
			return modelMap;
		}

		public void setModelMap(Map<String, Object> modelMap) {
			this.modelMap = modelMap;
		}

		public GeneratePathInfo getPathInfo() {
			return pathInfo;
		}

		public void setPathInfo(GeneratePathInfo pathInfo) {
			this.pathInfo = pathInfo;
		}
		
	}
	
	/**
	 * 生成文件路径信息
	 * @author Neo
	 *
	 */
	public static class GeneratePathInfo {
		
		/**
		 * 模板基路径
		 */
		private String ftlRoot; 
		/**
		 * 模板文件路径
		 */
		private String ftlFile; 
		/**
		 * 生成的文件基路径
		 */
		private String targetRoot; 
		/**
		 * 生成的文件路径
		 */
		private String targetFile;
		
		public String getFtlRoot() {
			return ftlRoot;
		}
		public void setFtlRoot(String ftlRoot) {
			this.ftlRoot = ftlRoot;
		}
		public String getFtlFile() {
			return ftlFile;
		}
		public void setFtlFile(String ftlFile) {
			this.ftlFile = ftlFile;
		}
		public String getTargetRoot() {
			return targetRoot;
		}
		public void setTargetRoot(String targetRoot) {
			this.targetRoot = targetRoot;
		}
		public String getTargetFile() {
			return targetFile;
		}
		public void setTargetFile(String targetFile) {
			this.targetFile = targetFile;
		}
		
	}
	
}
