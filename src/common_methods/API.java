package common_methods;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
public class API {

	public static int status_code(String baseURI,String resource,String requestbody) {
		
		RestAssured.baseURI=baseURI;
		int status_code=given().header("content-type","application/json").body(requestbody).when().post(resource).then().extract().response().statusCode();
		return status_code;
	}
	
public static String resbody(String baseURI,String resource,String requestbody) {
		
		RestAssured.baseURI=baseURI;
		String res_body=given().header("content-type","application/json").body(requestbody).when().post(resource).then().extract().response().asString();
		return res_body;
	}
}
