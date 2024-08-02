package com.lsd.logement.entity.finance;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lsd.logement.entity.AbstractEntity;
import com.lsd.logement.entity.finance.Enum.StatusTransfert.StatutTransfert;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class TransfertCaisse implements AbstractEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String transactionRef;
    @ManyToOne
    @JsonBackReference("caisse_transfert_de")
    private Caisse transfertDe;
    @ManyToOne
    @JsonBackReference("caisse_transfert_a")
    private Caisse transfertA;
    private int montant;
    @Enumerated(EnumType.STRING)
    private StatutTransfert statut;
    private ZonedDateTime createdAt;
    private ZonedDateTime lastUpdatedAt;

    public TransfertCaisse() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTransactionRef() {
        return transactionRef;
    }

    public void setTransactionRef(String transactionRef) {
        this.transactionRef = transactionRef;
    }

    public Caisse getTransfertDe() {
        return transfertDe;
    }

    public void setTransfertDe(Caisse transfertDe) {
        this.transfertDe = transfertDe;
    }

    public Caisse getTransfertA() {
        return transfertA;
    }

    public void setTransfertA(Caisse transfertA) {
        this.transfertA = transfertA;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public StatutTransfert getStatut() {
        return statut;
    }

    public void setStatut(StatutTransfert statut) {
        this.statut = statut;
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
}
