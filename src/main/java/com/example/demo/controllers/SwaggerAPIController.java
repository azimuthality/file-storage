package com.example.demo.controllers;

import com.example.demo.entity.File;
import com.example.demo.repository.FileService;
import com.example.demo.service.DataBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.ws.rs.core.Request;
import java.util.List;

@RestController
@RequestMapping(value = "/profiles")
public class SwaggerAPIController {

    @Autowired
    private DataBaseService dataBaseService;
    private final FileService fileService;


    public SwaggerAPIController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping(value = "/all")
    public List<File> getAll() {
        return fileService.getAll();
    }

    @GetMapping(value = "/{id:\\d+}")
    public File getFileById(@PathVariable long id) {
        return fileService.getFileById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public File insert(@Valid @RequestBody File file) {
        return dataBaseService.insertFile(file);
    }

}
