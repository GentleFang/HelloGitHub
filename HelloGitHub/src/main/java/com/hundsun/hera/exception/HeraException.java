/**
  * 名称：Hera
  * 日期：Nov 12, 2011
  * 创建人：fangchi
  */
package com.hundsun.hera.exception;

/**
 * 类名称：Hera
 * 类描述：Hera 异常类
 * 创建人：fangchi
 * 创建时间：Nov 12, 2011 1:24:48 PM
 * @version 0.0.1
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
public class HeraException extends Exception {

	public HeraException() {
		super();
	}

	public HeraException(String message, Throwable cause) {
		super(message, cause);
	}

	public HeraException(String message) {
		super(message);
	}

	public HeraException(Throwable cause) {
		super(cause);
	}
	
}
