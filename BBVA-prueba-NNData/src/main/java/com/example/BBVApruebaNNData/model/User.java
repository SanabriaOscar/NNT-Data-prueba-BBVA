package com.example.BBVApruebaNNData.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name ="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column( length = 40)
    private  String firstName;
    @Column( length = 40)
    private  String secondName;
    @Column( length = 40)
    private  String firstLastName;
    @Column( length = 40)
    private  String secondLastName;
    @Column( length = 60)
    private  int phoneNumber;
    @Column( length = 40)
    private  String identification;
    @Column( length = 40)
    private  String address;
    @Column( length = 40)
    private String city;

   @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private DocumentType documentType;

    public User(int i, String oscar, String jesus, String sanabria, String tavera, int i1, int i2, String s, String kennedy, DocumentType documentType) {

    }

    public User() {

    }
}
