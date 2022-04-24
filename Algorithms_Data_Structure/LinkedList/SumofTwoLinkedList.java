package LinkedList;

public class SumofTwoLinkedList {
    static Node head1,head2;

    static class  Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }
        /* Adds contents of two linked
    lists and return the head node
    of resultant list */
    Node addTwoLinkedList(Node first,Node second){
        // res is head node of the resultant list
        Node res=null;
        Node prev=null;
        Node temp=null;
        int carry=0,sum;
        // while both lists exist
        while (first!=null || second!=null){
            // Calculate value of next
            // digit in resultant list.
            // The next digit is sum
            // of following things
            // (i)  Carry
            // (ii) Next digit of first
            // list (if there is a next digit)
            // (ii) Next digit of second
            // list (if there is a next digit)
            sum=carry+(first!=null?first.data:0)+(second!=null?second.data:0);
            // update carry for next calulation
            carry=(sum>10)?1:0;
            // update sum if it is greater than 10
            sum=sum%10;
            // Create a new node with sum as data
            temp=new Node(sum);
            // if this is the first node then set
            // it as head of the resultant list
            if (res==null){
                res=temp;
            }
            else{
                prev.next=temp;
            }
            // Set prev for next insertion
            prev=temp;
            // Move first and second pointers
            // to next nodes
            if(first!=null){
                first=first.next;
            }
            if(second!=null){
                second=second.next;
            }
        }
        if(carry>0){
            temp.next=new Node(carry);
        }
        return res;
    }
    void  printList(Node head){
        while (head!=null){
            System.out.println(head.data+" ");
            head=head.next;
        }
        System.out.println("");
    }
    //Driver code
    public static void main(String[] args) {
        SumofTwoLinkedList linkedList=new SumofTwoLinkedList();
        // creating first list
        linkedList.head1=new Node(7);
        linkedList.head1.next=new Node(5);
        linkedList.head1.next.next=new Node(9);
        linkedList.head1.next.next.next=new Node(4);
        System.out.println("First list is");
        linkedList.printList(head1);
        linkedList.head2=new Node(3);
        linkedList.head2.next=new Node(5);
        linkedList.head2.next.next=new Node(9);
        linkedList.head2.next.next.next=new Node(4);
        System.out.println("Second list is");
        linkedList.printList(head2);
        // add the two lists and see the result
        Node rs=linkedList.addTwoLinkedList(head1,head2);
        System.out.println("sum of two linkedlist");
        linkedList.printList(rs);





    }

}
