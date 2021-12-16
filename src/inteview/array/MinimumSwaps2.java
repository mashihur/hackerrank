package inteview.array;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinimumSwaps2 { // V. Hard - Need to find the cycle no need to sort it to find the minimum swaps
	
	static int minimumSwaps(int[] a) { // This solution is similar to minimumSwaps4
		int minSwaps = 0, i, swaps, link;
		boolean[] visited = new boolean[a.length];
		
		for (i = 0; i < a.length; i++) {
			if (a[i] != (i + 1) && !visited[i]) {
				visited[i] = true;
				link = a[i] - 1;
				swaps = 0;
				while(!visited[link]) {
					visited[link] = true;
					link = a[link] - 1;
					swaps++;
				}
				minSwaps += (swaps);
			}
		}
		
		return minSwaps;
	}
	
	static int minimumSwaps4(int[] a) {
		int minSwaps = 0, i, swaps, link;
		int[] visited = new int[a.length];
		Arrays.fill(visited, 0);
		
		for (i = 0; i < a.length; i++) {
			if (a[i] != (i + 1) && visited[i] == 0) {
				link = i;
				swaps = 0;
				visited[link] = 1;
				while((a[link] - 1) != i) {
					link = a[link] - 1;
					visited[link] = 1;
					swaps++;
				}
				minSwaps += (swaps);
			}
		}
		
		return minSwaps;
	}
	
	
/////////////////////////////// This solution sort the array, which is not required ///////////////////////////////////////////////	
    static int minimumSwaps2(int[] a) {
        int minSwaps = 0, index, swapIndex1, swapIndex2, link;
        LinkedList<Integer> list = new LinkedList<Integer>();

        for(index = 0; index < a.length; index++) {        	
        	if (a[index] == index + 1) {
        		continue;
        	} 
        	
        	link = index;
        	while(list.isEmpty() || (list.peek() != link)) {
        		list.add(link);   
//        		System.out.println("Added "  + link);
        		link = a[link] - 1;        		
        	}
        	
        	swapIndex1 = list.pollLast();
    		while(!list.isEmpty()) {
    			swapIndex2 = list.pollFirst();
        		swap(a, swapIndex1, swapIndex2);
        		minSwaps++;
//        		Helpful.printArray(a);
        	}
        	
        }
        
        return minSwaps;
    }
    
	private static void swap(int[] a, int i, int j) {
		a[i] = a[i] ^ a[j];
		a[j] = a[i] ^ a[j];
		a[i] = a[i] ^ a[j];
	}
/////////////////////////////// This solution sort the array, which is not required ///////////////////////////////////////////////
	
/////////////////////////////// Inefficient Solution ///////////////////////////////////////////////    
    static int minimumSwaps3(int[] a) {
        int minSwaps = 0, index = 0;

        while(index < (a.length - 1)) {        	
            for (int i = index; i < a.length; i++) {            
            	if(a[i] == (index + 1)) {
            		if (i != index) {
            			a[index] = a[index] ^ a[i];
        			    a[i] = a[index] ^ a[i];
        			    a[index] = a[index] ^ a[i];  
        			    minSwaps++;
            		}
            		index++;
            		break;
            	}
            }           
        }
        return minSwaps;
    }
///////////////////////////// Inefficient Solution ///////////////////////////////////////////////    


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);
        System.out.println(res);

//        bufferedWriter.write(String.valueOf(res));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
    
    
}
