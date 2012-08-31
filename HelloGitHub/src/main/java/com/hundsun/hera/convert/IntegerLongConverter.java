/**
  * 名称：Hera
  * 日期：Nov 12, 2011
  * 创建人：fangchi
  */

package com.hundsun.hera.convert;

import com.hundsun.hera.exception.HeraException;

/**
 * 类名称：IntegerLongConverter
 * 类描述：Integer to Long
 * 创建人：fangchi
 * 创建时间：Nov 12, 2011 3:11:50 PM
 * @version 
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class IntegerLongConverter implements Converter<Integer, Long> {

	@Override
	public Class getFrom() {
		return Integer.class;
	}

	@Override
	public Class getTo() {
		return Long.class;
	}

	/**
	 * Integer to Long 实现
	 * @param m 要转化的类
	 * @param defultValue 默认值
	 * @param args 转换参数
	 */
	public Long convert(Integer m,Long defultValue, Object... args) throws HeraException {
		try {
			Long  result=m.longValue();
			return result;
		} catch (Exception e) {
			if(defultValue != null){
				return defultValue;
			}else{
				throw new HeraException("Integer to Long 转化错误 ："+e.getMessage() );
			}
		}
	}

}
