package com.restAssured.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.RestAssured;

public class BaseClass{

	public String ApiBaseUri;
	private Properties prop;
	public Logger LOGGER;
	public static String serviceUrl;

	private static BaseClass single_instance = null;

	// BaseClass constructor
	private BaseClass() 
	{ 
		prop = new Properties();
		try {
			prop.load(new FileInputStream("configs/config.properties"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		LOGGER = LogManager.getLogger(BaseClass.class);

		//Get the commandline parameters
		//serviceUrl = System.getProperty("serviceUrl");
		serviceUrl = "https://petstore.swagger.io/v2";

		RestAssured.baseURI = serviceUrl;		

		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.useRelaxedHTTPSValidation();
		ApiBaseUri = RestAssured.baseURI;
	}

	public static BaseClass getInstance() 
	{ 
		if (single_instance == null) 
			single_instance = new BaseClass(); 

		return single_instance; 
	}
		

	public String getExecuteSecurityHeaderTests() {
		return prop.getProperty("executeSecurityHeaderTests");
	}

}
