package test;

import baseUrlKlasoru.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.PojoHerokuAppBooking;
import pojos.PojoHerokuAppExpectedBody;
import pojos.PojoHerokuappBookingDates;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C28_Post_Pojo extends HerokuAppBaseUrl {
    /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
                        Request body
                   {
                        "firstname" : "Ahmet",
                        "lastname" : “Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                 "checkin" : "2021-06-01",
                                 "checkout" : "2021-06-10"
                                          },
                        "additionalneeds" : "wi-fi"
                    }
                        Response Body = Expected Data
                        {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                              }
                    }
         */
    @Test
    public void post01(){

        // 1 - URL ve Body hazirla

        specHerokuApp.pathParam("pp1","booking");

        PojoHerokuappBookingDates bookingDates = new PojoHerokuappBookingDates("2021-06-01","2021-06-10");
        System.out.println("bookingDates = " + bookingDates);
        PojoHerokuAppBooking reqBody =
                new PojoHerokuAppBooking("Ahmet","Bulut",500,false,"wi-fi",bookingDates);
        System.out.println("reqBody = " + reqBody);

        // 2 - Expected Data hazirla

        PojoHerokuAppExpectedBody expBody = new PojoHerokuAppExpectedBody(24,reqBody);
        System.out.println("expBody = " + expBody);
        // 3 - Response'i kaydet

        Response response = given().
                spec(specHerokuApp).
                contentType(ContentType.JSON).
                when().
                body(reqBody).
                post("/{pp1}");

        response.prettyPrint();


        // 4 - Assertion

        PojoHerokuAppExpectedBody respPojo = response.as(PojoHerokuAppExpectedBody.class);

        assertEquals(expBody.getBooking().getFirstname(),respPojo.getBooking().getFirstname());
        assertEquals(expBody.getBooking().getLastname(),respPojo.getBooking().getLastname());
        assertEquals(expBody.getBooking().getTotalprice(),respPojo.getBooking().getTotalprice());
        assertEquals(expBody.getBooking().isDepositpaid(),respPojo.getBooking().isDepositpaid());
        assertEquals(expBody.getBooking().getAdditionalneeds(),respPojo.getBooking().getAdditionalneeds());
        assertEquals(expBody.getBooking().getBookingdates().getCheckin(),respPojo.getBooking().getBookingdates().getCheckin());
        assertEquals(expBody.getBooking().getBookingdates().getCheckout(),respPojo.getBooking().getBookingdates().getCheckout());

    }



}
