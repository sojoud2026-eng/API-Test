package com.test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class SimplePostTest {

 public static void main(String[] args) {

     String requestbody = "{\n" + " \"userId\":  \"20222\" ,\n" +
     "  \"title\": \"sojoudTesting99\",\n" +
             "  \"body\": \"lets go \"\n" +
             "}";
     Response response = RestAssured.given().contentType(ContentType.JSON).body(requestbody).post("https://jsonplaceholder.typicode.com/posts");
     System.out.println("Staus Code ;"+response.statusCode());
     System.out.println("Body:"+ response.getBody().asString());

    }
}
