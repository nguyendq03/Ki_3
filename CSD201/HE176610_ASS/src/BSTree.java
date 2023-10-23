
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
public class BSTree {

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

    void visit(Node p) {
        if (p != null) {
            System.out.println(p.info + " ");
        }
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
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

    void preOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
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

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    String f0() {//input your RollNumber
        String RollNum = "HExxxxx";
        return RollNum;
    }

    void insert(String xType, int xRate, int xWing) {
        //You should insert here statements to complete this function
        if (xType.charAt(0) == 'B' || xRate > 10) {
        } else {
            Bird newBird = new Bird(xType, xRate, xWing);
            if (isEmpty()) {
                root = new Node(newBird);
                return;
            }
            Node f, p;
            f = null;
            p = root;
            while (p != null) {
                if (p.info == newBird) {
                    System.out.println("The key " + newBird + " already exists!");
                    return;
                }
                f = p;
                if (newBird.rate < p.info.rate) {
                    p = p.left;
                } else {
                    p = p.right;
                }
            }
            if (newBird.rate < f.info.rate) {
                f.left = new Node(newBird);
            } else {
                f.right = new Node(newBird);
            }
        }
    }

//Do not edit this function. Your task is to complete insert function above only.
    void f1(int line) throws Exception {

        clear();
        loadData(line);
        String fname = "fout.txt";
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
    void breadthF2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            if (r.info.wing >= 4 && r.info.wing <= 10) {
                fvisit(r, f);
            }
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void f2(int line) throws Exception {
        clear();
        loadData(line);
        String fname = "fout.txt";
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
        breadthF2(root, f);
        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    boolean isOddPosition = true;

    void preOrderF3(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        if (isOddPosition) {
            fvisit(p, f);
        }
        isOddPosition = !isOddPosition;
        preOrderF3(p.left, f);
        preOrderF3(p.right, f);
    }

    void f3(int line) throws Exception {
        clear();
        loadData(line);
        String fname = "fout.txt";
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
        preOrderF3(root, f);
//------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void inOrderF4(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrderF4(p.left, f);
        if (p.info.wing < 4 && p.info.rate > 6) {
            fvisit(p, f);
        }
        inOrderF4(p.right, f);
    }

    void f4(int line) throws Exception {
        clear();
        loadData(line);
        String fname = "fout.txt";
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
        inOrderF4(root, f);
//------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void postOrderF5(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrderF5(p.left, f);
        postOrderF5(p.right, f);
        if (p.info.type.charAt(0) == 'A' || p.info.type.charAt(0) == 'C') {
            fvisit(p, f);
        }
    }

    void f5(int line) throws Exception {
        clear();
        loadData(line);
        String fname = "fout.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        postOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        postOrderF5(root, f);
//------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    ArrayList<Node> listF6 = new ArrayList<>();

    void inOrderF6(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrderF6(p.left, f);
        listF6.add(p);
        inOrderF6(p.right, f);
    }

    void deleteByCopying(Node x) {
        if (root == null) {
            System.out.println("This tree is empty, no deletion");
            return;
        }
        Node f, p;
        f = null; // f will be parent of p
        p = root;
        while (p != null) {
            if (p.info.rate == x.info.rate) {
                break;
            }
            f = p;
            if (x.info.rate < p.info.rate) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            System.out.println("The key " + x + " does not exist");
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

    void f6(int line) throws Exception {
        clear();
        loadData(line);
        String fname = "fout.txt";
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
        inOrderF6(root, f);
        deleteByCopying(listF6.get(5));
        System.out.println(listF6.get(5).info);
        //------------------------------------------------------------------------------------
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    ArrayList<Node> listF7 = new ArrayList<>();

    void postOrderF7(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrderF7(p.left, f);
        postOrderF7(p.right, f);
        listF7.add(p);
    }

    void deleteByMerging(Node x) {
        if (root == null) {
            System.out.println("The tree is empty");
            return;
        }
        Node f, p; // f will be the parent of p
        f = null;
        p = root;

        // Find the node to be deleted
        while (p != null) {
            if (p.info.rate == x.info.rate) {
                break; // Found the node x
            }
            f = p;
            if (x.info.rate < p.info.rate) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        // Node x not found, no deletion
        if (p == null) {
            System.out.println("The key " + x + " does not exist, no deletion");
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

    void f7(int line) throws Exception {
        clear();
        loadData(line);
        String fname = "fout.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        postOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        postOrderF7(root, f);
        deleteByMerging(listF7.get(5));
        System.out.println(listF7.get(5).info);  
        //------------------------------------------------------------------------------------
        postOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    ArrayList<Node> listF8 = new ArrayList<>();

    void breadthF8(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            listF8.add(r);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
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

    void f8(int line) throws Exception {
        clear();
        loadData(line);
        String fname = "fout.txt";
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
        breadthF8(root, f);
        listF8.get(3).info.wing = findHeight(listF8.get(3));
        //System.out.println(listF8.get(3).info);
        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    ArrayList<Node> listF9 = new ArrayList<>();

    void preOrderF9(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        listF9.add(p);
        preOrderF9(p.left, f);
        preOrderF9(p.right, f);
    }

    void f9(int line) throws Exception {
        clear();
        loadData(line);
        String fname = "fout.txt";
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
        preOrderF9(root, f);
        listF9.get(5).info.wing = findHeight(listF9.get(5));
        //System.out.println(listF9.get(5).info);
        //------------------------------------------------------------------------------------
        preOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    Node nodeF10;

    void inOrderF10(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrderF10(p.left, f);
        if (p.left != null && p.right != null && p.info.rate < 5) {
            nodeF10 = p;
        }
        inOrderF10(p.right, f);
    }

    Node rotateRight(Node p) {
        if (p == null || p.left == null) {
            return p;
        }
        if (p == root) {
            Node q = p.left;
            p.left = q.right;
            q.right = p;
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

    void f10(int line) throws Exception {
        clear();
        loadData(line);
        String fname = "fout.txt";
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
        inOrderF10(root, f);
        rotateRight(nodeF10);
        //System.out.println(nodeF10.info);
        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    Node nodeF11;

    void postOrderF11(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrderF11(p.left, f);
        postOrderF11(p.right, f);
        if (p.right != null && p.info.rate > 7) {
            nodeF11 = p;
        }
    }

    Node rotateLeft(Node p) {
        if (p == null || p.right == null) {
            return p;
        }
        if (p == root) {
            Node q = p.right;
            p.right = q.left;
            q.left = p;
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

    void f11(int line) throws Exception {
        clear();
        loadData(line);
        String fname = "fout.txt";
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
        postOrderF11(root, f);
        rotateLeft(nodeF11);
        //System.out.println(nodeF11.info);
        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

}
