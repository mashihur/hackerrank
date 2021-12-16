package inteview.greedyAlgorithm;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ReverseShuffleMerge {

    // Complete the reverseShuffleMerge function below.
    static String reverseShuffleMerge(String s) {
        int i, j;
        char temp = s.charAt(s.length() - 1), temp2;
        ArrayList<Character> result = new ArrayList<Character>();
        int[] limit = new int[26];
        Arrays.fill(limit, 0);
        int[] output = new int[26];
        Arrays.fill(output, 0);
        int[] reject = new int[26];
        Arrays.fill(reject, 0);

        for (i = 0; i < s.length(); i++) {
            limit[s.charAt(i) - 'a']++;
        }
        for (i = 0; i < 26; i++) {
            limit[i] = limit[i] / 2;
//            if (limit[i] != 0) {
////                System.out.printf("%c = %d \n", (i + 'a'), limit[i]);
//            }
        }

        for (i = s.length() - 1; i >= 0; i--) {
            temp = s.charAt(i);
            if (limit[temp - 'a'] > output[temp - 'a']) {
                while (result.size() > 0 && result.get(result.size() - 1) > temp) {
                    temp2 = result.get(result.size() - 1);
                    if(limit[temp2 - 'a'] > reject[temp2 - 'a']) {
                        result.remove(result.size() - 1);
//                        System.out.println("removed = " + temp2);
                        reject[temp2 - 'a']++;
                        output[temp2 - 'a']--;
                    } else {
                        break;
                    }
                }
//                System.out.println("added = " + temp);
                result.add(temp);
                output[temp - 'a']++;
            } else {
                reject[temp - 'a']++;
            }
        }


        StringBuilder builder = new StringBuilder();
        for (Character character : result) {
            builder.append(character);
        }

        return builder.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = reverseShuffleMerge(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
