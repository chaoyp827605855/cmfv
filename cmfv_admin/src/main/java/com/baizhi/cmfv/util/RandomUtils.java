package com.baizhi.cmfv.util;

import java.util.Random;

public class RandomUtils {
	
	public static String randomSalt(int num){
		Random random = new Random();
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		char[] ch = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num; i++) {
			sb.append(ch[random.nextInt(ch.length)]);
		}
		return sb.toString();
	}
}
