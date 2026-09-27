<div align="center">

# 📱 Sistem Sewa Handphone

Aplikasi console berbasis Java untuk mengelola transaksi penyewaan handphone,
dibuat menggunakan konsep **OOP (Object-Oriented Programming)**.

</div>

---

## 📖 Deskripsi Proyek

**Sistem Sewa Handphone** adalah aplikasi berbasis *console* (command line) yang dibuat menggunakan
Java untuk mengelola transaksi penyewaan handphone. Program ini mendukung dua kategori handphone,
yaitu **Smartphone** dan **FeaturePhone**, yang masing-masing memiliki atribut khusus berbeda.

Fitur utama yang tersedia:

-  Menyewa handphone dari daftar yang tersedia
-  Melihat daftar seluruh handphone yang bisa disewa
-  Menambahkan unit handphone baru secara *custom* (Smartphone maupun FeaturePhone)
-  Perhitungan **diskon otomatis** berdasarkan lama sewa
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

> Ganti path gambar di bawah (`docs/...png`) dengan screenshot hasil run program milikmu sendiri.

<table>
  <tr>
    <td width="50%">
      <img src="docs/screenshot-menu-utama.png" alt="Menu Utama" width="100%"/>
    </td>
    <td>
      <b>Menu Utama</b><br/>
      Tampilan awal program menampilkan 4 pilihan menu kepada pengguna:
      Sewa Handphone Baru, Lihat Daftar Handphone, Tambah Handphone Baru, dan Keluar.
    </td>
  </tr>
  <tr>
    <td width="50%">
      <img src="docs/screenshot-sewa-hp.png" alt="Proses Sewa Handphone" width="100%"/>
    </td>
    <td>
      <b>Proses Sewa Handphone</b><br/>
      Pengguna mengisi data pelanggan, memilih handphone, memasukkan lama sewa,
      lalu sistem mencetak nota sewa lengkap dengan perhitungan diskon otomatis.
    </td>
  </tr>
  <tr>
    <td width="50%">
      <img src="docs/screenshot-tambah-hp.png" alt="Tambah Handphone Baru" width="100%"/>
    </td>
    <td>
      <b>Tambah Handphone Baru (Custom)</b><br/>
      Pengguna menambahkan handphone baru secara custom dengan memilih tipe
      dan mengisi data spesifik sesuai tipe tersebut.
    </td>
  </tr>
</table>

<br/>

<div align="center">

Dibuat sebagai tugas mata kuliah **Pemrograman Berorientasi Objek (PBO)**

</div>
