package com.w2a.RestAssuredAPIBatch2.Rough;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class FileMove {
	
	
	public static void main(String[] args) {
		String newFileName="TestReport";
		TimeZone.setDefault(TimeZone.getTimeZone("IST"));
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String timeStamp=f.format(new Date());
		
		newFileName=newFileName+timeStamp+".html";
	
				
		File file= new File("./extentreport.html");
		
		
		if(file.renameTo(new File("./src/test/resources/archivedExtentReports/"+newFileName)))
		{
			System.out.println("File has been moved");
			file.delete();
		}
		else
		{
			System.out.println("File does not moved");
		}
	}

}
