import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.event.*;




 public class mnuNota extends JFrame implements ActionListener{
 	
 	
 	JLabel lblJudul = new JLabel ("ENTRY NOTA");
 	
 	JLabel lblno_nota = new JLabel ("No. Nota");
 	JLabel lbltglnota = new JLabel ("Tanggal Nota");
 	
 	JLabel lblNoPesanan = new JLabel ("No Pesanan");
 	JLabel lblTanggal = new JLabel ("Tanggal");
 	JLabel lblKodePelanggan = new JLabel ("Kode Pelanggan");
 	JLabel lblNamaPelanggan = new JLabel ("Nama Pelanggan");
 	JLabel lblAlamatKirim = new JLabel ("Alamat Kirim");
 	
 	JTextField txtnonota = new JTextField (10);
 	JTextField txtTanggalnota = new JTextField (10);
 	JTextField txtNoPesanan = new JTextField (10);
 	JTextField txtTanggal = new JTextField (10);
 	JTextField txtKodePelanggan= new JTextField (10);
 	JTextField txtNamaPelanggan = new JTextField (10);
 	JTextField txtAlamatKirim = new JTextField (10);
 	
 	
 	JButton cmdHapus = new JButton ("Hapus");
 	JButton cmdTambah = new JButton ("Tambah");
 	JButton cmdBersih = new JButton ("Bersih");
 	
 	String[] strJdl = {"Nomor" , "Nomor Nota" , "Tanggal Nota" , "Nomor Pesanan" ,"Kode Pelanggan" , "Nama Pelanggan"};
	DefaultTableModel tabMode;
	JTable tabelnota = new JTable();
	JScrollPane sptabelnota = new JScrollPane();
 	
 	public mnuNota(){
 		setSize(600,500);
 		setVisible(true);
 		setLocationRelativeTo(this);
 		setTitle("Nota");
 		
 		
 		lblJudul.setBounds(220,10,300,30);
 		lblJudul.setFont(new Font("verdana", Font.BOLD,30));
 		
 		lblno_nota.setBounds(20,60,100,25);
 		lbltglnota.setBounds(20,90,100,25);
 		lblNoPesanan.setBounds(350,60,100,25);
 		lblTanggal.setBounds(350,90,100,25);
 		lblKodePelanggan.setBounds(350,120,100 ,25);
 		lblNamaPelanggan.setBounds(350,150,100,25);
 		lblAlamatKirim.setBounds (350,180,100,25);
 		
 		txtnonota.setBounds(130,60,100,25);
 		txtTanggalnota.setBounds(130,90,100,25);
 		txtNoPesanan.setBounds(460,60,100,25);
 		txtTanggal.setBounds(460,90,100,25);
 		txtKodePelanggan.setBounds(460,120,100,25);
 		txtNamaPelanggan.setBounds(460,150,100,25);
 		txtAlamatKirim.setBounds(460,180,100,25);
 		
 		
 		tabMode = new DefaultTableModel(null,strJdl);
		tabelnota.setModel(tabMode);
		sptabelnota.getViewport().add(tabelnota);
		tabelnota.setEnabled(true);
		sptabelnota.setBounds (10, 240, 560, 200);
		
 		
 		cmdHapus.setBounds(120,160,90,25);
		cmdTambah.setBounds(20,160,90,25);
		cmdBersih.setBounds(220,160,90,25);
 		
 		getContentPane().setLayout(null);
 		getContentPane().add(lblJudul);
 		
 		getContentPane().add(lblno_nota);
 		getContentPane().add(lbltglnota);
 		getContentPane().add(txtnonota);
 		getContentPane().add(txtTanggalnota);
 		
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
		
		getContentPane().add(cmdHapus);
		getContentPane().add(cmdTambah);
		getContentPane().add(cmdBersih);
		
		
		
		
		getContentPane().add(sptabelnota);
		

	
		
		nonaktif();
		txtnonota.addActionListener(this);
		cmdBersih.addActionListener(this);
		cmdTambah.addActionListener(this);
		cmdHapus.addActionListener(this);
		txtNoPesanan.addActionListener(this);
	
 	}
 	
 	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==txtnonota){
			carinota();
			}
		if(ae.getSource()==cmdBersih){
			nonaktif();
			}
		if(ae.getSource()==txtNoPesanan){
			caripesanan1();
			}
		if(ae.getSource()==cmdTambah){
			tambahnota();
			}
		if(ae.getSource()==cmdHapus){
			hapusnota();
			}
		} 
		
 	
 	void carinota(){
		try{
	   		Koneksi ObjKoneksi = new Koneksi();  
	   		Connection con = ObjKoneksi.bukaKoneksi();  
	   		Statement st = con.createStatement();  
			String sql ="select nota.tgl_nota, nota.nopesanan, Pesanan.tglpesanan, Pesanan.kdpelanggan, pesanan.alamatkirim "+
						" from nota , Pesanan where no_nota='"+txtnonota.getText()+"' and nota.nopesanan=Pesanan.nopesanan ";
			ResultSet rs = st.executeQuery(sql); 
			if(rs.next()){
				txtTanggalnota.setText(rs.getString("tgl_nota").substring(0,10));
				txtNoPesanan.setText(rs.getString("nopesanan"));
				txtTanggal.setText(rs.getString("tglpesanan").substring(0,10));
				txtKodePelanggan.setText(rs.getString("kdpelanggan"));
				txtAlamatKirim.setText(rs.getString("alamatkirim"));
				txtTanggalnota.setEditable(false);
	   			txtNoPesanan.setEditable(false);
				cmdHapus.setEnabled(true);
				cmdTambah.setEnabled(false);
				carinmpelanggan();
				tampilketabel();
			}
			else{
				JOptionPane.showMessageDialog(null,"Tidak Ada Nota");
	   			cmdTambah.setEnabled(true);
	   			cmdHapus.setEnabled(false);
	   			txtTanggalnota.setEditable(true);
	   			txtNoPesanan.setEditable(true);
	   			txtTanggalnota.setText("");
	   			txtNamaPelanggan.setText("");
				txtNoPesanan.setText("");
				txtTanggal.setText("");
				txtKodePelanggan.setText("");
				txtAlamatKirim.setText("");
				hapusTabel();

			}
			
	   		rs.close();
 	  		con.close();
		}
		catch(Exception e){
		}
	}
	
	
	void carinmpelanggan(){
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
				tampilketabel();
			}
			else{
				JOptionPane.showMessageDialog(null,"Pesanan Belum Terdaftar, Silahkan isi Form Pesanan");
				txtNamaPelanggan.setText("");
				txtKodePelanggan.setText("");
				txtAlamatKirim.setText("");
				txtTanggal.setText("");
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
	
	
		void tambahnota(){
		try{
	   		Koneksi ObjKoneksi = new Koneksi(); //1
	   		Connection con = ObjKoneksi.bukaKoneksi(); //2
	   		Statement st = con.createStatement(); //3
			String sql = "insert into nota values('"+
				txtnonota.getText()+"','"+
				txtTanggalnota.getText()+"','"+
				txtNoPesanan.getText()+"')" ;
			int vHasil = st.executeUpdate(sql); //
			if (vHasil>0){
				JOptionPane.showMessageDialog(null, "Nota Sudah dibuat");
				tampilketabel();
			}
 	  		con.close();
		}
		catch(Exception e){
		}
	}	
	
	
	void hapusnota(){
 		try {
 			Koneksi ObjKoneksi = new Koneksi ();
 			Connection con = ObjKoneksi.bukaKoneksi();
 				Statement st = con.createStatement();
			String sql = "delete from nota where no_nota='"+txtnonota.getText()+"'"; 
			int vHasil = st.executeUpdate(sql);
			if (vHasil >0){
				JOptionPane.showMessageDialog (null, "Nota Berhasil Dihapus");
			}
 	  		con.close();
 	  	
 	  		nonaktif();
 		}
 		catch(Exception e){
 		}
 	}
	
	
	void nonaktif(){
		txtnonota.setText("");
		txtTanggalnota.setText("");
		txtTanggalnota.setEditable(false);
		txtNoPesanan.setText("");
		txtNoPesanan.setEditable(false);
		txtKodePelanggan.setText("");
		txtKodePelanggan.setEditable(false);
		txtNamaPelanggan.setText("");
		txtNamaPelanggan.setEditable(false);
		txtAlamatKirim.setText("");
		txtAlamatKirim.setEditable(false);
		txtTanggal.setText("");
		txtTanggal.setEditable(false);
		hapusTabel();
		
		cmdTambah.setEnabled(false);
		cmdHapus.setEnabled(false);
	}
 	
 	
 	
 	void tampilketabel(){
		try{
			hapusTabel();
	   		Koneksi ObjKoneksi = new Koneksi(); //1
	   		Connection con = ObjKoneksi.bukaKoneksi(); //2
	   		Statement st = con.createStatement(); //3
			String sql ="select nota.no_nota, nota.tgl_nota, nota.nopesanan, Pesanan.kdpelanggan, Pelanggan.nmpelanggan "+
						" from nota, Pesanan, Pelanggan where no_nota='"+txtnonota.getText()+"' and nota.nopesanan=Pesanan.nopesanan "+
						" and Pesanan.kdpelanggan=Pelanggan.kdpelanggan" ;
			ResultSet rs = st.executeQuery(sql); //
			while(rs.next()){
				String vno_nota	= rs.getString("no_nota");
				String vtgl_nota	= rs.getString("tgl_nota").substring(0,10);
				String vnopesanan	= rs.getString("nopesanan");
				String vkdpelanggan= rs.getString("kdpelanggan");
				String vnmpelanggan= rs.getString("nmpelanggan");

				String[] data 	= {"",vno_nota,vtgl_nota,vnopesanan,vkdpelanggan,vnmpelanggan};
				tabMode.addRow(data);
				resetNo();
			}
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
 	
 	
 	
 	public static void main (String []args){
 		new mnuNota();
 	}
 }