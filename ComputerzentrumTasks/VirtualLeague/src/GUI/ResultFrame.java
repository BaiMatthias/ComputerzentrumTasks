package GUI;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JScrollPane;
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
