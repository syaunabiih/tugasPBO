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