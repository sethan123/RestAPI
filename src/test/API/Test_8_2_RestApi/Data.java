package Test_8_2_RestApi;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class Data {

	@Test
	void fakeDataGenerator() {
		Faker faker = new Faker();
		
		String name = faker.name().fullName();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String streetAddress = faker.address().streetAddress();
		String username = faker.name().username();
		String email = faker.internet().safeEmailAddress();
		String password = faker.internet().password(5, 10);
		String phoneno = faker.phoneNumber().cellPhone();

		System.out.println("Name: "+ name);
		System.out.println("First Name: "+ firstName);
		System.out.println("Last Name: "+ lastName);
		System.out.println("Address: "+ streetAddress);
		System.out.println("User Name: "+ username);
		System.out.println("Email: "+ email);
		System.out.println("Password: "+ password);
		System.out.println("Phone: "+phoneno);
		
	}
}
