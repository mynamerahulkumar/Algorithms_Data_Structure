public class ReturnKthLast {
    static  Node head;
    static  class Node{
        int data;
        Node next;
          public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    //recursive solution
    static int recursiveSolution(Node head,int k){
        if(head==null){
            return 0;
        }
        int index=recursiveSolution(head.next,k)+1;
        if(index==k){
            System.out.println("Value at index "+k+"  is "+head.data);

        }
        return index;
    }
    //iterative
    static Node returnkthLast(int k){
        Node ptr1=head;
        Node ptr2=head;
        int i=0;
        while(i<k && ptr1!=null){
            ptr1=ptr1.next;
            i++;
        }
        if(ptr1==null){
            return null;
        }
        i=0;
        while(ptr1!=null){
            ptr1=ptr1.next;
            ptr2=ptr2.next;
            i++;
        }
        return ptr2;
    }

    public static void main(String[] args) {
        ReturnKthLast linkedList=new ReturnKthLast();
        linkedList.head=new Node(3);
        linkedList.head.next=new Node(2);
        linkedList.head.next.next=new Node(5);
        linkedList.head.next.next.next=new Node(6);
        linkedList.head.next.next.next.next=new Node(0);
        linkedList.head.next.next.next.next.next=new Node(0);
        int k=3;
        Node node=returnkthLast(k);
        if(node!=null){
            System.out.println("Kth element from last "+node.data);
        }
        else{
            System.out.println("Size of linkedlist is less than "+k);
        }
        System.out.println("Recursive solution");
        Node head1=linkedList.head;
        System.out.println(recursiveSolution(head1,k));
    }
}
