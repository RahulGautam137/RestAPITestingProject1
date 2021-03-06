package main.java.restassuredapitesting;

import io.restassured.http.ContentType;
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


                given().
                param("zip","110032,IN").
                param("appid","dc735b6de1394239a29c68b35248369d").
                when().get("http://api.openweathermap.org/data/2.5/weather").
                        then().assertThat().statusCode(200);




    }

    @Test
    public void Test2(){
        Response resp=given().
                param("q","London").
                param("appid","dc735b6de1394239a29c68b35248369d").
                when().
                get("http://api.openweathermap.org/data/2.5/weather");
        System.out.println(resp.asString());
        System.out.println(resp.getStatusCode());
       //System.out.println(resp.getBody());
        System.out.println(resp.getStatusCode());
        //System.out.println(resp.getBody());

    }
    @Test
    public void Test3(){
        String description=given().
                param("zip","110032,IN").
                param("appid","dc735b6de1394239a29c68b35248369d").
                when().
                get("http://api.openweathermap.org/data/2.5/weather").
                then().contentType(ContentType.JSON).extract().path("weather[0].description");


    }
    @Test
    public void getDataAndPassToAPI(){

        Response resp1=given().
                param("appid","dc735b6de1394239a29c68b35248369d").
                param("zip","110032,IN").when().get("http://api.openweathermap.org/data/2.5/weather");
        System.out.println(resp1.asString());
        Float longitude=resp1.
                then().contentType(ContentType.JSON).extract().path("coord.lon");
        System.out.println("longtitute value "+longitude);
        Float latitude=resp1.
                then().contentType(ContentType.JSON).extract().path("coord.lat");
        System.out.println("latitude value "+latitude);
        Response resp= given().param("lon", longitude).param("lat", latitude).param("appid","dc735b6de1394239a29c68b35248369d").
                when().get("http://api.openweathermap.org/data/2.5/weather");
        System.out.println("Response code is "+resp.asString());

    }
}
