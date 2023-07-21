package com.restAssured.users_test;

//import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.restAssured.common.Constants;
import com.restAssured.common.BaseClass;
import com.restAssured.users.UserController;
import com.restAssured.users.UserUtility;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

/**
 * @author Anvarit Raman
 *  This class contains test cases for users endpoint
 */

public class CreateUsersTest 
{
	BaseClass base = BaseClass.getInstance();
	UserController users = UserController.getInstance();

	private String userId = Constants.userId;
	private String userName = Constants.userName  + System.currentTimeMillis();;
	private String firstName = Constants.firstName;
	private String lastName = Constants.lastName;
	private String userEmail = Constants.userEmail;
	private String userPassword = Constants.userPassword;
	private String phoneNumber = Constants.phoneNumber;
	private String status = Constants.zeroStatus;
	
	//This test case creates a user
		@Test(enabled = true, priority=1, description="This test case creates a user")
		public void TC1_CreateUser() throws Exception {
			
			base.LOGGER.info("\n\n *********In " + new Object() {}.getClass().getEnclosingMethod().getName() + " Test *********\\n\\n");
			//Create User Json Body
			String postUserJsonBody = UserUtility.generateUserJson("resources/usersData/postUser.json", userId, userName, firstName, lastName, userEmail, userPassword, phoneNumber, status);
			
			//Post User
			Response response = users.postUser(postUserJsonBody);
			//ResponseBody body = response.getBody();
			//System.out.println("Response Body is: " + body.asString());
			Assert.assertEquals(response.getStatusCode(),Constants.STATUS_OK); //Validate status code
			
			//Validate response data
			Assert.assertEquals(response.jsonPath().get("message"),"ok");
			//Assert.assertEquals(response.jsonPath().get("code"),200);
				
		}
		
		@Test(enabled = true, priority=2, description="This test case creates a user with invalid userId")
		public void TC2_CreateUser_InvalidRequest() throws Exception {
			
			base.LOGGER.info("\n\n *********In " + new Object() {}.getClass().getEnclosingMethod().getName() + " Test *********\\n\\n");
			//Create User Json Body
			String postUserJsonBody = UserUtility.generateUserJson("resources/usersData/postUser.json", "@!#@!", userName, firstName, lastName, userEmail, userPassword, phoneNumber, status);
			
			//Post User
			Response response = users.postUser(postUserJsonBody);
			Assert.assertEquals(response.getStatusCode(),Constants.STATUS_INTERNAL_SERVER_ERROR); //Validate status code
			
			//Validate response data
			Assert.assertEquals(response.jsonPath().get("message"),"something bad happened");
			//Assert.assertEquals(response.jsonPath().get("code"),500);
				
		}
		
		@Test(enabled = true, priority=3, description="This test case creates a user with null userId")
		public void TC3_CreateUser_NullValue() throws Exception {
			
			base.LOGGER.info("\n\n *********In " + new Object() {}.getClass().getEnclosingMethod().getName() + " Test *********\\n\\n");
			//Create User Json Body
			String postUserJsonBody = UserUtility.generateUserJson("resources/usersData/postUser.json", "", userName, firstName, lastName, userEmail, userPassword, phoneNumber, status);
			
			//Post User
			Response response = users.postUser(postUserJsonBody);
			Assert.assertEquals(response.getStatusCode(),Constants.STATUS_OK); //Validate status code
			
			//Validate response data
			Assert.assertEquals(response.jsonPath().get("message"),"ok");
			//Assert.assertEquals(response.jsonPath().get("code"),200);
				
		}
		
		//Update user
		@Test(enabled = true, priority=4, description="This test case creates a user")
		public void TC4_UpdateUser() throws Exception {
			
			base.LOGGER.info("\n\n *********In " + new Object() {}.getClass().getEnclosingMethod().getName() + " Test *********\\n\\n");
			//Create User Json Body
			String postUserJsonBody = UserUtility.generateUserJson("resources/usersData/putUser.json", userId, userName+"_edit", firstName, lastName, userEmail, userPassword, phoneNumber, status);
			
			//Post User
			Response response = users.putUser(postUserJsonBody, userName);
			Assert.assertEquals(response.getStatusCode(),Constants.STATUS_OK); //Validate status code
			
			//Validate response data
			Assert.assertEquals(response.jsonPath().get("message"),userId);
			//Assert.assertEquals(response.jsonPath().get("code"),200);
				
		}
		
		@Test(enabled = true, priority=5, description="This test case creates a user")
		public void TC5_UpdateUserInvalidUserName() throws Exception {
			
			base.LOGGER.info("\n\n *********In " + new Object() {}.getClass().getEnclosingMethod().getName() + " Test *********\\n\\n");
			//Create User Json Body
			String postUserJsonBody = UserUtility.generateUserJson("resources/usersData/putUser.json", userId, "@1#%^", firstName, lastName, userEmail, userPassword, phoneNumber, status);
			
			//Post User
			Response response = users.putUser(postUserJsonBody, userName);
			Assert.assertEquals(response.getStatusCode(),Constants.STATUS_OK); //Validate status code
			
			//Validate response data
			Assert.assertEquals(response.jsonPath().get("message"),userId);
			//Assert.assertEquals(response.jsonPath().get("code"),200);
				
		}
		
		@Test(enabled = true, priority=6, description="This test case creates a user")
		public void TC6_GetUser() throws Exception {
			
			base.LOGGER.info("\n\n *********In " + new Object() {}.getClass().getEnclosingMethod().getName() + " Test *********\\n\\n");
			
			//Get User
			Response response = users.getUser(userName);
			Assert.assertEquals(response.getStatusCode(),Constants.STATUS_OK); //Validate status code
			Assert.assertEquals(response.jsonPath().get("username"),userName);
				
		}
	
}
