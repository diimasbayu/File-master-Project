import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.event.*;



 public class Master_data_Pelanggan extends JFrame implements ActionListener{
 	JLabel lblJudul = new JLabel ("ENTRY PELANGGAN");
 	JLabel lblKdPelanggan = new JLabel ("Kode Pelanggan :");
 	JLabel lblNamaPelanggan = new JLabel ("Nama Pelanggan:");
 	JLabel lblAlamat = new JLabel ("Alamat :");
 	JLabel lblTelepon = new JLabel ("Telepon:");
 	
 	JTextField txtKdPelanggan = new JTextField (10);
 	JTextField txtNamaPelanggan= new JTextField (10);
 	JTextField txtTelepon = new JTextField (10);
 	JTextArea txtAlamat = new JTextArea ();
 	
 	JButton cmdTambah = new JButton ("TAMBAH");
 	JButton cmdUbah = new JButton ("UBAH");
 	JButton cmdHapus = new JButton ("HAPUS");
 	JButton cmdBersih = new JButton ("BERSIH");
 	
 	
 	//deklarasi objek tabel
 	String[] strJdl = {"Nomor","Kode Pelanggan","Nama Pelanggan","Alamat","Telepon"};
	DefaultTableModel tabMode;
	JTable tabelPelanggan = new JTable();
	JScrollPane sptabelPelanggan = new JScrollPane();
	
 	public Master_data_Pelanggan(){
 		
 		setSize(600,600);
 		setVisible(true);
 		setLocationRelativeTo(this);
 		setTitle("Entry Data Pelanggan");
 		
 			//Mengatur objek text Area
 		txtAlamat.setLineWrap(true);
 		txtAlamat.setWrapStyleWord(true);
 		JScrollPane scrollPane = new JScrollPane(txtAlamat,
 				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
 	
 		//setiing lokasi dengan bound (X,Y,WIDTH,HEIGHT)
 		
 		//baris x
 		lblJudul.setBounds(120,10,400,30);
 		lblJudul.setFont(new Font	("verdana", Font.BOLD,30));
 		lblKdPelanggan.setBounds(20,60,100,25);
 		lblNamaPelanggan.setBounds(20,90,100,25);
 		lblAlamat.setBounds(20,120,100,25);
 		lblTelepon.setBounds(20,180,100,25);
 		cmdTambah.setBounds(20,220,100,25);
 		cmdUbah.setBounds(125,220,100,25);
 		cmdHapus.setBounds(230,220,100,25);
 		cmdBersih.setBounds(335,220,100,25);
 		
 		tabMode = new DefaultTableModel(null,strJdl);
		tabelPelanggan.setModel(tabMode);
		sptabelPelanggan.getViewport().add(tabelPelanggan);
		tabelPelanggan.setEnabled(true);
		sptabelPelanggan.setBounds (20, 300, 500, 200);	//batasan scroll.
 		
 		//baris y
 		txtKdPelanggan.setBounds(130,60,100,25);
 		txtNamaPelanggan.setBounds(130,90,100,25);
 		scrollPane.setBounds(130,120,200,50);
 		txtTelepon.setBounds(130,180,100,25);
 		
 		
 		
 		//masukkan content
 		getContentPane().setLayout(null);
 		getContentPane().add(lblJudul);
 		getContentPane().add(lblKdPelanggan);
 		getContentPane().add(txtKdPelanggan);
 		getContentPane().add(lblNamaPelanggan);
 		getContentPane().add(txtNamaPelanggan);
 		getContentPane().add(txtTelepon);
 		getContentPane().add(lblTelepon);
 		getContentPane().add(lblAlamat);
		getContentPane().add(scrollPane);
		
 		getContentPane().add(cmdTambah);
 		getContentPane().add(cmdUbah);
 		getContentPane().add(cmdHapus);
 		getContentPane().add(cmdBersih);
 		getContentPane().add(sptabelPelanggan);
 		
 		//action listener untuk button tambah hapus ubah
 		cmdTambah.addActionListener(this);
 		cmdHapus.addActionListener(this);
 		cmdUbah.addActionListener(this);
 		cmdBersih.addActionListener(this);
 		txtKdPelanggan.addActionListener(this);
 		
 		tabelPelanggan.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent mouseEvent){
		tampil();
            }
        }
        );
		
		bersihPelanggan();
		
 		setVisible (true);
 			
 	}
 	
 	public void actionPerformed(ActionEvent ae) {
 		if(ae.getSource()==cmdTambah){
 			tambahPelanggan();
 		}
 		if(ae.getSource()==cmdHapus){
 			hapusPelanggan();
 		}
 		if(ae.getSource()==cmdUbah){
 			ubahBrg();
 		}
 		if(ae.getSource()==cmdBersih){
 			bersihPelanggan();
 		}
 		if(ae.getSource()==txtKdPelanggan){
 			if (txtKdPelanggan.getText().equals("")){
 				JOptionPane.showMessageDialog (null, "Harap Masukkan Kode Pelanggan Anda!");
 			}
 			else{
 				cariPelanggan();
 			}
 			
 		}
 	}
 	//mENAMPILKAN DENGAN CARA MENGCLICK MOUSE
 	void tampil(){
		try{
			int row = tabelPelanggan.getSelectedRow();
			txtKdPelanggan.setText(tabMode.getValueAt(row,1).toString());
			cariPelanggan();
		}
		catch(Exception e){
		}
	} 	
	
 	//cari Barang dengan cara menekan enter di txt lblKdPelanggan
 	
 	void cariPelanggan(){
 		try{
	   		Koneksi ObjKoneksi = new Koneksi();
	   		Connection con = ObjKoneksi.bukaKoneksi();
	   		Statement st = con.createStatement();
			String sql = "select * from Pelanggan where kdpelanggan='"+txtKdPelanggan.getText()+"'" ;
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				 		
				txtNamaPelanggan.setText(rs.getString("nmpelanggan"));
				txtAlamat.setText(rs.getString("alamat"));
				txtTelepon.setText(rs.getString("telepon"));
				cmdTambah.setEnabled(false);
				cmdUbah.setEnabled(true);
				cmdHapus.setEnabled(true);
				JOptionPane.showMessageDialog (null, "DATA DITEMUKAN !!!");
			}
			else{
				cmdTambah.setEnabled(true);
				cmdUbah.setEnabled(false);
				cmdHapus.setEnabled(false);
				JOptionPane.showMessageDialog (null, "DATA TIDAK DITEMUKAN !!!\nSILAHKAN KLIK TAMBAH");
			}
	   		rs.close();
 	  		con.close();
 	  		//tampil(); //dipanggil saat tabel di doble click
		}
		catch(Exception e){
		}
 	}
 	
 	//btn bersih
 		void bersihPelanggan(){
 			txtKdPelanggan.setText("");
 			txtNamaPelanggan.setText("");
 			txtTelepon.setText("");
 			txtAlamat.setText("");
 			
 			cmdTambah.setEnabled(false);
 			cmdUbah.setEnabled(false);
 			cmdHapus.setEnabled(false);
 			
 			tampilketabel();
 		}
 		
 		
 		// btn hapus
 	 	void hapusPelanggan(){
 		try {
 			Koneksi ObjKoneksi = new Koneksi ();
 			Connection con = ObjKoneksi.bukaKoneksi();
 				Statement st = con.createStatement();
			String sql = "delete from Pelanggan where kdpelanggan='" + txtKdPelanggan.getText()+"'"; 
			int vHasil = st.executeUpdate(sql);
			if (vHasil >0){
				JOptionPane.showMessageDialog (null, "DATA BERHASIL DIHAPUS");
			}
 	  		con.close();
 	  		// menghapus data setelah import 
 	  		bersihPelanggan();
 		}
 		catch(Exception e){
 		}
 	}
 	
 	
 	//btn ubah 
 	void ubahBrg(){
 		try {
 			Koneksi ObjKoneksi = new Koneksi ();
 			Connection con = ObjKoneksi.bukaKoneksi();
 				Statement st = con.createStatement();
			String sql = "update Pelanggan set nmpelanggan='"+ 
			txtNamaPelanggan.getText()+"',alamat='"+
			txtAlamat.getText()+"',telepon='"+
			txtTelepon.getText()+"' where kdpelanggan='" + txtKdPelanggan.getText()+"'";
			int vHasil = st.executeUpdate(sql);
			if (vHasil >0){
				JOptionPane.showMessageDialog (null, "Data Sudah DiUbah");
			}
 	  		con.close();
 	  		//menghaps setelah diimport
			bersihPelanggan();
 		}
 		catch(Exception e){
 		}
 	}
 	
 	
 	// btn tambah 
 	void tambahPelanggan(){
 		try {
 			Koneksi ObjKoneksi = new Koneksi ();
 			Connection con = ObjKoneksi.bukaKoneksi();
 				Statement st = con.createStatement();
			String sql = "insert into Pelanggan values ('"+ 
			txtKdPelanggan.getText()+"','"+
			txtNamaPelanggan.getText()+"','"+
			txtAlamat.getText()+"','"+
			txtTelepon.getText()+"')";
			int vHasil = st.executeUpdate(sql);
			if (vHasil >0){
				JOptionPane.showMessageDialog (null, "DATA BERHASIL DI TAMBAHKAN");
			}
 	  		con.close();
 	  		
			//menghapus data setelah diimport
 	  		bersihPelanggan();
 		}
 		catch(Exception e){
 		}
 	}
 			
 	// menampilkan data ke tabel
 	void tampilketabel(){
		try{
			hapusTabel();
	   		Koneksi ObjKoneksi = new Koneksi();
	   		Connection con = ObjKoneksi.bukaKoneksi();
	   		Statement st = con.createStatement();
			String sql = "select * from Pelanggan" ;
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				 		
				String vlblKdPelanggan = rs.getString("kdpelanggan");
				String vNamaBarang = rs.getString("nmpelanggan");
				String vAlamat = rs.getString("alamat");
				String vTelepon = rs.getString("telepon");
				String[] data = {"",vlblKdPelanggan,vNamaBarang,vAlamat,vTelepon};
				tabMode.addRow(data);	
				resetNo();
			}
	   		rs.close();
 	  		con.close();
 	  		//tampil(); //dipanggil saat tabel di doble click
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
 		new Master_data_Pelanggan();
 	}
 }