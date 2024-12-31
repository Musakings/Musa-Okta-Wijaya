/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Musza
 */
public class Cnidaria extends Invertebrata {
    public Cnidaria(String name, String type, String category, String subcategory) {
        super(name, type, category, subcategory);
    }

    // Metode khusus untuk Cnidaria
    public void memilikiTentakel() {
        System.out.println(getName() + " memiliki tentakel untuk menangkap mangsa.");
    }

    public void menghasilkanRacun() {
        System.out.println(getName() + " menghasilkan racun untuk melumpuhkan mangsanya.");
    }
}

