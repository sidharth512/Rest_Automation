package RestAssate;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GETvalueofEachnodes {
	@Test
	
	
	public void get() {
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification httprequest=RestAssured.given();

		Response responds=httprequest.request(Method.GET, "https://reqres.in/api/users?page=2");
		//String body=responds.getBody().asString();
		//System.out.println(body);
		JsonPath jsonpath=responds.jsonPath();
	Object	info=jsonpath.get("data");
	System.out.println(info);
	Headers head =responds.getHeaders();
	for(Header allheader:head) {
		System.out.println(allheader.getValue());
	}
	//System.out.println(head);
		
		
	}

}
