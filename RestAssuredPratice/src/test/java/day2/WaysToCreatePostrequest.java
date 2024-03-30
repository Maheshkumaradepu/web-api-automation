package day2;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

/*we have 4 different ways
 * 1.HashMap
 * 2.Org.Json Library
 * 3.POJO class
 *  4.JSON data 
 *  */
public class WaysToCreatePostrequest {
	 @Test(priority=1)
	void testPostusingHashMap() {

		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("name", "scott");
		data.put("location", "bhadurpally");
		data.put("phone", "1223214341241");
		String courseArr[] = { "C++", "JAVA" };
		data.put("cources", courseArr);

		given().contentType("application/json").body(data).when().post("http://localhost:3000/Students").then()
				.statusCode(201).body("name", equalTo("scott")).body("location", equalTo("bhadurpally"))
				.body("cources[0]", equalTo("C++")).header("content-Type", "application/json").log().all();

	}

	 @Test(priority = 2)
	void testPostusingJSONLibrary() {

		JSONObject data = new JSONObject();
		data.put("name", "scott");
		data.put("location", "bhadurpally");
		data.put("phone", "1223214341241");
		String courseArr[] = { "C++", "JAVA" };
		data.put("cources", courseArr);

		given().contentType("application/json").body(data.toString()).when().post("http://localhost:3000/Students")
				.then().statusCode(201).body("name", equalTo("scott")).body("location", equalTo("bhadurpally"))
				.body("cources[0]", equalTo("C++")).header("content-Type", "application/json").log().all();

	}

	@Test(priority = 3)
	void testPostusingPOJOClass() {

		Pojo_postRequest data = new Pojo_postRequest();
		data.setName("scott");
		data.setLocation("bhadurpally");
		data.setPhone("1223214341241");
		String CoursesArr[] = { "C++", "JAVA" };
		data.setCources(CoursesArr);

		given().contentType("application/json").body(data).when().post("http://localhost:3000/Students").then()
				.statusCode(201).body("name", equalTo("scott")).body("location", equalTo("bhadurpally"))
				.body("cources[0]", equalTo("C++")).header("content-Type", "application/json").log().all();

	}

	@Test(priority = 4)
	void testPostusingxtrnlJson() throws FileNotFoundException {

		File f = new File(".\\body.json");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);

		given().contentType("application/json").body(data.toString()).when().post("http://localhost:3000/Students")
				.then().statusCode(201).body("name", equalTo("kings")).body("location", equalTo("vikarabaddss"))
				.body("cources[0]", equalTo("C#")).header("content-Type", "application/json").log().all();

	}
}
