package com.hundsun.hera.convert;

import com.hundsun.hera.exception.HeraException;

/**
 * 类名称：ObjectIntegerConverter
 * 类描述：Object to Integer
 * 创建人：fangchi
 * 创建时间：Nov 10, 2011 8:21:17 PM
 * @version 0.0.1
 * 修改人：
 * 修改时间：
 * 修改备注：fangchi modify 20111112去掉public关键字
 */
class ObjectIntegerConverter implements Converter<Object,Integer>{
	
	/**
	 * Object to Integer 实现
	 * @param m 要转化的类
	 * @param defultValue 默认值
	 * @param args 转换参数
	 */
	public Integer convert(Object object,Integer defultValue,Object... args) throws HeraException{
		if(object instanceof Double){
			return  new DoubleIntegerConverter().convert((Double)object, defultValue, args);
		} else if(object instanceof Long){
			return  new LongIntegerConverter().convert((Long)object, defultValue, args);
		} else {
			try{
				return Integer.valueOf(object.toString());
			}catch (Exception e) {
				if(defultValue!=null){
					return defultValue;
				}else{
					throw new HeraException("Object to Ingeger 转化错误 ："+e.getMessage() );
				}
			}
		}
	}
	
	public Class getFrom() {
		return Object.class;
	}

	public Class getTo() {
		return Integer.class;
	}

}
