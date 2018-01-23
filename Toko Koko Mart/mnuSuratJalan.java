import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.event.*;

 public class mnuSuratJalan extends JFrame implements ActionListener{
 	
 	JLabel lblJudul = new JLabel ("ENTRY SURAT JALAN");
 	
 	JLabel lblno_sj = new JLabel ("No. SJ");
 	JLabel lbltglsj = new JLabel ("Tanggal SJ");
 	
 	JLabel lblno_nota = new JLabel ("No. Nota");
 	JLabel lbltglnota = new JLabel ("Tanggal Nota");
 	JLabel lblnopol = new JLabel ("No. Polisi");
 	JLabel lbljeniskendaraan = new JLabel ("Jenis Kendaraan");
 	
 	JTextField txtNosj = new JTextField (10);
 	JTextField txtTanggalsj = new JTextField (10);
 	
 	JTextField txtnonota = new JTextField (10);
 	JTextField txtTanggalnota = new JTextField (10);
 	JTextField txtnopol = new JTextField (10);
 	JTextField txtjeniskendaraan = new JTextField (10);
 	
 	JButton cmdHapus = new JButton ("Hapus");
 	JButton cmdTambah = new JButton ("Tambah");
 	JButton cmdBersih = new JButton ("Bersih");
 	
 	String[] strJdl = {"Nomor","Nomor SJ","Nomor Nota","Nomor Polisi","Jenis Kendaraan"};
	DefaultTableModel tabMode;
	JTable tabelsuratjalan = new JTable();
	JScrollPane sptabelsuratjalan = new JScrollPane();
 	
 	public mnuSuratJalan(){
 		setSize(600,500);
 		setVisible(true);
 		setLocationRelativeTo(this);
 		setTitle("Nota");
 		
 	lblJudul.setBounds(110,10,500,30);
 	lblJudul.setFont(new Font("verdana", Font.BOLD,30));
 
 	lblno_sj.setBounds(20,60,100,25);
 	lbltglsj.setBounds(20,90,100,25);
	
	
	lblno_nota.setBounds(350,60,100,25);
	lbltglnota.setBounds(350,90,100,25); 
	lblnopol.setBounds(350,120,120,25);
	lbljeniskendaraan.setBounds(350,150,100,25);
	
	txtNosj.setBounds(130,60,100,25);
 	txtTanggalsj.setBounds(130,90,100,25);
 	
	txtnonota.setBounds(460,60,100,25);
	txtTanggalnota.setBounds(460,90,100,25);
	txtnopol.setBounds(460,120,100,25);
	txtjeniskendaraan.setBounds(460,150,100,25);
	
	tabMode = new DefaultTableModel(null,strJdl);
	tabelsuratjalan.setModel(tabMode);
	sptabelsuratjalan.getViewport().add(tabelsuratjalan);
	tabelsuratjalan.setEnabled(true);
	sptabelsuratjalan.setBounds (10, 240, 560, 200);
		
	cmdHapus.setBounds(120,160,90,25);
	cmdTambah.setBounds(20,160,90,25);
	cmdBersih.setBounds(220,160,90,25);
	
	
	
	getContentPane().setLayout(null);
 	getContentPane().add(lblJudul);
 	
 	getContentPane().add(lblno_sj);
 	getContentPane().add(lbltglsj);
 	getContentPane().add(txtNosj);
 	getContentPane().add(txtTanggalsj);
 	
 	getContentPane().add(lblno_nota);
	getContentPane().add(lbltglnota);
	getContentPane().add(lblnopol);
	getContentPane().add(lbljeniskendaraan);
	getContentPane().add(txtnonota);
	getContentPane().add(txtTanggalnota);
	getContentPane().add(txtnopol);
	getContentPane().add(txtjeniskendaraan);	

 	
	getContentPane().add(cmdHapus);
	getContentPane().add(cmdTambah);
	getContentPane().add(cmdBersih);
	
	nonaktif();
	getContentPane().add(sptabelsuratjalan);
	txtNosj.addActionListener(this);
	cmdBersih.addActionListener(this);
	cmdTambah.addActionListener(this);
	txtnonota.addActionListener(this);
	txtnopol.addActionListener(this);
	cmdHapus.addActionListener(this);
	
	
	
 	}
 	
 	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==txtNosj){
			carisj();
		}
		if(ae.getSource()==txtnonota){
			carinota();
		}
		if(ae.getSource()==txtnopol){
			carikendaraan();
		}
		if(ae.getSource()==cmdTambah){
			tambahsj();
		}
		if(ae.getSource()==cmdHapus){
			hapussj();
		}
		if(ae.getSource()==cmdBersih){
			nonaktif();
		}
	}
 	
 	void carisj(){
		try{
	   		Koneksi ObjKoneksi = new Koneksi();  
	   		Connection con = ObjKoneksi.bukaKoneksi();  
	   		Statement st = con.createStatement();  
			String sql ="select Surat_Jalan.no_sj, Surat_Jalan.tgl_sj, Surat_Jalan.no_nota, Surat_Jalan.nopolisi, nota.tgl_nota, Kendaraan.jeniskendaraan "+
						" from Surat_Jalan, nota , Kendaraan where no_sj='"+txtNosj.getText()+"' and Surat_Jalan.no_nota=nota.no_nota "+
						" and Surat_Jalan.nopolisi=Kendaraan.nopolisi" ;
			ResultSet rs = st.executeQuery(sql); //
			if(rs.next()){
				txtTanggalsj.setText(rs.getString("tgl_sj").substring(0,10));
				txtnonota.setText(rs.getString("no_nota"));
				txtTanggalnota.setText(rs.getString("tgl_nota").substring(0,10));
				txtnopol.setText(rs.getString("nopolisi"));
				txtjeniskendaraan.setText(rs.getString("jeniskendaraan"));
				txtTanggalsj.setEditable(false);
	   			txtnonota.setEditable(false);
	   			txtnopol.setEditable(false);
				cmdHapus.setEnabled(true);
				cmdTambah.setEnabled(false);
				tampilketabel();
			}
			else{
				JOptionPane.showMessageDialog(null,"Tidak Ada Surat Jalan");
	   			cmdTambah.setEnabled(true);
	   			cmdHapus.setEnabled(false);
	   			txtTanggalsj.setEditable(true);
	   			txtnonota.setEditable(true);
	   			txtnopol.setEditable(true);
	   			txtTanggalsj.setText("");
				txtnonota.setText("");
				txtTanggalnota.setText("");
				txtnopol.setText("");
				txtjeniskendaraan.setText("");
				hapusTabel();

			}
			
	   		rs.close();
 	  		con.close();
		}
		catch(Exception e){
		}
	}
	
		void carinota(){
		try{
	   		Koneksi ObjKoneksi = new Koneksi();  
	   		Connection con = ObjKoneksi.bukaKoneksi();  
	   		Statement st = con.createStatement();  
			String sql = "select tgl_nota from nota where no_nota= '"+
						 txtnonota.getText()+"'" ;
			ResultSet rs = st.executeQuery(sql); //
			if(rs.next()){
				txtTanggalnota.setText(rs.getString("tgl_nota").substring(0,10));
			}
			else{
				JOptionPane.showMessageDialog(null,"Tidak Ada Nota yang Dibuat");
				txtTanggalnota.setText("");
			}
	   		rs.close();
 	  		con.close();
		}
		catch(Exception e){
		}
	}
	
	
	void carikendaraan(){
		try{
	   		Koneksi ObjKoneksi = new Koneksi();  
	   		Connection con = ObjKoneksi.bukaKoneksi();  
	   		Statement st = con.createStatement();  
			String sql = "select jeniskendaraan from Kendaraan where nopolisi= '"+
						 txtnopol.getText()+"'" ;
			ResultSet rs = st.executeQuery(sql); //
			if(rs.next()){
				txtjeniskendaraan.setText(rs.getString("jeniskendaraan"));
			}
			else{
				JOptionPane.showMessageDialog(null,"Kendaraan Tidak Terdaftar");
				txtjeniskendaraan.setText("");
			}
	   		rs.close();
 	  		con.close();
		}
		catch(Exception e){
		}
	}
	
	void tambahsj(){
		try{
	   		Koneksi ObjKoneksi = new Koneksi(); //1
	   		Connection con = ObjKoneksi.bukaKoneksi(); //2
	   		Statement st = con.createStatement(); //3
			String sql = "insert into Surat_Jalan values('"+
				txtNosj.getText()+"','"+
				txtTanggalsj.getText()+"','"+
				txtnonota.getText()+"','"+
				txtnopol.getText()+"')" ;
			int vHasil = st.executeUpdate(sql); //
			if (vHasil>0){
				JOptionPane.showMessageDialog(null, "Surat Jalan Sudah dibuat");
			}
 	  		con.close();
 	  		tampilketabel();
		}
		catch(Exception e){
		}
	}	
	
	
	
	void hapussj(){
 		try {
 			Koneksi ObjKoneksi = new Koneksi ();
 			Connection con = ObjKoneksi.bukaKoneksi();
 				Statement st = con.createStatement();
			String sql = "delete from Surat_Jalan where no_sj='"+txtNosj.getText()+"'"; 
			int vHasil = st.executeUpdate(sql);
			if (vHasil >0){
				JOptionPane.showMessageDialog (null, "Surat Jalan Berhasil dihapus");
			}
 	  		con.close();
 	  		nonaktif();
 	  		tampilketabel();
 		}
 		catch(Exception e){
 		}
 	}
	
	void nonaktif(){
		txtNosj.setText("");
		txtTanggalsj.setText("");
		txtTanggalsj.setEditable(false);
		txtnonota.setText("");
		txtnonota.setEditable(false);
		txtTanggalnota.setText("");
		txtTanggalnota.setEditable(false);
		txtnopol.setText("");
		txtnopol.setEditable(false);
		txtjeniskendaraan.setText("");
		txtjeniskendaraan.setEditable(false);
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
			String sql ="select Surat_Jalan.no_sj, Surat_Jalan.no_nota, Surat_Jalan.nopolisi, Kendaraan.jeniskendaraan "+
						"  from Surat_Jalan, Kendaraan where no_sj='"+txtNosj.getText()+"' and Surat_Jalan.nopolisi=Kendaraan.nopolisi";
			ResultSet rs = st.executeQuery(sql); //
			while(rs.next()){
				String vno_sj	= rs.getString("no_sj");
				String vno_nota	= rs.getString("no_nota");
				String vnopolisi	= rs.getString("nopolisi");
				String vjeniskendaraan= rs.getString("jeniskendaraan");

				String[] data 	= {"",vno_sj,vno_nota,vnopolisi,vjeniskendaraan};
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
 		new mnuSuratJalan();
 	}
 }