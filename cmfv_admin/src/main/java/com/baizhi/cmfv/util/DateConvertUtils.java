package com.baizhi.cmfv.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 日期与字符串转换的工具类
 */
public class DateConvertUtils {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	//字符串转utilDate
	public static java.util.Date toUtilDate(String source){
		try {
			return sdf.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	//utilDate转sqlDate
	public static java.sql.Date toSqlDate(java.util.Date utilDate){
		return new java.sql.Date(utilDate.getTime());
	}

	//将任何一种日期类型进行格式化
	public static String toString(java.util.Date date){//java.sql.Date
		return sdf.format(date);
	}
	
}
