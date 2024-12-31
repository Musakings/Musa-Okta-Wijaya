
import java.io.File;
import java.net.URL;
import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Musza
 */
public class Hewan {
    public String nama;
    public String Carabergerak;
    public String habitat;
    public String jeniskelamin;
    private final String makananFavorit;
    public String jenishewan;
    
    public Hewan(String nama, String habitat,String jeniskelamin, String makananFavorit, String jenishewan) {
        this.makananFavorit = makananFavorit;
    }

    public String getMakananFavorit() {
        return makananFavorit;
    }

    String getInformasi() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
      public String getJenisHewan() {
        return this.jenishewan; // Menyediakan akses ke properti jenishewan
    }

}
