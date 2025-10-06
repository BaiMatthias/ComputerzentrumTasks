package allesBunt;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class BunteForm extends JPanel{
	
	public BunteForm() {
		
	}
	
	@Override 
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.setColor(Color.RED);
        g.fillRect(50, 50, 120, 60);

        
        g.setColor(Color.BLUE);
        g.fillOval(200, 50, 60, 40);

        
        g.setColor(Color.BLACK);
        g.drawLine(50, 150, 300, 150);
		
	}
	

}
