import java.util.ArrayList;
import java.util.List;

// Kelas untuk MenuItem
class MenuItem {
    private String nama;
    private double harga;

    public MenuItem(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    @Override
    public String toString() {
        return nama + " - Rp" + harga;
    }
}

// Kelas untuk Order
class Order  {
    private List<MenuItem> items;
    private double pajak;
    private double diskon;

    public Order(double pajak, double diskon)  {
        this.items = new ArrayList<>();
        this.pajak = pajak;
        this.diskon = diskon;
    }


    // Menambahkan item ke dalam pesanan
    public void addItem(MenuItem item) {
        items.add(item);
    }

    // Custom Template: hitungTotal
    public double hitungTotal() {
        double subtotal = items.stream().mapToDouble(MenuItem::getHarga).sum();
        double totalPajak = subtotal * (pajak / 100);
        double totalDiskon = subtotal * (diskon / 100);
        return subtotal + totalPajak - totalDiskon;
    }

    // Menampilkan nota
    public void tampilkanNota() {
        System.out.println("====== Nota Pemesanan ======");
        items.forEach(item -> System.out.println(item));
        double subtotal = items.stream().mapToDouble(MenuItem::getHarga).sum();
        System.out.println("Subtotal: Rp" + subtotal);
        System.out.println("Pajak (" + pajak + "%): Rp" + (subtotal * (pajak / 100)));
        System.out.println("Diskon (" + diskon + "%): Rp" + (subtotal * (diskon / 100)));
        System.out.println("Total Bayar: Rp" + hitungTotal());
        System.out.println("============================");
    }
}

// Kelas utama untuk menjalankan program
public class Main {
    public static void main(String[] args) {
        // Membuat objek Order dengan pajak 10% dan diskon 5%
        Order pesanan = new Order(10, 5);

        // Menambahkan item ke dalam pesanan
        pesanan.addItem(new MenuItem("Nasi Goreng", 20000));
        pesanan.addItem(new MenuItem("Ayam Bakar", 25000));
        pesanan.addItem(new MenuItem("Es Teh", 5000));

        // Menampilkan nota
        pesanan.tampilkanNota();
    }
}
