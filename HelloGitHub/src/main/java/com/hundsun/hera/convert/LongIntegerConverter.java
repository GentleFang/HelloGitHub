/**
  * 名称：Hera
  * 日期：Nov 12, 2011
  * 创建人：fangchi
  */

package com.hundsun.hera.convert;

import com.hundsun.hera.exception.HeraException;

/**
 * 类名称：LongIntegerConverter
 * 类描述：Long to Integer
 * 创建人：fangchi
 * 创建时间：Nov 12, 2011 3:11:50 PM
 * @version 0.0.1
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class LongIntegerConverter implements Converter<Long,Integer> {

	@Override
	public Class getFrom() {
		return Long.class;
	}

	@Override
	public Class getTo() {
		return Integer.class;
	}

	/**
	 * Long to Integer 实现
	 * @param m 要转化的类
	 * @param defultValue 默认值
	 * @param args 转换参数
	 */
	public Integer convert(Long m,Integer defultValue, Object... args) throws HeraException {
		try {
			Integer  result=m.intValue();
			return result;
		} catch (Exception e) {
			if(defultValue != null){
				return defultValue;
			}else{
				throw new HeraException("Long to Ingeger 转化错误 ："+e.getMessage() );
			}
		}
	}

}
