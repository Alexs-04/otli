package com.korebit.data.structure.stack;

import com.korebit.data.structure.Node;

public class Stack {

    private Node end;
    int length = 0;
    StringBuilder list = new StringBuilder();

    public Stack() {
        end = null;
        length = 0;
    }

    public boolean isEmptyForStack() {
        return end == null;
    }

    public void insertNode(int n) {
        Node newNode = new Node(n);
        newNode.next = end;
        end = newNode;
        length++;
    }

    public void removeNode() {
        end = end.next;
        length--;
    }

    public int endValue() {
        return end.info;
    }

    public int size() {
        return length;
    }

    public void clear() {
        while (!isEmptyForStack()) {
            removeNode();
        }
    }

    public void show() {
        Node rec = end;
        while (rec != null) {
            list.append(rec.info).append("\n");
            rec = rec.next;
        }
        javax.swing.JOptionPane.showMessageDialog(null, list);
        list = new StringBuilder();
    }
}
