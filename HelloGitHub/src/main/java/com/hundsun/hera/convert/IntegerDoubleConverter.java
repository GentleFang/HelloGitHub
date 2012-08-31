/**
  * 名称：Hera
  * 日期：Nov 12, 2011
  * 创建人：fangchi
  */

package com.hundsun.hera.convert;

import com.hundsun.hera.exception.HeraException;

/**
 * 类名称：IntegerDoubleConverter
 * 类描述：Integer to Double
 * 创建人：fangchi
 * 创建时间：Nov 12, 2011 3:11:50 PM
 * @version 
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class IntegerDoubleConverter implements Converter<Integer, Double> {

	@Override
	public Class getFrom() {
		return Integer.class;
	}

	@Override
	public Class getTo() {
		return Double.class;
	}

	/**
	 * Integer to Long 实现
	 * @param m 要转化的类
	 * @param defultValue 默认值
	 * @param args 转换参数
	 */
	public Double convert(Integer m,Double defultValue, Object... args) throws HeraException {
		try {
			Double  result=m.doubleValue();
			return result;
		} catch (Exception e) {
			if(defultValue != null){
				return defultValue;
			}else{
				throw new HeraException("Integer to Double 转化错误 ："+e.getMessage() );
			}
		}
	}

}
