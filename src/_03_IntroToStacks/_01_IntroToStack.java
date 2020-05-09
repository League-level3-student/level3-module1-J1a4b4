package _03_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
	public static void main(String[] args) {
		//1. Create a Stack of Doubles
		//   Don't forget to import the Stack class
		Stack<Double> stackI = new Stack<Double>();
		//2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		Random random = new Random();
		Double x;
		for (int i = 0; i < 100; i++) {
			x = random.nextDouble() * 100;
			stackI.push(x);
		}
		//3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
		String stringI = JOptionPane.showInputDialog(null, "Please enter a number between 0 and 100, inclusive.");
		String stringII = JOptionPane.showInputDialog(null, "Please enter another number between 0 and 100, inclusive.");
		Double boundI = Double.parseDouble(stringI);
		Double boundII = Double.parseDouble(stringII);
		//4. Pop all the elements off of the Stack. Every time a double is popped that is
		//   between the two numbers entered by the user, print it to the screen.
		Double d;
		if (stackI.isEmpty() == false) {
			d = stackI.pop();
			if (boundI > boundII) {
				if (d < boundI && d > boundII) {
					System.out.println(d);
				}
			}else if (boundI < boundII) {
				if (d > boundI && d < boundII) {
					System.out.println(d);
				}
			}else if (boundI == boundII) {
				if (d == boundI) {
					System.out.println(d);
				}
			}
		}
		
		//   EXAMPLE:
		//   NUM 1: 65
		//   NUM 2: 75
		
		//   Popping elements off stack...
		//   Elements between 65 and 75:
		//   66.66876846
		//   74.51651681
		//   70.05110654
		//   69.21350456
		//   71.54506465
		//   66.47984807
		//   74.12121224
	}
}
