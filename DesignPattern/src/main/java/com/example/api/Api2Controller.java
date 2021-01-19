package com.example.api;

import com.example.service.ApiService;
import java.util.Date;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api2")
@Log4j2
public class Api2Controller {

    @Autowired
    ApiService apiService;

    @GetMapping(value = "/{username}")
    public ResponseEntity<String> login(@PathVariable(value = "username") String username) {
        String result = Thread.currentThread().getName()
            + " --- " + username
            + " --- " + Runtime.getRuntime()
            + " --- " + new Date()
            + apiService.hashCode();
        System.out.println(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
