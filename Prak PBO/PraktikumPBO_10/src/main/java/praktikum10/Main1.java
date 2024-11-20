/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum10;

/**
 *
 * @author Musza
 */
public class Main1 {
    public static void main(String[] args) {
        // Membuat objek Elektronik dan Makanan
        Elektronik elektronik = new Elektronik();
        Makanan makanan = new Makanan();

        // Contoh harga produk
        double hargaElektronik = 1200000; // Harga dalam rupiah
        double hargaMakanan = 60000;     // Harga dalam rupiah

        // Menghitung pajak
        double pajakElektronik = elektronik.hitungPajak(hargaElektronik);
        double pajakMakanan = makanan.hitungPajak(hargaMakanan);

        // Menampilkan hasil
        System.out.println("Harga Elektronik: Rp " + hargaElektronik);
        System.out.println("Harga Elektronik setelah kena pajak: Rp " + pajakElektronik);
        System.out.println("Harga Makanan: Rp " + hargaMakanan);
        System.out.println("Harga Makanan setelah kena pajak: Rp " + pajakMakanan);
    }
}
