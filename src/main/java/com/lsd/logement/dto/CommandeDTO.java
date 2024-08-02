package com.lsd.logement.dto;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import com.lsd.logement.entity.Stock.FournisseurEntreprise;
import com.lsd.logement.entity.Stock.FournisseurParticulier;
import com.lsd.logement.entity.Stock.LigneCommande;
import com.lsd.logement.entity.Stock.Enum.StatutCommande;

public class CommandeDTO extends AbstractDTO<Integer> {

    private Integer id;
    private String refCmd;
    private String demandeur;
    private StatutCommande statut;
    private ZonedDateTime createdAt;
    private ZonedDateTime lastUpdatedAt;
    private Date dateLivraison;
    private FournisseurEntreprise fournisseurEntreprise;
    private FournisseurParticulier fournisseurParticulier;
    private int prixTotal;
    private List<LigneCommande> ligneCommande;

    public CommandeDTO() {
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    public void setRefCmd(String refCmd) {
        this.refCmd = refCmd;
    }

    public String getRefCmd() {
        return this.refCmd;
    }

    public void setDemandeur(String demandeur) {
        this.demandeur = demandeur;
    }

    public String getDemandeur() {
        return this.demandeur;
    }

    public void setStatut(StatutCommande statut) {
        this.statut = statut;
    }

    public StatutCommande getStatut() {
        return this.statut;
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

    public void setDateLivraison(java.util.Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public java.util.Date getDateLivraison() {
        return this.dateLivraison;
    }

    public FournisseurEntreprise getFournisseurEntreprise() {
        return fournisseurEntreprise;
    }

    public void setFournisseurEntreprise(FournisseurEntreprise fournisseurEntreprise) {
        this.fournisseurEntreprise = fournisseurEntreprise;
    }

    public FournisseurParticulier getFournisseurParticulier() {
        return fournisseurParticulier;
    }

    public void setFournisseurParticulier(FournisseurParticulier fournisseurParticulier) {
        this.fournisseurParticulier = fournisseurParticulier;
    }

    public int getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(int prixTotal) {
        this.prixTotal = prixTotal;
    }

    public List<LigneCommande> getLigneCommande() {
        return ligneCommande;
    }

    public void setLigneCommande(List<LigneCommande> ligneCommande) {
        this.ligneCommande = ligneCommande;
    }
}
