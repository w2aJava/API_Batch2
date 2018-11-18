package com.w2a.RestAssuredAPIBatch2.StripeAPI;

import java.util.Hashtable;

import com.w2a.RestAssuredAPIBatch2.Setup.TestSetup;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CustomerAPI extends TestSetup {
	
	public static Response sendPostRequestToCreateCustomer(Hashtable<String, String> data)
	{
		Response response=setFormParams(data.get("arguments"), resquestSpecification).post(data.get("endpoint"))
		.then().extract().response();
		return response;
	}
	
	public static Response sendGetRequestToListAllCustomers(Hashtable<String, String> data)
	{
		Response response= resquestSpecification.get(data.get("endpoint"))
				.then().extract().response();
				return response;
		
	}
	public static Response sendDeleteMethodWithValidData(Hashtable<String, String> data)
	{
		Response response=resquestSpecification.delete(data.get("endpoint"))
				.then().extract().response();
		return response;
	}
	
	

}
