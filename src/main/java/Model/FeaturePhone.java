/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */
public class FeaturePhone extends Handphone {
    private int kapasitasBaterai;
    private boolean adaRadioFM;
 
    public FeaturePhone(String merk, String tipe, double hargaSewaPerHari, int kapasitasBaterai, boolean adaRadioFM) {
        super(merk, tipe, hargaSewaPerHari);
        this.kapasitasBaterai = kapasitasBaterai;
        this.adaRadioFM = adaRadioFM;
    }
 
    public int getKapasitasBaterai() {
        return kapasitasBaterai;
    }
 
    public boolean isAdaRadioFM() {
        return adaRadioFM;
    }
 
    // POLYMORPHISM: Method Overriding
    @Override
    public void tampilkanInformasi() {
        super.tampilkanInformasi(); 
        System.out.println("Kapasitas Baterai : " + kapasitasBaterai + " mAh");
        // CONDITION (if-else) dalam bentuk ternary
        System.out.println("Fitur Radio FM    : " + (adaRadioFM ? "Tersedia" : "Tidak Ada"));
    }
}
