
package DoublyLinkedList;

public class DoubleNode {
    Person info;
    DoubleNode prev, next;

    public DoubleNode() {
    }

    public DoubleNode(Person info, DoubleNode prev, DoubleNode next) {
        this.info = info;
        this.prev = prev;
        this.next = next;
    }

    public DoubleNode(Person info) {
        this.info = info;
        next = null;
        prev = null;
    }
   
    
}
