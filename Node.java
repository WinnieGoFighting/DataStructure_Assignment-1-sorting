
package assignment.pkg1.sorting;

public class Node {
    Person person;
    Node prev;
    Node next;

    public Node(Person person) {
        this.person = person;
        this.prev = null;
        this.next = null;
    }
}
