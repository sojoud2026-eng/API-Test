package com.test;

import io.restassured.internal.ValidatableResponseImpl;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import org.testng.Assert;

import java.util.List;
import java.util.Objects;

public class APITest {

@Test
 public void Testiness(){
    System.out.println("Starting");
   // String utl = "https://jsonplaceholder.typicode.com/posts";
   // RestAssured.given().when().get("https://jsonplaceholder.typicode.com/posts").then().statusCode(200).extract().path("title");
String  result = RestAssured.given().when().get("https://jsonplaceholder.typicode.com/posts/1").then().extract().asString();

        //extract().path("title");
    System.out.println("the Result:  " + result);
  Assert.assertNotNull(result ,"name should be not added");
  Assert.assertEquals(result.equals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"),"the Data not  matching");
    }
@Test
public void testFeldValidations(){

    System.out.println("Validations");
    RestAssured.given().when().get("https://jsonplaceholder.typicode.com/posts/1")
            .then().assertThat().statusCode(200)
            .body("title", Matchers.instanceOf(String.class))
            .body("id",Matchers.greaterThan(0))
            .body("userId",Matchers.notNullValue());
}
@Test
public void testResponsTime(){

    long time = RestAssured.given().when().get("https://jsonplaceholder.typicode.com/posts/1").time();
    System.out.println("Response time : " + time);
    Assert.assertTrue(time < 2000 ,"API response is too Slow");
  String responseBody =  RestAssured.given().when().get("https://jsonplaceholder.typicode.com/posts/1").getBody().asString();
    System.out.println("Response Body : " + responseBody);
}
}
