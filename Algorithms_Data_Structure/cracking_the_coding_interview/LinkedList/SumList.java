public class SumList {
    static Node head;
    static Node head2;
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    /*
    1 .pass two header
    2.create a new head and node
    3. intialize new head
    4.append new node with node
     */
    static Node sumList(Node head1,Node head2){
        Node newHead=null;
        int rem=0;
        Node node=null;
        while (head1!=null && head2!=null){
            int num=head1.data+head2.data+rem;
            rem=num/10;
            num=num%10;
            if(newHead==null){
                newHead=new Node(num);
                node=newHead;
            }
            else {
                node.next = new Node(num);
                node = node.next;
            }
            head1=head1.next;
            head2=head2.next;
        }
        while (head1!=null){
            int num=head1.data+rem;
            rem=num/10;
            num=num%10;
            node.next=new Node(num);
            node=node.next;
            head1=head1.next;
        }
        while (head2!=null){
            int num=head2.data+rem;
            rem=num/10;
            num=num%10;
            node.next=new Node(num);
            node=node.next;
            head2=head2.next;
        }
        if(rem!=0){
            node.next=new Node(rem);
        }
        return newHead;
    }
    static void printList(Node head){
        while (head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SumList linkedList=new SumList();
        linkedList.head=new Node(7);
        linkedList.head.next=new Node(1);
        linkedList.head.next.next=new Node(6);
        SumList linkedList2=new SumList();
        linkedList2.head2=new Node(5);
        linkedList2.head2.next=new Node(9);
        linkedList2.head2.next.next=new Node(2);
        System.out.println("First list");
        printList(linkedList.head);
        System.out.println("Second list");
        printList(linkedList2.head2);
        System.out.println("Sum of two linked list");
        Node head3= sumList(linkedList.head,linkedList2.head2);
        printList(head3);
    }
}
