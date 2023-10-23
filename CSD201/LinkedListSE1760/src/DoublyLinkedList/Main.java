
package DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        MyDoubleList db = new MyDoubleList();
        DoubleNode p, q;
        Person x;
        int k;
        String[] a = {"A", "C", "B", "E", "D"};
        int[] b = {9, 5, 17, 5, 8};
        //Checked
        System.out.println("\n1. Test addLast");
        db.clear();
        db.addMany(a, b);
        db.traverse(); //  (A,9) (C,5) (B,17) (E,5) (D,8)
        x = new Person("X", 30);
        db.addLast(x);
        db.traverse();

        //Checked
        System.out.println("\n2. Test addFirst");
        db.clear();
        db.addMany(a, b);
        db.traverse(); //  (A,9) (C,5) (B,17) (E,5) (D,8)
        x = new Person("X", 30);
        db.addFirst(x);
        db.traverse(); // (X,30) (A,9) (C,5) (B,17) (E,5) (D,8)
        
        //Checked
        System.out.println("\n3. Test searchByName");
        db.clear();
        db.addMany(a, b);
        db.traverse(); //  (A,9) (C,5) (B,17) (E,5) (D,8)
        p = db.searchByName("B");
        if (p == null) {
            System.out.println("Not found");
        } else {
            System.out.println("The person found is");
            db.visit(p);
            System.out.println();
        }
        
        //Checked
        System.out.println("\n4. Test insertAfter");
        db.clear();
        db.addMany(a, b);
        db.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        x = new Person("X", 30);
        q = db.searchByName("B");
        db.insertAfter(q, x);
        db.traverse(); // (A,9) (C,5) (B,17) (X,30) (E,5) (D,8)
        
        //Checked
        System.out.println("\n5. Test insertBefore");
        db.clear();
        db.addMany(a, b);
        db.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        x = new Person("X", 30);
        q = db.searchByName("B");
        db.insertBefore(q, x);
        db.traverse(); // (A,9) (C,5) (X,30) (B,17) (E,5) (D,8)
        
        //Checked
        System.out.println("\n6. Test remove(Node q)");
        db.clear();
        db.addMany(a, b);
        db.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        q = db.searchByName("B");
        db.remove(q);
        db.traverse(); // (A,9) (C,5) (E,5) (D,8)
        
        //Checked
        System.out.println("\n7. Test remove(String xName)");
        db.clear();
        db.addMany(a, b);
        db.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        db.remove("B");
        db.traverse(); // (A,9) (C,5) (E,5) (D,8)
        
        //Checked
        System.out.println("\n8. Test remove(int xAge)");
        db.clear();
        db.addMany(a, b);
        db.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        db.remove(5);
        db.traverse(); // (A,9) (B,17) (E,5) (D,8)
        
        //Checked
        System.out.println("\n9. Test removeAll(int xAge)");
        db.clear();
        db.addMany(a, b);
        db.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        db.removeAll(5);
        db.traverse(); // (A,9) (B,17) (D,8)
        
        //Checked
        System.out.println("\n10. Test pos(int k)");
        db.clear();
        db.addMany(a, b);
        db.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        p = db.pos(2);
        System.out.println("The person at position 2 is ");
        db.visit(p); // The person at position 2 is  (B,17)
        System.out.println();
        
        //Checked
        System.out.println("\n11. Test removePos(int k)");
        db.clear();
        db.addMany(a, b);
        db.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        db.removePos(2);
        db.traverse(); // (A,9) (C,5) (E,5) (D,8)
        
        //Checked
        System.out.println("\n12. Test sortByName()");
        db.clear();
        db.addMany(a, b);
        db.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        db.sortByName();
        db.traverse(); // (A,9) (B,17) (C,5) (D,8) (E,5)
        
        //Checked
        System.out.println("\n13. Test sortByAge()");
        db.clear();
        db.addMany(a, b);
        db.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        db.sortByAge();
        db.traverse(); // (C,5) (E,5) (D,8) (A,9) (B,17)
        
        //Checked
        System.out.println("\n14. Test size()");
        db.clear();
        db.addMany(a, b);
        db.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        k = db.size();
        System.out.println("Size = " + k);
        
        //Checked
        System.out.println("\n15. Test toArray()");
        db.clear();
        db.addMany(a, b);
        db.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        Person[] u = db.toArray();
        if (u != null) {
            for (int i = 0; i < u.length; i++) {
                System.out.print(u[i]); // (A,9) (C,5) (B,17) (E,5) (D,8)
            }
            System.out.println();
        }
        
        //Checked
        System.out.println("\n16. Test reverse()");
        db.clear();
        db.addMany(a, b);
        db.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        db.reverse();
        db.traverse(); // (D,8) (E,5) (B,17) (C,5) (A,9)
        
        //Checked
        System.out.println("\n17. Test findMaxAge()");
        db.clear();
        db.addMany(a, b);
        db.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        p = db.findMaxAge();
        System.out.println("The person with maximum age:");
        db.visit(p);
        System.out.println();
        
        //Checked
        System.out.println("\n18. Test findMinAge()");
        db.clear();
        db.addMany(a, b);
        db.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        p = db.findMinAge();
        System.out.println("The person with minimum age:");
        db.visit(p);
        System.out.println();
        
        //Checked
        System.out.println("\n19. Test setData()");
        db.clear();
        db.addMany(a, b);
        db.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        p = db.searchByName("B");
        x = new Person("XX", 99);
        db.setData(p, x);
        db.traverse(); // (D,8) (E,5) (XX,99) (C,5) (A,9)
        
        //Checked
        String[] c = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        int[] d = {9, 8, 7, 6, 15, 4, 3, 2, 1};
        System.out.println("\n20. Test sortByAge(3, 6)");
        db.clear();
        db.addMany(c, d);
        db.traverse(); // (A,9) (B,8) (C,7) (D,6) (E,15) (F,4) (G,3) (H,2) (I,1)
        db.sortByAge(3, 6);
        db.traverse(); // (A,9) (B,8) (C,7) (G,3) (F,4) (D,6) (E,15) (H,2) (I,1) 

        //Checked
        System.out.println("\n21. Test reverse(3, 6)");
        db.clear();
        db.addMany(c, d);
        db.traverse(); // (A,9) (B,8) (C,7) (D,6) (E,15) (F,4) (G,3) (H,2) (I,1)
        db.reverse(3, 6);
        db.traverse(); // (A,9) (B,8) (C,7) (G,3) (F,4) (E,15) (D,6) (H,2) (I,1) 

        System.out.println();
        
    }
}
