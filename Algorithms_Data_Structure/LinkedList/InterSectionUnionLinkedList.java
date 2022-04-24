package LinkedList;

public class InterSectionUnionLinkedList {
    Node head;
    class  Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }
    /* Function to get Union of 2 Linked Lists */
    void getUnition(Node head1,Node head2){
        Node t1=head1;
        Node t2=head2;
        // insert all elements of list1 in the result
        while (t1!=null){
            push(t1.data);
            t1=t1.next;
        }
        // insert those elements of list2
        // that are not present
        while (t2!=null){
            if(!isDataPresent(t1,t2.data)){
                push(t2.data);
            }
            t2=t2.next;
        }
    }
    void getInterSection(Node head1,Node head2){
        Node t1=head1;
        // Traverse list1 and search each
        // element of it in list2.
        // If the element is present in
        // list 2, then insert the
        // element to result
        while (t1!=null) {
            if (isDataPresent(head2, t1.data)) {
                push(t1.data);
            }
            t1 = t1.next;
        }
    }
    /* Utility function to print list */
    void printList(){
        Node temp=head;
        while (temp!=null){
            System.out.println(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    void push(int new_data){
        Node new_node=new Node(new_data);
        new_node.next=head;
        head=new_node;
    }
    /* A utilty function that returns true
       if data is present in linked list
       else return false */
    boolean isDataPresent(Node head,int data){
        Node t=head;
        while (t!=null){
            if(t.data==data){
                return true;
            }
            t=t.next;
        }
        return false;
    }

    public static void main(String[] args) {
        InterSectionUnionLinkedList linkedList=new InterSectionUnionLinkedList();
        InterSectionUnionLinkedList linkedList1=new InterSectionUnionLinkedList();
        InterSectionUnionLinkedList unionLinkedList=new InterSectionUnionLinkedList();
        InterSectionUnionLinkedList interSectionUnionLinkedList=new InterSectionUnionLinkedList();
        linkedList.push(4);
        linkedList.push(5);
        linkedList.push(10);
        linkedList.push(5);
        linkedList.push(9);
        System.out.println("First list-");
        linkedList.printList();
        linkedList1.push(11);
        linkedList1.push(5);
        linkedList1.push(13);
        linkedList1.push(10);
        linkedList1.push(15);
        System.out.println("Second List-");
        linkedList1.printList();
        System.out.println("Union of two list");
        unionLinkedList.getUnition(linkedList.head,linkedList1.head);
        unionLinkedList.printList();
        System.out.println("Intersection of two list");
        interSectionUnionLinkedList.getInterSection(linkedList.head, linkedList1.head);
        interSectionUnionLinkedList.printList();
    }
}
