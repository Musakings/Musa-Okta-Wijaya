/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Musza
 */
public class Moluska extends Vertebrata {
    public Moluska(String name, String type, String category, String subcategory) {
        super(name, type, category, subcategory);
    }

    // Metode khusus untuk Moluska
    public void memilikiCangkang() {
        System.out.println(getName() + " memiliki cangkang sebagai pelindung.");
    }

    public void bergerakDenganKakiOtot() {
        System.out.println(getName() + " bergerak menggunakan kaki otot.");
    }
}
