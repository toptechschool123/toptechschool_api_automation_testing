package http_methods;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.junit.Ignore;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.Customers;


public class PostRequests {
	 public static String secret_key = "sk_test_51MnoCzCG0XLhk2w9oaMABmQRLgcEsLaW6XrjdHCtRTwbxXB7mz55R1TZs8khqiykx6HzrPzlR2c5ap9J3qeShh5D009eT0AHpN";
	 public static String secret_key2 = "Bearer sk_test_51MnoCzCG0XLhk2w9oaMABmQRLgcEsLaW6XrjdHCtRTwbxXB7mz55R1TZs8khqiykx6HzrPzlR2c5ap9J3qeShh5D009eT0AHpN";
		
	// we create users in different ways: 1: using parameters 2: using json format. 
		
	
	 @Test
		public void createUser() {
		 
			 
			Response response = given().auth().basic(secret_key, "")
					.param("name", "Shah")
					.param("email", "Shah@toptechschool.us")
					.param("description", "shopkeeper")
					.when().post("https://api.stripe.com/v1/customers");
				
			response.prettyPeek();	
			
	 }
	 
	 @Ignore
		@Test            // create payload using Map/HashMap
		public void createUser_Map()	{
			
			Map<String, Object> map = new HashMap<String, Object>();
		
		
		
		
		map.put("name", "Shack");
		map.put("email", "Shack@toptechschool.us");
		map.put("description", "sdet");
		
		Response response = given().auth().basic(secret_key, "").contentType("application/x-www-form-urlencoded").
		params(map).
		post("https://api.stripe.com/v1/customers");
		
		//response.prettyPrint();
		response.prettyPeek();
		
		
		} 
	 @Ignore
		@Test
		public void createUser_JsonObjectClass() { 
			// we can also create payload using JSONOBJECT CLASS 
			
			JSONObject request = new JSONObject();


			request.put("Name", "Liza");
			request.put("Job", "Manual Software Tester");
			request.put("role", "Assistant lead");
			
			
			
					given().contentType(ContentType.JSON).
					body(request.toJSONString()).
					when().post("https://reqres.in/api/users").
					then().statusCode(201).log().all();
			
					
		}
		
	   @Ignore
		@Test   // create payload using json file
		public void createUser_jsonFile() {
			
			String filePath = ".\\src\\resource\\java\\test_data\\file.json";
			File file = new File(filePath);
			
					given().contentType(ContentType.JSON).body(file).
					when().post("https://reqres.in/api/users").
					then().statusCode(201).log().all();
		
		} 
		
	   @Ignore
		@Test    // pojo stands for plain old java object
		public void createUser_PojoClass() {
			
			Customers customers = new Customers("Kate", "kate@gmail.com", "seattle WA");
			
			
			Response response = given().contentType(ContentType.JSON).
					body(customers).
					when().post("https://reqres.in/api/users");
			
			
					
					
					
			response.prettyPrint();
			System.out.println(response.getStatusCode());
			
			
			
			
			
}}