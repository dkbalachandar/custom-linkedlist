
/**
 * A custom linked list implementation in Java
 */
public class MyLinkedList {

    private Node head;

    private int size;

    /**
     * Method to add the data into the list
     *
     * @param data
     */
    public void add(Object data) {

        Node temp = new Node(data);
        if (head == null) {
            head = temp;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(temp);
        }
        size++;
    }

    /**
     * Method to get the Element
     * @param index
     * @return Object
     */
    public Object get(int index) {

        if (index < 0 || index >= size) {
            return null;
        }
        Node current = head;
        for (int i = 1; i < index; i++) {
            if (current.getNext() == null) {
                return null;
            } else {
                current = current.getNext();
            }
        }
        return current.getData();
    }

    /**
     * Method to remove the element
     * @param index
     * @return boolean
     */
    public boolean remove(int index) {

        if (index < 0 || index >= size) {
            return false;
        }
        Node current = head;
        for (int i = 1; i < index; i++) {
            if (current.getNext() == null) {
                return false;
            } else {
                current = current.getNext();
            }
        }
        current.setNext(current.getNext().getNext());
        size--;
        return true;
    }

    /**
     * Method to print the node elements
     */
    public void printElements() {

        Node current = head;
        while (current.getNext() != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
        System.out.println(current.getData());
    }

    public int getSize() {
        return size;
    }

    /**
     * A static inner class represents a Node.
     */
    private static class Node {

        private Object data;

        private Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }

        public Object getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

    private void findMiddleElement() {

        //Move by one node at a time
        Node firstPointer = head;
        //Move by two nodes at a time
        Node secondPointer = head;
        while (secondPointer!= null && secondPointer.getNext() != null &&
                secondPointer.getNext().getNext() != null) {
            firstPointer = firstPointer.getNext();
            secondPointer = secondPointer.getNext().getNext();
        }
        System.out.println("Middle Element is: "+ firstPointer.getData());
    }

    public static void main(String[] args) {

        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add("String1");
        linkedList.add("String2");
        linkedList.add("String3");
        linkedList.add("String4");
        System.out.println("Size of the Linked List is :" + linkedList.getSize());
        System.out.println("Element at Index 1::" + linkedList.get(1));
        linkedList.printElements();
        System.out.println("Remove at Index 1::" + linkedList.remove(1));
        linkedList.findMiddleElement();
    }
}
