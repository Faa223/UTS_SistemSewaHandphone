/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */
public class Smartphone extends Handphone {
    private String sistemOperasi;
    private int kapasitasRAM;
 
    public Smartphone(String merk, String tipe, double hargaSewaPerHari, String sistemOperasi, int kapasitasRAM) {
        super(merk, tipe, hargaSewaPerHari);
        this.sistemOperasi = sistemOperasi;
        this.kapasitasRAM = kapasitasRAM;
    }
 
    public String getSistemOperasi() {
        return sistemOperasi;
    }
 
    public int getKapasitasRAM() {
        return kapasitasRAM;
    }
 
    // POLYMORPHISM: Method Overriding
    // Nama & signature method SAMA dengan induk (Handphone), tapi isinya beda
    @Override
    public void tampilkanInformasi() {
        super.tampilkanInformasi(); // panggil versi induk dulu
        System.out.println("Sistem Operasi    : " + sistemOperasi);
        System.out.println("RAM               : " + kapasitasRAM + " GB");
    }
}