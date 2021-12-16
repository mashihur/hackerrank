package inteview.string;

import java.io.IOException;
import java.util.Scanner;

public class CommonChild { // Hard - Longest Common Subsequence

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
    	int[][] a = new int[s1.length() + 1][s2.length() + 1];

    	for (int i = 1; i <= s1.length(); i++) {
    		for (int j = 1; j <= s2.length(); j++) {
        		if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
        			a[i][j] = a[i - 1][j - 1] + 1;
        		} else {
        			a[i][j] = Math.max(a[i - 1][j], a[i][j - 1]);
        		}
        	}
    	}
    	
    	/////////////// LCS print sequence //////////////////////
//    	int i = s1.length(), j = s2.length();
//    	while(i > 0 && j > 0) {
//    		if (a[i][j] == a[i][j - 1]) {
//    			j--;
//    		} else {
//    			builder.append(s2.charAt(j - 1));
//    			i--;
//    			j--;
//    		}
//    	}
//    	builder.reverse();
//    	System.out.println(builder.toString());
    	///////////////////////////////////////////////////////////    	    
    	
    	return a[s1.length()][s2.length()];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
