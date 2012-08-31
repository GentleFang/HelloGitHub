package com.hundsun.hera.convert;

import java.util.HashMap;
import java.util.Map;

/**
 * 类名称：Converters
 * 类描述：转化容器 对外提供统一的转化接口
 * 创建人：fangchi
 * 创建时间：Nov 10, 2011 8:19:59 PM
 * @version  0.0.1
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
public final class Converters {
    
    private static final Map<String, Converter<?,?>> converters = new HashMap<String,Converter<?,?>>();
    
    static{
        register(new DoubleLongConverter());
        register(new DoubleIntegerConverter());
        register(new IntegerLongConverter());
        register(new IntegerDoubleConverter());
        register(new LongDoubleConverter());
        register(new LongIntegerConverter());
        register(new ObjectIntegerConverter());
        register(new ObjectDoubleConverter());
        register(new ObjectLongConverter());
    }
    
    /**
     * 注册
     * @param converter 要注册的转化器
     */
    public static void register(Converter<?,?> converter){
        converters.put(converter.getFrom().toString()+"-"+converter.getTo().toString(), converter);
    }

    @SuppressWarnings("unchecked")
    /**
     * 功能描述：获取转化器
     * @param <T> 元类
     * @param <M> 目标类
     * @param clazz 
     * @param clazz2
     * @return 对应的转化器
     * @throws Exception 未找到
     */
    public static <T,M> Converter<T,M> getConverter(Class<T> clazz,Class<M> clazz2) throws Exception{
    	Converter<T,M> m =  (Converter<T,M>)converters.get(clazz.toString()+"-"+clazz2.toString());
    	if(m == null){
    		throw new Exception("未实现Class"+clazz+"至Class"+clazz2+"的转换");
    	}
    	return m;
    }
}
