import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.util.Locale;



public class mnuLapPesan extends JFrame implements ActionListener{
	
	
	JLabel lblJudul = new JLabel("Cetak Laporan Pesanan");
 	JLabel lblNoPesanan = new JLabel ("No Pesanan ");
 	JTextField txtNoPesanan = new JTextField (10);

	
	String[] strJdl = {"Nomor","Nomor Pesanan","Kode Barang","Nama Barang","Kode Pelanggan","Nama Pelanggan","Jumlah Pesan","Harga Pesan"};
	DefaultTableModel tabMode;
	JTable tbllappesan = new JTable();
	JScrollPane skrtbllappesan = new JScrollPane();

	
	JButton btnCetak = new JButton("Cetak");
	
	public mnuLapPesan(){
 		setSize(600,430);
 		setVisible(true);
 		setLocationRelativeTo(this);
 		setTitle("Laporan Pesanan");
 		
 		
		lblJudul.setBounds(120,10,400,30);
		lblJudul.setFont(new Font("verdana", Font.BOLD,30));
		
		lblNoPesanan.setBounds(20,80,100,25);
		txtNoPesanan.setBounds(100,80,100,25);



		tabMode = new DefaultTableModel(null,strJdl);
		tbllappesan.setModel(tabMode);
		skrtbllappesan.getViewport().add(tbllappesan);
		tbllappesan.setEnabled(true);
		skrtbllappesan.setBounds (10, 140, 560, 200);
		
		btnCetak.setBounds(470,350,100,25);

 	
		getContentPane().setLayout(null);
 		getContentPane().add(lblJudul);
 		getContentPane().add(lblNoPesanan);
 		getContentPane().add(txtNoPesanan); 
 		getContentPane().add(btnCetak); 	
 		getContentPane().add(skrtbllappesan);
 		tampilketabel();
 		txtNoPesanan.addActionListener(this);
 		btnCetak.addActionListener(this);
 	}
 	
 	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==txtNoPesanan){
			caripesanan();
		}
	if (ae.getSource()==btnCetak) {
			cetak();
		}
	
	}
	

	void cetak() {
		JOptionPane.showMessageDialog(null, "Laporan Sudah Tercetak");
			nonaktif();	
		}
	
 	void caripesanan(){
		try{
	   		Koneksi ObjKoneksi = new Koneksi();  
	   		Connection con = ObjKoneksi.bukaKoneksi();  
	   		Statement st = con.createStatement();  
			String sql = "select * from Pesanan where nopesanan='"+
						 txtNoPesanan.getText()+"'" ;
			ResultSet rs = st.executeQuery(sql); //
			if(rs.next()){
				JOptionPane.showMessageDialog(null,"Pesanan Terdaftar");
				tampilketabel();
				btnCetak.setEnabled(true);
			}
			else{
				JOptionPane.showMessageDialog(null,"Pesanan Belum Terdaftar, Silahkan isi Pesanan");
				nonaktif();
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
	
	
	void nonaktif(){
		btnCetak.setEnabled(false);
		hapusTabel();
		txtNoPesanan.setText("");
		

	}
	
	
 	public static void main (String []args){
 		new mnuLapPesan();
 	}
 }