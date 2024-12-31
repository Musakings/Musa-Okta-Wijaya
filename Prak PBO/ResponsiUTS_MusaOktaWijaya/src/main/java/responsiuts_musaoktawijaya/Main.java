/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsiuts_musaoktawijaya;

/**
 *
 * @author Musza
 */
public class Main {
    public static void main(String[] args) {
        //Polimorfisme pada produk
        Produk produk1 = new Elektronik("Play Station", 5000000.00, 2);
        Produk produk2 = new Makanan("Oreo", 2500.0, "30-09-2024");
        
        //Polimorfisme pada Pegawai
        Pegawai pegawai1 = new PegawaiTetap("Musa", 10000000.00, 7000000.00);
        Pegawai pegawai2 = new PegawaiKontrak("Tika", 5000000.00, 10);
        
        //Tampilkan informasi produk
        System.out.println("Informasi Produk:");
        produk1.tampilkanInfo();
        System.out.println();
        produk2.tampilkanInfo();
        
        //Tampilkan informasi pegawai
        System.out.println("\nInformasi Pegawai:");
        pegawai1.tampilkanInfo();
        System.out.println();
        pegawai2.tampilkanInfo();
    }
}
