package tests_verification;
import static io.restassured.RestAssured.given;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;


public class JsonSchemaValidation {

	
	 public static String secret_key = "sk_test_51MnoCzCG0XLhk2w9oaMABmQRLgcEsLaW6XrjdHCtRTwbxXB7mz55R1TZs8khqiykx6HzrPzlR2c5ap9J3qeShh5D009eT0AHpN";
	
	
	
	 @Test
	 public void jsonSchemavalidation() throws FileNotFoundException {
		
		 FileInputStream jsonShema = new FileInputStream("C:\\Users\\T540p\\eclipse-workspace\\toptechschool_api_automation_testing\\src\\resource\\java\\test_data\\jsonSchema.json");
		 RestAssured.baseURI = "https://api.stripe.com";

		    //GET operation
		  given().auth().basic(secret_key, "").
		    when().get("/v1/customers/cus_OsJSEbiMbYXSgO").
		    then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonShema))
			.statusCode(200).log().all();

	
	
}
}