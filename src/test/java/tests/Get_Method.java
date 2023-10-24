package tests;
import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import core.BaseClass;
import io.restassured.response.Response;

@Listeners(utils.Listeners.class)
public class Get_Method extends BaseClass{
	
	static String user_id = "/cus_Ooa2CL5gYThUL1qq";

	@BeforeTest
	public void beforeTest() {
		
		
		logger.info("it is before test");
	}
	@Test
	public void getAllUsers() {
		
	Response response = given().auth().basic(secret_key, "").get(BaseClass.get_AllUsers());
		
		response.prettyPeek();
		logger.info("it is json response");
	}
	
	@Test
	public void getSingleUser() {
	Response response = given().auth().basic(secret_key, "").get(BaseClass.get_SingleUser()+"/cus_Ooa2CL5gYThUL1qq");
		
	response.prettyPrint();
	
	}

}
