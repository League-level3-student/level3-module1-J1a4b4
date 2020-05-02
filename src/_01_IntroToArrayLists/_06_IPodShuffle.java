package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener{
	Song song1 = new Song("Song1.mp3");
	Song song2 = new Song("Song2.mp3");
	Song song3 = new Song("Song3.mp3");
	Song song4 = new Song("Song4.mp3");
	Song song5 = new Song("Song5.mp3");
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
		//Done.
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton button = new JButton();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.add(button);
		button.setText("Surprise Me!");
		button.addActionListener(this);
		frame.pack();
	}
	
	public static void main(String[] args) {
		new _06_IPodShuffle();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Random random = new Random();
		int randNum = random.nextInt(5)+1;
		if (randNum == 1) {
			song2.stop();
			song3.stop();
			song4.stop();
			song5.stop();
			song1.play();
		}else if (randNum == 2) {
			song1.stop();
			song3.stop();
			song4.stop();
			song5.stop();
			song2.play();
		}else if (randNum == 3) {
			song1.stop();
			song2.stop();
			song4.stop();
			song5.stop();
			song3.play();
		}else if (randNum == 4) {
			song1.stop();
			song2.stop();
			song3.stop();
			song5.stop();
			song4.play();
		}else if (randNum == 5) {
			song2.stop();
			song3.stop();
			song4.stop();
			song1.stop();
			song5.play();
		}
	}
}