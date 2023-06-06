package com.example.demo.repository;


import com.example.demo.entity.Simple;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<Simple, String> {

}
