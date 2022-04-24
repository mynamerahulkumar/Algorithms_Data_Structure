import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
public class EqualPartition {
    Map<TreeNode,Integer> map=new HashMap<>();
    int totalSum=0;
    public int solve(TreeNode A) {
        TreeNode root=A;
        inorder(root);
        System.out.println(totalSum+"--");
        if(totalSum%2!=0) return 0;// since sum is odd so it can't be divided into two parts
        root=A;
        subTreeSum(root);
        int sum=totalSum/2;
        System.out.println(totalSum+"--"+sum);
        for(Map.Entry<TreeNode,Integer> element:map.entrySet()){ // if anyone of subtree has sum=totalSum/2 return 1;
            if(element.getValue()==sum){
                return 1;
            }
        }
        return 0;

    }
    public int subTreeSum(TreeNode A){
        if(A==null){
            return 0;
        }
        map.put(A,(A.val)+subTreeSum(A.left)+subTreeSum(A.right)); // for each subtree get the sum
        return map.get(A);
    }
    // intialise map
    public void inorder(TreeNode A){
        if(A==null){
            return;
        }
        Stack<TreeNode> st=new Stack<>();
        while(!st.isEmpty() || A!=null)
        {
            while(A!=null){
                st.push(A);
                A=A.left;
            }
            if(A==null){
                A=st.pop();
                totalSum+=A.val;
                A=A.right;
            }
        }
    }
    TreeNode root;
    public  EqualPartition(){
        this.root=null;
    }
    public  EqualPartition(int val){
        root=new TreeNode(val);
    }


    public static void main(String[] args) {
        EqualPartition tree=new EqualPartition();
        tree.root=new TreeNode(5);
        tree.root.left=new TreeNode(3);
        tree.root.right=new TreeNode(7);
        tree.root.left.left=new TreeNode(4);
        tree.root.left.right=new TreeNode(6);
        tree.root.right.left=new TreeNode(5);
        tree.root.right.right=new TreeNode(6);
        tree.solve(tree.root);
    }
}
