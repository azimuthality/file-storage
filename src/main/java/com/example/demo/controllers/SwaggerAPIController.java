package com.example.demo.controllers;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/")
public class SwaggerAPIController {
    @GetMapping( value = "/file",
        produces = MediaType.APPLICATION_PDF_VALUE
    )
    public @ResponseBody byte[] getImage() throws IOException {
        InputStream in = getClass()
                .getResourceAsStream("/files/test.pdf/");
        return IOUtils.toByteArray(in);
    }

    @RequestMapping(value = "/list", method = GET)
    public String listFile(){
        return "list-file";
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
        return "Put";
    }

}
