package List;

import Node.ReaderNode;
import Object.Reader;
import Validation.Validate;
import java.io.*;

public class ReaderList {

    ReaderNode head, tail;

    public ReaderList() {
    }

    //2.1. Load data from file
    public File loadDataFromFile() {
        String fileName = validate.inputString("Enter file path: ");
        File f = new File(fileName);
        return f;
    }

    //2.2 Input & add to the end
    public void inputAndLoadToTheEnd() {
        File f = loadDataFromFile();
        try {
            //Use  FileReader and BufferedReader to read each character and each line data
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            //code that reads data line by line from file using readLine() method of BufferedReader
            while ((line = br.readLine()) != null) {
                //Method trim to remove space at the beginning and at the end
                String[] data = line.split("\\|");
                //
                String rCode = data[0].trim();
                String name = data[1].trim();
                //convert from byear integer to int
                int byear = Integer.parseInt(data[2].trim());
                Reader newReader = new Reader(rCode, name, byear);

                //Check valid
                //checkDuplicated mark that the reader code is unique
                boolean checkDuplicated = true;
                ReaderNode currentNode = head;
                //Traverse the list of readers to check for duplicates of reader codes
                while (currentNode != null) {
                    //Check rcode is not empty by using compare rcode equal rcode
                    if (rCode.equals(currentNode.info.getRcode())) {
                        //
                        checkDuplicated = false;
                        break;
                    }
                    currentNode = currentNode.next;
                }
                ////If not duplicated then create and add in the end of the list
                if (checkDuplicated) {
                    this.addLast(newReader);
                }
            }
            System.out.println("-----Input data successfully-----");
        } catch (Exception ex) {
            System.err.println("Loading error occurs: " + ex.getMessage());
        }
    }

    //2.3. Display data
    public void displayData() {
        System.out.println("code\t|\tName\t|\tBirth");
        System.out.println("--------------------------------------");
        ReaderNode p = head;
        //The data of each reader is printed out by calling the visit(p) method.
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println();
    }

    //2.4. Save reader list to file
    public void saveReaderListToFile() {
        File f = loadDataFromFile();
        try {
            FileWriter writer = new FileWriter(f);
            ReaderNode currentNode = head;
            //each reader's data is written to the file using the object's write() method
            while (currentNode != null) {
                writer.write(currentNode.info.getRcode() + " | "
                        + currentNode.info.getName() + " | "
                        + currentNode.info.getByear() + "\n");
                //After recording the current reader's data,currentNode to prepare for the next iteration.
                currentNode = currentNode.next;
            }
            writer.close();
            System.out.println("-----Save reader file successfully.-----");
        } catch (Exception ex) {
            System.err.println("Saving errors occur: " + ex.getMessage());
        }
    }

    //2.5. Search by rcode
    public ReaderNode search(String xCode) {
        ReaderNode currentNode = head;
        //Each node in the list of readers is checked, loop continue run when to null
        while (currentNode != null) {
            //Check If the currentNode's reader code matches the xCode (the one the reader is looking for), the statement in the if block will be executed.
            if (currentNode.info.getRcode().equals(xCode)) {
                //represent readers found
                return currentNode;
            }
            //If no reader with xCode is found in the list, the loop will continue to move currentNode to the next node by assigning currentNode = currentNode.next.
            currentNode = currentNode.next;
        }
        //If you have traversed the entire list without finding a reader with xCode, the code returns null
        return null;
    }

    //2.6. Delete by rcode
    public void delete(String xCode) {
        //Check empty or not
        if (isEmpty()) {
            System.out.println("-----Empty list, no deletion!-----");
            return;
        }
        //If not empty use method 
        remove(search(xCode));
        System.out.println("-----Delete successfully!-----");
    }

    //Initialize validate
    Validate validate = new Validate();

    public void clear() {
        head = tail = null;
    }

    public void visit(ReaderNode needVisit) {
        if (needVisit != null) {
            System.out.println(needVisit.info);
        }
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void addLast(Reader x) {
        ReaderNode q = new ReaderNode(x);
        if (isEmpty()) {
            head = tail = q;
        } else {
            tail.next = q;
            tail = q;
        }
    }

    public void addFirst(Reader x) {
        ReaderNode n = new ReaderNode(x);
        if (isEmpty()) {
            tail = head = n;
        } else {
            n.next = head;
            head = n;
        }
    }

    void insertAfter(ReaderNode needInsertAfter, Reader x) {
        if (needInsertAfter == null) {
            return;
        }
        ReaderNode newNode = new ReaderNode(x);
        newNode.next = needInsertAfter.next;
        needInsertAfter.next = newNode;
    }

    void remove(ReaderNode nodeRemove) {
        if (nodeRemove == null) {
            return;
        }
        if (head == nodeRemove) {
            head = head.next;
            return;
        }
        ReaderNode p = head;
        while (p.next != nodeRemove) {
            p = p.next;
        }
        p.next = nodeRemove.next;
    }

}
