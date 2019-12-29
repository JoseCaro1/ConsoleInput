package es.iessaladillo.consoleinput;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Esta clase contiene el control de excepciones por escritura de teclado.
 * Controlando todas las posibles excepciones a la hora de introducir un dato.
 * 
 * @author Jose Caro
 * @version 1.0
 * @since 1.0
 */
public class ConsoleInput {

	private final Scanner keyboard;

	public ConsoleInput(Scanner keyboard) {
		this.keyboard = keyboard;
	}

	private void cleanInput() {
		keyboard.nextLine();
	}

	/**
	 * readByte() Retorna un byte introducido por el usuario. En el caso que el
	 * usuario no introduzca un byte se le volvera a pedir hasta que lo haga.
	 * 
	 * @return El byte introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public byte readByte() {
		byte readB = 0;
		boolean exit = false;
		do {
			try {
				System.out.print("Introduzca un digito: ");
				readB = keyboard.nextByte();
				exit = false;
			} catch (InputMismatchException e) {
				System.out.println("Error al introducir el numero");
				exit = true;
			} finally {
				cleanInput();
			}
		} while (exit);

		return readB;
	}

	/**
	 * readByteLessThan(byte upperBound) : retorna un byte introducido por el
	 * usuario inferior al parametro.En el caso que el usuario no introduzca un byte
	 * se le volvera a pedir hasta que lo haga.
	 * 
	 * @see readByte()
	 * @param UpperBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El byte introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public byte readByteLessThan(byte upperBound) {
		byte readB;
		do {
			readB = readByte();
			if (readB >= upperBound) {
				System.out.println("Has introducido un byte mayor o igual al parametro");
			}
		} while (readB >= upperBound);
		return readB;
	}

	/**
	 * readByteLessOrEqualThan(byte upperBound) : retorna un byte introducido por el
	 * usuario inferior o igual al parametro.En el caso que el usuario no introduzca
	 * un byte se le volvera a pedir hasta que lo haga.
	 * 
	 * @see readByte()
	 * @param UpperBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El byte introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public byte readByteLessOrEqualThan(byte upperBound) {
		byte readB;
		do {
			readB = readByte();
			if (readB > upperBound) {
				System.out.println("Has introducido un byte mayor al parametro");
			}
		} while (readB > upperBound);
		return readB;
	}

	/**
	 * readByteGreaterThan(byte lowerBound) : retorna un byte introducido por el
	 * usuario superior al parametro.En el caso que el usuario no introduzca un byte
	 * se le volvera a pedir hasta que lo haga.
	 * 
	 * @see readByte()
	 * @param lowerBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El byte introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public byte readByteGreaterThan(byte lowerBound) {
		byte readB;
		do {
			readB = readByte();
			if (readB <= lowerBound) {
				System.out.println("Has introducido un byte menor o igual al parametro");
			}
		} while (readB <= lowerBound);
		return readB;
	}

	/**
	 * readByteGreaterThan(byte lowerBound) : retorna un byte introducido por el
	 * usuario superior o igual al parametro.En el caso que el usuario no introduzca
	 * un byte se le volvera a pedir hasta que lo haga.
	 * 
	 * @see readByte()
	 * @param lowerBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El byte introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public byte readByteGreaterOrEqualThan(byte lowerBound) {
		byte readB;
		do {
			readB = readByte();
			if (readB < lowerBound) {
				System.out.println("Has introducido un byte menor al parametro");
			}
		} while (readB < lowerBound);
		return readB;
	}

	/**
	 * readByteInRangeInclusive(byte lowerBound, byte upperBound) : retorna un byte
	 * introducido por el usuario cuyo valor este en el rango de lowerBound y
	 * upperBound, ambos incluidos.En el caso que el usuario no introduzca un numero
	 * que culpa dichos requisitos se le volvera pedir al usuario que lo introduzca.
	 * 
	 * @see readByte()
	 * @param lowerBound Parametro minimo del rango.
	 * @param upperBound Parametro maximo del rango.
	 * @return Retorna el byte introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public byte readByteInRangeInclusive(byte lowerBound, byte upperBound) {
		byte readB;

		do {
			readB = readByte();
		} while (readB < lowerBound || readB > upperBound);
		return readB;
	}

	/**
	 * readByteInRangeExclusive(byte lowerBound, byte upperBound) : retorna un byte
	 * introducido por el usuario cuyo valor este en el rango de lowerBound y
	 * upperBound, donde upperBound no esté incluido.En el caso que el usuario no
	 * introduzca un numero que culpa dichos requisitos se le volvera pedir al
	 * usuario que lo introduzca.
	 * 
	 * @see readByte()
	 * @param lowerBound Parametro minimo del rango.
	 * @param upperBound Parametro maximo del rango.
	 * @return Retorna el byte introducido por el usuario .
	 * @version 1.0
	 * @since 1.0
	 */

	public byte readByteInRangeExclusive(byte lowerBound, byte upperBound) {
		byte readB;

		do {
			readB = readByte();
		} while (readB < lowerBound || readB >= upperBound);
		return readB;
	}

	/**
	 * readShort() Retorna un short introducido por el usuario. En el caso que el
	 * usuario no introduzca un short se le volvera a pedir hasta que lo haga.
	 * 
	 * @return El short introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	//SHORT
	public short readShort() {
		short readS = 0;
		boolean exit = false;
		do {
			try {
				System.out.print("Introduzca un digito: ");
				readS = keyboard.nextShort();
				exit = false;
			} catch (InputMismatchException e) {
				System.out.println("Error al introducir el numero");
				exit = true;
			} finally {
				cleanInput();
			}
		} while (exit);
		return readS;
	}

	/**
	 * readShortLessThan(short upperBound) retorna un short introducido por el
	 * usuario inferior al parametro. En el caso que el usuario no introduzca un
	 * short se le volvera a pedir hasta que lo haga.
	 * 
	 * @see readShort()
	 * @param UpperBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El short introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public short readShortLessThan(short upperBound) {
		short readS;
		do {
			readS = readShort();
			if (readS >= upperBound) {
				System.out.println("Has introducido un short mayor o igual al parametro");
			}
		} while (readS >= upperBound);
		return readS;
	}

	/**
	 * readShortLessOrEqualThan(short upperBound) : retorna un short introducido por
	 * el usuario inferior o igual al parametro.En el caso que el usuario no
	 * introduzca un short se le volvera a pedir hasta que lo haga.
	 * 
	 * @see readShort()
	 * @param UpperBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El short introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public short readShortLessOrEqualThan(short upperBound) {
		short readS;
		do {
			readS = readShort();
			if (readS > upperBound) {
				System.out.println("Has introducido un short mayor al parametro");
			}
		} while (readS > upperBound);
		return readS;
	}

	/**
	 * readShortGreaterThan(short lowerBound) : retorna un short introducido por el
	 * usuario superior al parametro.En el caso que el usuario no introduzca un
	 * short se le volvera a pedir hasta que lo haga.
	 * 
	 * @see readShort()
	 * @param lowerBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El short introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public short readShortGreaterThan(short lowerBound) {
		short readS;
		do {
			readS = readShort();
			if (readS <= lowerBound) {
				System.out.println("Has introducido un short menor o igual al parametro");
			}
		} while (readS <= lowerBound);
		return readS;
	}

	/**
	 * readShortGreaterOrEqualThan(short lowerBound) : retorna un short introducido
	 * por el usuario superior o igual al parametro.En el caso que el usuario no
	 * introduzca un short se le volvera a pedir hasta que lo haga.
	 * 
	 * @see readShort()
	 * @param lowerBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El short introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public short readShortGreaterOrEqualThan(short lowerBound) {
		Short readS;
		do {
			readS = readShort();
			if (readS < lowerBound) {
				System.out.println("Has introducido un short menor al parametro");
			}
		} while (readS < lowerBound);
		return readS;
	}

	/**
	 * readShortInRangeInclusive(short lowerBound, short upperBound) : retorna un
	 * short introducido por el usuario cuyo valor este en el rango de lowerBound y
	 * upperBound, ambos incluidos. En el caso que el usuario no introduzca un short
	 * de dichos requisitos se le volvera a pedir hasta que lo haga.
	 * 
	 * @see readShort()
	 * @param UpperBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @param lowerBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El short introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public short readShortInRangeInclusive(short lowerBound, short upperBound) {
		short readS;

		do {
			readS = readShort();
		} while (readS < lowerBound || readS > upperBound);
		return readS;
	}

	/**
	 * readShortInRangeExclusive(short lowerBound, short upperBound) : retorna un
	 * short introducido por el usuario cuyo valor este en el rango de lowerBound y
	 * upperBound, donde upperBound no este incluido. En el caso que el usuario no
	 * introduzca un short de dichos requisitos se le volvera a pedir hasta que lo
	 * haga.
	 * 
	 * @see readShort()
	 * @param UpperBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @param lowerBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El short introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public short readShortInRangeExclusive(short lowerBound, short upperBound) {
		short readS;

		do {
			readS = readShort();
		} while (readS < lowerBound || readS >= upperBound);
		return readS;
	}

	/**
	 * readInt() Retorna un int introducido por el usuario. En el caso que el
	 * usuario no introduzca un int se le volvera a pedir hasta que lo haga.
	 * 
	 * @return El int introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */
	//INT
	public int readInt() {
		int readI = 0;
		boolean exit = false;
		do {
			try {
				//System.out.print("Introduzca un digito: ");
				readI = keyboard.nextInt();
				exit = false;
			} catch (InputMismatchException e) {
				System.out.println("Error al introducir el numero");
				exit = true;
			} finally {
				cleanInput();
			}
		} while (exit);
		return readI;
	}

	/**
	 * readIntLessThan(int upperBound) retorna un int introducido por el usuario
	 * inferior al parametro. En el caso que el usuario no introduzca un int se le
	 * volvera a pedir hasta que lo haga.
	 * 
	 * @see readInt()
	 * @param UpperBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El int introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public int readIntLessThan(int upperBound) {
		int readI;
		do {
			readI = readInt();
			if (readI >= upperBound) {
				System.out.println("Has introducido un int mayor o igual al parametro");
			}
		} while (readI >= upperBound);
		return readI;
	}

	/**
	 * readIntLessOrEqualThan(int upperBound) : retorna un int introducido por el
	 * usuario inferior o igual al parametro.En el caso que el usuario no introduzca
	 * un int se le volvera a pedir hasta que lo haga.
	 * 
	 * @see readInt()
	 * @param UpperBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El int introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public int readIntLessOrEqualThan(int upperBound) {
		int readI;
		do {
			readI = readInt();
			if (readI > upperBound) {
				System.out.println("Has introducido un int mayor al parametro");
			}
		} while (readI > upperBound);
		return readI;
	}

	/**
	 * readIntGreaterThan(int lowerBound) : retorna un int introducido por el
	 * usuario superior al parametro.En el caso que el usuario no introduzca un int
	 * se le volvera a pedir hasta que lo haga.
	 * 
	 * @see readInt()
	 * @param lowerBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El int introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public int readIntGreaterThan(int lowerBound) {
		int readI;
		do {
			readI = readInt();
			if (readI <= lowerBound) {
				System.out.println("Has introducido un int menor o igual al parametro");
			}
		} while (readI <= lowerBound);
		return readI;
	}

	/**
	 * readIntGreaterOrEqualThan(int lowerBound) : retorna un int introducido por el
	 * usuario superior o igual al parametro.En el caso que el usuario no introduzca
	 * un int se le volvera a pedir hasta que lo haga.
	 * 
	 * @see readInt()
	 * @param lowerBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El int introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public int readIntGreaterOrEqualThan(int lowerBound) {
		int readI;
		do {
			readI = readInt();
			if (readI < lowerBound) {
				System.out.println("Has introducido un int menor al parametro");
			}
		} while (readI < lowerBound);
		return readI;
	}

	/**
	 * readIntInRangeInclusive(int lowerBound, int upperBound) : retorna un int
	 * introducido por el usuario cuyo valor este en el rango de lowerBound y
	 * upperBound, ambos incluidos. En el caso que el usuario no introduzca un int
	 * de dichos requisitos se le volvera a pedir hasta que lo haga.
	 * 
	 * @see readInt()
	 * @param UpperBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @param lowerBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El int introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public int readIntInRangeInclusive(int lowerBound, int upperBound) {
		int readI;

		do {
			readI = readInt();
		} while (readI < lowerBound || readI > upperBound);
		return readI;
	}

	/**
	 * readIntInRangeExclusive(int lowerBound, int upperBound) : retorna un int
	 * introducido por el usuario cuyo valor este en el rango de lowerBound y
	 * upperBound, donde upperBound no esta incluido. En el caso que el usuario no
	 * introduzca un int de dichos requisitos se le volvera a pedir hasta que lo
	 * haga.
	 * 
	 * @see readInt()
	 * @param UpperBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @param lowerBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El int introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public int readIntInRangeExclusive(int lowerBound, int upperBound) {
		int readI;

		do {
			readI = readInt();
		} while (readI < lowerBound || readI >= upperBound);
		return readI;
	}

	/**
	 * readLong() Retorna un long introducido por el usuario. En el caso que el
	 * usuario no introduzca un long se le volvera a pedir hasta que lo haga.
	 * 
	 * @return El long introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	//LONG
	public long readLong() {
		long readL = 0;
		boolean exit = false;
		do {
			try {
				//System.out.print("Introduzca un digito: ");
				readL = keyboard.nextLong();
				exit = false;
			} catch (InputMismatchException e) {
				System.out.println("Error al introducir el numero");
				exit = true;
			} finally {
				cleanInput();
			}
		} while (exit);
		return readL;
	}

	/**
	 * readLongLessThan(long upperBound) retorna un long introducido por el usuario
	 * inferior al parametro. En el caso que el usuario no introduzca un long se le
	 * volvera a pedir hasta que lo haga.
	 * 
	 * @see readLong()
	 * @param UpperBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El long introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public long readLongLessThan(long upperBound) {
		long readL;
		do {
			readL = readLong();
			if (readL >= upperBound) {
				System.out.println("Has introducido un long mayor o igual al parametro");
			}
		} while (readL >= upperBound);
		return readL;
	}

	/**
	 * readLongLessOrEqualThan(long upperBound) : retorna un long introducido por el
	 * usuario inferior o igual al parametro.En el caso que el usuario no introduzca
	 * un long se le volvera a pedir hasta que lo haga.
	 * 
	 * @see readLong()
	 * @param UpperBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El long introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public long readLongLessOrEqualThan(long upperBound) {
		long readL;
		do {
			readL = readLong();
			if (readL > upperBound) {
				System.out.println("Has introducido un long mayor al parametro");
			}
		} while (readL > upperBound);
		return readL;
	}

	/**
	 * readLongGreaterThan(long lowerBound) : retorna un long introducido por el
	 * usuario superior al parametro.En el caso que el usuario no introduzca un long
	 * se le volvera a pedir hasta que lo haga.
	 * 
	 * @see readLong()
	 * @param lowerBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El long introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public long readLongGreaterThan(long lowerBound) {
		long readL;
		do {
			readL = readLong();
			if (readL <= lowerBound) {
				System.out.println("Has introducido un long menor o igual al parametro");
			}
		} while (readL <= lowerBound);
		return readL;
	}

	/**
	 * readLongGreaterOrEqualThan(long lowerBound) : retorna un long introducido por
	 * el usuario superior o igual al parametro.En el caso que el usuario no
	 * introduzca un long se le volvera a pedir hasta que lo haga.
	 * 
	 * @see readLong()
	 * @param lowerBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El long introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public long readLongGreaterOrEqualThan(long lowerBound) {
		long readL;
		do {
			readL = readLong();
			if (readL < lowerBound) {
				System.out.println("Has introducido un long menor al parametro");
			}
		} while (readL < lowerBound);
		return readL;
	}

	/**
	 * readLongInRangeInclusive(long lowerBound, long upperBound) : retorna un long
	 * introducido por el usuario cuyo valor este en el rango de lowerBound y
	 * upperBound, ambos incluidos. En el caso que el usuario no introduzca un long
	 * de dichos requisitos se le volvera a pedir hasta que lo haga.
	 * 
	 * @see readLong()
	 * @param UpperBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @param lowerBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El long introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public long readLongInRangeInclusive(long lowerBound, long upperBound) {
		long readL;

		do {
			readL = readLong();
		} while (readL < lowerBound || readL > upperBound);
		return readL;
	}

	/**
	 * readLongInRangeExclusive(long lowerBound, long upperBound) : retorna un long
	 * introducido por el usuario cuyo valor este en el rango de lowerBound y
	 * upperBound, donde el upperBound no esta incluido. En el caso que el usuario
	 * no introduzca un long de dichos requisitos se le volvera a pedir hasta que lo
	 * haga.
	 * 
	 * @see readLong()
	 * @param UpperBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @param lowerBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El long introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public long readLongInRangeExclusive(long lowerBound, long upperBound) {
		long readL;

		do {
			readL = readLong();
		} while (readL < lowerBound || readL >= upperBound);
		return readL;
	}

	/**
	 * readDouble() Retorna un double introducido por el usuario. En el caso que el
	 * usuario no introduzca un double se le volvera a pedir hasta que lo haga.
	 * 
	 * @return El double introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	//DOUBLE
	public double readDouble() {
		double readD = 0;
		boolean exit = false;
		do {
			try {
				//System.out.print("Introduzca un digito: ");
				readD = keyboard.nextDouble();
				exit = false;
			} catch (InputMismatchException e) {
				System.out.println("Error al introducir el numero");
				exit = true;
			} finally {
				cleanInput();
			}
		} while (exit);
		return readD;
	}

	/**
	 * readDoubleLessThan(double upperBound) retorna un double introducido por el
	 * usuario inferior al parametro. En el caso que el usuario no introduzca un
	 * double se le volvera a pedir hasta que lo haga.
	 * 
	 * @see readDouble()
	 * @param UpperBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El double introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public double readDoubleLessThan(double upperBound) {
		double readD;
		do {
			readD = readDouble();
			if (readD >= upperBound) {
				System.out.println("Has introducido un double mayor o igual al parametro");
			}
		} while (readD >= upperBound);
		return readD;
	}

	/**
	 * readDoubleLessOrEqualThan(double upperBound) : retorna un double introducido
	 * por el usuario inferior o igual al parametro.En el caso que el usuario no
	 * introduzca un double se le volvera a pedir hasta que lo haga.
	 * 
	 * @see readDouble()
	 * @param UpperBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El double introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public double readDoubleLessOrEqualThan(double upperBound) {
		double readD;
		do {
			readD = readDouble();
			if (readD > upperBound) {
				System.out.println("Has introducido un double mayor al parametro");
			}
		} while (readD > upperBound);
		return readD;
	}

	/**
	 * readDoubleGreaterThan(double lowerBound) : retorna un double introducido por
	 * el usuario superior al parametro.En el caso que el usuario no introduzca un
	 * double se le volvera a pedir hasta que lo haga.
	 * 
	 * @see readDouble()
	 * @param lowerBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El double introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public double readDoubleGreaterThan(double lowerBound) {
		double readD;
		do {
			readD = readDouble();
			if (readD <= lowerBound) {
				System.out.println("Has introducido un double menor o igual al parametro");
			}
		} while (readD <= lowerBound);
		return readD;
	}

	/**
	 * readDoubleGreaterOrEqualThan(double lowerBound) : retorna un double
	 * introducido por el usuario superior o igual al parametro.En el caso que el
	 * usuario no introduzca un double se le volvera a pedir hasta que lo haga.
	 * 
	 * @see readDouble()
	 * @param lowerBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El double introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public double readDoubleGreaterOrEqualThan(double lowerBound) {
		double readD;
		do {
			readD = readDouble();
			if (readD < lowerBound) {
				System.out.println("Has introducido un double menor al parametro");
			}
		} while (readD < lowerBound);
		return readD;
	}

	/**
	 * readDoubleInRangeInclusive(double lowerBound, double upperBound) : retorna un
	 * double introducido por el usuario cuyo valor este en el rango de lowerBound y
	 * upperBound, ambos incluidos. En el caso que el usuario no introduzca un
	 * double de dichos requisitos se le volvera a pedir hasta que lo haga.
	 * 
	 * @see readDouble()
	 * @param UpperBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @param lowerBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El double introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public double readDoubleInRangeInclusive(double lowerBound, double upperBound) {
		double readD;

		do {
			readD = readDouble();
		} while (readD < lowerBound || readD > upperBound);
		return readD;
	}

	/**
	 * readDoubleExRangeInclusive(double lowerBound, double upperBound) : retorna un
	 * double introducido por el usuario cuyo valor este en el rango de lowerBound y
	 * upperBound, donde upperBound no esta incluido. En el caso que el usuario no
	 * introduzca un long de dichos requisitos se le volvera a pedir hasta que lo
	 * haga.
	 * 
	 * @see readDouble()
	 * @param UpperBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @param lowerBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El double introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public double readDoubleInRangeExclusive(double lowerBound, double upperBound) {
		double readD;

		do {
			readD = readDouble();
		} while (readD < lowerBound || readD >= upperBound);
		return readD;
	}

	/**
	 * readFloat() Retorna un float introducido por el usuario. En el caso que el
	 * usuario no introduzca un float se le volvera a pedir hasta que lo haga.
	 * 
	 * @return El float introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	//FLOAT
	public float readFloat() {
		float readF = 0;
		boolean exit = false;
		do {
			try {
				//System.out.print("Introduzca un digito: ");
				readF = keyboard.nextFloat();
				exit = false;
			} catch (InputMismatchException e) {
				System.out.println("Error al introducir el numero");
				exit = true;
			} finally {
				cleanInput();
			}
		} while (exit);
		return readF;
	}

	/**
	 * readFloatLessThan(float upperBound) retorna un float introducido por el
	 * usuario inferior al parametro. En el caso que el usuario no introduzca un
	 * float se le volvera a pedir hasta que lo haga.
	 * 
	 * @see readFloat()
	 * @param UpperBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El float introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public float readFloatLessThan(float upperBound) {
		float readF;
		do {
			readF = readFloat();
			if (readF >= upperBound) {
				System.out.println("Has introducido un float mayor o igual al parametro");
			}
		} while (readF >= upperBound);
		return readF;
	}

	/**
	 * readFloatLessOrEqualThan(float upperBound) : retorna un float introducido por
	 * el usuario inferior o igual al parametro.En el caso que el usuario no
	 * introduzca un float se le volvera a pedir hasta que lo haga.
	 * 
	 * @see readFloat()
	 * @param UpperBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El float introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public float readFloatLessOrEqualThan(float upperBound) {
		float readF;
		do {
			readF = readFloat();
			if (readF > upperBound) {
				System.out.println("Has introducido un float mayor al parametro");
			}
		} while (readF > upperBound);
		return readF;
	}

	/**
	 * readFloatGreaterThan(float lowerBound) : retorna un float introducido por el
	 * usuario superior al parametro.En el caso que el usuario no introduzca un
	 * float se le volvera a pedir hasta que lo haga.
	 * 
	 * @see readFloat()
	 * @param lowerBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El float introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public float readFloatGreaterThan(float lowerBound) {
		float readF;
		do {
			readF = readFloat();
			if (readF <= lowerBound) {
				System.out.println("Has introducido un float menor o igual al parametro");
			}
		} while (readF <= lowerBound);
		return readF;
	}

	/**
	 * readFloatGreaterOrEqualThan(float lowerBound) : retorna un float introducido
	 * por el usuario superior o igual al parametro.En el caso que el usuario no
	 * introduzca un float se le volvera a pedir hasta que lo haga.
	 * 
	 * @see readFloat()
	 * @param lowerBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El float introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public float readFloatGreaterOrEqualThan(float lowerBound) {
		float readF;
		do {
			readF = readFloat();
			if (readF < lowerBound) {
				System.out.println("Has introducido un float menor al parametro");
			}
		} while (readF < lowerBound);
		return readF;
	}

	/**
	 * readFloatInRangeInclusive(float lowerBound, float upperBound) : retorna un
	 * float introducido por el usuario cuyo valor este en el rango de lowerBound y
	 * upperBound, ambos incluidos. En el caso que el usuario no introduzca un float
	 * de dichos requisitos se le volvera a pedir hasta que lo haga.
	 * 
	 * @see readFloat()
	 * @param UpperBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @param lowerBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El float introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public float readFloatInRangeInclusive(float lowerBound, float upperBound) {
		float readF;

		do {
			readF = readFloat();
		} while (readF < lowerBound || readF > upperBound);
		return readF;
	}

	/**
	 * readFloatInRangeExclusive(float lowerBound, float upperBound) : retorna un
	 * float introducido por el usuario cuyo valor este en el rango de lowerBound y
	 * upperBound, donde upperBound no esta incluido. En el caso que el usuario no
	 * introduzca un float de dichos requisitos se le volvera a pedir hasta que lo
	 * haga.
	 * 
	 * @see readFloat()
	 * @param UpperBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @param lowerBound Parametro utilizado para compararse por el digito del
	 *                   usuario.
	 * @return El float introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public float readFloatInRangeExclusive(float lowerBound, float upperBound) {
		float readF;

		do {
			readF = readFloat();
		} while (readF < lowerBound || readF >= upperBound);
		return readF;
	}

	/**
	 * readChar() : retorna un caracter introducido por el usuario. Si éste
	 * introduce más de un carácter, se le vuelve a solicitar.
	 * 
	 * @return El char introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	//CHAR
	public char readChar() {
		String str;

		do {

			System.out.print("Introduzca un caracter: ");
			str = keyboard.nextLine();
			if (str.length() <= 0 || str.length() > 1) {
				System.out.println("Has introducido mas de caracter o ninguno");
			}
		} while (str.length() <= 0 || str.length() > 1);
		return str.charAt(0);
	}

	/**
	 * readChar(String validCharacters) : retorna un caracter introducido por el
	 * usuario. El parámetro validCharacters contiene los posibles caracteres
	 * válidos.
	 * 
	 * @see readChar()
	 * @param validCharacters Contiene los caracteres validos que son comparados.
	 * @return El char introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public char readChar(String validCharacters) {
		char vChar, readC;
		boolean exit = false;
		do {
			readC = readChar();
			for (int count = 0; count <= validCharacters.length() - 1; count++) {
				vChar = validCharacters.charAt(count);
				if (readC == vChar) {
					exit = true;
				}
			}
		} while (!exit);
		return readC;

	}

	/**
	 * readVowel(): retorna una vocal introducida por el usuario. En caso que el
	 * usuario no introduzca una vocal, se le volvera a pedir que introduzca una.
	 * 
	 * @see readChar(String validCharacters)
	 * @return El char introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public char readVowel() {
		char readC;
		readC = readChar("aeiouAEIOU");

		return readC;

	}

	/**
	 * readDigit(): retorna un digito introducida por el usuario. En caso que el
	 * usuario no introduzca una digito, se le volvera a pedir que introduzca uno.
	 * 
	 * @see readChar()
	 * @return El char introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public char readDigit() {
		char readC;
		boolean exit;
		do {
			readC = readChar();
			exit = Character.isDigit(readC);
		} while (!exit);

		return readC;
	}

	/**
	 * readLowerCase(): retorna un una letra minuscula introducida por el usuario.
	 * En caso que el usuario no introduzca una letra minuscula, se le volvera a
	 * pedir que introduzca una.
	 * 
	 * @see readChar()
	 * @return El char introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public char readLowerCase() {
		String str;
		char readC;
		do {
			readC = readChar();
			str = Character.toString(readC);
		} while (!str.equals(str.toLowerCase()) || Character.isDigit(readC));
		readC = str.charAt(0);

		return readC;
	}

	/**
	 * readUpperCase(): retorna un una letra mayuscula introducida por el usuario.
	 * En caso que el usuario no introduzca una letra mayuscula, se le volvera a
	 * pedir que introduzca una.
	 * 
	 * @see readChar()
	 * @return El char introducido por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public char readUpperCase() {
		String str;
		char readC;
		do {
			readC = readChar();
			str = Character.toString(readC);
		} while (str.equals(str.toLowerCase()) || Character.isDigit(readC));
		readC = str.charAt(0);

		return readC;
	}

	//METODOS STRING

	/**
	 * readString(): retorna una cadena introducida por el usuario
	 * 
	 * @return La cadena introducida por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public String readString() {
		String str;

		//System.out.print("Introduzca un cadena: ");
		str = keyboard.nextLine();

		return str;
	}

	/**
	 * readString(int maxLength): retorna una cadena introducida por el usuario cuya
	 * longitud sea de menor o igual al parametro.
	 * 
	 * @see readString()
	 * @param maxLength Max longitud de la cadena.
	 * @return La cadena introducida por el usuario.
	 * @version 1.0
	 * @since 1.0
	 */

	public String readString(int maxLength) {
		String str;
		do {
			str = readString();
		} while (str.length() > maxLength);
		return str;
	}

	//BOOLEAN

	/**
	 * readBooleanUsingChar(char affirmativeValue): retorna el true or false
	 * dependiendo de si el caracter introduciodo por el usuario es igual al
	 * parametro.
	 * 
	 * @see readChar()
	 * @param affirmativeValue
	 * @return True si el caracter es igual, si no false
	 * @version 1.0
	 * @since 1.0
	 */

	public boolean readBooleanUsingChar(char affirmativeValue) {
		String str = Character.toString(Character.toLowerCase(readChar()));
		String str1 = Character.toString(Character.toLowerCase(affirmativeValue));
		boolean valor = false;

		if (str.equals(str1)) {
			valor = true;
		}
		return valor;
	}

	/**
	 * readBooleanUsingChar(): retorna el true or false dependiendo de si el
	 * caracter introduciodo por el usuario es igual a S o N. En el caso que el
	 * caracter no sea igual a ninguno de los dos, se le pedira al usuario que
	 * introduzca de nuevo un caracter hasta que introduzca uno.
	 * 
	 * @see readChar()
	 * @return True si el caracter es igual S, si no false
	 * @version 1.0
	 * @since 1.0
	 */

	public boolean readBooleanUsingChar() {
		char readC = readChar("snSN");
		boolean valor = false;
		if (readC == 's' || readC == 'S') {
			valor = true;
		}
		return valor;

	}

	/**
	 * readBooleanUsingInt(Int affirmativeValue): retorna el true or false
	 * dependiendo de si el digito introduciodo por el usuario es igual al
	 * parametro.
	 * 
	 * @see readInt()
	 * @param affirmativeValue
	 * @return True si el digito es igual, si no false
	 * @version 1.0
	 * @since 1.0
	 */

	public boolean readBooleanUsingInt(int affirmativeValue) {
		int readI = readInt();
		boolean valor = false;

		if (Integer.compare(readI, affirmativeValue) == 0) {
			valor = true;
		}
		return valor;
	}

	/**
	 * readBooleanUsingInt(): retorna el true or false dependiendo de si el digito
	 * introduciodo por el usuario es igual a 1 o cualquier otro numero. En el caso
	 * que el no sea igual a un digito, se le pedira al usuario que introduzca de
	 * nuevo un caracter hasta que introduzca un digito.
	 * 
	 * @see readInt()
	 * @return True si el caracter es igual 1, si no false
	 * @version 1.0
	 * @since 1.0
	 */

	public boolean readBooleanUsingInt() {
		int readI = readInt();
		boolean valor = false;

		if (readI == 1) {
			valor = true;
		}
		return valor;
	}
}
