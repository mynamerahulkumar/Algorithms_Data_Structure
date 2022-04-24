import java.util.Stack;

public class QueueStack <T>{
    Stack<T> stackNewEst,stackOldest;
    public QueueStack(){
        stackNewEst=new Stack<T>();
        stackOldest=new Stack<T>();
    }
    public int size(){
        return stackNewEst.size()+stackOldest.size();
    }
    public void add(T value){
        /*
        Push onto stackNewest ,which always has the newest element on top
         */
        stackNewEst.push(value);
    }
    /*
    move elements from stackNewest into stackOldest .This is usually done so that we can do operation on stackoldest
     */
    private void shiftStacks(){
        if(stackOldest.isEmpty()){
            while (stackNewEst.isEmpty()){
                stackOldest.push(stackNewEst.pop());
            }
        }
    }
    public T peek(){
        shiftStacks();
        T data=stackOldest.peek();
        return data;
    }
    public T remove(){
        shiftStacks();
        return stackOldest.pop();
    }

}
