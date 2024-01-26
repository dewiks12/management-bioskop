import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

abstract class Multimedia {
    String judul;

    public Multimedia(String judul) {
        this.judul = judul;
    }

    abstract void displayInfo();
}
class Film extends Multimedia {
    String jamTayang;
    String studio;

    public Film(String judul, String jamTayang, String studio) {
        super(judul);
        this.jamTayang = jamTayang;
        this.studio = studio;
    }

    @Override
    void displayInfo() {
        System.out.println("Judul : " + judul +", Jam Tayang : " + jamTayang + ", Studio : " + studio);
    }
}

class ManagementBioskop {
    private Map<String, String> LoginAdmin;
    private ArrayList<Multimedia> daftarFilm;
    private ArrayList<String> transaksi;
    private double hargaTiket;

    public ManagementBioskop() {
        LoginAdmin = new HashMap<>();
        LoginAdmin.put("admin", "admin123");

        daftarFilm = new ArrayList<>();
        transaksi = new ArrayList<>();
        hargaTiket = 0.0;
    }

    public void tambahHargaTiket(double harga) {
        this.hargaTiket = harga;
        System.out.println("Harga tiket berhasil ditambahkan!");
    }

    public void editMultimedia(String judul, String jamTayangBaru, String studioBaru) {
        for (Multimedia multimedia : daftarFilm) {
            if (multimedia.judul.equals(judul) && multimedia instanceof Film) {
                Film film = (Film) multimedia;
                film.jamTayang = jamTayangBaru;
                film.studio = studioBaru;
                System.out.println("Film berhasil diupdate!");
                return;
            }
        }
        System.out.println("Film tidak ditemukan atau bukan film.");
    }

    public void editHargaTiket(double hargaBaru) {
        this.hargaTiket = hargaBaru;
        System.out.println("Harga tiket berhasil diupdate!");
    }

    public boolean adminLogin(String username, String password) {
        return LoginAdmin.containsKey(username) && LoginAdmin.get(username).equals(password);
    }

    public void tambahMultimedia(Multimedia multimedia) {
        daftarFilm.add(multimedia);
        System.out.println("Film berhasil ditambahkan!");
    }

    public void lihatDaftarMultimedia() {
        System.out.println("Daftar Film:");
        for (Multimedia multimedia : daftarFilm) {
            multimedia.displayInfo();
        }
    }

    public void beliTiket(String judulMultimedia, String namaPengunjung, double uangBayar) {
        for (Multimedia multimedia : daftarFilm) {
            if (multimedia.judul.equalsIgnoreCase(judulMultimedia) && multimedia instanceof Film) {
                Film film = (Film) multimedia;
                double totalHarga = hargaTiket;
                String transaksiInfo = "Nama Pengunjung: " + namaPengunjung +
                        ", Film: " + film.judul +
                        ", Jam Tayang: " + film.jamTayang +
                        ", Studio: " + film.studio +
                        ", Harga Tiket: " + totalHarga;

                if (uangBayar >= totalHarga) {
                    double kembalian = uangBayar - totalHarga;
                    transaksiInfo += ", Uang Bayar: " + uangBayar + ", Kembalian: " + kembalian;
                    transaksi.add(transaksiInfo);
                    System.out.println("Pembelian tiket berhasil!");
                } else {
                    System.out.println("Uang bayar tidak mencukupi. Pembelian tiket dibatalkan.");
                }
                return;
            }
        }
        System.out.println("Film tidak ditemukan atau tidak sedang tayang.");
    }

    public Multimedia cariMedia(String judulMultimedia) {
        for (Multimedia multimedia : daftarFilm) {
            if (multimedia.judul.equalsIgnoreCase(judulMultimedia)) {
                return multimedia;
            }
        }
        return null;
    }

    public void lihatTransaksi() {
        System.out.println("Daftar Transaksi:");
        for (String transaksiInfo : transaksi) {
            System.out.println(transaksiInfo);
        }
    }

    public double getHargaTiket() {
        return hargaTiket;
    }
}