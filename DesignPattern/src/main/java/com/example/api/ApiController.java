package com.example.api;

import com.example.service.ApiService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    ApiService apiService;

    @GetMapping("/thread-code")
    public ResponseEntity<String> getThreadCode() {
        return new ResponseEntity<>(Runtime.getRuntime().toString(), HttpStatus.OK);
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<String> login(@PathVariable(value = "username") String username){
        String result = Thread.currentThread().getName()
            + " --- " + username
            + " --- " + Runtime.getRuntime().toString()
            + " --- " + new Date()
            + apiService.hashCode();

        System.out.println(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
