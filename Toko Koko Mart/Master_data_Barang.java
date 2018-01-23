import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.event.*;



 public class Master_data_Barang extends JFrame implements ActionListener{
 	JLabel lblJudul = new JLabel ("ENTRY BARANG");
 	JLabel lblkd_brg = new JLabel ("Kode Barang :");
 	JLabel lblnm_brg = new JLabel ("Nama Barang:");
 	JLabel lblhargasatuan = new JLabel ("Harga Satuan :");
 	JLabel lblstok = new JLabel ("Stock:");
 	JLabel lblsatuan = new JLabel ("Satuan:");
 	
 	JTextField txtkd_brg = new JTextField (10);
 	JTextField txtnm_brg= new JTextField (10);
 	JTextField txthargasatuan = new JTextField (10);
 	JTextField txtstok = new JTextField (10);
 	JTextField txtsatuan = new JTextField (10);
 	
 	JButton btnTambah = new JButton ("TAMBAH");
 	JButton btnUbah = new JButton ("UBAH");
 	JButton btnHapus = new JButton ("HAPUS");
 	JButton btnBersih = new JButton ("BERSIH");
 	
 	
 	String[] strJdl = {"Nomor","Kode Barang","Nama Barang","Harga Satuan","Stock","Satuan"};
	DefaultTableModel tabMode;
	JTable tabelBrg = new JTable();
	JScrollPane sptabelBrg = new JScrollPane();
	
 	public Master_data_Barang(){
 		
 		setSize(540,500);
 		setVisible(true);
 		setLocationRelativeTo(this);
 		setTitle("Entry Data Barang");
 		
 		
 		lblJudul.setBounds(150,10,300,30);
 		lblJudul.setFont(new Font	("verdana", Font.BOLD,30));
 		lblkd_brg.setBounds(20,60,100,25);
 		lblnm_brg.setBounds(20,90,100,25);
 		lblhargasatuan.setBounds(20,120,100,25);
 		lblstok.setBounds(20,150,100,25);
 		lblsatuan.setBounds (20,180,100,25);
 		
 		btnTambah.setBounds(400,60,100,25);
 		btnUbah.setBounds(400,100,100,25);
 		btnHapus.setBounds(400,140,100,25);
 		btnBersih.setBounds(400,180,100,25);
 		
 		tabMode = new DefaultTableModel(null,strJdl);
		tabelBrg.setModel(tabMode);
		sptabelBrg.getViewport().add(tabelBrg);
		tabelBrg.setEnabled(true);
		sptabelBrg.setBounds (20, 240, 480, 200);
 		
 		txtkd_brg.setBounds(130,60,130,25);
 		txtnm_brg.setBounds(130,90,200,25);
 		txtsatuan.setBounds(130,120,130,25);
 		txtstok.setBounds(130,150,70,25);
 		txthargasatuan.setBounds(130,180,130,25);
 		
 		
 		getContentPane().setLayout(null);
 		getContentPane().add(lblJudul);
 		getContentPane().add(lblkd_brg);
 		getContentPane().add(txtkd_brg);
 		getContentPane().add(lblnm_brg);
 		getContentPane().add(txtnm_brg);
 		getContentPane().add(txthargasatuan);
 		getContentPane().add(txtstok);
 		getContentPane().add(lblstok);
 		getContentPane().add(lblhargasatuan);
		getContentPane().add(lblsatuan);
		getContentPane().add(txtsatuan);
		
 		getContentPane().add(btnTambah);
 		getContentPane().add(btnUbah);
 		getContentPane().add(btnHapus);
 		getContentPane().add(btnBersih);
 		getContentPane().add(sptabelBrg);
 		
 		btnTambah.addActionListener(this);
 		btnHapus.addActionListener(this);
 		btnUbah.addActionListener(this);
 		btnBersih.addActionListener(this);
 		txtkd_brg.addActionListener(this);
 		
 		tabelBrg.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent mouseEvent){
		tampil();
            }
        }
        );
		
		bersihBrg();
		
 		setVisible (true);
 			
 	}
 	
 	public void actionPerformed(ActionEvent ae) {
 		if(ae.getSource()==btnTambah){
 			tambahBrg();
 		}
 		if(ae.getSource()==btnHapus){
 			hapusBrg();
 		}
 		if(ae.getSource()==btnUbah){
 			ubahBrg();
 		}
 		if(ae.getSource()==btnBersih){
 			bersihBrg();
 		}
 		if(ae.getSource()==txtkd_brg){
 			if (txtkd_brg.getText().equals("")){
 				JOptionPane.showMessageDialog (null, "Harap Masukan Kode Barang!");
 			}else{
 				cariBrg();
 			}
 			
 		}
 	}
 	void tampil(){
		try{
			int row = tabelBrg.getSelectedRow();
			txtkd_brg.setText(tabMode.getValueAt(row,1).toString());
			cariBrg();
		}
		catch(Exception e){
		}
	} 	
	
 	
 	void cariBrg(){
 		try{
	   		Koneksi ObjKoneksi = new Koneksi();
	   		Connection con = ObjKoneksi.bukaKoneksi();
	   		Statement st = con.createStatement();
			String sql = "select * from Barang where kdbrg='"+txtkd_brg.getText()+"'" ;
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				 		
				txtnm_brg.setText(rs.getString("nmbrg"));
				txtsatuan.setText(rs.getString("satuan"));
				txtstok.setText(rs.getString("stock"));
				txthargasatuan.setText(rs.getString("harsat"));
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
 	
 		void bersihBrg(){
 			txtkd_brg.setText("");
 			txtnm_brg.setText("");
 			txtsatuan.setText("");
 			txtstok.setText("");
 			txthargasatuan.setText("");
 			
 			btnTambah.setEnabled(false);
 			btnUbah.setEnabled(false);
 			btnHapus.setEnabled(false);
 			
 			tampilketabel();
 		}
 		
 		
 	 	void hapusBrg(){
 		try {
 			Koneksi ObjKoneksi = new Koneksi ();
 			Connection con = ObjKoneksi.bukaKoneksi();
 				Statement st = con.createStatement();
			String sql = "delete from Barang where kdbrg='" + txtkd_brg.getText()+"'"; 
			int vHasil = st.executeUpdate(sql);
			if (vHasil >0){
				JOptionPane.showMessageDialog (null, "DATA BERHASIL DIHAPUS");
			}
 	  		con.close();
 	  		bersihBrg();
 		}
 		catch(Exception e){
 		}
 	}
 	
 	
 	void ubahBrg(){
 		try {
 			Koneksi ObjKoneksi = new Koneksi ();
 			Connection con = ObjKoneksi.bukaKoneksi();
 				Statement st = con.createStatement();
			String sql = "update Barang set nmbrg='"+ 
			txtnm_brg.getText()+"',satuan='"+
			txtsatuan.getText()+"',stock='"+
			txtstok.getText()+"',harsat='"+
			txthargasatuan.getText()+"' where kdbrg='" + txtkd_brg.getText()+"'";
			int vHasil = st.executeUpdate(sql);
			if (vHasil >0){
				JOptionPane.showMessageDialog (null, "Data Sudah DiUbah");
			}
 	  		con.close();
			bersihBrg();
 		}
 		catch(Exception e){
 		}
 	}
 	
 	
 	void tambahBrg(){
 		try {
 			Koneksi ObjKoneksi = new Koneksi ();
 			Connection con = ObjKoneksi.bukaKoneksi();
 				Statement st = con.createStatement();
			String sql = "insert into Barang values ('"+ 
			txtkd_brg.getText()+"','"+
			txtnm_brg.getText()+"','"+
			txtsatuan.getText()+"','"+
			txtstok.getText()+"','"+
			txthargasatuan.getText()+"')";
			int vHasil = st.executeUpdate(sql);
			if (vHasil >0){
				JOptionPane.showMessageDialog (null, "DATA BERHASIL DI TAMBAHKAN");
			}
 	  		con.close();
 	  		
 	  		bersihBrg();
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
			String sql = "select * from Barang" ;
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				 		
				String vkd_brg = rs.getString("kdbrg");
				String vNamaBarang = rs.getString("nmbrg");
				String vSatuan = rs.getString("satuan");
				String vStock = rs.getString("stock");
				String vHargaSatuan = rs.getString("harsat");
				String[] data = {"",vkd_brg,vNamaBarang,vSatuan,vStock,vHargaSatuan};
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
 		new Master_data_Barang();
 	}
 }