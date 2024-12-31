/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum5;

/**
 *
 * @author Musza
 */
public class Mobil extends KendaraanDarat{
    int jumlahPintu;
    String model;
    
    @Override
    public void tampilkanInfo() {
        System.out.println("Jumlah Pintu: " + jumlahPintu);
        System.out.println("Model: " + model);
    }
}
