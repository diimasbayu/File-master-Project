import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.event.*;



 public class Master_data_kendaraan extends JFrame implements ActionListener{
 	JLabel lblJudul = new JLabel ("ENTRY DATA KENDARAAN");
 	JLabel lblnopol = new JLabel ("Nomor Polisi :");
 	JLabel lbljeniskendaraan = new JLabel ("Jenis Kendaraan:");
 
 	
 	JTextField txtnopol = new JTextField (10);
 	JTextField txtjeniskendaraan= new JTextField (10);

 	
 	JButton btnTambah = new JButton ("TAMBAH");
 	JButton btnUbah = new JButton ("UBAH");
 	JButton btnHapus = new JButton ("HAPUS");
 	JButton btnBersih = new JButton ("BERSIH");
 	
 	
 	String[] strJdl = {"Nomor","Nomor Polisi","Jenis Kendaraan"};
	DefaultTableModel tabMode;
	JTable tabelKendaraan = new JTable();
	JScrollPane sptabelKendaraan = new JScrollPane();
	
 	public Master_data_kendaraan(){
 		
 		setSize(600,280);
 		setVisible(true);
 		setLocationRelativeTo(this);
 		setTitle("Entry Data Kendaraan");
 		
 		
 		lblJudul.setBounds(70,10,600,30);
 		lblJudul.setFont(new Font	("verdana", Font.BOLD,30));
 		lblnopol.setBounds(20,60,100,25);
 		lbljeniskendaraan.setBounds(20,90,100,25);
 		
 		btnTambah.setBounds(20,140,100,25);
 		btnUbah.setBounds(20,170,100,25);
 		btnHapus.setBounds(130,140,100,25);
 		btnBersih.setBounds(130,170,100,25);
 		
 		tabMode = new DefaultTableModel(null,strJdl);
		tabelKendaraan.setModel(tabMode);
		sptabelKendaraan.getViewport().add(tabelKendaraan);
		tabelKendaraan.setEnabled(true);
		sptabelKendaraan.setBounds (265, 60, 300, 150);
 		
 		txtnopol.setBounds(130,60,120,25);
 		txtjeniskendaraan.setBounds(130,90,100,25);
 		
 		
		getContentPane().setLayout(null);
 		getContentPane().add(lblJudul);
 		getContentPane().add(lblnopol);
 		getContentPane().add(txtnopol);
 		getContentPane().add(lbljeniskendaraan);
 		getContentPane().add(txtjeniskendaraan);
		
 		getContentPane().add(btnTambah);
 		getContentPane().add(btnUbah);
 		getContentPane().add(btnHapus);
 		getContentPane().add(btnBersih);
 		getContentPane().add(sptabelKendaraan);
 		
 		btnTambah.addActionListener(this);
 		btnHapus.addActionListener(this);
 		btnUbah.addActionListener(this);
 		btnBersih.addActionListener(this);
 		txtnopol.addActionListener(this);
 		
 		tabelKendaraan.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent mouseEvent){
		tampil();
            }
        }
        );
		
		bersihKendaraan();
		
 		setVisible (true);
 			
 	}
 	
 	public void actionPerformed(ActionEvent ae) {
 		if(ae.getSource()==btnTambah){
 			tambahKendaraan();
 		}
 		if(ae.getSource()==btnHapus){
 			hapusKendaraan();
 		}
 		if(ae.getSource()==btnUbah){
 			ubahKendaraan();
 		}
 		if(ae.getSource()==btnBersih){
 			bersihKendaraan();
 		}
 		if(ae.getSource()==txtnopol){
 			if (txtnopol.getText().equals("")){
 				JOptionPane.showMessageDialog (null, "Harap Masukan Nomor Polisi!");
 			}else{
 				cariNomorPolisi();
 			}
 			
 		}
 	}
 	void tampil(){
		try{
			int row = tabelKendaraan.getSelectedRow();
			txtnopol.setText(tabMode.getValueAt(row,1).toString());
			cariNomorPolisi();
		}
		catch(Exception e){
		}
	} 	
	
 	
 	void cariNomorPolisi(){
 		try{
	   		Koneksi ObjKoneksi = new Koneksi();
	   		Connection con = ObjKoneksi.bukaKoneksi();
	   		Statement st = con.createStatement();
			String sql = "select * from Kendaraan where nopolisi='"+txtnopol.getText()+"'" ;
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				 		
				txtjeniskendaraan.setText(rs.getString("jeniskendaraan"));
				btnTambah.setEnabled(false);
				btnUbah.setEnabled(true);
				btnHapus.setEnabled(true);
				JOptionPane.showMessageDialog (null, "DATA DITEMUKAN !!!");
			}
			else{
				btnTambah.setEnabled(true);
				btnUbah.setEnabled(false);
				btnHapus.setEnabled(false);
				JOptionPane.showMessageDialog (null, "DATA TIDAK DITEMUKAN !!!\nSILAHKAN KLIK TAMBAH");
			}
	   		rs.close();
 	  		con.close();
		}
		catch(Exception e){
		}
 	}
 	
 		void bersihKendaraan(){
 			txtnopol.setText("");
 			txtjeniskendaraan.setText("");
 			
 			btnTambah.setEnabled(false);
 			btnUbah.setEnabled(false);
 			btnHapus.setEnabled(false);
 			
 			tampilketabel();
 		}
 		
 		
 	 	void hapusKendaraan(){
 		try {
 			Koneksi ObjKoneksi = new Koneksi ();
 			Connection con = ObjKoneksi.bukaKoneksi();
 				Statement st = con.createStatement();
			String sql = "delete from = Kendaraan where nopolisi='" + txtnopol.getText()+"'"; 
			int vHasil = st.executeUpdate(sql);
			if (vHasil >0){
				JOptionPane.showMessageDialog (null, "DATA BERHASIL DIHAPUS");
			}
 	  		con.close();
 	  		bersihKendaraan();
 		}
 		catch(Exception e){
 		}
 	}
 	
 	
 	void ubahKendaraan(){
 		try {
 			Koneksi ObjKoneksi = new Koneksi ();
 			Connection con = ObjKoneksi.bukaKoneksi();
 				Statement st = con.createStatement();
			String sql = "update Kendaraan set jeniskendaraan='"+ 
			txtjeniskendaraan.getText()+"' where nopolisi='" + txtnopol.getText()+"'";
			int vHasil = st.executeUpdate(sql);
			if (vHasil >0){
				JOptionPane.showMessageDialog (null, "Data Sudah DiUbah");
			}
 	  		con.close();
			bersihKendaraan();
 		}
 		catch(Exception e){
 		}
 	}
 	
 	
 	void tambahKendaraan(){
 		try {
 			Koneksi ObjKoneksi = new Koneksi ();
 			Connection con = ObjKoneksi.bukaKoneksi();
 				Statement st = con.createStatement();
			String sql = "insert into Kendaraan values ('"+ 
			txtnopol.getText()+"','"+
			txtjeniskendaraan.getText()+"')";
			int vHasil = st.executeUpdate(sql);
			if (vHasil >0){
				JOptionPane.showMessageDialog (null, "DATA BERHASIL DI TAMBAHKAN");
			}
 	  		con.close();
 	  		
 	  		bersihKendaraan();
 		}
 		catch(Exception e){
 		}
 	}
 			
 	void tampilketabel(){
		try{
			hapusTabel();
	   		Koneksi ObjKoneksi = new Koneksi();
	   		Connection con = ObjKoneksi.bukaKoneksi();
	   		Statement st = con.createStatement();
			String sql = "select * from Kendaraan" ;
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				 		
				String vNoPolisi = rs.getString("nopolisi");
				String vJenisKendaraan = rs.getString("jeniskendaraan");
			
				String[] data = {"",vNoPolisi,vJenisKendaraan};
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
 		new Master_data_kendaraan();
 	}
 }