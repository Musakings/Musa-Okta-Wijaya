/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Musza
 */
public class Reptilia extends Hewan {
    public String carabergerak;
    public String deskripsi;

    public Reptilia(String nama, String habitat, String deskripsi, String carabergerak, String jenishewan) {
        super(nama, habitat, deskripsi, carabergerak, jenishewan);
        this.nama = nama;
        this.habitat = habitat;
        this.deskripsi = deskripsi;
        this.carabergerak = carabergerak;
        this.jenishewan= jenishewan;
    }
    
    @Override
    public String getInformasi() {
        return "Nama: " + nama + 
        "\nHabitat: " + habitat +
        "\nDeskripsi:" + deskripsi +
        "\nCarabergerak: " + carabergerak+
        "\nJenis:" + jenishewan;
    }
}
