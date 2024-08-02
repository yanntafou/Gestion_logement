package com.lsd.logement.dto;

import java.time.ZonedDateTime;
import java.util.List;

import com.lsd.logement.entity.SousCaisse;
import com.lsd.logement.entity.TransactionCaisse;
import com.lsd.logement.entity.finance.Enum.StatutCaisse;
import com.lsd.logement.entity.personnel.AppUser;

public class CaisseDTO extends AbstractDTO<Integer> {

    private Integer id;
    private String nom;
    private String ref;
    private StatutCaisse status;
    private int solde;
    private AppUser appUser;
    private ZonedDateTime createdAt;
    private ZonedDateTime lastUpdatedAt;
    private ZonedDateTime lastOpening;
    private boolean principal;
    private ZonedDateTime lastClosing;
    private List<TransactionCaisse> transactionCaisses;
    private List<SousCaisse> sousCaisses;

    public CaisseDTO() {
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

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getRef() {
        return this.ref;
    }

    public void setStatus(StatutCaisse status) {
        this.status = status;
    }

    public StatutCaisse getStatus() {
        return this.status;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public int getSolde() {
        return this.solde;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public AppUser getAppUser() {
        return this.appUser;
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

    @Override
    public String toString() {
        return "CaisseDTO{"
                + "id=" + id
                + ", nom='" + nom + '\''
                + ", ref='" + ref + '\''
                + ", status=" + status
                + ", solde=" + solde
                + ", createdBy=" + appUser
                + ", createdAt=" + createdAt
                + ", lastUpdatedAt=" + lastUpdatedAt
                + '}';
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
}
