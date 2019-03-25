import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class NavesSchemaTest {

  String urlBase = "https://swapi.co/api/";

  @Test
  public void contratoNaves(){

    given()
            .contentType("application/json")
            .when()
            .get(urlBase.concat("starships/9"))
            .then()
            .body(matchesJsonSchemaInClasspath("naves.json"));
  }
}
