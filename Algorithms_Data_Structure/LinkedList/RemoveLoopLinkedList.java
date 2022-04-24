package LinkedList;

public class RemoveLoopLinkedList {
    static Node head;
    static  class  Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }
    // Function that detects loop in the list
    int detectAndRemoveLoop(Node node){
        Node slow=node;
        Node fast=node;
        while (slow!=null &&  fast!=null&& fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            // If slow and fast meet at same point then loop
            // is present
            if(slow==fast){
                removeLoop(slow,node);
                return 1;
            }
        }
        return 0;
    }
    // Function to remove loop
    void removeLoop(Node loop,Node curr){
            Node ptr1=null,ptr2=null;
             /* Set a pointer to the beginning of the Linked List
         and move it one by one to find the first node which
         is part of the Linked List */
        ptr1=curr;
        while (1==1){
            /* Now start a pointer from loop_node and check
             if it ever reaches ptr2 */
            ptr2=loop;
            while (ptr2.next!=loop && ptr2.next!=ptr1){
                ptr2=ptr2.next;
            }
             /* If ptr2 reahced ptr1 then there is a loop. So
             break the loop */
            if(ptr2.next==ptr1){
                break;
            }
             /* After the end of loop ptr2 is the last node of
         the loop. So make next of ptr2 as NULL or move the first and see weather this as a part of list */
            ptr1=ptr1.next;
        }
        ptr2.next=null;
    }
    // Function to print the linked list
    void  printList(Node node){
        while (node!=null){
            System.out.println(node.data+" ");
            node=node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RemoveLoopLinkedList linkedList=new RemoveLoopLinkedList();
        linkedList.head=new Node(3);
        linkedList.head.next=new Node(5);
        linkedList.head.next.next=new Node(6);
        linkedList.head.next.next.next=new Node(8);
        linkedList.head.next.next.next.next=new Node(7);
        linkedList.head.next.next.next.next.next=new Node(11);
        // Creating a loop for testing
        head.next.next.next.next.next.next=head.next.next;
        System.out.println("After removing linkedList");
        linkedList.printList(head);


    }
}
