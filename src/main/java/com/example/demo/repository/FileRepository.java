package com.example.demo.repository;


import com.example.demo.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface FileRepository extends JpaRepository<File, String> {


}
