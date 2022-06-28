package com.example.BBVApruebaNNData.model;

import javax.persistence.*;

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
    private  int identification;
    @Column( length = 40)
    private  String address;
    @Column( length = 40)
    private String city;

   @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private DocumentType documentType;

    public User(int i, String oscar, String jesus, String sanabria, String tavera, int i1, int i2, String s, String kennedy, DocumentType documentType) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirtLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getIdentification() {
        return identification;
    }

    public void setIdentification(int identification) {
        this.identification = identification;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }
}
