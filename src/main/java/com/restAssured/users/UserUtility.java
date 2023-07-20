package com.restAssured.users;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Random;
import java.util.regex.Pattern;
import org.apache.commons.io.IOUtils;

public class UserUtility {
	
	// This method is used to generate user Json Body
	public static String generateUserJson(String jsonFilePath, String id, String userName, String firstName, String lastName, String userEmail, String userPassword, String phoneNumber, String status) throws IOException {
		
		String requestJsonPath = Paths.get(jsonFilePath).toString();
		FileInputStream fis = new FileInputStream(requestJsonPath);
		String requestContents = IOUtils.toString(fis, StandardCharsets.UTF_8);
		requestContents = requestContents.replaceAll(Pattern.quote("idValue"), id);
		requestContents = requestContents.replaceAll(Pattern.quote("nameValue"), userName);
		requestContents = requestContents.replaceAll(Pattern.quote("firstNameValue"), firstName);
		requestContents = requestContents.replaceAll(Pattern.quote("lastNameValue"), lastName);
		requestContents = requestContents.replaceAll(Pattern.quote("emailValue"), userEmail);
		requestContents = requestContents.replaceAll(Pattern.quote("passwordValue"), userPassword);
		requestContents = requestContents.replaceAll(Pattern.quote("phoneValue"), phoneNumber);
		requestContents = requestContents.replaceAll(Pattern.quote("statusValue"), status);
		return requestContents;	
	}
	
	private static long generateRandomNumber(int digits, Random random) {
        long min = (long) Math.pow(10, digits - 1);
        long max = (long) Math.pow(10, digits) - 1;
        return random.nextInt((int) (max - min + 1)) + min;
    } 
	
	public static String generateRandomNumber(int n) {
		Random random = new Random();
        long randomNumber = generateRandomNumber(n, random);
        String numberAsString = String.valueOf(randomNumber);
        
        return numberAsString;
	}

}
