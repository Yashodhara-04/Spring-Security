package com.SpringSecure.SpringSecurity.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String get(HttpServletRequest httpServletRequest)
    {
        return "Hii Welcome!!" + httpServletRequest.getSession().getId();
    }

    @GetMapping("/getCsrfToken")
    public CsrfToken getCsrfToken(HttpServletRequest httpServletRequest)
    {
        return (CsrfToken) httpServletRequest.getAttribute("_csrf");
    }
}
