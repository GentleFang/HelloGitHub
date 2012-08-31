/**
  * 名称：Hera
  * 日期：Nov 12, 2011
  * 创建人：fangchi
  */

package com.hundsun.hera.convert;

import com.hundsun.hera.exception.HeraException;

/**
 * 类名称：DoubleIntegerConverter
 * 类描述：Double to Integer
 * 创建人：fangchi
 * 创建时间：Nov 12, 2011 3:11:50 PM
 * @version 
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class DoubleIntegerConverter extends AbstractNumberConverter<Double, Integer> {

	@Override
	public Class getFrom() {
		return Double.class;
	}

	@Override
	public Class getTo() {
		return Integer.class;
	}

	/**
	 * Double to Long 实现
	 * @param m 要转化的类
	 * @param defultValue 默认值
	 * @param args 转换参数
	 */
	private Integer convertDetail(Double m,Integer defultValue) throws HeraException {
		try {
			Integer  result=m.intValue();
			return result;
		} catch (Exception e) {
			if(defultValue != null){
				return defultValue;
			}else{
				throw new HeraException("Double to Integer 转化错误 ："+e.getMessage() );
			}
		}
	}

	  
	@Override
	public Integer convertNumber(Double m, Integer defaultValue)
			throws HeraException {
		return convertDetail(m,defaultValue);
	}

	@Override
	public Integer convertNumber(Double m, Integer defaultValue,
			boolean createDemical) throws HeraException {
		if(createDemical)
			return convertDetail(m,defaultValue)+1;
		else{
			return convertDetail(m,defaultValue);
		}
	}

}
