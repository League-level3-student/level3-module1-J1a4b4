package _01_IntroToArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		//   Don't forget to import the ArrayList class
		ArrayList <String> strings = new ArrayList();
		//2. Add five Strings to your list
		strings.add("One");
		strings.add("Two");
		strings.add("Three");
		strings.add("Four");
		strings.add("Five");
		//3. Print all the Strings using a standard for-loop
		for (int i = 0; i < strings.size(); i++) {
			System.out.println(strings.get(i));
		}
		System.out.println("");
		//4. Print all the Strings using a for-each loop
		for (String string : strings) {
			System.out.println(string);
		}
		System.out.println("");
		//5. Print only the even numbered elements in the list.
		for (int i = 0; i < strings.size(); i++) {
			if (i % 2 == 1) {
				System.out.println(strings.get(i));
			}
		}
		System.out.println("");
		//6. Print all the Strings in reverse order.
		for (int i = strings.size() - 1; i >= 0; i--) {
			System.out.println(strings.get(i));
		}
		System.out.println("");
		//7. Print only the Strings that have the letter 'e' in them.
		for (int i = 0; i < strings.size(); i++) {
			if (strings.get(i).contains("e")) {
				System.out.println(strings.get(i));
			}
		}
	}
}
