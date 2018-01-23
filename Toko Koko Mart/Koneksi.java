 /*
-----------------------------------------------------
	Nama Program 	: Koneksi.java
	Dipanggil Oleh	: Semua program yang terhubung database
	Keterangan 		: Program koneksi database dengan Ms. Access
	Dibuat Oleh		: AEndF@2008, Versi Update
-----------------------------------------------------
*/

import java.sql.*;

public class Koneksi {
  	public Koneksi()  {
  	}
  	
	public Connection bukaKoneksi() throws SQLException  {
        Connection con = null;
     	try {
		    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      	    con=DriverManager.getConnection("jdbc:odbc:dbnya","","");
		    return con;
		}
    	catch (SQLException se) {
      	    System.out.println("Koneksi Berhasil");
      	    return null;
    	}
        catch (Exception ex) {
      	   System.out.println("Ngga Connect Bro");
      	   return null;
    	}
  	}
}