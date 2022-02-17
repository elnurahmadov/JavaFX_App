/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_project;

import java.time.LocalDate;

/**
 *
 * @author Asus X
 */
public class Shexs {

    private String ad;
    private String soyad;
    private LocalDate tarix;
    private String email;
    private String telefon;
    private String unvan;
    private int poctkodu;
    private String sheher;

    public Shexs(String ad, String soyad, LocalDate tarix, String email, String telefon, String unvan, int poctkodu, String sheher) {
        this.ad = ad;
        this.soyad = soyad;
        this.tarix = tarix;
        this.email = email;
        this.telefon = telefon;
        this.unvan = unvan;
        this.poctkodu = poctkodu;
        this.sheher = sheher;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public LocalDate getTarix() {
        return tarix;
    }

    public void setTarix(LocalDate tarix) {
        this.tarix = tarix;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public int getPoctkodu() {
        return poctkodu;
    }

    public void setPoctkodu(int poctkodu) {
        this.poctkodu = poctkodu;
    }

    public String getSheher() {
        return sheher;
    }

    public void setSheher(String sheher) {
        this.sheher = sheher;
    }

}
