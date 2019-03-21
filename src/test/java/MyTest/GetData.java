package MyTest;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetData {

    @Test
    public void testResponseCode(){
       Response resp=get("https://reqres.in/api/users?page=2");
       int code=resp.getStatusCode();
        System.out.println("Status  code :"+code);
        Assert.assertEquals(code,200);
        String data1= resp.asString();
        System.out.println(data1);
        //get("/page=2").then().body("page=2.per_page", equalTo(3));

        //get("/page=2").then().body("page=2", is(2));

       /* given().params("firstName", "Eve", "lastName", "Holt").
                when().post("/page=2").
                then().body(data[0].firstName, equalTo("Eve"));*/

        /*hen().
                get("/page=2").
                then().
                body("page=2.data[0].find { it.@id == 4 }.item", hasItems("Eve", "Holt"));


*/    }
}
