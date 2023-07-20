package com.restAssured.common;
import com.restAssured.users.UserUtility;

public class Constants {

    public static final int STATUS_OK=200;
    public static final int STATUS_CREATED=201;
    public static final int STATUS_NO_CONTENT=204;
    public static final int STATUS_BAD_REQUEST=400;
    public static final int STATUS_CONFLICT=409;
    public static final int STATUS_NOTFOUND=404;
    public static final int STATUS_INTERNAL_SERVER_ERROR=500;
    public static final String STATUS_MESSAGE_SUCCESS="SUCCESS";


    //Log formatting strings
    public static final String TC_START = "**** %s execution started ****\n";
    public static final String TC_END = "**** %s execution completed ****\n";
    
   
    //UserCreation properties
    public static final String userId = UserUtility.generateRandomNumber(7);
    public static final String userName = "AutoTest_" ;
    public static final String firstName = "rahul";
    public static final String lastName = "mehra";
    public static final String userEmail = "rahul.mehar@xyz.com";
    public static final String userPassword = "Password";
    public static final String phoneNumber = UserUtility.generateRandomNumber(10);
    public static final String zeroStatus = "0";
    
   //Pet Creation Properties
    public static final String petId = UserUtility.generateRandomNumber(5);
    public static final String categoryId = UserUtility.generateRandomNumber(1);
    public static final String categoryName = "Dog";
    public static final String petName = "Alfred";
    public static final String photoUrls1 = "http://demoUrl1.com";
    public static final String photoUrls2 = "http://demoUrl2.com";
    public static final String tagsId1 = UserUtility.generateRandomNumber(2);;
    public static final String tagsName1 = "tagName1";
    public static final String availableStatus = "available";
    public static final String pendingStatus = "pending";
    public static final String soldStatus = "sold";
	
    		



}
