/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

class BSTree {

    Node root;

    BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void clear() {
        root = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void preOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }

        //if (p.info.price>=3 && p.info.price<=5)
        fvisit(p, f);
        preOrder(p.left, f);
        preOrder(p.right, f);
    }

    void inOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder(p.left, f);
        fvisit(p, f);
        inOrder(p.right, f);
    }

    void postOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder(p.left, f);
        postOrder(p.right, f);
        fvisit(p, f);
    }

    void breadth(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void loadData(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void insert(String xOwner, int xPrice) {
        //You should insert here statements to complete this function
        if (xOwner.charAt(1) == 'A' || xPrice > 100) {

        } else {
            if (isEmpty()) {
                root = new Node(new Car(xOwner, xPrice));
                return;
            }
            //f la nut cha cua p
            Node f, p;
            f = null;
            p = root;
            while (p != null) {
                if (p.info.price == xPrice) {
                    return;
                }
                f = p;
                if (xPrice < p.info.price) {
                    p = p.left;
                } else {
                    p = p.right;
                }
            }
            if (xPrice < f.info.price) {
                f.left = new Node(new Car(xOwner, xPrice));
            } else {
                f.right = new Node(new Car(xOwner, xPrice));
            }
        }
    }

    void f1(int line) throws Exception {/* You do not need to edit this function. Your task is to complete insert  function
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
        breadth(root, f);
        f.writeBytes("\r\n");

        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void inOrderF2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrderF2(p.left, f);
        if (p.info.price >= 3 && p.info.price <= 50) {
            fvisit(p, f);
        }
        inOrderF2(p.right, f);
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
        inOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        inOrderF2(root, f);
        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

// f.writeBytes(" k = " + k + "\r\n");
//=============================================================
    ArrayList<Node> listF3 = new ArrayList<>();

    void postOrderF3(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrderF3(p.left, f);
        postOrderF3(p.right, f);
        if (p.info.price >= 30 && p.info.price <= 70 && p.left != null & p.right != null) {
            listF3.add(p);
        }
    }

    void deleteByCopying(Node x) {
        if (root == null) {
            return;
        }
        Node f, p;
        f = null; // f will be parent of p
        p = root;
        while (p != null) {
            if (p.info.price == x.info.price) {
                break;
            }
            f = p;
            if (x.info.price < p.info.price) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            return;
        }
        //Case 1: p is a leaf node
        if (p.left == null && p.right == null) {
            if (f == null) { //p is root
                root = null;
            } else {
                if (p == f.left) {
                    f.left = null;
                } else {
                    f.right = null;
                }
            }
            return;
        }
        //Case 2.1: p has left-child only
        if (p.left != null && p.right == null) {
            if (f == null) { //p is root
                root = p.left;
                p = null;
            } else {
                if (p == f.left) //p is left child
                {
                    f.left = p.left;
                } else {
                    f.right = p.left;
                }
            }
            return;
        }
        //Case 2.2: p has right-child only
        if (p.left == null && p.right != null) {
            if (f == null) { //p is root
                root = p.right;
                p = null;
            } else {
                if (p == f.left) //p is left child
                {
                    f.left = p.right;
                } else {
                    f.right = p.right;
                }
            }
            return;
        }
        //Case 3: p has 2 children
        if (p.left != null && p.right != null) {
            Node q = p.left; // Left sub tree of p
            Node rp, fr;
            rp = q;
            fr = null;
            while (rp.right != null) {
                fr = rp;
                rp = rp.right;
            } //rp is right most node
            p.info = rp.info;
            if (fr == null) {
                p.left = q.left;
            } else {
                fr.right = rp.left;
            }
        }
    }

    void f3(int line) throws Exception {
        clear();
        loadData(line);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        postOrder(root, f);
        f.writeBytes("\r\n");
//        inorder2(root);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        listF3.clear();
        postOrderF3(root, f);
        deleteByCopying(listF3.get(0));
        //------------------------------------------------------------------------------------
        postOrder(root, f);

        f.writeBytes(
                "\r\n");
        f.close();
    }

//=============================================================
    ArrayList<Node> listF4 = new ArrayList<>();

    void inOrderF4(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrderF4(p.left, f);
        if (p.left != null && p.info.price >= 30 && p.info.price <= 70) {
            listF4.add(p);
        }
        inOrderF4(p.right, f);
    }

    void deleteByMerging(Node x) {
        if (root == null) {
            return;
        }
        Node f, p; // f will be the parent of p
        f = null;
        p = root;

        // Find the node to be deleted
        while (p != null) {
            if (p.info.price == x.info.price) {
                break; // Found the node x
            }
            f = p;
            if (x.info.price < p.info.price) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        // Node x not found, no deletion
        if (p == null) {
            return;
        }

        // Case 1: Node x has two children
        if (p.left != null && p.right != null) {
            Node q = p.left;
            Node rp = q;

            // Find the rightmost node in the left subtree of x (rp)
            while (rp.right != null) {
                rp = rp.right;
            }

            if (f == null) {
                root = p.left; // Update the root if x is the root node
            } else {
                if (p == f.left) {
                    f.left = p.left; // Update f's left child
                } else {
                    f.right = p.left; // Update f's right child
                }
            }

            rp.right = p.right; // Attach the right subtree of x to the rightmost node in the left subtree
        } // Case 2: Node x has only one child
        else {
            Node child = (p.left != null) ? p.left : p.right;

            if (f == null) {
                root = child; // Update the root if x is the root node
            } else {
                if (p == f.left) {
                    f.left = child; // Update f's left child
                } else {
                    f.right = child; // Update f's right child
                }
            }
        }
    }

    void f4(int line) throws Exception {
        clear();
        loadData(line);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        inOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        listF4.clear();
        inOrderF4(root, f);
        deleteByMerging(listF4.get(0));
        //-------------------+-----------------------------------------------------------------
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }
    
//=============================================================
    ArrayList<Node> listF5 = new ArrayList<>();
    void preOrderF5(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        listF5.add(p);
        preOrderF5(p.left, f);
        preOrderF5(p.right, f);
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
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        listF5.clear();
        preOrderF5(root, f);
        deleteByMerging(listF5.get(3));
        //-------------------+-----------------------------------------------------------------
        preOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }
    
//=============================================================
    ArrayList<Node> listF6 = new ArrayList<>();
    void breadthF6(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            if(r.left != null)
                listF6.add(r);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
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
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        listF6.clear();
        breadthF6(root, f);
        deleteByMerging(listF6.get(1));
        //-------------------+-----------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }
    
//=============================================================
    ArrayList<Node> listF7 = new ArrayList<>();
    void preOrderF7(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        if(p.info.price >= 30 && p.info.price <= 70 && p.right != null)
            listF7.add(p);
        preOrderF7(p.left, f);
        preOrderF7(p.right, f);
    }
    
    Node rotateLeft(Node p) {
        if (p == null || p.right == null) {
            return p;
        }
        if (p == root) {
            Node q = p.right;
            p.right = q.left;
            q.left = p;
            root = q;
            return q;
        } else {
            Node f = root;
            while (f.right != p) {
                f = f.right;
            }
            Node q = p.right;
            f.right = q;
            p.right = q.left;
            q.left = p;
            return q;
        }

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
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        listF7.clear();
        preOrderF7(root, f);
        rotateLeft(listF7.get(0));
        //-------------------+-----------------------------------------------------------------
        preOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }
    
//=============================================================
    ArrayList<Node> listF8 = new ArrayList<>();
    void preOrderF8(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        if(p.info.price >= 30 && p.info.price <= 70 && p.left != null)
            listF8.add(p);
        preOrderF8(p.left, f);
        preOrderF8(p.right, f);
    }
    
    Node rotateRight(Node p) {
        if (p == null || p.left == null) {
            return p;
        }
        if (p == root) {
            Node q = p.left;
            p.left = q.right;
            q.right = p;
            root = q;
            return q;
        } else {
            Node f = root;
            while (f.left != p) {
                f = f.left;
            }
            Node q = p.left;
            f.left = q;
            p.left = q.right;
            q.right = p;
            return q;
        }
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
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        listF8.clear();
        preOrderF8(root, f);
        rotateRight(listF8.get(0));
        //-------------------+-----------------------------------------------------------------
        preOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }
    
//=============================================================
    ArrayList<Node> listF9 = new ArrayList<>();
    void inOrderF9(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrderF9(p.left, f);
        listF9.add(p);
        inOrderF9(p.right, f);
    }
    
    int findHeight(Node x) {
        if (isEmpty()) {
            return 0;
        }
        int heightLeft = 0;
        int heightRight = 0;
        if (x.left != null) {
            heightLeft = findHeight(x.left);
        }
        if (x.right != null) {
            heightRight = findHeight(x.right);
        }
        if (heightLeft > heightRight) {
            return heightLeft + 1;
        } else {
            return heightRight + 1;
        }
    }
    
    void fvisitF9(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(Integer.toString(findHeight(p)));
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
        inOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        listF9.clear();
        inOrderF9(root, f);
        fvisitF9(listF9.get(4), f);
        //-------------------+-----------------------------------------------------------------
//        preOrder(root, f);
//        f.writeBytes("\r\n");
//        f.close();
    }
    
//=============================================================
    ArrayList<Node> listF10 = new ArrayList<>();
    void inOrderF10(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrderF10(p.left, f);
        listF10.add(p);
        inOrderF10(p.right, f);
    }
    
    int lengthF10 = 0;
    int size(Node p) {
        if (p == null) {
            return 0;
        }
        size(p.left);
        size(p.right);
        lengthF10++;
        return lengthF10;
    }
    
    void fvisitF10(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(Integer.toString(size(p)));
        }
    }
    
    void f10(int line) throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        inOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        listF10.clear();
        inOrderF10(root, f);
        fvisitF10(listF10.get(4), f);
        //-------------------+-----------------------------------------------------------------
//        preOrder(root, f);
//        f.writeBytes("\r\n");
//        f.close();
    }

}
