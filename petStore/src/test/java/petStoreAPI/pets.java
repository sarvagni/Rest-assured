package petStoreAPI;

import java.io.File;

import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


/**Adding pet to the store 
 * Updating the details pet
 * Fetching the details of the pet
 * UPloading the Image of the pet
 * Removing the pet from the store.
 */
public class pets {
//Adding pet to the store.
	public static int addingPet() {
		RestAssured.baseURI="https://petstore.swagger.io";
		RequestSpecification httpRequest=RestAssured.given();
		
		//Creating the Request payload
		JSONObject requestPara=new JSONObject();
		JSONObject categoryPara=new JSONObject();
		JSONObject tags=new JSONObject();
		
		categoryPara.put("id", 0);
		categoryPara.put("name", "Golden Ritriver");
		
		tags.put("id", 0);
		tags.put("name","Chocklate");
		
		List<String> urls=Arrays.asList("URl1");
		List<JSONObject> tags1=Arrays.asList(tags);
		requestPara.put("id", 125);
		requestPara.put("category", categoryPara);
		requestPara.put("name","doggie");
		requestPara.put("photoUrls",urls);
		requestPara.put("tags",tags1);
		requestPara.put("status", "available");
		
//      <----------------------------------------->
		
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestPara.toJSONString());
		
		
		Response resp= httpRequest.request(Method.POST,"/v2/pet");
		String respoBody=resp.getBody().asString();
		
		//Printing the Response to the consol.
		System.out.println("resonse :"+respoBody);
		int statusCode=resp.getStatusCode();
		
		//Prints the statusCode in consol.
		System.out.println(statusCode);
		
		return statusCode;
		
	}
	//Updating the Pet details.
	public static int updatingPet() {
		RestAssured.baseURI="https://petstore.swagger.io";
		RequestSpecification httpRequest=RestAssured.given();
		
		//Creating the Request payload
		JSONObject requestPara=new JSONObject();
		JSONObject categoryPara=new JSONObject();
		JSONObject tags=new JSONObject();
		
		categoryPara.put("id", 0);
		categoryPara.put("name", "Golden Ritriver Breed");
		
		tags.put("id", 1);
		tags.put("name","Hunter");
		
		List<String> urls=Arrays.asList("URl1");
		List<JSONObject> tags1=Arrays.asList(tags);
		
		requestPara.put("id", 125);
		requestPara.put("category", categoryPara);
		requestPara.put("name","doggie_New");
		requestPara.put("photoUrls",urls);
		requestPara.put("tags",tags1);
		requestPara.put("status", "available");
		
//     <---------------------------------------->		
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestPara.toJSONString());
		
		
		Response resp= httpRequest.request(Method.PUT,"/v2/pet");
		String respoBody=resp.getBody().asString();
		
		//Printing the Response to the consol.
		System.out.println("resonse :"+respoBody);
		int statusCode=resp.getStatusCode();
		
		//Prints the statusCode.
		System.out.println(statusCode);
		
		return statusCode;
		
	}
	
	//Fetching the details of the pet.
	public static int fetchPet() {
		RestAssured.baseURI="https://petstore.swagger.io";
		RequestSpecification httpRequest=RestAssured.given();
		
		Response resp= httpRequest.request(Method.GET,"/v2/pet/125");
		String respoBody=resp.getBody().asString();
		
		//Printing the Response to the consol.
		System.out.println("resonse :"+respoBody);
		int statusCode=resp.getStatusCode();
		
		//Prints the statusCode.
		System.out.println(statusCode);
		
		return statusCode;
		
	}
	
	//Removing the pet from the store
	public static int deletePet() {
		RestAssured.baseURI="https://petstore.swagger.io";
		RequestSpecification httpRequest=RestAssured.given();
		
		Response resp= httpRequest.request(Method.DELETE,"/v2/pet/125");
		String respoBody=resp.getBody().asString();
		
		//Printing the Response to the consol.
		System.out.println("resonse :"+respoBody);
		int statusCode=resp.getStatusCode();
		
		//Prints the statusCode.
		System.out.println(statusCode);
		
		return statusCode;
		
	}
	
	//Uploading the Image of the Pet.
	public static int uploadPetImage() {
		RestAssured.baseURI="https://petstore.swagger.io";
		RequestSpecification httpRequest=RestAssured.given();
		
		//Set the properties to the Image file.
		String fileWithpath=System.getProperty("user.dir")+"\\petImage\\download.jpg";
		File petImage=new File(fileWithpath);
		
		//Setting up the Content type 
		httpRequest.header("Content-Type","multipart/form-data;charset=utf-8; boundary="+Math.random());
		httpRequest.multiPart("file",petImage);
		Response resp= httpRequest.request(Method.POST,"v2/pet/125/uploadImage");
		
		
		//Printing the Response to the consol.
		String respoBody=resp.getBody().asString();
		System.out.println("resonse :"+respoBody);
		
		//Prints the statusCode.
		int statusCode=resp.getStatusCode();
		System.out.println(statusCode);
		
		return statusCode;
		
	}
	
}
