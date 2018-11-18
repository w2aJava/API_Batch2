package com.w2a.RestAssuredAPIBatch2.Rough;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;

public class PassJsonAsBody {
	
	public static void main(String[] args) {
		
			Map<String,String> map= new HashMap<String,String>();
			map.put("name", "Rahul");
			map.put("job","API Automation Trainer");
			
			Response response=given().body(map).when().post("https://reqres.in/api/users").then().extract().response();
		   response.prettyPrint();
		
	}

}
