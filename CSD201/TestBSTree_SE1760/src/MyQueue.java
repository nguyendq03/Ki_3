
import java.util.LinkedList;


public class MyQueue {
    
    LinkedList<Node> t;

    public MyQueue() {
        t = new LinkedList<>();
    }
    boolean isEmpty(){
        return (t.isEmpty());
    }
    void enqueue(Node p){
        t.addLast(p);
    }
    Node dequeue(){
        if(isEmpty()) return (null);
        return (t.removeFirst());
    }
    Node front(){
        if (isEmpty()) return (null);
        return (t.getFirst());
    }
}
