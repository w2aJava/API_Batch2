package com.w2a.RestAssuredAPIBatch2.TestCases;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.w2a.RestAssuredAPIBatch2.POJOClasses.Customer;
import com.w2a.RestAssuredAPIBatch2.Setup.TestSetup;
import com.w2a.RestAssuredAPIBatch2.StripeAPI.CustomerAPI;
import com.w2a.RestAssuredAPIBatch2.TestUtils.DataProviderClass;
import com.w2a.RestAssuredAPIBatch2.TestUtils.TestUtils;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class VerifyCreateCustomerAPI extends TestSetup {

/*	@Test(dataProviderClass = DataProviderClass.class, dataProvider = "dp")
	public void verifyCreateCustomerAPI(Hashtable<String, String> data)
			throws JsonParseException, JsonMappingException, IOException {
		
		testLogger().assignAuthor("Rahul Jha");
		
		Response response = CustomerAPI.sendPostRequestToCreateCustomer(data);
		testLogger().log(Status.INFO, response.prettyPrint());

		ObjectMapper mapper = new ObjectMapper();
		Customer customer = mapper.readValue(response.asString(), Customer.class);
		testLogger().log(Status.INFO, "Asserting response status code");
		
		Assert.assertEquals(response.statusCode(), TestUtils.getExpectedStatusCode(data.get("expectedStatusCode")));

		testLogger().log(Status.INFO, "Asserting customer email id");
		//System.out.println("Email in the response is:- " + customer.getEmail());
		Assert.assertEquals(customer.getEmail(), data.get("expectedEmailId"));
		

	}

	@Test(dataProviderClass = DataProviderClass.class, dataProvider = "dp")
	public void verifycreateCustomerAPIWithInvalidEmailId(Hashtable<String, String> data)
			throws JsonParseException, JsonMappingException, IOException {
		Response response = CustomerAPI.sendPostRequestToCreateCustomer(data);
		
		//testLogger().info(response.prettyPrint());
	//	Assert.assertEquals(response.statusCode(), TestUtils.getExpectedStatusCode(data.get("expectedStatusCode")));
		
		
		
		//Assert.assertEquals(, expected);
		JsonPath jsonResponse = response.jsonPath();
		System.out.println(jsonResponse.get("id"));
		System.out.println("Email Id in the response-->"+jsonResponse.get("email"));
		System.out.println("Value of Object inside Sources is:- "+jsonResponse.get("sources.object"));

	}*/
	
	/*@Test(dataProviderClass = DataProviderClass.class, dataProvider = "dp")
	public void verifyListAllCustomers(Hashtable<String, String> data)
	{
		Response response = CustomerAPI.sendGetRequestToListAllCustomers(data);
		
		System.out.println(response.asString());
	}*/
	
	@Test
	public void createUser()
	{
		Map<String,String> map= new HashMap<String,String>();
		map.put("name", "raman");
		map.put("job","Selenium Automation Trainer");
		String json="{\"name\": \"morpheus\",\"job\": \"leader\"}";
		//Response response=given().contentType(ContentType.JSON).body(map).when().post("https://reqres.in/api/users").then().extract().response();
		Response response=given().contentType(ContentType.JSON).body(new File("./src/test/resources/inputJsonFIles/createuser.json")).when().post("https://reqres.in/api/users").then().extract().response();
		response.prettyPrint();
		
		//given().headers("header1", "valueOfHeader1","header2","valueOfHeader1").
	}

	// public void verify

}
