package com.robocode;

import java.util.ArrayList;
import java.util.List;

public class TreeImpl<E extends Comparable<E>> implements Tree<E> {
    private Node<E> root;


    @Override
    public synchronized void add(E element) {
        root = add(root, element);
    }

    private Node<E> add(Node<E> current, E element) {
        if (current == null) {
            return new Node<>(element);
        }

        if (element.compareTo(current.getValue()) > 0) {
            current.setRightNode(add(current.getRightNode(), element));
        } else if (element.compareTo(current.getValue()) < 0) {
            current.setLeftNode(add(current.getLeftNode(), element));
        } else {
            return current;
        }

        return current;
    }

    @Override
    public void delete(E element) {

    }

    @Override
    public void update() {
        List<E> list = inOrder();
        root = null;
        int mediana = (list.size() ) / 2;

        for (int i = mediana; i < list.size(); i++) {
            root = add(root, list.get(i));
            root = add(root, list.get((list.size() - 1) - i));

            System.out.println(list.get(i));
            System.out.println(list.get((list.size() - 1) - i));
        }
    }

    @Override
    public Node<E> find(E element) {
        return find(root, element);
    }

    private Node<E> find(Node<E> current, E element) {
        if (element.compareTo(current.getValue()) > 0) {
            return find(current.getRightNode(), element);
        } else if (element.compareTo(current.getValue()) < 0) {
            return find(current.getLeftNode(), element);
        }
        return current;
    }

    @Override
    public List<E> preOrder() {
        List<E> list = new ArrayList<>();

        preOrder(root, list);

        return list;
    }

    private void preOrder(Node<E> node, List<E> list) {
        if (node != null) {
            list.add(node.getValue());
            inOrder(node.getLeftNode(), list);
            inOrder(node.getRightNode(), list);
        }
    }

    @Override
    public List<E> inOrder() {
        List<E> list = new ArrayList<>();

        inOrder(root, list);

        return list;
    }

    private void inOrder(Node<E> node, List<E> list) {
        if (node != null) {
            inOrder(node.getLeftNode(), list);
            list.add(node.getValue());
            inOrder(node.getRightNode(), list);
        }
    }

    @Override
    public List<E> postOrder() {
        List<E> list = new ArrayList<>();

        postOrder(root, list);

        return list;
    }

    private void postOrder(Node<E> node, List<E> list) {
        if (node != null) {
            inOrder(node.getLeftNode(), list);
            inOrder(node.getRightNode(), list);
            list.add(node.getValue());
        }
    }
}
