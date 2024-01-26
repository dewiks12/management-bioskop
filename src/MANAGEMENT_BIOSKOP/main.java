package MANAGEMENT_BIOSKOP;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagementBioskop bioskop = new ManagementBioskop();
        int pilihanLogin;
        do {
            System.out.println("MENU LOGIN : ");
            System.out.println("1. Login Admin");
            System.out.println("2. Login Customer");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu : ");
            pilihanLogin = scanner.nextInt();
            scanner.nextLine();

            switch (pilihanLogin) {
                case 1:
                    System.out.print("Masukkan Username Admin: ");
                    String UsernameAdmin = scanner.nextLine();
                    System.out.print("Masukkan Password Admin: ");
                    String PasswordAdmin = scanner.nextLine();

                    if (bioskop.LoginAdmin(UsernameAdmin, PasswordAdmin)) {
                        int pilihanAdmin;
                        do {
                            System.out.println("\nMENU ADMIN : ");
                            System.out.println("1. Tambah Film");
                            System.out.println("2. Lihat Daftar Film");
                            System.out.println("3. Tambah Harga Tiket");
                            System.out.println("4. Edit Film");
                            System.out.println("5. Logout");
                            System.out.print("Pilih Menu: ");
                            pilihanAdmin = scanner.nextInt();
                            scanner.nextLine();

                            switch (pilihanAdmin) {
                                case 1:
                                    System.out.print("Masukkan Judul Film  : ");
                                    String judulFilm = scanner.nextLine();
                                    System.out.print("masukkan Jam Tayang  : ");
                                    String jamtayang = scanner.nextLine();
                                    System.out.print("Masukkan Studio      : ");
                                    String studio = scanner.nextLine();
                                    bioskop.TambahFilm(new Film(judulFilm, jamtayang, studio));
                                    break;
                                case 2:
                                        bioskop.LihatdaftarFilm();
                                        break;
                                case 3:
                                        System.out.print("Masukkan Harga Tiket : ");
                                        double hargaTiket = scanner.nextDouble();
                                        bioskop.TambahHargaTiket(hargaTiket);
                                        break;
                                case 4:
                                        System.out.print("Masukkan Film Yang Ingin Diedit: ");
                                        String editJudulFilm = scanner.nextLine();
                                        System.out.print("Masukkan Jam Tayang Baru  : ");
                                        String editJamtayang = scanner.nextLine();
                                        System.out.print("Masukkan Studio Baru    : ");
                                        String editStudio = scanner.nextLine();
                                        bioskop.EditFilm(editJudulFilm, editJamtayang, editStudio);
                                        break;
                                case 5:
                                        System.out.println("Masukkan Harga Tiket Baru : ");
                                        double editHarga = scanner.nextDouble();
                                        bioskop.EditHargaTiket(editHarga);
                                        break;
                                case 6:
                                        System.out.println("LOGOUT ADMIN!");
                                        break;
                                default:
                                        System.out.println("Pilihan Tidak Valid!");
                            }
                        }while (pilihanAdmin != 6);
                    } else {
                        System.out.println("LOGIN ADMIN GAGAL!");
                    }
                    break;
                case 2:
                    int pilihanCustomer;
                    do {
                        System.out.println("\nMENU PENGUNJUNG : ");
                        System.out.println("1. Cari Film");
                        System.out.println("2. Beli Tiket");
                        System.out.println("3. Lihat Transaksi");
                        System.out.println("4. Logout");
                        System.out.println("Pilih Menu: ");
                        pilihanCustomer = scanner.nextInt();
                        scanner.nextLine();

                        switch (pilihanCustomer) {
                            case 1:
                                System.out.print("Masukkan Judul Film yang Dicari : ");
                                String cariJudulFilm = scanner.nextLine();
                                Bioskop filmDitemukan = bioskop.cariFilm(cariJudulFilm);

                                if (filmDitemukan != null) {
                                    filmDitemukan.displayInfo();
                                } else {
                                    System.out.println("Film tidak ditemukan atau sedang tidak Tayang!");
                                }
                                break;
                            case 2:
                                System.out.print("Masukkan Judul Film yang ingin Ditonton : ");
                                String beliFilm = scanner.nextLine();
                                System.out.println("Harga Tiket : " + bioskop.getHargaTiket());
                                System.out.println("Masukkan Nama Pengunjun  : ");
                                String namaPengunjung = scanner.nextLine();
                                System.out.println("Masukkan uang Bayar      : ");
                                double uangbayar = scanner.nextDouble();
                                scanner.nextLine();
                                bioskop.BeliTiket(beliFilm, namaPengunjung, uangbayar);
                                break;
                            case 3:
                                bioskop.LihatTransaksi();
                                break;
                            case 4:
                                System.out.println("LOGOUT PENGUNJUNG!");
                                break;
                            default:
                                System.out.println("PILIHAN YANG DIMASUKKAN TIDAK VALID!");
                            }
                        } while (pilihanCustomer != 4);
                        break;
                case 3:
                    System.out.println("Keluar Dari Menu.terimakasih!");
                    break;
                default:
                    System.out.println("PILIHAN YANG DIMASUKKAN TIDAK VALID!");
            }
        }while (pilihanLogin != 3);
    }
}