/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum11;

/**
 *
 * @author Musza
 */
public class Main {
    public static void main(String[] args) {
        Pengarang p1 = new Pengarang("Pramoedya Ananta Toer");
        Pengarang p2 = new Pengarang("Andrea Hirata");
        
        Buku b1 = new Buku("Bumi Manusia", p1);
        Buku b2 = new Buku("Laskar Pelangi", p2);
        
        Perpustakaan perpustakaan =new Perpustakaan();
        
        perpustakaan.tambahBuku(b1);
        perpustakaan.tambahBuku(b2);
        
        System.out.println("Informasi Perpustakaan:");
        perpustakaan.infoPerpustakaan();
        System.out.println("");
        
        perpustakaan.HapusPerpustakaan();
    }
}
