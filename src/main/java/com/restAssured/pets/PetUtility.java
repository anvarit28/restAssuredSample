package com.restAssured.pets;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Random;
import java.util.regex.Pattern;
import org.apache.commons.io.IOUtils;

public class PetUtility {
	
	// This method is used to generate user Json Body
	public static String generatePetJson(String jsonFilePath, String id, String categoryId, String categoryName, String petName, String photoUrls1, String photoUrls2,
			String tagsId1, String tagsName1, String status) throws IOException {
		
		String requestJsonPath = Paths.get(jsonFilePath).toString();
		FileInputStream fis = new FileInputStream(requestJsonPath);
		String requestContents = IOUtils.toString(fis, StandardCharsets.UTF_8);
		requestContents = requestContents.replaceAll(Pattern.quote("idValue"), id);
		requestContents = requestContents.replaceAll(Pattern.quote("categoryIdValue"), categoryId);
		requestContents = requestContents.replaceAll(Pattern.quote("categoryNameValue"), categoryName);
		requestContents = requestContents.replaceAll(Pattern.quote("petNameValue"), petName);
		requestContents = requestContents.replaceAll(Pattern.quote("photoUrls1Value"), photoUrls1);
		requestContents = requestContents.replaceAll(Pattern.quote("photoUrls2Value"), photoUrls2);
		requestContents = requestContents.replaceAll(Pattern.quote("tagsId1Value"), tagsId1);
		requestContents = requestContents.replaceAll(Pattern.quote("tagsName1Value"), tagsName1);
		requestContents = requestContents.replaceAll(Pattern.quote("statusValue"), status);
		return requestContents;	
	}
	

}
