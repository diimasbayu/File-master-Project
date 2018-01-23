import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.util.Locale;



public class mnuLapPengiriman extends JFrame implements ActionListener{
	
	
	JLabel lblJudul = new JLabel("Cetak Laporan Pengiriman");
 	JLabel lblNosj = new JLabel ("Nomor SJ");
 	JTextField txtNosj = new JTextField (10);

	
	String[] strJdl = {"Nomor","Nomor SJ","Nomor Nota","Nomor Polisi","Jenis Kendaraan"};
	DefaultTableModel tabMode;
	JTable tbllappengiriman = new JTable();
	JScrollPane skrtbllappengiriman = new JScrollPane();

	
	JButton btnCetak = new JButton("Cetak");
	
	public mnuLapPengiriman(){
 		setSize(600,430);
 		setVisible(true);
 		setLocationRelativeTo(this);
 		setTitle("Laporan Pengiriman");
 		
 		
		lblJudul.setBounds(60,10,500,30);
		lblJudul.setFont(new Font("verdana", Font.BOLD,30));
		
		lblNosj.setBounds(20,80,100,25);
		txtNosj.setBounds(100,80,100,25);



		tabMode = new DefaultTableModel(null,strJdl);
		tbllappengiriman.setModel(tabMode);
		skrtbllappengiriman.getViewport().add(tbllappengiriman);
		tbllappengiriman.setEnabled(true);
		skrtbllappengiriman.setBounds (10, 140, 560, 200);
		
		btnCetak.setBounds(470,350,100,25);

 	
		getContentPane().setLayout(null);
 		getContentPane().add(lblJudul);
 		getContentPane().add(lblNosj);
 		getContentPane().add(txtNosj); 
 		getContentPane().add(btnCetak); 	
 		getContentPane().add(skrtbllappengiriman);
 		txtNosj.addActionListener(this);
 		btnCetak.addActionListener(this);
 		nonaktif();
 	}
 	
 	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==txtNosj){
			carisj();
		}
	if (ae.getSource()==btnCetak) {
			cetak();
		}
	
	}
	

	void cetak() {
		JOptionPane.showMessageDialog(null, "Laporan Sudah Tercetak");
			nonaktif();	
		}
	
 	void carisj(){
		try{
	   		Koneksi ObjKoneksi = new Koneksi();  
	   		Connection con = ObjKoneksi.bukaKoneksi();  
	   		Statement st = con.createStatement();  
			String sql ="select * from Surat_Jalan where no_sj='"+txtNosj.getText()+"'" ;
			ResultSet rs = st.executeQuery(sql); //
			if(rs.next()){
 			tampilketabel();
 			btnCetak.setEnabled(true);
			}
			else{
				JOptionPane.showMessageDialog(null,"Tidak Ada Surat Jalan");
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
	
	
	void nonaktif(){
		btnCetak.setEnabled(false);
		hapusTabel();
		txtNosj.setText("");
		

	}
	
	
 	public static void main (String []args){
 		new mnuLapPengiriman();
 	}
 }