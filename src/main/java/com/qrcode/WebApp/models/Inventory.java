package com.qrcode.WebApp.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_inventory;

    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "id_room", nullable = false)
    private Room room;

    private String result;
    private Date date;

    public Inventory() {
    }

    public Inventory(Room room, String result, Date date) {
        this.room = room;
        this.result = result;
        this.date = date;
    }

    public Long getId_inventory() {
        return id_inventory;
    }

    public void setId_inventory(Long id_inventory) {
        this.id_inventory = id_inventory;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
