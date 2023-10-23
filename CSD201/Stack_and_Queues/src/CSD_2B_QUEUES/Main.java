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


import java.util.*;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        int choice;
        int x = 0;
        int k;
        Scanner sc = new Scanner(System.in);
        ArrayQueue queue = new ArrayQueue();
        MyQueue myqueue = new MyQueue();
        Integer X;
        while (true) {
            System.out.println();
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Front");
            //System.out.println("4. Display all");
            System.out.println("0. Exit");
            System.out.print("   Your choice (0 -> 4) :    ");
            choice = sc.nextInt();
            if (choice == 0) {
                break;
            }

            /*switch(choice) 
            {
                case 1: System.out.println("Enter the value you want to enqueue:" );
                           x = sc.nextInt();
                           queue.enqueue(x);
                           break;
                case 2: 
                    
                     try {
                         System.out.println("Enter the value you want to dequeue:");
                        int dequeuedValue = (int) queue.dequeue(x);
                        System.out.println("Dequeue element: " + dequeuedValue);
                    } catch (Exception e) {
                        System.out.println("The queue is empty. Cannot dequeue.");
                    }
                    break;
                case 3: System.out.println("The front is: " + x);
                             break;
                             
            }
             */
            switch (choice) {
                case 1:
                    System.out.println("Enter the value you want to enqueue:");
                    x = sc.nextInt();
                    myqueue.enqueue(x);
                    System.out.println("Add the value successfully!");
                    break;
                case 2:

                    try {
                        System.out.println("Enter the value you want to dequeue:");
                        x = sc.nextInt();
                        System.out.println("Dequeue element: " + x);
                        myqueue.dequeue();
                        System.out.println("Dequeue element sucessfully!");
                    } catch (Exception e) {
                        System.out.println("The queue is empty. Cannot dequeue.");
                    }
                    break;
                case 3:
                    System.out.println("The front is: " + x);
                    break;
             
            }

        }

    }

}
