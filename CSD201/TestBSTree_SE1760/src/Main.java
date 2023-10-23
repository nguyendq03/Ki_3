
public class Main {
    public static void main(String[] args) {
        
        int a [] = {6,4,7,2,5,1,3};
//{12, 7, 1, 3, 2, 5, 10, 8, 6, 9};//{12, 7, 1, 3, 2, 5, 10, 8, 6, 9};
        //output 5,3,7,2,4,6,8,9
        BSTree t = new BSTree();
        t.insertMany(a);
        System.out.println("Test Breadth - Traveral");
        t.breadth(t.root);
        System.out.println();
      
//        System.out.println("Test simple balancing");
//        t.balance();
//        t.breadth(t.root);
//        System.out.println();
        
        System.out.println("Test Rotate right");
        t.root = t.rotateRight(t.root);
        t.breadth(t.root);
        System.out.println();
        
        
//        System.out.println("Test delete by merging");
//        t.deleteByMerging(6);
//        t.breadth(t.root);
//       // test delete by copy
//        System.out.println("Test Delete by copying");
//        t.deleteByCopy(3);
//        t.breadth(t.root);
//        System.out.println();
//        System.out.println("Test PreOrder - Traveral");
//        t.preOder(t.root);
//         System.out.println();
//        System.out.println("Test PostOder - Traveral");
//        t.postOrder(t.root);
//         System.out.println();
//        System.out.println("Test InOder - Traveral");
//        t.inOrder(t.root);
//        System.out.println();

    }
}
