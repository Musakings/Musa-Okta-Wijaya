/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum5;

/**
 *
 * @author Musza
 */
public class Main {
    public static void main(String[] args) {
        Mobil mobil = new Mobil();
        mobil.nama = "Ford";
        mobil.kecepatan = 210;
        mobil.jumlahPintu = 2;
        mobil.jumlahRoda = 4;
        mobil.model = "Mustang Shelby GT500";
        mobil.tampilkanInfo();
        
        System.out.println("");
        
        SepedaMotor motor = new SepedaMotor();
        motor.nama = "Kawasaki";
        motor.kecepatan = 110;
        motor.jenisMesin = "2-tak";
        motor.jumlahRoda = 2;
        motor.tampilkanInfo();
    }
}
