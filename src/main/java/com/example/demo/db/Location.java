package com.example.demo.db;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "Location")
public class Location implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "yandex")
    private String yandex;
    @Column(name = "google")
    private String google;
    @Column(name = "state")
    private String state;
}
