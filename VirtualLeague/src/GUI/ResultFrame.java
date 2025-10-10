package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import java.awt.Scrollbar;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
/**
 * Represents a Window for displaying tournament results
 */
public class ResultFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextArea txtResult;
	private JScrollPane scrollPane;

	

	/**
	 * Creates the frame with a textarea and a scrollbar attached to it
	 */
	public ResultFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Tournament Results");
		setBounds(100, 100, 450, 300);
		
		this.txtResult = new JTextArea();
		this.txtResult.setEditable(false);
		this.txtResult.setLineWrap(true);
		this.txtResult.setWrapStyleWord(true);
		
		
		this.scrollPane = new JScrollPane(this.txtResult);
		
		getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        loadFileContent();
	
	}
	/**
	 * Loads the tournament results from a file and displays it in the text area component
	 */
	private void loadFileContent() {
        try {
        	System.out.println("LoadFileContent");
            String content = Files.readString(Paths.get("tournament_results.txt"));
            this.txtResult.setText(content);
            this.txtResult.setCaretPosition(0); 
        } catch (IOException e) {
            this.txtResult.setText("Error reading tournament results: " + e.getMessage());
            
        }
    }

}
