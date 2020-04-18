package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addName = new JButton();
	JButton viewNames = new JButton();
	ArrayList <String> names = new ArrayList();
	int guestNumber = 4;
	
	public static void main(String[] args) {
		_02_GuestBook guestBook = new _02_GuestBook();
		guestBook.run();
	}
	void run() {
		frame.add(panel);
		panel.add(addName);
		panel.add(viewNames);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addName.setText("Add Name");
		viewNames.setText("View Names");
		names.add("Guest #1: Bob Banders");
		names.add("Guest #2: Sandy Summers");
		names.add("Guest #3: Greg Ganders");
		names.add("Guest #4: Donny Doners");
		addName.addActionListener(this);
		viewNames.addActionListener(this);
		frame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(addName)) {
			String entry = JOptionPane.showInputDialog(null, "Enter the name you wish to add.");
			guestNumber = guestNumber + 1;
			names.add("Guest #" + guestNumber + ": " + entry);
		}else if (e.getSource().equals(viewNames)) {
			String list = "";
			for (int i = 0; i < names.size(); i++) {
				list += names.get(i);
				list += " ";
			}
			JOptionPane.showMessageDialog(null, list);
		}
	}
}
