package org.demo.trifttorest.Rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorE2ETest {


    private final RestTemplate restTemplate = new RestTemplate();


    @Test
    public void testAddEndpointEndToEnd() {
        String baseUrl = "http://localhost:" + 8080 + "/add?num1=7&num2=3";

        ResponseEntity<Integer> response = restTemplate.getForEntity(baseUrl, Integer.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(10, response.getBody());
    }
}
