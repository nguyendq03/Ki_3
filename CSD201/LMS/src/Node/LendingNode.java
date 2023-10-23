package Node;

import Object.Lending;

public class LendingNode {
    public Lending info;
    public LendingNode next;

    public LendingNode(Lending info, LendingNode next) {
        this.info = info;
        this.next = next;
    }

    public LendingNode(Lending info) {
        this.info = info;
        this.next = null;
    }
}
