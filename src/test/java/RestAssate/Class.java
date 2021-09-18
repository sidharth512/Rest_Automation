package RestAssate;



import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Class {
	@Test
	public void test() {
		
		
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification httprequest=RestAssured.given();
		Response responds=httprequest.request(Method.GET,"https://reqres.in/api/users?page=2");
		String statuslines=responds.statusLine();
		int code=responds.statusCode();
		org.testng.Assert.assertEquals(code, 200);
		Headers allheaders=responds.headers();
	 int Headsize= allheaders.size();
	 for( Header head:allheaders) {
		 System.out.println(head.getName()+" @ "+head.getValue());
		 
	 }
		
		
       
		
	}

}
