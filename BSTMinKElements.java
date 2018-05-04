package com.example;

import java.util.ArrayList;

public class BSTMinKElements {

    public ArrayList<Integer> minK(Node node, int k){
        ArrayList<Integer> list = new ArrayList<Integer>();

        if (node == null) return list;

        ArrayList<Integer> leftList = minK(node.left, k);
        if (leftList.size() == k) return leftList;
        leftList.add(node.data);
        if (leftList.size() < k) {
            ArrayList<Integer> rightList = minK(node.right, k);
            int i=0;
            while(leftList.size() < k){
                if(i == rightList.size()) break;
                leftList.add(rightList.get(i));
                i++;
            }
        }
        return leftList;
    }

    public static void main(String [] args) {
        Node root = new Node(10, null, null);
        root.left = new Node(5, new Node(4, null, null), new Node(7, null, null));
        root.right = new Node(18, null, null);
        BSTMinKElements obj = new BSTMinKElements();
        System.out.println("BSTMIN " + obj.minK(root, 2));
    }
}

class Node {

    int data;
    Node left;
    Node right;

    public Node(int data, Node left, Node right){
        this.data = data;
        this.right = right;
        this.left= left;
    }
}


