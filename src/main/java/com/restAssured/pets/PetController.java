package com.restAssured.pets;

import static io.restassured.RestAssured.given;
import com.restAssured.common.*;
import io.restassured.response.Response;

/**
 * @author Anvarit.Raman
 *
 */
public class PetController {
		
	BaseClass base;
	
    private static PetController single_instance = null;    //Singleton var

    //Singleton code
    private PetController() {
        base = BaseClass.getInstance();
        //auth = Authorization.getInstance();      
    }

    public static PetController getInstance() {
        if (single_instance == null)
            single_instance = new PetController();
        return single_instance;
    }
    
    
    //This method is used to post user
    public Response postPet(String jsonBody) throws Exception {
		base.LOGGER.info("\n\n *********In " + new Object() {}.getClass().getEnclosingMethod().getName() + " Function *********\n\n");
		Response response = given()
				.header(RestApiUri.ContentType, "application/json")
				.body(jsonBody).log().ifValidationFails()
				.post(RestApiUri.createPet);
		return response;
	}
    
  //This method edits a user
    public Response putPet(String jsonBody) throws Exception {
		base.LOGGER.info("\n\n *********In " + new Object() {}.getClass().getEnclosingMethod().getName() + " Function *********\\n\\n");
		Response response = given()
				.header(RestApiUri.ContentType, "application/json")
				.body(jsonBody).log().ifValidationFails()
				.put(RestApiUri.createPet);
		return response;
	}

  //This method gets a pet based on status
    public Response getPet(String statusToSearch) throws Exception {
		base.LOGGER.info("\n\n *********In " + new Object() {}.getClass().getEnclosingMethod().getName() + " Function *********\\n\\n");
		Response response = given()
				.header(RestApiUri.ContentType, "application/json").log().ifValidationFails().queryParam("status", statusToSearch)
				.get(RestApiUri.getPet);
		return response;
	}
  
}
