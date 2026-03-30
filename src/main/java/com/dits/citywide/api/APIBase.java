package com.dits.citywide.api;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class APIBase {

    protected RequestSpecification request;

    @BeforeClass
    public void setupAPI() {

        // Set Base URI
        RestAssured.baseURI = "/users/2";

        // Common Request Specification
        request = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .log().all();
    }
}