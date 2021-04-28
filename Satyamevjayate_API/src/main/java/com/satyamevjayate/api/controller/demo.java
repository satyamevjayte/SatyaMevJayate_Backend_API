package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.Crime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class demo {
    @GetMapping
    public Principal demo(Principal user)
    {
        return user ;
    }
}
