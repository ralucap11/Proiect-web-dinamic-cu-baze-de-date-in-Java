package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "utilizatori")
public class Utilizatori {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_utilizator;
    private String nume;
    private String utilizator;
    private String parola;
    private String rolul;


   @OneToMany(mappedBy = "utilizator", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Masini> masini;


    public List<Masini> getMasini() {
        return masini;
    }

    public void setMasini(List<Masini> masini) {
        this.masini = masini;
    }
    public Utilizatori() {
    }

    public Utilizatori(int id_utilizator,String nume, String utilizator, String parola, String rolul) {
    this.id_utilizator = id_utilizator;
        this.nume = nume;
        this.utilizator = utilizator;
        this.parola = parola;
        this.rolul = rolul;
    }


    public int getId_utilizator() {
        return id_utilizator;
    }

    public void setId_utilizator(int id_utilizator) {
        this.id_utilizator = id_utilizator;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getUtilizator() {
        return utilizator;
    }

    public void setUtilizator(String utilizator) {
        this.utilizator = utilizator;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getRolul() {
        return rolul;
    }

    public void setRolul(String rolul) {
        this.rolul = rolul;
    }
}
