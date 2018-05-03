
package assignment.pkg1.sorting;


public class NodeManipulation {
    Node head = null;
    
    void insertHead(Person person) {
        Node newNode = new Node(person);
        //Empty list
        if(head==null) {
            head=newNode;
            return;
        }
        head.prev = newNode;
        newNode.next = head;
        head=newNode;
            }
    
    public void delete(String name) {
        //empty list
        if(head==null) return;
        //Node to remove is at head
        if(head.person.name.equals(name)){
            head = head.next;
            head.prev = null;
        }
        //Node to remove is not at head
        Node current=head;
        while(current!=null){
        if(current.person.name.equals(name)){
            current.prev.next=current.next;
            if(current.next!=null)
            current.next.prev=current.prev;
        }
        current=current.next;
    }
    }
    
    public void selectionSort(Node head) {
        if(head==null||head.next==null) 
            return;
        Node temp1 = head;
        while(temp1.next!=null) {
            Node temp2 = temp1.next;
            Node minNode=temp1;
            while(temp2!=null) {
                if(temp2.person.age<minNode.person.age)
                    minNode=temp2;
                temp2 = temp2.next;
            }
            //swap the nodes of temp1 and minNode
            swapNodes(temp1.person.age, minNode.person.age);
            temp1 = minNode.next;
        }
    }
    
   public void swapNodes(int x, int y)
    {
        // Nothing to do if x and y are same
        if (x == y) return;
 
        // Search for x (keep track of prevX and CurrX)
        Node prevX = null, currX = head;
        while (currX != null && currX.person.age != x)
        {
            prevX = currX;
            currX = currX.next;
        }
 
        // Search for y (keep track of prevY and currY)
        Node prevY = null, currY = head;
        while (currY != null && currY.person.age != y)
        {
            prevY = currY;
            currY = currY.next;
        }
 
        // If either x or y is not present, nothing to do
        if (currX == null || currY == null)
            return;
 
        // If x is not head of linked list
        if (prevX != null)
            prevX.next = currY;
        else //make y the new head
            head = currY;
 
        // If y is not head of linked list
        if (prevY != null)
            prevY.next = currX;
        else // make x the new head
            head = currX;
 
        // Swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
        }

    public void printList() {
        Node temp = head;
        while(temp!=null) {
            System.out.println(temp.person.name+" "+
                    temp.person.age);
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        NodeManipulation m = new NodeManipulation();
        m.insertHead(new Person("Alice",78));
        m.insertHead(new Person("Bob",3));
        m.insertHead(new Person("Mary",6));
        m.insertHead(new Person("Jack",9));
        m.insertHead(new Person("Linda",35));
        System.out.println("++++++++++++++++Original List++++++++++++++++++++++");
        m.printList();
        System.out.println("+++++++++++List After Mary is deleted+++++++++++++");
        m.delete("Mary");
        m.printList();
        m.selectionSort(m.head);
        System.out.println("+++++++++++++SortedList as below+++++++++++++++++++");
        m.printList();   
    } 
}
