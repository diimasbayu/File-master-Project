import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class Splash extends JWindow {
	private Dimension 		dimensi		= Toolkit.getDefaultToolkit().getScreenSize();
	private JLabel 			lblLogo		= new JLabel(new ImageIcon ("Gambar/Gambar.jpg"));
	private JProgressBar 	barisProgres= new JProgressBar();

	private int 			time 		= 0;
	private Timer 			timer;

	public Splash () {
 		Color Warna = Color.blue;

		barisProgres.setValue(0);
		barisProgres.setPreferredSize(new Dimension(100,15));
		barisProgres.setBackground(Color.yellow);
		barisProgres.setForeground(Color.blue);
		barisProgres.setStringPainted(true);
		barisProgres.setBorder(new LineBorder (Warna, 1));
		lblLogo.setBorder (new LineBorder (Warna, 1));
		
		getContentPane().add(lblLogo, BorderLayout.NORTH);
		getContentPane().add(barisProgres,BorderLayout.CENTER);
		
		timer=new Timer(100,new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				time++;
				barisProgres.setValue(time);
				if(barisProgres.getPercentComplete()==1.0){
					timer.stop();
					setVisible(false);
					new Form_Utama();
				}	
			}
		});
		timer.start();
		
		pack();
		setLocation (dimensi.width / 2 - getWidth() / 2, dimensi.height / 2 - getHeight() / 2);	
		show();
	}

	public static void main (String args[]) { 
		new Splash (); 
	}
}