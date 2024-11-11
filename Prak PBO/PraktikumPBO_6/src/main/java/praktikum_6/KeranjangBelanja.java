/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum_6;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Musza
 */
public class KeranjangBelanja {
    private final List<Produk> daftarProduk = new ArrayList<>();

    public void tambahProduk(Produk produk) {
        daftarProduk.add(produk);
    }

    public double hitungTotalHargaSetelahDiskon() {
        double total = 0;
        for (Produk produk : daftarProduk) {
            double hargaSetelahDiskon = produk.getHarga() - produk.hitungDiskon();
            total += hargaSetelahDiskon;
        }
        return total;
    }

    public void tampilkanProduk() {
        for (Produk produk : daftarProduk) {
            System.out.println("Nama Produk: " + produk.getNama() + ", Harga: " + produk.getHarga() + ", Diskon: " + produk.hitungDiskon());
        }
    }
}
