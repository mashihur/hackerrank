package inteview.dictionaryAndHashmap;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountTriplets { // Hard - Trick is important when input size is high [long and int should not be mixed up for long value]

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
    	long count = 0, temp;
    	HashMap<Long, Long> prevMap = new HashMap<Long, Long>();
    	HashMap<Long, Long> nextMap = new HashMap<Long, Long>();
    	
    	for (int i = 1; i < arr.size(); i++) {
			nextMap.put(arr.get(i), nextMap.getOrDefault(arr.get(i), 0l) + 1);    		
    	}    	
    	prevMap.put(arr.get(0), (long) 1);
    	
    	for (int i = 1; i < (arr.size() - 1); i++) {
    		temp = arr.get(i);    	
    		long local = nextMap.get(temp);
    		if (local > 1) {
    			nextMap.put(temp, --local);
    		} else {
    			nextMap.remove(temp);
    		}
    		
    		if (temp % r == 0 && prevMap.containsKey(temp / r) && nextMap.containsKey(temp * r)) {
    			count += (prevMap.get(temp / r) * nextMap.get(temp * r));
    		} 
    		
    		prevMap.put(temp, prevMap.getOrDefault(temp, 0l) + 1);
    	}

    	return count;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Long> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr.add(arrItem);
        }

        long ans = countTriplets(arr, r);
        System.out.println(ans);

//        bufferedWriter.write(String.valueOf(ans));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}

