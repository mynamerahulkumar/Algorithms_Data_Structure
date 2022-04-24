class  Node4{
    int data;
    Node4 left,right;
    public Node4(int d){
        this.data=d;
        this.left=this.right=null;
    }
}
public class ValidateBST {
    //root of binary tree
    Node4 root;
    //check the previous node of binary tree
    Node4 prev;
    boolean isBST(){
        prev=null;
        return isBST(root);
    }
    /*
    inorder traversal return the bst tree in ascending order .
    we have to just check current node is greater than prev node
     */
    boolean isBST(Node4 root){
        /*

        traverse a tree inorder fashion and keep track of previous element
         */
        if(root!=null) {
            if (!isBST(root.left)) {
                return false;
            }
            /*
            keep track of distinct element
             */
            if (prev != null && prev.data>=root.data){
                return false;
            }
            prev = root;
            if(!isBST(root.right)) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        ValidateBST bst=new ValidateBST();
        bst.root=new Node4(10);
        bst.root.left=new Node4(8);
        bst.root.right=new Node4(11);
        bst.root.left.left=new Node4(6);
        if(bst.isBST()){
            System.out.println("valid BST");
        }
        else{
            System.out.println("Invalid BST");
        }
    }
}
