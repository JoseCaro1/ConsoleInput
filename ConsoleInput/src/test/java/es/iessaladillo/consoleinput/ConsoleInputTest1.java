package es.iessaladillo.consoleinput;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ConsoleInputTest1 {

	// readChar

	@DisplayName("Should readChar return the character scanned")
	@Test
	void readCharWhenChar() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLine()).thenReturn("A");
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		char character = consoleInput.readChar();

		assertEquals('A', character);
	}

	@DisplayName("Should readChar call nextLine() again after a string of more than one character")
	@Test
	void readCharWhenInvalidString() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLine()).thenReturn("hola", "a");
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		char character = consoleInput.readChar();

		verify(keyboard, times(2)).nextLine();
		assertEquals('a', character);
	}

	@DisplayName("Should readChar call nextLine() again after an empty string")
	@Test
	void readCharWhenEmptyString() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLine()).thenReturn("", "1");
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		char character = consoleInput.readChar();

		verify(keyboard, times(2)).nextLine();
		assertEquals('1', character);
	}

	//readChar(String validCharacters)

	@DisplayName("Should readChar(validCharacter) return the character scanned")
	@Test
	void readCharValidCharacterWhenChar() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLine()).thenReturn("a");
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		char character = consoleInput.readChar("aBcd1");

		assertEquals('a', character);
	}

	@DisplayName("Should readChar(validCharacter) return when the character is out of parameters scanned")
	@Test
	void readCharValidCharacterWhenCharOutOfParameters() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLine()).thenReturn("A").thenReturn("a");
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		char character = consoleInput.readChar("aBcd1");

		verify(keyboard, times(2)).nextLine();
		assertEquals('a', character);
	}

	//readVowel

	@DisplayName("Should readVowel return when the character is not a vowel scanned")
	@Test
	void readVowelWhenCharIsNotVowel() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLine()).thenReturn("c").thenReturn("a");
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		char character = consoleInput.readVowel();

		verify(keyboard, times(2)).nextLine();
		assertEquals('a', character);
	}

	@DisplayName("Should readVowel return when the character is not a vowel scanned")
	@Test
	void readVowelWhenCharIsNotVowel1() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLine()).thenReturn("1").thenReturn("i");
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		char character = consoleInput.readVowel();

		verify(keyboard, times(2)).nextLine();
		assertEquals('i', character);
	}

	@DisplayName("Should  readVowel return when the character is a vowel scanned")
	@Test
	void readVowelWhenCharIsVowel() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLine()).thenReturn("a");
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		char character = consoleInput.readVowel();

		assertEquals('a', character);
	}

	//readDigit

	@DisplayName("Should readDigit return when the character is not a digit scanned")
	@Test
	void readDigitWhenCharIsNotDigit() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLine()).thenReturn("b").thenReturn("9");
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		char character = consoleInput.readDigit();

		verify(keyboard, times(2)).nextLine();
		assertEquals('9', character);
	}

	@DisplayName("Should readDigit return when the character is a digit scanned")
	@Test
	void readDigitWhenCharIsDigit() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLine()).thenReturn("1");
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		char character = consoleInput.readDigit();

		assertEquals('1', character);
	}

	//readLoweCase

	@DisplayName("Should readLowerCase return when the character is lower case scanned")
	@Test
	void readLowerCaseWhenCharIsLowerCase() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLine()).thenReturn("a");
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		char character = consoleInput.readLowerCase();

		assertEquals('a', character);
	}

	@DisplayName("Should readLowerCase return when the character is upper case scanned")
	@Test
	void readLowerCaseWhenCharIsUpperCase() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLine()).thenReturn("A").thenReturn("q");
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		char character = consoleInput.readLowerCase();

		verify(keyboard, times(2)).nextLine();
		assertEquals('q', character);
	}

	@DisplayName("Should readLowerCase return when the character is digit case scanned")
	@Test
	void readLowerCaseWhenCharIsDigit() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLine()).thenReturn("1").thenReturn("q");
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		char character = consoleInput.readLowerCase();

		verify(keyboard, times(2)).nextLine();
		assertEquals('q', character);
	}

	//readUpperCase

	@DisplayName("Should readUpperCase return when the character is lower case scanned")
	@Test
	void readUpperCaseWhenCharIsLowerCase() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLine()).thenReturn("a").thenReturn("C");
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		char character = consoleInput.readUpperCase();

		verify(keyboard, times(2)).nextLine();
		assertEquals('C', character);
	}

	@DisplayName("Should readUpperCase return when the character is upper case scanned")
	@Test
	void readUpperCaseWhenCharIsUpperCase() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLine()).thenReturn("A");
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		char character = consoleInput.readUpperCase();

		assertEquals('A', character);
	}

	@DisplayName("Should readUpperCase return when the character is digit case scanned")
	@Test
	void readUpperCaseWhenCharIsDigit() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLine()).thenReturn("1").thenReturn("B");
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		char character = consoleInput.readUpperCase();

		verify(keyboard, times(2)).nextLine();
		assertEquals('B', character);
	}

	//String
	//readString

	@DisplayName("Should readString return the string scanned")
	@Test
	void readStringWhenString() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLine()).thenReturn("Hola me llamo Jose Alfonso");
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		String str = consoleInput.readString();

		assertEquals("Hola me llamo Jose Alfonso", str);
	}

	//readString(maxLength)

	@DisplayName("Should readString return when the string is upper than maxLength scanned")
	@Test
	void readStringWhenStringIsUpperThanMaxLength() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLine()).thenReturn("Hola me llamo Jose Alfonso").thenReturn("Hola me");
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		String str = consoleInput.readString(7);

		verify(keyboard, times(2)).nextLine();
		assertEquals("Hola me", str);
	}

	@DisplayName("Should readString return when the string is lower than maxLength scanned")
	@Test
	void readStringMaxLengthWhenStringIsLowerThanMaxLength() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLine()).thenReturn("Alfonso");
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		String str = consoleInput.readString(10);

		assertEquals("Alfonso", str);
	}

	@DisplayName("Should readString return when the string is Equal than maxLength scanned")
	@Test
	void readStringMaxLengthWhenStringIsEqualThanMaxLength() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLine()).thenReturn("Hola me llamo Jose Alfonso");
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		String str = consoleInput.readString(26);

		assertEquals("Hola me llamo Jose Alfonso", str);
	}
	//BOOLEAN
	//readBooleanUsingChar(char affirmativeValue)

	@DisplayName("Should readBooleanUsingChar(AffirmativeValue) return when the character is Equal than affirmativeValue scanned")
	@Test
	void readBooleanUsingCharAffirmativeValueWhenCharIsEqualThanAffirmativeValue() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLine()).thenReturn("A");
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		boolean value = consoleInput.readBooleanUsingChar('A');

		assertEquals(true, value);

	}

	@DisplayName("Should readBooleanUsingChar(AffirmativeValue) return when the character is not Equal than affirmativeValue scanned")
	@Test
	void readBooleanUsingCharAffirmativeValueWhenCharIsNotEqualThanAffirmativeValue() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLine()).thenReturn("q");
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		boolean value = consoleInput.readBooleanUsingChar('A');

		assertEquals(false, value);

	}

	//readBooleanUsingChar()

	@DisplayName("Should readBooleanUsingChar return when the character is equal than 's' or 'n' scanned")
	@Test
	void readBooleanUsingCharWhenCharIsEqualThanYesOrNo() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLine()).thenReturn("s");
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		boolean value = consoleInput.readBooleanUsingChar();

		assertEquals(true, value);

	}

	@DisplayName("Should readBooleanUsingChar return when the character is not equal than 's' or 'n' scanned")
	@Test
	void readBooleanUsingCharWhenCharIsNotEqualThanYesOrNo() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLine()).thenReturn("q").thenReturn("n");
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		boolean value = consoleInput.readBooleanUsingChar();

		verify(keyboard, times(2)).nextLine();
		assertEquals(false, value);

	}

	//readBooleanUsingInt(int affirmativeValue)

	@DisplayName("Should readBooleanUsingInt return when the int is Equal than affirmativeValue scanned")
	@Test
	void readBooleanUsingIntAffirmativeValueWhenIntIsEqualThanAffirmativeValue() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextInt()).thenReturn(151);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		boolean value = consoleInput.readBooleanUsingInt(151);

		assertEquals(true, value);

	}

	@DisplayName("Should readBooleanUsingInt(AffirmativeValue) return when the int is not equal than affirmativeValue scanned")
	@Test
	void readBooleanUsingIntAffirmativeValueWhenIntIsNotEqualThanAffirmativeValue() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextInt()).thenReturn(9);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		boolean value = consoleInput.readBooleanUsingInt(151);

		assertEquals(false, value);

	}

	@DisplayName("Should readBooleanUsingInt(AffirmativeValue) return when the int is letter scanned")
	@Test
	void readBooleanUsingIntAffirmativeValueWhenIntIsLetter() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextInt()).thenThrow(new InputMismatchException()).thenReturn(151);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		boolean value = consoleInput.readBooleanUsingInt(151);

		verify(keyboard, times(2)).nextInt();
		assertEquals(true, value);

	}

	//readBooleanUsingInt

	@DisplayName("Should readBooleanUsingInt return when the int is letter scanned")
	@Test
	void readBooleanUsingIntWhenIntIsLetter() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextInt()).thenThrow(new InputMismatchException()).thenReturn(1);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		boolean value = consoleInput.readBooleanUsingInt();

		verify(keyboard, times(2)).nextInt();
		assertEquals(true, value);

	}

	@DisplayName("Should readBooleanUsingInt return when the int is 1 scanned")
	@Test
	void readBooleanUsingIntWhenIntIs1() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextInt()).thenReturn(1);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		boolean value = consoleInput.readBooleanUsingInt();

		assertEquals(true, value);

	}

	@DisplayName("Should readBooleanUsingInt return when the int is an other number scanned")
	@Test
	void readBooleanUsingIntWhenIntIsAnOtherNumber() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextInt()).thenReturn(51);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		boolean value = consoleInput.readBooleanUsingInt();

		assertEquals(false, value);

	}

	// readByte

	@DisplayName("Should readByte return the byte scanned")
	@Test
	void readByteWhenByte() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextByte()).thenReturn((byte) 8);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		byte number = consoleInput.readByte();

		assertEquals(8, number);
	}

	@DisplayName("Should readByte return the byte scanned")
	@Test
	void readByteWhenByte1() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextByte()).thenReturn((byte) 0);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		byte number = consoleInput.readByte();

		assertEquals(0, number);
	}

	@DisplayName("Should readByte call nextByte() again after the user has not entered a number")
	@Test
	void readByteWhenNonByte() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextByte()).thenThrow(new InputMismatchException()).thenReturn((byte) 10);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		byte number = consoleInput.readByte();

		verify(keyboard, times(2)).nextByte();
		assertEquals(10, number);
	}

	//readByteLessThan
	@DisplayName("Should readByteLessThan return the byte when byte is bigger than upperBound")
	@Test
	void readByteLessThanWhenByteIsBiggerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextByte()).thenReturn((byte) 8).thenReturn((byte) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		byte number = consoleInput.readByteLessThan((byte) 7);
		verify(keyboard, times(2)).nextByte();
		assertEquals(6, number);
	}

	@DisplayName("Should readByteLessThan return the byte when byte is lower than upperBound")
	@Test
	void readByteLessThanWhenByteIsLowerThanUpperBound() {//Preguntar mañana
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextByte()).thenReturn((byte) 5);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		byte number = consoleInput.readByteLessThan((byte) 7);

		assertEquals(5, number);
	}

	@DisplayName("Should readByteLessThan return the byte when byte is equal than upperBound")
	@Test
	void readByteLessThanWhenByteIsEqualThanUpperBound() {//Preguntar mañana
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextByte()).thenReturn((byte) 7).thenReturn((byte) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		byte number = consoleInput.readByteLessThan((byte) 7);
		verify(keyboard, times(2)).nextByte();
		assertEquals(6, number);
	}

	//readByteLessThan

	@DisplayName("Should readByteLessOrEqualThan return the byte when byte is equal than upperBound")
	@Test
	void readByteLessOrEqualThanWhenByteIsEqualThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextByte()).thenReturn((byte) 7);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		byte number = consoleInput.readByteLessOrEqualThan((byte) 7);

		assertEquals(7, number);
	}

	@DisplayName("Should readByteLessOrEqualThan return the byte when byte is lower than upperBound")
	@Test
	void readByteLessOrEqualThanWhenByteIsLowerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextByte()).thenReturn((byte) 5);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		byte number = consoleInput.readByteLessOrEqualThan((byte) 7);

		assertEquals(5, number);
	}

	@DisplayName("Should readByteLessOrEqualThan return the byte when byte is bigger than upperBound")
	@Test
	void readByteLessOrEqualThanWhenByteIsBiggerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextByte()).thenReturn((byte) 8).thenReturn((byte) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		byte number = consoleInput.readByteLessOrEqualThan((byte) 7);
		verify(keyboard, times(2)).nextByte();
		assertEquals(6, number);
	}

	//readByteGreaterThan

	@DisplayName("Should readByteGreaterThan return the byte when byte is equal than lowerBound")
	@Test
	void readByteGreaterThanWhenByteIsEqualThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextByte()).thenReturn((byte) 7).thenReturn((byte) 9);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		byte number = consoleInput.readByteGreaterThan((byte) 7);
		verify(keyboard, times(2)).nextByte();
		assertEquals(9, number);
	}

	@DisplayName("Should readByteGreaterThan return the byte when byte is bigger than lowerBound")
	@Test
	void readByteGreaterThanWhenByteIsBiggerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextByte()).thenReturn((byte) 9);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		byte number = consoleInput.readByteGreaterThan((byte) 7);

		assertEquals(9, number);
	}

	@DisplayName("Should readByteGreaterThan return the byte when byte is lower than lowerBound")
	@Test
	void readByteGreaterThanWhenByteIsLowerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextByte()).thenReturn((byte) 6).thenReturn((byte) 9);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		byte number = consoleInput.readByteGreaterThan((byte) 7);

		verify(keyboard, times(2)).nextByte();
		assertEquals(9, number);
	}

	//readByteGreaterOrEqualThan

	@DisplayName("Should readByteGreaterOrEqualThan return the byte when byte is equal than lowerBound")
	@Test
	void readByteGreaterOrEqualThanWhenByteIsEqualThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextByte()).thenReturn((byte) 7);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		byte number = consoleInput.readByteGreaterOrEqualThan((byte) 7);

		assertEquals(7, number);
	}

	@DisplayName("Should readByteGreaterOrEqualThan return the byte when byte is bigger than lowerBound")
	@Test
	void readByteGreaterOrEqualThanWhenByteIsBiggerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextByte()).thenReturn((byte) 9);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		byte number = consoleInput.readByteGreaterOrEqualThan((byte) 7);

		assertEquals(9, number);
	}

	@DisplayName("Should readByteGreaterOrEqualThan return the byte when byte is lower than lowerBound")
	@Test
	void readByteGreaterOrEqualThanWhenByteIsLowerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextByte()).thenReturn((byte) 6).thenReturn((byte) 9);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		byte number = consoleInput.readByteGreaterOrEqualThan((byte) 7);

		verify(keyboard, times(2)).nextByte();
		assertEquals(9, number);
	}

	//readByteInRangeInclusive

	@DisplayName("Should readByteInRangeInclusive return the byte when byte is equal than lowerBound")
	@Test
	void readByteInRangeInclusiveWhenByteIsEqualThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextByte()).thenReturn((byte) 5);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		byte number = consoleInput.readByteInRangeInclusive((byte) 5, (byte) 10);

		assertEquals(5, number);
	}

	@DisplayName("Should readByteInRangeInclusive return the byte when byte is equal than upperBound")
	@Test
	void readByteInRangeInclusiveWhenByteIsEqualThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextByte()).thenReturn((byte) 10);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		byte number = consoleInput.readByteInRangeInclusive((byte) 5, (byte) 10);

		assertEquals(10, number);
	}

	@DisplayName("Should readByteInRangeInclusive return the byte when byte is bigger than lowerBound and lower than upperBound")
	@Test
	void readByteInRangeInclusiveWhenByteIsBiggerThanLowerBoundAndLowerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextByte()).thenReturn((byte) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		byte number = consoleInput.readByteInRangeInclusive((byte) 5, (byte) 10);

		assertEquals(6, number);
	}

	@DisplayName("Should readByteInRangeInclusive return the byte when byte is lower than lowerBound")
	@Test
	void readByteInRangeInclusiveWhenByteIsLowerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextByte()).thenReturn((byte) 4).thenReturn((byte) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		byte number = consoleInput.readByteInRangeInclusive((byte) 5, (byte) 10);

		verify(keyboard, times(2)).nextByte();
		assertEquals(6, number);
	}

	@DisplayName("Should readByteInRangeInclusive return the byte when byte is bigger than upperBound")
	@Test
	void readByteInRangeInclusiveWhenByteIsBiggerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextByte()).thenReturn((byte) 11).thenReturn((byte) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		byte number = consoleInput.readByteInRangeInclusive((byte) 5, (byte) 10);

		verify(keyboard, times(2)).nextByte();
		assertEquals(6, number);

	}

	//readByteInRangeExclusive

	@DisplayName("Should readByteInRangeExclusive return the byte when byte is equal than lowerBound")
	@Test
	void readByteInRangeExclusiveWhenByteIsEqualThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextByte()).thenReturn((byte) 5);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		byte number = consoleInput.readByteInRangeExclusive((byte) 5, (byte) 10);

		assertEquals(5, number);
	}

	@DisplayName("Should readByteInRangeExclusive return the byte when byte is equal than upperBound")
	@Test
	void readByteInRangeExclusiveWhenByteIsEqualThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextByte()).thenReturn((byte) 10).thenReturn((byte) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		byte number = consoleInput.readByteInRangeExclusive((byte) 5, (byte) 10);

		verify(keyboard, times(2)).nextByte();
		assertEquals(6, number);
	}

	@DisplayName("Should readByteInRangeExclusive return the byte when byte is bigger than lowerBound and lower than upperBound")
	@Test
	void readByteInRangeExclusiveWhenByteIsBiggerThanLowerBoundAndLowerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextByte()).thenReturn((byte) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		byte number = consoleInput.readByteInRangeExclusive((byte) 5, (byte) 10);

		assertEquals(6, number);
	}

	@DisplayName("Should readByteInRangeExclusive return the byte when byte is lower than lowerBound")
	@Test
	void readByteInRangeExclusiveWhenByteIsLowerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextByte()).thenReturn((byte) 4).thenReturn((byte) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		byte number = consoleInput.readByteInRangeExclusive((byte) 5, (byte) 10);

		verify(keyboard, times(2)).nextByte();
		assertEquals(6, number);
	}

	@DisplayName("Should readByteInRangeExclusive return the byte when byte is bigger than upperBound")
	@Test
	void readByteInRangeExclusiveWhenByteIsBiggerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextByte()).thenReturn((byte) 11).thenReturn((byte) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		byte number = consoleInput.readByteInRangeExclusive((byte) 5, (byte) 10);

		verify(keyboard, times(2)).nextByte();
		assertEquals(6, number);

	}

	@DisplayName("Should readShort return the Short scanned")
	@Test
	void readShortWhenShort() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextShort()).thenReturn((short) 8);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		short number = consoleInput.readShort();

		assertEquals((short) 8, number);
	}

	@DisplayName("Should readShort return the Short scanned")
	@Test
	void readShortWhenShort1() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextShort()).thenReturn((short) 0);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		short number = consoleInput.readShort();

		assertEquals((short) 0, number);
	}

	@DisplayName("Should readShort call nextShort() again after the user has not entered a number")
	@Test
	void readShortWhenNonShort() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextShort()).thenThrow(new InputMismatchException()).thenReturn((short) 10);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		short number = consoleInput.readShort();

		verify(keyboard, times(2)).nextShort();
		assertEquals((short) 10, number);
	}

	//readShortLessThan
	@DisplayName("Should readShortLessThan return the Short when Short is bigger than upperBound")
	@Test
	void readShortLessThanWhenShortIsBiggerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextShort()).thenReturn((short) 8).thenReturn((short) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		short number = consoleInput.readShortLessThan((short) 7);
		verify(keyboard, times(2)).nextShort();
		assertEquals((short) 6, number);
	}

	@DisplayName("Should readShortLessThan return the Short when Short is lower than upperBound")
	@Test
	void readShortLessThanWhenShortIsLowerThanUpperBound() {//Preguntar mañana
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextShort()).thenReturn((short) 5);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		short number = consoleInput.readShortLessThan((short) 7);

		assertEquals((short) 5, number);
	}

	@DisplayName("Should readShortLessThan return the Short when Short is equal than upperBound")
	@Test
	void readShortLessThanWhenShortIsEqualThanUpperBound() {//Preguntar mañana
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextShort()).thenReturn((short) 7).thenReturn((short) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		short number = consoleInput.readShortLessThan((short) 7);
		verify(keyboard, times(2)).nextShort();
		assertEquals((short) 6, number);//Preguntar que hacer cuando se repito en el do while o preguntar si hay que poner excepcion
	}

	//readShortLessThan

	@DisplayName("Should readShortLessOrEqualThan return the Short when Short is equal than upperBound")
	@Test
	void readShortLessOrEqualThanWhenShortIsEqualThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextShort()).thenReturn((short) 7);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		short number = consoleInput.readShortLessOrEqualThan((short) 7);

		assertEquals((short) 7, number);
	}

	@DisplayName("Should readShortLessOrEqualThan return the Short when Short is lower than upperBound")
	@Test
	void readShortLessOrEqualThanWhenShortIsLowerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextShort()).thenReturn((short) 5);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		short number = consoleInput.readShortLessOrEqualThan((short) 7);

		assertEquals((short) 5, number);
	}

	@DisplayName("Should readShortLessOrEqualThan return the Short when Short is bigger than upperBound")
	@Test
	void readShortLessOrEqualThanWhenShortIsBiggerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextShort()).thenReturn((short) 8).thenReturn((short) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		short number = consoleInput.readShortLessOrEqualThan((short) 7);
		verify(keyboard, times(2)).nextShort();
		assertEquals((short) 6, number);
	}

	//readShortGreaterThan

	@DisplayName("Should readShortGreaterThan return the Short when Short is equal than lowerBound")
	@Test
	void readShortGreaterThanWhenShortIsEqualThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextShort()).thenReturn((short) 7).thenReturn((short) 9);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		short number = consoleInput.readShortGreaterThan((short) 7);
		verify(keyboard, times(2)).nextShort();
		assertEquals((short) 9, number);
	}

	@DisplayName("Should readShortGreaterThan return the Short when Short is bigger than lowerBound")
	@Test
	void readShortGreaterThanWhenShortIsBiggerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextShort()).thenReturn((short) 9);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		short number = consoleInput.readShortGreaterThan((short) 7);

		assertEquals((short) 9, number);
	}

	@DisplayName("Should readShortGreaterThan return the Short when Short is lower than lowerBound")
	@Test
	void readShortGreaterThanWhenShortIsLowerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextShort()).thenReturn((short) 6).thenReturn((short) 9);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		short number = consoleInput.readShortGreaterThan((short) 7);

		verify(keyboard, times(2)).nextShort();
		assertEquals((short) 9, number);
	}

	//readShortGreaterOrEqualThan

	@DisplayName("Should readShortGreaterOrEqualThan return the Short when Short is equal than lowerBound")
	@Test
	void readShortGreaterOrEqualThanWhenShortIsEqualThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextShort()).thenReturn((short) 7);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		short number = consoleInput.readShortGreaterOrEqualThan((short) 7);

		assertEquals((short) 7, number);
	}

	@DisplayName("Should readShortGreaterOrEqualThan return the Short when Short is bigger than lowerBound")
	@Test
	void readShortGreaterOrEqualThanWhenShortIsBiggerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextShort()).thenReturn((short) 9);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		short number = consoleInput.readShortGreaterOrEqualThan((short) 7);

		assertEquals((short) 9, number);
	}

	@DisplayName("Should readShortGreaterOrEqualThan return the Short when Short is lower than lowerBound")
	@Test
	void readShortGreaterOrEqualThanWhenShortIsLowerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextShort()).thenReturn((short) 6).thenReturn((short) 9);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		short number = consoleInput.readShortGreaterOrEqualThan((short) 7);

		verify(keyboard, times(2)).nextShort();
		assertEquals((short) 9, number);
	}

	//readShortInRangeInclusive

	@DisplayName("Should readShortInRangeInclusive return the Short when Short is equal than lowerBound")
	@Test
	void readShortInRangeInclusiveWhenShortIsEqualThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextShort()).thenReturn((short) 5);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		short number = consoleInput.readShortInRangeInclusive((short) 5, (short) 10);

		assertEquals((short) 5, number);
	}

	@DisplayName("Should readShortInRangeInclusive return the Short when Short is equal than upperBound")
	@Test
	void readShortInRangeInclusiveWhenShortIsEqualThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextShort()).thenReturn((short) 10);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		short number = consoleInput.readShortInRangeInclusive((short) 5, (short) 10);

		assertEquals((short) 10, number);
	}

	@DisplayName("Should readShortInRangeInclusive return the Short when Short is bigger than lowerBound and lower than upperBound")
	@Test
	void readShortInRangeInclusiveWhenShortIsBiggerThanLowerBoundAndLowerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextShort()).thenReturn((short) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		short number = consoleInput.readShortInRangeInclusive((short) 5, (short) 10);

		assertEquals((short) 6, number);
	}

	@DisplayName("Should readShortInRangeInclusive return the Short when Short is lower than lowerBound")
	@Test
	void readShortInRangeInclusiveWhenShortIsLowerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextShort()).thenReturn((short) 4).thenReturn((short) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		short number = consoleInput.readShortInRangeInclusive((short) 5, (short) 10);

		assertEquals((short) 6, number);
	}

	@DisplayName("Should readShortInRangeInclusive return the Short when Short is bigger than upperBound")
	@Test
	void readShortInRangeInclusiveWhenShortIsBiggerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextShort()).thenReturn((short) 11).thenReturn((short) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		short number = consoleInput.readShortInRangeInclusive((short) 5, (short) 10);

		verify(keyboard, times(2)).nextShort();
		assertEquals((short) 6, number);

	}

	//readShortInRangeExclusive

	@DisplayName("Should readShortInRangeExclusive return the Short when Short is equal than lowerBound")
	@Test
	void readShortInRangeExclusiveWhenShortIsEqualThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextShort()).thenReturn((short) 5);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		short number = consoleInput.readShortInRangeExclusive((short) 5, (short) 10);

		assertEquals((short) 5, number);
	}

	@DisplayName("Should readShortInRangeExclusive return the Short when Short is equal than upperBound")
	@Test
	void readShortInRangeExclusiveWhenShortIsEqualThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextShort()).thenReturn((short) 10).thenReturn((short) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		short number = consoleInput.readShortInRangeExclusive((short) 5, (short) 10);

		verify(keyboard, times(2)).nextShort();
		assertEquals((short) 6, number);
	}

	@DisplayName("Should readShortInRangeExclusive return the Short when Short is bigger than lowerBound and lower than upperBound")
	@Test
	void readShortInRangeExclusiveWhenShortIsBiggerThanLowerBoundAndLowerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextShort()).thenReturn((short) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		short number = consoleInput.readShortInRangeExclusive((short) 5, (short) 10);

		assertEquals((short) 6, number);
	}

	@DisplayName("Should readShortInRangeExclusive return the Short when Short is lower than lowerBound")
	@Test
	void readShortInRangeExclusiveWhenShortIsLowerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextShort()).thenReturn((short) 4).thenReturn((short) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		short number = consoleInput.readShortInRangeExclusive((short) 5, (short) 10);

		verify(keyboard, times(2)).nextShort();
		assertEquals((short) 6, number);
	}

	@DisplayName("Should readShortInRangeExclusive return the Short when Short is bigger than upperBound")
	@Test
	void readShortInRangeExclusiveWhenShortIsBiggerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextShort()).thenReturn((short) 11).thenReturn((short) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		short number = consoleInput.readShortInRangeExclusive((short) 5, (short) 10);

		verify(keyboard, times(2)).nextShort();
		assertEquals((short) 6, number);

	}

	@DisplayName("Should readInt return the Int scanned")
	@Test
	void readIntWhenInt() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextInt()).thenReturn((int) 8);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		int number = consoleInput.readInt();

		assertEquals((int) 8, number);
	}

	@DisplayName("Should readInt return the Int scanned")
	@Test
	void readIntWhenInt1() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextInt()).thenReturn((int) 0);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		int number = consoleInput.readInt();

		assertEquals((int) 0, number);
	}

	@DisplayName("Should readInt call nextInt() again after the user has not entered a number")
	@Test
	void readIntWhenNonInt() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextInt()).thenThrow(new InputMismatchException()).thenReturn((int) 10);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		int number = consoleInput.readInt();

		verify(keyboard, times(2)).nextInt();
		assertEquals((int) 10, number);
	}

	//readIntLessThan
	@DisplayName("Should readIntLessThan return the Int when Int is bigger than upperBound")
	@Test
	void readIntLessThanWhenIntIsBiggerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextInt()).thenReturn((int) 8).thenReturn((int) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		int number = consoleInput.readIntLessThan((int) 7);
		verify(keyboard, times(2)).nextInt();
		assertEquals((int) 6, number);
	}

	@DisplayName("Should readIntLessThan return the Int when Int is lower than upperBound")
	@Test
	void readIntLessThanWhenIntIsLowerThanUpperBound() {//Preguntar mañana
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextInt()).thenReturn((int) 5);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		int number = consoleInput.readIntLessThan((int) 7);

		assertEquals((int) 5, number);
	}

	@DisplayName("Should readIntLessThan return the Int when Int is equal than upperBound")
	@Test
	void readIntLessThanWhenIntIsEqualThanUpperBound() {//Preguntar mañana
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextInt()).thenReturn((int) 7).thenReturn((int) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		int number = consoleInput.readIntLessThan((int) 7);
		verify(keyboard, times(2)).nextInt();
		assertEquals((int) 6, number);//Preguntar que hacer cuando se repito en el do while o preguntar si hay que poner excepcion
	}

	//readIntLessThan

	@DisplayName("Should readIntLessOrEqualThan return the Int when Int is equal than upperBound")
	@Test
	void readIntLessOrEqualThanWhenIntIsEqualThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextInt()).thenReturn((int) 7);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		int number = consoleInput.readIntLessOrEqualThan((int) 7);

		assertEquals((int) 7, number);
	}

	@DisplayName("Should readIntLessOrEqualThan return the Int when Int is lower than upperBound")
	@Test
	void readIntLessOrEqualThanWhenIntIsLowerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextInt()).thenReturn((int) 5);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		int number = consoleInput.readIntLessOrEqualThan((int) 7);

		assertEquals((int) 5, number);
	}

	@DisplayName("Should readIntLessOrEqualThan return the Int when Int is bigger than upperBound")
	@Test
	void readIntLessOrEqualThanWhenIntIsBiggerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextInt()).thenReturn((int) 8).thenReturn((int) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		int number = consoleInput.readIntLessOrEqualThan((int) 7);
		verify(keyboard, times(2)).nextInt();
		assertEquals((int) 6, number);
	}

	//readIntGreaterThan

	@DisplayName("Should readIntGreaterThan return the Int when Int is equal than lowerBound")
	@Test
	void readIntGreaterThanWhenIntIsEqualThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextInt()).thenReturn((int) 7).thenReturn((int) 9);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		int number = consoleInput.readIntGreaterThan((int) 7);
		verify(keyboard, times(2)).nextInt();
		assertEquals((int) 9, number);
	}

	@DisplayName("Should readIntGreaterThan return the Int when Int is bigger than lowerBound")
	@Test
	void readIntGreaterThanWhenIntIsBiggerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextInt()).thenReturn((int) 9);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		int number = consoleInput.readIntGreaterThan((int) 7);

		assertEquals((int) 9, number);
	}

	@DisplayName("Should readIntGreaterThan return the Int when Int is lower than lowerBound")
	@Test
	void readIntGreaterThanWhenIntIsLowerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextInt()).thenReturn((int) 6).thenReturn((int) 9);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		int number = consoleInput.readIntGreaterThan((int) 7);

		verify(keyboard, times(2)).nextInt();
		assertEquals((int) 9, number);
	}

	//readIntGreaterOrEqualThan

	@DisplayName("Should readIntGreaterOrEqualThan return the Int when Int is equal than lowerBound")
	@Test
	void readIntGreaterOrEqualThanWhenIntIsEqualThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextInt()).thenReturn((int) 7);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		int number = consoleInput.readIntGreaterOrEqualThan((int) 7);

		assertEquals((int) 7, number);
	}

	@DisplayName("Should readIntGreaterOrEqualThan return the Int when Int is bigger than lowerBound")
	@Test
	void readIntGreaterOrEqualThanWhenIntIsBiggerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextInt()).thenReturn((int) 9);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		int number = consoleInput.readIntGreaterOrEqualThan((int) 7);

		assertEquals((int) 9, number);
	}

	@DisplayName("Should readIntGreaterOrEqualThan return the Int when Int is lower than lowerBound")
	@Test
	void readIntGreaterOrEqualThanWhenIntIsLowerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextInt()).thenReturn((int) 6).thenReturn((int) 9);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		int number = consoleInput.readIntGreaterOrEqualThan((int) 7);

		verify(keyboard, times(2)).nextInt();
		assertEquals((int) 9, number);
	}

	//readIntInRangeInclusive

	@DisplayName("Should readIntInRangeInclusive return the Int when Int is equal than lowerBound")
	@Test
	void readIntInRangeInclusiveWhenIntIsEqualThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextInt()).thenReturn((int) 5);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		int number = consoleInput.readIntInRangeInclusive((int) 5, (int) 10);

		assertEquals((int) 5, number);
	}

	@DisplayName("Should readIntInRangeInclusive return the Int when Int is equal than upperBound")
	@Test
	void readIntInRangeInclusiveWhenIntIsEqualThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextInt()).thenReturn((int) 10);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		int number = consoleInput.readIntInRangeInclusive((int) 5, (int) 10);

		assertEquals((int) 10, number);
	}

	@DisplayName("Should readIntInRangeInclusive return the Int when Int is bigger than lowerBound and lower than upperBound")
	@Test
	void readIntInRangeInclusiveWhenIntIsBiggerThanLowerBoundAndLowerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextInt()).thenReturn((int) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		int number = consoleInput.readIntInRangeInclusive((int) 5, (int) 10);

		assertEquals((int) 6, number);
	}

	@DisplayName("Should readIntInRangeInclusive return the Int when Int is lower than lowerBound")
	@Test
	void readIntInRangeInclusiveWhenIntIsLowerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextInt()).thenReturn((int) 4).thenReturn((int) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		int number = consoleInput.readIntInRangeInclusive((int) 5, (int) 10);

		verify(keyboard, times(2)).nextInt();
		assertEquals((int) 6, number);
	}

	@DisplayName("Should readIntInRangeInclusive return the Int when Int is bigger than upperBound")
	@Test
	void readIntInRangeInclusiveWhenIntIsBiggerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextInt()).thenReturn((int) 11).thenReturn((int) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		int number = consoleInput.readIntInRangeInclusive((int) 5, (int) 10);

		verify(keyboard, times(2)).nextInt();
		assertEquals((int) 6, number);

	}

	//readIntInRangeExclusive

	@DisplayName("Should readIntInRangeExclusive return the Int when Int is equal than lowerBound")
	@Test
	void readIntInRangeExclusiveWhenIntIsEqualThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextInt()).thenReturn((int) 5);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		int number = consoleInput.readIntInRangeExclusive((int) 5, (int) 10);

		assertEquals((int) 5, number);
	}

	@DisplayName("Should readIntInRangeExclusive return the Int when Int is equal than upperBound")
	@Test
	void readIntInRangeExclusiveWhenIntIsEqualThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextInt()).thenReturn((int) 10).thenReturn((int) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		int number = consoleInput.readIntInRangeExclusive((int) 5, (int) 10);

		verify(keyboard, times(2)).nextInt();
		assertEquals((int) 6, number);//Otra vez el lio
	}

	@DisplayName("Should readIntInRangeExclusive return the Int when Int is bigger than lowerBound and lower than upperBound")
	@Test
	void readIntInRangeExclusiveWhenIntIsBiggerThanLowerBoundAndLowerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextInt()).thenReturn((int) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		int number = consoleInput.readIntInRangeExclusive((int) 5, (int) 10);

		assertEquals((int) 6, number);
	}

	@DisplayName("Should readIntInRangeExclusive return the Int when Int is lower than lowerBound")
	@Test
	void readIntInRangeExclusiveWhenIntIsLowerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextInt()).thenReturn((int) 4).thenReturn((int) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		int number = consoleInput.readIntInRangeExclusive((int) 5, (int) 10);

		verify(keyboard, times(2)).nextInt();
		assertEquals((int) 6, number);
	}

	@DisplayName("Should readIntInRangeExclusive return the Int when Int is bigger than upperBound")
	@Test
	void readIntInRangeExclusiveWhenIntIsBiggerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextInt()).thenReturn((int) 11).thenReturn((int) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		int number = consoleInput.readIntInRangeExclusive((int) 5, (int) 10);

		verify(keyboard, times(2)).nextInt();
		assertEquals((int) 6, number);

	}

	//LONG

	@DisplayName("Should readLong return the Long scanned")
	@Test
	void readLongWhenLong() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLong()).thenReturn((long) 8);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		long number = consoleInput.readLong();

		assertEquals((long) 8, number);
	}

	@DisplayName("Should readLong return the Long scanned")
	@Test
	void readLongWhenLong1() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLong()).thenReturn((long) 0);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		long number = consoleInput.readLong();

		assertEquals((long) 0, number);
	}

	@DisplayName("Should readLong call nextLong() again after the user has not entered a number")
	@Test
	void readLongWhenNonLong() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLong()).thenThrow(new InputMismatchException()).thenReturn((long) 10);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		long number = consoleInput.readLong();

		verify(keyboard, times(2)).nextLong();
		assertEquals((long) 10, number);
	}

	//readLongLessThan
	@DisplayName("Should readLongLessThan return the Long when Long is bigger than upperBound")
	@Test
	void readLongLessThanWhenLongIsBiggerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLong()).thenReturn((long) 8).thenReturn((long) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		long number = consoleInput.readLongLessThan((long) 7);
		verify(keyboard, times(2)).nextLong();
		assertEquals((long) 6, number);
	}

	@DisplayName("Should readLongLessThan return the Long when Long is lower than upperBound")
	@Test
	void readLongLessThanWhenLongIsLowerThanUpperBound() {//Preguntar mañana
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLong()).thenReturn((long) 5);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		long number = consoleInput.readLongLessThan((long) 7);

		assertEquals((long) 5, number);
	}

	@DisplayName("Should readLongLessThan return the Long when Long is equal than upperBound")
	@Test
	void readLongLessThanWhenLongIsEqualThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLong()).thenReturn((long) 7).thenReturn((long) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		long number = consoleInput.readLongLessThan((long) 7);
		verify(keyboard, times(2)).nextLong();
		assertEquals((long) 6, number);
	}

	//readLongLessThan

	@DisplayName("Should readLongLessOrEqualThan return the Long when Long is equal than upperBound")
	@Test
	void readLongLessOrEqualThanWhenLongIsEqualThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLong()).thenReturn((long) 7);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		long number = consoleInput.readLongLessOrEqualThan((long) 7);

		assertEquals((long) 7, number);
	}

	@DisplayName("Should readLongLessOrEqualThan return the Long when Long is lower than upperBound")
	@Test
	void readLongLessOrEqualThanWhenLongIsLowerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLong()).thenReturn((long) 5);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		long number = consoleInput.readLongLessOrEqualThan((long) 7);

		assertEquals((long) 5, number);
	}

	@DisplayName("Should readLongLessOrEqualThan return the Long when Long is bigger than upperBound")
	@Test
	void readLongLessOrEqualThanWhenLongIsBiggerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLong()).thenReturn((long) 8).thenReturn((long) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		long number = consoleInput.readLongLessOrEqualThan((long) 7);
		verify(keyboard, times(2)).nextLong();
		assertEquals((long) 6, number);
	}

	//readLongGreaterThan

	@DisplayName("Should readLongGreaterThan return the Long when Long is equal than lowerBound")
	@Test
	void readLongGreaterThanWhenLongIsEqualThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLong()).thenReturn((long) 7).thenReturn((long) 9);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		long number = consoleInput.readLongGreaterThan((long) 7);
		verify(keyboard, times(2)).nextLong();
		assertEquals((long) 9, number);
	}

	@DisplayName("Should readLongGreaterThan return the Long when Long is bigger than lowerBound")
	@Test
	void readLongGreaterThanWhenLongIsBiggerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLong()).thenReturn((long) 9);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		long number = consoleInput.readLongGreaterThan((long) 7);

		assertEquals((long) 9, number);
	}

	@DisplayName("Should readLongGreaterThan return the Long when Long is lower than lowerBound")
	@Test
	void readLongGreaterThanWhenLongIsLowerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLong()).thenReturn((long) 6).thenReturn((long) 9);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		long number = consoleInput.readLongGreaterThan((long) 7);

		verify(keyboard, times(2)).nextLong();
		assertEquals((long) 9, number);
	}

	//readLongGreaterOrEqualThan

	@DisplayName("Should readLongGreaterOrEqualThan return the Long when Long is equal than lowerBound")
	@Test
	void readLongGreaterOrEqualThanWhenLongIsEqualThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLong()).thenReturn((long) 7);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		long number = consoleInput.readLongGreaterOrEqualThan((long) 7);

		assertEquals((long) 7, number);
	}

	@DisplayName("Should readLongGreaterOrEqualThan return the Long when Long is bigger than lowerBound")
	@Test
	void readLongGreaterOrEqualThanWhenLongIsBiggerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLong()).thenReturn((long) 9);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		long number = consoleInput.readLongGreaterOrEqualThan((long) 7);

		assertEquals((long) 9, number);
	}

	@DisplayName("Should readLongGreaterOrEqualThan return the Long when Long is lower than lowerBound")
	@Test
	void readLongGreaterOrEqualThanWhenLongIsLowerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLong()).thenReturn((long) 6).thenReturn((long) 9);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		long number = consoleInput.readLongGreaterOrEqualThan((long) 7);

		verify(keyboard, times(2)).nextLong();
		assertEquals((long) 9, number);
	}

	//readLongInRangeInclusive

	@DisplayName("Should readLongInRangeInclusive return the Long when Long is equal than lowerBound")
	@Test
	void readLongInRangeInclusiveWhenLongIsEqualThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLong()).thenReturn((long) 5);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		long number = consoleInput.readLongInRangeInclusive((long) 5, (long) 10);

		assertEquals((long) 5, number);
	}

	@DisplayName("Should readLongInRangeInclusive return the Long when Long is equal than upperBound")
	@Test
	void readLongInRangeInclusiveWhenLongIsEqualThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLong()).thenReturn((long) 10);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		long number = consoleInput.readLongInRangeInclusive((long) 5, (long) 10);

		assertEquals((long) 10, number);
	}

	@DisplayName("Should readLongInRangeInclusive return the Long when Long is bigger than lowerBound and lower than upperBound")
	@Test
	void readLongInRangeInclusiveWhenLongIsBiggerThanLowerBoundAndLowerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLong()).thenReturn((long) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		long number = consoleInput.readLongInRangeInclusive((long) 5, (long) 10);

		assertEquals((long) 6, number);
	}

	@DisplayName("Should readLongInRangeInclusive return the Long when Long is lower than lowerBound")
	@Test
	void readLongInRangeInclusiveWhenLongIsLowerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLong()).thenReturn((long) 4).thenReturn((long) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		long number = consoleInput.readLongInRangeInclusive((long) 5, (long) 10);

		verify(keyboard, times(2)).nextLong();
		assertEquals((long) 6, number);
	}

	@DisplayName("Should readLongInRangeInclusive return the Long when Long is bigger than upperBound")
	@Test
	void readLongInRangeInclusiveWhenLongIsBiggerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLong()).thenReturn((long) 11).thenReturn((long) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		long number = consoleInput.readLongInRangeInclusive((long) 5, (long) 10);

		verify(keyboard, times(2)).nextLong();
		assertEquals((long) 6, number);

	}

	//readLongInRangeExclusive

	@DisplayName("Should readLongInRangeExclusive return the Long when Long is equal than lowerBound")
	@Test
	void readLongInRangeExclusiveWhenLongIsEqualThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLong()).thenReturn((long) 5);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		long number = consoleInput.readLongInRangeExclusive((long) 5, (long) 10);

		assertEquals((long) 5, number);
	}

	@DisplayName("Should readLongInRangeExclusive return the Long when Long is equal than upperBound")
	@Test
	void readLongInRangeExclusiveWhenLongIsEqualThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLong()).thenReturn((long) 10).thenReturn((long) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		long number = consoleInput.readLongInRangeExclusive((long) 5, (long) 10);

		verify(keyboard, times(2)).nextLong();
		assertEquals((long) 6, number);//Otra vez el lio
	}

	@DisplayName("Should readLongInRangeExclusive return the Long when Long is bigger than lowerBound and lower than upperBound")
	@Test
	void readLongInRangeExclusiveWhenLongIsBiggerThanLowerBoundAndLowerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLong()).thenReturn((long) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		long number = consoleInput.readLongInRangeExclusive((long) 5, (long) 10);

		assertEquals((long) 6, number);
	}

	@DisplayName("Should readLongInRangeExclusive return the Long when Long is lower than lowerBound")
	@Test
	void readLongInRangeExclusiveWhenLongIsLowerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLong()).thenReturn((long) 4).thenReturn((long) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		long number = consoleInput.readLongInRangeExclusive((long) 5, (long) 10);

		verify(keyboard, times(2)).nextLong();
		assertEquals((long) 6, number);
	}

	@DisplayName("Should readLongInRangeExclusive return the Long when Long is bigger than upperBound")
	@Test
	void readLongInRangeExclusiveWhenLongIsBiggerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLong()).thenReturn((long) 11).thenReturn((long) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		long number = consoleInput.readLongInRangeExclusive((long) 5, (long) 10);

		verify(keyboard, times(2)).nextLong();
		assertEquals((long) 6, number);

	}

	@DisplayName("Should readDouble return the Double scanned")
	@Test
	void readDoubleWhenDouble() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextDouble()).thenReturn((double) 8);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		double number = consoleInput.readDouble();

		assertEquals((double) 8, number);
	}

	@DisplayName("Should readDouble return the Double scanned")
	@Test
	void readDoubleWhenDouble1() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextDouble()).thenReturn((double) 8.11);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		double number = consoleInput.readDouble();

		assertEquals((double) 8.11, number);
	}

	@DisplayName("Should readDouble call nextDouble() again after the user has not entered a number")
	@Test
	void readDoubleWhenNonDouble() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextDouble()).thenThrow(new InputMismatchException()).thenReturn((double) 10);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		double number = consoleInput.readDouble();

		verify(keyboard, times(2)).nextDouble();
		assertEquals((double) 10, number);
	}

	//readDoubleLessThan
	@DisplayName("Should readDoubleLessThan return the Double when Double is bigger than upperBound")
	@Test
	void readDoubleLessThanWhenDoubleIsBiggerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextDouble()).thenReturn((double) 8).thenReturn((double) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		double number = consoleInput.readDoubleLessThan((double) 7);
		verify(keyboard, times(2)).nextDouble();
		assertEquals((double) 6, number);
	}

	@DisplayName("Should readDoubleLessThan return the Double when Double is lower than upperBound")
	@Test
	void readDoubleLessThanWhenDoubleIsLowerThanUpperBound() {//Preguntar mañana
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextDouble()).thenReturn((double) 5);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		double number = consoleInput.readDoubleLessThan((double) 7);

		assertEquals((double) 5, number);
	}

	@DisplayName("Should readDoubleLessThan return the Double when Double is equal than upperBound")
	@Test
	void readDoubleLessThanWhenDoubleIsEqualThanUpperBound() {//Preguntar mañana
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextDouble()).thenReturn((double) 7).thenReturn((double) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		double number = consoleInput.readDoubleLessThan((double) 7);
		verify(keyboard, times(2)).nextDouble();
		assertEquals((double) 6, number);//Preguntar que hacer cuando se repito en el do while o preguntar si hay que poner excepcion
	}

	//readDoubleLessThan

	@DisplayName("Should readDoubleLessOrEqualThan return the Double when Double is equal than upperBound")
	@Test
	void readDoubleLessOrEqualThanWhenDoubleIsEqualThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextDouble()).thenReturn((double) 7);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		double number = consoleInput.readDoubleLessOrEqualThan((double) 7);

		assertEquals((double) 7, number);
	}

	@DisplayName("Should readDoubleLessOrEqualThan return the Double when Double is lower than upperBound")
	@Test
	void readDoubleLessOrEqualThanWhenDoubleIsLowerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextDouble()).thenReturn((double) 5);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		double number = consoleInput.readDoubleLessOrEqualThan((double) 7);

		assertEquals((double) 5, number);
	}

	@DisplayName("Should readDoubleLessOrEqualThan return the Double when Double is bigger than upperBound")
	@Test
	void readDoubleLessOrEqualThanWhenDoubleIsBiggerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextDouble()).thenReturn((double) 8).thenReturn((double) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		double number = consoleInput.readDoubleLessOrEqualThan((double) 7);
		verify(keyboard, times(2)).nextDouble();
		assertEquals((double) 6, number);
	}

	//readDoubleGreaterThan

	@DisplayName("Should readDoubleGreaterThan return the Double when Double is equal than lowerBound")
	@Test
	void readDoubleGreaterThanWhenDoubleIsEqualThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextDouble()).thenReturn((double) 7).thenReturn((double) 9);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		double number = consoleInput.readDoubleGreaterThan((double) 7);
		verify(keyboard, times(2)).nextDouble();
		assertEquals((double) 9, number);
	}

	@DisplayName("Should readDoubleGreaterThan return the Double when Double is bigger than lowerBound")
	@Test
	void readDoubleGreaterThanWhenDoubleIsBiggerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextDouble()).thenReturn((double) 9);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		double number = consoleInput.readDoubleGreaterThan((double) 7);

		assertEquals((double) 9, number);
	}

	@DisplayName("Should readDoubleGreaterThan return the Double when Double is lower than lowerBound")
	@Test
	void readDoubleGreaterThanWhenDoubleIsLowerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextDouble()).thenReturn((double) 6).thenReturn((double) 9);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		double number = consoleInput.readDoubleGreaterThan((double) 7);

		verify(keyboard, times(2)).nextDouble();
		assertEquals((double) 9, number);
	}

	//readDoubleGreaterOrEqualThan

	@DisplayName("Should readDoubleGreaterOrEqualThan return the Double when Double is equal than lowerBound")
	@Test
	void readDoubleGreaterOrEqualThanWhenDoubleIsEqualThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextDouble()).thenReturn((double) 7);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		double number = consoleInput.readDoubleGreaterOrEqualThan((double) 7);

		assertEquals((double) 7, number);
	}

	@DisplayName("Should readDoubleGreaterOrEqualThan return the Double when Double is bigger than lowerBound")
	@Test
	void readDoubleGreaterOrEqualThanWhenDoubleIsBiggerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextDouble()).thenReturn((double) 9);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		double number = consoleInput.readDoubleGreaterOrEqualThan((double) 7);

		assertEquals((double) 9, number);
	}

	@DisplayName("Should readDoubleGreaterOrEqualThan return the Double when Double is lower than lowerBound")
	@Test
	void readDoubleGreaterOrEqualThanWhenDoubleIsLowerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextDouble()).thenReturn((double) 6).thenReturn((double) 9);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		double number = consoleInput.readDoubleGreaterOrEqualThan((double) 7);

		verify(keyboard, times(2)).nextDouble();
		assertEquals((double) 9, number);
	}

	//readDoubleInRangeInclusive

	@DisplayName("Should readDoubleInRangeInclusive return the Double when Double is equal than lowerBound")
	@Test
	void readDoubleInRangeInclusiveWhenDoubleIsEqualThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextDouble()).thenReturn((double) 5);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		double number = consoleInput.readDoubleInRangeInclusive((double) 5, (double) 10);

		assertEquals((double) 5, number);
	}

	@DisplayName("Should readDoubleInRangeInclusive return the Double when Double is equal than upperBound")
	@Test
	void readDoubleInRangeInclusiveWhenDoubleIsEqualThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextDouble()).thenReturn((double) 10);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		double number = consoleInput.readDoubleInRangeInclusive((double) 5, (double) 10);

		assertEquals((double) 10, number);
	}

	@DisplayName("Should readDoubleInRangeInclusive return the Double when Double is bigger than lowerBound and lower than upperBound")
	@Test
	void readDoubleInRangeInclusiveWhenDoubleIsBiggerThanLowerBoundAndLowerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextDouble()).thenReturn((double) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		double number = consoleInput.readDoubleInRangeInclusive((double) 5, (double) 10);

		assertEquals((double) 6, number);
	}

	@DisplayName("Should readDoubleInRangeInclusive return the Double when Double is lower than lowerBound")
	@Test
	void readDoubleInRangeInclusiveWhenDoubleIsLowerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextDouble()).thenReturn((double) 4).thenReturn((double) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		double number = consoleInput.readDoubleInRangeInclusive((double) 5, (double) 10);

		verify(keyboard, times(2)).nextDouble();
		assertEquals((double) 6, number);
	}

	@DisplayName("Should readDoubleInRangeInclusive return the Double when Double is bigger than upperBound")
	@Test
	void readDoubleInRangeInclusiveWhenDoubleIsBiggerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextDouble()).thenReturn((double) 11).thenReturn((double) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		double number = consoleInput.readDoubleInRangeInclusive((double) 5, (double) 10);

		verify(keyboard, times(2)).nextDouble();
		assertEquals((double) 6, number);

	}

	//readDoubleInRangeExclusive

	@DisplayName("Should readDoubleInRangeExclusive return the Double when Double is equal than lowerBound")
	@Test
	void readDoubleInRangeExclusiveWhenDoubleIsEqualThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextDouble()).thenReturn((double) 5);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		double number = consoleInput.readDoubleInRangeExclusive((double) 5, (double) 10);

		assertEquals((double) 5, number);
	}

	@DisplayName("Should readDoubleInRangeExclusive return the Double when Double is equal than upperBound")
	@Test
	void readDoubleInRangeExclusiveWhenDoubleIsEqualThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextDouble()).thenReturn((double) 10).thenReturn((double) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		double number = consoleInput.readDoubleInRangeExclusive((double) 5, (double) 10);

		verify(keyboard, times(2)).nextDouble();
		assertEquals((double) 6, number);//Otra vez el lio
	}

	@DisplayName("Should readDoubleInRangeExclusive return the Double when Double is bigger than lowerBound and lower than upperBound")
	@Test
	void readDoubleInRangeExclusiveWhenDoubleIsBiggerThanLowerBoundAndLowerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextDouble()).thenReturn((double) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		double number = consoleInput.readDoubleInRangeExclusive((double) 5, (double) 10);

		assertEquals((double) 6, number);
	}

	@DisplayName("Should readDoubleInRangeExclusive return the Double when Double is lower than lowerBound")
	@Test
	void readDoubleInRangeExclusiveWhenDoubleIsLowerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextDouble()).thenReturn((double) 4).thenReturn((double) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		double number = consoleInput.readDoubleInRangeExclusive((double) 5, (double) 10);

		verify(keyboard, times(2)).nextDouble();
		assertEquals((double) 6, number);
	}

	@DisplayName("Should readDoubleInRangeExclusive return the Double when Double is bigger than upperBound")
	@Test
	void readDoubleInRangeExclusiveWhenDoubleIsBiggerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextDouble()).thenReturn((double) 11).thenReturn((double) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		double number = consoleInput.readDoubleInRangeExclusive((double) 5, (double) 10);

		verify(keyboard, times(2)).nextDouble();
		assertEquals((double) 6, number);

	}

	@DisplayName("Should readFloat return the Float scanned")
	@Test
	void readFloatWhenFloat() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextFloat()).thenReturn((float) 8);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		float number = consoleInput.readFloat();

		assertEquals((float) 8, number);
	}

	@DisplayName("Should readFloat return the Float scanned")
	@Test
	void readFloatWhenFloat1() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextFloat()).thenReturn((float) 8.11);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		float number = consoleInput.readFloat();

		assertEquals((float) 8.11, number);
	}

	@DisplayName("Should readFloat call nextFloat() again after the user has not entered a number")
	@Test
	void readFloatWhenNonFloat() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextFloat()).thenThrow(new InputMismatchException()).thenReturn((float) 10);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		float number = consoleInput.readFloat();

		verify(keyboard, times(2)).nextFloat();
		assertEquals((float) 10, number);
	}

	//readFloatLessThan
	@DisplayName("Should readFloatLessThan return the Float when Float is bigger than upperBound")
	@Test
	void readFloatLessThanWhenFloatIsBiggerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextFloat()).thenReturn((float) 8).thenReturn((float) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		float number = consoleInput.readFloatLessThan((float) 7);
		verify(keyboard, times(2)).nextFloat();
		assertEquals((float) 6, number);
	}

	@DisplayName("Should readFloatLessThan return the Float when Float is lower than upperBound")
	@Test
	void readFloatLessThanWhenFloatIsLowerThanUpperBound() {//Preguntar mañana
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextFloat()).thenReturn((float) 5);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		float number = consoleInput.readFloatLessThan((float) 7);

		assertEquals((float) 5, number);
	}

	@DisplayName("Should readFloatLessThan return the Float when Float is equal than upperBound")
	@Test
	void readFloatLessThanWhenFloatIsEqualThanUpperBound() {//Preguntar mañana
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextFloat()).thenReturn((float) 7).thenReturn((float) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		float number = consoleInput.readFloatLessThan((float) 7);
		verify(keyboard, times(2)).nextFloat();
		assertEquals((float) 6, number);//Preguntar que hacer cuando se repito en el do while o preguntar si hay que poner excepcion
	}

	//readFloatLessThan

	@DisplayName("Should readFloatLessOrEqualThan return the Float when Float is equal than upperBound")
	@Test
	void readFloatLessOrEqualThanWhenFloatIsEqualThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextFloat()).thenReturn((float) 7);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		float number = consoleInput.readFloatLessOrEqualThan((float) 7);

		assertEquals((float) 7, number);
	}

	@DisplayName("Should readFloatLessOrEqualThan return the Float when Float is lower than upperBound")
	@Test
	void readFloatLessOrEqualThanWhenFloatIsLowerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextFloat()).thenReturn((float) 5);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		float number = consoleInput.readFloatLessOrEqualThan((float) 7);

		assertEquals((float) 5, number);
	}

	@DisplayName("Should readFloatLessOrEqualThan return the Float when Float is bigger than upperBound")
	@Test
	void readFloatLessOrEqualThanWhenFloatIsBiggerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextFloat()).thenReturn((float) 8).thenReturn((float) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		float number = consoleInput.readFloatLessOrEqualThan((float) 7);
		verify(keyboard, times(2)).nextFloat();
		assertEquals((float) 6, number);
	}

	//readFloatGreaterThan

	@DisplayName("Should readFloatGreaterThan return the Float when Float is equal than lowerBound")
	@Test
	void readFloatGreaterThanWhenFloatIsEqualThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextFloat()).thenReturn((float) 7).thenReturn((float) 9);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		float number = consoleInput.readFloatGreaterThan((float) 7);
		verify(keyboard, times(2)).nextFloat();
		assertEquals((float) 9, number);
	}

	@DisplayName("Should readFloatGreaterThan return the Float when Float is bigger than lowerBound")
	@Test
	void readFloatGreaterThanWhenFloatIsBiggerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextFloat()).thenReturn((float) 9);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		float number = consoleInput.readFloatGreaterThan((float) 7);

		assertEquals((float) 9, number);
	}

	@DisplayName("Should readFloatGreaterThan return the Float when Float is lower than lowerBound")
	@Test
	void readFloatGreaterThanWhenFloatIsLowerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextFloat()).thenReturn((float) 6).thenReturn((float) 9);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		float number = consoleInput.readFloatGreaterThan((float) 7);

		verify(keyboard, times(2)).nextFloat();
		assertEquals((float) 9, number);
	}

	//readFloatGreaterOrEqualThan

	@DisplayName("Should readFloatGreaterOrEqualThan return the Float when Float is equal than lowerBound")
	@Test
	void readFloatGreaterOrEqualThanWhenFloatIsEqualThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextFloat()).thenReturn((float) 7);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		float number = consoleInput.readFloatGreaterOrEqualThan((float) 7);

		assertEquals((float) 7, number);
	}

	@DisplayName("Should readFloatGreaterOrEqualThan return the Float when Float is bigger than lowerBound")
	@Test
	void readFloatGreaterOrEqualThanWhenFloatIsBiggerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextFloat()).thenReturn((float) 9);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		float number = consoleInput.readFloatGreaterOrEqualThan((float) 7);

		assertEquals((float) 9, number);
	}

	@DisplayName("Should readFloatGreaterOrEqualThan return the Float when Float is lower than lowerBound")
	@Test
	void readFloatGreaterOrEqualThanWhenFloatIsLowerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextFloat()).thenReturn((float) 6).thenReturn((float) 9);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		float number = consoleInput.readFloatGreaterOrEqualThan((float) 7);

		verify(keyboard, times(2)).nextFloat();
		assertEquals((float) 9, number);
	}

	//readFloatInRangeInclusive

	@DisplayName("Should readFloatInRangeInclusive return the Float when Float is equal than lowerBound")
	@Test
	void readFloatInRangeInclusiveWhenFloatIsEqualThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextFloat()).thenReturn((float) 5);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		float number = consoleInput.readFloatInRangeInclusive((float) 5, (float) 10);

		assertEquals((float) 5, number);
	}

	@DisplayName("Should readFloatInRangeInclusive return the Float when Float is equal than upperBound")
	@Test
	void readFloatInRangeInclusiveWhenFloatIsEqualThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextFloat()).thenReturn((float) 10);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		float number = consoleInput.readFloatInRangeInclusive((float) 5, (float) 10);

		assertEquals((float) 10, number);
	}

	@DisplayName("Should readFloatInRangeInclusive return the Float when Float is bigger than lowerBound and lower than upperBound")
	@Test
	void readFloatInRangeInclusiveWhenFloatIsBiggerThanLowerBoundAndLowerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextFloat()).thenReturn((float) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		float number = consoleInput.readFloatInRangeInclusive((float) 5, (float) 10);

		assertEquals((float) 6, number);
	}

	@DisplayName("Should readFloatInRangeInclusive return the Float when Float is lower than lowerBound")
	@Test
	void readFloatInRangeInclusiveWhenFloatIsLowerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextFloat()).thenReturn((float) 4).thenReturn((float) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		float number = consoleInput.readFloatInRangeInclusive((float) 5, (float) 10);

		verify(keyboard, times(2)).nextFloat();
		assertEquals((float) 6, number);
	}

	@DisplayName("Should readFloatInRangeInclusive return the Float when Float is bigger than upperBound")
	@Test
	void readFloatInRangeInclusiveWhenFloatIsBiggerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextFloat()).thenReturn((float) 11).thenReturn((float) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		float number = consoleInput.readFloatInRangeInclusive((float) 5, (float) 10);

		verify(keyboard, times(2)).nextFloat();
		assertEquals((float) 6, number);

	}

	//readFloatInRangeExclusive

	@DisplayName("Should readFloatInRangeExclusive return the Float when Float is equal than lowerBound")
	@Test
	void readFloatInRangeExclusiveWhenFloatIsEqualThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextFloat()).thenReturn((float) 5);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		float number = consoleInput.readFloatInRangeExclusive((float) 5, (float) 10);

		assertEquals((float) 5, number);
	}

	@DisplayName("Should readFloatInRangeExclusive return the Float when Float is equal than upperBound")
	@Test
	void readFloatInRangeExclusiveWhenFloatIsEqualThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextFloat()).thenReturn((float) 10).thenReturn((float) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		float number = consoleInput.readFloatInRangeExclusive((float) 5, (float) 10);

		verify(keyboard, times(2)).nextFloat();
		assertEquals((float) 6, number);//Otra vez el lio
	}

	@DisplayName("Should readFloatInRangeExclusive return the Float when Float is bigger than lowerBound and lower than upperBound")
	@Test
	void readFloatInRangeExclusiveWhenFloatIsBiggerThanLowerBoundAndLowerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextFloat()).thenReturn((float) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		float number = consoleInput.readFloatInRangeExclusive((float) 5, (float) 10);

		assertEquals((float) 6, number);
	}

	@DisplayName("Should readFloatInRangeExclusive return the Float when Float is lower than lowerBound")
	@Test
	void readFloatInRangeExclusiveWhenFloatIsLowerThanLowerBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextFloat()).thenReturn((float) 4).thenReturn((float) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		float number = consoleInput.readFloatInRangeExclusive((float) 5, (float) 10);

		verify(keyboard, times(2)).nextFloat();
		assertEquals((float) 6, number);
	}

	@DisplayName("Should readFloatInRangeExclusive return the Float when Float is bigger than upperBound")
	@Test
	void readFloatInRangeExclusiveWhenFloatIsBiggerThanUpperBound() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextFloat()).thenReturn((float) 11).thenReturn((float) 6);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		float number = consoleInput.readFloatInRangeExclusive((float) 5, (float) 10);

		verify(keyboard, times(2)).nextFloat();
		assertEquals((float) 6, number);

	}
}
