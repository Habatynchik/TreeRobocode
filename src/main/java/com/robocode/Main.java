package com.robocode;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println(7/2);
        Tree<Integer> integerTree = new TreeImpl<>();

        integerTree.add(1);
        integerTree.add(2);
        integerTree.add(3);
        integerTree.add(4);
        integerTree.add(5);
        integerTree.add(6);
        integerTree.add(7);

        System.out.println(integerTree.preOrder());
        integerTree.update();
        System.out.println(integerTree.preOrder());
        System.out.println(integerTree.inOrder());
        System.out.println(integerTree.postOrder());

    }
}