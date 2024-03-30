package day4;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ParsingJsonResponse {

	@Test
	void testJsonResponse() {
		/*
		 * Type 1 given().contentType("ContentType.json")
		 * 
		 * .when().get("http://localhost:3000/store")
		 * 
		 * .then().statusCode(200).header("Content-Type", "application/json")
		 * .body("book[3].title", equalTo("The Lord of the Rings")).log().all();
		 */
		// Type 2
		Response res = given().contentType("ContentType.json")

				.when().get("http://localhost:3000/store");

		/*
		 * Assert.assertEquals(res.getStatusCode(), 200);
		 * Assert.assertEquals(res.header("Content-Type"), "application/json"); String
		 * bookName = res.jsonPath().get("book[3].title").toString();
		 * Assert.assertEquals(bookName, "The Lord of the Rings");
		 */

		JSONObject jo = new JSONObject(res.asString());
		for (int i = 0; i < jo.getJSONArray("book").length(); i++) {
			String bookname = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			System.out.println(bookname);
		}
	}
}
