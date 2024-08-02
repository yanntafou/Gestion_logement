package com.lsd.logement.entity.reservation;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lsd.logement.entity.AbstractEntity;
import com.lsd.logement.entity.client.LocataireParticulier;
import com.lsd.logement.entity.client.LocataireSociete;
import com.lsd.logement.entity.finance.Payement;
import com.lsd.logement.entity.finance.Enum.PaymentStatus;
import com.lsd.logement.entity.infrastructure.Local;
import com.lsd.logement.entity.reservation.Enum.BookingState;
import com.lsd.logement.entity.reservation.Enum.PeriodQty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Bail implements AbstractEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)
    private Date dateEntre;

    @Temporal(TemporalType.DATE)
    private Date validate;

    private String numReservation;

    @Enumerated(EnumType.STRING)
    private BookingState statut;

    private int sejour;
    private int echeance;

    @Enumerated(EnumType.STRING)
    private PeriodQty periodQty;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    private ZonedDateTime createdAt;
    private ZonedDateTime lastUpdatedAt;

    @ManyToOne
    @JsonBackReference("local_bail")
    private Local local;

    @ManyToOne
    @JsonBackReference("bail_locataire_societe")
    private LocataireSociete locataireSociete;

    @ManyToOne
    @JsonBackReference("bail_locataire_particulier")
    private LocataireParticulier locataireParticulier;

    @OneToMany(mappedBy = "bail", cascade = CascadeType.ALL)
    @JsonManagedReference("bail_payment")
    private List<Payement> payements;

    public Bail() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateEntre() {
        return dateEntre;
    }

    public void setDateEntre(Date dateEntre) {
        this.dateEntre = dateEntre;
    }

    public Date getValidate() {
        return validate;
    }

    public void setValidate(Date validate) {
        this.validate = validate;
    }

    public String getNumReservation() {
        return numReservation;
    }

    public void setNumReservation(String numReservation) {
        this.numReservation = numReservation;
    }

    public BookingState getStatut() {
        return statut;
    }

    public void setStatut(BookingState statut) {
        this.statut = statut;
    }

    public int getSejour() {
        return sejour;
    }

    public void setSejour(int sejour) {
        this.sejour = sejour;
    }

    public PeriodQty getPeriodQty() {
        return periodQty;
    }

    public void setPeriodQty(PeriodQty periodQty) {
        this.periodQty = periodQty;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
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

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public LocataireSociete getLocataireSociete() {
        return locataireSociete;
    }

    public void setLocataireSociete(LocataireSociete locataireSociete) {
        this.locataireSociete = locataireSociete;
    }

    public LocataireParticulier getLocataireParticulier() {
        return locataireParticulier;
    }

    public void setLocataireParticulier(LocataireParticulier locataireParticulier) {
        this.locataireParticulier = locataireParticulier;
    }

    public List<Payement> getPayements() {
        return payements;
    }

    public void setPayements(List<Payement> payements) {
        this.payements = payements;
    }

    public int getEcheance() {
        return echeance;
    }

    public void setEcheance(int echeance) {
        this.echeance = echeance;
    }
}
