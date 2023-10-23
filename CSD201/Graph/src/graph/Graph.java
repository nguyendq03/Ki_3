package graph;

/**
 *
 * @author Admin
 */
public class Graph {

    int a[][];
    char v[];
    int n;
    int i, j, k;
    int[][] d;
    int[][] p;
    int INF;

    Graph() {
        v = "ABCDEF".toCharArray();
    }

    void setData(int b[][]) {
        n = b.length;
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = b[i][j];
            }
        }
    }

    void display() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", a[i][j]);
            }
            System.out.println();
        }
    }

    void visit(int i) {
        System.out.print(v[i] + " ");
    }

    //Breadth first
    void breadth(boolean en[], int i) {
        MyQueue q = new MyQueue();
        q.enqueue(i);
        en[i] = true;
        int r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            visit(r);
            for (int j = 0; j < n; j++) {
                if (!en[j] && a[r][j] > 0) {
                    q.enqueue(j);
                    en[j] = true;
                }
            }
        }
    }

    //Bread first
    void breadth(int k) {
        boolean en[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            en[i] = false;
        }
        breadth(en, k);
        for (int j = 0; j < n; j++) {
            if (!en[j]) {
                breadth(en, j);
            }
        }
    }

    //Depth first
    void depth(boolean vis[], int i) {
        visit(i);
        vis[i] = true;
        for (int j = 0; j < n; j++) {
            if (!vis[j] && a[i][j] > 0) {
                depth(vis, j);
            }
        }
    }

    //Depth first
    void depth(int k) {
        boolean vis[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            vis[i] = false;
        }
        depth(vis, k);
        for (int j = 0; j < n; j++) {
            if (!vis[j]) {
                depth(vis, j);
            }
        }

    }

    void dijkstra(int from, int to) {
        int d[] = new int[n];
        int p[] = new int[n];
        boolean S[] = new boolean[n];
        int i, j, min, k, INF = 99;
        for (i = 0; i < n; i++) {
            d[i] = a[from][i];
            p[i] = from;
            S[i] = false;
        }
        S[from] = true;
        while (true) {
            k = - 1;
            min = INF;
            //tim k sao cho d[k] = min
            for (i = 0; i < n; i++) {
                if (S[i]) {
                    continue;
                }
                if (d[i] < min) {
                    min = d[i];
                    k = i;
                }
            }
            if (k == -1) {
                System.out.println("No solution!");
                return;
            }
            //chon k vao tap S
            S[k] = true;
            if (k == to) {
                break;
            }
            for (i = 0; i < n; i++) {
                if (S[i]) {
                    continue;
                }
                if (d[i] > d[k] + a[k][i]) {
                    d[i] = d[k] + a[k][i];
                    p[i] = k;
                }
            }
        }
        System.out.println("The shortest distance: " + d[to]);
        //in duong di
        System.out.println("The shortest path: ");
        MyStack s = new MyStack();
        s.push(to);
        i = to;
        while (i != from) {
            i = p[i];
            s.push(i);
        }
        i = s.pop();
        System.out.print(v[i]);
        while (!s.isEmpty()) {
            i = s.pop();
            System.out.print("->" + v[i]);
        }
    }

    void floyd() {

        d = new int[n][n];
        p = new int[n][n];
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                d[i][j] = a[i][j];
                p[i][j] = i;
            }
        }
        for (k = 0; k < n; k++) {
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    if (d[i][j] > d[i][k] + d[k][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                        p[i][j] = k;
                    }
                }
            }
        }
    }

    void shortestPath(int fro, int to) {
        floyd();
        int i;
        System.out.println("\n The shortest distance = " + d[fro][to]);
        MyStack h = new MyStack();
        i = to;
        h.push(i);
        while (true) {
            i = p[fro][i];
            h.push(i);
            if (i == fro) {
                break;
            }
        }
        i = h.pop();
        System.out.print(v[i]);
        while (!h.isEmpty()) {
            i = h.pop();
            System.out.print(" -> " + v[i]);
        }
    }
}
