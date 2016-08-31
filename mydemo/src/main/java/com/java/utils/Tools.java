package com.java.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

public class Tools {

	/**
	 * 一年的毫秒数
	 */
	public static final long YEAR_MILLIS = 31104000000L;

	/**
	 * 一月的毫秒数，30天。
	 */
	public static final long MONTH_MILLIS = 2592000000L;

	/**
	 * 一周的毫秒数
	 */
	public static final long WEEK_MILLIS = 604800000L;

	/**
	 * 一天的毫秒数
	 */
	public static final long DAY_MILLIS = 86400000L;

	/**
	 * 一小时的毫秒数
	 */
	public static final long HOUR_MILLIS = 3600000L;

	/**
	 * 一分钟的毫秒数
	 */
	public static final long MINUTE_MILLIS = 60000L;

	/**
	 * 一秒的毫秒数
	 */
	public static final long SECOND_MILLIS = 1000L;

	/**
	 * DateFormat的本地变量Map
	 */
	private static ThreadLocal<Map<String, DateFormat>> DATA_MAP_LOCAL = new ThreadLocal<Map<String, DateFormat>>();

	/**
	 * NumberFormat的本地变量Map
	 */
	private static ThreadLocal<Map<String, NumberFormat>> NUMBER_MAP_LOCAL = new ThreadLocal<Map<String, NumberFormat>>();

	/**
	 * 获取DataFormat
	 * 
	 * @param format
	 *            - String
	 * @return DateFormat
	 */
	private static DateFormat getDataFormat(String format) {
		Map<String, DateFormat> map = DATA_MAP_LOCAL.get();
		if (map == null) {
			map = new HashMap<String, DateFormat>();
			DATA_MAP_LOCAL.set(map);
		}

		DateFormat fmt = map.get(format);
		if (fmt == null) {
			fmt = new SimpleDateFormat(format);
			map.put(format, fmt);
		}

		return fmt;
	}

	/**
	 * 当前时间往前推多少小时
	 * @param hourcount  前推小时数
	 * @return
	 */
	public static String getHoursAgoTime(int hourcount) {
		String oneHoursAgoTime = "";
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR, Calendar.HOUR - hourcount); // 把时间设置为当前时间-1小时，同理，也可以设置其他时间
		oneHoursAgoTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(cal.getTime());// 获取到完整的时间
		return oneHoursAgoTime;
	}

	/**
	 * 获取DateFormat，格式化时间为：yyyy-MM-dd
	 * 
	 * @return DateFormat
	 */
	public static DateFormat getDateFormat() {
		return getDataFormat("yyyy-MM-dd");
	}

	/**
	 * 获取DateFormat，格式化时间为：yyyy-MM-dd HH:mm:ss
	 * 
	 * @return DateFormat
	 */
	public static DateFormat getDateTimeFormat() {
		return getDataFormat("yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 获得当前的一个格式化的时间，格式为：yyyy-MM-dd HH:mm:ss
	 * 
	 * @return String
	 */
	public static String getCurrentDate() {
		return getDateFormat().format(new Date());
	}

	/**
	 * 获得当前的一个格式化的时间
	 * 
	 * @param format
	 *            - 格式化字符串
	 * @return String
	 */
	public static String getCurrentDate(String format) {
		SimpleDateFormat sf = new SimpleDateFormat(format);
		return sf.format(new Date());
	}

	public static Date getBeforeDate(int count) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate = new Date();
		Calendar date = Calendar.getInstance();
		date.setTime(beginDate);
		date.set(Calendar.DATE, date.get(Calendar.DATE) - count);
		Date endDate = new Date();
		try {
			endDate = dft.parse(dft.format(date.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return endDate;
	}

	/**
	 * 格式化日期yyyy-MM-dd，返回Date
	 * 
	 * @return long
	 */
	public static Date getDate(String date) {
		if (Tools.isNull(date))
			return null;
		try {
			return getDateFormat().parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获得今天得日期 2011-12-12
	 * 
	 * @return String
	 */
	public static String getDate() {
		return getDateFormat().format(new Date());
	}

	/**
	 * 获得今天得日期 2011-12-12
	 * 
	 * @param time
	 *            - 毫秒
	 * @return String
	 */
	public static String getDate(long time) {
		return getDateFormat().format(new Date(time));
	}

	/**
	 * 获得今天得日期 2011-12-12
	 * 
	 * @param date
	 *            - 日期
	 * @return String
	 */
	public static String getDate(Date date) {
		if (date == null)
			return "";
		return getDateFormat().format(date);
	}

	/**
	 * 将时间的STRING格式化一下
	 * 
	 * @param date
	 * @param format1
	 * @param format2
	 * @return
	 */
	public static String getFormatString(String date, String format1,
			String format2) {
		long ss = getDateTimeMillis(date, format1);
		return getFormatDate(ss, format2);
	}

	/**
	 * 获取一个格式化的时间
	 * 
	 * @param time
	 *            long
	 * @param format
	 *            格式化字符串
	 * @return String
	 */
	public static String getFormatDate(long time, String format) {
		SimpleDateFormat sf = new SimpleDateFormat(format);
		Date date = new Date(time);
		return sf.format(date);
	}

	/**
	 * 时间格式化，格式：2011-11-11 11:11:11
	 * 
	 * @param time
	 *            - 时间
	 * @return String
	 */
	public static String getDateTime() {
		return getDateTime(new Date());
	}

	/**
	 * 时间格式化
	 * 
	 * @param time
	 *            - 时间
	 * @return String
	 */
	public static String getDateTime(long time) {
		return getDateTimeFormat().format(new Date(time));
	}

	/**
	 * 时间格式化
	 * 
	 * @param date
	 *            - 时间对象
	 * @return String
	 */
	public static String getDateTime(Date date) {
		if (date == null)
			return "";
		return getDateTimeFormat().format(date);
	}

	/**
	 * 格式化日期 yyyy-MM-dd HH:mm:ss，返回Date
	 * 
	 * @return long
	 */
	public static Date getDateTime(String date) {
		if (Tools.isNull(date))
			return null;
		try {
			return getDateTimeFormat().parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 逆向解析一个时间，返回一个long型的时间
	 * 
	 * @param date
	 *            - 字符型时间
	 * @param format
	 *            - 格式化时间
	 * @return long 型时间
	 */
	public static long getDateTimeMillis(String date, String format) {
		SimpleDateFormat sf = new SimpleDateFormat(format);
		try {
			return sf.parse(date).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	 
	
	/**
	 * 获得当前日期与本周一相差的天数
	 * 
	 * @return int
	 */
	private static int getMondayPlus() {
		Calendar cd = Calendar.getInstance();
		// 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
		int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == 1) {
			return 6;
		} else {
			return dayOfWeek - 2;
		}
	}

	/**
	 * 获得上周星期一的日期时间,返回long
	 * 
	 * @return long
	 */
	public static long getPreviousMonday() {
		int mondayPlus = getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, -(mondayPlus + 7));
		currentDate.set(Calendar.MINUTE, 0);
		currentDate.set(Calendar.SECOND, 0);
		currentDate.set(Calendar.MILLISECOND, 0);
		currentDate.set(Calendar.HOUR_OF_DAY, 0);
		return currentDate.getTimeInMillis();
	}

	/**
	 * 获得本周星期一的时间,返回long
	 * 
	 * @return long
	 */
	public static long getCurrnetMonday() {
		int mondayPlus = getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, -mondayPlus);
		currentDate.set(Calendar.MINUTE, 0);
		currentDate.set(Calendar.SECOND, 0);
		currentDate.set(Calendar.MILLISECOND, 0);
		currentDate.set(Calendar.HOUR_OF_DAY, 0);
		return currentDate.getTimeInMillis();
	}

	/**
	 * 得到今天前几天的凌晨的时间
	 * 
	 * @param dayBefore
	 *            - 几天前
	 * @return long - dayBefore天前凌晨的时间。
	 */
	public static long getDayTime(long dayBefore) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(System.currentTimeMillis() - dayBefore * 24 * 60
				* 60 * 1000);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		return cal.getTimeInMillis();
	}

	/**
	 * 得到指定日期的凌晨的时间
	 * 
	 * @param date
	 *            - Date
	 * @return long
	 */
	public static long getDayTime(Date date) {
		if (date == null)
			throw new NullPointerException();

		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date.getTime());
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		return cal.getTimeInMillis();
	}

	/**
	 * 获得当前V小时的毫秒数
	 * 
	 * @param v
	 *            - 当前几小时，可以为负数
	 * @return long - 当前V小时的毫秒数
	 */
	public static long getHourTime(long v) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(System.currentTimeMillis() + v * Tools.HOUR_MILLIS);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTimeInMillis();
	}

	/**
	 * 匹配字符
	 * 
	 * @param regex
	 *            - 通配符
	 * @param str
	 *            - 需要验证的字符
	 * @return boolean 布尔值
	 */
	public static boolean matches(String regex, String str) {
		if (str == null)
			return false;
		return Pattern.matches(regex, str);
	}

	/**
	 * 查看某字符是否在数组中
	 * 
	 * @param array
	 *            - 数组
	 * @param str
	 *            - 字符串
	 * @return - Ture or False
	 */
	public static boolean isInArray(String[] array, String str) {
		if (Tools.isNull(str))
			return false;
		if (array == null || array.length == 0)
			return false;
		for (String s : array) {
			if (s.equals(str))
				return true;
		}
		return false;
	}

	/**
	 * 四舍五入返回一个小数
	 * 
	 * @param d
	 *            - 要格式化的数字
	 * @param scale
	 *            - 返回小数的位数
	 * @return double
	 */
	public static double getDouble(double d, int scale) {
		BigDecimal bd = new BigDecimal(d);
		return bd.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 四舍五入返回一个小数
	 * 
	 * @param f
	 *            - 要格式化的数字
	 * @param scale
	 *            - 返回小数的位数
	 * @return float
	 */
	public static float getFloat(float f, int scale) {
		BigDecimal bd = new BigDecimal(f);
		return bd.setScale(scale, BigDecimal.ROUND_HALF_UP).floatValue();
	}

	/**
	 * 四舍五入返回一个小数
	 * 
	 * @param f
	 * @param scale
	 * @return
	 */
	public static float getFloat(Float f, int scale) {
		if (f == null)
			return getFloat(0f, scale);
		BigDecimal bd = new BigDecimal(f.floatValue());
		return bd.setScale(scale, BigDecimal.ROUND_HALF_UP).floatValue();
	}

	/**
	 * 字符串不能为空
	 * 
	 * @param str
	 *            - 字符串
	 * @param defaultStr
	 *            - 字符串为空显示的字符
	 * @return 不为空的字符串
	 */
	public static String formatString(String str, String defaultStr) {
		if (str == null)
			return defaultStr;
		return str;
	}

	/**
	 * 字符串不能为空
	 * 
	 * @param str
	 *            - 字符串
	 * @return 不为空的字符串
	 */
	public static String formatString(String str) {
		if (str == null)
			return "";
		return str;
	}

	/**
	 * 转换成大小
	 * 
	 * @param str
	 *            - 字符串
	 * @return 不为空的字符串
	 */
	public static String toUpperCase(String str) {
		return str == null ? "" : str.toUpperCase();
	}

	/**
	 * 转换成小写
	 * 
	 * @param str
	 *            - 字符串
	 * @return 不为空的字符串
	 */
	public static String toLowerCase(String str) {
		return str == null ? "" : str.toLowerCase();
	}

	/**
	 * 如果字符串存在，则将c拼接并返回，否则返回空字串
	 * 
	 * @param s
	 *            - 字符串
	 * @param c
	 *            - 要拼接的字符串
	 * @return String
	 */
	public static String concatString(String str, String c) {
		if (isNull(str))
			return "";
		return str + c;
	}

	/**
	 * 返回一个字符串是否为空，如果字符串为""也为true
	 * 
	 * @param str
	 *            - String
	 * @return true false
	 */
	public static boolean isNull(String str) {
		if (str == null || str.length() == 0)
			return true;
		return false;
	}

	/**
	 * 返回一个字符串是否为空，如果字符串为""也为true，空格也为true
	 * 
	 * @param str
	 *            - String
	 * @return true false
	 */
	public static boolean isTrimNull(String str) {
		if (str == null || str.trim().length() == 0)
			return true;
		return false;
	}

	/**
	 * 返回一个字符串是否不为空
	 * 
	 * @param str
	 *            - String
	 * @return True or False
	 */
	public static boolean isNotNull(String str) {
		if (str == null || str.length() == 0)
			return false;
		return true;
	}

	/**
	 * 返回一个字符串是否不为空
	 * 
	 * @param str
	 *            - String
	 * @return True or False
	 */
	public static boolean isNotTrimNull(String str) {
		if (str == null || str.trim().length() == 0)
			return false;
		return true;
	}

	/**
	 * 返回List是否为空
	 * 
	 * @param list
	 *            - List
	 * @return True or False
	 */
	public static boolean isNull(List<?> list) {
		if (list == null || list.isEmpty())
			return true;
		return false;
	}

	/**
	 * 返回List是否不为空
	 * 
	 * @param list
	 *            - List
	 * @return True or False
	 */
	public static boolean isNotNull(List<?> list) {
		if (list == null || list.isEmpty())
			return false;
		return true;
	}

	/**
	 * 返回Map是否为空
	 * 
	 * @param map
	 *            - Map
	 * @return True or False
	 */
	public static boolean isNull(Map<?, ?> map) {
		if (map == null || map.isEmpty())
			return true;
		return false;
	}

	/**
	 * 返回Map是否不为空
	 * 
	 * @param map
	 *            - Map
	 * @return True or False
	 */
	public static boolean isNotNull(Map<?, ?> map) {
		if (map == null || map.isEmpty())
			return false;
		return true;
	}

	/**
	 * 判断Object是否为空，注意，此处仅仅判断 null
	 * 
	 * @param obj
	 *            - Object
	 * @return True or False
	 */
	public static boolean isNull(Object obj) {
		if (obj == null)
			return true;
		return false;
	}

	/**
	 * 判断Object是否不为空，注意，此处仅仅判断 null
	 * 
	 * @param obj
	 *            - Object
	 * @return True or False
	 */
	public static boolean isNotNull(Object obj) {
		if (obj == null)
			return false;
		return true;
	}

	/**
	 * 返回Set是否不为空
	 * 
	 * @param set
	 *            - Set
	 * @return True or False
	 */
	public static boolean isNotNull(Set<?> set) {
		if (set == null || set.isEmpty())
			return false;
		return true;
	}

	/**
	 * 返回Set是否为空
	 * 
	 * @param set
	 *            - Set
	 * @return True or False
	 */
	public static boolean isNull(Set<?> set) {
		if (set == null || set.isEmpty())
			return true;
		return false;
	}

	/**
	 * 判断数组是否为空
	 * 
	 * @param array
	 *            - Object[]
	 * @return True or False
	 */
	public static boolean isNull(Object[] array) {
		if (array == null || array.length == 0)
			return true;
		return false;
	}

	/**
	 * 判断数组是否不为空
	 * 
	 * @param array
	 *            - Object[]
	 * @return True or False
	 */
	public static boolean isNotNull(Object[] array) {
		if (array == null || array.length == 0)
			return false;
		return true;
	}

	/**
	 * 判断字符串是否为浮点型数字，包含负数
	 * 
	 * @param str
	 *            - String
	 * @return true or false
	 */
	public static boolean isDouble(String str) {
		if (str == null || str.length() == 0)
			return false;
		return Pattern.matches("^[-]?[\\d]+([.]?[\\d]*)$", str);
	}

	/**
	 * 判断是否是整型数字，包括负数
	 */
	private static final Pattern Pattern_Int = Pattern.compile("^[-]?[\\d]+$");

	/**
	 * 判断字符串是否为整型数字，包括负数。
	 * 
	 * @param str
	 *            - String
	 * @return True or False
	 */
	public static boolean isInt(String str) {
		if (isNull(str))
			return false;
		Matcher m = Pattern_Int.matcher(str);
		return m.matches();
	}

	/**
	 * 判断是否是手机的正则表达式
	 */
	private static final Pattern Pattern_Mobile = Pattern
			.compile("^1[0-9]{10}$");

	/**
	 * 判断是否是手机号码
	 * 
	 * @param str
	 *            - String
	 * @return true or false
	 */
	public static boolean isMobile(String str) {
		if (str == null || str.length() != 11)
			return false;
		Matcher m = Pattern_Mobile.matcher(str);
		return m.matches();
	}

	/**
	 * 判断是否是座机
	 * 
	 * @param str
	 *            - String
	 * @return True or False
	 */
	public static boolean isTel(String str) {
		if (str == null)
			return false;

		return Pattern.matches("^(\\d{3,4}-)?\\d{7,9}$", str);
	}

	/**
	 * 判断是否是电话[手机和座机都行]
	 * 
	 * @param str
	 *            - String
	 * @return True or False
	 */
	public static boolean isPhone(String str) {
		if (isNull(str))
			return false;

		if (isMobile(str) || isTel(str))
			return true;
		return false;
	}

	/**
	 * 判断是否是QQ号码
	 * 
	 * @param str
	 *            - String
	 * @return True or False
	 */
	public static boolean isQQ(String str) {
		if (isNull(str))
			return false;

		return Pattern.matches("^([1-9]{1})([0-9]{4,13})$", str);
	}

	/**
	 * 判断是否是微信号码
	 * 
	 * @param str
	 *            - String
	 * @return True or False
	 */
	public static boolean isWeixin(String str) {
		if (isNull(str))
			return false;

		return Pattern.matches("^([a-zA-Z]{1})([0-9A-Za-z_-]{5,19})$", str);
	}

	/**
	 * 判断是否是钱的格式，如12或12.12
	 * 
	 * @param str
	 *            - String
	 * @return True or False
	 */
	public static boolean isMoney(String str) {
		if (str == null || str.length() == 0)
			return false;
		return Pattern.matches("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){1,2})?$",
				str);
	}

	/**
	 * 看一段字符串中是否是汉字
	 * 
	 * @param str
	 *            String 要判断的字符串
	 * @return boolean 布尔值
	 */
	public static boolean isChinese(String str) {
		if (isNull(str))
			return false;
		return Pattern.matches("[\u4e00-\u9fa5]*", str);
	}

	/**
	 * 看一段字符串是否是字母
	 * 
	 * @param str
	 *            String 要判断的字符串
	 * @return boolean 布尔值
	 */
	public static boolean isEnglish(String str) {
		if (isNull(str))
			return false;
		return Pattern.matches("[a-zA-Z]*", str);
	}

	/**
	 * 判断是否是数字的正则表达式
	 */
	private static final Pattern Pattern_Number = Pattern.compile("\\d+");

	/**
	 * 判断一段字符串是否是数字，不包括全角和负数。 此方法替代<code>Tools.isMath(java.lang.String)</code>
	 * 
	 * @param str
	 *            - 字符串
	 * @return boolean 布尔值
	 */
	public static boolean isNumber(String str) {
		if (str == null)
			return false;
		Matcher m = Pattern_Number.matcher(str);
		return m.matches();
	}

	/**
	 * 判断一段字符串是否是正整数且不含0
	 * 
	 * @param str
	 *            - 字符串
	 * @return True or False
	 */
	public static boolean isPositiveNumber(String str) {
		if (!isNumber(str))
			return false;

		return Integer.parseInt(str) > 0;
	}

	/**
	 * 判断一段字符串是否是Email
	 * 
	 * @param str
	 *            String 字符串
	 * @return boolean 布尔值
	 */
	public static boolean isEmail(String str) {
		if (isNull(str))
			return false;
		return Pattern
				.matches(
						"^([a-zA-Z0-9_\\-]+\\.*)+@([a-zA-Z0-9_\\-]+\\.*)+(\\.(com|cn|mobi|co|net|so|org|gov|tel|tv|biz|cc|hk|name|info|asia|me|tw|nz|ru|fr|de|au|jp|kr)){1,2}+$",
						str);
	}

	/**
	 * 判断是否是日期的正则表达式
	 */
	private static final Pattern Pattern_Date = Pattern
			.compile("^[0-9]{4}-[0-9]{2}-[0-9]{2}$");

	/**
	 * 判断一段字符串是否是日期，2011-07-07
	 * 
	 * @param str
	 *            - 字符串
	 * @return boolean 布尔值
	 */
	public static boolean isDate(String str) {
		if (str == null)
			return false;
		Matcher m = Pattern_Date.matcher(str);
		return m.matches();
	}

	/**
	 * 判断是否是日期+时间的正则表达式，如2013-01-23 15:07:47
	 */
	private static final Pattern Pattern_DateTime = Pattern
			.compile("^[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}$");

	/**
	 * 判断一段字符串是否是日期+时间，2011-07-07 12:12:12
	 * 
	 * @param str
	 *            - 字符串
	 * @return boolean 布尔值
	 */
	public static boolean isDateTime(String str) {
		if (str == null)
			return false;
		Matcher m = Pattern_DateTime.matcher(str);
		return m.matches();
	}

	/**
	 * 数组转换成a,b,c格式的字符串
	 * 
	 * @param array
	 *            - Object[]
	 * @return String
	 */
	public static String toString(Object[] array) {
		return toString(array, ",");
	}

	/**
	 * 数组转换成a,b,c格式的字符串
	 * 
	 * @param array
	 *            - Object[]
	 * @param seperator
	 *            - 间隔字符
	 * @return String
	 */
	public static String toString(Object[] array, String seperator) {
		if (array == null || array.length == 0)
			return "";
		StringBuilder buf = new StringBuilder(array.length * 12);
		for (int i = 0; i < array.length - 1; i++) {
			buf.append(array[i]).append(seperator);
		}
		return buf.append(array[array.length - 1]).toString();
	}

	/**
	 * 列表转换成a,b,c格式的字符串
	 * 
	 * @param list
	 *            - List<?>
	 * @return String
	 */
	public static String toString(List<?> list) {
		return toString(list, ",");
	}

	/**
	 * 列表转换成a,b,c格式的字符串
	 * 
	 * @param list
	 *            - List<?>
	 * @param seperator
	 *            - 间隔字符
	 * @return String
	 */
	public static String toString(List<?> list, String seperator) {
		if (list == null || list.isEmpty())
			return "";
		int size = list.size();
		StringBuilder buf = new StringBuilder(size * 12).append(list.get(0));
		for (int i = 1; i < size; i++) {
			buf.append(seperator).append(list.get(i));
		}
		return buf.toString();
	}

	/**
	 * 迭代器转换成a,b,c格式的字符串
	 * 
	 * @param objects
	 *            - Iterator<?>
	 * @return String
	 */
	public static String toString(Iterator<?> objects) {
		return toString(objects, ",");
	}

	/**
	 * 迭代器转换成a,b,c格式的字符串
	 * 
	 * @param objects
	 *            - Iterator<?>
	 * @param seperator
	 *            - 间隔字符
	 * @return String
	 */
	public static String toString(Iterator<?> objects, String seperator) {
		if (objects == null || !objects.hasNext())
			return "";
		StringBuilder buf = new StringBuilder();
		if (objects.hasNext())
			buf.append(objects.next());
		while (objects.hasNext()) {
			buf.append(seperator).append(objects.next());
		}
		return buf.toString();
	}

	/**
	 * 编码URL字符串
	 * 
	 * @param str
	 *            - 字符串
	 * @param charset
	 *            - 编码
	 * @return String
	 * @throws UnsupportedEncodingException
	 */
	public static String encoder(String str, String charset)
			throws UnsupportedEncodingException {
		if (isNull(str))
			return "";
		return URLEncoder.encode(str, charset);
	}

	/**
	 * 去掉字符串头尾的空格
	 * 
	 * @param str
	 *            - 要替换的字符串
	 * @return String
	 */
	public static String trim(String str) {
		if (str == null)
			return "";
		return str.trim();
	}

	/**
	 * 去掉字符串头尾的字符
	 * 
	 * @param str
	 *            - 要替换的字符串
	 * @param s
	 *            - 要去掉的头尾字符
	 * @return String
	 */
	public static String trim(String str, String s) {
		if (Tools.isNull(str))
			return "";
		return str.replaceAll("^" + s + "+|" + s + "+$", "");
	}

	/**
	 * 字符串拼接
	 * 
	 * @param name
	 *            - 字符
	 * @param suffix
	 *            - 要拼接的字符串
	 * @return String
	 */
	public static String suffix(String name, String suffix) {
		if (name == null)
			name = "";
		return (suffix == null) ? name : name + suffix;
	}

	/**
	 * 字符串转换成int型,默认值返回0
	 * 
	 * @param s
	 *            - String
	 * @return int
	 */
	public static int parseInt(String s) {
		return parseInt(s, 0);
	}

	/**
	 * 字符串转换成int型
	 * 
	 * @param s
	 *            - String
	 * @param defaultValue
	 *            - 如果转换错误，则返回defaultValue
	 * @return int
	 */
	public static int parseInt(String s, int defaultValue) {
		if (s == null)
			return defaultValue;

		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * 字符串转换long型,默认值返回0
	 * 
	 * @param s
	 *            - String
	 * @return long
	 */
	public static long parseLong(String s) {
		return parseLong(s, 0);
	}

	/**
	 * 字符串转换成long型
	 * 
	 * @param s
	 *            - String
	 * @param defaultValue
	 *            - 如果转换错误，则返回defaultValue
	 * @return long
	 */
	public static long parseLong(String s, long defaultValue) {
		if (s == null)
			return defaultValue;

		try {
			return Long.parseLong(s);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * 字符串抓换成float型，默认值返回0
	 * 
	 * @param s
	 *            - String
	 * @return float
	 */
	public static float parseFloat(String s) {
		return parseFloat(s, 0f);
	}

	/**
	 * 字符串抓换成float型
	 * 
	 * @param s
	 *            - String
	 * @param defaultValue
	 *            - 如果转换错误，则返回defaultValue
	 * @return float
	 */
	public static float parseFloat(String s, float defaultValue) {
		if (s == null)
			return defaultValue;

		try {
			return Float.parseFloat(s);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * 字符串转换成double型，默认值返回0
	 * 
	 * @param s
	 *            - String
	 * @return double
	 */
	public static double parseDouble(String s) {
		return parseDouble(s, 0d);
	}

	/**
	 * 字符串抓换成double型
	 * 
	 * @param s
	 *            - String
	 * @param defaultValue
	 *            - 如果转换错误，则返回defaultValue
	 * @return double
	 */
	public static double parseDouble(String s, double defaultValue) {
		if (s == null)
			return defaultValue;

		try {
			return Double.parseDouble(s);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * 字符串转换成boolean型，默认值返回false
	 * 
	 * @param s
	 *            - String
	 * @return boolean
	 */
	public static boolean parseBoolean(String s) {
		return parseBoolean(s, false);
	}

	/**
	 * 字符串抓换成boolean型
	 * 
	 * @param s
	 *            - String
	 * @param defaultValue
	 *            - 如果转换错误，则返回defaultValue
	 * @return boolean
	 */
	public static boolean parseBoolean(String s, boolean defaultValue) {
		if (s == null)
			return defaultValue;

		try {
			return Boolean.parseBoolean(s);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * Long转换成long
	 * 
	 * @param l
	 *            - Long
	 * @param defaultValue
	 *            - 默认显示值
	 * @return long
	 */
	public static long longValue(Long l, long defaultValue) {
		if (l == null)
			return defaultValue;
		return l.longValue();
	}

	/**
	 * Long转换成long，如果为null，则显示0
	 * 
	 * @param l
	 *            - Long
	 * @return long
	 */
	public static long longValue(Long l) {
		return longValue(l, 0);
	}

	/**
	 * Integer转换成int
	 * 
	 * @param i
	 *            - Integer
	 * @param defaultValue
	 *            - 默认显示值
	 * @return int
	 */
	public static int intValue(Integer i, int defaultValue) {
		if (i == null)
			return defaultValue;
		return i.intValue();
	}

	/**
	 * Integer转换成int，如果为null，则显示0
	 * 
	 * @param i
	 *            - Integer
	 * @return int
	 */
	public static int intValue(Integer i) {
		return intValue(i, 0);
	}

	/**
	 * Float转换成float
	 * 
	 * @param f
	 *            - Float
	 * @param defaultValue
	 *            - 默认显示值
	 * @return float
	 */
	public static float floatValue(Float f, float defaultValue) {
		if (f == null)
			return defaultValue;
		return f.floatValue();
	}

	/**
	 * Float转换成float，如果为null，则显示0
	 * 
	 * @param f
	 *            - Float
	 * @return float
	 */
	public static float floatValue(Float f) {
		return floatValue(f, 0f);
	}

	/**
	 * Double转换成double
	 * 
	 * @param d
	 *            - Double
	 * @param defaultValue
	 *            - 默认显示值
	 * @return double
	 */
	public static double doubleValue(Double d, double defaultValue) {
		if (d == null)
			return defaultValue;
		return d.doubleValue();
	}

	/**
	 * Double转换成double，如果为null，则显示0
	 * 
	 * @param d
	 *            - Double
	 * @return double
	 */
	public static double doubleValue(Double d) {
		return doubleValue(d, 0d);
	}

	/**
	 * Boolean转换成Boolean
	 * 
	 * @param b
	 *            - Boolean
	 * @param defaultValue
	 *            - 默认显示值
	 * @return boolean
	 */
	public static boolean booleanValue(Boolean b, boolean defaultValue) {
		if (b == null)
			return defaultValue;
		return b.booleanValue();
	}

	/**
	 * Boolean转换成Boolean，如果为null，则显示false
	 * 
	 * @param b
	 *            - Boolean
	 * @return boolean
	 */
	public static boolean booleanValue(Boolean b) {
		return booleanValue(b, false);
	}

	/**
	 * Date转换成long型
	 * 
	 * @param date
	 *            - 时间
	 * @return long
	 */
	public static long dateValue(Date date) {
		if (date == null)
			return 0;
		return date.getTime();
	}

	/**
	 * 首字母小写
	 * 
	 * @param s
	 *            - String
	 * @return String
	 */
	public static String uncapFirst(String s) {
		if (s == null || s.length() == 0)
			return "";

		return Character.toLowerCase(s.charAt(0)) + s.substring(1);
	}

	/**
	 * 首字母小写
	 * 
	 * @param s
	 *            - String
	 * @return String
	 */
	public static String capFirst(String s) {
		if (s == null || s.length() == 0)
			return "";

		return Character.toUpperCase(s.charAt(0)) + s.substring(1);
	}

	/**
	 * int 转换成 byte 4位数组
	 * 
	 * @param i
	 *            - int
	 * @return byte[]
	 */
	public static byte[] intToByteArray(int i) {
		byte[] result = new byte[4];
		result[0] = (byte) ((i >> 24) & 0xFF);
		result[1] = (byte) ((i >> 16) & 0xFF);
		result[2] = (byte) ((i >> 8) & 0xFF);
		result[3] = (byte) (i & 0xFF);
		return result;
	}

	/**
	 * 4位byte数组转换成int
	 * 
	 * @param b
	 *            - byte[]
	 * @return int
	 */
	public static int byteArrayToInt(byte[] b) {
		if (b == null || b.length != 4)
			return 0;

		int value = 0;
		for (int i = 0; i < 4; i++) {
			int shift = (4 - 1 - i) * 8;
			value += (b[i] & 0x000000FF) << shift;
		}
		return value;
	}

	/**
	 * 当前日期与给定日期比较
	 * 
	 * @param time1
	 *            开始日期
	 * @param time2
	 *            结束日期
	 * @return
	 */
	public static boolean compareTime(String time1, String time2) {
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date now = c.getTime();
		boolean b = false;
		try {
			Date startDate = df.parse(time1);
			Date endDate = df.parse(time2);
			if (now.compareTo(startDate) >= 0 && now.compareTo(endDate) <= 0) {
				b = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return b;
	}

	/**
	 * 当前时间是否在指定的时间范围内
	 * 
	 * @param beginDate
	 *            - 开始时间
	 * @param endDate
	 *            - 结束时间[不含]
	 * @return True or False
	 */
	public static boolean betweenTime(Date beginDate, Date endDate) {
		if (beginDate == null || endDate == null)
			return false;

		long currTime = System.currentTimeMillis();
		if (beginDate.getTime() <= currTime && endDate.getTime() > currTime)
			return true;
		return false;
	}

	/**
	 * 利用apache的StringUtils.split
	 * 
	 * @param s
	 *            - 要分割的字符串
	 * @return String[]
	 */
	public static String[] split(String s) {
		return StringUtils.split(s, ",");
	}

	/**
	 * 利用apache的StringUtils.split
	 * 
	 * @param s
	 *            - 要分割的字符串
	 * @param separatorChars
	 *            - 指定分割符
	 * @return String[]
	 */
	public static String[] split(String s, String separatorChars) {
		return StringUtils.split(s, separatorChars);
	}

	/**
	 * 对sql字符进行编码
	 * 
	 * @param str
	 *            - 要编码的字符串
	 * @return String
	 */
	public static String escapeSql(String str) {
		return StringEscapeUtils.escapeSql(str);
	}

	/**
	 * 获取NumberFormat
	 * 
	 * @param format
	 *            - String
	 * @return NumberFormat
	 */
	private static NumberFormat getNumberFormat(String format) {
		Map<String, NumberFormat> map = NUMBER_MAP_LOCAL.get();
		if (map == null) {
			map = new HashMap<String, NumberFormat>();
			NUMBER_MAP_LOCAL.set(map);
		}

		NumberFormat fmt = map.get(format);
		if (fmt == null) {
			fmt = new DecimalFormat(format);
		}

		return fmt;
	}

	/**
	 * 获取NumberFormat，保留两位小数
	 * 
	 * @return NumberFormat
	 */
	public static NumberFormat getDefaultNumberFormat() {
		return getNumberFormat("#0.00");
	}

	/**
	 * 获取NumberFormat，如果有小数则显示小数，否则不显示
	 * 
	 * @return NumberFormat
	 */
	public static NumberFormat getSmallDecimalFormat() {
		return getNumberFormat("#0.##");
	}

	/**
	 * 获取两位Float
	 * 
	 * @param number
	 *            - 数字
	 * @return String
	 */
	public static String getFloat2(float number) {
		NumberFormat df = getDefaultNumberFormat();
		return df.format(number);
	}

	/**
	 * 获取两位Float
	 * 
	 * @param number
	 *            - 数字
	 * @param zero
	 *            - 如果小数位数为0，是否显示小数位。
	 * @return String
	 */
	public static String getFloat2(float number, boolean zero) {
		NumberFormat df = zero ? getDefaultNumberFormat()
				: getSmallDecimalFormat();
		return df.format(number);
	}

	/**
	 * 获取两个Double
	 * 
	 * @param number
	 *            - 数字
	 * @return String
	 */
	public static String getDouble2(double number) {
		NumberFormat df = getDefaultNumberFormat();
		return df.format(number);
	}

	/**
	 * 获取两位Float
	 * 
	 * @param number
	 *            - 数字
	 * @param zero
	 *            - 如果小数位数为0，是否显示小数位。
	 * @return String
	 */
	public static String getDouble2(double number, boolean zero) {
		NumberFormat df = zero ? getDefaultNumberFormat()
				: getSmallDecimalFormat();
		return df.format(number);
	}

	/**
	 * 格式化double类型的字段，保存两位小数
	 * 
	 * @param o
	 *            - 需要格式化属性的对象
	 */
	public static void formatDoubleField(Object o) {
		Map<String, Double> fieldmap = new HashMap<String, Double>();
		Map<String, Double> getfieldmap = new HashMap<String, Double>();
		Map<String, Double> setfieldmap = new HashMap<String, Double>();
		for (Field field : o.getClass().getDeclaredFields()) {
			String fileType = field.getType().toString().toLowerCase();
			if (fileType.equals("double")) {
				try {
					getfieldmap.put("get" + field.getName().toLowerCase(), 0D);
					setfieldmap.put("set" + field.getName().toLowerCase(), 0D);
					fieldmap.put(field.getName().toLowerCase(), 0D);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
			}
		}

		Object[] obj = null;
		for (Method m : o.getClass().getDeclaredMethods()) {
			if (getfieldmap.get(m.getName().toString().toLowerCase()) != null) {
				Object tmp = null;
				try {
					tmp = m.invoke(o, obj);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				double val = Double.parseDouble(tmp.toString());
				setfieldmap.put("set" + m.getName().substring(3).toLowerCase(),
						val);
				getfieldmap.put("get" + m.getName().substring(3).toLowerCase(),
						val);
				fieldmap.put(m.getName().substring(3).toLowerCase(), val);
			}
		}

		for (Method m : o.getClass().getDeclaredMethods()) {
			if (setfieldmap.get(m.getName().toString().toLowerCase()) != null) {
				BigDecimal b = new BigDecimal(setfieldmap.get(m.getName()
						.toString().toLowerCase()));
				double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP)
						.doubleValue();
				try {
					m.invoke(o, f1);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 获取本机IP地址
	 * 
	 * @return String
	 */
	public static String getLocalIP() {
		String ip = "";
		try {
			Enumeration<NetworkInterface> e1 = NetworkInterface
					.getNetworkInterfaces();
			a: while (e1.hasMoreElements()) {
				NetworkInterface ni = (NetworkInterface) e1.nextElement();
				Enumeration<InetAddress> e2 = ni.getInetAddresses();
				while (e2.hasMoreElements()) {
					InetAddress ia = e2.nextElement();
					if (ia != null && ia instanceof Inet4Address) {
						String t = ia.getHostAddress();
						if (Tools.isNotNull(t) && !t.startsWith("127.0")) {
							ip = t;
							break a;
						}
					}
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
		return ip;
	}

	/**
	 * 获取指定机器的IP地址
	 * 
	 * @param host
	 *            - 域名，如www.58.com
	 * @return String
	 */
	public static String getServerIP(String host) {
		try {
			InetAddress inet = InetAddress.getByName(host);
			if (inet != null)
				return inet.getHostAddress();
		} catch (UnknownHostException e) {

		}
		return "";
	}

	/**
	 * 通过ByURLClassLoader获取当前加载的jar文件
	 * 
	 * @return List<String>
	 * @throws Exception
	 */
	public static List<String> getJarByURLClassLoader() throws Exception {
		URL[] urlAry = ((URLClassLoader) Thread.currentThread()
				.getContextClassLoader()).getURLs();
		List<String> jarFileList = new ArrayList<String>();
		for (URL url : urlAry) {
			String path = url.getPath();
			if (path.endsWith(".jar")) {
				jarFileList.add(URLDecoder.decode(path, "utf-8"));
			}
		}

		return jarFileList;
	}

	/**
	 * 判断类是否集成了指定的接口
	 * 
	 * @param type
	 *            - Class
	 * @param interfaceType
	 *            - Class
	 * @return True or False
	 */
	public static boolean interfaceOf(Class<?> type, Class<?> interfaceType) {
		if (type == null)
			return false;

		Class<?>[] interfaces = type.getInterfaces();
		for (Class<?> c : interfaces) {
			if (c.equals(interfaceType))
				return true;
		}

		return false;
	}

	/**
	 * 关闭数据库连接
	 * 
	 * @param rs
	 *            - 返回的数据集
	 * @param st
	 *            - sql语句执行对象
	 * @param co
	 *            - 数据库连接
	 */
	public static void closeDBA(ResultSet rs, Statement st, Connection co) {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (co != null)
				co.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static <T> Set<T> List2Set(List<T> list){
		if(list!=null && list.size()>0){
			Set<T> set=new HashSet<>();
			for(T t:list){
				set.add(t);
			}
			return set;
		}
		return null;
	}
	public static boolean isNullOrZero(Number num){
		if(num ==null){
			return true;
		}else{
			if((num+"").matches("[0].?[0]*")){
				return true;
			}else{
				return false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		String src="";
		 InputStreamReader rd=new InputStreamReader(new FileInputStream(new File(src)));
		   BufferedReader bd=new BufferedReader(rd);
		   int i=1;
		   while(true){
			   String str=bd.readLine();
			   if(i==200){
				   Thread.sleep(1000);
			   }
 			   if(str!=null&&str!=""){
				   String[] data=str.split(",");
				   System.out.println(data[0]+","+Double.parseDouble(data[1])+","+i);
				   i++;
				   
			   }else{
				   break;
			   }
		   }
		   bd.close();
		   rd.close();
		   
	}

}
