import java.util.List;

public class SortList {
    class ListNode{
        public int val;
        public ListNode next;
         ListNode(int x){
             val=x;
             next=null;
         }
    }
    public ListNode head=null;
    public ListNode tail=null;
    public void addNode(int a){
        ListNode newNode=new ListNode(a);
        if(head==null){
            head=newNode;
            tail=newNode;
        }
        else{
            tail.next=newNode;
            tail=newNode;
        }
    }
    public ListNode sortList(ListNode A) {
        /*
            1.Use merge sort
            2.First divide the array into two parts from middile
            3.o to mid nd mid_1 to n;
            4.Do step 3 and step 2 in recursive
            5.return merge(A,B)
        */

        ListNode head=A;
        if(head==null || head.next==null){
            return head;
        }
        ListNode mid=getMid(head);
        if(mid.next==null) head.next=null;
        ListNode x=head;
        ListNode  y=mid.next;
        mid.next=null;
        x=sortList(x);
        y= sortList(y);
        return merge(x,y);
    }
    public ListNode getMid(ListNode B){
        ListNode h=B;
        if(h==null ||h.next==null){
            return h;
        }
        ListNode slow=h;
        ListNode fast=h;
        while(slow!=null && fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode merge(ListNode x,ListNode y){
        ListNode headA=x;
        ListNode headB=y;
        ListNode head=null;
        if(headA==null){
            return headB;
        }
        if(headB==null){
            return headA;
        }
        if(headA.val<headB.val){
            head=headA;
            headA=headA.next;
        }
        else{
            head=headB;
            headB=headB.next;
        }
        ListNode t=head;
        while(headA!=null && headB!=null){
            if(headA.val<headB.val){
                t.next=headA;
                t=headA;
                headA=headA.next;
            }
            else{
                t.next=headB;
                t=headB;
                headB=headB.next;
            }
        }
        if(headA!=null){
            t.next=headA;
        }
        if(headB!=null){
            t.next=headB;
        }
        return head;

    }

    public static void main(String[] args) {
        SortList list=new SortList();
        list.addNode(3);
        list.addNode(4);
        list.addNode(2);
        list.addNode(8);
        list.sortList(list.head);
    }
}
