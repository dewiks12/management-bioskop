import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagementBioskop bioskop = new ManagementBioskop();

        int pilihanLogin;
        do {
            System.out.println("Menu Login:");
            System.out.println("1. Login Admin");
            System.out.println("2. Login Pengunjung");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            pilihanLogin = scanner.nextInt();
            scanner.nextLine(); // Membuang newline

            switch (pilihanLogin) {
                case 1:
                    System.out.print("Masukkan username admin: ");
                    String adminUsername = scanner.nextLine();
                    System.out.print("Masukkan password admin: ");
                    String adminPassword = scanner.nextLine();

                    if (bioskop.adminLogin(adminUsername, adminPassword)) {
                        int pilihanAdmin;
                        do {
                            System.out.println("\nMenu Admin:");
                            System.out.println("1. Tambah Film");
                            System.out.println("2. Lihat Daftar Film");
                            System.out.println("3. Tambah Harga Tiket");
                            System.out.println("4. Edit Film");
                            System.out.println("5. Edit Harga Tiket");
                            System.out.println("6. Logout");
                            System.out.print("Pilih menu: ");
                            pilihanAdmin = scanner.nextInt();
                            scanner.nextLine(); // Membuang newline

                            switch (pilihanAdmin) {
                                case 1:
                                    System.out.print("Masukkan judul film   : ");
                                    String judulFilm = scanner.nextLine();
                                    System.out.print("Masukkan jam tayang   : ");
                                    String jamTayang = scanner.nextLine();
                                    System.out.print("Masukkan studio       : ");
                                    String studio = scanner.nextLine();
                                    bioskop.tambahMultimedia(new Film(judulFilm, jamTayang, studio));
                                    break;
                                case 2:
                                    bioskop.lihatDaftarMultimedia();
                                    break;
                                case 3:
                                    System.out.print("Masukkan harga tiket  : ");
                                    double hargaTiket = scanner.nextDouble();
                                    bioskop.tambahHargaTiket(hargaTiket);
                                    break;
                                case 4:
                                    System.out.print("Masukkan judul film yang ingin diedit: ");
                                    String editJudulMultimedia = scanner.nextLine();
                                    System.out.print("Masukkan jam tayang baru  : ");
                                    String editJamTayang = scanner.nextLine();
                                    System.out.print("Masukkan studio baru      : ");
                                    String editStudio = scanner.nextLine();
                                    bioskop.editMultimedia(editJudulMultimedia, editJamTayang, editStudio);
                                    break;
                                case 5:
                                    System.out.print("Masukkan harga tiket baru : ");
                                    double editHargaTiket = scanner.nextDouble();
                                    bioskop.editHargaTiket(editHargaTiket);
                                    break;
                                case 6:
                                    System.out.println("Logout Admin.");
                                    break;
                                default:
                                    System.out.println("Pilihan tidak valid.");
                            }
                        } while (pilihanAdmin != 6);
                    } else {
                        System.out.println("Login admin gagal.");
                    }
                    break;
                case 2:
                    int pilihanPengunjung;
                    do {
                        System.out.println("\nMenu Pengunjung:");
                        System.out.println("1. Cari Film");
                        System.out.println("2. Beli Tiket");
                        System.out.println("3. Lihat Transaksi");
                        System.out.println("4. Logout");
                        System.out.print("Pilih menu: ");
                        pilihanPengunjung = scanner.nextInt();
                        scanner.nextLine(); // Membuang newline

                        switch (pilihanPengunjung) {
                            case 1:
                                System.out.print("Masukkan judul film yang dicari : ");
                                String cariJudulMultimedia = scanner.nextLine();
                                Multimedia multimediaDitemukan = bioskop.cariMedia(cariJudulMultimedia);

                                if (multimediaDitemukan != null) {
                                    multimediaDitemukan.displayInfo();
                                } else {
                                    System.out.println("film tidak ditemukan atau tidak sedang tayang.");
                                }
                                break;
                            case 2:
                                System.out.print("Masukkan judul film yang ingin diTonton : ");
                                String beliJudulMultimedia = scanner.nextLine();
                                System.out.println("Harga tiket : " + bioskop.getHargaTiket());
                                System.out.print("Masukkan nama pengunjung  : ");
                                String beliNamaPengunjung = scanner.nextLine();
                                System.out.print("Masukkan uang bayar       : ");
                                double uangBayar = scanner.nextDouble();
                                scanner.nextLine(); // Membuang newline
                                bioskop.beliTiket(beliJudulMultimedia, beliNamaPengunjung, uangBayar);
                                break;
                            case 3:
                                bioskop.lihatTransaksi();
                                break;
                            case 4:
                                System.out.println("Logout Pengunjung.");
                                break;
                            default:
                                System.out.println("Pilihan tidak valid.");
                        }
                    } while (pilihanPengunjung != 4);
                    break;
                case 3:
                    System.out.println("Keluar dari program. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihanLogin != 3);

        scanner.close();
    }
}