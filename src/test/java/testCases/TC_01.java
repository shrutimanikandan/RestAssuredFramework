package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

public class TC_01 {
	
	@Test
    public void test_getPetsByStatus() {
    	given()
    	
    	.when()
    	   .get("https://petstore.swagger.io")
    	.then()   
    	  .statusCode(200);
    }
    
    //@Test
    public void test_addNewPet() {
        HashMap data = new HashMap();
        data.put("id","0");
        data.put("name","doggie");
        data.put("status","available");
        
    Response res =    
        given()
           .contentType("application/json")
           .body(data)
        .when()   
            .post("https://petstore.swagger.io/v2/pet")
            
        .then()
            .statusCode(405)
            .log().body()
            .extract().response();
    
   String jsonString =  res.asString();
   Assert.assertEquals(jsonString.contains("Invalid input"),true);
   
    }
}
