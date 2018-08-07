package org.pu.dept.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 工具类
 * @author dave
 *
 */
@SuppressWarnings("all")
public class ValueUtil {

	/**
	 * 判断是否为空
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isEmpty(Object value) {
		if (value == null) {
			return true;
		} else if (value instanceof String || value instanceof StringBuffer
				|| value instanceof Character) {
			return value.toString().trim().length() == 0;
		} else if (value instanceof Collection) {
			return ((Collection<?>) value).isEmpty();
		} else if (value instanceof Object[]) {
			return ((Object[]) value).length == 0;
		} else if (value instanceof Map) {
			return ((Map<?, ?>) value).isEmpty();
		}
		return false;
	}

	/**
	 * 将多个参数转换为List
	 * 
	 * @param value
	 * @return
	 */
	public static <T> List<T> toList(T... value) {
		if (isEmpty(value))
			return new ArrayList<T>(0);
		List<T> list = new ArrayList<T>(value.length);
		for (T v : value)
			list.add(v);
		return list;
	}

	/**
	 * 将多个参数转换成Set集合
	 * 
	 * @param value
	 * @return
	 */
	public static <T> Set<T> toSet(T... value) {
		if (isEmpty(value))
			return new HashSet<T>(0);
		Set<T> set = new HashSet<T>(value.length);
		for (T v : value)
			set.add(v);
		return set;
	}

	/**
	 * 将多个“键:值”形式的字符串转换为Map
	 * 
	 * @param keyValues
	 * @return
	 */
	public static Map<String, String> toMap(String... keyValues) {
		Map<String, String> map = new HashMap<String, String>();
		if (isEmpty(keyValues))
			return map;
		for (String keyValue : keyValues) {
			if (isEmpty(keyValue))
				continue;
			if (keyValue.contains(":")) {
				int index = keyValue.indexOf(":");
				String key = keyValue.substring(0, index).trim();
				String value = keyValue.substring(index + 1).trim();
				map.put(key, value);
			} else {
				map.put(keyValue, null);
			}
		}
		return map;
	}
}