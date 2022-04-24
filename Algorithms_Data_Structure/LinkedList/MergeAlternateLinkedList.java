package LinkedList;

public class MergeAlternateLinkedList {
    Node head;
    class  Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }
    /* Inserts a new Node at front of the list. */
    void push(int new_data){
         /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node=new Node(new_data);
        /* 3. Make next of new Node as head */
        new_node.next=head;
        /* 4. Move the head to point to new Node */
        head=new_node;
    }
    // Main function that inserts nodes of linked list q into p at
    // alternate positions. Since head of first list never changes
    // and head of second list/ may change, we need single pointer
    // for first list and double pointer for second list.
    void mergeList(MergeAlternateLinkedList q){
        Node p_curr=head;
        Node q_curr=q.head;
        Node p_next,q_next;
        // While there are available positions in p;
        while (p_curr!=null && q_curr!=null){
            // Save next pointers
            p_next=p_curr.next;
            q_next=q_curr.next;
            // make q_curr as next of p_curr
            q_curr.next=p_next;
            p_curr.next=q_next;
            // update current pointers for next iteration
            p_curr=p_next;
            q_curr=q_next;
        }
        q.head=q_curr;
    }
    /* Function to print linked list */
    void printList(){
        Node temp=head;
        while (temp!=null){
            System.out.println(temp.data+" ");
            temp=temp.next;
        }
    }
    /* Driver program to test above functions */
    public static void main(String[] args) {
        MergeAlternateLinkedList linkedList=new MergeAlternateLinkedList();
        MergeAlternateLinkedList linkedList1=new MergeAlternateLinkedList();
        linkedList.push(2);
        linkedList.push(3);
        linkedList.push(4);
        System.out.println("First list-");
        linkedList.printList();
        linkedList1.push(5);
        linkedList1.push(6);
        linkedList1.push(7);
        System.out.println("Second list-");
        linkedList1.printList();
        //merge two linkedlist
        linkedList.mergeList(linkedList1);
        System.out.println("Print modified merge linked list 2");
        linkedList1.printList();


    }

}
