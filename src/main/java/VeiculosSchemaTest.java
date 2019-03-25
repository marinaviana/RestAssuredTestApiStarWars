import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class VeiculosSchemaTest {

  @Test
  public void contratoVeiculo(){
    String urlBase = "https://swapi.co/api/";
    given()
            .contentType("aplication/json")
            .when()
            .get(urlBase.concat("vehicles/4"))
            .then()
            .body(matchesJsonSchemaInClasspath("veiculos.json"));
  }
}
