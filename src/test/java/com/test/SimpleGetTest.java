package com.test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class SimpleGetTest {


    public static void main (String[] args){
Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/11");
System.out.println("Status code:"+response.statusCode() );
System.out.println("Body:"+ response.getBody().asString());
    }
}
