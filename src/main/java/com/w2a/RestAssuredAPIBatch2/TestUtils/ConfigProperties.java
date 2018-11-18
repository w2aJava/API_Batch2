package com.w2a.RestAssuredAPIBatch2.TestUtils;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Key;
import org.aeonbits.owner.Config.Sources;


@Sources({ 
	"file:src\\test\\resources\\propertyFiles\\${enviroment}.properties" // mention the property file name
})
public interface ConfigProperties extends Config{

	@Key("baseURI")
	String getBaseURI();
	
	@Key("basePath")
	String getBasePath();
	
	@Key("username")
	String getusername();
	
	@Key("portNumber")
	int getPortNumber();
	
	@Key("sheetName")
	String getSheetName();
	
	@Key("secretKey")
	String getSecretKey();
	
	
	
	
}
