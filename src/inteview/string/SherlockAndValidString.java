package inteview.string;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class SherlockAndValidString {// Hard - Need to use map to keep count or use array properly

	
	static String isValid(String s) { // My own better approach
		if (s.length() == 1) {
			return "YES";
		}
		Integer[] a = new Integer[26];
		Arrays.fill(a, 0);
		int count = 0, i, nonZeroIndex;
		
		for (i = 0; i < s.length(); i++) {
			a[s.charAt(i) - 'a']++;
		}
		Arrays.sort(a, Collections.reverseOrder());

		count += (a[0] - a[1]);		
		for (nonZeroIndex = 25; nonZeroIndex >= 0; nonZeroIndex--) {
			if (a[nonZeroIndex] != 0) {
				break;
			}
		}				
		for (i = 1; i < nonZeroIndex - 1; i++) {
			if  ((a[i] - a[i + 1]) > 0) {
				return "NO";
			}
		}		
		if (nonZeroIndex > 0) {
			int temp = a[nonZeroIndex - 1] - a[nonZeroIndex];
			count += Math.min(temp, a[nonZeroIndex]);
		}		
		
		return (count > 1) ? "NO" : "YES";
	}
	
	// Complete the isValid function below.
	static String isValid2(String s) {
		Integer[] a = new Integer[26];
		Arrays.fill(a, 0);
		int count = 0, i, j;
		
		for (i = 0; i < s.length(); i++) {
			a[s.charAt(i) - 'a']++;
		}
		Arrays.sort(a, Collections.reverseOrder());

		if ((a[0] - a[1]) == 1) {
			a[0]--;
			count++;
		}
		for (i = 0; i < a.length - 1; i++) {
			for (j = i + 1; j < a.length; j++) {
				if (a[j] == 1 && ((j < a.length - 1) && (a[j + 1] == 0))) {
					a[j]--;
					count++;
				} else if (a[j] != 0) {
					count += (a[i] - a[j]);
				}
				if (count > 1) {
					return "NO";
				}
			}
		}
		
		return "YES";
	}
	
	static String isValid3(String s) { // This approach is efficient
		int[] a = new int[26];
		Arrays.fill(a, 0);
		String returnValue = "YES";
		TreeMap<Integer, Integer> countMap = new TreeMap<Integer, Integer>();

		for (int i = 0; i < s.length(); i++) {
			a[s.charAt(i) - 'a']++;
		}

		for (int i = 0; i < a.length; i++) {
			if (a[i] != 0) {
				Integer local = countMap.get(a[i]);
				if (local == null) {
					countMap.put(a[i], 1);
				} else {
					countMap.put(a[i], (local + 1));
				}
			}
		}
		
//		for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
//			System.out.println("Key = " + entry.getKey() + ", value = " + entry.getValue());
//		}
		
		
		if (countMap.size() == 1) {
			returnValue = "YES";
		} else if (countMap.size() == 2) {
			Entry<Integer, Integer> firstEntry = countMap.firstEntry();
			Entry<Integer, Integer> lastEntry = countMap.lastEntry();
			if ((firstEntry.getKey() == 1 && firstEntry.getValue() == 1) || (lastEntry.getValue() == 1 && ((lastEntry.getKey() - firstEntry.getKey()) == 1))) {
				returnValue = "YES";
			} else {
				returnValue = "NO";
			}
		} else {
			returnValue = "NO";
		}

		return returnValue;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = scanner.nextLine();

		String result = isValid(s);
		System.out.println(result);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

		scanner.close();
	}
}
