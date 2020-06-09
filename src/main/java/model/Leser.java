package model;

public class Leser {
    private int leserId;
    private String lesername;
    private int geburtsjahr;

    public int getLeserId() {
        return leserId;
    }

    public void setLeserId(int leserId) {
        this.leserId = leserId;
    }

    public String getLesername() {
        return lesername;
    }

    public void setLesername(String lesername) {
        this.lesername = lesername;
    }

    public int getGeburtsjahr() {
        return geburtsjahr;
    }

    public void setGeburtsjahr(int geburtsjahr) {
        this.geburtsjahr = geburtsjahr;
    }
}
