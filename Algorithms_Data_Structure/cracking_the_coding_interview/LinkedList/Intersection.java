public class Intersection {
    static DeleteMiddle.Node head;
    static  class  Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static boolean interSectionPoint(Node head1,Node head2){
        int len1=0;
        int len2=0;
        Node node1=head1;
        while(node1!=null){
            len1++;
            node1=node1.next;
        }
        Node node2=head2;
        int diff=0;
        while(node2!=null){
            len2++;
            node2=node2.next;
        }
        if(len1>len2){
            diff=len1-len2;
            node1=head1;
            node2=head2;
        }
        else{
            diff=len2-len1;
            node1=head2;
            node2=head1;
        }
        //9->2-0-4 -5-6-7=7
        //1-3-4  -5-6-7=3
        while(diff>0){
            node1=node1.next;
            diff--;
        }
        while(node1!=null && node2!=null){
            if(node1==node2){
                return true;
            }
            node1=node1.next;
            node2=node2.next;
        }
        return false;



    }
}
