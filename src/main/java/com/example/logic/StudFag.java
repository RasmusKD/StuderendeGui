package com.example.logic;

public class StudFag {
    private int stdnr;
    private int fagnr;
    private int kar;

    public StudFag() {
    }

    public StudFag(int stdnr, int fagnr, int kar) {
        this.stdnr = stdnr;
        this.fagnr = fagnr;
        this.kar = kar;
    }

    public int getStdnr() {
        return stdnr;
    }

    public void setStdnr(int stdnr) {
        this.stdnr = stdnr;
    }

    public int getFagnr() {
        return fagnr;
    }

    public void setFagnr(int fagnr) {
        this.fagnr = fagnr;
    }

    public int getKar() {
        return kar;
    }

    public void setKar(int kar) {
        this.kar = kar;
    }
}
