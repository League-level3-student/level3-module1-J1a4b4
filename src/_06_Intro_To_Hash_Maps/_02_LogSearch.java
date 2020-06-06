package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Stack;

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
	JButton buttonV;
	HashMap <Integer, String> log = new HashMap();
	HashMap <Integer, String> auditLog = new HashMap();
	Stack<Integer> keyRing = new Stack();
	int auditIndex = 1;
	
	public static void main(String[] args) {
		_02_LogSearch logSearch = new _02_LogSearch();
		logSearch.start();
	}
	
	void start() {
		frame = new JFrame();
		panel = new JPanel();
		buttonI = new JButton();
		buttonII = new JButton();
		buttonIII = new JButton();
		buttonIV = new JButton();
		buttonV = new JButton();
		frame.add(panel);
		panel.add(buttonI);
		panel.add(buttonII);
		panel.add(buttonIII);
		panel.add(buttonIV);
		panel.add(buttonV);
		buttonI.setText("Add Entry");
		buttonII.setText("Search by ID");
		buttonIII.setText("View List");
		buttonIV.setText("Remove Entry");
		buttonV.setText("Audit");
		buttonI.addActionListener(this);
		buttonII.addActionListener(this);
		buttonIII.addActionListener(this);
		buttonIV.addActionListener(this);
		buttonV.addActionListener(this);
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
			keyRing.push(Integer.parseInt(inputI));
			JOptionPane.showMessageDialog(null, "Entry recorded.");
			auditLog.put(auditIndex, "Type: Addition ID: " + Integer.parseInt(inputI) + " Entry : " + inputII);
			auditIndex ++;
		}else if (e.getSource().equals(buttonII)) {
			String input = JOptionPane.showInputDialog(null, "Please enter the search ID.");
			if (log.containsKey(Integer.parseInt(input))) {
				JOptionPane.showMessageDialog(null, "Log entry for ID " + input + ": " + log.get(Integer.parseInt(input)));
				auditLog.put(auditIndex, "Type: Search ID: " + Integer.parseInt(input) + " Success: Y");
			}else {
				JOptionPane.showMessageDialog(null, "This entry does not exist.");
				auditLog.put(auditIndex, "Type: Search ID: " + Integer.parseInt(input) + " Success: N");
			}
			auditIndex ++;
		}else if (e.getSource().equals(buttonIII)) {
			String list = "";
			Stack<Integer> transition = new Stack();
			int currentID = 0;
			for (int i = 0; i < log.size(); i++) {
				currentID = keyRing.pop();
				list = list + "ID: " + currentID + " Name: " + log.get(currentID) + "  ";
				transition.push(currentID);
			}
			for (int i = 0; i < transition.size(); i++) {
				keyRing.push(transition.pop());
			}
			JOptionPane.showMessageDialog(null, list);
			auditLog.put(auditIndex, "Type: List");
			auditIndex ++;
		}else if (e.getSource().equals(buttonIV)) {
			String input = JOptionPane.showInputDialog(null, "Please enter the ID of the entry you wish to remove.");
			if (log.containsKey(Integer.parseInt(input))) {
				auditLog.put(auditIndex, "Type: Addition ID: " + Integer.parseInt(input) + " Entry : " + log.get(input) + " Success: Y");
				log.remove(input);
				JOptionPane.showMessageDialog(null, "Entry Removed");
			}else {
				JOptionPane.showMessageDialog(null, "The entry you are attempting to remove does not exist.");
				auditLog.put(auditIndex, "Type: Addition ID: " + Integer.parseInt(input) + " Entry : " + log.get(input) + " Success: N");
			}
			auditIndex ++;
		}else if (e.getSource().equals(buttonV)) {
			for (int i = 0; i < auditLog.size(); i++) {
				String listI = "";
				listI = listI + "ID: " + i + " Name: " + auditLog.get(i) + "  ";
			}
		}
	}
}
