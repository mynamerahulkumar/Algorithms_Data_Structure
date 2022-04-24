//A binary Tree node
class Node{
    int data;
    Node left,right;
    Node(int d){
        this.data=d;
        left=right=null;
    }
}
/*
    1.Get the middle of the array and make it root
    2.Recursively do the same for left and right
        a)Get the middle of left half and make it left child of the root
        created in step 2;
        b)Get the middle of right half and make it right of root created in step 1.
 */
public class MinimalTreeBST {
    static Node root;
    Node sortedArrayToBST(int[]arr,int start,int end){
        /*base case
         if(l>r) for binary search
         */
        if(start>end){
            return null; //leaf node
        }
        int mid=start+(end-start)/2;
        Node node=new Node(arr[mid]);
        node.left=sortedArrayToBST(arr,start,mid-1);
        node.right=sortedArrayToBST(arr,mid+1,end);
        return node;
    }
    void preOrder(Node node){
        if(node==null){
            return;
        }
        System.out.println(node.data+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args) {
        MinimalTreeBST bTree=new MinimalTreeBST();
        int[]arr=new int[]{1,2,3,4,5,6,7};
        int n=arr.length;
        root=bTree.sortedArrayToBST(arr,0,n-1);
        bTree.preOrder(root);
    }

}
