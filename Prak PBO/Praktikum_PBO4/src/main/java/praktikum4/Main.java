/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum4;

/**
 *
 * @author Musza
 */
public class Main {
    public static void main(String[] args) {
        Pekerja pekerja1= new Pekerja("Musa", 20, "Penambang Emas", 1000000.00);
        System.out.println("\nNama pekerja: " + pekerja1.getNama());
        System.out.println("");
        System.out.println(pekerja1);
        System.out.println("\nMengubah nama pekerja");
        
        pekerja1.setNama("Musa Okta W");
        System.out.println(pekerja1);
    }
}
