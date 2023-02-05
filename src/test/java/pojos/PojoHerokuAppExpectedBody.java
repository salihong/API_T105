package pojos;

import baseUrlKlasoru.HerokuAppBaseUrl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PojoHerokuAppExpectedBody {
    /*
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
    private int bookingid;
    private PojoHerokuAppBooking booking;

}
