import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SchemaTest {
  String urlBase = "https://swapi.co/api/";

  @Test
  public void cuidador(){

    given()
            .relaxedHTTPSValidation()
            .contentType("application/json")
            .when()
            .get(urlBase.concat("people/1/"))
            .then()
            .body(matchesJsonSchemaInClasspath("teste.json"));
  }
}
