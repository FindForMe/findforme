package com.ffm_backend.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

public class ffmUtil {
	
	public static String genRowID(int length) {
		
		/*Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i <= length; i++) {
			char c = (char)rand.nextInt((int)Character.MAX_VALUE);
			sb.append(c);
		}*/
		//return sb.toString();
		return UUID.randomUUID()
				.toString()
				.replace("-","")
				.substring(0,32);
	}
	
	public static String genRowID() {
		return UUID.randomUUID()
				.toString()
				.replace("-","") 
				.substring(0,32);
	}
	
	public static String genImageCode(String caller) {
		String code;
		
		switch(caller.toLowerCase()) {
		case "post" :
			code = "PST" + UUID.randomUUID().toString().substring(26).toUpperCase();
			break;
		case "user" :
			code = "USR" + UUID.randomUUID().toString().substring(26).toUpperCase();
			break;
		default :
			code = "DFT" + UUID.randomUUID().toString().substring(26).toUpperCase();
		}
		return code;
		
	}
	public static String genCurrDateTime() {
		
		/*Date date = new Date();
		DateFormat formate = new DateFormat();*/
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(Calendar.getInstance().getTime());
	}
	
	public static void main(String[] args) {
		System.out.println("row id : "+genRowID());
		System.out.println("date time : "+genCurrDateTime());
	}
	
}
