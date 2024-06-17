package com.example.TerminKalender.Model;

public class EinladungInformation {
    Long id;

    int tag;
    int monat;
    int jahr;

    int uhrzeit;
    String beschreibung;

    Long erstellerId;

    String erstellerName;

    Long einladungsId;

    public Long getEinladungsId() {
        return einladungsId;
    }

    public void setEinladungsId(Long einladungsId) {
        this.einladungsId = einladungsId;
    }

    public EinladungInformation(Long id, int tag, int monat, int jahr, int uhrzeit, String beschreibung, Long erstellerId, String erstellerName,Long einladungsId) {
        this.id = id;
        this.tag = tag;
        this.monat = monat;
        this.jahr = jahr;
        this.uhrzeit = uhrzeit;
        this.beschreibung = beschreibung;
        this.erstellerId = erstellerId;
        this.erstellerName = erstellerName;
        this.einladungsId = einladungsId;
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

    public String getErstellerName() {
        return erstellerName;
    }

    public void setErstellerName(String erstellerName) {
        this.erstellerName = erstellerName;
    }

    @Override
    public String toString() {
        return "EinladungInformation{" +
                "id=" + id +
                ", tag=" + tag +
                ", monat=" + monat +
                ", jahr=" + jahr +
                ", uhrzeit=" + uhrzeit +
                ", beschreibung='" + beschreibung + '\'' +
                ", erstellerId=" + erstellerId +
                ", erstellerName='" + erstellerName + '\'' +
                ", einladungsId=" + einladungsId +
                '}';
    }
}




