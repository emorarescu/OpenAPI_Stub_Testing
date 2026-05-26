package org.example;

import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class TestPayment {


    @Step
    @Tag("test")
    @ParameterizedTest
    @CsvSource({
            "e7e99424-d514-4b56-9f0c-05736f6dd22d",
            "987f6543-e21b-34d3-b654-123456789abc",
            "11111111-2222-3333-4444-555555555555"
    })
//    @CsvFileSource(
//            resources = "/test-data/payments.csv",
//            numLinesToSkip = 1
//    )
    public void getBreedById(String breedId) {

        Response as =
        SerenityRest
                .given()
                .contentType("application/json")
                .when()
                .get("https://dogapi.dog/api/v2/breeds/" + breedId);

        System.out.println(as.body().prettyPrint());

    }


}
