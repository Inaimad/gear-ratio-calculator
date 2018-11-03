package com.gearcalc.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api")
public class CommonRestController {

    @GetMapping("/test")
    public String testApplication() {
        return "App running OK!";
    }

}