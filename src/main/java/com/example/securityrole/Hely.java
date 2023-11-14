package com.example.securityrole;
import jakarta.persistence.*;

@Entity
@Table(name = "hely")

public class Hely {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer fkod;

    private Integer moziazon;

    public Integer getFkod() {
        return fkod;
    }

    public void setFkod(Integer fkod) {
        this.fkod = fkod;
    }

    public Integer getMoziazon() {
        return moziazon;
    }

    public void setMoziazon(Integer moziazon) {
        this.moziazon = moziazon;
    }
}
