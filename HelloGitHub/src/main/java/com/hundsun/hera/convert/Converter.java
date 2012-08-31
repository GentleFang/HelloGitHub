package com.hundsun.hera.convert;

import com.hundsun.hera.exception.HeraException;

/**
 * 项目名称：Hera
 * 类名称：Converter
 * 类描述：转化接口
 * 创建人：fangchi
 * 创建时间：Nov 5, 2011 3:10:03 PM
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version 0.0.1
 */
public interface Converter<FROM,TO>{
	
	/**
	 * 获取要转化的类
	 * @return 要转化的类
	 * @since 0.0.1
	 */
	Class getFrom();
	
	/**
	 * 获取转化的类 
	 * @return  转化的类 
	 * @since 0.0.1
	 */
	Class getTo();
	
	/**
	 * 转化方法
	 * @param m 要转换的类
	 * @param defaultValue 默认值
	 * @param args 转化参数  为 默认转化值
	 * @return 转化的类
	 * @since 0.0.1
	 */
	TO convert(FROM m,TO defaultValue,Object... args) throws HeraException;
}
