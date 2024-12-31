/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum5;

/**
 *
 * @author Musza
 */
public class MainHewan {
    public static void main(String[] args) {
        Kucing kucing1 = new Kucing();
        kucing1.nama = "Doraemon";
        kucing1.kelamin = "Jantan";
        kucing1.jenis = "Cyborg";
        kucing1.TampilkanInfo();
        
        System.out.println("");
        
        Anjing anjing2 = new Anjing();
        anjing2.nama = "Sarana";
        anjing2.kelamin = "Betina";
        anjing2.jenis = "Bulldog";
        anjing2.TampilkanInfo();
    }
}
