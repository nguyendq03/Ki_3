
//(1)==============================================================
import java.io.*;

class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != tail) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        fvisit(p, f);
        f.writeBytes("\r\n");
    }

    void loadData(int k) //do not edit this function
    {
        File f = new File("data.txt");
        if (!f.isFile()) {
            System.out.println("not file");
        }
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addHead(a[i], b[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void addHead(String xOwner, int xPrice) {//You should write here appropriate statements to complete this function.
        if (xOwner.charAt(xOwner.length() - 1) == 'B' || xPrice > 100) {
        } else {
            Car x = new Car(xOwner, xPrice);
            Node n = new Node(x);
            if (isEmpty()) {
                tail = head = n;
            } else {
                n.next = head;
                head = n;
            }
        }
    }

    void addTail(String xOwner, int xPrice) {//You should write here appropriate statements to complete this function.

    }

    void f1(int line) throws Exception {/* You do not need to edit this function. Your task is to complete the addLast  function
        above only.
         */
        clear();
        loadData(line);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

//==================================================================
    void insertBefore(Node needInsertBefore, Node x) {
        if (needInsertBefore == null) {
            return;
        }
        Node newNode = x;
        Node p = head;
        if (needInsertBefore == p) {
            addHead(x.info.owner, x.info.price);
        } else {
            while (p.next != needInsertBefore) {
                p = p.next;
            }
            newNode.next = needInsertBefore;
            p.next = newNode;
        }
    }

    void f2(int line) throws Exception {
        clear();
        loadData(line);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Node x = new Node(new Car("X", 1));

        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node cur = head;
        while (cur.info.price <= 10) {
            cur = cur.next;
        }
        insertBefore(cur, x);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f3(int line) throws Exception {
        clear();
        loadData(line);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Node x = new Node(new Car("X", 1));
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node cur = head;
        int cnt = 0;
        while (cur.next != null) {
            if (cur.info.price > 10) {
                cnt++;
                if (cnt == 2) {
                    break;
                }
            }
            cur = cur.next;
        }
        insertBefore(cur, x);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f4(int line) throws Exception {
        clear();
        loadData(line);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Node x = new Node(new Car("X", 1));
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node cur = head;
        Node needInsertBefore = null;
        while (cur.next != null) {
            if (cur.info.price > 10) {
                needInsertBefore = cur;
            }
            cur = cur.next;
        }
        insertBefore(needInsertBefore, x);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
//==================================================================
    void remove(Node nodeRemove) {
        if (nodeRemove == null) {
            return;
        }
        if(head == nodeRemove) {
            head = head.next;
            return;
        }
        Node p = head;
        while (p.next != nodeRemove) {
            p = p.next;
        }
        p.next = nodeRemove.next;
        if(p.next == null) 
            tail = p;
    }
    
    void f5(int line) throws Exception {
        clear();
        loadData(line);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);

        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node cur = head;
        while(cur.next != null) {
            if(cur.info.price > 10 && cur.info.owner.charAt(1) == 'C') {
                cur = cur.next;
                break;
            }
            cur = cur.next;
        }
        remove(cur);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void f6(int line) throws Exception {
        clear();
        loadData(line);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);

        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node cur = head;
        Node nodeRemove = null;
        while(cur.next != null) {
            if(cur.info.price > 10 && cur.info.owner.charAt(1) == 'C') {
                nodeRemove = cur.next;
            }
            cur = cur.next;
        }
        remove(nodeRemove);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void f7(int line) throws Exception {
        clear();
        loadData(line);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);

        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node cur = head;
        Node nodeRemove = null;
        while(cur.next != null) {
            if(cur.next.info.price > 10 && cur.next.info.owner.charAt(1) == 'C') {
                nodeRemove = cur;
                break;
            }
            cur = cur.next;
        }
        remove(nodeRemove);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void f8(int line) throws Exception {
        clear();
        loadData(line);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);

        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node cur = head;
        Node nodeRemove = null;
        while(cur.next != null) {
            if(cur.next.info.price > 10 && cur.next.info.owner.charAt(1) == 'C') {
                nodeRemove = cur;
            }
            cur = cur.next;
        }
        remove(nodeRemove);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
    void sortByPriceFromHead(Node toEnd) {
        Node pi, pj;
        Car x;
        for (pi = head; pi != toEnd.next; pi = pi.next) {
            for (pj = pi.next; pj != toEnd.next; pj = pj.next) {
                if (pi.info.price > pj.info.price) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
            }
        }
    }
    
    void sortByPriceToEnd(Node fromFirst) {
        Node pi, pj;
        Car x;
        for (pi = fromFirst; pi != null; pi = pi.next) {
            for (pj = pi.next; pj != null; pj = pj.next) {
                if (pi.info.price < pj.info.price) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
            }
        }
    }

    void f9(int line) throws Exception {
        clear();
        loadData(line);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);

        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node cur = head;
        Node maxPriceNode = head;
        while(cur.next != null) {
            if(cur.info.price >= maxPriceNode.info.price)
                maxPriceNode = cur;
            cur = cur.next;
        }
        sortByPriceFromHead(maxPriceNode);
        sortByPriceToEnd(maxPriceNode.next);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void sortByOwnerFromHead(Node toEnd) {
        Node pi, pj;
        Car x;
        for (pi = head; pi != toEnd.next; pi = pi.next) {
            for (pj = pi.next; pj != toEnd.next; pj = pj.next) {
                if (pi.info.owner.compareTo(pj.info.owner) < 0) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
            }
        }
    }
    
    void sortByOwnerToEnd(Node fromFirst) {
        Node pi, pj;
        Car x;
        for (pi = fromFirst; pi != null; pi = pi.next) {
            for (pj = pi.next; pj != null; pj = pj.next) {
                if (pi.info.owner.compareTo(pj.info.owner) > 0) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
            }
        }
    }
    
    void f10(int line) throws Exception {
        clear();
        loadData(line);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);

        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node cur = head;
        Node minPriceNode = head;
        while(cur.next != null) {
            if(cur.info.price < minPriceNode.info.price)
                minPriceNode = cur;
            cur = cur.next;
        }
        sortByOwnerFromHead(minPriceNode);
        sortByOwnerToEnd(minPriceNode.next);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
}
