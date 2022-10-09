package pom.support.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import pom.support.configuration.Endpoint;

public class RestApiUtils {

    private static Response response;
    static String token;

    private RestApiUtils() {

    }

    @BeforeClass
    public static Object getToken() {
        String id = RestAssured.given()
                .relaxedHTTPSValidation()  /*Para não ter problema com certificado*/
                .contentType("application/x-www-form-urlencoded;charset=utf-8")
                .formParam("client_id", "sustentacao")   /*Campos para gerar token - tipo o body*/
                .formParam("client-secret", "0521479962585445-55222")
                .formParam("grant-type", "credentials")
                .when()
                .post(Endpoint.AUTENTICACAO)
                .then()
                .extract()
                .response()
                .path("acess_token") /*nome do campo que gera id*/;
        token = "Bearer " + id;
        return token;

    }

    public static void post(Object body, String endpoint) {
        response = RestAssured.given()
                .header("Authorization", getToken())
                .relaxedHTTPSValidation()
//                .log().ifValidationFails()
                .log().all()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(endpoint)
                .thenReturn()
        ;
    }

    public static Response getResponse() {
        return response;
    }

    public static void patch(String id, String valorAlterar, String endpoint) {
        response = RestAssured.given()
                .header("Authorization", getToken())
                .log().all()
                .relaxedHTTPSValidation()
                .pathParam("idSimulacao", id) /*Nesse exemplo o id passado sofrerá ajuste*/
                .pathParam("valor", valorAlterar) /* Novo Valor que vou colocar*/
                .when()
                .patch(endpoint)
                .thenReturn()
        ;
    }

    public static String getBaseUri(){
        return RestAssured.baseURI;
    }

    public static void get(String endpoint){
        response = RestAssured.given()
                .header("Authorization", getToken())
                .log().all()
                .relaxedHTTPSValidation()
                .when()
                .get(endpoint)
                .thenReturn()
                ;
    }
}
