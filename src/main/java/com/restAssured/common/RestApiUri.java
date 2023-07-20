package com.restAssured.common;
/**
 * @author Anvarit Raman
 * This class has placeholder for all rest uris. 
 */

public class RestApiUri {
	
	public static final String ContentType = "Content-Type";
	public static final String ContentTypeJson = "application/json";
	public static final String ContentTypeTextPlain = "text/plain";
	public static final String Authorization="Authorization";
	public static final String AuthorizationHeader="Bearer ";
	public static final String ContentTypeMultipartFormdata = "multipart/form-data";
	
	//Users Endpoints	
	public static final String createUser = " /user/createWithArray";
	public static final String editUser = " /user/";
	
	

	//Pet Endpoints
	public static final String createPet = "/pet";
	public static final String getPet = "/pet/findByStatus";
			
	
	private static RestApiUri single_instance = null;
	private RestApiUri() 
    { 
		 
    }
	public static RestApiUri getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new RestApiUri(); 
        return single_instance; 
    }	
}
