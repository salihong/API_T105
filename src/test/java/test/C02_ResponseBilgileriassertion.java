package test;

import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_ResponseBilgileriassertion {

    @Test
     public void get01(){

        String url= "https://restful-booker.herokuapp.com/booking/69";
        Response response= given().when().get(url);
        response.prettyPrint();
        response.
                then().
                assertThat().statusCode(200).contentType("application/json; charset=utf-8").
                header("Server","Cowboy").
                statusLine("HTTP/1.1 200 OK");
    }
}
