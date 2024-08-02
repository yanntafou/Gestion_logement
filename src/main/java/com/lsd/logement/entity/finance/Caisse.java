package com.lsd.logement.entity.finance;

import java.time.ZonedDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lsd.logement.entity.AbstractEntity;
import com.lsd.logement.entity.SousCaisse;
import com.lsd.logement.entity.TransactionCaisse;
import com.lsd.logement.entity.finance.Enum.StatutCaisse;
import com.lsd.logement.entity.personnel.AppUser;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Caisse implements AbstractEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String ref;
    private boolean principal;
    @Enumerated(EnumType.STRING)
    private StatutCaisse status;
    private int solde;
    @ManyToOne()
    @JsonBackReference("caisse_user")
    @JoinColumn(name = "user_id")
    private AppUser user;
    private ZonedDateTime lastOpening;
    private ZonedDateTime lastClosing;
    private ZonedDateTime createdAt;
    private ZonedDateTime lastUpdatedAt;
    @OneToMany(mappedBy = "caisse")
    @JsonManagedReference("caisse_transactions")
    private List<TransactionCaisse> transactionCaisses;

    @OneToMany(mappedBy = "caisse", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JsonManagedReference("sous_caisse")
    private List<SousCaisse> sousCaisses;

    public Caisse() {
    }

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

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
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

    public StatutCaisse getStatus() {
        return status;
    }

    public void setStatus(StatutCaisse status) {
        this.status = status;
    }

    public void setAppUser(AppUser user) {
        this.user = user;
    }

    public AppUser getAppUser() {
        return this.user;
    }

    public ZonedDateTime getLastOpening() {
        return lastOpening;
    }

    public void setLastOpening(ZonedDateTime lastOpening) {
        this.lastOpening = lastOpening;
    }

    public ZonedDateTime getLastClosing() {
        return lastClosing;
    }

    public void setLastClosing(ZonedDateTime lastClosing) {
        this.lastClosing = lastClosing;
    }

    public List<TransactionCaisse> getTransactionCaisses() {
        return transactionCaisses;
    }

    public void setTransactionCaisses(List<TransactionCaisse> transactionCaisses) {
        this.transactionCaisses = transactionCaisses;
    }

    public List<SousCaisse> getSousCaisses() {
        return sousCaisses;
    }

    public void setSousCaisses(List<SousCaisse> sousCaisses) {
        this.sousCaisses = sousCaisses;
    }

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

    @Override
    public String toString() {
        return "Caisse{"
                + "id=" + id
                + ", nom='" + nom + '\''
                + ", ref='" + ref + '\''
                + ", status=" + status
                + ", solde=" + solde
                + ", createdBy=" + user
                + ", createdAt=" + createdAt
                + ", lastUpdatedAt=" + lastUpdatedAt
                + '}';
    }
}
