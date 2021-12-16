package inteview.array;

import java.util.*;


public class ArrayManipulation { // V. Hard - Cannot go in brute force approach

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
    	long[] a = new long[n];
    	Arrays.fill(a, 0);
    	
    	for (int i = 0; i < queries.length; i++) {
    		a[queries[i][0] - 1] += queries[i][2];
    		if (queries[i][1] != n) {
        		a[queries[i][1]] -= queries[i][2];
    		}
    	}
    	
    	long max = a[0];
    	for (int i = 1; i < a.length; i++) {
    		a[i] += a[i - 1];
    		if (a[i] > max) {
    			max = a[i];
    		}
    	}
    	    	
        return max;
    }
    
//    // Complete the arrayManipulation function below.
//    static long arrayManipulation(int n, int[][] queries) {
//    	long[] a = new long[n];
//    	Arrays.fill(a, 0);
//    	
//    	for (int i = 0; i < queries.length; i++) {
//    		for (int j = (queries[i][0] - 1); j < queries[i][1]; j++) {
//    			a[j] += queries[i][2];
//    		}
//    	}
//    	
//    	long max = a[0];
//    	for (int i = 1; i < a.length; i++) {
//    		if (a[i] > max) {
//    			max = a[i];
//    		}
//    	}
//    	System.out.println(max);
//    	
//        return max;
//    }
    


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);
        System.out.println(result);
        
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
