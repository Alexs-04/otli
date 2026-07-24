package com.korebit.data.structure.queue;

import com.korebit.data.structure.Node;

public class Queue {
    private Node start, end;
    StringBuilder heap = new StringBuilder();

    public Queue() {
        start = null;
        end = null;
    }

    public boolean isEmptyForHeap() {
        return start == null;
    }

    public void insert(int info) {
        Node newNode = new Node();
        newNode.info = info;
        newNode.next = null;
        if (isEmptyForHeap()) {
            start = newNode;
        } else {
            end.next = newNode;
        }
        end = newNode;
    }

    public int extract() {
        if (!isEmptyForHeap()) {
            int info = start.info;
            if (start == end) {
                start = null;
                end = null;
            } else {
                start = start.next;
            }
            return info;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public void show() {
        Node route = start;
        StringBuilder row = new StringBuilder();
        while (route != null) {
            heap.append(route.info).append(" ");
            route = route.next;
        }
        String[] str = heap.toString().split(" ");
        for (int i = str.length - 1; i >= 0; i--) {
            row.append(" ").append(str[i]);
        }
        javax.swing.JOptionPane.showMessageDialog(null, row.toString());
        heap = new StringBuilder();
    }
}
