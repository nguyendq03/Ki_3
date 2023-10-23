package Node;

import Object.Book;

public class BookNode {
    public Book info;
    public BookNode next;

    public BookNode(Book info, BookNode next) {
        this.info = info;
        this.next = next;
    }

    public BookNode(Book info) {
        this.info = info;
        this.next = null;
    }
}
