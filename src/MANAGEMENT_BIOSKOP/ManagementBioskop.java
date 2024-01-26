package MANAGEMENT_BIOSKOP;

import java.util.ArrayList;
import java.util.HashMap;

public class ManagementBioskop {

    private HashMap<String, String> LoginAdmin;
    private ArrayList<Bioskop> daftarFilm;
    private ArrayList<String> Transaksi;
    private double HargaTiket;

    public ManagementBioskop() {
        LoginAdmin = new HashMap<>();
        LoginAdmin.put("admin", "admin123");

        daftarFilm = new ArrayList<>();
        Transaksi = new ArrayList<>();
        HargaTiket = 0;
    }
    public void TambahHargaTiket(double harga) {
        this.HargaTiket = harga;
        System.out.println("Harga tiket berhasil ditambahkan!");
    }
    public void EditFilm(String judul, String JamTayang, String Studio) {
        for(Bioskop bioskop : daftarFilm) {
            if(bioskop.judul.equals(judul) && bioskop instanceof Film) {
                Film Edit = (Film) bioskop;
                Edit.JamTayang = JamTayang;
                Edit.Studio = Studio;
                System.out.println("Film berhasil diupdate!");
                return;
            }
        }
        System.out.println("Film tidak ditemukan!");
    }
    public void EditHargaTiket(double hargaBaru){
        this.HargaTiket = hargaBaru;
        System.out.println("Harga tiket berhasil diupdate!");
    }
    public boolean LoginAdmin(String Username, String Password) {
        return LoginAdmin.containsKey(Username) && LoginAdmin.get(Username).equals(Password);
    }
    public void TambahFilm(Bioskop bioskop) {
        daftarFilm.add(bioskop);
        System.out.println("Film berhasil ditambahkan!");
    }
    public void LihatdaftarFilm() {
        System.out.println("Daftar Film :");
        for(Bioskop bioskop : daftarFilm) {
            bioskop.displayInfo();
        }
    }
    public void BeliTiket(String JudulFilm, String namaCustomer, double uangBayar) {
        for(Bioskop bioskop : daftarFilm) {
            if(bioskop.judul.equalsIgnoreCase(JudulFilm) && bioskop instanceof Film) {
                Film film = (Film) bioskop;
                double TotalHarga = HargaTiket;
                String InfoTransaksi = "Nama Pengunjung: " + namaCustomer +
                        ", Film: "+film.judul +
                        ", Jam Tayang: " + film.JamTayang +
                        ", Studio: " + film.Studio +
                        ", Harga Tiket: "+ TotalHarga;

                if(uangBayar >= TotalHarga) {
                    double Kembalian = uangBayar - uangBayar;
                    InfoTransaksi += ", Uang Bayar: " + uangBayar + ", kembalian: " + Kembalian;
                    Transaksi.add(InfoTransaksi);
                    System.out.println("Pembelian Tiket berhasil");
                }else {
                    System.out.println("Uang bayar tidak mencukupi.Pembelian dibatalkan");
                }
                return;
            }
        }
        System.out.println("Film tidak ditemukan atau Film tidak Tayang");
    }
    public Bioskop cariFilm(String judulFilm) {
        for(Bioskop bioskop : daftarFilm) {
            if(bioskop.judul.equalsIgnoreCase(judulFilm)) {
                return bioskop;
            }
        }
        return null;
    }
    public void LihatTransaksi() {
        System.out.println("Daftar Transaksi:");
        for(String InfoTransaksi : Transaksi) {
            System.out.println(InfoTransaksi);
        }
    }
    public double getHargaTiket() {
        return HargaTiket;
    }
}
