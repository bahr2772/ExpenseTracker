package com.yknotplanning.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Expense {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;



    private String merchantName;
    private String description;
    private BigDecimal amount;
    private String date;

    public Expense() {
    }

    public Expense(String merchantName, String description, BigDecimal amount, String date) {
        this.merchantName = merchantName;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }
    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}