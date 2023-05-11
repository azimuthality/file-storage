package com.example.demo.db;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Files")
public class Files implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fileName")
    private String filename;

    @Column(name = "type")
    private String type;

    @Column(name = "size")
    private double size;
    @Column(name = "owner")
    private String owner;
}
