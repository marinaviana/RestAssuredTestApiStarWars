import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class PlanetasSchemaTest {

  String urlBase = "https://swapi.co/api/";

  @Test
  public void contratoPlanetas(){

    given()
            .contentType("application/json")
            .when()
            .get(urlBase.concat("planets/1/"))
            .then()
            .body(matchesJsonSchemaInClasspath("planetas.json"));

  }
}
