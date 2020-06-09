package model;

import java.util.Date;

public class Ausleihe {

    private String isbn;
    private int exemplarNummer;
    private Date datum;
    private int leserId;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getExemplarNummer() {
        return exemplarNummer;
    }

    public void setExemplarNummer(int exemplarNummer) {
        this.exemplarNummer = exemplarNummer;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getLeserId() {
        return leserId;
    }

    public void setLeserId(int leserId) {
        this.leserId = leserId;
    }
}
