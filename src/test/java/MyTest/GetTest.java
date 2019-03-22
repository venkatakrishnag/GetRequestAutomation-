package MyTest;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GetTest {

    @Test
    public void GetWeatherDetails(){

        RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.request(Method.GET,"/Hyderabad");
        String responseBody = response.getBody().asString();
        System.out.println("Response body is ==>"+responseBody);
        int statusCode=response.getStatusCode();
        Assert.assertEquals(statusCode,200, "Correct status code returned");
        String statusLine = response.statusLine();
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK","Correct status code returned");
        String contentType = response.header("Content-Type");
        System.out.println("Content-type value :"+contentType);
        long time = response.getTime();
        System.out.println("Response Time :"+time);
        String serverType=response.header("server");
        System.out.println("server value :"+serverType);
        String acceptLanguage=response.header("Content-Encoding");
        System.out.println("Content-Encoding :"+acceptLanguage);

        Headers allHeaders = response.headers();
        for(Header header : allHeaders)
        {
            System.out.println("Key: " + header.getName() +" Value: " + header.getValue());
        }

        JsonPath jsonData=response.jsonPath();
        String city=jsonData.get("City");
        Assert.assertEquals(city,"Hyderabad");
        System.out.println("city name :"+city);
    }
}
