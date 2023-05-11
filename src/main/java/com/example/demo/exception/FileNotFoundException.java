package com.example.demo.exception;

public class FileNotFoundException extends RuntimeException {

    private final long id;

    public FileNotFoundException(long id) {
        this.id = id;
    }
    public String getMessage(int id){
        return ("Could not find file" + id);
    }
}
