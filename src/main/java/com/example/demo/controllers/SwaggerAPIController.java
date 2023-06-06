package com.example.demo.controllers;


import java.util.Arrays;
import com.example.demo.entity.Simple;
import com.example.demo.message.ResponseFile;
import com.example.demo.service.DataBaseService;
import io.swagger.models.Model;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.core.io.Resource;


import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/File")
public class SwaggerAPIController {
    @Autowired
    private DataBaseService dataBaseService;

    @PostMapping("/Upload")
    public ResponseFile uploadFile(@RequestParam("file") MultipartFile file) {

        Simple model = dataBaseService.saveFile(file);

        String fileUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/download/").
                path(model.getId()).toUriString();
        return new ResponseFile(model.getName(), model.getType(), fileUri);
    }

    @PostMapping("/UploadMultipleFiles")
    public List<ResponseFile> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files).
                stream().
                map(file -> uploadFile(file)).
                collect(Collectors.toList());
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) {
        Simple model = dataBaseService.getFile(fileName);
        return ResponseEntity.ok().
                header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + model.getName() + "\"").
                body(new ByteArrayResource(model.getData()));


    }

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        Simple simple = dataBaseService.getFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + simple.getName() + "\"")
                .body(simple.getData());
    }

    @GetMapping("/Allfiles")
    public  List<Simple>  getListFiles(Model model) {
        List<Simple> fileDetails = dataBaseService.getListOfFiles();

        return fileDetails;
    }


    

}
