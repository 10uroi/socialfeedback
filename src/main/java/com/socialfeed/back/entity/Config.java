package com.socialfeed.back.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "configuration")
public class Config {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String key;
    private String value;

}
