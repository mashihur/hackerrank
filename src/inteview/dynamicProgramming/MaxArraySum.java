package inteview.dynamicProgramming;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MaxArraySum { // Medium - main trick is to find out the dynamic programming formula

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
    	if (arr.length == 1) {
    		return arr[0];
    	}
    	int i, max;
    	int[] dp = new int[arr.length];
    	dp[0] = arr[0];
    	dp[1] = Math.max(arr[0], arr[1]);
    	for (i = 2; i < arr.length; i++) {
    		max = Math.max(arr[i], (dp[i - 2] + arr[i]));
    		dp[i] = Math.max(max, dp[i - 1]);
    	}
    	    	
    	return dp[dp.length - 1];
    }
    
//    static int maxSubsetSum2(int[] arr) {
//    	if (arr.length == 1) {
//    		return arr[0];
//    	}
//    	int i, max;
//    	int[] dp = new int[arr.length];
//    	dp[0] = arr[0];
//    	dp[1] = Math.max(arr[0], arr[1]);
//    	if (arr.length > 2) {
//    		dp[1] = Math.max(arr[0], arr[1]);
//    	}
//    	for (i = 2; i < arr.length; i++) {
//    		max = Math.max(arr[i], (dp[i - 2] + arr[i]));
//    		dp[i] = Math.max(max, dp[i - 1]);
//    	}
//    	    	
//    	return dp[dp.length - 1];
//    }
    


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

