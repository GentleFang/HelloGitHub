package com.hundsun.convert;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hundsun.hera.convert.Converters;

public class ConvertersTest {

	// Double类转化成Integer类，进位
	@Test
	public void convert1() throws Exception {
		assertEquals(
				new Integer(2),
				Converters.getConverter(Double.class, Integer.class).convert(
						new Double(1.2), new Integer(1), true));
	}

	// Double类转化成Integer类，不进位
	@Test
	public void convert2() throws Exception {
		assertEquals(
				new Integer(1),
				Converters.getConverter(Double.class, Integer.class).convert(
						new Double(1.2), new Integer(1), false));
	}

	// Double类转化成Integer类，第三个参数为长度为1的integer值
	@Test
	public void convert3() throws Exception {
		assertEquals(
				new Integer(10),
				Converters.getConverter(Double.class, Integer.class).convert(
						new Double(10.2), new Integer(1), new Integer(1)));
	}

	// Double类转化成Integer类，第三个参数为空
	@Test
	public void convert04() throws Exception {
		assertEquals(
				new Integer(10),
				Converters.getConverter(Double.class, Integer.class).convert(
						new Double(10.2), new Integer(1)));
	}

	// Double类转化成Integer类，第三个参数为null(返回默认值)
	@Test
	public void convert05() throws Exception {
		assertEquals(
				new Integer(1),
				Converters.getConverter(Double.class, Integer.class).convert(
						new Double(10.2), new Integer(1), null));
	}

	// Double类转化成Integer类，第二个参数为null(没有抛出异常)
	@Test
	public void convert6() throws Exception {
		assertEquals(
				new Integer(10),
				Converters.getConverter(Double.class, Integer.class).convert(
						new Double(10.2), null));
	}

	// Double类转化成Integer类，第一，二个参数为null(抛出异常,转化错误)
	@Test
	public void convert7() throws Exception {
		try {
			assertEquals(new Integer(10),
					Converters.getConverter(Double.class, Integer.class)
							.convert(null, null));
		} catch (Exception e) {
			assertTrue(true);
			return;
		}
		assertTrue(false);
	}

	// Double类转化成Integer类，第一个参数为null,采用默认值(没有抛出异常)
	@Test
	public void convert8() throws Exception {
		assertEquals(
				new Integer(10),
				Converters.getConverter(Double.class, Integer.class).convert(
						null, new Integer(10)));
	}

	// Object类转化成Integer类，进位
	@Test
	public void convert9() throws Exception {
		assertEquals(
				new Integer(2),
				Converters.getConverter(Object.class, Integer.class).convert(
						new Double(1.2), new Integer(1), true));
	}

	// Integer类转化成Double类，不进位
	@Test
	public void convert10() throws Exception {
		assertEquals(
				new Double(1.0),
				Converters.getConverter(Integer.class, Double.class).convert(
						new Integer(1), new Double(11.0), false));
	}

	// Integer类转化成Double类，第三个参数为长度为1的integer值
	@Test
	public void convert11() throws Exception {
		assertEquals(
				new Double(10),
				Converters.getConverter(Integer.class, Double.class).convert(
						new Integer(10), new Double(1), new Integer(1)));
	}

	// Integer类转化成Double类，第三个参数为空
	@Test
	public void convert12() throws Exception {
		assertEquals(
				new Double(10),
				Converters.getConverter(Integer.class, Double.class).convert(
						new Integer(10), new Double(1)));
	}

	// Integer类转化成Double类，第三个参数为null(抛出异常)
	@Test
	public void convert13() throws Exception {
		assertEquals(
				new Double(10),
				Converters.getConverter(Integer.class, Double.class).convert(
						new Integer(10), new Double(1), null));
	}

	// Integer类转化成Double类，第二个参数为null(没有抛出异常)
	@Test
	public void convert14() throws Exception {
		assertEquals(
				new Double(10),
				Converters.getConverter(Integer.class, Double.class).convert(
						new Integer(10), null));
	}

	// Integer类转化成Double类，第一，二个参数为null(抛出异常,转化错误)
	@Test
	public void convert15() throws Exception {
		try {
			assertEquals(new Double(10),
					Converters.getConverter(Integer.class, Double.class)
							.convert(null, null));
		} catch (Exception e) {
			assertTrue(true);
			return;
		}
		assertTrue(false);
	}

	// Integer类转化成Double类，第一个参数为null,采用默认值(没有抛出异常)
	@Test
	public void convert16() throws Exception {
		assertEquals(
				new Double(1.0),
				Converters.getConverter(Integer.class, Double.class).convert(
						null, new Double(1.0)));
	}

	@Test
	public void convert17() throws Exception {

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
