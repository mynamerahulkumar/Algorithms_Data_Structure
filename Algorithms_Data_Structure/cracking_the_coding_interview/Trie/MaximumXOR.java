import java.util.Collections;
import java.util.Scanner;

public class MaximumXOR {
    /*
        A=[1,2,3,4,5]
        step 1) convert to binary each number
        step 2) add 1 to the Trie
        step 3) do xor of 2 with Trie and try to get max value
             3.1) if node has 2 values try to get which has max 0^1=1
        step 4)add 2 to the Trie
        step 5) step 3 and step 4 and get max xor from step 3
     */
   static class TrieNode3{
        TrieNode3[] Trie;
        int cntNode;
        int data;
        boolean isLeaf;
        public TrieNode3(){
            Trie=new TrieNode3[2];
            for(int i=0;i<2;i++){
                Trie[i]=null;
            }
            this.isLeaf=false;
            this.data=0;

        }
    }
    public void InsertNode(TrieNode3 root,String bits,int val){
        TrieNode3 temp=root;
        for(int i=0;i<bits.length();i++){
            int a=bits.charAt(i)-'0';
            if(temp.Trie[a]==null){
                temp.Trie[a]=new TrieNode3();
                temp.Trie[a].cntNode=1;
            }
            else{
                temp.Trie[a].cntNode++;// if two node has common bits add cnt node=2
            }
            temp=temp.Trie[a];
        }
        temp.isLeaf=true;
        temp.data=val;

    }
//    public  int getLeafNode(TrieNode3 root,int a){
//
//
//    }
    public int getMaxXor(TrieNode3 root,String bit2,int  val){
        int result=-1;
        TrieNode3 temp=root;
      //  System.out.println(bit1+"--"+val);
        if(temp.Trie[bit2.charAt(0)-'0']==null){
            return  result;
        }
        else{
            temp=temp.Trie[bit2.charAt(0)-'0'];
        }
        int foundJoint=0;
        for(int i=1;i<bit2.length();i++){
            int a=bit2.charAt(i)-'0';
            // check it has 1 both 0 then get which has xor 1
             if(temp.Trie[1]!=null && temp.Trie[0]!=null){
                 if(a==1){
                     temp=temp.Trie[0];
                 }
                 else{
                     temp=temp.Trie[1];
                 }
             }
            else if(temp.Trie[1]!=null){
                 temp=temp.Trie[1];
             }
             else if (temp.Trie[0]!=null) {
                 temp = temp.Trie[0];
             }
        }
        // end will result the data;
        if(temp!=null && temp.isLeaf){
            result=temp.data;
        }
        result=getXor(result,val);
        return  result;
    }
    public  int  getXor(int x,int y){
       int result=0;
       for(int i=0;i<32;i++){
           if(((1<<i)&x)!=((1<<i)&y)){
               result|=1<<i;
           }
       }
       return result;
    }
    public  String convertToBits(int val){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<32;i++){
            if(val>0){
                int num=val%2;
                if(num==1) {
                    sb.append('1');
                }
                else{
                    sb.append('0');
                }
                val=val/2;
            }
            else{
                sb.append('0');
            }
        }
        sb=sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//       // System.out.print("Enter size of array:");
//      //  int n=sc.nextInt();
//        int[]arr=new int[n];
//        int result=0;
//        for(int i=0;i<n;i++){
//            System.out.print("Enter input:");
//            arr[i]=sc.nextInt();
//        }
//        // make trie node and get max xor
//
//        if(n==1){
//            result=arr[0];
//        }
      //  arr[0]="00101";
        int[]arr=new int[3];
        int result=0;
        MaximumXOR obj=new MaximumXOR();
        TrieNode3 root=new TrieNode3();
        String []strArr=new String[3];
        strArr[0]="00101";
        strArr[1]="01010";
        strArr[2]="011111";
        arr[0]=5;
        arr[1]=10;
        arr[2]=15;
        for(int i=0;i<3;i++){
          //  String bits=obj.convertToBits(arr[i]);
            if(i==0){
              obj.InsertNode(root,strArr[i],arr[i]);
            }
            else{
                result=Math.max(obj.getMaxXor(root,strArr[i],arr[i]),result);
                System.out.println(result);
                if(i!=2) obj.InsertNode(root,strArr[i],arr[i]);
            }
        }
    }
}
