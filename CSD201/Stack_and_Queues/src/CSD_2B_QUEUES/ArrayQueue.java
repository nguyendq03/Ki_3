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
public class ArrayQueue {

    protected Object[] a;
    protected int max;
    protected int first, last;

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int max1) {
        max = max1;
        a = new Object[max];
        first = last = -1;
    }

    public boolean isEmpty() {
        return (first == 1);
    }

    public boolean isFull() {
        return (first == 0 && last == max - 1 || first == last + 1);
    }

    public boolean grow() {
        int i, j;
        int max1 = max + max / 2;
        Object[] a1 = new Object[max1];
        if (a1 == null) {
            return (false);
        }
        if (last >= first) {
            for (i = first; i <= last; i++) {
                a1[i - first] = a[i];
            }
        } else {
            for (i = first; i < max; i++) {
                a1[i - first] = a[i];
                i = max - first;
                for (j = 0; i <= last; j++) {
                    a1[i + j] = a[j];
                }
            }
        }
        a = a1;
        first = 0;
        last = max - 1;
        max = max1;
        return (true);

    }

    public void enqueue(Object x) {
        if (isFull() && !grow()) {
            return;
        }
        if (last == max - 1 || last == -1) {
            a[0] = x;
            last = 0;
            if (first == -1) {
                first = 0;

            } else {
                a[++last] = x;
            }

        }
    }

   
  Object front() throws Exception
      { if(isEmpty()) throw new Exception();
        return(a[first]);
      }

  
  public Object dequeue(Object x) throws Exception
      { if(isEmpty()) throw new Exception();
         x = a[first] ;
        if(first == last)	// only one element
           {first = last = -1;}
           else if(first==max-1)
             first = 0;
             else
             first++;
        return(x);
      }
    
   /*Object front() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        Object x = a[first];
        if (first == last) {  //only one element

            first = last = -1;

        } else if (first == max - 1) {
            first = 0;
        } else {
            first++;
        }
        return (x);

    }
    */
    public void displayAll() {
    if (isEmpty()) {
        System.out.println("The queue is empty. There are no elements to display.");
        return;
    }
    
    System.out.println("Elements in the queue are:");
    if (first <= last) {
        for (int i = first; i <= last; i++) {
            System.out.print(a[i] + " ");
        }
    } else {
        for (int i = first; i < max; i++) {
            System.out.print(a[i] + " ");
        }
        for (int i = 0; i <= last; i++) {
            System.out.print(a[i] + " ");
        }
    }
    System.out.println();
}
    
}