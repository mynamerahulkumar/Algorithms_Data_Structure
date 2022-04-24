import java.util.Stack;

public class StackMin extends Stack<Integer> {
    Stack<Integer> min=new Stack<>();
    public void push(int x){
        if(isEmpty()==true){
            super.push(x);
            min.push(x);
        }
        else{
            super.push(x);
            int y=min.pop();
            min.push(y);
            if(x<y){
                min.push(x);
            }
        }
    }
    public Integer pop(){
       int x=super.pop();
       int y=min.pop();
       if(y!=x){
           min.push(y);
       }
       return y;
    }
    public int getMin(){
        int x=min.pop();
        min.push(x);
        return x;
    }

}
