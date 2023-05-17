package com.robocode;

import java.util.List;

public interface Tree<E extends Comparable<E>> {

    void add(E element);

    void delete(E element);

    void update();

    Node<E> find(E element);

    List<E> preOrder();

    List<E> inOrder();

    List<E> postOrder();
}
