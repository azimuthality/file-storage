package com.example.demo.service;


import com.example.demo.entity.File;
import com.example.demo.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.stream.Stream;


@Service
public class DataBaseService  {

    @Autowired
    private  FileRepository fileRepository;


    public File store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        File file1 = new File(fileName, file.getContentType(), file.getBytes());

        return fileRepository.save(file1);
    }

    public File getFile(String id) {
        return fileRepository.findById(id).get();
    }

    public Stream<File> getAllFile() {
        return fileRepository.findAll().stream();
    }



}
