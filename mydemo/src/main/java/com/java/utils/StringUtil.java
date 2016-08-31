package com.java.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;

public class StringUtil {

	/**
	 * 方法判断参数字符串是否为空
	 * 
	 * @author Michael 2015-1-5
	 * @param str
	 * @return 布尔值
	 */
	public static boolean isEmpty(String str) {
		return StringUtils.isEmpty(str);
	}

	/**
	 * 方法判断参数字符串是否不为空
	 * 
	 * @param str
	 * @return 如果字符串本身为空或长度为0，则返回假
	 */
	public static boolean isNotEmpty(String str) {
		return StringUtils.isNotEmpty(str);
	}

	/**
	 * 方法判断参数字符串是否没有内容
	 * 
	 * @param str
	 * @return 如果字符串为空或长度为0，则返回真
	 */
	public static boolean isBlank(String str) {
		return StringUtils.isBlank(str);
	}

	/**
	 * 方法判断参数字符串是否不是没有内容
	 * 
	 * @param str
	 * @return 如果字符串为空或长度为0，则返回假
	 */
	public static boolean isNotBlank(String str) {
		return StringUtils.isNotBlank(str);
	}

	/**
	 * 返回参数字符串去掉前后空格的结果
	 * 
	 * @param str
	 * @return 去掉空格后的结果
	 */
	public static String trim(String str) {
		return StringUtils.trim(str);
	}

	/**
	 * 先去空格，然后利用isEmpty方法判断是否为空
	 * 
	 * @param str
	 * @return 空则返回null，否则返回处理后的结果
	 */
	public static String trimToNull(String str) {
		return StringUtils.trimToNull(str);
	}

	/**
	 * 如果参数字符串为null，则返回""，否则去空格后返回
	 * 
	 * @param str
	 * @return 空则返回""，否则返回处理后的结果
	 */
	public static String trimToEmpty(String str) {
		return StringUtils.trimToEmpty(str);
	}

	/**
	 * 返回参数字符串去掉前后空格的结果
	 * 
	 * @param str
	 * @return 返回处理后的结果
	 */
	public static String strip(String str) {
		return StringUtils.strip(str);
	}

	/**
	 * 先去空格，然后利用isEmpty方法判断是否为空
	 * 
	 * @param str
	 * @return 空则返回null，否则返回处理后的结果
	 */
	public static String stripToNull(String str) {
		return StringUtils.stripToNull(str);
	}

	/**
	 * 如果参数字符串为null，则返回""，否则去空格后返回
	 * 
	 * @param str
	 * @return 空则返回""，否则返回处理后的结果
	 */
	public static String stripToEmpty(String str) {
		return StringUtils.stripToEmpty(str);
	}

	/**
	 * 去掉任意名为stripChars的字符集合
	 * 
	 * @param str
	 * @param stripChars
	 * @return 返回处理后的结果
	 */
	public static String strip(String str, String stripChars) {
		return StringUtils.strip(str, stripChars);
	}

	/**
	 * 在字符串str的前面去掉stripChars代表的字符集合
	 * 
	 * @param str
	 * @param stripChars
	 * @return 返回处理后的结果
	 */
	public static String stripStart(String str, String stripChars) {
		return StringUtils.stripStart(str, stripChars);
	}

	/**
	 * 在字符串str的后面去掉stripChars代表的字符集合
	 * 
	 * @param str
	 * @param stripChars
	 * @return 返回处理后的结果
	 */
	public static String stripEnd(String str, String stripChars) {
		return StringUtils.stripEnd(str, stripChars);
	}

	/**
	 * 参数为字符串数组，利用strip方法处理一组字符串，返回的也是数组，但非参数数组
	 * 
	 * @param strs
	 * @return 返回处理后的结果
	 */
	public static String[] stripAll(String[] strs) {
		return StringUtils.stripAll(strs);
	}

	/**
	 * 参数为字符串数组，利用strip方法处理一组字符串，返回的也是数组，但非参数数组
	 * 
	 * @param strs
	 * @param stripChars
	 * @return 返回处理后的结果
	 */
	public static String[] stripAll(String[] strs, String stripChars) {
		return StringUtils.stripAll(strs, stripChars);
	}

	/**
	 * 比较两个字符串，使用其中一个的equals方法，只不过之前对两个字符串进行判空
	 * 
	 * @param str1
	 * @param str2
	 * @return 返回处理后的结果
	 */
	public static boolean equals(String str1, String str2) {
		return StringUtils.equals(str1, str2);
	}

	/**
	 * 不考虑大小写的比较字符串，方法和equals方法类似
	 * 
	 * @param str1
	 * @param str2
	 * @return 返回处理后的结果
	 */
	public static boolean equalsIgnoreCase(String str1, String str2) {
		return StringUtils.equalsIgnoreCase(str1, str2);
	}

	/**
	 * 返回字符串中的某个字符串从左侧数第一次出现的位置
	 * 
	 * @param str
	 * @param searchChar
	 * @return 返回处理后的结果
	 */
	public static int indexOf(String str, char searchChar) {
		return StringUtils.indexOf(str, searchChar);
	}

	/**
	 * 返回字符串中的某个字符串从左侧数第一次出现的位置
	 * 
	 * @param str
	 * @param searchChar
	 * @param startPos
	 * @return 返回处理后的结果
	 */
	public static int indexOf(String str, char searchChar, int startPos) {
		return StringUtils.indexOf(str, searchChar, startPos);
	}

	/**
	 * 返回字符串中的某个字符串从左侧数第一次出现的位置
	 * 
	 * @param str
	 * @param searchStr
	 * @return 返回处理后的结果
	 */
	public static int indexOf(String str, String searchStr) {
		return StringUtils.indexOf(str, searchStr);
	}

	/**
	 * 返回字符串中的某个字符串从左侧数第一次出现的位置
	 * 
	 * @param str
	 * @param searchStr
	 * @param startPos
	 * @return 返回处理后的结果
	 */
	public static int indexOf(String str, String searchStr, int startPos) {
		return StringUtils.indexOf(str, searchStr, startPos);
	}

	/**
	 * 查找第ordinal个匹配的字符串
	 * 
	 * @param str
	 * @param searchStr
	 * @param ordinal
	 * @return 返回处理后的结果
	 */
	public static int ordinalIndexOf(String str, String searchStr, int ordinal) {
		return StringUtils.ordinalIndexOf(str, searchStr, ordinal);
	}

	/**
	 * 返回字符串中的某个字符串从右侧数最后一次出现的位置
	 * 
	 * @param str
	 * @param searchChar
	 * @return 返回处理后的结果
	 */
	public static int lastIndexOf(String str, char searchChar) {
		return StringUtils.lastIndexOf(str, searchChar);
	}

	/**
	 * 返回字符串中的某个字符串从右侧数最后一次出现的位置
	 * 
	 * @param str
	 * @param searchStr
	 * @return 返回处理后的结果
	 */
	public static int lastIndexOf(String str, String searchStr) {
		return StringUtils.lastIndexOf(str, searchStr);
	}

	/**
	 * 返回字符串中的某个字符串从右侧数最后一次出现的位置
	 * 
	 * @param str
	 * @param searchChar
	 * @param startPos
	 * @return 返回处理后的结果
	 */
	public static int lastIndexOf(String str, char searchChar, int startPos) {
		return StringUtils.lastIndexOf(str, searchChar, startPos);
	}

	/**
	 * 返回字符串中的某个字符串从右侧数最后一次出现的位置
	 * 
	 * @param str
	 * @param searchStr
	 * @param startPos
	 * @return 返回处理后的结果
	 */
	public static int lastIndexOf(String str, String searchStr, int startPos) {
		return StringUtils.lastIndexOf(str, searchStr, startPos);
	}

	/**
	 * 找出字符串数组searchStrs中的字符串最后一次出现在字符串str中的位置
	 * 
	 * @param str
	 * @param searchStrs
	 * @return 返回处理后的结果
	 */
	public static int lastIndexOfAny(String str, String[] searchStrs) {
		return StringUtils.lastIndexOfAny(str, searchStrs);
	}

	/**
	 * 在字符串中查找一组字符，返回遇到的任意一个字符即可
	 * 
	 * @param str
	 * @param searchChars
	 * @return 返回处理后的结果
	 */
	public static int indexOfAny(String str, char[] searchChars) {
		return StringUtils.indexOfAny(str, searchChars);
	}

	/**
	 * 在字符串中查找一组字符，返回遇到的任意一个字符即可
	 * 
	 * @param str
	 * @param searchChars
	 * @return 返回处理后的结果
	 */
	public static int indexOfAny(String str, String searchChars) {
		return StringUtils.indexOfAny(str, searchChars);
	}

	/**
	 * 在字符串中查找一组字符，返回遇到的任意一个字符即可
	 * 
	 * @param str
	 * @param searchStrs
	 * @return 返回处理后的结果
	 */
	public static int indexOfAny(String str, String[] searchStrs) {
		return StringUtils.indexOfAny(str, searchStrs);
	}

	/**
	 * 在字符串中查找一组字符，返回首先遇到的任意一个不在该组字符的位置即可
	 * 
	 * @param str
	 * @param searchChars
	 * @return 返回处理后的结果
	 */
	public static int indexOfAnyBut(String str, char[] searchChars) {
		return StringUtils.indexOfAnyBut(str, searchChars);
	}

	/**
	 * 在字符串中查找一组字符，返回首先遇到的任意一个不在该组字符的位置即可
	 * 
	 * @param str
	 * @param searchChars
	 * @return 返回处理后的结果
	 */
	public static int indexOfAnyBut(String str, String searchChars) {
		return StringUtils.indexOfAnyBut(str, searchChars);
	}

	/**
	 * 查找参数字符串是否在给定的字符串中
	 * 
	 * @param str
	 * @param searchChar
	 * @return 如果给定字符串为空或参数字符串为空，则返回假，利用indexOf的结果是否为-1确定返回值
	 */
	public static boolean contains(String str, char searchChar) {
		return StringUtils.contains(str, searchChar);
	}

	/**
	 * 查找参数字符串是否在给定的字符串中
	 * 
	 * @param str
	 * @param searchStr
	 * @return 如果给定字符串为空或参数字符串为空，则返回假，利用indexOf的结果是否为-1确定返回值
	 */
	public static boolean contains(String str, String searchStr) {
		return StringUtils.contains(str, searchStr);
	}

	/**
	 * 测试字符串是否只包含字符数组中的那些字符
	 * 
	 * @param str
	 * @param valid
	 * @return 返回处理后的结果
	 */
	public static boolean containsOnly(String str, char[] valid) {
		return StringUtils.containsOnly(str, valid);
	}

	/**
	 * 测试字符串是否只包含字符数组中的那些字符
	 * 
	 * @param str
	 * @param validChars
	 * @return 返回处理后的结果
	 */
	public static boolean containsOnly(String str, String validChars) {
		return StringUtils.containsOnly(str, validChars);
	}

	/**
	 * 测试字符串是否任意一个字符数组中的字符
	 * 
	 * @param str
	 * @param invalidChars
	 * @return 遍历字符串，如果任意一个字符与字符数组中的字符相同，则返回真，否则返回假
	 */
	public static boolean containsNone(String str, char[] invalidChars) {
		return StringUtils.containsNone(str, invalidChars);
	}

	/**
	 * 测试字符串是否任意一个字符数组中的字符
	 * 
	 * @param str
	 * @param invalidChars
	 * @return 遍历字符串，如果任意一个字符与字符数组中的字符相同，则返回真，否则返回假
	 */
	public static boolean containsNone(String str, String invalidChars) {
		return StringUtils.containsNone(str, invalidChars);
	}

	/**
	 * 得到字符串str的子串
	 * 
	 * @param str
	 * @param start
	 * @return 返回处理后的结果
	 */
	public static String substring(String str, int start) {
		return StringUtils.substring(str, start);
	}

	/**
	 * 得到字符串str的子串
	 * 
	 * @param str
	 * @param start
	 * @param end
	 * @return 返回处理后的结果
	 */
	public static String substring(String str, int start, int end) {
		return StringUtils.substring(str, start, end);
	}

	/**
	 * 得到字符串str从左边数len长度的子串
	 * 
	 * @param str
	 * @param len
	 * @return 返回处理后的结果
	 */
	public static String left(String str, int len) {
		return StringUtils.left(str, len);
	}

	/**
	 * 得到字符串str从右边数len长度的子串
	 * 
	 * @param str
	 * @param len
	 * @return 返回处理后的结果
	 */
	public static String right(String str, int len) {
		return StringUtils.right(str, len);
	}

	/**
	 * 得到字符串str从pos开始len长度的子串
	 * 
	 * @param str
	 * @param pos
	 * @param len
	 * @return 返回处理后的结果
	 */
	public static String mid(String str, int pos, int len) {
		return StringUtils.mid(str, pos, len);
	}

	/**
	 * 得到字符串str的在字符串separator出现前的字串，且separator不包括在内
	 * 
	 * @param str
	 * @param separator
	 * @return 返回处理后的结果
	 */
	public static String substringBefore(String str, String separator) {
		return StringUtils.substringBefore(str, separator);
	}

	/**
	 * 得到字符串str的在字符串separator出现后的字串，且separator不包括在内
	 * 
	 * @param str
	 * @param separator
	 * @return 返回处理后的结果
	 */
	public static String substringAfter(String str, String separator) {
		return StringUtils.substringAfter(str, separator);
	}

	/**
	 * 得到字符串str的在字符串separator最后一次出现前的字串
	 * 
	 * @param str
	 * @param separator
	 * @return 返回处理后的结果
	 */
	public static String substringBeforeLast(String str, String separator) {
		return StringUtils.substringBeforeLast(str, separator);
	}

	/**
	 * 得到字符串str的在字符串separator最后一次出现后的字串
	 * 
	 * @param str
	 * @param separator
	 * @return 返回处理后的结果
	 */
	public static String substringAfterLast(String str, String separator) {
		return StringUtils.substringAfterLast(str, separator);
	}

	/**
	 * 得到str中的在两个字符串tag中间的字符串，即str中的tag所夹的串
	 * 
	 * @param str
	 * @param tag
	 * @return 返回处理后的结果
	 */
	public static String substringBetween(String str, String tag) {
		return StringUtils.substringBetween(str, tag);
	}

	/**
	 * 得到str中的在两个字符串open和close中间的字符串，即open和close所夹的串
	 * 
	 * @param str
	 * @param open
	 * @param close
	 * @return 返回处理后的结果
	 */
	public static String substringBetween(String str, String open, String close) {
		return StringUtils.substringBetween(str, open, close);
	}

	/**
	 * 把字符串拆分成一个字符串数组，用空白符作为分隔符
	 * 
	 * @param str
	 * @return 返回处理后的结果
	 */
	public static String[] split(String str) {
		return StringUtils.split(str);
	}

	/**
	 * 把字符串拆分成一个字符串数组，用指定的字符separatorChar作为分隔符
	 * 
	 * @param str
	 * @param separatorChar
	 * @return 返回处理后的结果
	 */
	public static String[] split(String str, char separatorChar) {
		return StringUtils.split(str, separatorChar);
	}

	/**
	 * 把字符串拆分成一个字符串数组，用指定的字符串separatorChars作为分隔符
	 * 
	 * @param str
	 * @param separatorChars
	 * @return 返回处理后的结果
	 */
	public static String[] split(String str, String separatorChars) {
		return StringUtils.split(str, separatorChars);
	}

	/**
	 * 把字符串拆分成一个字符串数组，用指定的字符串separatorChars作为分隔符，数组的最大长度为max
	 * 
	 * @param str
	 * @param separatorChars
	 * @param max
	 * @return 返回处理后的结果
	 */
	public static String[] split(String str, String separatorChars, int max) {
		return StringUtils.split(str, separatorChars, max);
	}

	/**
	 * 把字符串拆分成一个字符串数组，用指定的字符串separatorChars作为分隔符
	 * 
	 * @param str
	 * @param separator
	 * @return 返回处理后的结果
	 */
	public static String[] splitByWholeSeparator(String str, String separator) {
		return StringUtils.splitByWholeSeparator(str, separator);
	}

	/**
	 * 把字符串拆分成一个字符串数组，用指定的字符串separatorChars作为分隔符，数组的最大长度为max
	 * 
	 * @param str
	 * @param separator
	 * @param max
	 * @return 返回处理后的结果
	 */
	public static String[] splitByWholeSeparator(String str, String separator, int max) {
		return StringUtils.splitByWholeSeparator(str, separator, max);
	}

	/**
	 * 把字符串str拆分成一个数组，用空白符(whitespace)作为分隔符，保留所有的标识，包括相邻分隔符产生的空的标识
	 * 
	 * @param str
	 * @return 返回处理后的结果
	 */
	public static String[] splitPreserveAllTokens(String str) {
		return StringUtils.splitPreserveAllTokens(str);
	}

	/**
	 * 把字符串str拆分成一个数组，用separatorChar作为分隔符，保留所有的标识，包括相邻分隔符产生的空的标识
	 * 
	 * @param str
	 * @param separatorChar
	 * @return 返回处理后的结果
	 */
	public static String[] splitPreserveAllTokens(String str, char separatorChar) {
		return StringUtils.splitPreserveAllTokens(str, separatorChar);
	}

	/**
	 * 把字符串str拆分成一个数组，用separatorChar作为分隔符，保留所有的标识，包括相邻分隔符产生的空的标识
	 * 
	 * @param str
	 * @param separatorChars
	 * @return 返回处理后的结果
	 */
	public static String[] splitPreserveAllTokens(String str, String separatorChars) {
		return StringUtils.splitPreserveAllTokens(str, separatorChars);
	}

	/**
	 * 把字符串str拆分成一个数组，用separatorChar作为分隔符，保留所有的标识，包括相邻分隔符产生的空的标识，指定数组最大长度max
	 * 
	 * @param str
	 * @param separatorChars
	 * @param max
	 * @return 返回处理后的结果
	 */
	public static String[] splitPreserveAllTokens(String str, String separatorChars, int max) {
		return StringUtils.splitPreserveAllTokens(str, separatorChars, max);
	}

	/**
	 * 把数组中的元素连接成一个字符串返回
	 * 
	 * @param array
	 * @return 返回处理后的结果
	 */
	public static String join(Object[] array) {
		return StringUtils.join(array);
	}

	/**
	 * 把数组中的元素连接成一个字符串返回，把分隔符separator也加上
	 * 
	 * @param array
	 * @param separator
	 * @return 返回处理后的结果
	 */
	public static String join(Object[] array, char separator) {
		return StringUtils.join(array, separator);
	}

	/**
	 * 把数组中的元素连接成一个字符串返回，把分隔符separator也加上
	 * 
	 * @param array
	 * @param separator
	 * @return 返回处理后的结果
	 */
	public static String join(Object[] array, String separator) {
		return StringUtils.join(array, separator);
	}

	/**
	 * 把数组中的元素连接成一个字符串返回，把分隔符separator也加上
	 * 
	 * @param iterator
	 * @param separator
	 * @return 返回处理后的结果
	 */
	public static String join(Iterator<?> iterator, char separator) {
		return StringUtils.join(iterator, separator);
	}

	/**
	 * 把数组中的元素连接成一个字符串返回，把分隔符separator也加上
	 * 
	 * @param iterator
	 * @param separator
	 * @return 返回处理后的结果
	 */
	public static String join(Iterator<?> iterator, String separator) {
		return StringUtils.join(iterator, separator);
	}

	/**
	 * 删除字符串中的所有空白符
	 * 
	 * @param str
	 * @return 返回处理后的结果
	 */
	public static String deleteWhitespace(String str) {
		return StringUtils.deleteWhitespace(str);
	}

	/**
	 * 如果字符串str是以字符串remove开始，则去掉这个开始，然后返回，否则返回原来的串
	 * 
	 * @param str
	 * @param remove
	 * @return 返回处理后的结果
	 */
	public static String removeStart(String str, String remove) {
		return StringUtils.removeStart(str, remove);
	}

	/**
	 * 如果字符串str是以字符串remove结尾，则去掉这个结尾，然后返回，否则返回原来的串
	 * 
	 * @param str
	 * @param remove
	 * @return 返回处理后的结果
	 */
	public static String removeEnd(String str, String remove) {
		return StringUtils.removeEnd(str, remove);
	}

	/**
	 * 去掉字符串str中所有包含remove的部分，然后返回
	 * 
	 * @param str
	 * @param remove
	 * @return 返回处理后的结果
	 */
	public static String remove(String str, String remove) {
		return StringUtils.remove(str, remove);
	}

	/**
	 * 去掉字符串str中所有包含remove的部分，然后返回
	 * 
	 * @param str
	 * @param remove
	 * @return 返回处理后的结果
	 */
	public static String remove(String str, char remove) {
		return StringUtils.remove(str, remove);
	}

	/**
	 * 在字符串text中用with代替repl，仅一次
	 * 
	 * @param text
	 * @param repl
	 * @param with
	 * @return 返回处理后的结果
	 */
	public static String replaceOnce(String text, String repl, String with) {
		return StringUtils.replaceOnce(text, repl, with);
	}

	/**
	 * 在字符串text中用with代替repl，替换所有
	 * 
	 * @param text
	 * @param repl
	 * @param with
	 * @return 返回处理后的结果
	 */
	public static String replace(String text, String repl, String with) {
		return StringUtils.replace(text, repl, with);
	}

	/**
	 * 在字符串text中用with代替repl，max为最大替换次数
	 * 
	 * @param text
	 * @param repl
	 * @param with
	 * @param max
	 * @return 返回处理后的结果
	 */
	public static String replace(String text, String repl, String with, int max) {
		return StringUtils.replace(text, repl, with, max);
	}

	/**
	 * 在字符串str中用字符replaceChar代替所有字符searchChar，如果字符串为null或""，则返回它本身
	 * 
	 * @param str
	 * @param searchChar
	 * @param replaceChar
	 * @return 返回处理后的结果
	 */
	public static String replaceChars(String str, char searchChar, char replaceChar) {
		return StringUtils.replaceChars(str, searchChar, replaceChar);
	}

	/**
	 * 用replaceChars代替str中的searchChars
	 * 
	 * @param str
	 * @param searchChars
	 * @param replaceChars
	 * @return 返回处理后的结果
	 */
	public static String replaceChars(String str, String searchChars, String replaceChars) {
		return StringUtils.replaceChars(str, searchChars, replaceChars);
	}

	/**
	 * 用字符串overlay覆盖字符串str从start到end之间的串
	 * 
	 * @param str
	 * @param overlay
	 * @param start
	 * @param end
	 * @return 返回处理后的结果
	 */
	public static String overlay(String str, String overlay, int start, int end) {
		return StringUtils.overlay(str, overlay, start, end);
	}

	/**
	 * 去掉字符串str的最后一个字符
	 * 
	 * @param str
	 * @return 返回处理后的结果
	 */
	public static String chomp(String str) {
		return StringUtils.chomp(str);
	}

	/**
	 * 重复字符串repeat次，组合成一个新串返回
	 * 
	 * @param str
	 * @param separator
	 * @return 返回处理后的结果
	 */
	public static String chomp(String str, String separator) {
		return StringUtils.chomp(str, separator);
	}

	/**
	 * 去掉字符串str的最后一个字符
	 * 
	 * @param str
	 * @return 返回处理后的结果
	 */
	public static String chop(String str) {
		return StringUtils.chop(str);
	}

	/**
	 * 重复字符串repeat次，组合成一个新串返回
	 * 
	 * @param str
	 * @param repeat
	 * @return 返回处理后的结果
	 */
	public static String repeat(String str, int repeat) {
		return StringUtils.repeat(str, repeat);
	}

	/**
	 * 如果字符串长度小于size，则在右边补空格使其长度等于size，然后返回如果字符串长度大于等于size， 则返回它本身
	 * 
	 * @param str
	 * @param size
	 * @return 返回处理后的结果
	 */
	public static String rightPad(String str, int size) {
		return StringUtils.rightPad(str, size);
	}

	/**
	 * 如果字符串长度小于size，则在右边补空格使其长度等于size，然后返回如果字符串长度大于等于size， 则返回它本身
	 * 
	 * @param str
	 * @param size
	 * @param padChar
	 * @return 返回处理后的结果
	 */
	public static String rightPad(String str, int size, char padChar) {
		return StringUtils.rightPad(str, size, padChar);
	}

	/**
	 * 如果字符串长度小于size，则在右边补空格使其长度等于size，然后返回如果字符串长度大于等于size， 则返回它本身
	 * 
	 * @param str
	 * @param size
	 * @param padStr
	 * @return 返回处理后的结果
	 */
	public static String rightPad(String str, int size, String padStr) {
		return StringUtils.rightPad(str, size, padStr);
	}

	/**
	 * 如果字符串长度小于size，则在右边补空格使其长度等于size，然后返回如果字符串长度大于等于size， 则返回它本身
	 * 
	 * @param str
	 * @param size
	 * @return 返回处理后的结果
	 */
	public static String leftPad(String str, int size) {
		return StringUtils.leftPad(str, size);
	}

	/**
	 * 如果字符串长度小于size，则在右边补空格使其长度等于size，然后返回如果字符串长度大于等于size， 则返回它本身
	 * 
	 * @param str
	 * @param size
	 * @param padChar
	 * @return 返回处理后的结果
	 */
	public static String leftPad(String str, int size, char padChar) {
		return StringUtils.leftPad(str, size, padChar);
	}

	/**
	 * 如果字符串长度小于size，则在右边补空格使其长度等于size，然后返回如果字符串长度大于等于size， 则返回它本身
	 * 
	 * @param str
	 * @param size
	 * @param padStr
	 * @return 返回处理后的结果
	 */
	public static String leftPad(String str, int size, String padStr) {
		return StringUtils.leftPad(str, size, padStr);
	}

	/**
	 * 产生一个字符串返回，该字符串长度等于size，str位于新串的中心，其他位置补空格
	 * 
	 * @param str
	 * @param size
	 * @return 返回处理后的结果
	 */
	public static String center(String str, int size) {
		return StringUtils.center(str, size);
	}

	/**
	 * 产生一个字符串返回，该字符串长度等于size，str位于新串的中心，其他位置补空格
	 * 
	 * @param str
	 * @param size
	 * @param padChar
	 * @return 返回处理后的结果
	 */
	public static String center(String str, int size, char padChar) {
		return StringUtils.center(str, size, padChar);
	}

	/**
	 * 产生一个字符串返回，该字符串长度等于size，str位于新串的中心，其他位置补空格
	 * 
	 * @param str
	 * @param size
	 * @param padStr
	 * @return 返回处理后的结果
	 */
	public static String center(String str, int size, String padStr) {
		return StringUtils.center(str, size, padStr);
	}

	/**
	 * 转换成英文大写
	 * 
	 * @param str
	 * @return 返回处理后的结果
	 */
	public static String upperCase(String str) {
		return StringUtils.upperCase(str);
	}

	/**
	 * 转换成英文小写
	 * 
	 * @param str
	 * @return 返回处理后的结果
	 */
	public static String lowerCase(String str) {
		return StringUtils.lowerCase(str);
	}

	/**
	 * 转换第一个字符为大写，如何第一个字符是大写原始返回
	 * 
	 * @param str
	 * @return 返回处理后的结果
	 */
	public static String capitalize(String str) {
		return StringUtils.capitalize(str);
	}

	/**
	 * 转换第一个字符为大写.如何第一个字符是大写原始返回
	 * 
	 * @param str
	 * @return 返回处理后的结果
	 */
	public static String uncapitalize(String str) {
		return StringUtils.uncapitalize(str);
	}

	/**
	 * 把字符串中的字符大写转换为小写，小写转换为大写
	 * 
	 * @param str
	 * @return 返回处理后的结果
	 */
	public static String swapCase(String str) {
		return StringUtils.swapCase(str);
	}

	/**
	 * 计算字符串sub在字符串str中出现的次数
	 * 
	 * @param str
	 * @param sub
	 * @return 返回处理后的结果
	 */
	public static int countMatches(String str, String sub) {
		return StringUtils.countMatches(str, sub);
	}

	/**
	 * 检查是否CharSequence的只包含Unicode的字母
	 * 
	 * @param str
	 * @return 返回处理后的结果
	 */
	public static boolean isAlpha(String str) {
		return StringUtils.isAlpha(str);
	}

	/**
	 * 检查是否只包含Unicode的CharSequence的字母和空格（''）
	 * 
	 * @param str
	 * @return 返回处理后的结果
	 */
	public static boolean isAlphaSpace(String str) {
		return StringUtils.isAlphaSpace(str);
	}

	/**
	 * 检查是否只包含Unicode的CharSequence的字母或数字
	 * 
	 * @param str
	 * @return 返回处理后的结果
	 */
	public static boolean isAlphanumeric(String str) {
		return StringUtils.isAlphanumeric(str);
	}

	/**
	 * 如果检查的Unicode CharSequence的只包含字母，数字或空格（''）
	 * 
	 * @param str
	 * @return 返回处理后的结果
	 */
	public static boolean isAlphanumericSpace(String str) {
		return StringUtils.isAlphanumericSpace(str);
	}

	/**
	 * 检查是否只包含ASCII可CharSequence的字符
	 * 
	 * @param str
	 * @return 返回处理后的结果
	 */
	public static boolean isAsciiPrintable(String str) {
		return StringUtils.isAsciiPrintable(str);
	}

	/**
	 * 检查是否只包含数值
	 * 
	 * @param str
	 * @return 返回处理后的结果
	 */
	public static boolean isNumeric(String str) {
		return StringUtils.isNumeric(str);
	}

	/**
	 * 检查是否只包含数值或者空格
	 * 
	 * @param str
	 * @return 返回处理后的结果
	 */
	public static boolean isNumericSpace(String str) {
		return StringUtils.isNumericSpace(str);
	}

	/**
	 * 检查是否只是str
	 * 
	 * @param str
	 * @return 返回处理后的结果
	 */
	public static boolean isWhitespace(String str) {
		return StringUtils.isWhitespace(str);
	}

	/**
	 * 将str转换为 ""
	 * 
	 * @param str
	 * @return 返回处理后的结果
	 */
	public static String defaultString(String str) {
		return StringUtils.defaultString(str);
	}

	/**
	 * 仅当字符串为Null时 转换为指定的字符串(参数2)
	 * 
	 * @param str
	 * @param defaultStr
	 * @return 返回处理后的结果
	 */
	public static String defaultString(String str, String defaultStr) {
		return StringUtils.defaultString(str, defaultStr);
	}

	/**
	 * 根据特定字符(参数2)分隔进行反转
	 * 
	 * @param str
	 * @param defaultStr
	 * @return 返回处理后的结果
	 */
	public static String defaultIfEmpty(String str, String defaultStr) {
		return StringUtils.defaultIfEmpty(str, defaultStr);
	}

	/**
	 * 将字符串倒序排列
	 * 
	 * @param str
	 * @return 返回处理后的结果
	 */
	public static String reverse(String str) {
		return StringUtils.reverse(str);
	}

	/**
	 * 根据特定字符(参数2)分隔进行反转
	 * 
	 * @param str
	 * @param separatorChar
	 * @return 返回处理后的结果
	 */
	public static String reverseDelimited(String str, char separatorChar) {
		return StringUtils.reverseDelimited(str, separatorChar);
	}

	/**
	 * 只显示指定数量(参数2)的字符
	 * 
	 * @param str
	 * @param maxWidth
	 * @return 返回处理后的结果
	 */
	public static String abbreviate(String str, int maxWidth) {
		return StringUtils.abbreviate(str, maxWidth);
	}

	/**
	 * 只显示指定数量(参数2)的字符
	 * 
	 * @param str
	 * @param offset
	 * @param maxWidth
	 * @return 返回处理后的结果
	 */
	public static String abbreviate(String str, int offset, int maxWidth) {
		return StringUtils.abbreviate(str, offset, maxWidth);
	}

	/**
	 * 去掉参数2字符串中在参数1里开头部分共有的部分
	 * 
	 * @param str1
	 * @param str2
	 * @return 返回处理后的结果
	 */
	public static String difference(String str1, String str2) {
		return StringUtils.difference(str1, str2);
	}

	/**
	 * 统计两个字符串开始部分共有的字符个数
	 * 
	 * @param str1
	 * @param str2
	 * @return 返回处理后的结果
	 */
	public static int indexOfDifference(String str1, String str2) {
		return StringUtils.indexOfDifference(str1, str2);
	}

	/**
	 * 统计参数1里的每个字符与参数2里每个字符不同部分的字符个数
	 * 
	 * @param s
	 * @param t
	 * @return 返回处理后的结果
	 */
	public static int getLevenshteinDistance(String s, String t) {
		return StringUtils.getLevenshteinDistance(s, t);
	}

	/**
	 * 布尔转换字符口串
	 * 
	 * @param value
	 * @return 返回处理后的结果
	 */
	public static String booleanToString(boolean value) {
		return value == true ? "1" : "0";
	}

	/**
	 * 布尔转换字符口串
	 * 
	 * @param value
	 * @return 返回处理后的结果
	 */
	public static String booleanToString(Object value) {
		return value == null || (Boolean) value == false ? "0" : "1";
	}

	/**
	 * 数字转换布尔
	 * 
	 * @param value
	 * @return 返回数字型
	 */
	public static boolean IntegerToBoolean(Integer value) {
		return value == null || value == 0 ? false : true;
	}

	/**
	 * SHA1加密
	 * 
	 * @param decript
	 * @return
	 */
	public static String SHA(String decript) {
		try {
			MessageDigest digest = java.security.MessageDigest.getInstance("SHA");
			digest.update(decript.getBytes());
			byte messageDigest[] = digest.digest();
			// Create Hex String
			StringBuffer hexString = new StringBuffer();
			// 字节数组转换为 十六进制 数
			for (int i = 0; i < messageDigest.length; i++) {
				String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexString.append(0);
				}
				hexString.append(shaHex);
			}
			return hexString.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}

}
