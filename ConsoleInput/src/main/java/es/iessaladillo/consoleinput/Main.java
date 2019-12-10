package es.iessaladillo.consoleinput;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		ConsoleInput miConsoleInput = new ConsoleInput(keyboard);
		System.out.println(miConsoleInput.readLongInRangeInclusive(5, 10));

	}

}
