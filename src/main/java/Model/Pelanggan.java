/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */
public class Pelanggan {
    private String nama;
    private String nomorKTP;
    private String nomorTelepon;
 
    public Pelanggan(String nama, String nomorKTP, String nomorTelepon) {
        this.nama = nama;
        this.nomorKTP = nomorKTP;
        this.nomorTelepon = nomorTelepon;
    }
 
    public String getNama() {
        return nama;
    }
 
    public void setNama(String nama) {
        this.nama = nama;
    }
 
    public String getNomorKTP() {
        return nomorKTP;
    }
 
    public void setNomorKTP(String nomorKTP) {
        this.nomorKTP = nomorKTP;
    }
 
    public String getNomorTelepon() {
        return nomorTelepon;
    }
 
    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }
 
    public void tampilkanPelanggan() {
        System.out.println("Nama Pelanggan    : " + nama);
        System.out.println("No. KTP           : " + nomorKTP);
        System.out.println("No. Telepon       : " + nomorTelepon);
    }
}