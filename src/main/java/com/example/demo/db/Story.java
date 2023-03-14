package com.example.demo.db;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Story")
public class Story implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "uploadDate")
    private double uploadDate;

    @Column(name = "changed")
    private double changed;

}
