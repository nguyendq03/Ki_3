
import java.util.ArrayList;

public class BSTree {

    Node root;
    Node q;

    BSTree() {
        root = null;
    }

    void clear() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void insert(int x) {
        if (isEmpty()) {
            root = new Node(x);
            return;
        }
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info == x) {
                System.out.println("The key" + x + "already exists!");
                return;
            }
            f = p;
            if (x < p.info) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (x < f.info) {
            f.left = new Node(x);
        } else {
            f.right = new Node(x);
        }

    }

    void insertMany(int a[]) {
        for (int i = 0; i < a.length; i++) {
            insert(a[i]);
        }
    }

    void visit(Node p) {
        if (p != null) {
            System.out.print(p.info + " ");
        }
    }

    Node search(Node p, int x) {
        if (p == null) {
            return (null);
        }
        if (p.info == x) {
            return (p);
        }
        if (x < p.info) {
            return search(p.left, x);
        } else {
            return search(p.right, x);
        }
    }

    void breadth(Node p) {
        if (isEmpty()) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            visit(r);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void preOder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOder(p.left);
        preOder(p.right);
    }

    void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);

    }

    void deleteByCopy(int x) {
        if (root == null) {
            System.out.println("The tree is empty");
            return;
        }
        Node f, p; //f will be father of p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info == x) {
                break;//found the x
            }
            f = p;
            if (x < p.info) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            System.out.println("The key " + x + "does not exists, no deletion");
            return;
        }//not found
        //case 1. p is a leaf - node
        if (p.left == null && p.right == null) {
            if (f == null) {//p is root
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
        //th2. p has a left - child node
        if (p.left != null && p.right == null) {
            if (f == null) {
                root = p.left;
            } else {
                if (p == f.left) {
                    f.left = p.left;
                } else {
                    f.right = p.left;
                }
            }
            return;
        }
        //case 2. p has a right - child node
        if (p.left != null && p.right == null) {
            if (f == null) {
                root = p.right;
            } else {
                if (p == f.left) {
                    f.left = p.right;
                } else {
                    f.right = p.right;
                }
            }
            return;
        }
        //Case 3. p have two children node
        if (p.left != null && p.right != null) {
            Node q = p.left;
            Node fr, rp;
            fr = null;
            rp = q;
            while (rp.right != null) {
                fr = rp;
                rp = rp.right;
            }//rp  is right most node
            p.info = rp.info;
            if (fr == null) {
                p.left = q.left;
            }
            fr.right = rp.left;
        }
    }

    void deleteByMerging(int x) {
        if (root == null) {
            System.out.println("The tree is empty");
            return;
        }
        Node f, p; //f will be father of p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info == x) {
                break;//found the x
            }
            f = p;
            if (x < p.info) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            System.out.println("The key " + x + "does not exists, no deletion");
            return;
        }
        if (p.left != null && p.right != null) {
            Node q = p.left;
            Node rp;
            rp = q;
            while (rp.right != null) {
                rp = rp.right;
            }//rp  is right most node
            if (f == null) {
                root = p.left;
            } else {
                f.left = p.left;
                rp.right = p.right;
            }
        }
    }

    void inOder(ArrayList<Integer> t, Node p) {
        if (p == null) {
            return;
        }
        inOder(t, p.left);
        t.add(p.info);
        inOder(t, p.right);
    }

    void bal(ArrayList<Integer> t, int i, int j) {
        if (i > j) {
            return;
        }
        int k = (i + j) / 2;
        Integer x = t.get(k);
        insert(x);
        bal(t, i, k - 1);
        bal(t, k + 1, j);
    }

    void balance() {
        ArrayList<Integer> t = new ArrayList<>();
        inOder(t, root);
        clear();
        int n = t.size();
        bal(t, 0, n - 1);
    }

    //Create rotation right for tree
    Node rotateRight(Node p) {
        {
            {
                if (p == null || p.left == null) {
                    Node q = p.left;
                    p.left = q.right;
                    q.right = p;

                }
            }
            return q;
        }
        
    }
    //Create rotation left for tree

    public Node min() {
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public Node max() {
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }
    
  }

