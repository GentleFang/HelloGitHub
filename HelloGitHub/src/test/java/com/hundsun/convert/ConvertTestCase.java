/**
 * 日期：Nov 12, 2011
 * 创建人：fangchi
 */
package com.hundsun.convert;

import com.hundsun.hera.convert.Converters;
import com.hundsun.hera.exception.HeraException;

import junit.framework.TestCase;

/**
 * 类名称：ConvertTestCase 类描述：测试Convert类 
 * 创建人：fangchi 
 * 创建时间：Nov 12, 2011 3:15:10 PM
 * @version 0.0.1 修改人： 修改时间： 修改备注：
 */
public class ConvertTestCase extends TestCase {

	public final void testConvert() throws HeraException, Exception {

		assertEquals(
				new Long(1),
				Converters.getConverter(Double.class, Long.class).convert(
						new Double(1.2), new Long(1), new Object[0]));

		assertEquals(
				new Integer(2),
				Converters.getConverter(Double.class, Integer.class).convert(
						new Double(1.2), new Integer(1), true));
		assertEquals(
				new Integer(1),
				Converters.getConverter(Double.class, Integer.class).convert(
						null, new Integer(1), new Object[0]));

		assertEquals(
				new Long(1),
				Converters.getConverter(Integer.class, Long.class).convert(1,
						new Long(1), new Object[0]));
		assertEquals(
				new Double(1.0),
				Converters.getConverter(Integer.class, Double.class).convert(1,
						new Double(1.0), new Object[0]));

		assertEquals(
				new Double(1),
				Converters.getConverter(Long.class, Double.class).convert(
						new Long(1), new Double(1), new Object[0]));

		assertEquals(
				new Integer(1),
				Converters.getConverter(Long.class, Integer.class).convert(
						null, new Integer(1), new Object[0]));

		Object o = 1;
		assertEquals(
				new Integer(1),
				Converters.getConverter(Object.class, Integer.class).convert(o,
						new Integer(1), new Object[0]));

		assertEquals(
				new Long(1),
				Converters.getConverter(Object.class, Long.class).convert(o,
						new Long(1), new Object[0]));

		assertEquals(
				new Double(1.0),
				Converters.getConverter(Object.class, Double.class).convert(o,
						new Double(1.0), new Object[0]));
	}
}
