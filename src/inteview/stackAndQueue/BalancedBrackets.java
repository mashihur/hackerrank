package inteview.stackAndQueue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {// Hard- Need to use stack and Map both
	
    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (map.containsKey(temp)) {
                stack.push(temp);
            } else if (!stack.isEmpty() && map.get(stack.peek()) == temp) {
                stack.pop();
            } else {
                return "NO";
            }
        }
        
        return (stack.size() == 0) ? "YES" : "NO"; 
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
    	int count = 1;
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);
            System.out.println(count + " " + result);
            count++;

//            bufferedWriter.write(result);
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

        scanner.close();
    }
}
