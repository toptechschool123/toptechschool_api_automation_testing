package http_methods;
import static io.restassured.RestAssured.given;

import org.junit.Ignore;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class Put_Post_methods {
	static String basic_auth = "sk_test_51MnoCzCG0XLhk2w9oaMABmQRLgcEsLaW6XrjdHCtRTwbxXB7mz55R1TZs8khqiykx6HzrPzlR2c5ap9J3qeShh5D009eT0AHpN";
	static String bearer_auth = "Bearer sk_test_51MnoCzCG0XLhk2w9oaMABmQRLgcEsLaW6XrjdHCtRTwbxXB7mz55R1TZs8khqiykx6HzrPzlR2c5ap9J3qeShh5D009eT0AHpN";
	static String user_id = "cus_Opgo6Tv0amMsVT";
							
	@Ignore
	@Test
	public void postUser() {
		
		given().auth().basic(basic_auth, "").
		param("description",  "engineering").
		param("email", "engineer@yahoo.com").
		param("name","engineer").
		post("https://api.stripe.com/v1/customers").
		then().statusCode(200).statusLine("HTTP/1.1 200 OK").log().all();

		
		
	}
	
	
	@Test
	public void updateUser() {
		Response response =	given().header("Authorization",bearer_auth ).
		param("email", "eng@yahoo.com").
		param("name","eng Tom").
		post("https://api.stripe.com/v1/customers/" + user_id);	
		
		response.prettyPrint();
		
	}
	
		
}
