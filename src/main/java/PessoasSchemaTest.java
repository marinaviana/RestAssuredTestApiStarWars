import com.jayway.restassured.path.json.JsonPath;
import org.junit.Test;


import java.util.HashMap;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertEquals;

public class PessoasSchemaTest {

  String urlBase = "https://swapi.co/api/";

  @Test
  public void contratoPessoa(){

    given()
            .contentType("application/json; charset = UTF-16")
            .when()
            .get(urlBase.concat("people/1"))
            .then()
            .body(matchesJsonSchemaInClasspath("pessoa.json"));
  }

  //Os dois testes asseguir testão o mesmo cenário (Realizar a busca por um personagem existente),
  // se diferenciam pela foma comosão implementados

  @Test
  public void buscaPessoa(){

    String pessoa = given()
            .contentType("application/json")
            .when()
            .get(urlBase.concat("people/?search=lei"))
            .then()
            .extract().response().body().asString();

    assertEquals(pessoa.contains("Leia"), true);

  }

  @Test
  public void buscaPessoaComSucesso() {
    String response = given()
            .contentType("application/json")
            .when()
            .get(urlBase.concat("people/?search=lei"))
            .then()
            .extract().response().body().print();

    final JsonPath jsonPath = new JsonPath(response);
    List<HashMap<String, String>> resultList = jsonPath.get("results");
    assertEquals("Leia Organ", resultList.get(0).get("name"));

  }

  // Realizar uma busca por um personagem inexistente
  // Este teste  é meramente ilustrativo uma vez que
  // a api não retorna nenhuma informação de resultado não encontrado
  // esse teste deveria ser um teste E2E ou a api deveria retonar um 404 ou uma mensagem de item não encontrado
  @Test
  public void buscaPessoaInexistente() {
    given()
            .contentType("application/json")
            .when()
            .get(urlBase.concat("people/?search=marina"))
            .then()
            .statusCode(200);

  }

}
