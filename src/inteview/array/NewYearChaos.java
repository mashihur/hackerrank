package inteview.array;

import java.util.Scanner;

public class NewYearChaos { // Hard - Need to focus to the point as per specification

	static void minimumBribes(int[] a) {
		boolean chaos = false;
		int bribeCount = 0, i;

		for (i = a.length - 1; i > 0; i--) {
			int position = i + 1;
			if (a[i] == position) {
				continue;
			} else if (a[i - 1] == position) {
				swap(a, i - 1, i);
				bribeCount++;
			} else if (i > 1 && a[i - 2] == position) {
				swap(a, i - 2, i - 1);
				swap(a, i - 1, i);
				bribeCount += 2;
			} else {
				chaos = true;
				break;
			}
		}

//		if (a[0] != 1) {
//			swap(a, 0, 1);
//			bribeCount++;
//		}

		if (chaos) {
			System.out.println("Too chaotic");
		} else {
			System.out.println(bribeCount);
		}
	}

	private static void swap(int[] a, int i, int j) {
		a[i] = a[i] ^ a[j];
		a[j] = a[i] ^ a[j];
		a[i] = a[i] ^ a[j];
	}

	/////////////////////////////////// Previous solution
	/////////////////////////////////// ////////////////////////////////////////////
	static void minimumBribes2(int[] a) {
		boolean chaos = false;
		int bribeCount = 0, temp, index = 0;

		for (int i = 0; i < a.length; i++) {
			temp = i + 3;
			if (a[i] > temp) {
				chaos = true;
				break;
			}
		}
		if (chaos) {
			System.out.println("Too chaotic");
			return;
		}

		while (index < (a.length - 1)) {
			for (int i = index; i < (a.length - 1); i++) {
				if (a[i] > a[i + 1]) {
					a[i] = a[i] ^ a[i + 1];
					a[i + 1] = a[i] ^ a[i + 1];
					a[i] = a[i] ^ a[i + 1];
					bribeCount++;
				}
				if (i == index && a[i] == (i + 1)) {
					index++;
				}
			}
		}

		System.out.println(bribeCount + "");
	}
	/////////////////////////////////// Previous solution
	/////////////////////////////////// ////////////////////////////////////////////

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] q = new int[n];

			String[] qItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int qItem = Integer.parseInt(qItems[i]);
				q[i] = qItem;
			}

			minimumBribes(q);
		}

		scanner.close();
	}
}
