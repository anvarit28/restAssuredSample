package com.restAssured.pets_test;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.restAssured.common.Constants;
import com.restAssured.common.BaseClass;
import com.restAssured.pets.PetController;
import com.restAssured.pets.PetUtility;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

/**
 * @author Anvarit Raman
 *  This class contains test cases for users endpoint
 */

public class CreatePetTest 
{
	BaseClass base = BaseClass.getInstance();
	PetController pets = PetController.getInstance();

	private String petId = Constants.petId;
	private String categoryId = Constants.categoryId  + System.currentTimeMillis();
	private String categoryName = Constants.categoryName;
	private String petName = Constants.petName + System.currentTimeMillis();
	private String photoUrls1 = Constants.photoUrls1;
	private String photoUrls2 = Constants.photoUrls2;
	private String tagsId1 = Constants.tagsId1;
	private String tagsName1 = Constants.tagsName1;
	private String status = Constants.availableStatus;
	private String statusSold = Constants.soldStatus;
	
	//This test case creates a user
		@Test(enabled = true, priority=1, description="This test case creates a user")
		public void TC1_CreatePet() throws Exception {
			
			base.LOGGER.info("\n\n *********In " + new Object() {}.getClass().getEnclosingMethod().getName() + " Test *********\\n\\n");
			//Create User Json Body
			String postUserJsonBody = PetUtility.generatePetJson("resources/petData/postPet.json", petId, categoryId, categoryName, petName, photoUrls1, photoUrls2, tagsId1, tagsName1, status);
			
			//Post User
			Response response = pets.postPet(postUserJsonBody);
			Assert.assertEquals(response.getStatusCode(),Constants.STATUS_OK); //Validate status code
			
			//Validate response data
			Assert.assertEquals(response.jsonPath().get("id"), Integer.parseInt(petId));
			Assert.assertEquals(response.jsonPath().get("category.name"),categoryName);
				
		}
		
		@Test(enabled = true, priority=2, description="This test case creates a user with invalid userId")
		public void TC2_CreatePet_InvalidRequest() throws Exception {
			
			base.LOGGER.info("\n\n *********In " + new Object() {}.getClass().getEnclosingMethod().getName() + " Test *********\\n\\n");
			//Create User Json Body
			String postUserJsonBody = PetUtility.generatePetJson("resources/petData/postPet.json", petId, categoryId, categoryName, petName, photoUrls1, photoUrls2, "invalid1", tagsName1, status);
			
			//Post User
			Response response = pets.postPet(postUserJsonBody);
			Assert.assertEquals(response.getStatusCode(),Constants.STATUS_INTERNAL_SERVER_ERROR); //Validate status code
			
			//Validate response data
			Assert.assertEquals(response.jsonPath().get("message"),"something bad happened");
			Assert.assertEquals(response.jsonPath().get("code"),500);
				
		}
		
		
	
		@Test(enabled = true, priority=3, description="Update pet name and status")
		public void TC3_UpdatePet() throws Exception {
			
			base.LOGGER.info("\n\n *********In " + new Object() {}.getClass().getEnclosingMethod().getName() + " Test *********\\n\\n");
			//Create User Json Body
			String postUserJsonBody = PetUtility.generatePetJson("resources/petData/postPet.json", petId, categoryId, categoryName, petName+"_edit", photoUrls1, photoUrls2, tagsId1, tagsName1, statusSold);
			
			//Put Pet
			Response response = pets.putPet(postUserJsonBody);
			Assert.assertEquals(response.getStatusCode(),Constants.STATUS_OK); //Validate status code
			
			//Validate response data
			Assert.assertEquals(response.jsonPath().get("id"), Integer.parseInt(petId));
			Assert.assertEquals(response.jsonPath().get("category.name"),categoryName);
				
		}
		
		@Test(enabled = true, priority=4, description="Update invalid status")
		public void TC4_UpdatePetInvalidStatus() throws Exception {
			
			base.LOGGER.info("\n\n *********In " + new Object() {}.getClass().getEnclosingMethod().getName() + " Test *********\\n\\n");
			//Create User Json Body
			String postUserJsonBody = PetUtility.generatePetJson("resources/petData/postPet.json", petId, categoryId, categoryName, petName+"_edit", photoUrls1, photoUrls2, tagsId1, tagsName1, "InvalidStatus");
			
			//Put Pet
			Response response = pets.putPet(postUserJsonBody);
			Assert.assertEquals(response.getStatusCode(),Constants.STATUS_OK); //Validate status code
			
			//Validate response data
			Assert.assertEquals(response.jsonPath().get("id"), Integer.parseInt(petId));
			Assert.assertEquals(response.jsonPath().get("category.name"),categoryName);
				
		}
		
		@Test(enabled = true, priority=5, description="This test case gets available pets which is Not Found")
		public void TC5_GetPet() throws Exception {
			
			base.LOGGER.info("\n\n *********In " + new Object() {}.getClass().getEnclosingMethod().getName() + " Test *********\\n\\n");
			//Get Pet
			Response response = pets.getPet("available");
			Assert.assertEquals(response.getStatusCode(),Constants.STATUS_OK); //Validate status code
			
				
		}
		
		@Test(enabled = true, priority=5, description="This test case searches for an invalid status pets which returns 0 records")
		public void TC6_GetPet() throws Exception {
			
			base.LOGGER.info("\n\n *********In " + new Object() {}.getClass().getEnclosingMethod().getName() + " Test *********\\n\\n");
			//Get Pet
			Response response = pets.getPet("invalidStatus");
			Assert.assertEquals(response.getStatusCode(),Constants.STATUS_OK); //Validate status code
			Assert.assertEquals(response.getBody().asString().length(),2); // Validate that response body doesn't shows any record
			
				
		}
	
}
