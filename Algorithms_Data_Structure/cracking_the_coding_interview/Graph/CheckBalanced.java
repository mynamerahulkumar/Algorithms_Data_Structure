/*
https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/#

 */

class  Node3{
    int data;
    Node3 left,right;
    public Node3(int d){
        this.data=d;
        this.left=this.right=null;
    }
}
class Height{
    int height=0;

}
public class CheckBalanced {
    Node3 root;
    boolean isBalancedTree(Node3 root,Height height){
        /*
        tree is empty
         */
        if(root==null){
            height.height=0;
            return true;
        }
        /* Get heights of left and right sub trees */

        Height lheight=new Height(),rheight=new Height();
        boolean l=isBalancedTree(root.left,lheight);
        boolean r=isBalancedTree(root.right,rheight);
        int lh=lheight.height,rh=rheight.height;
         /* Height of current node is max of heights of
           left and right subtrees plus 1*/
        height.height=(lh>rh)?lh:rh+1;
         /* If difference between heights of left and right
           subtrees is more than 2 then this node is not balanced
           so return 0 */
        if(Math.abs(lh-rh)>=2){
            return false;
        }
        /* If this node is balanced and left and right subtrees
           are balanced then return true */
        else{
            return l && r;
        }
    }

    public static void main(String[] args) {
        /* Constructed binary tree is
                   1
                 /   \
                2      3
              /  \    /
            4     5  6
            /
           7         */
        Height height=new Height();
        CheckBalanced binarTree=new CheckBalanced();
        binarTree.root=new Node3(1);
        binarTree.root.left=new Node3(2);
        binarTree.root.right=new Node3(3);
        binarTree.root.left.left=new Node3(4);
        binarTree.root.left.right=new Node3(5);
        binarTree.root.right.right=new Node3(6);
        binarTree.root.left.left.left=new Node3(7);


        if(binarTree.isBalancedTree(binarTree.root,height)){
            System.out.println("Binary tree is balanced");
        }
        else{
            System.out.println("Binary tree is not balanced");
        }
    }

}
