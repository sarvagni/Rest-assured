package petStoreAPI;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


/**Placing the order.
 * Fetching the details of the order
 * Removing the order.
 */
public class orders {
	
	//Placing the order.
	public static int placingOrder() {
		RestAssured.baseURI="https://petstore.swagger.io";
		RequestSpecification httpRequest=RestAssured.given();
		
		//Creating the Request payload
		JSONObject requestPara=new JSONObject();
		requestPara.put("id", 126);
		requestPara.put("petId", 1);
		requestPara.put("quantity", 2);
		requestPara.put("shipDate","2021-09-04T07:43:10.562Z");
		requestPara.put("status","placed");
		requestPara.put("complete", true);
		
//     <-------------------------------------->		
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestPara.toJSONString());
		
		
		Response resp= httpRequest.request(Method.POST,"/v2/store/order");
		String respoBody=resp.getBody().asString();
		
		//Printing the Response to the consol.
		System.out.println("resonse :"+respoBody);
		int statusCode=resp.getStatusCode();
		
		//Prints the statusCode.
		System.out.println(statusCode);
		
		return statusCode;
		
	}
	
	//Fetching the details of order
	public static int fetchOrder() {
		RestAssured.baseURI="https://petstore.swagger.io";
		RequestSpecification httpRequest=RestAssured.given();
		
		Response resp= httpRequest.request(Method.GET,"/v2/store/order/1");
		String respoBody=resp.getBody().asString();
		
		//Printing the Response to the consol.
		System.out.println("resonse :"+respoBody);
		int statusCode=resp.getStatusCode();
		
		//Prints the statusCode.
		System.out.println(statusCode);
		
		return statusCode;
		
	}
	
	//Removes the order.
	public static int deleteOrder() {
		RestAssured.baseURI="https://petstore.swagger.io";
		RequestSpecification httpRequest=RestAssured.given();
		
		Response resp= httpRequest.request(Method.DELETE,"/v2/store/order/126");
		String respoBody=resp.getBody().asString();
		
		//Printing the Response to the consol.
		System.out.println("resonse :"+respoBody);
		int statusCode=resp.getStatusCode();
		
		//Prints the statusCode.
		System.out.println(statusCode);
		
		return statusCode;
		
	}
	
	
}
