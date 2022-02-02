package com.qrcode.WebApp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
public class Object {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_object;

    private String description;
    private BigDecimal price;
    private Date date;

    public Object() {
    }

    public Object(String description, BigDecimal price, Date date) {
        this.description = description;
        this.price = price;
        this.date = date;
    }

    public Long getId_object() {
        return id_object;
    }

    public void setId_object(Long id_object) {
        this.id_object = id_object;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
