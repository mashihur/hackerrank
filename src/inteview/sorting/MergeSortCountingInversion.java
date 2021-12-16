package inteview.sorting;

import java.io.IOException;
import java.util.Scanner;

public class MergeSortCountingInversion {//V. Hard - Use of merge sort with with intelligent calculation of count

    // Complete the countInversions function below.
	static int count;
    static long countInversions(int[] arr) {
    	count = 0;
    	new MergeSortCountingInversion().mergeSort(arr, 0, arr.length - 1);
    	return count;
    }
    
	private void mergeSort(int[] a, int low, int high) {
		if (high > low) {
			int mid = (low + high) / 2;
			mergeSort(a, low, mid);
			mergeSort(a, mid + 1, high);
			merge(a, low, mid, high);
		}
			
	}
	
	private void merge(int[] a, int low, int mid, int high) {
		int[] b = new int[high - low + 1];
		int i = low, j = mid + 1, k = 0, l = 0;
		
		while(i <= mid && j <= high) {
			if (a[j] < a[i]) {
				b[k] = a[j];
				count += (j - i - l); // instead of using b if we swapped that would change the position of i, that's why l is required
				k++; j++; l++;
			} else {
				b[k] = a[i];
				k++; i++;
			}
		}
		
		while(i <= mid) {
			b[k++] = a[i++];
		}
		
		while(j <= high) {
			b[k++] = a[j++];
		}
		
		for (int p = 0; p < b.length; p++) {
			a[low + p] = b[p];
		}
	}


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);
            System.out.println(result);
//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

        scanner.close();
    }
}
