/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum12;
import java.io.Serializable;
/**
 *
 * @author Musza
 */
public class Produk implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nama;
    private double harga;
    private int stok;

    // Konstruktor tanpa parameter
    public Produk() {
    }

    // Konstruktor dengan parameter
    public Produk(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Metode untuk menampilkan informasi produk
    public void tampilkanInfo() {
        System.out.println("Nama Produk: " + nama);
        System.out.println("Harga: Rp" + harga);
        System.out.println("Stok: " + stok);
    }
}