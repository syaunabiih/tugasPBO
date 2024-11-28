class Barang {
    private String kode; // Kode barang
    private String nama; // Nama barang
    private double harga; // Harga barang

    public Barang(String kode, String nama, double harga) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }
}

class Transaksi extends Barang {
    private int noFaktur; // Nomor faktur transaksi
    private int jumlahBeli; // Jumlah barang yang dibeli
    private double total; // Total harga

    public Transaksi(int noFaktur, String kode, String nama, double harga, int jumlahBeli) {
        super(kode, nama, harga);
        this.noFaktur = noFaktur;
        this.jumlahBeli = jumlahBeli;
        this.total = harga * jumlahBeli;
    }

    public int getNoFaktur() {
        return noFaktur;
    }

    public int getJumlahBeli() {
        return jumlahBeli;
    }

    public double getTotal() {
        return total;
    }
}