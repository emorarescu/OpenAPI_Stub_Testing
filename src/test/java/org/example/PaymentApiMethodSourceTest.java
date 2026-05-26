package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static io.restassured.RestAssured.given;

public class PaymentApiMethodSourceTest {

    static Stream<org.junit.jupiter.params.provider.Arguments> paymentData() {

        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(
                        "123e4567-e89b-12d3-a456-426614174000",
                        200,
                        true
                ),
                org.junit.jupiter.params.provider.Arguments.of(
                        "987f6543-e21b-34d3-b654-123456789abc",
                        200,
                        false
                ),
                org.junit.jupiter.params.provider.Arguments.of(
                        "11111111-2222-3333-4444-555555555315",
                        500,
                        null
                )
        );
    }


    @ParameterizedTest
    @MethodSource("paymentData")
    void shouldValidatePayments(
            String paymentId,
            int expectedStatus,
            Boolean paid
    ) {

        var response =
                given()
                        .baseUri("http://localhost:8089")

                        .when()
                        .get("/payment/" + paymentId)

                        .then()
                        .statusCode(expectedStatus);

        if (expectedStatus == 200) {
            response.body("paid",
                    org.hamcrest.Matchers.equalTo(paid));
        }
    }
}