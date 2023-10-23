/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd_2b_queues;

/**
 *
 * @author Admin
 */
public class MyQueue {

    protected Node head, tail;

    public MyQueue() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    Object front() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        return (head.info);

    }

    public Object dequeue() throws Exception {

        if (isEmpty()) {
            throw new Exception();
        }
        Object x = head.info;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return (x);

    }
    
    public void enqueue(Object x) {
        if(isEmpty()) 
            head = tail = new Node(x);
        else 
        {
            tail.next = new Node(x);
            tail = tail.next;
        }
    }
    
    public void displayAll() {
        if(isEmpty()) {
            System.out.println("The queue is empty. Please push elements to display!");
            return;
        }
        
        
    }
    

}
