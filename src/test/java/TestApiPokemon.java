import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TestApiPokemon {

    @Test
    public void test1() {
        String requestBody = """
                {
                    "query": "query getItems{pokemon_v2_item{name,cost}}",
                    "variables": null,
                    "operationName":"getItems"
                }""";

        Response response =
                given()
                        .baseUri("https://beta.pokeapi.co")
                        .basePath("/graphql/v1beta")
                        .header("Content-Type", "application/json")
                        .header("Accept", "*/*")
                        .body(requestBody)
                        .when()
                        .post()
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .extract().response();

        System.out.println(response.asString());
    }

    @Test
    public void test2() {
        Response response =
                given()
                        .baseUri("https://pokeapi.co")
                        .basePath("/api/v2/pokemon/ditto")
                        .header("Content-Type", "application/json")
                        .header("Accept", "*/*")
                        .when()
                        .get()
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .extract().response();

        System.out.println(response.asString());
    }

    @Test
    public void test3() {
        Response response =
                given()
                        .baseUri("https://pokeapi.co")
                        .basePath("/api/v2/pokemon/ditto")
                        .header("Content-Type", "application/json")
                        .header("Accept", "*/*")
                        .when()
                        .get()
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .extract().response();

        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.getString("abilities.ability"));
    }

    @Test
    public void test4() {
        Response response =
                given()
                        .baseUri("https://pokeapi.co")
                        .basePath("/api/v2/pokemon/ditto")
                        .header("Content-Type", "application/json")
                        .header("Accept", "*/*")
                        .when()
                        .get()
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .extract().response();

        String ability = response.jsonPath().getList("abilities.ability.name").get(0).toString();

        Response responseAbility =
                given()
                        .baseUri("https://pokeapi.co")
                        .basePath("api/v2/ability/" + ability)
                        .header("Content-Type", "application/json")
                        .header("Accept", "*/*")
                        .when()
                        .get()
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .extract().response();
        System.out.println(responseAbility.asString());
    }

    @Test
    public void test5() {
        Response response =
                given()
                        .baseUri("https://pokeapi.co")
                        .basePath("/api/v2/pokemon/ditto")
                        .header("Content-Type", "application/json")
                        .header("Accept", "*/*")
                        .when()
                        .get()
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .extract().response();

        String ability = response.jsonPath().getString("abilities.ability.name[0]");

        Response responseAbility =
                given()
                        .baseUri("https://pokeapi.co")
                        .basePath("api/v2/ability/" + ability)
                        .header("Content-Type", "application/json")
                        .header("Accept", "*/*")
                        .when()
                        .get()
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .extract().response();
        System.out.println(responseAbility.asString());
    }

    @Test
    public void test6() {
        Response response =
                given()
                        .baseUri("https://pokeapi.co")
                        .basePath("/api/v2/pokemon/ditto")
                        .header("Content-Type", "application/json")
                        .header("Accept", "*/*")
                        .when()
                        .get()
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .extract().response();

        response.jsonPath().getList("abilities.ability.name").forEach(ability -> {
            Response responseAbility =
                    given()
                            .baseUri("https://pokeapi.co")
                            .basePath("api/v2/ability/" + ability)
                            .header("Content-Type", "application/json")
                            .header("Accept", "*/*")
                            .when()
                            .get()
                            .then()
                            .assertThat()
                            .statusCode(200)
                            .extract().response();
            System.out.println(responseAbility.asString());
        });
    }
}
