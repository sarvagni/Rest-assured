package petStoreAPI;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
//import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


/**Creating User to the store 
 * Updating the details of User
 * Fetching the details of the User.
 * Deleting the user
 */
public class user {
	
	//Creating User 
	public static int userCreation() {
		RestAssured.baseURI="https://petstore.swagger.io";
		RequestSpecification httpRequest=RestAssured.given();
		
		//Creating the Request payload
		JSONObject requestPara=new JSONObject();
		requestPara.put("id", 124);
		requestPara.put("username", "Karthikeya124");
		requestPara.put("firstName", "Karthikeya1");
		requestPara.put("lastName", "Sarvagni1");
		requestPara.put( "email", "rraju7812@gmail.com");
		requestPara.put("password", "12345678910");
		requestPara.put("phone", "9440660618");
		requestPara.put("userStatus", 0);
		
//     <---------------------------------------------->		
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body("["+requestPara.toJSONString()+"]");
		
		
		Response resp= httpRequest.request(Method.POST,"/v2/user/createWithList");
		String respoBody=resp.getBody().asString();
		
		//Printing the Response to the consol.
		System.out.println("resonse :"+respoBody);
		int statusCode=resp.getStatusCode();
		
		//Prints the statusCode in consol.
		System.out.println(statusCode);
		
		return statusCode;
		
	}
	
	//Updating the details of User
	public static int userUpdate() {
		RestAssured.baseURI="https://petstore.swagger.io";
		RequestSpecification httpRequest=RestAssured.given();
		
		//Creating the Request payload
		JSONObject requestPara=new JSONObject();
		requestPara.put("id", 124);
		requestPara.put("username", "Karthikeya124");
		requestPara.put("firstName", "Karthik");
		requestPara.put("lastName", "Duggirala");
		requestPara.put( "email", "karthikeyaSarvagni@gmail.com");
		requestPara.put("password", "12345678910");
		requestPara.put("phone", "9440660618");
		requestPara.put("userStatus", 0);
		
//     <------------------------------------------------>		
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestPara.toJSONString());
		
		
		Response resp= httpRequest.request(Method.PUT,"/v2/user/Karthikeya124");
		String respoBody=resp.getBody().asString();
		
		
		//Printing the Response to the consol.
		System.out.println("resonse :"+respoBody);
		int statusCode=resp.getStatusCode();
		
		//Prints the statusCode in consol.
		System.out.println(statusCode);
		
		return statusCode;
		
	}
	
	//Fetching the details of the User.
	public static int fetchUser() {
		RestAssured.baseURI="https://petstore.swagger.io";
		RequestSpecification httpRequest=RestAssured.given();
		
		Response resp= httpRequest.request(Method.GET,"/v2/user/Karthikeya124");
		String respoBody=resp.getBody().asString();
		
		//Printing the Response to the consol.
		System.out.println("resonse :"+respoBody);
		int statusCode=resp.getStatusCode();
		
		//Prints the statusCode in consol.
		System.out.println(statusCode);
		
		return statusCode;
		
	}
	
	//Deleting the user
	public static int deleteUser() {
		RestAssured.baseURI="https://petstore.swagger.io";
		RequestSpecification httpRequest=RestAssured.given();
		
		Response resp= httpRequest.request(Method.DELETE,"/v2/user/Karthikeya124");
		String respoBody=resp.getBody().asString();
		
		//Printing the Response to the consol.
		System.out.println("resonse :"+respoBody);
		int statusCode=resp.getStatusCode();
		
		//Prints the statusCode in consol.
		System.out.println(statusCode);
		
		return statusCode;
		
	}

}
