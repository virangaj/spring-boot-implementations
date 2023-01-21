package com.oauth2.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/oauth2/callback")
    private String returnSuccess(){
        return "Login Completer";
    }
}
