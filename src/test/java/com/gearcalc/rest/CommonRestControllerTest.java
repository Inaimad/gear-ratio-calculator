package com.gearcalc.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CommonRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Value("classpath:samples/sampleCircumference.json")
    private Resource wheelResource;

    @Value("classpath:samples/sampleCalculateSpeed.json")
    private Resource carResource;

    private String wheelJson;
    private String carJson;

    @Before
    public void init() throws IOException {
        File wheelResourceFile = wheelResource.getFile();
        File carResourceFile = carResource.getFile();

        wheelJson = new String(Files.readAllBytes(wheelResourceFile.toPath()));
        carJson = new String(Files.readAllBytes(carResourceFile.toPath()));
    }

    @Test
    public void getWheelCircumference() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/wheel/circumference")
                .accept(MediaType.APPLICATION_JSON).content(wheelJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void getVmaxPerGear() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/calculateSpeed")
                .accept(MediaType.APPLICATION_JSON).content(carJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
}