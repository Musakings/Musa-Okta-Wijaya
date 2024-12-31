import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class AnimalApp {
    private JFrame frame;
    private JComboBox<String> typeComboBox;
    private JComboBox<String> categoryComboBox;
    private JComboBox<String> vertebrateComboBox;
    private JComboBox<String> invertebrateComboBox;
    private JButton searchButton;
    private JList<String> animalList;
    private DefaultListModel<String> animalListModel;
    private JEditorPane descriptionTextArea;
    private JLabel imageLabel;
    private JTextField searchField; // Kolom pencarian manual
    private List<String> allAnimals; // Daftar semua hewan untuk pencarian
    

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                AnimalApp window = new AnimalApp();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public AnimalApp() {
        initialize();
    }

    private void initialize() {
        // Frame setup
        frame = new JFrame();
        frame.setTitle("Animal Explorer");
        frame.setBounds(100, 100, 1200, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(15, 15));

        // **Panel untuk Kontrol Pilihan**
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3, 1, 10, 10)); // Menambahkan baris untuk pencarian manual
        controlPanel.setBorder(BorderFactory.createTitledBorder("Kontrol Pilihan"));
        controlPanel.setBackground(new Color(240, 240, 240));
        frame.getContentPane().add(controlPanel, BorderLayout.NORTH);

        // Baris pertama: Tipe dan Kategori
        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        row1.setBackground(new Color(240, 240, 240));
        row1.add(createLabel("Pilih Tipe Hewan:"));
        typeComboBox = new JComboBox<>(new String[]{"Karnivora", "Herbivora", "Omnivora"});
        typeComboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        row1.add(typeComboBox);

        row1.add(createLabel("Pilih Kategori:"));
        categoryComboBox = new JComboBox<>(new String[]{"Vertebrata", "Invertebrata"});
        categoryComboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        categoryComboBox.addActionListener(e -> updateCategoryList());
        row1.add(categoryComboBox);
        controlPanel.add(row1);

        // Baris kedua: Subkategori dan Tombol Cari
        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        row2.setBackground(new Color(240, 240, 240));
        vertebrateComboBox = new JComboBox<>(new String[]{"Mamalia", "Aves", "Reptil", "Amfibi", "Ikan"});
        vertebrateComboBox.setEnabled(false);
        vertebrateComboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        row2.add(vertebrateComboBox);

        invertebrateComboBox = new JComboBox<>(new String[]{"Insecta", "Moluska", "Arthropoda", "Cnidaria", "Echinodermata"});
        invertebrateComboBox.setEnabled(false);
        invertebrateComboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        row2.add(invertebrateComboBox);

        searchButton = new JButton("Cari");
        searchButton.setFont(new Font("Arial", Font.BOLD, 14));
        searchButton.setBackground(new Color(51, 153, 255));
        searchButton.setForeground(Color.WHITE);
        searchButton.addActionListener(this::updateAnimalList);
        row2.add(searchButton);
        controlPanel.add(row2);

        // **Baris Ketiga: Pencarian Manual**
        JPanel row3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        row3.setBackground(new Color(240, 240, 240));
        row3.add(createLabel("Cari Hewan:"));
        searchField = new JTextField(20);
        searchField.setFont(new Font("Arial", Font.PLAIN, 14));
        searchField.addActionListener(this::manualSearch); // Pencarian ketika mengetik
        row3.add(searchField);
        controlPanel.add(row3);

        // **Panel Utama untuk Daftar, Gambar, dan Deskripsi**
        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

        // Panel untuk Daftar Hewan
        animalListModel = new DefaultListModel<>();
        animalList = new JList<>(animalListModel);
        animalList.setFont(new Font("Arial", Font.PLAIN, 14));
        animalList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        animalList.setBackground(new Color(255, 255, 255));
        animalList.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        animalList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedAnimal = animalList.getSelectedValue();
                showAnimalDescription(selectedAnimal);
            }
        });
        JScrollPane listScrollPane = new JScrollPane(animalList);
        listScrollPane.setPreferredSize(new Dimension(250, 0));
        listScrollPane.setBorder(BorderFactory.createTitledBorder("Daftar Hewan"));
        mainPanel.add(listScrollPane, BorderLayout.WEST);

        // Panel untuk Detail (Gambar dan Deskripsi)
        JPanel detailsPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        detailsPanel.setBackground(new Color(240, 240, 240));
        mainPanel.add(detailsPanel, BorderLayout.CENTER);

        // Panel untuk Gambar Hewan
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBorder(BorderFactory.createTitledBorder("Gambar Hewan"));
        imagePanel.setBackground(new Color(255, 255, 255));
        imageLabel = new JLabel("", JLabel.CENTER);
        imageLabel.setPreferredSize(new Dimension(500, 350));
        imagePanel.add(imageLabel, BorderLayout.CENTER);
        detailsPanel.add(imagePanel);

        // Panel untuk Deskripsi Hewan
        JPanel descriptionPanel = new JPanel(new BorderLayout());
        descriptionPanel.setBorder(BorderFactory.createTitledBorder("Deskripsi Hewan"));
        descriptionPanel.setBackground(new Color(255, 255, 255));
        descriptionTextArea = new JEditorPane();
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setContentType("text/html");
        descriptionTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionTextArea);
        descriptionPanel.add(descriptionScrollPane, BorderLayout.CENTER);
        detailsPanel.add(descriptionPanel);

        // Inisialisasi daftar hewan
        allAnimals = new ArrayList<>();
        allAnimals.add("Harimau");
        allAnimals.add("Singa");
        allAnimals.add("Gajah");
        
        allAnimals.add("Burung Hantu");
        allAnimals.add("Kupu-Kupu");
        allAnimals.add("Kuda");
        
        allAnimals.add("Kelinci");
        allAnimals.add("Ikan Paus");
        allAnimals.add("Komodo");
        allAnimals.add("Lebah");
        allAnimals.add("Bintang Laut");
        allAnimals.add("Burung Merak");
        allAnimals.add("Kura-Kura");
        allAnimals.add("Belalang");
        allAnimals.add("Salamander");
        allAnimals.add("Katak Daun");
        allAnimals.add("Ikan Nila");
        allAnimals.add("Babi");
        allAnimals.add("Burung Gagak");
        allAnimals.add("Kadal Lidah Biru");
        allAnimals.add("Katak Hijau Pohon");
        allAnimals.add("Capung");
        allAnimals.add("Cumi-Cumi");
        allAnimals.add("Laba-Laba Serigala");
        allAnimals.add("Ubur-Ubur");
        allAnimals.add("Keong Emas");
        allAnimals.add("Karang Batu");
        allAnimals.add("Bulu Babi");
        allAnimals.add("Kumbang Tanah");
        allAnimals.add("Siput Laut");
        allAnimals.add("Kepiting Bakau");
        allAnimals.add("Ubur-Ubur Cassiopea");
        allAnimals.add("Bintang Laut Pasir");


        

    }

    // Helper Method untuk Label dengan Font Konsisten
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(new Color(51, 51, 51));
        return label;
    }

    private void updateCategoryList() {
    String selectedCategory = (String) categoryComboBox.getSelectedItem();

    // Menampilkan pilihan untuk Vertebrata atau Invertebrata berdasarkan kategori yang dipilih
    if ("Vertebrata".equals(selectedCategory)) {
        vertebrateComboBox.setEnabled(true);  // Aktifkan combobox vertebrata
        invertebrateComboBox.setEnabled(false);  // Nonaktifkan combobox invertebrata
    } else if ("Invertebrata".equals(selectedCategory)) {
        vertebrateComboBox.setEnabled(false);  // Nonaktifkan combobox vertebrata
        invertebrateComboBox.setEnabled(true);  // Aktifkan combobox invertebrata
    } else {
        vertebrateComboBox.setEnabled(false);  // Nonaktifkan kedua combobox jika kategori lain dipilih
        invertebrateComboBox.setEnabled(false);
    }
}



    private void updateAnimalList(ActionEvent e) {
    animalListModel.clear();
    String searchText = searchField.getText().toLowerCase();

    // Jika kolom Cari Hewan tidak kosong, cari berdasarkan nama hewan saja
    if (!searchText.isEmpty()) {
        for (String animal : allAnimals) {
            if (animal.toLowerCase().contains(searchText)) {
                animalListModel.addElement(animal);
            }
        }
    } else {
        // Jika kolom Cari Hewan kosong, gunakan filter tipe, kategori, dan subkategori
        String selectedType = (String) typeComboBox.getSelectedItem();
        String selectedCategory = (String) categoryComboBox.getSelectedItem();
        String selectedSubCategory = "Vertebrata".equals(selectedCategory)
                ? (String) vertebrateComboBox.getSelectedItem()
                : (String) invertebrateComboBox.getSelectedItem();

        if (selectedType == null || selectedCategory == null || selectedSubCategory == null) {
            JOptionPane.showMessageDialog(frame, "Pastikan Anda memilih Tipe, Kategori, dan Subkategori.", 
                                          "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        for (String animal : allAnimals) {
            if (shouldAddAnimal(animal, selectedType, selectedCategory, selectedSubCategory)) {
                animalListModel.addElement(animal);
            }
        }
    }

    // Tampilkan pesan jika tidak ada hasil
    if (animalListModel.isEmpty()) {
        animalListModel.addElement("Tidak ada hewan yang ditemukan.");
    }
}


private boolean shouldAddAnimal(String animal, String selectedType, String selectedCategory, String selectedSubCategory) {
    // Tambahkan logika untuk memeriksa tipe, kategori, dan subkategori lebih fleksibel
    switch (animal) {
        case "Harimau":
            return "Karnivora".equals(selectedType) && "Vertebrata".equals(selectedCategory) && "Mamalia".equals(selectedSubCategory);
        case "Singa":
            return "Karnivora".equals(selectedType) && "Vertebrata".equals(selectedCategory) && "Mamalia".equals(selectedSubCategory);
        case "Gajah":
            return "Herbivora".equals(selectedType) && "Vertebrata".equals(selectedCategory) && "Mamalia".equals(selectedSubCategory);
        
        case "Burung Hantu":
            return "Karnivora".equals(selectedType) && "Vertebrata".equals(selectedCategory) && "Aves".equals(selectedSubCategory);
        case "Kupu-Kupu":
            return "Herbivora".equals(selectedType) && "Invertebrata".equals(selectedCategory) && "Insecta".equals(selectedSubCategory);
        case "Kuda":
            return "Herbivora".equals(selectedType) && "Vertebrata".equals(selectedCategory) && "Mamalia".equals(selectedSubCategory);
        case "Kelinci":
            return "Herbivora".equals(selectedType) && "Vertebrata".equals(selectedCategory) && "Mamalia".equals(selectedSubCategory);
        case "Ikan Paus":
            return "Karnivora".equals(selectedType) 
            && "Vertebrata".equals(selectedCategory) 
            && ("Mamalia".equals(selectedSubCategory) || "Ikan".equals(selectedSubCategory));

        case "Komodo":
            return "Karnivora".equals(selectedType) && "Vertebrata".equals(selectedCategory) && "Reptil".equals(selectedSubCategory);
        case "Lebah":
            return "Herbivora".equals(selectedType) && "Invertebrata".equals(selectedCategory) && "Insecta".equals(selectedSubCategory);
        case "Bintang Laut":
            return "Karnivora".equals(selectedType) && "Invertebrata".equals(selectedCategory) && "Echinodermata".equals(selectedSubCategory);
        case "Burung Merak":
            return "Herbivora".equals(selectedType) && "Vertebrata".equals(selectedCategory) && "Aves".equals(selectedSubCategory);
        case "Kura-Kura":
            return "Herbivora".equals(selectedType) && "Vertebrata".equals(selectedCategory) && "Reptil".equals(selectedSubCategory);
        case "Belalang":
            return "Herbivora".equals(selectedType) 
            && "Invertebrata".equals(selectedCategory) 
            && ("Insecta".equals(selectedSubCategory) || "Arthropoda".equals(selectedSubCategory));

        case "Salamander":
            return "Karnivora".equals(selectedType) && "Vertebrata".equals(selectedCategory) && "Amfibi".equals(selectedSubCategory);
        case "Katak Daun":
            return "Herbivora".equals(selectedType) && "Vertebrata".equals(selectedCategory) && "Amfibi".equals(selectedSubCategory);
        case "Ikan Nila":
            return ("Herbivora".equals(selectedType) || "Omnivora".equals(selectedType)) 
            && "Vertebrata".equals(selectedCategory) 
            && "Ikan".equals(selectedSubCategory);

        case "Babi":
            return "Omnivora".equals(selectedType) && "Vertebrata".equals(selectedCategory) && "Mamalia".equals(selectedSubCategory);
        case "Burung Gagak":
            return "Omnivora".equals(selectedType) && "Vertebrata".equals(selectedCategory) && "Aves".equals(selectedSubCategory);
        case "Kadal Lidah Biru":
            return "Omnivora".equals(selectedType) && "Vertebrata".equals(selectedCategory) && "Reptil".equals(selectedSubCategory);
        case "Katak Hijau Pohon":
            return "Omnivora".equals(selectedType) && "Vertebrata".equals(selectedCategory) && "Amfibi".equals(selectedSubCategory);
        case "Capung":
            return "Karnivora".equals(selectedType) && "Invertebrata".equals(selectedCategory) && "Insecta".equals(selectedSubCategory);
        case "Cumi-Cumi":
            return "Karnivora".equals(selectedType) && "Invertebrata".equals(selectedCategory) && "Moluska".equals(selectedSubCategory);
        case "Laba-Laba Serigala":
            return "Karnivora".equals(selectedType) && "Invertebrata".equals(selectedCategory) && "Arthropoda".equals(selectedSubCategory);
        case "Ubur-Ubur":
            return "Karnivora".equals(selectedType) && "Invertebrata".equals(selectedCategory) && "Cnidaria".equals(selectedSubCategory);
        case "Keong Emas":
            return "Herbivora".equals(selectedType) && "Invertebrata".equals(selectedCategory) && "Moluska".equals(selectedSubCategory);
        case "Karang Batu":
            return "Herbivora".equals(selectedType) && "Invertebrata".equals(selectedCategory) && "Cnidaria".equals(selectedSubCategory);
        case "Bulu Babi":
            return "Herbivora".equals(selectedType) && "Invertebrata".equals(selectedCategory) && "Echinodermata".equals(selectedSubCategory);
        case "Kumbang Tanah":
            return "Omnivora".equals(selectedType) && "Invertebrata".equals(selectedCategory) && "Insecta".equals(selectedSubCategory);
        case "Siput Laut":
            return "Omnivora".equals(selectedType) && "Invertebrata".equals(selectedCategory) && "Moluska".equals(selectedSubCategory);
        case "Kepiting Bakau":
            return "Omnivora".equals(selectedType) && "Invertebrata".equals(selectedCategory) && "Arthropoda".equals(selectedSubCategory);
        case "Ubur-Ubur Cassiopea":
            return "Omnivora".equals(selectedType) && "Invertebrata".equals(selectedCategory) && "Cnidaria".equals(selectedSubCategory);
        case "Bintang Laut Pasir":
            return "Omnivora".equals(selectedType) && "Invertebrata".equals(selectedCategory) && "Echinodermata".equals(selectedSubCategory);


        default:
            return false;
    }
}

// Pencarian manual berdasarkan nama hewan
private void manualSearch(ActionEvent e) {
    String searchText = searchField.getText().toLowerCase();
    animalListModel.clear();
    
    // Filter berdasarkan pencarian manual dan pilihan dropdown yang sudah diterapkan
    for (String animal : allAnimals) {
        String selectedType = (String) typeComboBox.getSelectedItem();
        String selectedCategory = (String) categoryComboBox.getSelectedItem();
        String selectedSubCategory = selectedCategory.equals("Vertebrata")
                ? (String) vertebrateComboBox.getSelectedItem()
                : (String) invertebrateComboBox.getSelectedItem();

        // Periksa jika nama hewan mengandung teks pencarian manual dan cocok dengan tipe, kategori, subkategori yang dipilih
        if (animal.toLowerCase().contains(searchText) && 
            shouldAddAnimal(animal, selectedType, selectedCategory, selectedSubCategory)) {
            animalListModel.addElement(animal);
        }
    }

    // Jika tidak ada hewan yang ditemukan, beri tahu pengguna
    if (animalListModel.isEmpty()) {
        animalListModel.addElement("Tidak ada hewan yang ditemukan.");
    }
}


    private void showAnimalDescription(String selectedAnimal) {
        if (selectedAnimal == null) {
            return; // Avoid null pointer exception if no animal is selected
        }

        String description = "";
        ImageIcon image = null;

        switch (selectedAnimal) {
            case "Harimau":
                description = """
                        <html>
                        <h2>Harimau</h2>
                        <p><b>Tipe:</b> Karnivora</p>
                        <p><b>Kategori:</b> Vertebrata</p>
                        <p><b>Subkategori:</b> Mamalia</p>
                        <p><b>Habitat:</b> Hutan tropis</p>
                        <p><b>Makanan:</b> Daging</p>
                        <p><i>Harimau adalah predator besar dengan garis-garis khas pada tubuhnya.</i></p>
                        </html>
                        """;
                image = new ImageIcon(getClass().getResource("/images/harimau.jpg"));
                break;
            case "Singa":
                description = """
                        <html>
                        <h2>Singa</h2>
                        <p><b>Tipe:</b> Karnivora</p>
                        <p><b>Kategori:</b> Vertebrata</p>
                        <p><b>Subkategori:</b> Mamalia</p>
                        <p><b>Habitat:</b> Savana</p>
                        <p><b>Makanan:</b> Daging</p>
                        <p><i>Singa dikenal sebagai raja hutan dengan surai yang khas pada jantan.</i></p>
                        </html>
                        """;
                image = new ImageIcon(getClass().getResource("/images/singa.jpg"));
                break;
            case "Gajah":
                description = """
                        <html>
                        <h2>Gajah</h2>
                        <p><b>Tipe:</b> Herbivora</p>
                        <p><b>Kategori:</b> Vertebrata</p>
                        <p><b>Subkategori:</b> Mamalia</p>
                        <p><b>Habitat:</b> Hutan dan padang rumput</p>
                        <p><b>Makanan:</b> Rumput, daun, dan buah-buahan</p>
                        <p><i>Gajah adalah mamalia darat terbesar yang hidup di dunia saat ini.</i></p>
                        </html>
                        """;
                image = new ImageIcon(getClass().getResource("/images/gajah.jpg"));
                break;
            case "Kuda":
                description = """
                        <html>
                        <h2>Kuda</h2>
                        <p><b>Tipe:</b> Herbivora</p>
                        <p><b>Kategori:</b> Vertebrata</p>
                        <p><b>Subkategori:</b> Mamalia</p>
                        <p><b>Habitat:</b> Padang rumput</p>
                        <p><b>Makanan:</b> Rumput</p>
                        <p><i>Kuda adalah hewan mamalia yang sering digunakan untuk transportasi dan olahraga berkuda.</i></p>
                        </html>
                        """;
                image = new ImageIcon(getClass().getResource("/images/kuda.jpg"));
                break;
            
            
            case "Kelinci":
                description = """
                        <html>
                        <h2>Kelinci</h2>
                        <p><b>Tipe:</b> Herbivora</p>
                        <p><b>Kategori:</b> Vertebrata</p>
                        <p><b>Subkategori:</b> Mamalia</p>
                        <p><b>Habitat:</b> Padang rumput dan hutan</p>
                        <p><b>Makanan:</b> Rumput, sayuran</p>
                        <p><i>Kelinci adalah mamalia kecil yang dikenal dengan telinga panjang dan gerakannya yang cepat.</i></p>
                        </html>
                        """;
                image = new ImageIcon(getClass().getResource("/images/kelinci.jpg"));
                break;
            case "Ikan Paus":
                description = """
                        <html>
                        <h2>Ikan Paus</h2>
                        <p><b>Tipe:</b> Karnivora</p>
                        <p><b>Kategori:</b> Vertebrata</p>
                        <p><b>Subkategori:</b> Mamalia dan ikan </p>
                        <p><b>Habitat:</b> Lautan</p>
                        <p><b>Makanan:</b> Ikan kecil, plankton</p>
                        <p><i>Ikan paus adalah mamalia laut terbesar yang dikenal dengan kemampuan bernyanyinya.</i></p>
                        </html>
                        """;
                image = new ImageIcon(getClass().getResource("/images/ikan_paus.jpg"));
                break;
            case "Burung Hantu":
                description = """
                        <html>
                        <h2>Burung Hantu</h2>
                        <p><b>Tipe:</b> Karnivora</p>
                        <p><b>Kategori:</b> Vertebrata</p>
                        <p><b>Subkategori:</b> Aves</p>
                        <p><b>Habitat:</b> Hutan, padang rumput</p>
                        <p><b>Makanan:</b> Mamalia kecil, serangga</p>
                        <p><i>Burung hantu dikenal dengan kemampuan berburu pada malam hari dengan pendengaran dan penglihatan yang tajam.</i></p>
                        </html>
                    """;
                image = new ImageIcon(getClass().getResource("/images/burung_hantu.jpg"));
                break;
            case "Kupu-Kupu":
                description = """
                        <html>
                        <h2>Kupu-Kupu</h2>
                        <p><b>Tipe:</b> Herbivora</p>
                        <p><b>Kategori:</b> Invertebrata</p>
                        <p><b>Subkategori:</b> Insecta</p>
                        <p><b>Habitat:</b> Taman dan kebun</p>
                        <p><b>Makanan:</b> Nektar bunga</p>
                        <p><i>Kupu-kupu adalah serangga dengan sayap berwarna-warni yang indah.</i></p>
                        </html>
                    """;
                image = new ImageIcon(getClass().getResource("/images/kupu_kupu.jpg"));
                break;
            case "Komodo":
                description = """
                        <html>
                        <h2>Komodo</h2>
                        <p><b>Tipe:</b> Karnivora</p>
                        <p><b>Kategori:</b> Vertebrata</p>
                        <p><b>Subkategori:</b> Reptil</p>
                        <p><b>Habitat:</b> Pulau tropis</p>
                        <p><b>Makanan:</b> Daging, termasuk bangkai</p>
                        <p><i>Komodo adalah kadal terbesar di dunia yang hanya ditemukan di Indonesia.</i></p>
                        </html>
                    """;
                image = new ImageIcon(getClass().getResource("/images/komodo.jpg"));
                break;
            case "Lebah":
                description = """
                        <html>
                        <h2>Lebah</h2>
                        <p><b>Tipe:</b> Herbivora</p>
                        <p><b>Kategori:</b> Invertebrata</p>
                        <p><b>Subkategori:</b> Insecta</p>
                        <p><b>Habitat:</b> Taman, hutan</p>
                        <p><b>Makanan:</b> Nektar bunga</p>
                        <p><i>Lebah dikenal sebagai penyerbuk tanaman yang penting untuk ekosistem.</i></p>
                        </html>
                    """;
                image = new ImageIcon(getClass().getResource("/images/lebah.jpg"));
                break;

            case "Bintang Laut":
                description = """
                        <html>
                        <h2>Bintang Laut</h2>
                        <p><b>Tipe:</b> Karnivora</p>
                        <p><b>Kategori:</b> Invertebrata</p>
                        <p><b>Subkategori:</b> Echinodermata</p>
                        <p><b>Habitat:</b> Dasar laut</p>
                        <p><b>Makanan:</b> Moluska kecil</p>
                        <p><i>Bintang laut adalah makhluk laut dengan kemampuan regenerasi tinggi.</i></p>
                        </html>
                        """;
                image = new ImageIcon(getClass().getResource("/images/bintang_laut.jpg"));
                break;

            case "Burung Merak":
                description = """
                        <html>
                        <h2>Burung Merak</h2>
                        <p><b>Tipe:</b> Herbivora</p>
                        <p><b>Kategori:</b> Vertebrata</p>
                        <p><b>Subkategori:</b> Aves</p>
                        <p><b>Habitat:</b> Hutan dan padang rumput</p>
                        <p><b>Makanan:</b> Biji-bijian, buah-buahan</p>
                        <p><i>Burung merak dikenal dengan bulunya yang indah dan sering digunakan dalam ritual budaya.</i></p>
                        </html>
                        """;
                image = new ImageIcon(getClass().getResource("/images/burung_merak.jpg"));
                break;

            case "Kura-Kura":
                description = """
                        <html>
                        <h2>Kura-Kura</h2>
                        <p><b>Tipe:</b> Herbivora</p>
                        <p><b>Kategori:</b> Vertebrata</p>
                        <p><b>Subkategori:</b> Reptil</p>
                        <p><b>Habitat:</b> Pantai dan rawa</p>
                        <p><b>Makanan:</b> Rumput laut, tanaman air</p>
                        <p><i>Kura-kura adalah reptil bercangkang yang bergerak lambat dan hidup lama.</i></p>
                        </html>
                        """;
                image = new ImageIcon(getClass().getResource("/images/kura_kura.jpg"));
                break;

            case "Belalang":
                description = """
                        <html>
                        <h2>Belalang</h2>
                        <p><b>Tipe:</b> Herbivora</p>
                        <p><b>Kategori:</b> Invertebrata</p>
                        <p><b>Subkategori:</b> Insecta dan Arthropoda</p>
                        <p><b>Habitat:</b> Padang rumput, ladang, dan area berhutan</p>
                        <p><b>Makanan:</b> Daun, batang tanaman, dan rumput</p>
                        <p><i>Belalang adalah serangga loncat yang memainkan peran penting dalam ekosistem.</i></p>
                        </html>
                        """;
                image = new ImageIcon(getClass().getResource("/images/belalang.jpg"));
                break;
            case "Salamander":
                description = """
                        <html>
                        <h2>Salamander</h2>
                        <p><b>Tipe:</b> Karnivora</p>
                        <p><b>Kategori:</b> Vertebrata</p>
                        <p><b>Subkategori:</b> Amfibi</p>
                        <p><b>Habitat:</b> Hutan basah, sungai, dan rawa</p>
                        <p><b>Makanan:</b> Serangga kecil, cacing, dan invertebrata lainnya</p>
                        <p><i>Salamander adalah amfibi yang memiliki kemampuan regenerasi luar biasa dan sering hidup di tempat-tempat lembap.</i></p>
                        </html>
                        """;
                image = new ImageIcon(getClass().getResource("/images/salamander.jpg"));
                break;
            case "Katak Daun":
                description = """
                        <html>
                        <h2>Katak Daun</h2>
                        <p><b>Tipe:</b> Herbivora</p>
                        <p><b>Kategori:</b> Vertebrata</p>
                        <p><b>Subkategori:</b> Amfibi</p>
                        <p><b>Habitat:</b> Hutan hujan tropis</p>
                        <p><b>Makanan:</b> Daun, tanaman air</p>
                        <p><i>Katak Daun adalah amfibi unik yang sering ditemukan di hutan tropis, dikenal karena warna tubuhnya yang menyerupai dedaunan untuk kamuflase.</i></p>
                        </html>
                        """;
                image = new ImageIcon(getClass().getResource("/images/katak_daun.jpg"));
                break;
            case "Ikan Nila":
                description = """
                        <html>
                        <h2>Ikan Nila</h2>
                        <p><b>Tipe:</b> Herbivora dan omnivora</p>
                        <p><b>Kategori:</b> Vertebrata</p>
                        <p><b>Subkategori:</b> Ikan</p>
                        <p><b>Habitat:</b> Sungai, danau, dan tambak</p>
                        <p><b>Makanan:</b> Alga, tumbuhan air, dan serangga kecil</p>
                        <p><i>Ikan Nila adalah ikan air tawar yang dikenal sebagai sumber protein penting dan sering dibudidayakan di berbagai negara.</i></p>
                        </html>
                        """;
                image = new ImageIcon(getClass().getResource("/images/ikan_nila.jpg"));
                break;
            case "Babi":
                description = """
                        <html>
                        <h2>Babi</h2>
                        <p><b>Tipe:</b> Omnivora</p>
                        <p><b>Kategori:</b> Vertebrata</p>
                        <p><b>Subkategori:</b> Mamalia</p>
                        <p><b>Habitat:</b> Ladang, hutan, peternakan</p>
                        <p><b>Makanan:</b> Buah-buahan, sayuran, serangga, dan sisa makanan</p>
                        <p><i>Babi adalah hewan mamalia yang cerdas dan memiliki penciuman yang tajam. 
                        Mereka memakan berbagai jenis makanan, baik tumbuhan maupun hewan kecil.</i></p>
                        </html>
                        """;
                image = new ImageIcon(getClass().getResource("/images/babi.jpg"));
                break;
            case "Burung Gagak":
                description = """
                        <html>
                        <h2>Burung Gagak</h2>
                        <p><b>Tipe:</b> Omnivora</p>
                        <p><b>Kategori:</b> Vertebrata</p>
                        <p><b>Subkategori:</b> Aves</p>
                        <p><b>Habitat:</b> Hutan, perkotaan</p>
                        <p><b>Makanan:</b> Serangga, buah-buahan, biji-bijian, bangkai</p>
                        <p><i>Burung gagak adalah burung yang cerdas dengan kemampuan mempelajari lingkungan sekitarnya. 
                        Mereka memakan berbagai jenis makanan, baik tumbuhan maupun hewan kecil.</i></p>
                        </html>
                        """;
                image = new ImageIcon(getClass().getResource("/images/burung_gagak.jpg"));
                break;
            case "Kadal Lidah Biru":
                description = """
                        <html>
                        <h2>Kadal Lidah Biru</h2>
                        <p><b>Tipe:</b> Omnivora</p>
                        <p><b>Kategori:</b> Vertebrata</p>
                        <p><b>Subkategori:</b> Reptil</p>
                        <p><b>Habitat:</b> Hutan, padang rumput, daerah semi-kering</p>
                        <p><b>Makanan:</b> Serangga, buah-buahan, sayuran, siput</p>
                        <p><i>Kadal Lidah Biru adalah reptil yang memiliki lidah berwarna biru mencolok. 
                        Mereka memakan berbagai jenis makanan, termasuk serangga dan tumbuhan.</i></p>
                        </html>
                        """;
                image = new ImageIcon(getClass().getResource("/images/kadal_lidah_biru.jpg"));
                break;
            case "Katak Hijau Pohon":
                description = """
                        <html>
                        <h2>Katak Hijau Pohon</h2>
                        <p><b>Tipe:</b> Omnivora</p>
                        <p><b>Kategori:</b> Vertebrata</p>
                        <p><b>Subkategori:</b> Amfibi</p>
                        <p><b>Habitat:</b> Hutan hujan tropis, area dekat sumber air</p>
                        <p><b>Makanan:</b> Serangga kecil, buah, daun</p>
                        <p><i>Katak Hijau Pohon adalah spesies amfibi yang biasanya ditemukan di pohon-pohon. 
                        Mereka memakan berbagai jenis makanan, termasuk serangga dan tumbuhan, untuk bertahan hidup 
                        di lingkungan hutan.</i></p>
                        </html>
                        """;
                image = new ImageIcon(getClass().getResource("/images/katak_hijau_pohon.jpg"));
                break;
            
            case "Capung":
                description = """
                        <html>
                        <h2>Capung</h2>
                        <p><b>Tipe:</b> Karnivora</p>
                        <p><b>Kategori:</b> Invertebrata</p>
                        <p><b>Subkategori:</b> Insecta</p>
                        <p><b>Habitat:</b> Dekat sumber air seperti sungai, danau, dan rawa</p>
                        <p><b>Makanan:</b> Nyamuk, lalat kecil, dan serangga lainnya</p>
                        <p><i>Capung adalah predator tangguh yang berburu mangsa saat terbang. 
                        Mereka memiliki penglihatan yang tajam dan kecepatan terbang tinggi, 
                        menjadikannya efektif dalam mengendalikan populasi serangga kecil seperti nyamuk.</i></p>
                        </html>
                        """;
                image = new ImageIcon(getClass().getResource("/images/capung.jpg"));
                break;
            case "Cumi-Cumi":
                description = """
                        <html>
                        <h2>Cumi-Cumi</h2>
                        <p><b>Tipe:</b> Karnivora</p>
                        <p><b>Kategori:</b> Invertebrata</p>
                        <p><b>Subkategori:</b> Moluska</p>
                        <p><b>Habitat:</b> Lautan, mulai dari perairan dangkal hingga laut dalam</p>
                        <p><b>Makanan:</b> Ikan kecil, udang, dan krustasea lainnya</p>
                        <p><i>Cumi-cumi adalah predator laut yang tangguh dengan tentakel yang digunakan untuk menangkap mangsa. 
                        Mereka memiliki kemampuan berenang cepat dan kamuflase untuk berburu serta menghindari predator.</i></p>
                        </html>
                        """;
                image = new ImageIcon(getClass().getResource("/images/cumi_cumi.jpg"));
                break;
            case "Laba-Laba Serigala":
                description = """
                        <html>
                        <h2>Laba-Laba Serigala</h2>
                        <p><b>Tipe:</b> Karnivora</p>
                        <p><b>Kategori:</b> Invertebrata</p>
                        <p><b>Subkategori:</b> Arthropoda</p>
                        <p><b>Habitat:</b> Hutan, padang rumput, dan area berbatu</p>
                        <p><b>Makanan:</b> Serangga kecil, larva, dan hewan kecil lainnya</p>
                        <p><i>Laba-Laba Serigala adalah predator aktif yang berburu mangsa tanpa menggunakan jaring. 
                        Mereka mengandalkan kecepatan dan penglihatan tajam untuk menangkap serangga kecil.</i></p>
                        </html>
                        """;
                image = new ImageIcon(getClass().getResource("/images/laba_laba_serigala.jpg"));
                break;
            case "Ubur-Ubur":
                description = """
                        <html>
                        <h2>Ubur-Ubur</h2>
                        <p><b>Tipe:</b> Karnivora</p>
                        <p><b>Kategori:</b> Invertebrata</p>
                        <p><b>Subkategori:</b> Cnidaria</p>
                        <p><b>Habitat:</b> Lautan, baik perairan dangkal maupun laut dalam</p>
                        <p><b>Makanan:</b> Plankton, ikan kecil, dan larva</p>
                        <p><i>Ubur-ubur adalah predator laut yang menggunakan tentakel mereka untuk menangkap mangsa. 
                        Tentakel mereka dilengkapi sel penyengat yang melumpuhkan mangsa sebelum dicerna.</i></p>
                        </html>
                        """;
                image = new ImageIcon(getClass().getResource("/images/ubur_ubur.jpg"));
                break;
            case "Keong Emas":
                description = """
                        <html>
                        <h2>Keong Emas</h2>
                        <p><b>Tipe:</b> Herbivora</p>
                        <p><b>Kategori:</b> Invertebrata</p>
                        <p><b>Subkategori:</b> Moluska</p>
                        <p><b>Habitat:</b> Perairan tawar seperti sawah, danau, dan sungai</p>
                        <p><b>Makanan:</b> Daun, ganggang, dan tumbuhan air lainnya</p>
                        <p><i>Keong Emas adalah moluska air tawar yang sering ditemukan di sawah dan perairan dangkal. 
                        Mereka memakan berbagai jenis tumbuhan air dan sering dianggap sebagai hama pada tanaman padi.</i></p>
                        </html>
                        """;
                image = new ImageIcon(getClass().getResource("/images/keong_emas.jpg"));
                break;
            case "Karang Batu":
                description = """
                        <html>
                        <h2>Karang Batu</h2>
                        <p><b>Tipe:</b> Herbivora (melalui hubungan mutualistik)</p>
                        <p><b>Kategori:</b> Invertebrata</p>
                        <p><b>Subkategori:</b> Cnidaria</p>
                        <p><b>Habitat:</b> Terumbu karang di perairan laut tropis</p>
                        <p><b>Makanan:</b> Nutrisi dari zooxanthellae dan partikel organik kecil</p>
                        <p><i>Karang Batu hidup dalam hubungan mutualistik dengan zooxanthellae, alga mikroskopis yang menyediakan energi 
                        melalui fotosintesis. Mereka juga dapat menangkap partikel makanan kecil menggunakan tentakel mereka.</i></p>
                        </html>
                        """;
                image = new ImageIcon(getClass().getResource("/images/karang_batu.jpg"));
                break;
            case "Bulu Babi":
                description = """
                        <html>
                        <h2>Bulu Babi Hijau</h2>
                        <p><b>Tipe:</b> Herbivora</p>
                        <p><b>Kategori:</b> Invertebrata</p>
                        <p><b>Subkategori:</b> Echinodermata</p>
                        <p><b>Habitat:</b> Dasar laut berbatu, terutama di perairan dangkal</p>
                        <p><b>Makanan:</b> Alga, rumput laut</p>
                        <p><i>Bulu Babi Hijau adalah hewan laut yang memakan alga dan tumbuhan laut. Mereka memiliki peran penting dalam menjaga ekosistem laut dengan mencegah pertumbuhan alga yang berlebihan.</i></p>
                        </html>
                        """;
                image = new ImageIcon(getClass().getResource("/images/bulu_babi.jpg"));
                break;
            case "Kumbang Tanah":
                description = """
                        <html>
                        <h2>Kumbang Tanah</h2>
                        <p><b>Tipe:</b> Omnivora</p>
                        <p><b>Kategori:</b> Invertebrata</p>
                        <p><b>Subkategori:</b> Insecta</p>
                        <p><b>Habitat:</b> Tanah, hutan, kebun, dan ladang</p>
                        <p><b>Makanan:</b> Serangga kecil, biji-bijian, bahan organik</p>
                        <p><i>Kumbang Tanah adalah serangga yang memiliki kemampuan untuk memakan berbagai jenis makanan, 
                        termasuk mangsa hidup seperti serangga kecil dan sisa tumbuhan. Mereka membantu mengontrol populasi hama 
                        sekaligus mendaur ulang bahan organik.</i></p>
                        </html>
                        """;
                image = new ImageIcon(getClass().getResource("/images/kumbang_tanah.jpg"));
                break;
            case "Siput Laut":
                description = """
                        <html>
                        <h2>Siput Laut</h2>
                        <p><b>Tipe:</b> Omnivora</p>
                        <p><b>Kategori:</b> Invertebrata</p>
                        <p><b>Subkategori:</b> Moluska</p>
                        <p><b>Habitat:</b> Laut dangkal hingga kedalaman sedang, terutama di terumbu karang</p>
                        <p><b>Makanan:</b> Alga, detritus, organisme kecil seperti hidroid</p>
                        <p><i>Siput Laut adalah hewan laut dari filum Moluska yang memakan alga dan organisme kecil lainnya. 
                        Beberapa spesies juga dapat menyerap racun dari mangsanya untuk digunakan sebagai mekanisme pertahanan.</i></p>
                        </html>
                        """;
                image = new ImageIcon(getClass().getResource("/images/siput_laut.jpg"));
                break;
            case "Kepiting Bakau":
                description = """
                        <html>
                        <h2>Kepiting Bakau</h2>
                        <p><b>Tipe:</b> Omnivora</p>
                        <p><b>Kategori:</b> Invertebrata</p>
                        <p><b>Subkategori:</b> Arthropoda</p>
                        <p><b>Habitat:</b> Hutan bakau, muara sungai</p>
                        <p><b>Makanan:</b> Daun, buah-buahan, bahan organik, dan hewan kecil</p>
                        <p><i>Kepiting Bakau adalah arthropoda yang hidup di ekosistem bakau. Mereka memiliki peran penting dalam daur ulang 
                        bahan organik dan menjaga keseimbangan ekosistem di wilayah pesisir.</i></p>
                        </html>
                        """;
                image = new ImageIcon(getClass().getResource("/images/kepiting_bakau.jpg"));
                break;
            case "Ubur-Ubur Cassiopea":
                description = """
                        <html>
                        <h2>Ubur-Ubur Cassiopea</h2>
                        <p><b>Tipe:</b> Omnivora</p>
                        <p><b>Kategori:</b> Invertebrata</p>
                        <p><b>Subkategori:</b> Cnidaria</p>
                        <p><b>Habitat:</b> Perairan dangkal tropis, dasar laut berlumpur atau berpasir</p>
                        <p><b>Makanan:</b> Plankton, alga (melalui simbiosis dengan zooxanthellae)</p>
                        <p><i>Ubur-Ubur Cassiopea adalah spesies unik yang hidup di dasar laut dengan posisi terbalik. 
                        Mereka mendapatkan energi dari alga simbion yang tinggal di tubuhnya dan juga memakan plankton kecil.</i></p>
                        </html>
                        """;
                image = new ImageIcon(getClass().getResource("/images/ubur_ubur_cassiopea.jpg"));
                break;
            case "Bintang Laut Pasir":
                description = """
                        <html>
                        <h2>Bintang Laut Pasir</h2>
                        <p><b>Tipe:</b> Omnivora</p>
                        <p><b>Kategori:</b> Invertebrata</p>
                        <p><b>Subkategori:</b> Echinodermata</p>
                        <p><b>Habitat:</b> Dasar laut berpasir di perairan dangkal</p>
                        <p><b>Makanan:</b> Alga, moluska kecil, krustasea, dan bahan organik</p>
                        <p><i>Bintang Laut Pasir adalah hewan laut omnivora yang bergerak di dasar laut untuk mencari makanan. 
                        Mereka berkontribusi pada ekosistem dengan mendaur ulang bahan organik dan menjaga populasi hewan kecil.</i></p>
                        </html>
                        """;
                image = new ImageIcon(getClass().getResource("/images/bintang_laut_pasir.jpg"));
                break;
               
               

// Tambahkan case lain untuk hewan tambahan...

            

        }

        // Mengatur ukuran gambar
        if (image != null) {
            Image img = image.getImage();
            Image resizedImage = img.getScaledInstance(500, 350, Image.SCALE_SMOOTH); // Mengubah ukuran gambar menjadi 500x350 piksel
            image = new ImageIcon(resizedImage);
        }

        descriptionTextArea.setText(description);
        imageLabel.setIcon(image);
    }
}







