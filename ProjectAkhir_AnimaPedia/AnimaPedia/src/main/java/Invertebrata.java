/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Musza
 */
public class Invertebrata {
    private String name;
    private String type;
    private String category;
    private String subcategory;

    public Invertebrata(String name, String type, String category, String subcategory) {
        this.name = name;
        this.type = type;
        this.category = category;
        this.subcategory = subcategory;
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

    public void displayInfo() {
        System.out.println("Nama: " + name);
        System.out.println("Tipe: " + type);
        System.out.println("Kategori: " + category);
        System.out.println("Subkategori: " + subcategory);
    }
}
