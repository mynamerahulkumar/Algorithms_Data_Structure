import java.util.HashMap;
import java.util.Map;

public class LevelOrderMakeTree {
   class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int x){
            this.val=x;
            this.left=null;
            this.right=null;
        }
    }
    public TreeNode solve(int[] A) {
        int n=A.length;
        Map<Integer,TreeNode> map=new HashMap<>();
        TreeNode head=new TreeNode(A[0]);
        TreeNode nd=head;
        map.put(0,nd);
        for(int i=0;i<n && 2*i+2<n;i++){
            if(A[i]==-1) continue;
            int left=2*i+1;
            int right=2*i+2;
            if(map.containsKey(i)){
                TreeNode node=map.get(i);
                if((A[left])!=-1){
                    node.left=new TreeNode(A[left]);
                    map.put(left,node.left);
                }
                if((A[right])!=-1){
                    node.right=new TreeNode(A[right]);
                    map.put(right,node.right);
                }
            }
        }
        return head;
    }
    public void postOrder(TreeNode A){
       if(A==null) return;
       postOrder(A.left);
       postOrder(A.right);
        System.out.println(A.val);
    }

    public static void main(String[] args) {
        int[]arr={ 1, 2,4 ,-1, 3, -1, 5, 7, -1, -1 ,6 ,-1, 8, -1, -1, -1, -1 };
        LevelOrderMakeTree obj=new LevelOrderMakeTree();
        TreeNode head=obj.solve(arr);
    }
}
