package com.restAssured.users;

import static io.restassured.RestAssured.given;
import com.restAssured.common.*;
import io.restassured.response.Response;

/**
 * @author Anvarit.Raman
 *
 */
public class UserController {
		
	BaseClass base;
	//Authorization auth;
    private static UserController single_instance = null;    //Singleton var

    //Singleton code
    private UserController() {
        base = BaseClass.getInstance();
        //auth = Authorization.getInstance();      
    }

    public static UserController getInstance() {
        if (single_instance == null)
            single_instance = new UserController();
        return single_instance;
    }
    
    
    //This method is used to post user
    public Response postUser(String jsonBody) throws Exception {
		base.LOGGER.info("\n\n *********In " + new Object() {}.getClass().getEnclosingMethod().getName() + " Function *********\\n\\n");
		Response response = given()
				.header(RestApiUri.ContentType, "application/json")
				.body(jsonBody).log().ifValidationFails()
				.post(RestApiUri.createUser);
		return response;
	}
    
  //This method edits a user
    public Response putUser(String jsonBody, String userName) throws Exception {
		base.LOGGER.info("\n\n *********In " + new Object() {}.getClass().getEnclosingMethod().getName() + " Function *********\\n\\n");
		Response response = given()
				.header(RestApiUri.ContentType, "application/json")
				.body(jsonBody).log().ifValidationFails()
				.put(RestApiUri.editUser + userName);
		return response;
	}

  //This method gets a user
    public Response getUser(String userName) throws Exception {
		base.LOGGER.info("\n\n *********In " + new Object() {}.getClass().getEnclosingMethod().getName() + " Function *********\\n\\n");
		Response response = given()
				.header(RestApiUri.ContentType, "application/json")
				.get(RestApiUri.editUser + userName);
		return response;
	}
  
}
