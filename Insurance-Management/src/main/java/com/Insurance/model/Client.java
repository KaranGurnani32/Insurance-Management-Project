package com.Insurance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Client {

//    Client: Represents a client with properties such as name, date of birth, address,
//    and contact information.

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String dob;
    private String address;
    private String contactInfo;


    public Client() {}

    public Client(String name, String dob, String address, String contactInfo) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.contactInfo = contactInfo;
    }
}
