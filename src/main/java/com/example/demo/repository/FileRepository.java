package com.example.demo.repository;


import com.example.demo.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public interface FileRepository extends JpaRepository<File, Long> {

    @Query("SELECT t FROM File t")
    List<File> getAll();

    @Query("SELECT t FROM File t WHERE t.id=:id")
    File getFileById(long id);

    @Modifying
    @Query(value = "insert into file_list (file, uuid_identifier) values (:file, :uuid_identifier)", nativeQuery = true)
    void insert(String file, String uuid_identifier);

}
