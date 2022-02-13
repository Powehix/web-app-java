package com.qrcode.WebApp.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
public class Object {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_object;

    private String description;

    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "id_room", nullable = false)
    private Room room;

    private BigDecimal price;
    private Date date;

    public Object() {
    }

    public Object(String description, Room room, BigDecimal price, Date date) {
        this.description = description;
        this.room = room;
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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
