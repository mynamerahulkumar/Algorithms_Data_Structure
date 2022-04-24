import java.util.*;

public class AutoComplete {
   static   class TrieNode1{
        TrieNode1[] Trie;
        int cntNode;
        Set<Integer>wSet=wSet=new HashSet<>();;
        public  TrieNode1(){
            Trie=new TrieNode1[26];
            for(int i=0;i<26;i++){
                Trie[i]=null;
            }
            this.cntNode=1;
        }
        public  void addWeight(int w){
            if(!this.wSet.contains(w)){
                this.wSet.add(w);
            }
        }
    }
    Map<Integer,String>wMap=new HashMap<>();
    public  void updateWeightMap(List<String> list,List<Integer>W){
          for(int i=0;i<list.size() && i<W.size();i++){
              wMap.put(W.get(i),list.get(i)); // weight is unique
          }
    }
    public  void insertNode(TrieNode1 root,String s,int w){
        TrieNode1 temp=root;
        for(int i=0;i<s.length();i++){
            int a=s.charAt(i)-'a';
            if(temp.Trie[a]==null){
                temp.Trie[a]=new TrieNode1();// intialize weight and count node=1
                temp.Trie[a].addWeight(w);
            }
            else{
                temp.Trie[a].cntNode+=1;
                temp.Trie[a].addWeight(w);
                // update the count node and add new weight which has same prefix
            }
            temp=temp.Trie[a];
        }
    }
    /*
    1.we will traverse with the help of prefix

     */
    public List<String> predictWord(TrieNode1 root,String pre){
        TrieNode1 temp=root; // aaaa aacd abaa abaa aadcc // aa aba abc
        ArrayList<String>resList=new ArrayList<>();
        int found=1;
        for(int i=0;i<pre.length();i++){
            int a=pre.charAt(i)-'a';
            if(temp.Trie[a]!=null){
                if(i==pre.length()-1){
                    Set<Integer>wSet1=temp.Trie[a].wSet;
                    allWordPredicted(resList,wSet1);
                }
            }
            else if(temp.Trie[a]==null){
                found=0;
                break;
            }
            temp=temp.Trie[a];
        }
        if(resList.size()==0 && found==0){
            resList.add("-1");
            return resList;
        }
        else{
            return  resList;
        }
    }
    public  void allWordPredicted(List<String>resList,Set<Integer>wSet){
            Iterator itr=wSet.iterator();
            // sort based on weight
        ArrayList<Integer>list=new ArrayList<>();
            int count=0;
            while (itr.hasNext()){
                int w=(int)itr.next();
                list.add(w);
            }
            Collections.sort(list,Collections.reverseOrder());
            for(int i=0;i<list.size()&& i<5;i++){
                resList.add(wMap.get(list.get(i)));
            }
    }
    public static  void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of test cases:");
        int T=sc.nextInt();// number of test cases
        for(int k=0;k<T;k++) {
            System.out.println("Enter number of input cases:");
            int N = sc.nextInt();// number of input string
            System.out.println("Enter number of prefix cases:");
            int M = sc.nextInt();// number of prefix
            ArrayList<String> lStrings = new ArrayList<>();
            // create string input
            ArrayList<String> pList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                System.out.println("Enter input string:");
                String s = sc.next();
                lStrings.add(s);
            }
            // create wlist
            ArrayList<Integer> wList=new ArrayList<>();
            for(int i=0;i<N;i++){
                System.out.println("Enter weight of respective input:");
                int w=sc.nextInt();
                wList.add(w);
            }
            // create prefix input
            for (int i = 0; i < M; i++) {
                System.out.println("Enter prefix input");
                String s = sc.next();
                pList.add(s);
            }
            // update wmap

            // make Trie tree
            AutoComplete autoComplete=new AutoComplete();
            autoComplete.updateWeightMap(lStrings,wList);
            TrieNode1 root=new TrieNode1();
            for(int i=0;i<N;i++){
                autoComplete.insertNode(root,lStrings.get(i),wList.get(i));
            }
            for(int j=0;j<M;j++){
                List<String> resultList=new ArrayList<>();
                resultList=autoComplete.predictWord(root,pList.get(j));
                if(resultList.size()==1 && resultList.get(0)=="-1"){
                    System.out.print(-1);
                }
                else{
                    for(int i=0;i<resultList.size();i++){
                        System.out.print(resultList.get(i)+" ");
                    }
                }
                System.out.println();
            }
        }


    }
}
