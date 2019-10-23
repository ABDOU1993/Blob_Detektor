// Übung - Bildverarbeitung - Blob Detektor
// Gruppe : SALHAOUI Abdelmonaim & BEN ZAHIR Bouchra

package blob;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Test {

	public static void main(String s[]) throws IOException {
		
		JFrame f = new JFrame("Blob Detector");
		JFrame result = new JFrame("Result");
		
		HesseMatrix hesse = new HesseMatrix();
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		// input image
		BufferedImage image = ImageIO.read(new File("src/blob/nasa_a.jpg"));
		JButton b1 = new JButton("apply");
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				try {
					BufferedImage img = hesse.changePixelColor(image);
					result.getContentPane().add(new JLabel(new ImageIcon(img)));		
					result.pack();
					result.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			};
		});
		
		f.getContentPane().add(new JLabel(new ImageIcon(image)));
		f.getContentPane().add("South",b1);
		f.pack();
		f.setVisible(true);
		
		
	}
}
