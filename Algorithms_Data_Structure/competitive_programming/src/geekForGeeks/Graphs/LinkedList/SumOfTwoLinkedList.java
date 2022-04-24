package geekForGeeks.Graphs.LinkedList;

import java.util.Stack;

public class SumOfTwoLinkedList {
    static Node l1,l2,result;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static void pushL1(int data){
        Node newNode=new Node(data);
        newNode.next=l1;
        l1=newNode;
    }
    public static void pushL2(int data){
        Node newNode=new Node(data);
        newNode.next=l2;
        l2=newNode;
    }
    public static Node addTwoNumber(){
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        while (l1!=null){
            stack1.push(l1.data);
            l1=l1.next;
        }
        while (l2!=null){
            stack2.push(l2.data);
            l2=l2.next;
        }
        int carry=0;
        result=null;
        while (!stack1.isEmpty()|| !stack2.isEmpty()){
            int a=0,b=0;
            if(!stack1.isEmpty()){
                a=stack1.pop();
            }
            if(!stack2.isEmpty()){
                b=stack2.pop();
            }
            int total=a+b+carry;
            Node temp=new Node(total%10);
            carry=total/10;
            if(result==null){
                result=temp;
            }
            else{
                temp.next=result;
                result=temp;
            }

        }
        if(carry!=0){
            Node newNode=new Node(carry);
            newNode.next=result;
            result=newNode;
        }
        return result;
    }
    public static void PrinSumList(){
        while (result!=null){
            System.out.println(result.data+" ");
            result=result.next;
        }
    }

    public static void main(String[] args) {
        int arr1[]={5, 6, 7};
        int arr2[]={1, 8};
        int size1=3;
        int size2=2;
        for(int i=0;i<size1;i++){
            pushL1(arr1[i]);
        }
        for(int i=0;i<size2;i++){
            pushL2(arr2[i]);
        }
        addTwoNumber();
        PrinSumList();
    }
}
