package org.example;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;

import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static org.example.stubs.PaymentStub.setupPaymentStubs;

//import org.junit.jupiter.api.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SpringBootApplication
public class Main {


    public static WireMockServer wireMockServer;

    public static void main(String[] args) throws InterruptedException, AWTException {


//        RestAssured.baseURI = "https://dogapi.dog";
//
//        given()
//                .contentType(ContentType.JSON)
//                .when()
//                .get("/api/v2/breeds/e7e99424-d514-4b56-9f0c-05736f6dd22d")
//                .then()
//                .log()
//                .all()
//                .statusCode(200)
//                .contentType(ContentType.JSON)
//
//                // data
//                .body("data.id", org.hamcrest.Matchers.equalTo("e7e99424-d514-4b56-9f0c-05736f6dd22d"))
//                .body("data.type", org.hamcrest.Matchers.equalTo("breed"))
//
//                // attributes
//                .body("data.attributes.name", org.hamcrest.Matchers.equalTo("Akita"))
//
//                .body("data.attributes.life.min", org.hamcrest.Matchers.equalTo(10))
//                .body("data.attributes.life.max", org.hamcrest.Matchers.equalTo(12))
//
//                .body("data.attributes.male_weight.min", org.hamcrest.Matchers.equalTo(35))
//                .body("data.attributes.male_weight.max", org.hamcrest.Matchers.equalTo(60))
//
//                .body("data.attributes.female_weight.min", org.hamcrest.Matchers.equalTo(35))
//                .body("data.attributes.female_weight.max", org.hamcrest.Matchers.equalTo(50))
//
//                .body("data.attributes.description",
//                        org.hamcrest.Matchers.equalTo("The Akita is a large, muscular dog breed that originated in Japan. They are known for their loyalty and courage."))
//
//                .body("data.attributes.hypoallergenic", org.hamcrest.Matchers.equalTo(false))
//
//                // links
//                .body("links.self",
//                        org.hamcrest.Matchers.equalTo("https://dogapi.dog/api/v2/breeds/e7e99424-d514-4b56-9f0c-05736f6dd22d"))
//
//                // extra validations
//                .body("data", notNullValue())
//                .body("data.attributes", notNullValue());


//        try {
        startServer();


//            RestAssured.baseURI = "http://localhost";
//            RestAssured.port = 8089;
//
//            given()
//                    .contentType(ContentType.JSON)
//                    .when()
//                    .get("/payment/123e4567-e89b-12d3-a456-426614174000")
//                    .then()
//                    .statusCode(200)
//                    .contentType(ContentType.JSON)
//                    .body("paid", org.hamcrest.Matchers.equalTo(true))
//                    .body("requestedAt", notNullValue());
//
//            System.out.println("Test passed successfully!");
//
//            given()
//                    .contentType(ContentType.JSON)
//                    .when()
//                    .get("/payment/11111111-2222-3333-4444-555555554555")
//                    .then()
//                    .statusCode(400)
//                    .contentType(ContentType.JSON)
//                    .body("errorCode", org.hamcrest.Matchers.equalTo("NOT_FOUND"))
//                    .body("errorMessage", org.hamcrest.Matchers.equalTo("Payment not found"));
//
//            System.out.println("Test passed successfully!");


//        } finally {
//            stopServer();
//        }
        while (true) {
            Thread.sleep(10000);
            System.out.println("Server Running: " + wireMockServer.isRunning());
        }
    }

    static void startServer() {
        wireMockServer = new WireMockServer(8089);
        configureFor("localhost", 8089);
        wireMockServer.start();
        setupPaymentStubs();
    }

    static void stopServer() {
        wireMockServer.stop();

    }
}