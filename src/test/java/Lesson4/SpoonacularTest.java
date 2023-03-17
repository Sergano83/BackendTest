package Lesson4;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class SpoonacularTest extends AbstractTest{

    @Test
    void getRecipePositiveTest() {
        given().spec(getRequestSpecification())
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(responseSpecification);
    }


    @Test
    void getAccountInfoWithExternalEndpointTest(){
        Response response = given().spec(requestSpecification)
                .when()
                .formParam("title","Burger")
                .post("https://api.spoonacular.com/recipes/cuisine")
                .prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(Response.class);
        assertThat(response.getContentType(), containsString("Json"));
    }



    @Test
    void test(){
        given().spec(requestSpecification)
                .when()
                .formParam("title","Burger")
                .formParam("language", "en")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .statusCode(200);
    }

}
