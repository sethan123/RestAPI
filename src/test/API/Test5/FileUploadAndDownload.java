package Test5;

//Open command prompt , the run below command
//
//		java - jar file-upload-RestAPI.jar

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


import java.io.File;

import org.testng.annotations.Test;

public class FileUploadAndDownload {

	@Test(priority=1)
	void singleFileUpload()
	{
		File myfile=new File("C:\\AutomationPractice\\Test1.txt");
		
		given()
			.multiPart("file",myfile)
			.contentType("multipart/form-data")
		
		.when()
			.post("http://localhost:8080/uploadFile")
		
		.then()
			.statusCode(200)
			.body("fileName", equalTo("Test1.txt"))
			.log().all();
					
		
	}
	

	//@Test
	void multipleFilesUpload()
	{
		File myfile1=new File("C:\\AutomationPractice\\Test1.txt");
		File myfile2=new File("C:\\AutomationPractice\\Test2.txt");
		
		given()
			.multiPart("files",myfile1)
			.multiPart("files",myfile2)
			.contentType("multipart/form-data")
		
		.when()
			.post("http://localhost:8080/uploadMultipleFiles")
		
		.then()
			.statusCode(200)
			.body("[0].fileName", equalTo("Test1.txt"))
			.body("[1].fileName", equalTo("Test2.txt"))
			
			.log().all();
					
		
	}
	
	//@Test
	void multipleFilesUpload2()   
	{
		File myfile1=new File("C:\\AutomationPractice\\Test1.txt");
		File myfile2=new File("C:\\AutomationPractice\\Test2.txt");
		
		File filearr[]= {myfile1,myfile2};  // wont work for all kinds API
		
		given()
			.multiPart("files",filearr)
			.contentType("multipart/form-data")
		
		.when()
			.post("http://localhost:8080/uploadMultipleFiles")
		
		.then()
			.statusCode(200)
			.body("[0].fileName", equalTo("Test1.txt"))
			.body("[1].fileName", equalTo("Test2.txt"))
			
			.log().all();
					
		
	}
	
	@Test(priority=2)
	void fileDownload()
	{
		given()
		
		.when()
			.get("http://localhost:8080/downloadFile/Test1.txt")
		.then()
			.statusCode(200)
			.log().body();	
		}
	
	
	
}
