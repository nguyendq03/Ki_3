package linkedlistse1760;

import java.util.List;

public class MyList {

    Node head, tail;

    public MyList() {
        head = tail = null;
    }

    void clear() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    //Display node need visit to console
    void visit(Node needVisit) {
        if (needVisit != null) {
            System.out.print(needVisit.info);
        }
    }

    //Traverse and display all node of list
    void traverse() {
        Node p = head;
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
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
        } else {
            tail.next = q;
            tail = q;
        }
    }

    //(2) - Add new node to the head of list
    void addFirst(Person x) {
        //tạo nút mới
        Node n = new Node(x);
        if (isEmpty()) {
            tail = head = n;
        } else {
            //nối head vào sau n
            n.next = head;
            //cập nhật head mới bằng n
            head = n;
        }
    }

    //(3) - Search and return node that have name
    Node searchByName(String xName) {
        Node currPoint = head;
        while (currPoint != null) {
            if (currPoint.info.name.equals(xName)) {
                return currPoint;
            }
            currPoint = currPoint.next;
        }
        return null;
    }

    Node searchByAge(int xAge) {
        Node currPoint = head;
        while (currPoint != null) {
            if (currPoint.info.age == xAge) {
                return currPoint;
            }
            currPoint = currPoint.next;
        }
        return null;
    }

    // (4) - Add new node after current node
    void insertAfter(Node needInsertAfter, Person x) {
        if (needInsertAfter == null) {
            return;
        }
        Node newNode = new Node(x);
        newNode.next = needInsertAfter.next;
        needInsertAfter.next = newNode;
    }

    // (5) - Add new node before current node
    void insertBefore(Node needInsertBefore, Person x) {
        if (needInsertBefore == null) {
            return;
        }
        Node newNode = new Node(x);
        Node p = head;
        while (p.next != needInsertBefore) {
            p = p.next;
        }
        newNode.next = needInsertBefore;
        p.next = newNode;
    }

    // (6) - Remove node from the list
    void remove(Node nodeRemove) {
        if (nodeRemove == null) {
            return;
        }
        Node p = head;
        while (p.next != nodeRemove) {
            p = p.next;
        }
        p.next = nodeRemove.next;
    }

    // (7) Remove node that have name need to remove
    void remove(String xName) {
        if (isEmpty()) {
            return;
        }
        Node p = head;
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
        Node p = head;
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
        Node p = head;
        while (p != null) {
            p = searchByAge(xAge);
            if (p == null) {
                break;
            }
            remove(p);
        }

    }

    // (10) - Return node at the position index
    Node pos(int k) {
        if (isEmpty()) {
            return (null);
        }
        Node p = head;
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
    
    // (12)- sort ascending, less name value up to head

    void sortByName() {
        Node pi, pj;
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
        Node currPoint = head;
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
    Node findMaxAge() {
        if (isEmpty()) {
            return null;
        }
        Node p = head.next;
        Node nodeMaxAge = head;
        while (p != null) {
            if (p.info.age > nodeMaxAge.info.age) {
                nodeMaxAge = p;
            }
            p = p.next;
        }
        return (nodeMaxAge);
    }
    
    // (18) - return age value is min
    Node findMinAge() {
        if (isEmpty()) {
            return null;
        }
        Node p = head.next;
        Node nodeMinAge = head;
        while (p != null) {
            if (p.info.age < nodeMinAge.info.age) {
                nodeMinAge = p;
            }
            p = p.next;
        }
        return (nodeMinAge);
    }
    
    // (19) -Replace data of node with new data
    void setData(Node needSetData, Person x) {
        if (isEmpty()) {
            return;
        }
        Node p = head;
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
