package com.astraspecs.restful;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController

public class FirstController {

    // Creating Endpoints

    @GetMapping("/hello!!")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String sayHello(){
        return "Hello from Spring";
    }


    @PostMapping("/post")
    public String post(
            @RequestBody String message
    ){
        return "Request accepted and message is: " + message;
    }

}
