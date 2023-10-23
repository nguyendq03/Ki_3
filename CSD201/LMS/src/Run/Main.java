package Run;

import List.BookList;
import List.LendingList;
import List.ReaderList;
import Validation.Validate;
import java.util.Scanner;

public class Main {

    //BOOK_FILE = ""D:\FPTUniversity\CSD201\Book.txt"";
    //READER_FILE = ""D:\FPTUniversity\CSD201\Reader.txt"";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Validate validate = new Validate();

        BookList bookList = new BookList();
        ReaderList readerList = new ReaderList();
        LendingList lendingList = new LendingList();

        int choice;

        do {
            System.out.println("1. About book list.");
            System.out.println("2. About reader list.");
            System.out.println("3. About leding list.");
            System.out.println("0. Exit.");
            choice = validate.inputInt("Enter your choice: ", 0, 3);
            switch (choice) {
                case 1:
                    System.out.println("**********In book list**********");
                    int choice1;
                    do {
                        System.out.println("===Choose 0 to 10===");
                        System.out.println("1.1. Load data from file.");
                        System.out.println("1.2. Input & add to the end."
                                + "\n\t(author's location: BOOK_FILE = \"D:\\FPTUniversity\\CSD201.txt\")");
                        System.out.println("1.3. Display data.");
                        System.out.println("1.4. Save book list to file.");
                        System.out.println("1.5. Search by bcode.");
                        System.out.println("1.6. Delete by bcode.");
                        System.out.println("1.7. Sort by bcode.");
                        System.out.println("1.8. Input & add to beginning.");
                        System.out.println("1.9. Add after position k.");
                        System.out.println("1.10. Delete position k.");
                        System.out.println("Press 0 to exit.");
                        choice1 = validate.inputInt("Enter your choice: ", 0, 10);
                        switch (choice1) {
                            case 1:
                                bookList.loadDataFromFile();
                                break;
                            case 2:
                                bookList.inputAndLoadToTheEnd();
                                System.out.println("");
                                break;
                            case 3:
                                bookList.displayData();
                                System.out.println("");
                                break;
                            case 4:
                                bookList.saveBookListToFile();
                                System.out.println("");
                                break;
                            case 5:
                                double bcode5 = validate.inputDouble("Enter bcode: ", 1, Double.MAX_VALUE);
                                if (bookList.search(bcode5) != null) {
                                    System.out.println("\tBook found. Book's information: ");
                                    System.out.print("\t");
                                    bookList.visit(bookList.search(bcode5));
                                    System.out.println("");
                                } else {
                                    System.err.println("Book not found.");
                                    System.out.println("");
                                }
                                break;
                            case 6:
                                double bcode6 = validate.inputDouble("Enter bcode: ", 1 , Double.MAX_VALUE);
                                if (bookList.search(bcode6) != null) {
                                    bookList.delete(bcode6);
                                    System.out.println("");
                                } else {
                                    System.err.println("Book not found.");
                                    System.out.println("");
                                }
                                break;
                            case 7:
                                bookList.sortByBcode();
                                System.out.println("");
                                break;
                            case 8:
                                bookList.inputAndAddToBeginning();
                                System.out.println("");
                                break;
                            case 9:
                                int k = validate.inputInt("Enter position: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                                bookList.addAfterPosition(k);
                                System.out.println("");
                                break;
                            case 10:
                                int d = validate.inputInt("Enter position: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                                bookList.deletePosition(d);
                                System.out.println("");
                                break;
                            case 0:
                                System.out.println("**********Out of book list**********");
                                break;
                            default:
                                System.out.println("Invalid option, please try again.");
                        }
                    } while (choice1 != 0);
                    break;
                case 2:
                    System.out.println("**********In reader list**********");
                    int choice2;
                    do {
                        System.out.println("===Choose 0 to 6===");
                        System.out.println("2.1. Load data from file.");
                        System.out.println("2.2. Input & add to the end."
                                + "\n\tauthor's location: READER_FILE = \"C:\\Users\\admin\\Desktop\\CSD201\\ASM1\\File\\Reader.txt\")");
                        System.out.println("2.3. Display data.");
                        System.out.println("2.4. Save reader list to file.");
                        System.out.println("2.5. Search by rcode.");
                        System.out.println("2.6. Delete by rcode.");
                        System.out.println("Press 0 to exit.");
                        choice2 = validate.inputInt("Enter your choice: ", 0, 6);
                        switch (choice2) {
                            case 1:
                                readerList.loadDataFromFile();
                                System.out.println("");
                                break;
                            case 2:
                                readerList.inputAndLoadToTheEnd();
                                System.out.println("");
                                break;
                            case 3:
                                readerList.displayData();
                                System.out.println("");
                                break;
                            case 4:
                                readerList.saveReaderListToFile();
                                System.out.println("");
                                break;
                            case 5:
                                String rcode5 = validate.inputString("Enter rcode: ");
                                if (readerList.search(rcode5) != null) {
                                    System.out.println("\tReader found. Reader's information: ");
                                    System.out.print("\t");
                                    readerList.visit(readerList.search(rcode5));
                                    System.out.println("");
                                } else {
                                    System.err.println("Reader not found.");
                                    System.out.println("");
                                }
                                break;
                            case 6:
                                String rcode6 = validate.inputString("Enter rcode: ");
                                if (readerList.search(rcode6) != null) {
                                    readerList.delete(rcode6);
                                    System.out.println("");
                                } else {
                                    System.err.println("Reader not found.");
                                    System.out.println("");
                                }
                                break;
                            case 0:
                                System.out.println("**********Out of reader list**********");
                                break;
                            default:
                                System.out.println("Invalid option, please try again.");
                        }
                    } while (choice2 != 0);
                    break;
                case 3:
                    System.out.println("**********In lending list**********");
                    int choice3;
                    do {
                        System.out.println("===Choose 0 to 3===");
                        System.out.println("3.1. Input data.");
                        System.out.println("3.2. Display lending data.");
                        System.out.println("3.3. Sort by bcode.");
                        System.out.println("3.4. Sort by rcode.");
                        System.out.println("Press 0 to exit.");
                        choice3 = validate.inputInt("Enter your choice: ", 0, 4);
                        switch (choice3) {
                            case 1:
                                lendingList.inputData(bookList, readerList);
                                System.out.println("");
                                break;
                            case 2:    
                                lendingList.displayData();
                                System.out.println("");
                                break;
                            case 3: 
                                lendingList.sortByBcode();
                                System.out.println("");
                                break;
                            case 4:
                                lendingList.sortByRcode();
                                System.out.println("");
                                break;
                            case 0:
                                System.out.println("**********Out of lending list**********");
                                break;
                            default:
                                System.out.println("Invalid option, please try again.");
                        }
                    } while (choice3 != 0);
            }
        } while (choice != 0);
    }
}
