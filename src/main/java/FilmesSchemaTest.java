import groovy.transform.TailRecursive;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class FilmesSchemaTest {

  @Test
  public void contratoFilme(){

    String urlBase = "https://swapi.co/api/";

    given()
            .contentType("application/json")
            .when()
            .get(urlBase.concat("films/1"))
            .then()
            .body(matchesJsonSchemaInClasspath("filmes.json"));
  }
}
