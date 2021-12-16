package inteview.dictionaryAndHashmap;
import java.io.*;
import java.util.*;


public class SherlockAndAnagrams { // Hard

	
    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
    	int count = 0, len;
    	for (int i = 0; i < (s.length() - 1); i++) {
    		for (int j = i; j >= 0; j--) {
    			len = (i + 1) - j;
    			for (int k = j + 1; k <= (s.length() - len); k++) {
        			if (isAnagram(s.substring(j, j + len), s.substring(k, k + len))) {
        				count++;
        			}	
    			}
    		}
    	}
    	return count;
    }
    
    static boolean isAnagram(String s1, String s2) {
//    	System.out.println("s1 = " + s1 + ", s2 = " + s2);
    	if (s1.equals(s2)) {
    		return true;
    	}
    	boolean has = true;
    	StringBuilder s1Builder = new StringBuilder(s1);
    	StringBuilder s2Builder = new StringBuilder(s2);
    	int temp = 0;
    	ArrayList<Integer> indexList = new ArrayList<Integer>();

    	
    	for (int i = 0; i < s1Builder.length(); i++) {
    		temp = s2Builder.indexOf(s1Builder.substring(i, i + 1));
    		if (temp == -1) {
    			has = false;
    			break;
    		} else {
    			indexList.add(temp);
    			s2Builder.replace(temp, temp + 1, "0");
    		}
    	}
    	
    	if (has && indexList.size() > 1) {
        	Collections.sort(indexList);
        	for (int i = 0; i < (indexList.size() - 1); i++) {
        		if ((indexList.get(i + 1) - indexList.get(i)) != 1) {
        			has = false;
        			break;
        		}
        	}
    	}
    	
    	return has;
    }

    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);
            System.out.println(result);

//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

        scanner.close();
    }
}
