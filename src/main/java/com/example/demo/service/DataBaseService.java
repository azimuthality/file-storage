package com.example.demo.service;

import com.example.demo.entity.File;
import com.example.demo.repository.FileRepository;
import com.example.demo.repository.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;


@Primary
@Service
public class DataBaseService implements FileService {

    @Autowired
    private final FileRepository fileRepository;
    public DataBaseService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }
    @Override
    public File getFileById(long id) {
        return fileRepository.getFileById(id);
    }

    public File insertFile(File file)
    {
        return fileRepository.save(file);
    }

    @Override
    public List<File> getAll(){
        return fileRepository.findAll();
    }

}
