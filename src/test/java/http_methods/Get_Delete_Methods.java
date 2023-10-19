package http_methods;
import static io.restassured.RestAssured.given;

import org.junit.Ignore;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class Get_Delete_Methods {
	static String basic_auth = "sk_test_51MnoCzCG0XLhk2w9oaMABmQRLgcEsLaW6XrjdHCtRTwbxXB7mz55R1TZs8khqiykx6HzrPzlR2c5ap9J3qeShh5D009eT0AHpN";
	static String user_id = "cus_Ooa2CL5gYThUL1";
	@Ignore
	@Test
	public void getAllUsers() {
		
	Response response = given().auth().basic(basic_auth, "").when().get("https://api.stripe.com/v1/customers");
		
		response.prettyPeek();
		response.prettyPrint();
	}
	@Ignore
	@Test
	public void getSingleUser() {
		
		given().auth().basic(basic_auth, "").get("https://api.stripe.com/v1/customers/" +user_id).then().statusCode(200).log().all();
		
	}
	
	@Test
	public void deleteUser() {
		
		given().auth().basic(basic_auth, "").delete("https://api.stripe.com/v1/customers/" + user_id).then().statusCode(200).log().everything();
	}
	
	
	

}
