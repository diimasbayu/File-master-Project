import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.event.*;

 public class mnuPesanan extends JFrame implements ActionListener {
 	JLabel lblJudul = new JLabel ("ENTRY PESANAN");
 	JLabel lblNoPesanan = new JLabel ("No Pesanan ");
 	JLabel lblTanggal = new JLabel ("Tanggal");
 	JLabel lblKodePelanggan = new JLabel ("Kode Pelanggan ");
 	JLabel lblNamaPelanggan = new JLabel ("Nama Pelanggan");
 	JLabel lblAlamatKirim = new JLabel ("Alamat Kirim");
 	
 	
 	JTextField txtNoPesanan = new JTextField (10);
 	JTextField txtKodePelanggan= new JTextField (10);
 	JTextField txtNamaPelanggan = new JTextField (10);
 	JTextField txtAlamatKirim = new JTextField (10);
 	 
 	//sebelah kirinya
 	JLabel lblKodeBarang = new JLabel ("Kode Barang ");
 	JLabel lblNamaBarang = new JLabel ("Nama Barang ");
 	JLabel lblSatuan = new JLabel ("Satuan ");
 	JLabel lblStok = new JLabel ("Stok");
 	JLabel lblHargaSatuan = new JLabel ("Harga Satuan ");
 	JLabel lblJumlahPesan = new JLabel ("Jumlah Pesan ");
 	JLabel lblHargaPesan = new JLabel ("Harga Pesan ");
 	JLabel lblTotal = new JLabel ("Total ");
 	
 	JTextField txtKodeBarang = new JTextField (10);
 	JTextField txtNamaBarang= new JTextField (10);
 	JTextField txtSatuan = new JTextField (10);
 	JTextField txtStok = new JTextField (10);
 	JTextField txtHargaSatuan = new JTextField (10);
 	JTextField txtJumlahPesan = new JTextField (10);
 	JTextField txtHargaPesan = new JTextField (10);
 	JTextField txtTotal = new JTextField (10);
 	JTextField txtTanggal = new JTextField (10);
 	
 	JButton cmdHapus = new JButton ("Hapus");
 	JButton cmdTambah = new JButton ("Tambah");
 	JButton cmdTambah2 = new JButton ("Tambah");
 	JButton cmdBersih = new JButton ("Bersih");


 	String[] strJdl = {"Nomor","Nomor Pesanan","Kode Barang","Nama Barang","Kode Pelanggan","Nama Pelanggan","Jumlah Pesan","Harga Pesan"};
	DefaultTableModel tabMode;
	JTable tabelpesanan = new JTable();
	JScrollPane sptabelpesanan = new JScrollPane();

 	
 	public mnuPesanan(){
 		setSize(800,600);
 		setVisible(true);
 		setLocationRelativeTo(this);
 		setTitle("Pesanan");
 		
 		
 	
 		
 		lblJudul.setBounds(220,10,300,30);
 		lblJudul.setFont(new Font("verdana", Font.BOLD,30));
 		lblNoPesanan.setBounds(20,60,100,25);
 		lblTanggal.setBounds(20,90,100,25);
 		lblKodePelanggan.setBounds(20,120,100 ,25);
 		lblNamaPelanggan.setBounds(20,150,100,25);
 		lblAlamatKirim.setBounds (20,180,100,25);
 		cmdHapus.setBounds(590,60,100,25);	
 		cmdTambah.setBounds(590,90,100,25);
 		cmdTambah2.setBounds(130,230,100,25);
		cmdBersih.setBounds(590,120,100,25);
 		
 		tabMode = new DefaultTableModel(null,strJdl);
		tabelpesanan.setModel(tabMode);
		sptabelpesanan.getViewport().add(tabelpesanan);
		tabelpesanan.setEnabled(true);
		sptabelpesanan.setBounds (20, 300, 700, 200);
		lblTotal.setBounds (500,510,100,25);
		
 		
 		txtNoPesanan.setBounds(130,60,100,25);
 		txtTanggal.setBounds(130,90,100,25);
 		txtKodePelanggan.setBounds(130,120,100,25);
 		txtNamaPelanggan.setBounds(130,150,100,25);
 		txtAlamatKirim.setBounds(130,180,100,25);
 		
 		lblKodeBarang.setBounds(350,60,100,25);
 		lblNamaBarang.setBounds(350,90,100,25);
 		lblSatuan.setBounds(350,120,100,25);
 		lblStok.setBounds(350,150,100,25);
 		lblHargaSatuan.setBounds(350,180,100,25);
 		lblJumlahPesan.setBounds(350,210,100,25);
 		lblHargaPesan.setBounds(350,240,100,25);
 		txtKodeBarang.setBounds(460,60,100,25);
 		txtNamaBarang.setBounds(460,90,100,25);
 		txtSatuan.setBounds(460,120,100,25);
 		txtStok.setBounds(460,150,100,25);
 		txtHargaSatuan.setBounds(460,180,100,25);
 		txtJumlahPesan.setBounds(460,210,100,25);
 		txtHargaPesan.setBounds(460,240,100,25);
 		txtTotal.setBounds(550,510,100,25);
 		
 		
 		
 		getContentPane().setLayout(null);
 		getContentPane().add(lblJudul);
 		getContentPane().add(lblNoPesanan);
 		getContentPane().add(txtNoPesanan);
 		getContentPane().add(lblTanggal);
 		getContentPane().add(txtKodePelanggan);
 		getContentPane().add(txtNamaPelanggan);
 		getContentPane().add(txtAlamatKirim);
 		getContentPane().add(lblNamaPelanggan);
 		getContentPane().add(lblKodePelanggan);
		getContentPane().add(lblAlamatKirim);
		getContentPane().add(txtTanggal);
		getContentPane().add(lblKodeBarang);
		getContentPane().add(lblNamaBarang);
		getContentPane().add(lblSatuan);
		getContentPane().add(lblStok);
		getContentPane().add(lblHargaSatuan);
		getContentPane().add(lblJumlahPesan);
		getContentPane().add(lblHargaPesan);
		getContentPane().add(lblTotal);
		getContentPane().add(txtKodeBarang);
		getContentPane().add(txtNamaBarang);
		getContentPane().add(txtSatuan);
		getContentPane().add(txtStok);
		getContentPane().add(txtHargaSatuan);
		getContentPane().add(txtJumlahPesan);
		getContentPane().add(txtHargaPesan);
		getContentPane().add(txtTotal);
	
		getContentPane().add(cmdHapus);
 		getContentPane().add(cmdTambah);
 		getContentPane().add(cmdTambah2);
 		getContentPane().add(cmdBersih);
 		nonaktif();
 		
 		getContentPane().add(sptabelpesanan);
 		txtNoPesanan.addActionListener(this);
 		txtKodeBarang.addActionListener(this);
 		txtKodePelanggan.addActionListener(this);
 		cmdTambah.addActionListener(this);	
 		cmdTambah2.addActionListener(this);	
 		cmdBersih.addActionListener(this);
 		cmdHapus.addActionListener(this);
 		txtJumlahPesan.addActionListener(this);
 		
 		
 		tabelpesanan.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent mouseEvent){
		tampil();
            }
        }
        );
 	}
 	
 		public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==txtNoPesanan){
			caripesanan1();
		}
		if(ae.getSource()==txtKodeBarang){
			caribarang1();
		}
		if(ae.getSource()==txtKodePelanggan){
			caripelanggan();
		}
		if(ae.getSource()==cmdBersih){
			nonaktif();
		}
		if(ae.getSource()==cmdTambah){
			tambahdetilpesanan();
		}
		if(ae.getSource()==cmdTambah2){
			tambahpesanan();
		}
		if(ae.getSource()==cmdHapus){
			hapuspesanan();
		}
		if(ae.getSource()==txtJumlahPesan){
			Total();
		}
	}
	
	
	
	
	void Total(){
		int harsat = Integer.parseInt(txtHargaSatuan.getText());
		int jumlahpesan = Integer.parseInt(txtJumlahPesan.getText());
		int total = harsat*jumlahpesan;
		txtHargaPesan.setText("" + total);
		
		
	}
	
	
		void tambahpesanan(){
		try{
	   		Koneksi ObjKoneksi = new Koneksi(); //1
	   		Connection con = ObjKoneksi.bukaKoneksi(); //2
	   		Statement st = con.createStatement(); //3
			String sql = "insert into Pesanan values('"+
				txtNoPesanan.getText()+"','"+
				txtTanggal.getText()+"','"+
				txtKodePelanggan.getText()+"','"+
				txtAlamatKirim.getText()+"')" ;
			int vHasil = st.executeUpdate(sql); //
			if (vHasil>0){
				JOptionPane.showMessageDialog(null, "Pesanan Sudah ditambahkan");
			}
 	  		con.close();
		}
		catch(Exception e){
		}
	}	
	
	
	void tampil(){
		try{
			int row = tabelpesanan.getSelectedRow();
			txtKodeBarang.setText(tabMode.getValueAt(row,2).toString());
			caribarang1();
		}
		catch(Exception e){
		}
	} 	
	
	
		void tambahdetilpesanan(){
		try{
	   		Koneksi ObjKoneksi = new Koneksi(); //1
	   		Connection con = ObjKoneksi.bukaKoneksi(); //2
	   		Statement st = con.createStatement(); //3
			String sql = "insert into Detilpesanan values('"+
				txtNoPesanan.getText()+"','"+
				txtKodeBarang.getText()+"','"+
				txtJumlahPesan.getText()+"','"+
				txtHargaPesan.getText()+"','"+
				txtKodePelanggan.getText()+"')" ;
			int vHasil = st.executeUpdate(sql); //
			if (vHasil>0){
				JOptionPane.showMessageDialog(null, "Pesanan Sudah ditambahkan");
			}
 	  		con.close();
 	  		tampilketabel();
		}
		catch(Exception e){
		}
	}	
	
	
	void hapuspesanan(){
 		try {
 			Koneksi ObjKoneksi = new Koneksi ();
 			Connection con = ObjKoneksi.bukaKoneksi();
 				Statement st = con.createStatement();
			String sql = "delete from Detilpesanan where kdbrg='"+txtKodeBarang.getText()+"' and  nopesanan='"+txtNoPesanan.getText()+"'"; 
			int vHasil = st.executeUpdate(sql);
			if (vHasil >0){
				JOptionPane.showMessageDialog (null, "Pesanan Berhasil Dihapus");
			}
 	  		con.close();
 	  	
 	  		tampilketabel();
 		}
 		catch(Exception e){
 		}
 	}
 	
 	void caripesanan1(){
		try{
	   		Koneksi ObjKoneksi = new Koneksi();  
	   		Connection con = ObjKoneksi.bukaKoneksi();  
	   		Statement st = con.createStatement();  
			String sql = "select * from Pesanan where nopesanan='"+
						 txtNoPesanan.getText()+"'" ;
			ResultSet rs = st.executeQuery(sql); //
			if(rs.next()){
				txtTanggal.setText(rs.getString("tglpesanan").substring(0,10));
				txtKodePelanggan.setText(rs.getString("kdpelanggan"));
				txtAlamatKirim.setText(rs.getString("alamatkirim"));
				lanjutan_caripesanan1();
				txtTanggal.setEditable(false);
				txtKodePelanggan.setEditable(false);
				txtAlamatKirim.setEditable(false);
				txtHargaPesan.setEditable(false);
				txtJumlahPesan.setEditable(false);
				tampilketabel();
				cmdTambah2.setEnabled(false);
			}
			else{
				JOptionPane.showMessageDialog(null,"Pesanan Belum Terdaftar, Silahkan isi Pesanan");
				cmdTambah2.setEnabled(true);
				txtTanggal.setEditable(true);
				txtKodePelanggan.setEditable(true);
				txtAlamatKirim.setEditable(true);
				txtHargaPesan.setEditable(true);
				txtJumlahPesan.setEditable(true);
				txtNamaPelanggan.setText("");
				txtKodePelanggan.setText("");
				txtAlamatKirim.setText("");
				txtTanggal.setText("");
				hapusTabel();
			}
			
	   		rs.close();
 	  		con.close();
		}
		catch(Exception e){
		}
	}
		void lanjutan_caripesanan1(){
		try{
	   		Koneksi ObjKoneksi = new Koneksi();  
	   		Connection con = ObjKoneksi.bukaKoneksi();  
	   		Statement st = con.createStatement();  
			String sql = "select nmpelanggan from Pelanggan where kdpelanggan= '"+
						 txtKodePelanggan.getText()+"'" ;
			ResultSet rs = st.executeQuery(sql); //
			if(rs.next()){
				txtNamaPelanggan.setText(rs.getString("nmpelanggan"));
			}
			else{
				JOptionPane.showMessageDialog(null,"Data Tidak Valid");
			}
	   		rs.close();
 	  		con.close();
		}
		catch(Exception e){
		}
	}
	
	void caripelanggan(){
		try{
	   		Koneksi ObjKoneksi = new Koneksi();  
	   		Connection con = ObjKoneksi.bukaKoneksi();  
	   		Statement st = con.createStatement();  
			String sql = "select * from Pelanggan where kdpelanggan='"+
						 txtKodePelanggan.getText()+"'" ;
			ResultSet rs = st.executeQuery(sql); //
			if(rs.next()){
				txtNamaPelanggan.setText(rs.getString("nmpelanggan"));
			}
			else{
				JOptionPane.showMessageDialog(null,"Anda Belum Terdaftar");
			
				}
			
	   		rs.close();
 	  		con.close();
		}
		catch(Exception e){
		}
	}
	
	
		void caribarang1(){
		try{
	   		Koneksi ObjKoneksi = new Koneksi();  
	   		Connection con = ObjKoneksi.bukaKoneksi();  
	   		Statement st = con.createStatement();  
			String sql = "select * from Barang where kdbrg='"+
						 txtKodeBarang.getText()+"'" ;
			ResultSet rs = st.executeQuery(sql); //
			if(rs.next()){
				txtNamaBarang.setText(rs.getString("nmbrg"));
				txtSatuan.setText(rs.getString("satuan"));
				txtStok.setText(rs.getString("stock"));
				txtHargaSatuan.setText(rs.getString("harsat"));
				lanjutan_caribarang1();
			}
			else{
				JOptionPane.showMessageDialog(null,"Barang yang anda Pesan Tidak Dalam Stock");
				txtTanggal.setEditable(true);
				}
			
	   		rs.close();
 	  		con.close();
		}
		catch(Exception e){
		}
	}
	
	
	void lanjutan_caribarang1(){
		try{
	   		Koneksi ObjKoneksi = new Koneksi();  
	   		Connection con = ObjKoneksi.bukaKoneksi();  
	   		Statement st = con.createStatement();  
			String sql = "select jml_pesan,hrg_pesan from Detilpesanan where kdbrg= '"+
						 txtKodeBarang.getText()+"' and nopesanan='"+
						 txtNoPesanan.getText()+"' " ;
			ResultSet rs = st.executeQuery(sql); //
			if(rs.next()){
				txtJumlahPesan.setText(rs.getString("jml_pesan"));
				txtHargaPesan.setText(rs.getString("hrg_pesan"));
				txtJumlahPesan.setEditable(false);
				txtHargaPesan.setEditable(false);
				cmdTambah.setEnabled(false);
				cmdHapus.setEnabled(true);
			}
			else{
				JOptionPane.showMessageDialog(null,"Pesanan Anda Belum Terdaftar");
				txtJumlahPesan.setText("");
				txtHargaPesan.setText("");
				txtJumlahPesan.setEditable(true);
				cmdTambah.setEnabled(true);
			}
	   		rs.close();
 	  		con.close();
		}
		catch(Exception e){
		}
	}
	
	
	void tampilketabel(){
		try{
			hapusTabel();
	   		Koneksi ObjKoneksi = new Koneksi(); //1
	   		Connection con = ObjKoneksi.bukaKoneksi(); //2
	   		Statement st = con.createStatement(); //3
			String sql = "select Detilpesanan.nopesanan,Detilpesanan.kdbrg,Detilpesanan.jml_pesan,Detilpesanan.hrg_pesan "+
			",Barang.nmbrg,Pelanggan.kdpelanggan,Pelanggan.nmpelanggan "+
				" from Detilpesanan,Barang,Pelanggan "+
				" where nopesanan='"+txtNoPesanan.getText()+
				"' and Detilpesanan.kdbrg=Barang.kdbrg and Detilpesanan.kdpelanggan=Pelanggan.kdpelanggan" ;
			ResultSet rs = st.executeQuery(sql); //
			int Total=0;
			while(rs.next()){
				String vnopesanan	= rs.getString("nopesanan");
				String vKodeBarang	= rs.getString("kdbrg");
				String vNamaBarang	= rs.getString("nmbrg");
				String vKodePelanggan 		= rs.getString("kdpelanggan");
				String vNamaPelanggan		= rs.getString("nmpelanggan");
				String vjml_pesan		= rs.getString("jml_pesan");
				String vhrg_pesan		= rs.getString("hrg_pesan");

				String[] data 	= {"",vnopesanan,vKodeBarang,vNamaBarang,vKodePelanggan,vNamaPelanggan,vjml_pesan,vhrg_pesan};
				tabMode.addRow(data);
				Total+=Integer.parseInt(vhrg_pesan);	
				resetNo();
			}
        		txtTotal.setText(""+Total);
	   		rs.close();
 	  		con.close();
		}
		catch(Exception e){
		}
 	}
	 		void resetNo(){
		int brs = tabMode.getRowCount();
		for(int i=0;i<brs;i++){
			String no = String.valueOf(i+1);
			tabMode.setValueAt(no+".",i,0);
		}
	}

	void hapusTabel(){
		int brs = tabMode.getRowCount();
		for(int i=0;i<brs;i++){
			tabMode.removeRow(0);
		}
	}
	
	void nonaktif(){
		txtNamaPelanggan.setEditable(false);
		txtTanggal.setEditable(false);
		txtAlamatKirim.setEditable(false);
		txtKodePelanggan.setEditable(false);
		txtNamaBarang.setEditable(false);
		txtSatuan.setEditable(false);
		txtStok.setEditable(false);
		txtHargaSatuan.setEditable(false);
		txtJumlahPesan.setEditable(false);
		txtHargaPesan.setEditable(false);
		txtTotal.setEditable(false);
		
		cmdTambah.setEnabled(false);
		cmdTambah2.setEnabled(false);
		cmdHapus.setEnabled(false);
		txtTotal.setText("");
		txtKodeBarang.setText("");
		txtNoPesanan.setText("");
		txtNamaPelanggan.setText("");
		txtTanggal.setText("");
		txtAlamatKirim.setText("");
		txtKodePelanggan.setText("");
		txtNamaBarang.setText("");
		txtSatuan.setText("");
		txtStok.setText("");
		txtHargaSatuan.setText("");
		txtJumlahPesan.setText("");
		txtHargaPesan.setText("");		
		hapusTabel();
	}
	
		
	
	
 	public static void main (String []args){
 		new mnuPesanan();
 	}
 }