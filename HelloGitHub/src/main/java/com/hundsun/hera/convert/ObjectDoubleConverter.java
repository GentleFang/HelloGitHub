package com.hundsun.hera.convert;

import com.hundsun.hera.exception.HeraException;

/**
 * 类名称：ObjectDoubleConverter
 * 类描述：object to double
 * 创建人：fangchi
 * 创建时间：Nov 10, 2011 8:20:44 PM
 * @version  0.0.1
 * 修改人：
 * 修改时间：
 * 修改备注：fangchi modify 20111112去掉public关键字 
 */
class ObjectDoubleConverter implements Converter<Object,Double>{

	/**
	 * Object to Double 实现
	 * @param m 要转化的类
	 * @param defultValue 默认值
	 * @param args 转换参数
	 */
	public Double convert(Object object,Double defultValue,Object... args) throws HeraException{
		if(object instanceof Integer){
			return  new IntegerDoubleConverter().convert((Integer)object, defultValue, args);
		} else if(object instanceof Long){
			return  new LongDoubleConverter().convert((Long)object, defultValue, args);
		} else {
			try{
				return Double.valueOf(object.toString());
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
		return Double.class;
	}

}
