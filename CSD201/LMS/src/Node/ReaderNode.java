package Node;

import Object.Reader;

public class ReaderNode {
    public Reader info;
    public ReaderNode next;

    public ReaderNode(Reader info, ReaderNode next) {
        this.info = info;
        this.next = next;
    }

    public ReaderNode(Reader info) {
        this.info = info;
        this.next = null;
    }
}
