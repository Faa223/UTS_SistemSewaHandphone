<div align="center">

#  Sistem Sewa Handphone

Aplikasi console berbasis Java untuk mengelola transaksi penyewaan handphone,
dibuat menggunakan konsep **OOP**.

</div>

---

##  Deskripsi Proyek

**Sistem Sewa Handphone** adalah aplikasi berbasis *console* yang dibuat menggunakan
Java untuk mengelola transaksi penyewaan handphone. Program ini mendukung dua kategori handphone,
yaitu **Smartphone** dan **FeaturePhone**, yang masing-masing memiliki atribut khusus berbeda.

Fitur utama yang tersedia:

-  Menyewa handphone dari daftar yang tersedia
-  Melihat daftar seluruh handphone yang bisa disewa
-  Menambahkan unit handphone baru secara *custom* (Smartphone maupun FeaturePhone)
-  Perhitungan **diskon otomatis** jika menyewa lebih dari 7 hari
-  Validasi input di setiap tahap (anti *error* saat user salah ketik)

<br/>

##  Struktur Proyek

```
SistemSewaHandphone/
├── src/main/java/
│   ├── Model/
│   │   ├── Handphone.java        # Superclass / induk
│   │   ├── Smartphone.java       # Subclass -> extends Handphone
│   │   ├── FeaturePhone.java     # Subclass -> extends Handphone
│   │   ├── Pelanggan.java        # Data pelanggan
│   │   └── Sewa.java             # Logika transaksi & perhitungan biaya
│   └── com/mycompany/sistemsewahandphone/
│       └── Main.java             # Entry point program (menu utama)
└── README.md
```

<br/>

##  Konsep OOP yang Diterapkan

<table>
  <tr>
    <th align="left">Konsep</th>
    <th align="left">Penerapan di Kode</th>
  </tr>
  <tr>
    <td><b>Inheritance</b></td>
    <td><code>Smartphone</code> dan <code>FeaturePhone</code> sama-sama <code>extends Handphone</code></td>
  </tr>
  <tr>
    <td><b>Polymorphism (Overriding)</b></td>
    <td><code>tampilkanInformasi()</code> di-override di <code>Smartphone</code> & <code>FeaturePhone</code>, dipanggil secara polymorphic dari <code>Sewa</code></td>
  </tr>
  <tr>
    <td><b>Polymorphism (Overloading)</b></td>
    <td><code>hitungTotalBiaya()</code> vs <code>hitungTotalBiaya(double diskonPersen)</code> di class <code>Sewa</code></td>
  </tr>
  <tr>
    <td><b>Condition (if-else)</b></td>
    <td>Validasi input & logika diskon otomatis (<code>getDiskonOtomatis()</code>)</td>
  </tr>
  <tr>
    <td><b>Looping</b></td>
    <td><code>do-while</code> untuk menu utama & transaksi, <code>while</code> untuk validasi setiap input</td>
  </tr>
</table>

<br/>

##  Alur Program

### Cara Menjalankan
1. Buka project di **Apache NetBeans**.
2. Klik kanan project → **Run** (atau tekan `F6`).
3. Menu utama akan langsung tampil di jendela Output.

>  Jika input/output terasa tidak sinkron di NetBeans, jalankan langsung lewat terminal:
> ```bash
> java -cp target/classes com.mycompany.sistemsewahandphone.Main
> ```

### Alur Menu

<details>
<summary><b>1️. Sewa Handphone Baru</b></summary>
<br/>

1. Program meminta input **Nama, No. KTP, No. Telepon** pelanggan.
2. Menampilkan daftar handphone yang tersedia untuk dipilih.
3. Pengguna memasukkan **lama sewa (hari)**.
4. Sistem menghitung total biaya, otomatis memberi diskon jika lama sewa ≥ 3 hari (5%) atau ≥ 7 hari (15%).
5. Nota sewa dicetak lengkap dengan detail handphone (berbeda tampilannya tergantung tipe HP, berkat *polymorphism*).
6. Pengguna ditanya apakah ingin sewa lagi tanpa perlu kembali ke menu utama.

</details>

<details>
<summary><b>2️. Lihat Daftar Handphone Tersedia</b></summary>
<br/>

Menampilkan seluruh handphone yang bisa disewa beserta merk, tipe, dan harga sewa per hari — termasuk handphone yang sudah ditambahkan secara custom.

</details>

<details>
<summary><b>3️. Tambah Handphone Baru (Custom)</b></summary>
<br/>

1. Pengguna memilih tipe handphone: **Smartphone** atau **FeaturePhone**.
2. Mengisi data umum: merk, tipe, harga sewa per hari.
3. Mengisi data khusus sesuai tipe yang dipilih:
   - **Smartphone** → pilih Sistem Operasi (iOS/Android/HarmonyOS) & kapasitas RAM.
   - **FeaturePhone** → kapasitas baterai & ketersediaan Radio FM.
4. Handphone baru langsung masuk ke daftar dan bisa langsung disewa.

</details>

<details>
<summary><b>4️. Keluar</b></summary>
<br/>

Menampilkan pesan penutup dan menghentikan program.

</details>

<br/>

##  Penjelasan Output 

<table>
  <tr>
    <td width="50%">
      <img width="496" height="231" alt="Screenshot 2026-09-27 171622" src="https://github.com/user-attachments/assets/88fc8404-49b3-4800-8837-98fd0ca916cd" />
    </td>
    <td>
      <b>Menu Utama</b><br/>
      Tampilan awal program menampilkan 4 pilihan menu kepada pengguna:
      Sewa Handphone Baru, Lihat Daftar Handphone, Tambah Handphone Baru, dan Keluar.
    </td>
  </tr>
  <tr>
    <td width="50%">
      <img width="566" height="699" alt="Screenshot 2026-09-27 170838" src="https://github.com/user-attachments/assets/0887b481-553c-4600-ba20-44b9a7dd6572" />
      <img width="409" height="565" alt="Screenshot 2026-09-27 170810" src="https://github.com/user-attachments/assets/b1fe0396-7487-4ddc-95e6-9ed8e501bbfa" />
    </td>
    <td>
      <b>Proses Sewa Handphone</b><br/>
      Pengguna mengisi data pelanggan, memilih handphone, memasukkan lama sewa,
      lalu sistem mencetak nota sewa lengkap dengan hitungan diskon jika menyewa lebih dari 7 hari
    </td>
  </tr>
  <tr>
    <td width="50%">
      <img width="602" height="583" alt="Screenshot 2026-09-27 170627" src="https://github.com/user-attachments/assets/e5a1b8c1-ae87-4cd6-a773-75c0bdb43366" />
    </td>
    <td>
      <b>Tambah Handphone Baru </b><br/>
      Pengguna menambahkan handphone baru dengan memilih terlebih dahulu Handphone yang mau ditambahkan contohnya seperti pada Gambar yang saya punya saya memilih Smartphone, setelah itu memilih tipe dan mengisi Ram yang di inginkan.
    </td>
  </tr>
</table>

<br/>

<div align="center">

</div>
