package RestAssate;



import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import Utiles.testcasedata;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDriven_Test {
	@Test(dataProvider = "empdataprovider")
	public void PostMethod(String ename,String work) {
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification  httprequest=RestAssured.given();
	        JSONObject requestparan=new JSONObject();
	        requestparan.put("name",ename);
	        requestparan.put( "job",work);
	        httprequest.header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON);
	        httprequest.body( requestparan.toJSONString());
	        Response  respond= httprequest.request(Method.POST,"https://reqres.in/api/users");
	        respond.then().statusCode(201).log().all();
	        String body=respond.getBody().asString();
	       Assert.assertEquals(body.contains(ename),true);
	       Assert.assertEquals(body.contains(work),true);
            int code=respond.statusCode();
	        System.out.println(code);
	}

	
	@DataProvider(name="empdataprovider")
	String [][]EmpData() throws IOException{
		String path="C:\\Users\\User 1\\Desktop\\New Microsoft Office Excel Worksheet.xlsx";
		int rownum =testcasedata.getrow(path,"Sheet1");
	  int colcount=	testcasedata.getcell(path,"Sheet1", rownum);
	  String [][] empData=new String[rownum][colcount];
	  for(int i=1;i<=rownum;i++) {
		  for(int j =0;j< colcount;j++) {
			  empData [i-1][j]=testcasedata.getcellvalue( path,"Sheet1",i, j);
			  
		  }
	  }
	
		
		
		//String empData[][]= {{"abc123","test"},{"uor213","devp"};
		return (empData);
}
	}
