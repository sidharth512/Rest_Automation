package RestAssate;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RespondsBody {
	@Test
	
	
	
	public void JsonRespondbody() {
		
		
		
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification httprequest=RestAssured.given();
		Response  respond=httprequest.request(Method.GET,"https://reqres.in/api/users/2");
		int code=respond.getStatusCode();
		Assert.assertEquals(code, 200);
		String body=respond.getBody().asString();
		System.out.println(body);
		Assert.assertEquals(body.contains("janet.weaver@reqres.in"), true);
	}

}
