/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
 
package com.mycompany.sistemsewahandphone;
 
import Model.Sewa;
import Model.Handphone;
import Model.Smartphone;
import Model.FeaturePhone;
import Model.Pelanggan;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
/**
 *
 * @author ASUS
 */
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        // INHERITANCE: 2 tipe turunan Handphone (Smartphone & FeaturePhone)
        // Pakai ArrayList (bukan array biasa) supaya user bisa MENAMBAH HP baru
        // secara dinamis lewat menu, tanpa dibatasi ukuran tetap.
        List<Handphone> daftarHP = new ArrayList<>();
        daftarHP.add(new Smartphone("Apple", "iPhone 15 Pro", 150000, "iOS", 8));
        daftarHP.add(new FeaturePhone("Nokia", "105 4G", 30000, 1450, true));
 
        int pilihanMenu = 0;
 
        // LOOPING: perulangan utama menu, berhenti kalau user pilih 4 (Keluar)
        do {
            System.out.println("\n=========================================");
            System.out.println("      PENYEWAAN HANDPHONE        ");
            System.out.println("=========================================");
            System.out.println("1. Sewa Handphone Baru");
            System.out.println("2. Lihat Daftar Handphone Tersedia");
            System.out.println("3. Tambah Handphone Baru");
            System.out.println("4. Keluar");
 
            pilihanMenu = 0;
            while (pilihanMenu < 1 || pilihanMenu > 4) {
                System.out.print("Pilihan Anda (1-4): ");
                if (scanner.hasNextInt()) {
                    pilihanMenu = scanner.nextInt();
                    if (pilihanMenu < 1 || pilihanMenu > 4) {
                        System.out.println("Pilihan tidak valid! Silakan pilih 1, 2, 3, atau 4.");
                    }
                } else {
                    System.out.println("Input harus berupa angka!");
                    scanner.next();
                }
            }
            scanner.nextLine(); // bersihkan sisa newline
            
            if (pilihanMenu == 1) {
                prosesSewaBaru(scanner, daftarHP);
            } else if (pilihanMenu == 2) {
                tampilkanDaftarHandphone(daftarHP);
            } else if (pilihanMenu == 3) {
                tambahHandphoneBaru(scanner, daftarHP);
            } else {
                System.out.println("\n=========================================");
                System.out.println(" Terima kasih telah menyewa Handphone disini ");
                System.out.println("=========================================");
            }
 
        } while (pilihanMenu != 4);
 
        scanner.close();
    }
 
    // Menampilkan daftar handphone yang tersedia untuk disewa (termasuk yang custom)
    private static void tampilkanDaftarHandphone(List<Handphone> daftarHP) {
        System.out.println("\n--- Daftar Handphone Tersedia ---");
        for (int i = 0; i < daftarHP.size(); i++) {
            Handphone hp = daftarHP.get(i);
            // CONDITION: kasih label tipe biar user tahu ini Smartphone atau FeaturePhone
            String label = (hp instanceof Smartphone) ? "Smartphone" : "FeaturePhone";
            System.out.println((i + 1) + ". [" + label + "] " + hp.getMerk() + " " + hp.getTipe()
                    + " (Rp" + hp.getHargaSewaPerHari() + "/hari)");
        }
    }
 
    // Menu baru: user input sendiri data handphone yang mau ditambahkan
    private static void tambahHandphoneBaru(Scanner scanner, List<Handphone> daftarHP) {
        System.out.println("\n--- Tambah Handphone Baru ---");
        System.out.println("Pilih tipe handphone yang ingin ditambahkan:");
        System.out.println("1. Smartphone");
        System.out.println("2. FeaturePhone");
 
        // LOOPING + CONDITION: validasi tipe HP (harus 1 atau 2)
        int tipeHP = 0;
        while (tipeHP != 1 && tipeHP != 2) {
            System.out.print("Pilihan Anda (1/2): ");
            if (scanner.hasNextInt()) {
                tipeHP = scanner.nextInt();
                if (tipeHP != 1 && tipeHP != 2) {
                    System.out.println("Pilihan tidak valid! Silakan pilih 1 atau 2.");
                }
            } else {
                System.out.println("Input harus berupa angka!");
                scanner.next();
            }
        }
        scanner.nextLine(); // bersihkan sisa newline
 
        // Input data umum (dimiliki semua Handphone -> lewat parent class)
        System.out.print("Masukkan Merk HP        : ");
        String merk = scanner.nextLine();
        System.out.print("Masukkan Tipe HP        : ");
        String tipe = scanner.nextLine();
 
        // LOOPING + CONDITION: validasi harga sewa harus angka positif
        double harga = 0;
        while (harga <= 0) {
            System.out.print("Masukkan Harga Sewa/Hari: ");
            if (scanner.hasNextDouble()) {
                harga = scanner.nextDouble();
                if (harga <= 0) {
                    System.out.println("Harga sewa harus lebih dari 0!");
                }
            } else {
                System.out.println("Input harus berupa angka!");
                scanner.next();
            }
        }
        scanner.nextLine(); // bersihkan sisa newline
 
        // CONDITION: input tambahan beda tergantung tipe HP yang dipilih
        if (tipeHP == 1) {
            // Data khusus Smartphone
            // CONDITION + LOOPING: pilih Sistem Operasi dari pilihan yang masuk akal
            // (bukan teks bebas, supaya datanya konsisten/tidak asal ketik)
            System.out.println("Pilih Sistem Operasi:");
            System.out.println("1. iOS");
            System.out.println("2. Android");
 
            int pilihanOS = 0;
            while (pilihanOS < 1 || pilihanOS > 3) {
                System.out.print("Pilihan Anda (1-2): ");
                if (scanner.hasNextInt()) {
                    pilihanOS = scanner.nextInt();
                    if (pilihanOS < 1 || pilihanOS > 3) {
                        System.out.println("Pilihan tidak valid! Silakan pilih 1, 2, atau 3.");
                    }
                } else {
                    System.out.println("Input harus berupa angka!");
                    scanner.next();
                }
            }
            scanner.nextLine();
 
            // CONDITION: konversi pilihan angka jadi nama sistem operasi
            String sistemOperasi;
            if (pilihanOS == 1) {
                sistemOperasi = "iOS";
            } else if (pilihanOS == 2) {
                sistemOperasi = "Android";
            } else {
                sistemOperasi = "HarmonyOS";
            }
 
            int ram = 0;
            while (ram <= 0) {
                System.out.print("Masukkan Kapasitas RAM (GB): ");
                if (scanner.hasNextInt()) {
                    ram = scanner.nextInt();
                    if (ram <= 0) {
                        System.out.println("Kapasitas RAM harus lebih dari 0!");
                    }
                } else {
                    System.out.println("Input harus berupa angka!");
                    scanner.next();
                }
            }
            scanner.nextLine();
 
            Smartphone hpBaru = new Smartphone(merk, tipe, harga, sistemOperasi, ram);
            daftarHP.add(hpBaru);
        } else {
            // Data khusus FeaturePhone
            int kapasitasBaterai = 0;
            while (kapasitasBaterai <= 0) {
                System.out.print("Masukkan Kapasitas Baterai (mAh): ");
                if (scanner.hasNextInt()) {
                    kapasitasBaterai = scanner.nextInt();
                    if (kapasitasBaterai <= 0) {
                        System.out.println("Kapasitas baterai harus lebih dari 0!");
                    }
                } else {
                    System.out.println("Input harus berupa angka!");
                    scanner.next();
                }
            }
            scanner.nextLine();
 
            System.out.print("Ada Radio FM? (y/n)    : ");
            char adaRadio = scanner.next().charAt(0);
            scanner.nextLine();
            boolean adaRadioFM = (adaRadio == 'y' || adaRadio == 'Y');
 
            FeaturePhone hpBaru = new FeaturePhone(merk, tipe, harga, kapasitasBaterai, adaRadioFM);
            daftarHP.add(hpBaru);
        }
 
        System.out.println("\nHandphone baru berhasil ditambahkan ke daftar!");
    }
 
    // Alur transaksi sewa: input pelanggan -> pilih HP -> lama sewa -> cetak nota
    private static void prosesSewaBaru(Scanner scanner, List<Handphone> daftarHP) {
        char ulang;
 
        // LOOPING: bisa langsung sewa lagi tanpa balik ke menu utama dulu
        do {
            // Input data pelanggan
            System.out.print("Masukkan Nama Pelanggan : ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan No. KTP        : ");
            String ktp = scanner.nextLine();
            System.out.print("Masukkan No. Telepon    : ");
            String telp = scanner.nextLine();
 
            Pelanggan pelanggan = new Pelanggan(nama, ktp, telp);
 
            Handphone hpDipilih = null;
            int pilihanHP = 0;
 
            // LOOPING + CONDITION: validasi pilihan unit handphone
            while (pilihanHP < 1 || pilihanHP > daftarHP.size()) {
                tampilkanDaftarHandphone(daftarHP);
                System.out.print("Pilih Handphone yang Disewa (1-" + daftarHP.size() + "): ");
 
                if (scanner.hasNextInt()) {
                    pilihanHP = scanner.nextInt();
                    if (pilihanHP < 1 || pilihanHP > daftarHP.size()) {
                        System.out.println("Pilihan tidak valid!");
                    }
                } else {
                    System.out.println("Input harus berupa angka!");
                    scanner.next(); // Membersihkan buffer input salah
                }
            }
            hpDipilih = daftarHP.get(pilihanHP - 1); // konversi ke indeks 0-based
 
            // LOOPING + CONDITION: input lama sewa, validasi angka positif
            int lamaSewa = 0;
            while (lamaSewa <= 0) {
                System.out.print("Masukkan Lama Sewa (Hari): ");
                if (scanner.hasNextInt()) {
                    lamaSewa = scanner.nextInt();
                    if (lamaSewa <= 0) {
                        System.out.println("Lama sewa harus minimal 1 hari!");
                    }
                } else {
                    System.out.println("Input harus berupa angka!");
                    scanner.next();
                }
            }
            scanner.nextLine(); // bersihkan sisa newline setelah nextInt()
 
            // Memproses transaksi sewa
            Sewa transaksiSewa = new Sewa(pelanggan, hpDipilih, lamaSewa);
            transaksiSewa.cetakNotaSewa(); // di dalamnya terjadi POLYMORPHISM
 
            // CONDITION: konfirmasi ulangi transaksi sewa
            System.out.print("\nApakah ingin melakukan transaksi sewa lagi? (y/n): ");
            ulang = scanner.next().charAt(0);
            scanner.nextLine(); // Membersihkan buffer newline
 
        } while (ulang == 'y' || ulang == 'Y');
    }
}