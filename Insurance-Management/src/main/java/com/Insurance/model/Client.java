package com.Insurance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private String contactInfo;

    public Client() {
    }

    public Client(String name, LocalDate dateOfBirth, String address, String contactInfo) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.contactInfo = contactInfo;
    }
}
