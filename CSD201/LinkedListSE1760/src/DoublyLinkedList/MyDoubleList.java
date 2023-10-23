package DoublyLinkedList;

import linkedlistse1760.Node;

public class MyDoubleList {

    DoubleNode head, tail;

    public MyDoubleList() {
    }

    void clear() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    //Display node need visit to console
    void visit(DoubleNode needVisit) {
        if (needVisit != null) {
            System.out.print(needVisit.info);
        }
    }

    //Traverse and display all node of list
    void traverse() {
        DoubleNode p = head;
        while (p != null) {
            System.out.print(p.info + " ");
            p = p.next;
        }
        System.out.println();
    }
    
    // Add new list from 2 array
    void addMany(String a[], int b[]) {
        for (int i = 0; i < a.length; i++) {
            addLast(new Person(a[i], b[i]));
        }
    }

    //(1) - Add new node to the last of list
    void addLast(Person x) {
        DoubleNode p = new DoubleNode(x);
        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;
            p.prev = tail;
            tail = p;
        }
    }

    //(2) - Add new node to the head of list
    void addFirst(Person x) {
        DoubleNode q = new DoubleNode(x);
        if (isEmpty()) {
            head = tail = q;
        } else {
            q.next = head;
            head.prev = q;
            head = q;
        }
    }

    //(3) - Search and return node that have name
    DoubleNode searchByName(String xName) {
        DoubleNode currPoint = head;
        while (currPoint != null) {
            if (currPoint.info.name.equals(xName)) {
                return currPoint;
            }
            currPoint = currPoint.next;
        }
        return null;
    }
    
    DoubleNode searchByAge(int xAge) {
        DoubleNode currPoint = head;
        while (currPoint != null) {
            if (currPoint.info.age == xAge) {
                return currPoint;
            }
            currPoint = currPoint.next;
        }
        return null;
    }
    
    // (4) - Add new node after current node
    void insertAfter(DoubleNode needInsertAfter, Person x) {
        if (needInsertAfter == null) {
            return;
        }
        DoubleNode newNode = new DoubleNode(x);
        newNode.next = needInsertAfter.next;
        newNode.prev = needInsertAfter;
        needInsertAfter.next = newNode;
    }
    
    // (5) - Add new node before current node
    void insertBefore(DoubleNode needInsertBefore, Person x) {
        if (needInsertBefore == null) {
            return;
        }
        DoubleNode newNode = new DoubleNode(x);
        needInsertBefore.prev.next = newNode;
        newNode.prev = needInsertBefore.prev;
        newNode.next = needInsertBefore;
        needInsertBefore.prev = newNode;
    }
    
    // (6) - Remove node from the list
    void remove(DoubleNode nodeRemove) {
        if (nodeRemove == null) {
            return;
        }
        nodeRemove.prev.next = nodeRemove.next;
        nodeRemove.next.prev = nodeRemove.prev;
    }
    
    // (7) Remove node that have name need to remove
    void remove(String xName) {
        if (isEmpty()) {
            return;
        }
        DoubleNode p = head;
        while (p != null) {
            if (p.info.name.compareTo(xName) == 0) {
                break;
            }
            p = p.next;
        }
        remove(p);
    }
    
    // (8)Remove node that have age need to remove
    void remove(int xAge) {
        if (isEmpty()) {
            return;
        }
        DoubleNode p = head;
        while (p != null) {
            if (p.info.age == xAge) {
                break;
            }
            p = p.next;
        }
        remove(p);
    }
    
    // (9)- Remove all node that have the same age value to ageNeedRemove
    void removeAll(int xAge) {
        DoubleNode p = head;
        while (p != null) {
            p = searchByAge(xAge);
            if (p == null) {
                break;
            }
            remove(p);
        }

    }
    
    // (10) - Return node at the position index
    DoubleNode pos(int k) {
        if (isEmpty()) {
            return (null);
        }
        DoubleNode p = head;
        int index = 0;
        while (p != null) {
            if (index == k) {
                return p;
            }
            p = p.next;
            index++;
        }
        return null;
    }
    
    // (11) - Remove node at index using above function
    void removePos(int k) {
        if (isEmpty()) {
            return;
        }
        remove(pos(k));
    }
    
    void sortByName() {
        DoubleNode pi, pj;
        Person x;
        for (pi = head; pi != null; pi = pi.next) {
            for (pj = pi.next; pj != null; pj = pj.next) {
                if (pi.info.name.compareTo(pj.info.name) > 0) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
            }
        }
    }
    
    // (13) - sort ascending, less age value up to head 
    void sortByAge() {
        if (isEmpty()) {
            return;
        }
        Person tempInfo;
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < this.size() - i - 1; j++) {
                if (pos(j).info.age > pos(j + 1).info.age) {
                    tempInfo = pos(j).info;
                    pos(j).info = pos(j + 1).info;
                    pos(j + 1).info = tempInfo;
                }
            }
        }
    }
    
    // (14)- size of list
    int size() {
        if (isEmpty()) {
            return 0;
        }
        DoubleNode currPoint = head;
        int size = 0;
        while (currPoint != null) {
            currPoint = currPoint.next;
            size++;
        }
        return size;
    }
    
    // (15)
    Person[] toArray() {
        return (null);
    }
    
    // (16)- Reverse the list, using swap head and tail
    void reverse() {
        if (isEmpty()) {
            return;
        }
        Person tempInfo;
        for (int i = 0, j = this.size() - 1; i < j; i++, j--) {
            tempInfo = pos(i).info;
            pos(i).info = pos(j).info;
            pos(j).info = tempInfo;
        }
    }
    
    // (17) - return age value is max
    DoubleNode findMaxAge() {
        if (isEmpty()) {
            return null;
        }
        DoubleNode p = head.next;
        DoubleNode nodeMaxAge = head;
        while (p != null) {
            if (p.info.age > nodeMaxAge.info.age) {
                nodeMaxAge = p;
            }
            p = p.next;
        }
        return (nodeMaxAge);
    }
    
    // (18) - return age value is min
    DoubleNode findMinAge() {
        if (isEmpty()) {
            return null;
        }
        DoubleNode p = head.next;
        DoubleNode nodeMinAge = head;
        while (p != null) {
            if (p.info.age < nodeMinAge.info.age) {
                nodeMinAge = p;
            }
            p = p.next;
        }
        return (nodeMinAge);
    }
    
    // (19) -Replace data of node with new data
    void setData(DoubleNode needSetData, Person x) {
        if (isEmpty()) {
            return;
        }
        DoubleNode p = head;
        while (p != null) {
            if (p == needSetData) {
                p.info = x;
                break;
            }
            p = p.next;
        }
    }
    
    // (20) - sort by age from k to h
    void sortByAge(int from, int to) {
        if (isEmpty()) {
            return;
        }
        Person tempInfo;
        for (int i = 0; i < this.size(); i++) {
            for (int j = from; j < to - i; j++) {
                if (pos(j).info.age > pos(j + 1).info.age) {
                    tempInfo = pos(j).info;
                    pos(j).info = pos(j + 1).info;
                    pos(j + 1).info = tempInfo;
                }
            }
        }
    }
    
    // (21) - reverse from k to h 
    void reverse(int from, int to) {
        if (isEmpty()) {
            return;
        }
        Person tempInfo;
        for (int i = from, j = to; i < j; i++, j--) {
            tempInfo = pos(i).info;
            pos(i).info = pos(j).info;
            pos(j).info = tempInfo;
        }
    }
}
