package LinkedList;

public class CompareStringLinkedList {
    Node head;
    static  Node a,b;
    static class Node{
        char data;
        Node next;
        Node(char c){
            data=c;
            next=null;
        }
    }
    int compare(Node node1,Node node2){
        if (node1==null && node2==null){
            return 1;
        }
        // check the length of linkedList
        while (node1!=null && node2!=null && node1.data==node2.data){
            node1=node1.next;
            node2=node2.next;
        }
        // if the list are of different size
        if (node1!=null && node2!=null){
            return (node1.data>node2.data?1:-1);
        }
        // if either of list has end
        if(node1!=null && node2==null){
            return 1;
        }
        else if(node1==null && node2!=null){
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        CompareStringLinkedList linkedList=new CompareStringLinkedList();
        Node result=null;
        linkedList.a=new Node('a');
        linkedList.a.next=new Node('g');
        linkedList.a.next.next=new Node('b');
        linkedList.a.next.next.next = new Node('k');
        linkedList.a.next.next.next.next = new Node('s');
        linkedList.a.next.next.next.next.next = new Node('b');
        linkedList.b = new Node('g');
        linkedList.b.next = new Node('e');
        linkedList.b.next.next = new Node('e');
        linkedList.b.next.next.next = new Node('k');
        linkedList.b.next.next.next.next = new Node('s');
        linkedList.b.next.next.next.next.next = new Node('a');
        int value;
        value=linkedList.compare(a,b);
        System.out.println(value);

    }


}
