package com.lsd.logement.dto;

import java.time.ZonedDateTime;

import com.lsd.logement.entity.TransactionTypeEnum;
import com.lsd.logement.entity.finance.Caisse;

public class TransactionCaisseDTO extends AbstractDTO<Integer> {

    private Integer id;
    private int amount;
    private String paymentMethod;
    private Caisse caisse;
    private TransactionTypeEnum type;
    private ZonedDateTime createdAt;
    private ZonedDateTime lastUpdatedAt;

    public TransactionCaisseDTO() {
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setCaisse(Caisse caisse) {
        this.caisse = caisse;
    }

    public Caisse getCaisse() {
        return this.caisse;
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

    public TransactionTypeEnum getType() {
        return type;
    }

    public void setType(TransactionTypeEnum type) {
        this.type = type;
    }
}
