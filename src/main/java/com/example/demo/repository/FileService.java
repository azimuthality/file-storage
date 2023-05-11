package com.example.demo.repository;

import com.example.demo.entity.File;

import java.util.List;


public interface FileService {
    File getFileById(long id);
    File insertFile(File file);
    List<File> getAll();
}
