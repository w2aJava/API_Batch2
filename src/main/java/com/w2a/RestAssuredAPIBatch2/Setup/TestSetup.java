package com.w2a.RestAssuredAPIBatch2.Setup;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.lang.reflect.Method;

import org.aeonbits.owner.ConfigFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.w2a.RestAssuredAPIBatch2.TestUtils.ConfigProperties;
import com.w2a.RestAssuredAPIBatch2.TestUtils.ExcelReader;
import com.w2a.RestAssuredAPIBatch2.TestUtils.ExtentManager;
import com.w2a.RestAssuredAPIBatch2.TestUtils.TestUtils;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class TestSetup {

	public static ConfigProperties configProperties=null;
	public ExcelReader excelReader = new ExcelReader(System.getProperty("user.dir")+
			"\\src\\test\\resources\\testData\\TestData.xlsx");
	
	protected static ExtentReports extent;
    protected static ThreadLocal<ExtentTest> classLevelLogger = new ThreadLocal<ExtentTest>();
    protected static ThreadLocal<ExtentTest> testLevelLogger = new ThreadLocal<ExtentTest>();
    public static RequestSpecification resquestSpecification;
    
    
    
	@BeforeSuite
	public void setUp() {
		
		ConfigFactory.setProperty("enviroment", "dev");
		configProperties = ConfigFactory.create(ConfigProperties.class);

		RestAssured.baseURI = configProperties.getBaseURI();
		RestAssured.basePath = configProperties.getBasePath();
		
		TestUtils.moveReportToArchiveFolder();
	
		extent=ExtentManager.GetExtent();
		System.out.println(configProperties.getBaseURI());
		System.out.println(configProperties.getSheetName());

	}

	@BeforeTest
	public void beforeTest() {

	}

	@BeforeClass
	public void beforeClass() {
		
		ExtentTest parent = extent.createTest(getClass().getSimpleName());
		classLevelLogger.set(parent);

	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		
		resquestSpecification=setRequestSpecification(configProperties.getSecretKey());

	}

	@AfterMethod
	public void afterMethod(ITestResult testCaseResult) {

		
	}

	@AfterClass
	public void afterClass() {

	}

	@AfterTest
	public void afterTest() {

	}

	@AfterSuite
	public void tearDown() {

	}

	public static ExtentTest testLogger()
	{
		return testLevelLogger.get();
	}
	
	public static RequestSpecification setRequestSpecification(String key)
	{
		return given().auth().basic(key, "");
	}
	
	public static RequestSpecification setFormParams(String arguments,RequestSpecification requestSpec)
	{
		String[] argument=arguments.split(";");
		for(int i=0;i<argument.length;i++)
		{
			String[] keyValuePair=argument[i].split(":");
			requestSpec.formParam(keyValuePair[0], keyValuePair[1]);
		}
		return requestSpec;
	}
	
}
