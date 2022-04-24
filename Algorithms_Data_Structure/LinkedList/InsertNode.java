package LinkedList;

import java.util.LinkedList;

public class InsertNode {
    Node head;
     class Node{
         int data;
         Node next;
         Node(int d){
             data=d;
             next=null;
         }
     }
     /* function to insert a node*/
    void SortedNode(Node new_node){
        Node currentNode;
        if (head==null || new_node.data<= head.data){
            new_node.next=head;
            head=new_node;
        }
        else{
            currentNode=head;
            while (currentNode.next!=null &&  currentNode.data<new_node.data){
                currentNode=currentNode.next;
            }
            new_node.next=currentNode.next; // insert at appropriate position
            currentNode.next=new_node;
        }
    }
    Node newNode(int d){
        Node x =new Node(d);
        return x;
    }
    void printList(){
        Node temp=head;
        while (temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
    public static  void main(String[] arg){
        InsertNode linkedList=new InsertNode();
        Node nNode;
        nNode=linkedList.newNode(5);
        linkedList.SortedNode(nNode);
        nNode= linkedList.newNode(10);
        linkedList.SortedNode(nNode);
        nNode=linkedList.newNode(7);
        linkedList.SortedNode(nNode);
        nNode=linkedList.newNode(11);
        linkedList.SortedNode(nNode);
        System.out.println("Created Linked List");
        linkedList.printList();


    }

}
