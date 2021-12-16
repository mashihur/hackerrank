package inteview.stackAndQueue;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class LargestRectangle {// V. Hard - Intelligent use of stack, Specially to find out the multiply
	
	// Complete the largestRectangle function below.
	public static long largestRectangle(int[] h) {
		Stack<Integer> stack = new Stack<Integer>();
		long max = 0;
		int i, index, multiply;

		for (i = 0; i < h.length; i++) {
			if (stack.empty() || h[stack.peek()] <= h[i]) {
				stack.push(i);
			} else {
				while(!stack.empty() && h[stack.peek()] > h[i]) {
					index = stack.pop();
					multiply = (stack.empty()) ? i : (i - stack.peek() - 1);
					max = Math.max(max, (long) (h[index] * multiply));					
				}
				stack.push(i);
			}
		}

		while(!stack.empty()) {
			index = stack.pop();
			multiply = (stack.empty()) ? i : (i - stack.peek() - 1);
			max = Math.max(max, (long) (h[index] * multiply));	
		}

		return max;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] h = new int[n];

		String[] hItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int hItem = Integer.parseInt(hItems[i]);
			h[i] = hItem;
		}

		long result = largestRectangle(h);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
	
	/* Test Cases
	  	10
		10 2 7 5 9 4 6 8 2 1
		
		10
		10 4 7 5 9 3 6 8 2 1
	 */
}
