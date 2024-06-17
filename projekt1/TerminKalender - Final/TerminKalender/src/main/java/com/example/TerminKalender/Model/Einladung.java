package com.example.TerminKalender.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Einladung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    long terminId;

    long invitedId;

    long erstellnerId;


    public Einladung() {
    }

    public Einladung(long terminId, long invitedId, long erstellnerId) {
        this.terminId = terminId;
        this.invitedId = invitedId;
        this.erstellnerId = erstellnerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getTerminId() {
        return terminId;
    }

    public void setTerminId(long terminId) {
        this.terminId = terminId;
    }

    public long getInvitedId() {
        return invitedId;
    }

    public void setInvitedId(long invitedId) {
        this.invitedId = invitedId;
    }

    public long getErstellnerId() {
        return erstellnerId;
    }

    public void setErstellnerId(long erstellnerId) {
        this.erstellnerId = erstellnerId;
    }

    @Override
    public String toString() {
        return "Einladung{" +
                "id=" + id +
                ", terminId=" + terminId +
                ", invitedId=" + invitedId +
                ", erstellnerId=" + erstellnerId +
                '}';
    }
}


