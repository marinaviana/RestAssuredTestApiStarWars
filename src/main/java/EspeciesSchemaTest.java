import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class EspeciesSchemaTest {

  String urlBase = "https://swapi.co/api/";

  @Test
  public void contratoEspecies(){

    given()
            .contentType("application/json")
            .when()
            .get(urlBase.concat("species/1"))
            .then()
            .body(matchesJsonSchemaInClasspath("especies.json"));

  }
}
