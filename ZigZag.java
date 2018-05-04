package com.example;

import java.util.Stack;

public class ZigZag {

    public int solution(Tree T) {
        return Math.max(zigZag(T.l,"L"), zigZag(T.r,"R"));
    }

    public int zigZag(Tree T , String prev){

        if (T == null) return 0;

        if(prev.equals("R")) {
            int count = zigZag(T.l, "L");
            return Math.max( count + 1, zigZag(T.r, "R"));
        }
        else {
            int count = zigZag(T.r, "R");
            return Math.max(zigZag(T.l, "L"),  count + 1);
        }

    }

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

    public static void main(String [] args){
        ZigZag obj = new ZigZag();
        Tree test = new Tree(5,new Tree(3, new Tree(20, new Tree(6, null, null), null), null), new Tree(10, new Tree(1, null, null), new Tree(15, new Tree(30, null, new Tree(9, new Tree(4,null,null), null)), new Tree(8, null, null))));
        System.out.println(obj.solution(test));
        printTree(test, 1);


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