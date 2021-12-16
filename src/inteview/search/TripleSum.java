package inteview.search;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class TripleSum { // V. Hard - Need to use map and get rid of duplicate elements (my approach)
	                     // V. Hard - Need to remove duplicate elements & binary search to get the index (Hackerrank)

	static long triplets(int[] a, int[] b, int[] c) {// Better approach
		long count = 0;
		int i;

		Integer[] ar = removeDuplicates(a);
		Integer[] br = removeDuplicates(b);
		Integer[] cr = removeDuplicates(c);

		Arrays.sort(ar);
		Arrays.sort(br);
		Arrays.sort(cr);

		for ( i = 0; i < br.length; i++) {
			int aCount = getIndexByBinarySearch(ar, br[i]);
			int cCount = getIndexByBinarySearch(cr, br[i]);
//    		System.out.println("key = " + br[i] + ", aCount = " + aCount + ", cCount = " + cCount);
			count += (aCount) * (cCount);
		}


		return count;
	}

	private static Integer[] removeDuplicates(int[] ar) { // Duplicates can be removed using HashSet if array is not sorted
		HashSet<Integer> set = new HashSet<Integer>();
		int i;

		for (i = 0; i < ar.length; i++) {
			set.add(ar[i]);
		}
    	Integer[] output = new Integer[set.size()];
    	set.toArray(output);
		return output;
	}


	private static int getIndexByBinarySearch(Integer[] a, int key) { // This is similar to Helpful.getEqualOrLowerIndex(..),  In that case returned value should be incremented once before multiplying
		int low = 0, high = a.length - 1, mid = 0, count = 0;

		while(high >= low) {
			mid = (high + low) / 2;
			if (a[mid] > key) {
				high = mid - 1;
			} else if (a[mid] <= key) {
				low = mid + 1;
				count = low;
			}
		}

		return count;
	}

    // Complete the triplets function below.
    static long triplets2(int[] a, int[] b, int[] c) {
    	long count = 0, temp = 0;
    	int p, j, k;
    	HashMap<Integer, Long> map = new HashMap<Integer, Long>();
    	
    	Integer[] ar = removeDuplicates(a);
    	Integer[] br = removeDuplicates(b);
    	Integer[] cr = removeDuplicates(c);
    	
    	Arrays.sort(ar);
    	Arrays.sort(br);
    	Arrays.sort(cr);    	    	
    	
    	for (j = 0, k = 0; j < br.length; j++) {
    		while(k < cr.length && cr[k] <= br[j]) {    			
    			count++;
    			k++;
    		}
    		
    		if (j == 0) {
    			map.put(br[j], count);
    		} else {
        		map.put(br[j], count + map.get(br[j - 1]));
    		}    		
//    		System.out.println("key = " + br[j] + ", value = " + map.get(br[j]));
    	}
    	
    	count = 0;   
    	temp = 0;
    	for (p = 0, j = 0; p < ar.length; p++) {    		    		
    		while(j < br.length && br[j] < ar[p]) {
    			j++;
    		}  
    		
    		if (j == 0) {
    			count += map.get(br[br.length - 1]);
    		} else if (j < br.length) {
    			temp = map.get(br[j - 1]);
        		count += (map.get(br[br.length - 1]) - temp);    			
    		}    		
    	}
    	    	
    	return count;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);
        System.out.println(ans);
//        bufferedWriter.write(String.valueOf(ans));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
