package main.java.restassuredapitesting;

import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;
public class FirstAPITest {

    @Test
    public void firstFunction(){
        //"http://api.openweathermap.org/data/2.5/weather?q=London&appid=dc735b6de1394239a29c68b35248369d"
        Response resp=given().param("q","London").param("appid","dc735b6de1394239a29c68b35248369d").when().get("http://api.openweathermap.org/data/2.5/weather");

        System.out.println(resp.getStatusCode());
        System.out.println(resp.getBody());
        System.out.println(resp.getStatusCode());
        System.out.println(resp.getBody());


    }
}
