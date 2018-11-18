package com.w2a.RestAssuredAPIBatch2.Rough;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.lang.reflect.Method;

import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.w2a.RestAssuredAPIBatch2.TestUtils.ConfigProperties;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class TestClass {

	public static ConfigProperties configProperty; 
	@BeforeMethod
	public void beforeMethod(Method method)
	{
		System.out.println("Method Name-->"+method.getName());
		ConfigFactory.setProperty("enviroment", "stage");
		configProperty = ConfigFactory.create(ConfigProperties.class);
		System.out.println(configProperty.getBaseURI());
		System.out.println(configProperty.getBasePath());
		
		RestAssured.baseURI=configProperty.getBaseURI();
		RestAssured.basePath=configProperty.getBasePath();
	}
	
	@Test
	public void useBaseURI()
	{
		Response res=given().auth().basic("sk_test_kzxPb2wjsBPiIh7QxZKqJU3a", "").get("customers/cus_DeMcLi6a0ci6tD").then().extract().response();
		System.out.println(res.asString());
	}
	
	@Test
	public void verifyCreateCustomerAPI(String userName,String password,String email,String address)
	{
		
	}

}
