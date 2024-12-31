/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Musza
 */
public class Vertebrata {
    private String name;
    private String type;
    private String category;
    private String subcategory;

    // Konstruktor dengan 4 argumen
    public Vertebrata(String name, String type, String category, String subcategory) {
        this.name = name;
        this.type = type;
        this.category = category;
        this.subcategory = subcategory;
    }

    // Getter dan setter (opsional, sesuai kebutuhan)
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
}
