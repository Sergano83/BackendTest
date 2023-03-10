package Lesson3;

import Lesson3.AbstractTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class SpoonacularTest extends AbstractTest {


    @Test
    void getRequest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "Eastern European")
                .queryParam("query", "soup")
                .queryParam("ingredients", "tomatoes,cow")

                .log().all()

                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .statusCode(200);



        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "steak")
                .queryParam("ingredients", "cow")

                .log().method()

                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .statusCode(200);

        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "pasta")
                .queryParam("cuisine", "italian")
                .queryParam("excludeCuisine", "greek")
                .queryParam("ingredients", "cow")
                .queryParam("diet", "vegetarian")
                .queryParam("intolerances", "gluten")

                .log().params()

                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .statusCode(200);

        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "Ice cream")
                .queryParam("diet", "vegetarian")
                .queryParam("intolerances", "gluten")
                .queryParam("instructionsRequired","true")

                .log().parameters()

                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .statusCode(200);

        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "Chinese")
                .queryParam("includeIngredients", "Pork")

                .log().body()

                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .statusCode(200);

    }

    @Test
    void postRequest(){
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Pork roast with green beans")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200);

        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "fried chicken")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200);

        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Bacon-Apple-Pecan Stuffed French Toast")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200);

        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Mango Fried Rice")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200);

        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Popcorn Ice Cream")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                //test log
                .statusCode(202);

    }

    @Test
    void getResponseData(){
        Response response = given()
                            .when()
                            .get(getBaseUrl()+"recipes/complexSearch?" +
                                    "cuisine=Eastern European&query=soup&ingredients=tomatoes,cow&apiKey=" +getApiKey());

        System.out.println("Date: " + response.getHeader("Date"));

        System.out.println("StatusLine: " + response.getStatusLine());

        System.out.println("Code: " + response.getStatusCode());

        System.out.println("Time: " + response.getTime());



    }
}