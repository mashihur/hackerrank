package inteview.sorting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FraudulentActivityNotifications {// Hard - Need to use map(I could also use array as there are 200 inputs) for large input
	
    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
    	int count = 0;
    	TreeMap<Integer, Integer> eMap = new TreeMap<Integer, Integer>();
    	    	
    	for (int i = 0; i < expenditure.length; i++) {
    		eMap.put(expenditure[i], eMap.getOrDefault(expenditure[i], 0) + 1);    		
    		if (i >= d && expenditure[i] >= getMedianDouble2(eMap, d, expenditure[i - d])) {
    			count++;
    		}
    	}
    		
    	return count;
    }
    
    static int getMedianDouble2(TreeMap<Integer, Integer> lMap, int l, int rValue) {
    	int  sum = 0, v1 = -1, v2 = -1, i1, i2;
    	float medianDouble;
    	boolean isEven = l % 2 == 0;

    	List<Integer> keyList = new ArrayList<Integer>(lMap.keySet());
    	List<Integer> valueList = new ArrayList<Integer>(lMap.values());
    	if (isEven) {
    		i1 = l / 2;
    		i2 = i1 + 1;
    	} else {
    		i1 = i2 = l / 2 + 1;
    	}
    	for (int i = 0; i < valueList.size(); i++) {
    		sum += valueList.get(i);
    		if (v1 == -1 && i1 <= sum) {
    			v1 = keyList.get(i);
    		}
    		if (v2 == -1 && i2 <= sum) {
    			v2 = keyList.get(i);
    			break;
    		}
    	}
    	
    	Integer temp = lMap.get(rValue);
    	if (temp > 1) {
    		lMap.put(rValue, --temp);
    	} else {
    		lMap.remove(rValue);
    	}
    	
    	medianDouble = (float)(v1 + v2) / 2;
    	medianDouble *= 2;
    	return (int)medianDouble;
    }
    
    static int getMedianDouble(TreeMap<Integer, Integer> lMap, int l, int rValue) {
    	int  count = 0, v1 = -1, v2 = -1;
    	float medianDouble;
    	boolean isEven = l % 2 == 0, isSet = false;
    	
//    	for (Map.Entry<Integer, Integer> entry : lMap.entrySet()) {
//    		System.out.print(entry.getKey() + " ");
//    	}
//    	System.out.println();
    	
    	for (Map.Entry<Integer, Integer> entry : lMap.entrySet()) {
    		count += entry.getValue();    		
    		if (isEven && count >= (l / 2) && !isSet) {
    			isSet = true;
    			v1 = entry.getKey();  
    			if (count > l/2) {
        			v2 = entry.getKey();
        			break;
        		}
    		} else if (count > l/2) {
    			v2 = entry.getKey();
    			break;
    		} 
    	}
    	
    	Integer temp = lMap.get(rValue);
    	if (temp > 1) {
    		lMap.put(rValue, --temp);
    	} else {
    		lMap.remove(rValue);
    	}
    	
    	medianDouble = isEven ? (float)(v1 + v2) / 2 : v2;
    	medianDouble *= 2;
//    	System.out.println("median = " + medianDouble + ", size = " + lMap.size());
//    	for (Map.Entry<Integer, Integer> entry : lMap.entrySet()) {
//    		System.out.print("key = " + entry.getKey() + ", value = " + entry.getValue() + " | ");
//    	}
    	return (int)medianDouble;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);
        System.out.println(result);
        
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
