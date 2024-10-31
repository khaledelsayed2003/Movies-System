package movie_project;

public class LinkedListNode {
    private Cinema cinema;
    private LinkedListNode next;

    public LinkedListNode(Cinema cinema) {
        this.cinema = cinema;
        this.next = null;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }
}
