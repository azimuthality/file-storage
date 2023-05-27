package com.example.demo.service;

import com.example.demo.constants.FileErrors;
import com.example.demo.entity.File;
import com.example.demo.exception.FileNotFoundException;
import com.example.demo.exception.FileSaveException;
import com.example.demo.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.nio.file.Files;

@Service
public class DataBaseService  {
    @Autowired
    private FileRepository fileRepository;
    public File saveFile(MultipartFile file) {

        String filename = StringUtils.cleanPath(file.getOriginalFilename());

        try {

            if (filename.contains("...")) {
                throw new FileSaveException(FileErrors.INVALID_FILE + filename);
            }

            File model = new File(filename, file.getContentType(), file.getBytes());
            return fileRepository.save(model);

        } catch (Exception e) {

            throw new FileSaveException(FileErrors.FILE_NOT_STORED, e);
        }

    }

    public File getFile(String fileId) {

        return fileRepository.findById(fileId).orElseThrow(() -> new FileNotFoundException(FileErrors.FILE_NOT_FOUND + fileId));
    }

    public List<File> getListOfFiles(){

        return fileRepository.findAll();
    }

}
