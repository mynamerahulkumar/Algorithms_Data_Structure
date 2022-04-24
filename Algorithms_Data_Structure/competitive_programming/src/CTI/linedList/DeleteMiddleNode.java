package CTI.linedList;


public class DeleteMiddleNode {
    Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static DeleteMiddleNode insert(int val,DeleteMiddleNode list){
        Node node=new Node(val);
        if(list.head==null){
            list.head=node;
            return list;
        }
        else{
            Node t1=list.head;
            while (t1.next!=null){
                t1=t1.next;
            }
            t1.next=node;
        }
        return list;
    }
    public static void print(DeleteMiddleNode list){
        Node t1=list.head;
        while (t1!=null){
            System.out.println(t1.data);
            t1=t1.next;
        }

    }
    public static void main(String[] args) {
       DeleteMiddleNode list=new DeleteMiddleNode();
       list=insert(3,list);
       list=insert(4,list);
       list=insert(5,list);
       list=insert(10,list);
       list=insert(1,list);
       print(list);
    }
}
