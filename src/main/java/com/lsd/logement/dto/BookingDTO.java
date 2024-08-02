package com.lsd.logement.dto;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import com.lsd.logement.entity.client.LocataireParticulier;
import com.lsd.logement.entity.client.LocataireSociete;
import com.lsd.logement.entity.finance.Payement;
import com.lsd.logement.entity.finance.Enum.PaymentStatus;
import com.lsd.logement.entity.infrastructure.Local;
import com.lsd.logement.entity.reservation.Enum.BookingState;
import com.lsd.logement.entity.reservation.Enum.PeriodQty;

public class BookingDTO extends AbstractDTO<Integer> {

    private Integer id;
    private Date dateReservation;
    private String nom;
    private String prenom;
    private String telephone;
    private Date validate;
    private String numReservation;
    private int sejour;
    private BookingState statut;
    private PaymentStatus paymentStatus;
    private PeriodQty preriodUnit;
    private ZonedDateTime createdAt;
    private ZonedDateTime lastUpdatedAt;
    private Local local;
    private LocataireSociete locataireSociete;
    private LocataireParticulier locataireParticulier;
    private List<Payement> payements;

    public BookingDTO() {
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    public void setDateReservation(java.util.Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public java.util.Date getDateReservation() {
        return this.dateReservation;
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

    public void setValidate(java.util.Date validate) {
        this.validate = validate;
    }

    public java.util.Date getValidate() {
        return this.validate;
    }

    public void setNumReservation(String numReservation) {
        this.numReservation = numReservation;
    }

    public String getNumReservation() {
        return this.numReservation;
    }

    public void setSejour(int sejour) {
        this.sejour = sejour;
    }

    public int getSejour() {
        return this.sejour;
    }

    public void setStatut(BookingState statut) {
        this.statut = statut;
    }

    public BookingState getStatut() {
        return this.statut;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentStatus getPaymentStatus() {
        return this.paymentStatus;
    }

    public void setPreriodUnit(PeriodQty preriodUnit) {
        this.preriodUnit = preriodUnit;
    }

    public PeriodQty getPreriodUnit() {
        return this.preriodUnit;
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

    public void setLocal(Local local) {
        this.local = local;
    }

    public Local getLocal() {
        return this.local;
    }

    public void setLocataireSociete(LocataireSociete locataireSociete) {
        this.locataireSociete = locataireSociete;
    }

    public LocataireSociete getLocataireSociete() {
        return this.locataireSociete;
    }

    public void setLocataireParticulier(LocataireParticulier locataireParticulier) {
        this.locataireParticulier = locataireParticulier;
    }

    public LocataireParticulier getLocataireParticulier() {
        return this.locataireParticulier;
    }

    public void setPayements(java.util.List<Payement> payements) {
        this.payements = payements;
    }

    public java.util.List<Payement> getPayements() {
        return this.payements;
    }
}
