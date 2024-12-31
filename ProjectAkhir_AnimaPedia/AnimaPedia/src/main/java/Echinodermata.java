/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Musza
 */
public class Echinodermata extends Invertebrata {
    public Echinodermata(String name, String type, String category, String subcategory) {
        super(name, type, category, subcategory);
    }

    // Metode khusus untuk Echinodermata
    public void memilikiTubuhBersimetriRadial() {
        System.out.println(getName() + " memiliki tubuh dengan simetri radial.");
    }

    public void bergerakDenganKakiAmbulakral() {
        System.out.println(getName() + " bergerak menggunakan kaki ambulakral.");
    }
}
