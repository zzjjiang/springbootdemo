package com.jone.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 对象转换工具
 */
public class FastUtils {
	/**
	 * conver:单个对象类型装换. 按照字段属性命名映射值
	 */
	public static <T> T convert(Object obj, Class<T> clazz) {
		if (obj != null) {
			return JSON.parseObject(JSON.toJSONString(obj), clazz);
		}
		return null;
	}

	/**
	 * conver:List对象类型转换. 按照字段属性命名映射值.
	 */
	public static <T> List<T> convert(Collection<?> list, Class<T> clas) {
		if (list != null) {
			return JSON.parseArray(JSON.toJSONString(list), clas);
		}
		return null;
	}

	/**
	 * 对象转map
	 */
	public static Map<String, Object> toMap(Object obj) {
		if (obj != null) {
			return JSON.parseObject(JSON.toJSONString(obj));
		}
		return null;
	}

	/**
	 * map转对象
	 */
	public static <T> T convert(Map<String, Object> map, Class<T> clazz) {
		return new JSONObject(map).toJavaObject(clazz);
	}

}
