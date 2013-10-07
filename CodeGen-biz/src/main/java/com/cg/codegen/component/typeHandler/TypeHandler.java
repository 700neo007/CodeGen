package com.cg.codegen.component.typeHandler;

/**
 * 类型处理器
 * @author Neo
 *
 */
public abstract class TypeHandler {

	/**
	 * 类型信息
	 * @author Neo
	 *
	 */
	public static class TypeInfo {
		
		/**
		 * 类型描述
		 */
		private String typeDesc;
		/**
		 * 类型
		 */
		private String type;
		/**
		 * 长度
		 */
		private Integer length;
		/**
		 * 精度
		 */
		private Integer precision;
		
		
		public String getTypeDesc() {
			return typeDesc;
		}
		public void setTypeDesc(String typeDesc) {
			this.typeDesc = typeDesc;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public Integer getLength() {
			return length;
		}
		public void setLength(Integer length) {
			this.length = length;
		}
		public Integer getPrecision() {
			return precision;
		}
		public void setPrecision(Integer precision) {
			this.precision = precision;
		}
		
		
	}
	
}
