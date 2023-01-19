package com.security.demo.auth;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    @Autowired
    private AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        try {
            System.out.println(request.toString());
            return ResponseEntity.ok(service.register(request));
        } catch (Exception e) {
            System.out.println(e);

            return ResponseEntity.ok("Bad Request");
        }
    }


    @PostMapping("/authenticate")
    public ResponseEntity<?> register(@RequestBody AuthenticationRequest request) {
        try {
            return ResponseEntity.ok(service.authenticate(request));
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.ok("Bad Request");

        }
    }
}
