import java.util.ArrayList;
import java.util.EmptyStackException;

public class StackPlate {
    ArrayList<Stack> stacks=new ArrayList<>();
    public int capacity;
    public void setOfStacks(int capacity){
        this.capacity=capacity;
    }
    public Stack getLastStack(){
        if(stacks.size()==0) return null;
        return stacks.get(stacks.size()-1);
    }
    public void push(int v){
        Stack stack=getLastStack();
        if(stack!=null && !stack.isFull()){
            stack.push(v);
        }
        else{
            Stack stack1=new Stack(capacity);
            stack1.push(v);
            stacks.add(stack1);
        }
    }
    public int pop(){
        Stack last=getLastStack();
        if(last==null) throw new EmptyStackException();
        int v=last.pop();
        if(last.size==0) stacks.remove(stacks.size()-1);
        return v;

    }
    public boolean isEmpty(){
        Stack last=getLastStack();
        return last==null||last.isEmpty();
    }
    public int popAt(int index){
        return leftShit(index,true);
    }
    public int leftShit(int index,boolean removeTop){
        Stack stack=stacks.get(index);
        int removed_item;
        if(removeTop) removed_item=stack.pop();
        else removed_item=stack.removeBottom();
        if(stack.isEmpty()){
            stacks.remove(index);
        }
        else if(stacks.size()>index+1){
            int v=leftShit(index+1,false);
            stack.push(v);
        }
        return removed_item;
    }


    static class Node{
        Node above;
        Node below;
        int data;
        public Node(int data){
            this.data=data;
            this.below=null;
            this.above=null;
        }
    }

    public class Stack {
        private int capacity;
        public Node top, bottom;
        public int size = 0;

        public Stack(int capacity) {
            this.capacity = capacity;
        }

        public boolean isFull() {
            return this.capacity == size;
        }

        public void join(Node above, Node below) {
            if (below != null) {
                below.above = above;
            }
            if (above != null) {
                above.below = below;
            }
        }

        public boolean push(int v) {
            if (size>=capacity) return false;
            size++;
            Node n=new Node(v);
            if(size==1){
                bottom=n;
            }
            join(n,top);
            top=n;
            return true;
        }
        public int pop(){
            Node t=top;
            top=top.below;
            size--;
            return t.data;
        }
        public boolean isEmpty(){
            return size==0;
        }
        public int removeBottom(){
            Node b=bottom;
            bottom=bottom.above;
            if(bottom!=null){
                bottom.below=null;
            }
            size--;
            return b.data;
        }
    }
}
