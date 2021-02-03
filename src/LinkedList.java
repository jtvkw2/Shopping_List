/**
 * Class for the creation of Nodes
 */
class Node{
    String data;
    Node next;

    /**
     * Constructor for creation of nodes
     * @param data contains the String of the node
     * @param next defines next element of node
     */
    public Node(String data, Node next){
        this.data = data;
        this.next = next;
    }
}

/**
 * Class used in ShoppingList for creating a LinkedList
 */
public class LinkedList {
    private Node head;
    private Node tail;

    /**
     * LinkedList Constructor and makes head and tail null for new list
     */
    public LinkedList(){
        head = null;
        tail = null;
    }

    /**
     * Method for adding a string item to list
     *
     * @param item String Element
     * @return true when item is added to list
     */
    public boolean add(String item){
        Node newNode = new Node(item, null);

        if(head == null){
            head = newNode;
        }
        else{
            tail.next = newNode;
        }
        tail = newNode;
        return true;
    }

    /**
     * Method for removing item based on name from list
     *
     * @param item - This is the item to be removed
     * @return true when item is removed, false when list is empty
     */
    public boolean remove(String item){
        //checks to see if list is empty
        if(head == null){
            return false;
        }
        //if first item is removed, changes what node is the head
        else if (head.data.equals(item)){
            head = head.next;
            return true;
        }

        //Used for traversing list to find item to remove
        Node runner = head.next;
        Node previous = head;

        while(runner != null && runner.data.compareTo(item)< 0){
            previous = runner;
            runner = runner.next;
        }
        if(runner != null && runner.data.equals(item)){
            previous.next = runner.next;
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Method for getting a string array version of linked list
     *
     * @returns a String Array for the prinitng of the linked list
     */
    public String[] get(){
        int count;
        Node runner;
        String[] elements;

        count = 0;
        runner = head;
        while(runner != null){
            count++;
            runner = runner.next;
        }

        elements = new String[count];
        runner = head;
        count = 0;
        while(runner != null){
            elements[count] = runner.data;
            count++;
            runner = runner.next;
        }
        return elements;
    }

    /**
     * Method checks if list is empty
     * @return true if empty, false if not
     */
    public boolean isEmpty(){
        return head == null;
    }

    /**
     * Method that checks linked list for item
     * @param item - item to be checked
     * @returns true if array contains item, false if not.
     */
    public boolean contains(String item){
        Node runner;
        runner = head;

        while(runner !=null) {
            if (runner.data.equals(item)) {
                return true;
            }
            runner = runner.next;
        }
        return false;
    }


}
