package main.java.restassuredapitesting;

import org.testng.annotations.BeforeTest;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;
public class FirstAPITest {

    @BeforeTest
    public void firstFunction(){

        get("api.openweathermap.org/data/2.5/weather?q=London&appid=dc735b6de1394239a29c68b35248369d");


    }
}
