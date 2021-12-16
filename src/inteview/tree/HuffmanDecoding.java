package inteview.tree;

import java.util.*;

// Hard - Solution is easy, understanding the problem is difficult

abstract class Node3 implements Comparable<Node3> {
    public  int frequency; // the frequency of this tree
    public  char data;
    public  Node3 left, right; 
    public Node3(int freq) { 
      frequency = freq; 
    }
 
    // compares on the frequency
    public int compareTo(Node3 tree) {
        return frequency - tree.frequency;
    }
}
 
class HuffmanLeaf extends Node3 {
    
 
    public HuffmanLeaf(int freq, char val) {
        super(freq);
        data = val;
    }
}
 
class HuffmanNode extends Node3 {
    
    public HuffmanNode(Node3 l, Node3 r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }

}


class Decoding {

/*  
	class Node
		public  int frequency; // the frequency of this tree
    	public  char data;
    	public  Node left, right;
    
*/ 

	void decode(String s, Node3 root) {
        StringBuilder output = new StringBuilder();
        Node3 tempNode = root;
        int i;
        char tempChar;
        
        for (i = 0; i < s.length(); i++) {
            tempChar = s.charAt(i);
            if (tempChar == '1') {
                tempNode = tempNode.right;
            } else if (tempChar == '0') {
                tempNode = tempNode.left;
            }
            if (tempNode.left == null && tempNode.right == null) {
                output.append(tempNode.data);
                tempNode = root;                
            }
        }
            
        System.out.println(output.toString());
    }



}

 
public class HuffmanDecoding {
  
    // input is an array of frequencies, indexed by character code
    public static Node3 buildTree(int[] charFreqs) {
      
        PriorityQueue<Node3> trees = new PriorityQueue<Node3>();
        // initially, we have a forest of leaves
        // one for each non-empty character
        for (int i = 0; i < charFreqs.length; i++)
            if (charFreqs[i] > 0)
                trees.offer(new HuffmanLeaf(charFreqs[i], (char)i));
 
        assert trees.size() > 0;
      
        // loop until there is only one tree left
        while (trees.size() > 1) {
            // two trees with least frequency
        	Node3 a = trees.poll();
        	Node3 b = trees.poll();
 
            // put into new node and re-insert into queue
            trees.offer(new HuffmanNode(a, b));
        }
      
        return trees.poll();
    }
  
    public static Map<Character,String> mapA=new HashMap<Character ,String>();
  
    public static void printCodes(Node3 tree, StringBuffer prefix) {
      
        assert tree != null;
      
        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf)tree;
 
            // print out character, frequency, and code for this leaf (which is just the prefix)
            //System.out.println(leaf.data + "\t" + leaf.frequency + "\t" + prefix);
            mapA.put(leaf.data,prefix.toString());

        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode)tree;
 
            // traverse left
            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length()-1);
 
            // traverse right
            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }
 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
    
        String test= input.next();
 
        // we will assume that all our characters will have
        // code less than 256, for simplicity
        int[] charFreqs = new int[256];
      
        // read each character and record the frequencies
        for (char c : test.toCharArray())
            charFreqs[c]++;
 
        // build tree
        Node3 tree = buildTree(charFreqs);
 
        // print out results
        printCodes(tree, new StringBuffer());
        StringBuffer s = new StringBuffer();
      
        for(int i = 0; i < test.length(); i++) {
          	char c = test.charAt(i);
            s.append(mapA.get(c));
        }
      
        //System.out.println(s);
        Decoding d = new Decoding();
        d.decode(s.toString(), tree);

    }
}