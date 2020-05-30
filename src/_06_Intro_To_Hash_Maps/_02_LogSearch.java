package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	JFrame frame;
	JPanel panel;
	JButton buttonI;
	JButton buttonII;
	JButton buttonIII;
	JButton buttonIV;
	HashMap <Integer, String> log = new HashMap();
	
	void start() {
		frame = new JFrame();
		panel = new JPanel();
		buttonI = new JButton();
		buttonII = new JButton();
		buttonIII = new JButton();
		frame.add(panel);
		panel.add(buttonI);
		panel.add(buttonII);
		panel.add(buttonIII);
		buttonI.setText("Add Entry");
		buttonII.setText("Search by ID");
		buttonIII.setText("View List");
		buttonI.addActionListener(this);
		buttonII.addActionListener(this);
		buttonIII.addActionListener(this);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(buttonI)) {
			String inputI = JOptionPane.showInputDialog(null, "Please enter an ID number.");
			String inputII = JOptionPane.showInputDialog(null, "Please enter the name corresponding to the ID.");
			log.put(Integer.parseInt(inputI), inputII);
		}else if (e.getSource().equals(buttonII)) {
			
		}
	}
}
