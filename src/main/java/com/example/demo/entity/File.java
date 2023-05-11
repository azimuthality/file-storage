package com.example.demo.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;

@Entity
@Table(name = "file_list")
public class File {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @Column(name = "file")
    private String file;

    @Column(name = "uuid_identifier")
    private String uuid_identifier;

    public File(){
    }

    public File(String file, String uuid_identifier) {
        this.file = file;
        this.uuid_identifier = uuid_identifier;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getUuid_identifier() {
        return uuid_identifier;
    }

    public void setUuid_identifier(String uuid_identifier) {
        this.uuid_identifier = uuid_identifier;
    }
}
