package com.example.demo.controllers;

import java.io.IOException;
import java.util.Arrays;
import com.example.demo.entity.File;
import com.example.demo.message.ResponseFile;
import com.example.demo.service.DataBaseService;
import io.github.classgraph.Resource;
import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/File")
public class SwaggerAPIController {
    @Autowired
    private DataBaseService dataBaseService;

    @PostMapping("/Upload")
    public ResponseFile uploadFile(@RequestParam("file") MultipartFile file) {

        File model = dataBaseService.saveFile(file);

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

    /*@GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) {
        File model = dataBaseService.getFile(fileName);
        return ResponseEntity.ok().
                header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + model.getFileName() + "\"").
                body(new ByteArrayResource(model.getFileData()));


    }*/


    @GetMapping("/Allfiles")
    public  List<File>  getListFiles(Model model) {
        List<File> fileDetails = dataBaseService.getListOfFiles();

        return fileDetails;
    }









    /*@GetMapping("/files")
    public ResponseEntity<List<ResponseFile>> getListFiles() {
        List<ResponseFile> files = dataBaseService.getAllFile().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(dbFile.getId())
                    .toUriString();

            return new ResponseFile(
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        File file = dataBaseService.getFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                .body(file.getData());
    }*/



}
