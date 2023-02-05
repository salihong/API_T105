package test;

import baseUrlKlasoru.JsonPlaceHolderBaseUrl;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataJsonPlaceHolder;

public class C18_Get_TestDataClassKullanimi extends JsonPlaceHolderBaseUrl {

    @Test
    public void get01() {
        this.specJasonPlace.pathParams("pp1", "posts", new Object[]{"pp2", 22});

        TestDataJsonPlaceHolder testDataJsonPlaceHolder = new TestDataJsonPlaceHolder();

        JSONObject expData = testDataJsonPlaceHolder.expectedBodyOlusturJSON();

        Response response = (Response) RestAssured.given().spec(this.specJasonPlace).when().get("/{pp1}/{pp2}", new Object[0]);
        JsonPath resJPath = response.jsonPath();

        Assert.assertEquals((long)testDataJsonPlaceHolder.basariliStatusCode, (long)response.getStatusCode());
        Assert.assertEquals(expData.get("userId"), resJPath.get("userId"));
        Assert.assertEquals(expData.get("id"), resJPath.get("id"));
        Assert.assertEquals(expData.get("title"), resJPath.get("title"));
        Assert.assertEquals(expData.get("body"), resJPath.get("body"));
    }

}
