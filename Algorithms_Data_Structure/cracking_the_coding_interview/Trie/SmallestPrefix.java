import java.util.ArrayList;

public class SmallestPrefix {
    class TrieNode{
        TrieNode Trie[];
        int cntNode;

        public TrieNode(){
            Trie=new TrieNode[256];
            for(int i=0;i<256;i++){
                Trie[i]=null;
            }
            this.cntNode=0;
        }
    }
    public  void insertNode(TrieNode A,String s){
        TrieNode temp=A;
        for(int i=0;i<s.length();i++){
            // if node char does not exist then add it
             if(temp.Trie[s.charAt(i)]==null){
                 temp.Trie[s.charAt(i)]=new TrieNode();
                 temp.Trie[s.charAt(i)].cntNode=1; // add cnt to i th node
             }
             else{
                 temp.Trie[s.charAt(i)].cntNode+=1;//inc cnt to i th node
             }
            temp=temp.Trie[s.charAt(i)];
        }
    }
    public  String makePrefix(TrieNode A,String s){
        StringBuilder sb=new StringBuilder();
        TrieNode temp=A.Trie[s.charAt(0)];
        sb.append(s.charAt(0));
        // by default first node will be always of string
        if(temp.cntNode==1){
            return  sb.toString();
        }
        for(int i=1;i<s.length();i++){
            temp=temp.Trie[s.charAt(i)];
            if(temp.cntNode>1){
                sb.append(s.charAt(i));
            }
            else if(temp.cntNode==1){
                sb.append(s.charAt(i));
                break;
            }
        }
        return  sb.toString();
    }
    public static void main(String[] args){
        SmallestPrefix obj=new SmallestPrefix();
        obj.prefix();
    }
    public  void prefix(){
        TrieNode root=new TrieNode();
        String[] list={"zebra", "dog", "duck", "dove" };
        ArrayList<String> resultList=new ArrayList<>();
        // make trie node
        for(int i=0;i<list.length;i++){
            insertNode(root,list[i]);
        }
        for(int i=0;i<list.length;i++){
            System.out.println(makePrefix(root,list[i]));
        }
    }
}
