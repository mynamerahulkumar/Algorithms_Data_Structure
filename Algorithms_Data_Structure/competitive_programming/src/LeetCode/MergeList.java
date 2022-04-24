package LeetCode;

import java.util.ArrayList;
import java.util.List;

//Definition for singly-linked list.
 class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        List<ListNode> nodePoint=new ArrayList<>();
        for(int i=0;i<lists.length;i++){
            nodePoint.add(lists[i]);
        }
        ListNode head=null;
        // find the first node first;
        ListNode temp=null;
        int min=Integer.MAX_VALUE;
        int idx=0;
        for(int i=0;i<nodePoint.size();i++){
            if(nodePoint.get(i).val<min){
                temp=nodePoint.get(i);
                min=temp.val;
                idx=i;
            }
        }
        head=temp;
        //move the first node;
        nodePoint.set(idx,nodePoint.get(idx).next);
        ListNode m1=head;
        boolean isAllNodeVisted =false;
        while(!isAllNodeVisted){
            int cnt=0;
            ListNode t1=null;
            int k=0;
            min=Integer.MAX_VALUE;
            for(int i=0;i<nodePoint.size();i++){
                if(nodePoint.get(i)!=null){
                    if(nodePoint.get(i).val<min){
                        t1=nodePoint.get(i);
                        k=i;
                        min=t1.val;
                        cnt=1;
                    }
                }
            }
            if(cnt==0){
                isAllNodeVisted=true;
            }
            m1.next=t1;
            m1=t1;
            if(nodePoint.get(k)!=null){
                nodePoint.set(k,nodePoint.get(k).next);
            }
        }
        return head;
    }
}
public class MergeList {
    public static void main(String[] args) {
        ListNode head=new ListNode(1,null);
        head.next=new ListNode(4,head.next);
        head.next.next=new ListNode(5,head.next.next);
        ListNode head2=new ListNode(1,null);
        head2.next=new ListNode(3,head2.next);
        head2.next.next=new ListNode(4,head2.next.next);
        ListNode head3=new ListNode(2,null);
        head3.next=new ListNode(6,head3.next);
        ListNode[] list=new ListNode[3];
        list[0]=head;
        list[1]=head2;
        list[2]=head3;
        Solution solution=new Solution();
        ListNode mergNode=solution.mergeKLists(list);
        while (mergNode!=null){
            System.out.println(mergNode.val);
            mergNode=mergNode.next;
        }
    }
}
