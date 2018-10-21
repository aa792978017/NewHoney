package com.honeypot.honeypot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class indexController {
    @RequestMapping(value = "/index")
    @ResponseBody
    public String index(){
        return "honeypot,o pp [111dsfasd ";
    }


}

