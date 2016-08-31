package com.java.utils;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JsonUtil {
	/**
	 * 对象转json
	 * 
	 * @param obj
	 * @return
	 */
	public static String jsonFromObj(Object obj) {
		String json = JSONObject.toJSONString(obj);
		return json;
	}

	/**
	 * String 转json
	 * 
	 * @param value
	 * @return
	 */
	public static JSONObject jsonFromString(String value) {
		JSONObject json = JSON.parseObject(value);
		return json;
	}

	/**
	 * json转对象
	 * 
	 * @param json
	 * @param obj
	 * @return
	 */
	public static Object objFromJson(JSONObject json, Class<?> obj) {
		return JSON.toJavaObject(json, obj);
	}

	/**
	 * json转List<?>
	 * 
	 * @param value
	 * @param obj
	 * @return
	 */
	public static List<?> listobjFromJson(String value, Class<?> obj) {
		return JSON.parseArray(value, obj);
	}

	/**
	 * json转List
	 * 
	 * @param value
	 * @return
	 */
	public static List<?> listFromJson(String value) {
		return JSON.parseArray(value);
	}

	/**
	 * json转map
	 * 
	 * @param value
	 * @return
	 */
	public static Map<?, ?> mapFromJsonString(String value) {
		Map<?, ?> map = (Map<?, ?>) JSON.parse(value);
		return map;
	}

	/**
	 * json序列化
	 * 
	 * @param jsonText
	 * @return
	 */
	public static String toJSON(Object jsonText) {
		return JSON.toJSONString(jsonText, SerializerFeature.WriteDateUseDateFormat);
	}

	/**
	 * 含有时间的处理
	 * 
	 * @param jsonText
	 * @return
	 */
	public static String toJSONStringWithDateFormat(Object jsonText, String format) {
		return JSON.toJSONStringWithDateFormat(jsonText, format, SerializerFeature.WriteDateUseDateFormat);
	}
}
