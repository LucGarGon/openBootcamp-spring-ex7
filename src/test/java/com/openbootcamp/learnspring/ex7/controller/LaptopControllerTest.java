package com.openbootcamp.learnspring.ex7.controller;

import com.openbootcamp.learnspring.ex7.domain.Laptop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {
    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void laptops() {
        ResponseEntity<Laptop[]> response =
                testRestTemplate.getForEntity("/laptops", Laptop[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());

    }

    @Test
    void findOneLaptop() {
        ResponseEntity<Laptop> response  =
                testRestTemplate.getForEntity("/laptop/1", Laptop.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void crearLaptop() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = "{\n" +
                "\t\"modelo\": \"LPA1\",\n" +
                "\t\"marca\": \"Dell\",\n" +
                "\t\"precio\": 12.2\n" +
                "}";

        HttpEntity<String> request = new HttpEntity<>(json,headers);

        ResponseEntity<Laptop> response = testRestTemplate.exchange("/crearLaptop", HttpMethod.POST, request, Laptop.class);

        Laptop result = response.getBody();

        assertEquals(7L, result.getId());
        assertEquals("LPA1", result.getModelo());
    }

    @Test
    void deleteLaptop() {
        ResponseEntity<Laptop> response  =
                testRestTemplate.exchange("/deleteLaptop/1",  HttpMethod.DELETE, null,  Laptop.class);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void updateLaptop() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = "{\n" +
                "\t\"id\": \"1\",\n" +
                "\t\"modelo\": \"LPA1\",\n" +
                "\t\"marca\": \"Dell\",\n" +
                "\t\"precio\": 12.2\n" +
                "}";

        HttpEntity<String> request = new HttpEntity<>(json,headers);

        ResponseEntity<Laptop> response = testRestTemplate.exchange("/crearLaptop", HttpMethod.POST, request, Laptop.class);

        Laptop result = response.getBody();

        assertEquals(7L, result.getId());
        assertEquals("LPA1", result.getModelo());
    }


}