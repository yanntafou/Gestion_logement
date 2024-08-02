package com.lsd.logement.dto;

import java.time.ZonedDateTime;

import com.lsd.logement.entity.Stock.Article;
import com.lsd.logement.entity.Stock.Commande;

public class LigneCommandeDTO extends AbstractDTO<Integer> {

    private Integer id;
    private Commande commande;
    private Article article;
    private int qte;
    private int prixUnitaire;
    private int qteStock;
    private ZonedDateTime createdAt;
    private ZonedDateTime lastUpdatedAt;

    public LigneCommandeDTO() {
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Commande getCommande() {
        return this.commande;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public int getQte() {
        return this.qte;
    }

    public void setPrixUnitaire(int prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public int getPrixUnitaire() {
        return this.prixUnitaire;
    }

    public void setQteStock(int qteStock) {
        this.qteStock = qteStock;
    }

    public int getQteStock() {
        return this.qteStock;
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

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
