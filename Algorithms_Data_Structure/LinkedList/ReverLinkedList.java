package LinkedList;

public class ReverLinkedList {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }
    /* Function to reverse the linked list */
    Node reverseLinkedList(Node node){
        Node prev=null;
        Node curr=node;
        Node next=null;
        while (curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        node=prev;
        return node;
    }
    void printList(Node node){
        while (node!=null){
            System.out.println(node.data+" ");
            node=node.next;
        }
    }
    // Driver Code
    public static void main(String[] args) {
        ReverLinkedList linkedList=new ReverLinkedList();
        linkedList.head=new Node(4);
        linkedList.head.next=new Node(5);
        linkedList.head.next.next=new Node(6);
        linkedList.head.next.next.next=new Node(2);
        System.out.println("Given linked list");
        linkedList.printList(head);// passed a reference
        System.out.println("reverse a linked list");
        head=linkedList.reverseLinkedList(head);
        linkedList.printList(head);
    }
}
