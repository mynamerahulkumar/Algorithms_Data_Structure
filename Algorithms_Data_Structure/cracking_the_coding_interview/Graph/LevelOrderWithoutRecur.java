import java.util.LinkedList;
import java.util.Queue;

class  Node2{
    int data;
    Node2 left,right;
    public Node2(int d){
        this.data=d;
        this.left=this.right=null;
    }
}
public class LevelOrderWithoutRecur {
    Node2 root;
    void printLevelOrder(){
        Queue<Node2>queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node2 tempNode=queue.poll();
            System.out.println(tempNode.data+" ");
            if(tempNode.left!=null){
                queue.add(tempNode.left);
            }
            if(tempNode.right!=null){
                queue.add(tempNode.right);
            }
        }
    }

    public static void main(String[] args) {
        LevelOrderWithoutRecur binaryTree=new LevelOrderWithoutRecur();
        binaryTree.root=new Node2(1);
        binaryTree.root.left=new Node2(2);
        binaryTree.root.right=new Node2(3);
        binaryTree.root.left.left=new Node2(4);
        binaryTree.root.left.right=new Node2(5);
        System.out.println("Level order traversal ");
        binaryTree.printLevelOrder();
    }
}
