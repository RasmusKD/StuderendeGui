package com.example.logic;

public class Fag {
    private int fagnr;
    private String fagNavn;

    public Fag() {
    }

    public Fag(int fagnr, String fagNavn) {
        this.fagnr = fagnr;
        this.fagNavn = fagNavn;
    }

    public int getFagnr() {
        return fagnr;
    }

    public void setFagnr(int fagnr) {
        this.fagnr = fagnr;
    }

    public String getFagNavn() {
        return fagNavn;
    }

    public void setFagNavn(String fagNavn) {
        this.fagNavn = fagNavn;
    }

    @Override
    public String toString() {
        return "Fag{" +
                "fagnr=" + fagnr +
                ", fagNavn='" + fagNavn + '\'' +
                '}';
    }
}