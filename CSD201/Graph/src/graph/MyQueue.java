/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.LinkedList;

/**
 *
 * @author Admin
 */
class MyQueue {

    LinkedList<Integer> t;

    public MyQueue() {
        t = new LinkedList<>();
    }

    boolean isEmpty() {
        return (t.isEmpty());
    }

    void enqueue(Integer p) {
        t.addLast(p);
    }

    Integer dequeue() {
        if (isEmpty()) {
            return (null);
        }
        return (t.removeFirst());
    }

    Integer front() {
        if (isEmpty()) {
            return (null);
        }
        return (t.getFirst());
    }
}
