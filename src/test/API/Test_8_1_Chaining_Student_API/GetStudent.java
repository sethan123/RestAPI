package Test_8_1_Chaining_Student_API;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetStudent {
	@Test
	public void getStudent(ITestContext context)
	{	
		// Chain (Share Data with) APIs in same Test Tag
		  //int id = (Integer) context.getAttribute("stu_id");
		
		// Chain (Share Data with) APIs in same Suite Tag	
		  int id = (Integer) context.getSuite().getAttribute("stu_id");
		
		
		given()
			.pathParam("id", id)
		.when()
			.get("http://localhost:3000/students/{id}")
						
		.then()
			.statusCode(200)
			.log().all();
	}
	
}
