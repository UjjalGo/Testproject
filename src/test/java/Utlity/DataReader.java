package Utlity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;

public  class DataReader {
	private static Properties prop;
//	private String projectPath=System.getProperty("user.dir");

	private String filePath="Data//config.properties";
	FileInputStream fs;
	
public DataReader() throws IOException{
//	System.out.println("Project Path is:"+projectPath);
	prop=new Properties();
	
		fs=new FileInputStream(filePath);
	prop.load(fs);	
	
	
}
public  String getUrl(){
	 String url = prop.getProperty("url");
	 if(url!= null) return url;
	 else throw new RuntimeException("url not specified in the config.properties file."); 
	 }
public String getUsername(){
	String username = prop.getProperty("username");
	 if(username!= null) return username;
	 else throw new RuntimeException("location not specified in the config.properties file."); 
	 }
public String getPassword(){
	String password = prop.getProperty("password");
	 if(password!= null) return password;
	 else throw new RuntimeException("location not specified in the config.properties file."); 
	 }	
public static String getNote(){
	String generatedName=RandomStringUtils.randomAlphabetic(10);
	return generatedName;
}

public static String getAnalysisType(){
	String analysisType=prop.getProperty("analysistype");
	return analysisType;
}

public  String getSubject(){
	String subject=prop.getProperty("subject");
	return subject;
}
public  String getBody(){
	String body=prop.getProperty("subject");
	return body;
}
public  String getLabel(){
	String label=prop.getProperty("label");
	return label;
}
}


