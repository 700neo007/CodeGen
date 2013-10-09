package com.cg.codegen.component.generator;

import java.io.File;

import org.apache.commons.lang3.StringUtils;

public class GeneratorUtil {
	
	private static GeneratorUtil _instance = new GeneratorUtil();
	
	private GeneratorUtil() {}
	
	public static GeneratorUtil getInstance() {
		return _instance;
	}

	/**
	 * 通过报名获取路径,com.cg.model -> com/cg/model 或 com\cg\model
	 * @param packageName
	 * @return
	 */
	public static String getPathByPackage(String packageName) {
		String[] pkgFragment = packageName.split("\\.");
		return StringUtils.join(pkgFragment, File.separator);
	}
	
	/**
	 * 把单词首字母转成大写
	 * @param word
	 * @return
	 */
	public static String convertFirtLetter2Upper(String word) {
		return (word.charAt(0) + "").toUpperCase() + word.substring(1);
	}
	
	/**
	 * 下划线命名->Camel命名，如：last_update_time -> lastUpdateTime
	 * @return
	 */
	public static String underline2CamelNaming(String source) {
		String[] words = source.split("_");
		if (words.length == 1) {
			return source;
		}
		String word = null;
		for (int i = 1, len = words.length; i < len; i++) {
			word = convertFirtLetter2Upper(words[i]);
			words[i] = word;
		}
		return StringUtils.join(words);
	}
	
	/**
	 * 下划线命名->Pascal命名，如：last_update_time -> LastUpdateTime
	 * @param source
	 * @return
	 */
	public static String underline2PascalNaming(String source) {
		String[] words = source.split("_");
		String word = null;
		for (int i = 0, len = words.length; i < len; i++) {
			word = GeneratorUtil.convertFirtLetter2Upper(words[i]);
			words[i] = word;
		}
		return StringUtils.join(words);
	}
	
	public static void main(String[] args) {
//		System.out.println(underline2PascalNaming("last_update_time"));
		
//		System.out.println(underline2CamelNaming("last_update_time"));
		
//		System.out.println(convertFirtLetter2Upper("commodity"));
		
//		System.out.println(getPathByPackage("com.cg.model"));
		
	}

	
}
