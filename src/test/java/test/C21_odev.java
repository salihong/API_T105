package test;

import baseUrlKlasoru.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataHerokuapp;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C21_odev extends HerokuAppBaseUrl {


    @Test
    public void post01(){

        // 1 - URL ve Body hazirla

        specHerokuApp.pathParams("pp1","booking");

        TestDataHerokuapp testDataHerokuapp = new TestDataHerokuapp();

        HashMap<String,Object> reqBody = testDataHerokuapp.expBodyOlusturMap();

        System.out.println("reqBody map = " + reqBody);

        // 2 - Expected Data hazirla

        HashMap<String,Object> expDataMap = testDataHerokuapp.expBodyOlusturMap();



        // 3 - Response'i kaydet

        Response response = given().
                spec(specHerokuApp).
                when().
                body(reqBody).
                post("/{pp1}");

        response.prettyPrint();

        // 4 - Assertion

        // Not : Bizim hazirlamis oldugumuz Expected Data Map formatinda.
        // Bize response'dan donen Response Body ise Json formatinda
        // Ikisini Assert methodlari icerisinde kiyaslayabilmemiz icin oncelikle
        // response'i map formatina parse etmemiz gerekiyor.

        HashMap<String,Object> respMap = response.as(HashMap.class);

        Assert.assertEquals  (((Map) (expDataMap.get("booking"))).get("firstname"),
                ((Map)(respMap.get("booking"))).get("firstname"));

        Assert.assertEquals  (((Map) (expDataMap.get("booking"))).get("lastname"),
                ((Map)(respMap.get("booking"))).get("employee_name"));

        Assert.assertEquals  (((Map) (expDataMap.get("booking"))).get("totalprice"),
                ((Map)(respMap.get("booking"))).get("totalprice"));

        Assert.assertEquals  (((Map) (expDataMap.get("booking"))).get("depositpaid"),
                ((Map)(respMap.get("booking"))).get("depositpaid"));

        Assert.assertEquals  (((Map)((Map) (expDataMap.get("booking"))).get("bookingdates")).get("checkin"),
                ((Map)((Map)(respMap.get("booking"))).get("bookingdates")).get("checkin"));

        Assert.assertEquals  (((Map)((Map) (expDataMap.get("booking"))).get("bookingdates")).get("checkout"),
                ((Map)((Map)(respMap.get("booking"))).get("bookingdates")).get("checkout"));
    }
}