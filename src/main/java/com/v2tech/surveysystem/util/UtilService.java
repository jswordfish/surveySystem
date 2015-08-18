package com.v2tech.surveysystem.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class UtilService {
private static Properties props = new Properties();	
	static{
		try {
			FileInputStream fis = new FileInputStream("surveySystem.properties");
			props.load(fis);
		} catch (FileNotFoundException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public static String getValue(String key){
		return props.getProperty(key);
	}

}
