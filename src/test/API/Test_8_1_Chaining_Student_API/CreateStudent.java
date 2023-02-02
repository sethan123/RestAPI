package Test_8_1_Chaining_Student_API;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class CreateStudent{
	//Post request body creation using using Org.JSON
	@Test
	public void createStudent(ITestContext context)
	{
		JSONObject data=new JSONObject();
		data.put("name","Scott");
		data.put("location","France");
		data.put("phone","123456");
		String coursesArr[]= {"C","C++"};
		data.put("courses", coursesArr);
				
		
		int id=given()
					.contentType("application/json")
					.body(data.toString())
		
				.when()
					.post("http://localhost:3000/students")
					.jsonPath().getInt("id");
		
	// Chain (Share Data with) APIs in same Test Tag
		//context.setAttribute("stu_id", id);
	
	// Chain (Share Data with) APIs in same Suite Tag
		context.getSuite().setAttribute("stu_id", id);	
	
	}
}