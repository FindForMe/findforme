package com.ffm.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	private static final String ABS_PATH = "E:\\dream\\project\\findforme\\ffm\\src\\main\\webapp\\assets\\img\\";
	private static String REAL_PATH = null;
	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);
	
	public static boolean uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		
		//Get the server realPath 
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/img/");
		logger.info(REAL_PATH);
		
		//Create the directory if not exists
		if(!new File(REAL_PATH).exists()) {
			 new File(REAL_PATH).mkdirs();
		}
		if(!new File(ABS_PATH).exists()) {
			new File(ABS_PATH).mkdirs();
		}
		try {
			//Transfer both file to Location
			file.transferTo(new File(REAL_PATH + code + ".jpg"));
			file.transferTo(new File(ABS_PATH + code + ".jpg"));
			return true;

		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public static boolean uploadProfilePicture(HttpServletRequest request, MultipartFile file, String code) {
		//Get the server real Path
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/img");
		logger.info(REAL_PATH);
		
		//Create the directory if not exists
		if(!new File(REAL_PATH).exists()) {
			new File(REAL_PATH).mkdirs();
		}
		if(!new File(ABS_PATH).exists()) {
			new File(ABS_PATH).mkdirs();
		}
		try {
			//Transer both file to location
			file.transferTo(new File(REAL_PATH+code+".jpg"));
			file.transferTo(new File(ABS_PATH+code+".jpg"));
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
