package com.spring.vaistai.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="vaistai")
public class Vaistai {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id ;

    @NotNull(message = "Įrašykite vaisto pavadinimą")
    @Pattern(regexp = "\\w {4,60}", message = "Leidžiama tik raidės ir skaičiai")
    @Column(name="vaistoPav")
    private String vaistoPav;

    @NotNull(message = "Pasirinkite vaistų grupę")
    @Column(name="vaistuGrupe")
    private String vaistuGrupe;

    @NotNull(message = "Pasirinkite vaisto formą")
    @Column(name="vaistoForma")
    private String vaistoForma;

    @NotNull(message = "Įrašykite veikliąją medžiagą")
    @Pattern(regexp = "[a-zA-Z ]{4,35}", message = "Leidžiama tik raidės")
    @Column(name="veiklMedziaga")
    private String veiklMedziaga;

    @Positive(message = "Įrašykite veikliosios medžiagos kiekį")
    @Column(name="medziagosKiekis")
    private double medziagosKiekis;

    public Vaistai(){}

    public Vaistai(String vaistoPav, String vaistuGrupe, String vaistoForma, String veiklMedziaga, double medziagosKiekis){
        this.vaistoPav = vaistoPav;
        this.vaistuGrupe = vaistuGrupe;
        this.vaistoForma = vaistoForma;
        this.veiklMedziaga = veiklMedziaga;
        this.medziagosKiekis = medziagosKiekis;
    }

    public Vaistai(int id, String vaistoPav, String vaistuGrupe, String vaistoForma, String veiklMedziaga, double medziagosKiekis) {
        this.id = id;
        this.vaistoPav = vaistoPav;
        this.vaistuGrupe = vaistuGrupe;
        this.vaistoForma = vaistoForma;
        this.veiklMedziaga = veiklMedziaga;
        this.medziagosKiekis = medziagosKiekis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVaistoPav() {
        return vaistoPav;
    }

    public void setVaistoPav(String vaistoPav) {
        this.vaistoPav = vaistoPav;
    }

    public String getVaistuGrupe() {
        return vaistuGrupe;
    }

    public void setVaistuGrupe(String vaistuGrupe) {
        this.vaistuGrupe = vaistuGrupe;
    }

    public String getVaistoForma() {
        return vaistoForma;
    }

    public void setVaistoForma(String vaistoForma) {
        this.vaistoForma = vaistoForma;
    }

    public String getVeiklMedziaga() {
        return veiklMedziaga;
    }

    public void setVeiklMedziaga(String veiklMedziaga) {
        this.veiklMedziaga = veiklMedziaga;
    }

    public double getMedziagosKiekis() {
        return medziagosKiekis;
    }

    public void setMedziagosKiekis(double medziagosKiekis) {
        this.medziagosKiekis = medziagosKiekis;
    }

    @Override
    public String toString() {
        return "\nVaistai{" +
                "id=" + id +
                ", vaistoPav='" + vaistoPav + '\'' +
                ", vaistuGrupe='" + vaistuGrupe + '\'' +
                ", vaistoForma='" + vaistoForma + '\'' +
                ", veiklMedziaga='" + veiklMedziaga + '\'' +
                ", medziagosKiekis=" + medziagosKiekis +
                '}';
    }
}
