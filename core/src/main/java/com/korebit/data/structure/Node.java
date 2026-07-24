package com.korebit.data.structure;

public class Node {
    public Node next;
    public int info;
    public Node(int info) {
        this.info = info;
        next = null;
    }

    public Node() {
    }
}
