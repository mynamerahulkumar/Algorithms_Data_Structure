package LinkedList;

public class DeleteNode {
    static Node head;

    static class  Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    void SortedInsert(Node newNode) {
        Node currentNode;
        if (head == null || newNode.data <= head.data) {
            currentNode = head;
            head = currentNode;
        }
        currentNode = head;
        while (currentNode.next != null & currentNode.data < newNode.data) {
            currentNode = currentNode.next;
        }
        newNode.next = currentNode.next;
        currentNode.next = newNode;
    }

    Node newNode(int d) {
        Node x = new Node(d);
        return x;
    }

    void printList(Node head) {
        while (head != null) {
            System.out.println(head.data + " ");
            head = head.next;
        }
    }

    void deleteNode(Node node, Node n) {
        if (node == n) {
            if (node.next == null) {
                System.out.println("List has only one element so It can't be deleted");
                return;
            } else {
                node.data = node.next.data;// copy the next element data
                //store the next address
                n = node.next;
                //remove the link of next node
                node.next = node.next.next;
                //free memory
                System.gc();
                return;
            }
        }
        //when it is not first node then follow the normal process find the previous node
        Node prev = node;
        while (prev.next != null && prev.next != n) {
            prev = prev.next;
        }
        //check node exist}
        if (prev.next==null){
            System.out.println("Node does not exist");
            return;
        }
        // remove node from linkedList
        node.next=node.next.next;
        //free memory
        System.gc();

    }

    public static void main(String[] args) {
//        DeleteNode linkedList=new DeleteNode();
//        Node nNode;
//        nNode=linkedList.newNode(5);
//        linkedList.SortedInsert(nNode);
//        nNode= linkedList.newNode(10);
//        linkedList.SortedInsert(nNode);
//        nNode=linkedList.newNode(7);
//        linkedList.SortedInsert(nNode);
//        nNode=linkedList.newNode(11);
//        linkedList.SortedInsert(nNode);
        DeleteNode list = new DeleteNode();
        list.head = new Node(12);
        list.head.next = new Node(15);
        list.head.next.next = new Node(10);
        list.head.next.next.next = new Node(11);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = new Node(6);
        list.head.next.next.next.next.next.next = new Node(2);
        list.head.next.next.next.next.next.next.next = new Node(3);

        System.out.println("Given Linked List :");
        list.printList(head);
        System.out.println("");

        // Let us delete the node with value 10
        System.out.println("Deleting node :" + head.next.next.data);
        list.deleteNode(head, head.next.next);

        System.out.println("Modified Linked list :");
        list.printList(head);
        System.out.println("");

    }
}
