import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isLoggedIn = false;
        String namaKasir = "syauqi";

        // LOGIN SECTION
        while (!isLoggedIn) {
            System.out.println("+-----------------------------------------------------+");
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            // Generate random captcha
            String captcha = generateCaptcha();
            System.out.print("Captcha [" + captcha + "]: ");
            String inputCaptcha = scanner.nextLine();

            if (username.equals("pbo5") && password.equals("password") && inputCaptcha.equals(captcha)) {
                System.out.println("Login berhasil!");
                isLoggedIn = true;
            } else {
                System.out.println("Login gagal. Silakan coba lagi.");
            }
        }

        // MAIN SECTION
        System.out.println("Selamat Datang di Supermarket ABC");
        boolean ulang = true;
        while (ulang) {
            try {
                // Menampilkan tanggal dan waktu
                Date sekarang = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm:ss");
                String tanggalWaktu = sdf.format(sekarang);
                System.out.println("Tanggal dan Waktu: " + tanggalWaktu);

                // Input data transaksi
                System.out.print("Masukkan No Faktur: ");
                int noFaktur = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                System.out.print("Masukkan Kode Barang: ");
                String kodeBarang = scanner.nextLine();

                System.out.print("Masukkan Nama Barang: ");
                String namaBarang = scanner.nextLine();

                System.out.print("Masukkan Harga Barang: ");
                double hargaBarang = scanner.nextDouble();

                System.out.print("Masukkan Jumlah Beli: ");
                int jumlahBeli = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                // Membuat objek transaksi
                Transaksi transaksi = new Transaksi(noFaktur, kodeBarang, namaBarang, hargaBarang, jumlahBeli);

                // Cetak detail transaksi
                System.out.println("+----------------------------------------------------+");
                System.out.println("No. Faktur    : " + transaksi.getNoFaktur());
                System.out.println("Kode Barang   : " + transaksi.getKode());
                System.out.println("Nama Barang   : " + transaksi.getNama());
                System.out.println("Harga Barang  : " + transaksi.getHarga());
                System.out.println("Jumlah Beli   : " + transaksi.getJumlahBeli());
                System.out.println("TOTAL         : " + transaksi.getTotal());
                System.out.println("+----------------------------------------------------+");
                System.out.println("Kasir         : " + namaKasir);
                System.out.println("+----------------------------------------------------+");

            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Silakan masukkan data yang benar.");
                scanner.nextLine(); // Clear invalid input
            }

            // Menanyakan apakah ingin memasukkan transaksi lagi
            System.out.print("Apakah Anda ingin memasukkan transaksi lagi? (iya/tidak): ");
            String jawab = scanner.nextLine();
            ulang = jawab.equalsIgnoreCase("iya");
        }

        scanner.close(); // Menutup scanner setelah selesai
        System.out.println("Terima kasih telah menggunakan program ini.");
    }

    // Method untuk menghasilkan captcha acak
    private static String generateCaptcha() {
        Random random = new Random();
        int captchaLength = 5; // Panjang captcha
        StringBuilder captcha = new StringBuilder(captchaLength);
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        
        for (int i = 0; i < captchaLength; i++) {
            int randomIndex = random.nextInt(characters.length());
            captcha.append(characters.charAt(randomIndex));
        }
        
        return captcha.toString();
    }
}