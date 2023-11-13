package com.example.securityrole;

import jakarta.persistence.*;

@Entity
@Table(name = "film")

public class Film {
    @Id
    private String filmcim;
    private Boolean szines;
    private String szinkron;
    private  String szarmazas;
    private String mufaj;
    private  Integer hossz;

    public String getFilmcim() {
        return filmcim;
    }

    public void setFilmcim(String filmcim) {
        this.filmcim = filmcim;
    }

    public Boolean getSzines() {
        return szines;
    }

    public void setSzines(Boolean szines) {
        this.szines = szines;
    }

    public String getSzinkron() {
        return szinkron;
    }

    public void setSzinkron(String szinkron) {
        this.szinkron = szinkron;
    }

    public String getSzarmazas() {
        return szarmazas;
    }

    public void setSzarmazas(String szarmazas) {
        this.szarmazas = szarmazas;
    }

    public Integer getHossz() {
        return hossz;
    }

    public void setHossz(Integer hossz) {
        this.hossz = hossz;
    }

    public String getMufaj() {
        return mufaj;
    }

    public void setMufaj(String mufaj) {
        this.mufaj = mufaj;
    }
}
