package com.lsd.logement.entity.personnel;

import java.time.ZonedDateTime;

import com.lsd.logement.entity.AbstractEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee implements AbstractEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNas() {
        return nas;
    }

    public void setNas(String nas) {
        this.nas = nas;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public int getSalaireHoraire() {
        return salaireHoraire;
    }

    public void setSalaireHoraire(int salaireHoraire) {
        this.salaireHoraire = salaireHoraire;
    }

    public String getStMarital() {
        return stMarital;
    }

    public void setStMarital(String stMarital) {
        this.stMarital = stMarital;
    }

    public String getPersContact() {
        return persContact;
    }

    public void setPersContact(String persContact) {
        this.persContact = persContact;
    }

    public String getPersTelephone() {
        return persTelephone;
    }

    public void setPersTelephone(String persTelephone) {
        this.persTelephone = persTelephone;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(ZonedDateTime startDate) {
        this.startDate = startDate;
    }

    @Override
    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public ZonedDateTime getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    @Override
    public void setLastUpdatedAt(ZonedDateTime lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    private String nom;
    private String prenom;
    private String address;
    private String nas;
    private String telephone;
    private String fonction;
    private int salaireHoraire;
    private String stMarital;
    private String persContact;
    private String persTelephone;
    private ZonedDateTime startDate;
    private ZonedDateTime createdAt;
    private ZonedDateTime lastUpdatedAt;

    public Employee() {
    }

}
