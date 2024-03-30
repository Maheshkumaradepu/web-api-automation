package day5;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class testXMLresponse {
	Response res = given().contentType("ContentType.json")

			.when().get("http://restapi.adequateshop.com/api/Traveler?page=1");

	XmlPath xo = new XmlPath(res.asString());
	List<String> travellers = xo.getList("Travelerinformationresponse.travelers.Travelerinfomation");

	Assert.assertEquals(travellers.size(),10);
	List<String> travellers_names = xo.getList("Travelerinformationresponse.travelers.Travelerinfomation.name");
	boolean status = false;

	for(
	String travellername:travellers_names)
	{
		if (travellername.equals("vijay Bharath reddy")) {
			status = true;
			break;
		}
	}Assert.assertEquals(status,True);
}
