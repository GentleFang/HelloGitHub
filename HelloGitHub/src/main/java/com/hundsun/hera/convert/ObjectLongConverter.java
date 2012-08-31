package com.hundsun.hera.convert;

import com.hundsun.hera.exception.HeraException;

/**
 * 类名称：ObjectLongConverter
 * 类描述：Object to long
 * 创建人：fangchi
 * 创建时间：Nov 10, 2011 8:21:40 PM
 * @version 
 * 修改人：
 * 修改时间：
 * 修改备注：fangchi modify 20111112去掉public关键字
 */
class ObjectLongConverter implements Converter<Object,Long>{
	
	/**
	 * Object to Long 实现
	 * @param m 要转化的类
	 * @param defultValue 默认值
	 * @param args 转换参数
	 * @throws HeraException 
	 */
	public Long convert(Object object,Long defultValue,Object... args) throws HeraException{
		if(object instanceof Double){
			return  new DoubleLongConverter().convert((Double)object, defultValue, args);
		} else if(object instanceof Integer){
			return  new IntegerLongConverter().convert((Integer)object, defultValue, args);
		} else {
			try{
				return Long.valueOf(object.toString());
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
		return Long.class;
	}

}
