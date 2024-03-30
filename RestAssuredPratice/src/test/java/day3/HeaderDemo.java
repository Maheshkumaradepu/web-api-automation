package day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeaderDemo {
	@Test
	void testHeaders() {

		given()

				.when().get("https://www.google.com")

				.then().header("Content-Type", "text/html; charset=ISO-8859-1").and().header("Content-Encoding", "gzip")
				.and().log().all();

	}

	@Test
	void getHeaders() {

		Response res = given()

				.when().get("https://www.google.com");

		// Single header value
		String headervalue = res.getHeader("Content-Type");
		System.out.println(headervalue);

		// all headers info

		Headers myheader = res.getHeaders();
		for (Header hd : myheader) {
			System.out.println(hd.getName() + "  " + hd.getValue());
		}

	}
}
