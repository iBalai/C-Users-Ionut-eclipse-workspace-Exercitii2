
public class Numbers {
	public static void main(String args[]) {
		System.out.println("Cel mai mic nr dintre cele  date este:" + smallest(12, 33, 4));
		System.out.println("the middle of the string is:" + middle("cuvant"));
		System.out.println("Numarul de vocale din string este:" + vowel("cuvant"));
		System.out.println("Suma cifrelor este:" + sum_digits(535));
		for (int i = 2; i < 100; i++) {

			if (is_Prime(i) && is_Prime(i + 2)) {
				System.out.printf("(%d, %d)\n", i, i + 2);
			}
		}
		System.out.println("Suma dupa un nr dat de ani este:" + investment(3, 1000, 10));
		System.out.println("Leap year?" + leapYear(2016));
		int[] array = new int[] { 12, 2, 55, 23, 12 };
		duplicate(array); // apelam metoda duplicate
		int weekday = 5;
		switch (weekday) { // un switch care ne returneaza ziua saptamanii in functie de valoarea pe care o
							// alegem de la 1 la 7
		case 1:
			System.out.println("Luni");
			break;
		case 2:
			System.out.println("Marti");
			break;
		case 3:
			System.out.println("Miercuri");
			break;
		case 4:
			System.out.println("joi");
			break;
		case 5:
			System.out.println("Vineri");
			break;
		case 6:
			System.out.println("Sambata");
			break;
		case 7:
			System.out.println("Duminica");
			break;
		}
		// System.out.print("Floyd's Triangle:" + printFloydTriangle(5));
		printFloydTriangle(5);

		int arr[] = { 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9 };
		int n = arr.length;
		pushZerosToEnd(arr, n);
		System.out.println("Array after pushing zeros to the back: ");
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println("");
		System.out.println("Suma cifrelor din string este:");
		getvalues("fsr4h7hd64f5");
		System.out.println("in binar:" + Integer.toBinaryString(402));
		System.out.println("Cea mai lunga secventa de 2 este:");
		solution(402);
		System.out.println("Suma a 3 numere este:" + suma(2, 5, 7));
	}

	public static int smallest(int a, int b, int c) { // metoda care returneaza minimul dintre nr
		int min = a;
		if (b < a) {
			min = b;
		}
		if (c < min) {
			min = c;
		}
		return min;
	}

	public static String middle(String str) { // metoda care returneaza caracterul din mijlocul unui string
		int position;
		int length;
		if (str.length() % 2 == 0) {
			position = str.length() / 2 - 1;
			length = 2;
		} else {
			position = str.length() / 2;
			length = 1;
		}
		return str.substring(position, position + length);
	}

	public static int vowel(String str2) { // metoda care returneaza nr de vocale dintr-un string
		int count = 0;
		for (int i = 0; i < str2.length(); i++) {
			if (str2.charAt(i) == 'a' || str2.charAt(i) == 'e' || str2.charAt(i) == 'i' || str2.charAt(i) == 'o'
					|| str2.charAt(i) == 'u') {
				count++;
			}

		}

		return count;
	}

	public static int sum_digits(int n) { // metoda care returneaza suma cifrelor unui nr
		int sum = 0;
		int c = 0;
		while (n != 0) {
			c = n % 10;
			n = n / 10;
			sum += c;
		}
		return sum;
	}

	public static boolean is_Prime(long n) { // metoda care returneaza toate nr prime mai mici de 100

		if (n < 2)
			return false;

		for (int i = 2; i <= n / 2; i++) {

			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static double investment(int durata, double investitie, double dobanda) {
		double profit = 0;
		double profit2 = investitie;
		double bani = 0;
		for (int i = 1; i <= durata; i++) {
			profit = profit + (dobanda / 100) * profit2;
			profit2 = profit2 + profit;
		}
		bani = profit + investitie;
		return bani;
	}

	static boolean leapYear(int year) { // metoda care verifica daca un an este sau nu bisect

		if (year % 4 != 0) {
			return false;
		}

		else if (year % 100 == 0 && year % 400 != 0) {
			return false;
		}

		else if (year % 400 == 0) {
			return true;
		} else {
			return true;
		}

	}

	static void duplicate(int array[]) { // metoda care gaseste duplicatele dintr-un array
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < array.length; j++) {
				if (array[i] == array[j] && (i != j)) {
					System.out.println(array[i]);

				}
			}

		}

	}

	public static void printFloydTriangle(int rows) {
		int number = 1;
		System.out.printf("Floyd's triangle of %d rows is : %n", rows);
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(number + " ");
				number++;
			}
			System.out.println();
		}
	}

	static void pushZerosToEnd(int arr[], int n) {
		int count = 0; // Count of non-zero elements

		for (int i = 0; i < n; i++)
			if (arr[i] != 0)
				arr[count++] = arr[i];

		while (count < n)
			arr[count++] = 0;
	}

	public static void getvalues(String s1) { // metoda care calculeaza suma cifrelor dintr-un string
		int sum = 0;
		for (int i = 0; i < s1.length(); i++) {
			char a = s1.charAt(i);
			if (Character.isDigit(a)) {
				int b = Integer.parseInt(String.valueOf(a));
				sum = sum + b;
			}
		}
		if (sum == 0) {
			System.out.println(-1);
		} else
			System.out.println(sum);
	}

	public static int solution(int n) { // metoda care returneaza cea mai lunga secventa de zerouri dintr-un integru
										// reprezentat binar
		int max = 0;
		String binaryString = Integer.toBinaryString(n);
		char[] characters = binaryString.toCharArray();
		int counter = 0;
		Character c;
		for (int i = 0; i < characters.length; i++) {
			c = characters[i];
			if (c.equals('0')) {
				counter++;
				if (max < counter) {
					max = counter;
				}
			} else
				counter = 0;

		}
		System.out.println(max);
		return max;

	}

	public static int suma(int a, int b, int c) {
		int s = 0;
		if (a != 5 && b != 5 && c != 5) {
			s = a + b + c;
		} else if (a == 5 && b != 5 && c != 5) {
			s = b + c;
		} else if (a != 5 && b == 5 && c != 5) {
			s = a + c;
		} else if (a != 5 && b != 5 && c == 5) {
			s = a + b;
		} else if (a == 5 && b == 5 && c != 5) {
			s = c;
		} else if (a == 5 && b != 5 && c == 5) {
			s = b;
		} else if (a != 5 && b == 5 && c == 5) {
			s = a;
		} else {
			s = 0;
		}
		return s;
	}
}
