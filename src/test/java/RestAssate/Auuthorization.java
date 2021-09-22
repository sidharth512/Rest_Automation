package RestAssate;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Test


public class Auuthorization {
	public void actitime() {
		RestAssured.baseURI="https://reqres.in";
		PreemptiveBasicAuthScheme authscheme=new PreemptiveBasicAuthScheme() ;
		authscheme.setUserName("admin");
		authscheme.setPassword("manager");
		RestAssured.authentication=authscheme;
		RequestSpecification httprequest=RestAssured.given();
		Response responds=httprequest.request(Method.GET,"/");
		int code=responds.statusCode();
		Assert.assertEquals(code, 200);
		System.out.println(responds.getBody().asPrettyString());
		JsonPath jsonpath=responds.jsonPath();
		System.out.println(jsonpath.get("function initPlaceHolders()"));
	   

		
	}

}
