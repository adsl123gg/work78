package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
	
	public static String getTime(){
		 Date today=new Date();
		 SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
		 String time=f.format(today);
		 return time;
	}
}
