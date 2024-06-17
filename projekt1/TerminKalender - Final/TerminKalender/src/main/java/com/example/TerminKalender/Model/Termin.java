package com.example.TerminKalender.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Termin")
public class Termin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    int tag;
    int monat;
    int jahr;

    int uhrzeit;
    String beschreibung;

    Long erstellerId;

    @Override
    public String toString() {
        return "Termin{" +
                "id=" + id +
                ", tag=" + tag +
                ", monat=" + monat +
                ", jahr=" + jahr +
                ", uhrzeit=" + uhrzeit +
                ", beschreibung='" + beschreibung + '\'' +
                ", erstellerId=" + erstellerId +
                '}';
    }

    public Termin(int tag, int monta, int jahr, int uhrzeit, String beschreibung) {
        this.tag = tag;
        this.monat = monta;
        this.jahr = jahr;
        this.uhrzeit = uhrzeit;
        this.beschreibung = beschreibung;
    }



    public Termin() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public int getMonat() {
        return monat;
    }

    public void setMonat(int monat) {
        this.monat = monat;
    }

    public int getJahr() {
        return jahr;
    }

    public void setJahr(int jahr) {
        this.jahr = jahr;
    }

    public int getUhrzeit() {
        return uhrzeit;
    }

    public void setUhrzeit(int uhrzeit) {
        this.uhrzeit = uhrzeit;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public Long getErstellerId() {
        return erstellerId;
    }

    public void setErstellerId(Long erstellerId) {
        this.erstellerId = erstellerId;
    }
}
