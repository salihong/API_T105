package test;

import baseUrlKlasoru.DummyBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.PojoDummyData;
import pojos.PojoDummyExpectedBody;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C29_Get_Pojo extends DummyBaseUrl {

    @Test
    public void get01(){
        // 1 - URL hazirla

        specDummy.pathParams("pp1","employee","pp2",3);

        // 2 - Expected Data hazirla

        PojoDummyData data = new PojoDummyData(3,"Ashton Cox",86000,66,"");

        PojoDummyExpectedBody expBody = new PojoDummyExpectedBody("success",data,"Successfully! Record has been fetched.");

        // 3 - Response'i kaydet

        Response response = given().spec(specDummy).when().get("/{pp1}/{pp2}");

        // 4 - Assertion

        PojoDummyExpectedBody respPojo = response.as(PojoDummyExpectedBody.class);
        /*
        assertEquals(expBody.getStatus(),respPojo.getStatus());
        assertEquals(expBody.getMessage(),respPojo.getMessage());
        assertEquals(expBody.getData().getEmployee_name(),respPojo.getData().getEmployee_name());
        assertEquals(expBody.getData().getEmployee_salary(),respPojo.getData().getEmployee_salary());
        assertEquals(expBody.getData().getEmployee_age(),respPojo.getData().getEmployee_age());
        assertEquals(expBody.getData().getProfile_image(),respPojo.getData().getProfile_image());
        assertEquals(expBody.getData().getId(),respPojo.getData().getId());
        */
    }



}
