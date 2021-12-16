package inteview.search;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class IceCreamParlor {// Hard - Can't go brute force. Use of binary search and mapping two arrays

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
    	int i, l, h, mid = 0, item, j, id1 = 0, id2 = 0;
    	int[] copy = cost.clone();
    	boolean found = false;
    	Arrays.parallelSort(cost);    	
    	
    	for (i = 0; i < cost.length - 1; i++) {
    		l = i + 1;
    		h = cost.length - 1;
    		item = money - cost[i];
    		/////////////// Binary search can be done using Java's default method ///////////////////
//    		mid = Arrays.binarySearch(cost, i + 1, cost.length - 1, item);
//    		if (mid > i && mid < cost.length && cost[mid] == item) {
//    			found = true;
//    			break;
//    		}
    		//////////////////////////////////////////////////////////////////////////////////////////
    		while(h >= l) {
    			mid = (l + h) / 2;    			
    			if (item > cost[mid]) {
    				l = mid + 1;    				
    			} else if (item < cost[mid]) {
    				h = mid - 1;    				
    			} else {
    				found = true;
    				break;
    			}
    		}
    		if (found) {
    			break;
    		}
    	}
    	
    	for (j = 0; j < copy.length; j++) {
    		if (id1 > 0 && id2 > 0) {
    			break;
    		} else {
    			if (id1 == 0 && copy[j] == cost[i]) {
    				id1 = j + 1;
    			} else if (copy[j] == cost[mid]) {
    				id2 = j + 1;
    			}
    		}
    	}
    	
    	if (id2 < id1) {
    		id1 = id1 ^ id2;
    		id2 = id1 ^ id2;
    		id1 = id1 ^ id2;
    	}
    	
    	System.out.println(id1 + " " + id2);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
