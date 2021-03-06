package com.example;

import java.util.Stack;

public class BSTShortestPath {


    public static void printTree(Tree tree, int count){

        if (tree == null) return;

        System.out.println(tree.x);

        if(tree.l != null) {
            for (int i = 0; i < count; i++) {
                System.out.print("LLL");
            }
            //System.out.println(tree.l.x);
            printTree(tree.l, count+1);
        }

        if(tree.r != null) {
            for (int i = 0; i < count; i++) {
                System.out.print("RRR");
            }
            //System.out.println(tree.r.x);
            printTree(tree.r, count+1);
        }

    }


    public boolean dfsShortestPath1(Tree root, int key, Stack<Integer> s) {

        if (root == null) return false;

        s.push(root.x);

        if (root.x == key) return true;

        if(dfsShortestPath1(root.l, key, s)) return true;
        if(dfsShortestPath1(root.r, key, s)) return true;

        s.pop();
        return false;
    }


    public boolean dfsShortestPath(Tree root, int key, Stack<Integer> s){

        if (root ==null) return false;
        s.push(root.x);
        if (root.x == key) return true;

        boolean ret = dfsShortestPath(root.l, key, s);
        if(!ret ) {
            if(root.l != null)
            s.pop();
            ret = dfsShortestPath(root.r, key, s);
            if(!ret && root.r !=null)
                s.pop();
        }

        return ret;
    }


    public boolean shortestPath(Tree root, int key, Stack<Integer> s){
        s.push(root.x);
        if (root.x == key) return true;
        if (root.l != null){
            if(shortestPath(root.l, key, s))
             return true;
        }
        if (root.r != null){
            if(shortestPath(root.r, key, s))
                return true;
        }
        s.pop();
        return false;
    }

    public static void main(String [] args){
        Tree test = new Tree(5,new Tree(3, new Tree(20, new Tree(6, null, null), null), null), new Tree(10, new Tree(1, null, null), new Tree(15, new Tree(30, null, new Tree(9, new Tree(4,null,null), null)), new Tree(8, null, null))));
        printTree(test, 1);
        Stack<Integer> s1 = new Stack<Integer>();
        obj.dfsShortestPath(test, 30, s1);


        Stack<Integer> s2 = new Stack<Integer>();
        obj.shortestPath(test, 30, s2);

        Stack<Integer> s3 = new Stack<Integer>();
        obj.dfsShortestPath1(test, 30, s3);

        System.out.println(s1.toString());
        System.out.println(s2.toString());
        System.out.println(s3.toString());
    }
}

class Tree {
    public int x;
    public Tree l;
    public Tree r;

    public Tree(int data, Tree l , Tree r){

        x = data;
        this.l = l;
        this.r = r;

    }
}
