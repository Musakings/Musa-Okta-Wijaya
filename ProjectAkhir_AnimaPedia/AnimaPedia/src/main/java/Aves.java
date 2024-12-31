/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Musza
 */
public class Aves extends Vertebrata {
    public Aves(String name, String type, String category, String subcategory) {
        super(name, type, category, subcategory);
    }

    // Metode khusus untuk Aves
    public void terbang() {
        System.out.println(getName() + " dapat terbang.");
    }

    public void bertelur() {
        System.out.println(getName() + " berkembang biak dengan bertelur.");
    }
}
