package day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesDemo {
	@Test
	void testCookies() {

		given()

				.when().get("https://www.google.com")

				.then().cookie("AEC", "Ae3NU9OZDr4C2KJFfUft5iDsH2llpfyF1q3joqSco-CpdqGFWAxW9Umcqw").statusCode(200)
				.log().all();

	}

	@Test(priority = 2)
	void getCookiesinfo() {

		Response res = given()

				.when().get("https://www.google.com");

		// get single cookie info

		String AEC_value = res.getCookie("AEC");
		System.out.println("cookie value is -->" + AEC_value);

		// get multiple cookies

		Map<String, String> cookies_values = res.getCookies();
		System.out.println(cookies_values.keySet());

		for (String k : cookies_values.keySet()) {
			String cookie_value = res.getCookie(k);
			System.out.println(k + "          " + cookie_value);
		}

	}
}
