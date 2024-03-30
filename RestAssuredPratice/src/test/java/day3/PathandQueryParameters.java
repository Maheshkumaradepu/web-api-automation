package day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class PathandQueryParameters {
	@Test
	void pathParameters() {

		given().pathParam("my_path", "users").queryParam("page", 2).queryParam("id", 5)

				.when().get("https://reqres.in/api/{my_path}")

				.then().log().all();
	}

}
