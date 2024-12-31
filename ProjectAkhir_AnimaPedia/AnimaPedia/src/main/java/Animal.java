/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Musza
 */
public class Animal {
    private String name;
    private String type;
    private String category;
    private String subcategory;
    private String specialInfo;  // Deskripsi singkat
    private String habitat;     // Habitat hewan
    private String makanan;     // Makanan hewan
    private String ciriKhusus;  // Ciri khas hewan
    private String imagePath;   // Path gambar


    public Animal(String name, String type, String category, String subcategory, String specialInfo, String habitat, String makanan, String ciriKhusus, String imagePath) {
        this.name = name;
        this.type = type;
        this.category = category;
        this.subcategory = subcategory;
        this.specialInfo = specialInfo;
        this.habitat = habitat;
        this.makanan = makanan;
        this.ciriKhusus = ciriKhusus;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public String getSpecialInfo() {
        return specialInfo;
    }

    public String getHabitat() {
        return habitat;
    }

    public String getMakanan() {
        return makanan;
    }

    public String getCiriKhusus() {
        return ciriKhusus;
    }
    public String getImagePath() {
        return imagePath;
    }
}

