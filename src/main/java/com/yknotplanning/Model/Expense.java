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
    private String item;
    private String category;

    public Expense() {
    }

    public Expense(String merchantName, String description, BigDecimal amount, String date, String item) {
        this.merchantName = merchantName;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.item = item;
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

    public String getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", merchantName='" + merchantName + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                ", item='" + item + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
}