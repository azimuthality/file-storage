package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/add")
public class SwaggerAPIController {

    @RequestMapping( value = "/file-link", method = GET)
    public String fileLink(){
        return "get";
    }
    @RequestMapping(value = "/list-file", method = GET)
    public String listFile(){
        return "file";
    }
    @RequestMapping(value = "/post", method = POST)
    @ResponseBody
    public String postFos() {
        return "Post";
    }
    @RequestMapping(value = "/delete", method = DELETE)
    public String deleteFos(){
        return "Delete";
    }
    @RequestMapping(value = "/put", method = PUT)
    public String putFos(){
        return "put";
    }

}
