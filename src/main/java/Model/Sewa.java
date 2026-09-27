/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */
public class Sewa {
    private Pelanggan pelanggan;
    private Handphone handphone;
    private int lamaSewaHari;
 
    public Sewa(Pelanggan pelanggan, Handphone handphone, int lamaSewaHari) {
        this.pelanggan = pelanggan;
        this.handphone = handphone;
        this.lamaSewaHari = lamaSewaHari;
    }
 
    public Pelanggan getPelanggan() {
        return pelanggan;
    }
 
    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }
 
    public Handphone getHandphone() {
        return handphone;
    }
 
    public void setHandphone(Handphone handphone) {
        this.handphone = handphone;
    }
 
    public int getLamaSewaHari() {
        return lamaSewaHari;
    }
 
    public void setLamaSewaHari(int lamaSewaHari) {
        this.lamaSewaHari = lamaSewaHari;
    }
 
    // Method awal: hitung total biaya tanpa diskon
    public double hitungTotalBiaya() {
        return handphone.getHargaSewaPerHari() * lamaSewaHari;
    }

    public double hitungTotalBiaya(double diskonPersen) {
        double subtotal = hitungTotalBiaya();
        double potongan = subtotal * (diskonPersen / 100);
        return subtotal - potongan;
    }
 
    public double getDiskonOtomatis() {
        double diskon;
        if (lamaSewaHari >= 7) {
            diskon = 15; 
        } else if (lamaSewaHari >= 3) {
            diskon = 5; 
        } else {
            diskon = 0;  
        }
        return diskon;
    }
 
    public void cetakNotaSewa() {
        System.out.println("\n=========================================");
        System.out.println("          NOTA SEWA HANDPHONE            ");
        System.out.println("=========================================");
        pelanggan.tampilkanPelanggan();
        System.out.println("-----------------------------------------");
 

        handphone.tampilkanInformasi();
 
        System.out.println("-----------------------------------------");
        System.out.println("Lama Sewa         : " + lamaSewaHari + " Hari");
        System.out.println("Subtotal Sewa     : Rp" + hitungTotalBiaya());
 
        double diskon = getDiskonOtomatis();
        if (diskon > 0) {
            System.out.println("Diskon            : " + diskon + "%");
            System.out.println("Total Biaya Sewa  : Rp" + hitungTotalBiaya(diskon));
        } else {
            System.out.println("Total Biaya Sewa  : Rp" + hitungTotalBiaya());
        }
        System.out.println("=========================================");
    }
}
