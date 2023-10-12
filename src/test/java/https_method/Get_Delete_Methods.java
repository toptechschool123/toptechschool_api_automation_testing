package https_method;
import static io.restassured.RestAssured.given;

import org.junit.Ignore;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class Get_Delete_Methods {
	static String basic_auth = "sk_test_51MnoCzCG0XLhk2w9oaMABmQRLgcEsLaW6XrjdHCtRTwbxXB7mz55R1TZs8khqiykx6HzrPzlR2c5ap9J3qeShh5D009eT0AHpN";
	
	@Ignore
	@Test
	public void getAllUsers() {
		
	Response response = given().auth().basic(basic_auth, "").when().get("https://api.stripe.com/v1/customers");
		
		response.prettyPeek();
	}
	
	@Test
	public void getSingleUser() {
		
		given().auth().basic(basic_auth, "").get("https://api.stripe.com/v1/customers/cus_OnNtYWKE44VDjR").then().statusCode(200).log().all();
		
	}
	

}
