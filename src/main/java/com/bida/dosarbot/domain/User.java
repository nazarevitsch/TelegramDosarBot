package com.bida.dosarbot.domain;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Table(name = "users")
@Entity(name = "User")
public class User {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @Column(name = "year")
    private int year;

    @Column(name = "month")
    private int month;

    @Column(name = "dosar_number")
    private int dosarNumber;

    @Column(name = "link_id")
    private Long linkId;

    @Column(name = "received_citizenship")
    private boolean receivedCitizenShip;

    public User(){}

    public User(int year, int dosarNumber, Long linkId, boolean receivedCitizenShip){
        this.dosarNumber = dosarNumber;
        this.year = year;
        this.linkId = linkId;
        this.receivedCitizenShip = receivedCitizenShip;
    }

    public User(int year, int dosarNumber, int month, Long linkId, boolean receivedCitizenShip){
        this.dosarNumber = dosarNumber;
        this.year = year;
        this.month = month;
        this.linkId = linkId;
        this.receivedCitizenShip = receivedCitizenShip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDosarNumber() {
        return dosarNumber;
    }

    public void setDosarNumber(int dosarNumber) {
        this.dosarNumber = dosarNumber;
    }

    public Long getLinkId() {
        return linkId;
    }

    public void setLinkId(Long linkId) {
        this.linkId = linkId;
    }

    public boolean isReceivedCitizenShip() {
        return receivedCitizenShip;
    }

    public void setReceivedCitizenShip(boolean receivedCitizenShip) {
        this.receivedCitizenShip = receivedCitizenShip;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", year=" + year +
                ", month=" + month +
                ", dosarNumber=" + dosarNumber +
                ", linkId=" + linkId +
                '}';
    }
}
