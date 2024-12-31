/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Musza
 */
public class Ikan extends Vertebrata {
    public Ikan(String name, String type, String category, String subcategory) {
        super(name, type, category, subcategory);
    }

    // Metode khusus untuk Ikan
    public void berenang() {
        System.out.println(getName() + " berenang di air.");
    }

    public void bernapasDenganInsang() {
        System.out.println(getName() + " bernapas menggunakan insang.");
    }
}

