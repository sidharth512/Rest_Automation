package RestAssate;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Delete_Method {
	@Test
	
	public void Dlt_content() {
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification httprequest=RestAssured.given();
		Response response=httprequest.request(Method.DELETE,"https://reqres.in/api/users/2");
		response.then().statusCode(204).log().all();
	}

}
