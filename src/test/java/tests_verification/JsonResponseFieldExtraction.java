package tests_verification;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonResponseFieldExtraction {
	 public static String secret_key = "sk_test_51MnoCzCG0XLhk2w9oaMABmQRLgcEsLaW6XrjdHCtRTwbxXB7mz55R1TZs8khqiykx6HzrPzlR2c5ap9J3qeShh5D009eT0AHpN";
	 public static String secret_key2 = "Bearer sk_test_51MnoCzCG0XLhk2w9oaMABmQRLgcEsLaW6XrjdHCtRTwbxXB7mz55R1TZs8khqiykx6HzrPzlR2c5ap9J3qeShh5D009eT0AHpN";
		
	

	 @Test
		public void createUser() {
		 
			 
			Response response = given().auth().basic(secret_key, "")
					.param("name","John")
					.param("address[line1]", "seattle WA")
					.param("description", "Fighter")
					.param("email", "Shakir@gmail.com")
					.when().post("https://api.stripe.com/v1/customers");
				
			response.prettyPeek();
			
			// json path clas is used to extract the value of each json field.
		JsonPath path = response.jsonPath();
			
	//	System.out.println(" customer name is " + path.get("name"));
	//	System.out.println("customer id is " + path.get("id"));
	//	System.out.println("customer email is " + path.get("email"));
		
	
	  System.out.println("customer name is " +response.jsonPath().getString("name"));
	  System.out.println("customer id is " + response.jsonPath().getString("id"));
	  System.out.println(" customer email is " + response.jsonPath().getString("email"));
	  System.out.println("customer address is " + response.jsonPath().getString("address.line1"));
	  System.out.println("customer is created at  " + response.jsonPath().getString("created"));
	 
	 }
			
}