/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum_pbo_3;

/**
 *
 * @author Musa Okta
 */
public class Mobil {
    String merk;
    String model;
    int tahun;
    String warna;
    
    public Mobil(String merk, String model, int tahun, String warna) {
        this.merk = merk;
        this.model = model;
        this.tahun = tahun;
        this.warna = warna;
    }
    public String getMerk() {
        return merk;
    }
    public void setmerk(String merk) {
        this.merk = merk;
    }
    public String getMerk(String merk) {
        return model;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getTahun() {
        return tahun;
    }
    public void setTahun(int tahun) {
        this.tahun = tahun;
    }
    public String getWarna() {
        return warna;
    }
    public void setWarna(String warna) {
        this.warna = warna;
    }
    void displayInfo() {
        System.out.println("Merk mobil: " + getMerk());
        System.out.println("Model: " + getModel());
        System.out.println("Tahun keluaran: " + getTahun());
        System.out.println("Warna mobil: " + getWarna());
    }   
    void startEngine() {
        System.out.println("Mesin mobil " + getMerk() + " Menyala");
    }
    void ubahWarna(String warnaBaru) {
        this.warna = warnaBaru;
        System.out.println("");
        System.out.println("Warna mobil diubah: " + warnaBaru);
        displayInfo();
    }
}