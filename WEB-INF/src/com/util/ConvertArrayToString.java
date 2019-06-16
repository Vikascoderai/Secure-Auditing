package com.util;

public class ConvertArrayToString {

	public static String convertToString(String[] array) {
		
		StringBuffer sb = new StringBuffer();
		int arrlen = array.length;
		if (arrlen != 0 && arrlen != 1) {
			int i = 0;
			for (String x : array) {
				if (i != arrlen) {
					sb.append(x + ",");
				} else {
					sb.append(x);
				}
				i++;
			}
		} else if(arrlen == 1){
			sb.append(array[0]);
		}
		return sb.toString();
	}
}
