package List;

import Node.BookNode;
import Object.Book;
import Validation.Validate;
import java.io.*;

public class BookList {

    BookNode head, tail;

    public BookList() {
    }

    //1.1. Load data from file
    public File loadDataFromFile() {
        //requires the user to enter the path of the file. The input value is stored in the variable
        String fileName = validate.inputString("Enter file path: ");
        //Create object is File
        File f = new File(fileName);
        return f;
    }

    //1.2. Input & load date from file
    //Method is read objects and check validity
    public void inputAndLoadToTheEnd() {
        File f = loadDataFromFile();
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                //Method trim to remove space at the beginning and at the end
                String[] data = line.split("\\|");
                String bCode = data[0].trim();
                String title = data[1].trim();
                //convert from quantity string to int
                int quantity = Integer.parseInt(data[2].trim());
                //convert from price string to double
                double price = Double.parseDouble(data[3].trim());
                Book newBook = new Book(bCode, title, quantity, 0, price);

                //Check valid duplicateded
                boolean checkDuplicated = true;
                //Check have list
                BookNode currentNode = head;
                //Throughout each node in list
                //
                while (currentNode != null) {
                    if (bCode.equals(currentNode.info.getBcode())) {
                        checkDuplicated = false;
                        break;
                    }
                    currentNode = currentNode.next;
                }
                //Add if valid
                if (0 <= quantity && checkDuplicated) {
                    this.addLast(newBook);
                }
            }
            System.out.println("-----Input data successfully-----");
        } catch (Exception ex) {
            System.err.println("Loading error occurs: " + ex.getMessage());
        }
    }

    //1.3. Display data
    public void displayData() {
        System.out.println("code\t|\tTitle\t|\tQuantity\t|\tLended\t|\tPrice\t|\tValue");
        System.out.println("---------------------------------------------------------------------------------------------");
        BookNode p = head;
        //Throughout each node in list
        while (p != null) {
            //Call method visit
            visit(p);
            p = p.next;
        }
        System.out.println();
    }

    //1.4. Save book list to file
    public void saveBookListToFile() {
        File f = loadDataFromFile();
        try {
            //create an object to write data to the file specified by the object
            FileWriter writer = new FileWriter(f);
            BookNode currentNode = head;
            while (currentNode != null) {
                //record information of current book
                writer.write(currentNode.info.getBcode() + " | "
                        + currentNode.info.getTitle() + " | "
                        + currentNode.info.getQuantity() + " | "
                        + currentNode.info.getLended() + " | "
                        + currentNode.info.getPrice() + " | "
                        + currentNode.info.getValue() + "\n");
                currentNode = currentNode.next;
            }
            //This line closes the write stream
            writer.close();
            System.out.println("-----Save book file successfully.-----");
        } catch (Exception ex) {
            System.out.println("Saving errors occur: " + ex.getMessage());
        }
    }

    public BookNode search(String xCode) {
        BookNode currentNode = head;
        //Throughout each node in list
        while (currentNode != null) {
            //
            if (currentNode.info.getBcode().equals(xCode)) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        //If not found or not empty, then return null
        return null;
    }

    //1.5. Search by bcode
    public BookNode search(double xPrice) {
        BookNode currentNode = head;
        //Throughout each node in list
        while (currentNode != null) {
            if (currentNode.info.getPrice() == xPrice) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        //If not found or not empty, then return null
        return null;
    }

    //1.6. Delete by bcode
    public void delete(double xPrice) {
        //Check if list empty then return true
        if (isEmpty()) {
            System.out.println("-----Empty list, no deletion!-----");
            return;
        }
        //Find book whose code is xCode, if find object BookNode or null, then remove out list
        remove(search(xPrice));
        System.out.println("-----Delete successfully!-----");
    }

    //1.7. Sort by bcode
    public void sortByBcode() {
        BookNode pi, pj;
        Book x;
        for (pi = head; pi != null; pi = pi.next) {
            for (pj = pi.next; pj != null; pj = pj.next) {
                if (pi.info.getBcode().compareTo(pj.info.getBcode()) > 0) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
            }
        }
        System.out.println("-----Sort successfully!-----");
    }

    //1.8. Input & add to beginning
    public void inputAndAddToBeginning() {
        System.out.println("Enter information for a book:");
        //Save code of book
        String bcode = "";
        //require the user to enter the book code until the book code is not duplicated in the current book list
        while (true) {
            bcode = validate.inputString("\tbcode: ");
            //Check duplicated for bcode
            boolean checkDuplicated = true;
            BookNode currentNode = head;
            //Check if the book code is duplicated in the current book list
            while (currentNode != null) {
                if (bcode == currentNode.info.getBcode()) {
                    checkDuplicated = false;
                    break;
                }
                currentNode = currentNode.next;
            }
            if (!checkDuplicated) {
                System.err.println("--bcode duplicated, enter again!--");
                continue;
            } else {
                break;
            }
        }
        String title = validate.inputString("\tTitle: ");
        int quantity = validate.inputInt("\tQuantity: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int lended = validate.inputInt("\tLended: ", 0, quantity);
        double price = validate.inputDouble("\tPrice: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        Book newBook = new Book(bcode, title, quantity, lended, price);
        //Call the addFirst() method to add a new book to the top of the current list of books.
        this.addFirst(newBook);
        System.out.println("-----Add a new book successfully!-----");
    }

    //1.9. Add after position k
    public void addAfterPosition(int k) {
        System.out.println("Enter information for a book:");
        //Create bcode sav code of book
        String bcode = "";
        //Require the user to enter the book code until the book code is not duplicated in the current book list
        while (true) {
            bcode = validate.inputString("\tcode: ");
            //Check duplicated for bcode
            boolean checkDuplicated = true;
            BookNode currentNode = head;
            //Loop while to using code book duplicated
            while (currentNode != null) {
                if (bcode.equals(currentNode.info.getBcode())) {
                    checkDuplicated = false;
                    break;
                }
                currentNode = currentNode.next;
            }
            if (!checkDuplicated) {
                System.err.print("--bcode duplicated, enter again!--");
                continue;
            } else {
                break;
            }
        }
        String title = validate.inputString("\tTitle: ");
        int quantity = validate.inputInt("\tQuantity: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int lended = validate.inputInt("\tLended: ", 0, quantity);
        double price = validate.inputDouble("\tPrice: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        Book newBook = new Book(bcode, title, quantity, lended, price);

        //Find the node at position k
        BookNode currentNode = head;
        int cnt = 0;
        //pass through the node of the list
        while (currentNode != null) {
            if (cnt == k) {
                break;
            }
            currentNode = currentNode.next;
            cnt++;
        }
        //Add after currentNode, then insert new book
        this.insertAfter(currentNode, newBook);
        System.out.println("-----Add a new book successfully!-----");
    }

    //1.10. Delete position k
    public void deletePosition(int k) {
        //Find the node at position k
        BookNode currentNode = head;
        int cnt = 0;
        //Pass through all node
        while (currentNode != null) {
            //Check k equal cnt, then you have find position want delete
            if (cnt == k) {
                break;
            }
            currentNode = currentNode.next;
            cnt++;
        }
        //Delete currentNode
        this.remove(currentNode);
        System.out.println("-----Delete a book successfully!-----");
    }

    //Initialize validate
    Validate validate = new Validate();

    public void clear() {
        head = tail = null;
    }

    public void visit(BookNode needVisit) {
        if (needVisit != null) {
            System.out.println(needVisit.info);
        }
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void addLast(Book x) {
        BookNode q = new BookNode(x);
        if (isEmpty()) {
            head = tail = q;
        } else {
            tail.next = q;
            tail = q;
        }
    }

    public void addFirst(Book x) {
        BookNode n = new BookNode(x);
        if (isEmpty()) {
            tail = head = n;
        } else {
            n.next = head;
            head = n;
        }
    }

    void insertAfter(BookNode needInsertAfter, Book x) {
        if (needInsertAfter == null) {
            return;
        }
        BookNode newNode = new BookNode(x);
        newNode.next = needInsertAfter.next;
        needInsertAfter.next = newNode;
    }

    void remove(BookNode nodeRemove) {
        if (nodeRemove == null) {
            return;
        }
        BookNode p = head;
        if (head == nodeRemove) {
            head = head.next;
            return;
        } else {
            while (p.next != nodeRemove) {
                p = p.next;
            }
            p.next = nodeRemove.next;
        }
    }
}
