public class DeleteMiddle {
    static Node head;
    static  class  Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static void deleteMiddleNode(Node middle){
        if(middle==null){
            return ;
        }
        System.out.println("Middle node deleted="+middle.data);
        /*
        Copy the the next element data to the middle element and delete next element
         */
        Node next=middle.next;
        middle.data=next.data;
        middle.next=next.next;
    }
    static void printLinkedList(){
        Node node=head;
        while (node!=null){
            System.out.print(node.data+" ");
            node=node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DeleteMiddle linkedList=new DeleteMiddle();
        linkedList.head=new Node(3);
        linkedList.head.next=new Node(2);
        linkedList.head.next.next=new Node(5);
        linkedList.head.next.next.next=new Node(6);
        linkedList.head.next.next.next.next=new Node(0);
        linkedList.head.next.next.next.next.next=new Node(1);
        linkedList.head.next.next.next.next.next.next=new Node(3);
        printLinkedList();
        System.out.println("delete middle node");
        deleteMiddleNode( linkedList.head.next.next.next);
        printLinkedList();

    }
}
