/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum_6;

/**
 *
 * @author Musza
 */
public class MainProduk {
    public static void main(String[] args) {
       KeranjangBelanja keranjang = new KeranjangBelanja();

       Produk buku = new Buku("Buku Kisa Nabi", 40000);
       Produk elektronik = new Elektronik("Laptop", 250000);
       Produk pakaian = new Pakaian("Kaos", 85000);

       keranjang.tambahProduk(buku);
       keranjang.tambahProduk(elektronik);
       keranjang.tambahProduk(pakaian);

       keranjang.tampilkanProduk();
       System.out.println("Total Harga setelah Diskon: " + keranjang.hitungTotalHargaSetelahDiskon());
    }
}
