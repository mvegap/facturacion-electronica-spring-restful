package com.miguelvega.apifacturaelectronica.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="customers")
public class Customer extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String country_code;

    @NotBlank
    private String document_type_code;

    @NotNull
    private int identity_card;

    @NotBlank
    private String firstname;

    @NotBlank
    private String middlename;

    @NotBlank
    private String lastname;

    @NotBlank
    private String surname;

    @NotBlank
    private String email;

    @NotBlank
    private String gender_code;

    @NotBlank
    private String phone;

    @NotBlank
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getDocument_type_code() {
        return document_type_code;
    }

    public void setDocument_type_code(String document_type_code) {
        this.document_type_code = document_type_code;
    }

    public int getIdentity_card() {
        return identity_card;
    }

    public void setIdentity_card(int identity_card) {
        this.identity_card = identity_card;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender_code() {
        return gender_code;
    }

    public void setGender_code(String gender_code) {
        this.gender_code = gender_code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
