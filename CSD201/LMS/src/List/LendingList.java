package List;

import Node.BookNode;
import Node.LendingNode;
import Node.ReaderNode;
import Object.Lending;
import Validation.Validate;

public class LendingList {

    LendingNode head, tail;

    public LendingList() {
    }

    //Initialize validate
    Validate validate = new Validate();

    //3.1. Input data
    public void inputData(BookList bookList, ReaderList readerList) {
        //Create bcode and rcode for user enter
        String bcode = validate.inputString("Enter book code: ");
        String rcode = validate.inputString("Enter reader code: ");
        //Check found for bcode and rcode by using search(), then result will be assigned
        BookNode bookFound = bookList.search(bcode);
        ReaderNode readerFound = readerList.search(rcode);
        //If not found 
        if (bookFound == null || readerFound == null) {
            System.out.println("-----Not found-----");
            //Check have equal quantity in book bookFound.info.getQuantity()
        } else if (bookFound.info.getLended() == bookFound.info.getQuantity()) {
            Lending newLending = new Lending(bcode, rcode, 0);
            this.addLast(newLending);
            System.out.println("--Lended is equal to quantity, set state = 0--");
            System.out.println("-----Add to the list successfully!-----");

        } else if (bookFound.info.getLended() < bookFound.info.getQuantity()) {
            Lending newLending = new Lending(bcode, rcode, 1);
            this.addLast(newLending);
            System.out.println("--Lended is smaller than quantity, set state = 1--");
            System.out.println("-----Add to the list successfully!-----");
        } else {
            int state = validate.inputInt("Enter state: ", 0, 2);
            if (state == 1) {
                System.out.println("-----The book is still at the reader, not given back.-----");
            } else {
                Lending newLending = new Lending(bcode, rcode, state);
                this.addLast(newLending);
                System.out.println("-----Add to the list successfully!-----");
            }
        }
    }

    //3.2. Display lending data
    public void displayData() {
        System.out.println("bcode\t|\trcode\t|\tState");
        System.out.println("--------------------------------------");
        LendingNode p = head;
        //traverse each node in the list,then Print out a blank line to create space between displayed results
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println();
    }

    //3.3.1. Sort by bcode
    public void sortByBcode() {
        LendingNode pi, pj;
        Lending x;
        //Create 2 loop to algorithm sort
        //This loop traverse each node of list
        for (pi = head; pi != null; pi = pi.next) {
            //Each traverse use method compareTo() to compare bcode
            for (pj = pi.next; pj != null; pj = pj.next) {
                //If pi.info.getBcode() greater than pj.info.getBcode() is bcode pi will be behind bcode pj
                if (pi.info.getBcode().compareTo(pj.info.getBcode()) > 0) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
            }
        }
        System.out.println("-----Sort successfully!-----");
    }

    //3.3.2. Sort by rcode
    public void sortByRcode() {
        LendingNode pi, pj;
        Lending x;
        //Create 2 loop to algorithm sort
        //This loop traverse each node of list
        for (pi = head; pi != null; pi = pi.next) {
            //Each traverse use method compareTo() to compare rcode
            for (pj = pi.next; pj != null; pj = pj.next) {
                //If pi.info.getRcode() greater than pj.info.getRcode() is rcode pi will be behind rcode pj
                if (pi.info.getRcode().compareTo(pj.info.getRcode()) > 0) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
            }
        }
        System.out.println("-----Sort successfully!-----");
    }

    public void clear() {
        head = tail = null;
    }

    public void visit(LendingNode needVisit) {
        if (needVisit != null) {
            System.out.println(needVisit.info);
        }
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void addLast(Lending x) {
        LendingNode q = new LendingNode(x);
        if (isEmpty()) {
            head = tail = q;
        } else {
            tail.next = q;
            tail = q;
        }
    }

    public void addFirst(Lending x) {
        LendingNode n = new LendingNode(x);
        if (isEmpty()) {
            tail = head = n;
        } else {
            n.next = head;
            head = n;
        }
    }

    void insertAfter(LendingNode needInsertAfter, Lending x) {
        if (needInsertAfter == null) {
            return;
        }
        LendingNode newNode = new LendingNode(x);
        newNode.next = needInsertAfter.next;
        needInsertAfter.next = newNode;
    }

    void remove(LendingNode nodeRemove) {
        if (nodeRemove == null) {
            return;
        }
        if (head == nodeRemove) {
            head = head.next;
            return;
        }
        LendingNode p = head;
        while (p.next != nodeRemove) {
            p = p.next;
        }
        p.next = nodeRemove.next;
    }

}
