package com.example.securityrole;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "uzenetek")
public class Kapcsolat {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String uzenet;
    private String felado;
    private LocalDateTime created_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUzenet() {
        return uzenet;
    }

    public void setUzenet(String uzenet) {
        this.uzenet = uzenet;
    }

    public String getFelado() {
        return felado;
    }

    public void setFelado(String felado) {
        this.felado = felado;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

}