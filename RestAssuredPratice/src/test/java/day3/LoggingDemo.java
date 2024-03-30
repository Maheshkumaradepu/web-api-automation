package day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class LoggingDemo {
	@Test
	void testlogs() {

		given()

				.when().get("https://reqres.in/api/users")

				.then().log().body().log().cookies().log().headers().log().all();

	}
}
