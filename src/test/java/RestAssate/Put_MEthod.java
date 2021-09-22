package RestAssate;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers.*;
@Test

public class Put_MEthod {
	public void Put() {
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification httprequest=RestAssured.given();
		JSONObject json =new JSONObject();
		json.put("name", "sidharth");
		json.put("job", "QA");
		httprequest.header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON);
		httprequest.body(json.toJSONString());
		Response respond=httprequest.request(Method.PUT,"https://reqres.in/api/users/2");
	respond.then().statusCode(200).log().all();
}}
