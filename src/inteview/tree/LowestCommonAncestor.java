package inteview.tree;

import java.util.*;
import java.io.*;


public class LowestCommonAncestor { // Hard - Need to find the recursive function
									// Similar Leetcode problem - L235, L236

        public static Node lca(Node root, int v1, int v2) { //Better solution due to binary search tree
            if (root.data > v1 && root.data > v2) {
                return lca(root.left, v1, v2);
            }

            if (root.data < v1 && root.data < v2) {
                return lca(root.right, v1, v2);
            }

            return root;
        }
	
    //	public static Node lca(Node root, int v1, int v2) { // My solution, applicable for non binary search tree
    //		if (root == null || root.data == v1 || root.data == v2) {
    //			return root;
    //		}
    //
    //		Node leftNode, rightNode;
    //
    //		leftNode = lca(root.left, v1, v2);
    //		rightNode = lca(root.right, v1, v2);
    //
    //		if (leftNode != null && leftNode.data != v1 && leftNode.data != v2) {
    //			return leftNode;
    //		}
    //		if (rightNode != null && rightNode.data != v1 && rightNode.data != v2) {
    //			return rightNode;
    //		}
    //
    //		if ((leftNode != null && (leftNode.data == v1 || leftNode.data == v2)) && (rightNode != null && (rightNode.data == v1 || rightNode.data == v2))) {
    //			return root;
    //		}
    //
    //      	return (leftNode != null) ? leftNode : rightNode;
    //    }
	


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
      	int v1 = scan.nextInt();
      	int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }	
}