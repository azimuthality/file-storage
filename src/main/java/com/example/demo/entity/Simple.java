package com.example.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name= "simple")

public class Simple {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")

    private String Id;

    private String name;

    private String type;

    @Lob
    private byte[] data;

    public Simple() {

    }

    public Simple(String name, String type) {

        this.name = name;
        this.type = type;

    }

    public Simple(String name, String type, byte[] data) {

        this.name = name;
        this.type = type;
        this.data = data;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
