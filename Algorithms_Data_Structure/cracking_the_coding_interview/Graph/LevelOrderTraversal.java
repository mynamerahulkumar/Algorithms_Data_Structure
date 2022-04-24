class  Node1{
    int data;
    Node1 left,right;
    public Node1(int d){
        this.data=d;
        this.left=this.right=null;
    }
}


public class LevelOrderTraversal {
    Node root;
    public LevelOrderTraversal(){
        root=null;
    }
    void  printLevelOrderTraversal(){
        int h=height(root);
        for(int i=1;i<=h;i++){
            levelOrder(root,i);
        }
    }
    int height(Node root){
        if(root==null){
            return 0;
        }
        int lHeight=height(root.left);
        int rHeight=height(root.right);
        if(lHeight>rHeight){
            return lHeight+1;
        }
        else{
            return rHeight+1;
        }
    }
    void levelOrder(Node root,int level){
        if(root==null){
            return;
        }
        if(level==1){
            System.out.println(root.data+" ");
        }
        else if(level>1) {
            levelOrder(root.left, level - 1);
            levelOrder(root.right, level - 1);
        }
    }

    public static void main(String[] args) {
        LevelOrderTraversal bTree=new LevelOrderTraversal();
        bTree.root=new Node(1);
        bTree.root.left=new Node(2);
        bTree.root.right = new Node(3);
        bTree.root.left.left = new Node(4);
        bTree.root.left.right = new Node(5);
        System.out.println("Level Order Traversal");
        bTree.printLevelOrderTraversal();
    }

}
