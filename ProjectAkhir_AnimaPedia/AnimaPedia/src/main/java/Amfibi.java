/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Musza
 */
public class Amfibi extends Vertebrata {
    public Amfibi(String name, String type, String category, String subcategory) {
        super(name, type, category, subcategory);
    }

    // Metode khusus untuk Amfibi
    public void hidupDiDuaAlam() {
        System.out.println(getName() + " dapat hidup di darat dan di air.");
    }

    public void bernapasDenganInsangDanParuParu() {
        System.out.println(getName() + " bernapas menggunakan insang saat muda dan paru-paru saat dewasa.");
    }
}
