public class Partition {
    static Node head;
    static  class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    /*
        1.Find the partition element
        2.Place one pointer before partition and another on one partition
        3.Replace the node based on constrain of x
     */
    static void partitionLinkedList(int x){
        Node ptr1=null; //before the x value
        Node ptr2=head; // on the x value
        int fnd=0;
        while (ptr2!=null) {
            if (ptr2.data == x) {
                fnd = 1;
                break;
            }
            ptr1 = ptr2;
            ptr2 = ptr2.next;
        }
        if(fnd==0){
            System.out.println(x+" values does not exist");
            return;
        }
        Node ptr3=null;
        Node ptr4=head;
        //move greater element before x to ahead of x
        if(ptr4.data!=x) {
            while (ptr4 != null) {
                if(ptr4.data==x){
                    break;
                }
                if(ptr4.data>x){
                    ptr3.next=ptr4.next;
                    ptr4.next=ptr2.next;
                    ptr2.next=ptr4;
                }
                ptr3=ptr4;
                ptr4=ptr4.next;
            }
        }
        //move smaller element ahead of  x to before x
        if(ptr4!=null) {
            while (ptr4 != null) {
                if(ptr4.data<x){
                    ptr1.next=ptr4;
                    ptr3.next=ptr4.next;
                    ptr1=ptr4;
                }
                ptr3=ptr4;
                ptr4=ptr4.next;
            }
        }


    }

    public static void main(String[] args) {

    }
}
