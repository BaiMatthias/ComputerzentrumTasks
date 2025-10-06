package allesBunt;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		JFrame f = new JFrame();

		f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		f.setTitle("Aufgabe 2");
		f.setSize(350, 300);
		
		f.setLayout(new GridLayout());
		
		f.add(new BunteForm());
		
		f.setVisible(true);
	}

}
