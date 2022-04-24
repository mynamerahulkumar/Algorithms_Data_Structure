public class RemoveDuplicate {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            this.data=d;
            next=null;
        }
    }
    /*
    Function to remove duplicates from unsorted linked list
     */
    void remove_duplicates(){
        Node ptr1=null,ptr2=null;
        ptr1=head;
        while (ptr1!=null && ptr1.next!=null){
            ptr2=ptr1;
            while(ptr2.next!=null){
                if(ptr1.data!=ptr2.next.data){
                    ptr2=ptr2.next;
                }
                else{
                    ptr2.next=ptr2.next.next;
                }
            }
            ptr1=ptr1.next;
        }
    }
    void printList(Node node){
        while (node!=null){
            System.out.print(node.data+" ");
            node=node.next;
        }
    }

    public static void main(String[] args) {
        RemoveDuplicate linkedList=new RemoveDuplicate();
        linkedList.head=new Node(10);
        linkedList.head.next=new Node(12);
        linkedList.head.next.next=new Node(11);
        linkedList.head.next.next.next=new Node(11);
        linkedList.head.next.next.next.next=new Node(12);
        linkedList.head.next.next.next.next.next=new Node(11);
        linkedList.head.next.next.next.next.next.next=new Node(10);
        System.out.println("Linked list before removing duplicates:\n");
        linkedList.printList(head);
        linkedList.remove_duplicates();
        System.out.println("Linked list after removing duplicates\n");
        linkedList.printList(head);
    }
}
