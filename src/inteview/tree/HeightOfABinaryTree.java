package inteview.tree;

import java.util.*;
import java.io.*;

class HeightOfABinaryTree {

    public static int height(Node root) {
        if (root == null) {
            return -1;
        }
          return 1 + Math.max(height(root.left), height(root.right));
    }
	
    ///////////////////////////////////////////////////////////////////////////////////////
    public static int height2(Node root) { //  My first approach
        return getMaxHeight(root, 0);
    }    
	public static int getMaxHeight(Node root, int height) {
		int leftHeight = height, rightHeight = height;
      	if (root.left != null) {
      		leftHeight = getMaxHeight(root.left, height + 1);
      	}
      	if (root.right != null) {
      		rightHeight = getMaxHeight(root.right, height + 1);
      	}
      	
      	return (leftHeight > rightHeight) ? leftHeight : rightHeight;
    }
	
	


	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
        	Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }	
}