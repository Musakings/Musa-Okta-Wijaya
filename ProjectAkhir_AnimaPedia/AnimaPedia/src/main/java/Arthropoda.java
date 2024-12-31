/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Musza
 */
public class Arthropoda extends Invertebrata {
    public Arthropoda(String name, String type, String category, String subcategory) {
        super(name, type, category, subcategory);
    }

    // Metode khusus untuk Arthropoda
    public void memilikiEksoskeleton() {
        System.out.println(getName() + " memiliki eksoskeleton sebagai pelindung.");
    }

    public void memilikiKakiBersendi() {
        System.out.println(getName() + " memiliki kaki bersendi yang fleksibel.");
    }
}
