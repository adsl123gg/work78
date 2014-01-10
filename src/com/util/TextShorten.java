package com.util;

public class TextShorten {

	public static String shorten(String text){
		if (text.length()>20) {
			text=text.substring(0,20);
			text+="...";
			return text;
		}else {
			return text;
		}
	}
}
