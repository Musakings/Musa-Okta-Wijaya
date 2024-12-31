/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Musza
 */
// Kelas Insecta
public class Insecta extends Vertebrata {
    public Insecta(String name, String type, String category, String subcategory) {
        super(name, type, category, subcategory);
    }

    // Metode khusus untuk Insecta
    public void memilikiSayap() {
        System.out.println(getName() + " memiliki sayap untuk terbang.");
    }

    public void metamorfosis() {
        System.out.println(getName() + " mengalami metamorfosis dalam siklus hidupnya.");
    }
}
