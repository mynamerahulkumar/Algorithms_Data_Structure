package CTI.linedList.Stack_Queue;

import java.util.Stack;

public class StackWithMin2 extends Stack<Integer> {
    Stack<Integer> s2;
    StackWithMin2(){
        s2=new Stack<Integer>();
    }
    public void push(int value){
        if(value<min()){
            s2.push(value);
        }
        super.push(value);
    }
    public Integer pop(){
        int value=super.pop();
        if(value==min()){
            s2.pop();
        }
        return value;
    }
    public Integer peek(){
        return super.peek();
    }

    public int min(){
        if(s2.isEmpty()){
            return Integer.MAX_VALUE;
        }
        else{
           return s2.peek();
        }
    }

    public static void main(String[] args) {
        StackWithMin2 stack=new StackWithMin2();
        stack.push(4);
        stack.push(5);
        stack.push(3);
        stack.push(100);
        stack.push(99);
        for(int i=0;i<stack.size();i++){
            System.out.println(stack.min());
        }
    }
}
