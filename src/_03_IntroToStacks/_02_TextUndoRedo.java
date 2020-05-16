package _03_IntroToStacks;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	Stack <Character> stackI = new Stack <Character>();
	String text = "";
	
	public static void main(String[] args) {
		_02_TextUndoRedo program = new _02_TextUndoRedo();
		program.start();
	}
	
	void start() {
		frame.add(panel);
		panel.add(label);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
		label.setText(text);
		frame.setPreferredSize(new Dimension(1000, 600));
		frame.pack();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	} 

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			stackI.push(text.charAt(text.length() - 1));
			text = text.substring(0, text.length() - 1);
			label.setText(text);
		}else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (stackI.isEmpty() == false) {
				text = text + stackI.pop();
				label.setText(text);
			}
		}else {
			label.setText(text + e.getKeyChar());
			text = label.getText();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}
