package inteview.string;

import java.io.*;
import java.util.*;

public class SpecialStringAgain {// Hard - cannot go for O(n^3) solution

	static long substrCount2(int n, String s) {// Both the solutions are similar
    	long totalCount = s.length(), count = 1;
    	int i, j;
    	
    	for (i = 0; i < s.length() - 1; i++) {
    		char value = s.charAt(i);
    		if (value == s.charAt(i + 1)) {
    			count++;
    		} else {
    			if (count > 1) {
    				totalCount += (count * (count - 1)) / 2;
    			}
    			
    			for (j = 1; j <= count; j++) {
    				int temp = i + j + 1;
    				if (temp < s.length() && s.charAt(temp) == value) {
    					totalCount++;
    				} else {
    					break;
    				}
    			}
    			count = 1;
    		}
    	}
    	
    	if (count > 1) {
			totalCount += (count * (count - 1)) / 2;
		}
    	
    	return totalCount;
    }
	
    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
    	long totalCount = s.length(), count1 = 1;
    	int j, k;
    	
    	for (int i = 0; i < s.length() - 1; i++) {
    		if (s.charAt(i) == s.charAt(i + 1)) {
    			count1++;
    		} else {
    			if (count1 > 1) {
    				totalCount += (count1 * (count1 - 1)) / 2;
    				count1 = 1;
    			}
    			j = i;
    			k = i + 2;
    			char temp = s.charAt(j);
    			while(j >= 0 && k < s.length()) {
    				if ((s.charAt(j) == temp) && (s.charAt(k) == temp)) {
    					totalCount++;
    					j--;
    					k++;
    				} else {
    					break;
    				}
    			}  
//    			System.out.println(s.charAt(i + 1) + ", totalCount = " + totalCount);
    		}
    	}
    	
    	if (count1 > 1) {
			totalCount += (count1 * (count1 - 1)) / 2;
		}
    	
    	return totalCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
