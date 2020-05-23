package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener{
	
	JFrame frame;
	JPanel panel;
	JLabel label;
	Stack <String> stackI;
	String wordInPlay;
	String text = "";
	int lives;
	Utilities utility = new Utilities();
	
	public HangMan(Utilities utility) {
		this.utility = utility;
	}

	public static void main(String[] args) {
		Utilities utility = new Utilities();
		HangMan hM = new HangMan(utility);
		hM.startGame(utility);
	}
	
	void startGame(Utilities u) {
		String input = JOptionPane.showInputDialog(null, "Please enter a number between 1 and 266, inclusive.");
		stackI = new Stack <String>();
		String word = "";
		while (stackI.size() < Integer.parseInt(input)) {
			word = u.readRandomLineFromFile("dictionary.txt");
			if (stackI.contains(word) == false) {
				stackI.push(word);
			}
		}
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		frame.add(panel);
		panel.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.addKeyListener(this);
		newWord(stackI);
		frame.pack();
	}

	void newWord(Stack <String> stack) {
		wordInPlay = stack.pop();
		text = "";
		for(int i = 0; i < wordInPlay.length(); i++) {
			text += "_";
		}
		label.setText(text);
		lives = 10;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		for (int i = 0; i < wordInPlay.length(); i++) {
			if (e.getKeyChar() == wordInPlay.charAt(i)) {
				text = text.substring(0, i) + e.getKeyChar() + text.substring(i + 1, text.length());
				label.setText(text);
			}else {
				lives = lives - 1;
			}
		}
		if (!text.contains("_")) {
			if (stackI.isEmpty() == true) {
				String choice = JOptionPane.showInputDialog(null, "You win!  Play again? (y/n)");
				if (choice.equals("y")) {
					startGame(utility);
				}else {
					System.exit(0);
				}
			}else {
				newWord(stackI);
			}	
		}
		if (lives == 0) {
			String choice = JOptionPane.showInputDialog(null, "Game over.  Play again? (y/n)");
			if (choice.equals("y")) {
				startGame(utility);
			}else {
				System.exit(0);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
