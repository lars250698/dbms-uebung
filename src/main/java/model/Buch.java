package model;

public class Buch {
    private String isbn;
    private int exemplarNummer;
    private String titel;
    private String autorname;

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

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getAutorname() {
        return autorname;
    }

    public void setAutorname(String autorname) {
        this.autorname = autorname;
    }
}
