package rr_pkg;

import org.testng.annotations.BeforeTest;

public class RRC {
	//@BeforeTest
	public static String base_url() {
		String baseURI="https://reqres.in/";
		return baseURI;
	}
	
	public static String resource() {
		
		String resource="api/users";
		return resource;
	}
	
	public static String reqbody() {
		String req_body="{\r\n"
				+ "	\"firstName\": \"John\",\r\n"
				+ "	\"lastName\": \"doe\",\r\n"
				+ "	\"executiveSummary\": \"Below, you will find a proposal, etc. etc.\",\r\n"
				+ "	\"products\": [\r\n"
				+ "		{\r\n"
				+ "			\"name\": \"test product\",\r\n"
				+ "			\"quantity\": 5,\r\n"
				+ "			\"price\": 10,\r\n"
				+ "			\"total\": 50\r\n"
				+ "		},\r\n"
				+ "		{\r\n"
				+ "			\"name\": \"Creative Name\",\r\n"
				+ "			\"quantity\": 10,\r\n"
				+ "			\"price\": 20,\r\n"
				+ "			\"total\": 200\r\n"
				+ "		}\r\n"
				+ "	]\r\n"
				+ "}";
		
		return req_body;
	}
}

