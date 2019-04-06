package openIT;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class modeUsingTextFileInput {

	public static int[] toIntArray(String s) {
		String[] newString = s.split(",");
		int length = newString.length;
		// System.out.println(newString);
		int[] n = new int[length];
		try {
			for (int i = 0; i < length; i++) {
				n[i] = Integer.parseInt(newString[i]);
				// System.out.println(n[i]);
			}
		} catch (NumberFormatException e) {
			System.out.println("N/A");
		}
		// System.out.println(n);
		return n;
	}

	public static int mode(int[] intArray) {
		int length = intArray.length;
		int count = 0;
		int maxSum = 0;
		int mode = 0;
		for (int i = 0; i < length; i++) {
			// 1,2,3,3,4,5
			count = 0;
			for (int j = i; j < length; j++) {
				if (intArray[i] == intArray[j]) {
					count = count + 1;
				}
			}
			if (count > maxSum) {
				maxSum = count;
				mode = intArray[i];
			}

		}
		return mode;

	}

	public static void main(String[] args) throws FileNotFoundException {
		int i = 0;
		int noOfLines;
		File file = new File(
				"C:\\StatisticsJava\\Statistics\\src\\openIT\\input.txt");
		Scanner sc = new Scanner(file);
		List<String> lines = new ArrayList<String>();
		while (sc.hasNextLine()) {
			lines.add(sc.next());

			//System.out.println(lines.get(i));
			i++;
		}

		noOfLines = i;
		//System.out.println("no. of Lines=" + noOfLines);
		sc.close();

		for (int x = 0; x < noOfLines; x++) {
			String line = lines.get(x);
			//System.out.println("line=" + line);
			int[] intArr = toIntArray(line);
			System.out.println(mode(intArr));
		}

	}

}
