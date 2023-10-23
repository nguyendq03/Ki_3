
/*
Stack: LIFO - Vào sau ra trước
Queue: FIFO - Vào trước ra trước
 */
package csd_2a_stacks;
import java.util.*;
/**
 *
 * @author Admin
 */
public class ArrayStack {

     protected  Object [] a; 
    int top, max;

    public ArrayStack() 
      { this(50);
      }

    public ArrayStack(int max1) 
      { max = max1;
        a =  new Object[max];
        top = -1;
      }
    
    protected  boolean grow()
      { int max1 = max + max/2;
        Object [] a1 = new Object[max1];
        if(a1 == null) return(false);
        for(int i =0; i<=top; i++)
             a1[i] = a[i];
         a = a1;
        return(true);
      }

    public boolean isEmpty()
      { return(top==-1);}

    public boolean isFull()
      { return(top==max-1);}

    public void clear()
      { top=-1;}

    public void push(Object x)
      { if(isFull() && !grow())
      {
          System.out.println("Stack is full. Cannot push element" + x);
          return;
      }
        a[++top] = x;
          System.out.println(x + " pushed to the stack");
      }

    Object top() 
      { if(isEmpty()) {
          return null;
      }
        return a[top];
      }

    public Object pop() 
      { if(isEmpty()) {
          return null;
      }
        Object x = a[top];
       a[top] = null;
       top--;
       
        return(x);
      }

    public void displayAll()
      { System.out.println("Elements in the list are:");
        for(int i = 0; i<=top; i++) System.out.print(a[i] + "  ");
        System.out.println();
      }
    
}
