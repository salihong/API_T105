package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_Get_ApiSorgulam {
    /*
        https://restful-booker.herokuapp.com/booking/256884 url’ine
        bir GET request gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.

         1- request için body hazırla
         2- Expected data hazırla
         3- response save as actual data  kaydedip
         4- assertion
         */
    @Test
    public void get01(){
        String url= "https://restful-booker.herokuapp.com/booking/133";

        Response response= given().when().get(url);
        response.prettyPrint();
        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Content type :" + response.getContentType());
        System.out.println("Status Line:" + response.getStatusLine());
        System.out.println("Response süresi :" + response.getTime());
       // System.out.println("Server Header değeri :" + response.getHeader(header));

    }



}
