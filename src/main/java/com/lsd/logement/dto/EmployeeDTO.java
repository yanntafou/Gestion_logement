package com.lsd.logement.dto;

import java.time.ZonedDateTime;

public class EmployeeDTO extends AbstractDTO<Integer> {

    private Integer id;
    private String nom;
    private String prenom;
    private String telephone;
    private String fonction;
    private String nas;
    private String stMarital;
    private String salaireHoraire;
    private String address;
    private String persContact;
    private String persTelephone;
    private ZonedDateTime createdAt;
    private ZonedDateTime startDate;
    private ZonedDateTime lastUpdatedAt;

    public EmployeeDTO() {
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getFonction() {
        return this.fonction;
    }

    public void setNas(String nas) {
        this.nas = nas;
    }

    public String getNas() {
        return this.nas;
    }

    public void setStMarital(String stMarital) {
        this.stMarital = stMarital;
    }

    public String getStMarital() {
        return this.stMarital;
    }

    public void setPersContact(String persContact) {
        this.persContact = persContact;
    }

    public String getPersContact() {
        return this.persContact;
    }

    public void setPersTelephone(String persTelephone) {
        this.persTelephone = persTelephone;
    }

    public String getPersTelephone() {
        return this.persTelephone;
    }

    public void setCreatedAt(java.time.ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public java.time.ZonedDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setLastUpdatedAt(java.time.ZonedDateTime lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public java.time.ZonedDateTime getLastUpdatedAt() {
        return this.lastUpdatedAt;
    }

    public String getSalaireHoraire() {
        return salaireHoraire;
    }

    public void setSalaireHoraire(String salaireHoraire) {
        this.salaireHoraire = salaireHoraire;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(ZonedDateTime startDate) {
        this.startDate = startDate;
    }

}
