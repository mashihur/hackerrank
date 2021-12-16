package inteview.dictionaryAndHashmap;
import java.io.*;
import java.util.*;

public class FrequencyQueries {// V. Hard - For large input we cannot use contains..(...) method of HashMap and other data Structure
	// Both the below solutions follow the same approach
	
    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
    	ArrayList<Integer> outputList = new ArrayList<Integer>();
    	HashMap<Integer, Integer> queryMap = new HashMap<Integer, Integer>();
    	HashMap<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
    	int query, data, temp;
    	
    	for (int i = 0; i < queries.size(); i++) {
    		List<Integer> queryList = queries.get(i);
    		query = queryList.get(0);
    		data = queryList.get(1);
    		if (query == 1) {
    			temp = queryMap.getOrDefault(data, 0) + 1;
    			queryMap.put(data, temp);
    			frequencyMap.put(temp, frequencyMap.getOrDefault(temp, 0) + 1);
    			temp--;
    			if (temp != 0) {
    				frequencyMap.put(temp, frequencyMap.getOrDefault(temp, 1) - 1);
    			}    			
    		} else if (query == 2) {
    			if (queryMap.containsKey(data)) {
        			temp = queryMap.get(data) - 1;
    				if (temp > 0) {
    					queryMap.put(data, temp);
    					frequencyMap.put(temp, frequencyMap.getOrDefault(temp, 0) + 1);
    					temp++;
    					frequencyMap.put(temp, frequencyMap.getOrDefault(temp, 1) - 1);
    				} else {
    					queryMap.remove(data);
    					temp++;
    					frequencyMap.put(temp, frequencyMap.getOrDefault(temp, 1) - 1);
    				}
    			}
    		} else if (query == 3) {
    			Integer local = frequencyMap.get(data);
    			if (local != null && local > 0) {
    				outputList.add(1);
    			} else {
    				outputList.add(0);
    			}
    		}   		
    	}
    	
    	return outputList;
    }
    
    // Complete the freqQuery function below.
    static List<Integer> freqQuery2(List<List<Integer>> queries) {
    	ArrayList<Integer> outputList = new ArrayList<Integer>();
    	HashMap<Integer, Integer> queryMap = new HashMap<Integer, Integer>();
    	HashMap<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
    	
    	for (int i = 0; i < queries.size(); i++) {
    		List<Integer> queryList = queries.get(i);
    		int query = queryList.get(0);
    		int data = queryList.get(1);
    		if (query == 1) {
    			Integer local = queryMap.get(data);
    			Integer freq;
    			if (local != null) {
    				queryMap.put(data, (local + 1));
    				freq = frequencyMap.get(local);
    				if (freq > 0) {
    					frequencyMap.put(local, --freq);
    				}
    				
    				freq = frequencyMap.get(local + 1);
    				if (freq == null) {
    					frequencyMap.put((local + 1), 1);
    				} else {
    					frequencyMap.put((local + 1), ++freq);
    				}
    			} else {
    				queryMap.put(data, 1);
    				freq = frequencyMap.get(1);
    				if (freq == null) {
    					frequencyMap.put(1, 1);
    				} else {
    					frequencyMap.put(1, ++freq);
    				}
    			}    			    			
    		} else if (query == 2) {
    			Integer local = queryMap.get(data);
    			Integer freq;
    			if (local != null) {
    				if (local > 1) {
    					queryMap.put(data, (local - 1));
    					freq = frequencyMap.get(local);
        				if (freq > 1) {
        					frequencyMap.put(local, --freq);        					
        				} else {
        					frequencyMap.put(local, 0);
        				}
        				
        				freq = frequencyMap.get(local - 1);
        				frequencyMap.put((local - 1), ++freq); 
    				} else {
    					queryMap.remove(data);
    					freq = frequencyMap.get(local);
        				if (freq > 1) {
        					frequencyMap.put(local, --freq);        					
        				} else {
        					frequencyMap.put(local, 0);
        				}    					
    				}    				
    			}
    		} else if (query == 3) {
    			Integer local = frequencyMap.get(data);
    			if (local != null && local > 0) { // Cannot use containsValue(...) of queryMap here, that's why needed another map
    				outputList.add(1);
    			} else {
    				outputList.add(0);
    			}
    		}   		
    	}
    	
    	return outputList;
    }
    
//    static List<Integer> freqQuery(List<List<Integer>> queries) {
//    	ArrayList<Integer> outputList = new ArrayList<Integer>();
////    	HashMap<Integer, Integer> queryMap = new HashMap<Integer, Integer>();
//    	int[] queryArray = new int[1000000000];
//    	int[] valueArray = new int[100];
//    	Arrays.fill(queryArray, 0);
//    	Arrays.fill(valueArray, 0);
//    	
//    	for (int i = 0; i < queries.size(); i++) {
//    		List<Integer> queryList = queries.get(i);
//    		int query = queryList.get(0);
//    		int data = queryList.get(1);
//    		if (query == 1) {
//    			if (queryArray[data] == 0) {
//    				queryArray[data] = 1;
//    				valueArray[1] = data;
//    			} else {
//    				queryArray[data]++;
//    				valueArray[queryArray[data]] = data;
//    			}
//    		} else if (query == 2) {
//    			if (queryArray[data] > 0) {
//    				queryArray[data]--;
//    				valueArray[queryArray[data]] = data;
//    			}
//    		} else if (query == 3) {
//    			if (valueArray[data] > 0) {
//    				outputList.add(1);
//    			} else {
//    				outputList.add(0);
//    			}
//    		}
//    	}
//    	
//    	return outputList;
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            String[] queriesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> queriesRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                int queriesItem = Integer.parseInt(queriesRowTempItems[j]);
                queriesRowItems.add(queriesItem);
            }

            queries.add(queriesRowItems);
        }

        List<Integer> ans = freqQuery(queries);

        for (int i = 0; i < ans.size(); i++) {
//            bufferedWriter.write(String.valueOf(ans.get(i)));
            System.out.println(String.valueOf(ans.get(i)));

//            if (i != ans.size() - 1) {
//                bufferedWriter.write("\n");
//            }
        }

//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
