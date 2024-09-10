/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum_pbo_3;

/**
 *
 * @author Musa Okta
 */
public class Mobil_Main {
    public static void main(String[] args) {
        System.out.println("Mobil Mussa");
        Mobil Mussa = new Mobil ("Ford", "Mustang Shelby GT500", 2022, "Hitam-Putih");
        Mussa.displayInfo();
        Mussa.startEngine();
        Mussa.ubahWarna("Biru-Putih");
        System.out.println("");
        System.out.println("");
        System.out.println("Mobil Kartika");
        Mobil Kartika = new Mobil ("Lamborgini", "Adventador", 2020, "Hijau");
        Kartika.displayInfo();
        Kartika.startEngine();
        Kartika.ubahWarna("Kuning");
    }
}
