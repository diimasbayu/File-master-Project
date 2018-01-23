import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

 public class Form_Utama extends JFrame implements ActionListener{
 	
 	JMenuBar mnuBar = new JMenuBar();
 	JMenu mnuFileMaster = new JMenu ("FileMaster");
 	JMenu mnuTransaksi = new JMenu ("Transaksi");
 	JMenu mnuLaporan = new JMenu ("Laporan");
 	
 	JMenuItem Master_data_Pelanggan = new JMenuItem ("Entry Data Pelanggan",new ImageIcon ("Gambar/Pelanggan.jpg"));
 	JMenuItem Master_data_Barang = new JMenuItem ("Entry Data Barang",new ImageIcon ("Gambar/Barang.jpg"));
 	JMenuItem Master_data_kendaraan = new JMenuItem ("Entry Data Kendaraan",new ImageIcon ("Gambar/Kendaraan.jpg"));
 	
 	JMenuItem mnuPesanan = new JMenuItem ("Pesanan", new ImageIcon ("Gambar/Pesanan.jpg"));
 	JMenuItem mnuNota = new JMenuItem ("Nota", new ImageIcon ("Gambar/Nota.jpg"));
 	JMenuItem mnuSuratJalan = new JMenuItem ("Surat Jalan", new ImageIcon ("Gambar/SuratJalan.jpg"));
 	
 	JMenuItem mnuLapPesan = new JMenuItem ("Cetak Laporan Pemesanan", new ImageIcon ("Gambar/CetakPesanan.jpg"));
 	JMenuItem mnuLapPengiriman = new JMenuItem ("Cetak Laporan Pengiriman", new ImageIcon ("Gambar/CetakPengiriman.jpg"));
 	
 	
 	
 	public Form_Utama(){
 		setSize(350,300);
 		setVisible(true);
 		setLocationRelativeTo(this);
 		setTitle("MENU UTAMA");
 		
 		setJMenuBar (mnuBar);
 		
 		
 		mnuBar.add(mnuFileMaster);
 		mnuBar.setBackground(Color.yellow);
 		mnuFileMaster.add(Master_data_Pelanggan);
 		mnuFileMaster.add(Master_data_Barang);
 		mnuFileMaster.add(Master_data_kendaraan);
 		
 		Master_data_Pelanggan.addActionListener(this);
 		Master_data_Barang.addActionListener(this);
 		Master_data_kendaraan.addActionListener(this);
 		mnuPesanan.addActionListener(this);
 		mnuNota.addActionListener(this);
 		mnuSuratJalan.addActionListener(this);
 		mnuLapPesan.addActionListener(this);
 		mnuLapPengiriman.addActionListener(this);
 		
 		
		mnuBar.add(mnuTransaksi);
		mnuTransaksi.add(mnuPesanan);
		mnuTransaksi.add(mnuNota);
		mnuTransaksi.add(mnuSuratJalan);
		
		mnuBar.add(mnuLaporan);
		mnuLaporan.add(mnuLapPesan);
		mnuLaporan.add(mnuLapPengiriman);
 	}
 	
 	public void actionPerformed (ActionEvent ae){
 		if (ae.getSource()==Master_data_Pelanggan){
 			new Master_data_Pelanggan();
 		}
 		if (ae.getSource()==Master_data_Barang){
 			new Master_data_Barang();
 		}
 		if (ae.getSource()==Master_data_kendaraan){
 			new Master_data_kendaraan();
 		}
 		if (ae.getSource()==mnuPesanan){
 			new mnuPesanan();
 		}
 		if (ae.getSource()==mnuNota){
 			new mnuNota();
 		}
 		if (ae.getSource()==mnuSuratJalan){
 			new mnuSuratJalan();
 		}
 		if (ae.getSource()==mnuLapPesan){
 			new mnuLapPesan();
 		}
 		if (ae.getSource()==mnuLapPengiriman){
 			new mnuLapPengiriman();
 		}
 		

 	}
 	
 	public static void main (String []args){
 		new Form_Utama();
 	}
 }