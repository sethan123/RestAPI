package Test_8_1_Chaining_Student_API;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class UpdateStudent {
	//using org.json
	@Test
	public void updateStudent(ITestContext context)
	{
		JSONObject data=new JSONObject();
		data.put("name","Scott");
		data.put("location","Germany"); //update
		data.put("phone","654321"); //update
		String coursesArr[]= {"C#","C++"}; //update
		data.put("courses", coursesArr);
				
		
		// Chain (Share Data with) APIs in same Test Tag
			//int id = (Integer) context.getAttribute("stu_id");
				
		// Chain (Share Data with) APIs in same Suite Tag	
		  int id = (Integer) context.getSuite().getAttribute("stu_id");
			
		
		given()
			.contentType("application/json")
			.pathParam("id", id)
			.body(data.toString())
			
		.when()
			.put("http://localhost:3000/students/{id}")
		.then()
			.statusCode(200)
			.header("Content-Type","application/json; charset=utf-8")
			.log().all();
			
	}
	
}
