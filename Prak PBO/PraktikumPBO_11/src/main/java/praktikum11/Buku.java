/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum11;

/**
 *
 * @author Musza
 */
public class Buku {
    private String judul;
    private Pengarang pengarang;
    
    public Buku(String judul, Pengarang pengarang) {
        this.judul = judul;
        this.pengarang = pengarang;
    }
    public void infoBuku() {
        System.out.println("Judul BUku: " + judul);
        pengarang.infoPengarang();
    }
    public void remove() {
        System.out.println("Buku '" + judul + "' dihapus");
    }
}
