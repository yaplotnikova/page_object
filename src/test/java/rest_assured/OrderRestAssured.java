package rest_assured;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.OrderDto;
import dto.PetDto;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrderRestAssured {

    private static final String BASE_URL = "https://petstore.swagger.io/v2";
    private RequestSpecification requestSpecification;

    @BeforeClass
    public void setUp() {
        requestSpecification = new RequestSpecBuilder().setBaseUri(BASE_URL)
                .addHeader("Content-Type", "application/json").build();
    }

    @Test
    @SneakyThrows
    public void createOrder() {
        OrderDto requestOrderId = OrderDto
                .builder()
                .status("delivered")
                .id(90646006l)
                .complete("true")
                .build();
        String orderId = RestAssured
                .given()
                .spec(requestSpecification)
                .body(new ObjectMapper().writeValueAsString(requestOrderId))//from java obj to json
                .when()
                .post("/store/order")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getString("id");

        JsonPath jsonResponseOrderId = RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get("/store/order/"+orderId)
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

        //from json to java obj
        OrderDto responseOrderId = new ObjectMapper().readValue(jsonResponseOrderId.prettify(), OrderDto.class);
        Assert.assertEquals(requestOrderId, responseOrderId);
    }

}
