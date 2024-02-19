package com.example.logic;

import java.util.ArrayList;

public class Studerende {
    private int stdnr;
    private String fnavn;
    private String enavn;
    private String adresse;
    private String postnr;
    private String mobil;
    private char klasse;
    private ArrayList<Fag> tilmeldteFag = new ArrayList<>();

    public Studerende() {
    }

    public Studerende(String fnavn, String enavn, String adresse, String postnr, String mobil, char klasse) {
        this.fnavn = fnavn;
        this.enavn = enavn;
        this.adresse = adresse;
        this.postnr = postnr;
        this.mobil = mobil;
        this.klasse = klasse;
    }

    public Studerende(int stdnr, String fnavn, String enavn, String adresse, String postnr, String mobil, char klasse) {
        this.stdnr = stdnr;
        this.fnavn = fnavn;
        this.enavn = enavn;
        this.adresse = adresse;
        this.postnr = postnr;
        this.mobil = mobil;
        this.klasse = klasse;
    }

    public Studerende(int stdnr, String fnavn, String enavn, String adresse, String postnr, String mobil, char klasse, ArrayList<Fag> tilmeldteFag) {
        this.stdnr = stdnr;
        this.fnavn = fnavn;
        this.enavn = enavn;
        this.adresse = adresse;
        this.postnr = postnr;
        this.mobil = mobil;
        this.klasse = klasse;
        this.tilmeldteFag = tilmeldteFag;
    }


    public int getStdnr() {
        return stdnr;
    }

    public void setStdnr(int stdnr) {
        this.stdnr = stdnr;
    }

    public String getFnavn() {
        return fnavn;
    }

    public void setFnavn(String fnavn) {
        this.fnavn = fnavn;
    }

    public String getEnavn() {
        return enavn;
    }

    public void setEnavn(String enavn) {
        this.enavn = enavn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPostnr() {
        return postnr;
    }

    public void setPostnr(String postnr) {
        this.postnr = postnr;
    }

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public char getKlasse() {
        return klasse;
    }

    public void setKlasse(char klasse) {
        this.klasse = klasse;
    }

    public ArrayList<Fag> getTilmeldteFag() {
        return tilmeldteFag;
    }

    public void setTilmeldteFag(ArrayList<Fag> tilmeldteFag) {
        this.tilmeldteFag = tilmeldteFag;
    }

    @Override
    public String toString() {
        return "Studerende{" +
                "stdnr=" + stdnr +
                ", fnavn='" + fnavn + '\'' +
                ", enavn='" + enavn + '\'' +
                ", adresse='" + adresse + '\'' +
                ", postnr='" + postnr + '\'' +
                ", mobil='" + mobil + '\'' +
                ", klasse=" + klasse +
                ", tilmeldteFag=" + tilmeldteFag +
                '}';
    }
}