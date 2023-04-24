package com.example.demo.controllers;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/add")
public class SwaggerAPIController {


    @GetMapping( value = "/get-image-with-media-type",
        produces = MediaType.IMAGE_JPEG_VALUE
    )
    public @ResponseBody byte[] getImage() throws IOException {
        InputStream in = getClass()
                .getResourceAsStream("/com/example/demo/files/izo.jpg");
        return IOUtils.toByteArray(in);
    }
    @GetMapping(
            value = "/get-text",
            produces = MediaType.TEXT_HTML_VALUE
    )
    public @ResponseBody byte[] getFile() throws IOException {
        InputStream in = getClass()
                .getResourceAsStream("/com/example/demo/files/text.txt");
        return IOUtils.toByteArray(in);
    }




    @RequestMapping(value = "/list-file", method = GET)
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
