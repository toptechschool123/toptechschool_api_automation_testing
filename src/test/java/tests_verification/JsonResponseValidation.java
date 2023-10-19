package tests_verification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matchers;
import org.junit.Ignore;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
public class JsonResponseValidation {

	
	static String basic_auth = "sk_test_51MnoCzCG0XLhk2w9oaMABmQRLgcEsLaW6XrjdHCtRTwbxXB7mz55R1TZs8khqiykx6HzrPzlR2c5ap9J3qeShh5D009eT0AHpN";
	static String user_id = "cus_On7ve5yUi6lgv7";
	
	@Ignore
	@Test
	public void validateJsonResposne() {
		
			 	given().auth().basic(basic_auth, "")
				.param("name","John")
				.param("address[line1]", "seattle WA")
				.param("description", "Fighter")
				.param("email", "Shakir@gmail.com")
				.when().post("https://api.stripe.com/v1/customers")
				
				.then().body("name", equalTo("John")).log().all();
			
	}
	@Ignore
	@Test
	public void validateJsonResponse2() {
		given().auth().basic(basic_auth, "").get("https://api.stripe.com/v1/customers/"+user_id)
		
		.then().body("email",equalTo ("Shaker@toptechschool.us")).log().all();
		
	}
	
	@Test
	public void validateJsonResponse3() {
		
		RestAssured.baseURI= "https://api.stripe.com";
		given().auth().basic(basic_auth, "").get("/v1/customers/"+user_id).then().log().all()
		
		.assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK")
		
		.body("name", Matchers.equalTo("Shaikh"), "email",Matchers.equalTo("Shaker@toptechschool.us"))
		
		.headers("Content-Type", "application/json0", "Connection", "keep-alive");
	}
	
	
}
