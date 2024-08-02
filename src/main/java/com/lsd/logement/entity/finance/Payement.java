package com.lsd.logement.entity.finance;

import java.io.Serializable;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lsd.logement.entity.AbstractEntity;
import com.lsd.logement.entity.reservation.Bail;
import com.lsd.logement.entity.reservation.Booking;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Payement implements AbstractEntity<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private ZonedDateTime createdAt;
    private ZonedDateTime lastUpdatedAt;
    private String paymentMethod;
    private int amount;
    private boolean isLast;
    private int rest;
    private int discount;
    @ManyToOne
    @JsonBackReference("payment_booking")
    private Booking booking;
    @ManyToOne
    @JsonBackReference("bail_payment")
    private Bail bail;

    public Payement() {
        this.isLast = false;
        ZonedDateTime currentDateTime = ZonedDateTime.now();
        this.createdAt = currentDateTime;
        this.lastUpdatedAt = currentDateTime;
        this.amount = 0;
        this.rest = 0;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean getIsLast() {
        return isLast;
    }

    public void setIsLast(boolean islast) {
        isLast = islast;
    }

    public int getRest() {
        return rest;
    }

    public void setRest(int rest) {
        this.rest = rest;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Payement{"
                + "id=" + id
                + ", createdAt=" + createdAt
                + ", lastUpdatedAt=" + lastUpdatedAt
                + ", paymentMethod='" + paymentMethod + '\''
                + ", amount=" + amount
                + ", isLast=" + isLast
                + ", rest=" + rest
                + ", booking=" + booking.getSejour()
                + '}';
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Bail getBail() {
        return bail;
    }

    public void setBail(Bail bail) {
        this.bail = bail;
    }
}
