package RestAssate;



import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

public class Class {
	@Test
	public void test() {
		
		
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification httprequest=RestAssured.given();
		Response responds=httprequest.request(Method.GET,"https://reqres.in/api/users?page=2");
		//responds.then().statusCode(200).body("data.id[1]",equalTo(8)).log().all();
		responds.then().statusCode(200).body("data.first_name",hasItems("Michael","Lindsay"));
		String statuslines=responds.statusLine();
		int code=responds.statusCode();
		org.testng.Assert.assertEquals(code, 200);
		String head=responds.header("content-type");
		System.out.println(head);
		Headers allheaders=responds.headers();
	 int Headsize= allheaders.size();
	 for( Header heads:allheaders) {
		 System.out.println(heads.getName()+" @ "+heads.getValue());
		 
	 }
		
		
       
		
	}

}
