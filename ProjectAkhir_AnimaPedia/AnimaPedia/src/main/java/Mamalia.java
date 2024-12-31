/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Musza
 */
public class Mamalia extends Vertebrata {
    public Mamalia(String name, String type, String category, String subcategory) {
        super(name, type, category, subcategory);
    }

    // Metode khusus untuk Mamalia
    public void menyusuiAnak() {
        System.out.println(getName() + " menyusui anaknya.");
    }

    public void memilikiBulu() {
        System.out.println(getName() + " memiliki bulu atau rambut.");
    }
}
