/**
  * 名称：Hera
  * 日期：Nov 12, 2011
  * 创建人：fangchi
  */

package com.hundsun.hera.convert;

import com.hundsun.hera.exception.HeraException;

/**
 * 类名称：AbstractNumberConverter
 * 类描述：数字装换抽象类 细精度转粗精度
 * 创建人：fangchi
 * 创建时间：Nov 12, 2011 5:06:20 PM
 * @version 
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
public abstract class AbstractNumberConverter<FROM, TO> implements Converter<FROM, TO> {

	/**
	 * 转化方法
	 * @param m 要转换的类
	 * @param defaultValue 默认值
	 * @param args arg[0] true 增加1 如 1.2->integer 为2 false  1.2->integer 为1
	 * @return 转化的类
	 * @since 0.0.1
	 */
	public TO convert(FROM m,TO defaultValue,Object... args) throws HeraException{
		try {
			if(args.length == 0){
				return convertNumber(m,defaultValue);
			} else if(args.length == 1){
				return convertNumber(m,defaultValue,Boolean.valueOf(args[0].toString()));
			} else {
				throw new HeraException("未找到匹配的参数");
			}
		} catch (Exception e) {
			if(defaultValue != null){
				return defaultValue;
			}else{
				throw new HeraException("转换失败:"+e.getMessage());
			}
		}
		
	}
	
	public abstract TO convertNumber(FROM m,TO defaultValue) throws HeraException;
	
	
	public abstract TO convertNumber(FROM m,TO defaultValue,boolean createDemical) throws HeraException;
}
