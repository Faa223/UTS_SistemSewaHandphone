/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */
public class Handphone {
    private String merk;
    private String tipe;
    private double hargaSewaPerHari;
 
    public Handphone(String merk, String tipe, double hargaSewaPerHari) {
        this.merk = merk;
        this.tipe = tipe;
        this.hargaSewaPerHari = hargaSewaPerHari;
    }
 
    public String getMerk() {
        return merk;
    }
 
    public String getTipe() {
        return tipe;
    }
 
    public double getHargaSewaPerHari() {
        return hargaSewaPerHari;
    }
 
    // Method ini akan di-override oleh subclass (Smartphone & FeaturePhone)
    // Inilah dasar dari POLYMORPHISM (Method Overriding)
    public void tampilkanInformasi() {
        System.out.println("Merk HP           : " + merk);
        System.out.println("Tipe HP           : " + tipe);
        System.out.println("Harga Sewa / Hari : Rp" + hargaSewaPerHari);
    }
}