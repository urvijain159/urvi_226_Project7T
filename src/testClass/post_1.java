package testClass;

import java.time.LocalDateTime;


import org.testng.Assert;
import org.testng.annotations.Test;

import common_methods.API;
import io.restassured.path.json.JsonPath;
import rr_pkg.RRC;

public class post_1 {
   @Test
	public static void execute() {
		
		int statusCode=API.status_code(RRC.base_url(), RRC.resource(), RRC.reqbody());
		System.out.println(statusCode);
		
		String res_body=API.resbody(RRC.base_url(), RRC.resource(), RRC.reqbody());
		System.out.println(res_body);
		
		JsonPath jsp_req=new JsonPath(RRC.reqbody());	
		JsonPath jsp_res=new JsonPath(res_body);
	    int count=jsp_res.getList("products").size();
	    System.out.println(count);
	    
	    for(int i=0;i<count;i++)
	    {
	    	
	String res_name=jsp_res.getString("products["+i+"].name");
    String res_quantity=jsp_res.getString("products["+i+"].quantity");
    int res_int_quantity=Integer.parseInt(res_quantity);
    String res_price=jsp_res.getString("products["+i+"].price");
    int res_int_price=Integer.parseInt(res_price);
    String res_total=jsp_res.getString("products["+i+"].total");
    int res_int_total=Integer.parseInt(res_total);
    String res_id=jsp_res.getString("id");
	String res_createdAt=jsp_res.getString("createdAt");
	
	String trim_date=res_createdAt.substring(0,10);
	
	 //generate date
    LocalDateTime date=LocalDateTime.now();
    String exp_date=date.toString().substring(0,10);
    
   
    String req_name=jsp_req.getString("products["+i+"].name");
    String req_quantity=jsp_req.getString("products["+i+"].quantity");
    int req_int_quantity=Integer.parseInt(req_quantity);
    String req_price=jsp_req.getString("products["+i+"].price");
    int req_int_price=Integer.parseInt(req_price);
    String req_total=jsp_req.getString("products["+i+"].total");
    int req_int_total=Integer.parseInt(req_total);
	    
        Assert.assertEquals(res_name,req_name);
	    Assert.assertEquals(res_quantity,req_quantity);
	    Assert.assertEquals(res_price,req_price);
	    Assert.assertEquals(res_total, req_total);
	    Assert.assertNotNull(res_id);
		Assert.assertEquals(trim_date, exp_date);
	}

   }
}