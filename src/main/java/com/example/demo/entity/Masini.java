package com.example.demo.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "masini")
public class Masini {
    @Id
    private String nrInmatriculare;
    private int id_utilizator;
    private String marca;
    private String modelul;
    private String culoarea;
    private int an;
    private int capacitate_cilindrica;
    private String combustibil;
    private int putere;
    private int cuplu;
    private int volum;
    private int pret;

    public Masini() {}

    public Masini(String nrInmatriculare, int id_utilizator, String marca, String modelul, String culoarea, int an, int capacitate_cilindrica, String combustibil, int putere, int cuplu, int volum, int pret) {
        this.nrInmatriculare = nrInmatriculare;
        this.id_utilizator = id_utilizator;
        this.marca = marca;
        this.modelul = modelul;
        this.culoarea = culoarea;
        this.an = an;
        this.capacitate_cilindrica = capacitate_cilindrica;
        this.combustibil = combustibil;
        this.putere = putere;
        this.cuplu = cuplu;
        this.volum = volum;
        this.pret = pret;
    }
    @ManyToOne
    @JoinColumn(name = "id_utilizator",insertable=false, updatable=false)
    private Utilizatori utilizator;
    public String getNrInmatriculare() {
        return nrInmatriculare;
    }

    public void setNrInmatriculare(String nr_inmatriculare) {
        this.nrInmatriculare = nr_inmatriculare;
    }

    public int getId_utilizator() {
        return id_utilizator;
    }

    public void setId_utilizator(int id_utilizator) {
        this.id_utilizator = id_utilizator;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelul() {
        return modelul;
    }

    public void setModelul(String modelul) {
        this.modelul = modelul;
    }

    public String getCuloarea() {
        return culoarea;
    }

    public void setCuloarea(String culoarea) {
        this.culoarea = culoarea;
    }

    public int getAn() {
        return an;
    }

    public void setAn(int an) {
        this.an = an;
    }

    public int getCapacitate_cilindrica() {
        return capacitate_cilindrica;
    }

    public void setCapacitate_cilindrica(int capacitate_cilindrica) {
        this.capacitate_cilindrica = capacitate_cilindrica;
    }

    public String getCombustibil() {
        return combustibil;
    }

    public void setCombustibil(String combustibil) {
        this.combustibil = combustibil;
    }

    public int getPutere() {
        return putere;
    }

    public void setPutere(int putere) {
        this.putere = putere;
    }

    public int getCuplu() {
        return cuplu;
    }

    public void setCuplu(int cuplu) {
        this.cuplu = cuplu;
    }

    public int getVolum() {
        return volum;
    }

    public void setVolum(int volum) {
        this.volum = volum;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public Utilizatori getUtilizator() {
        return utilizator;
    }

    public void setUtilizator(Utilizatori utilizator) {
        this.utilizator = utilizator;
    }
}
