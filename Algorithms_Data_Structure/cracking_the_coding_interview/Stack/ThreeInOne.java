import java.util.EmptyStackException;

public class ThreeInOne {
    private int numberOfStack=3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;
    public ThreeInOne(int stackSize){
        stackCapacity=stackSize;
        values=new int[stackSize*numberOfStack];
        sizes=new int[numberOfStack];
    }
    /*
    push value onto stack
     */
    public void push(int stackNum,int value) {
        if (isFull(stackNum)) {
           // throw new FullStackException();
        }

    /*
    increment stack pointer and then update top value
     */
        sizes[stackNum]++;
        values[indexOfTop(stackNum)]=value;
    }
    /*
    pop value from the stack
     */
    public int pop(int stackNum){
        if(isEmpty(stackNum)){
            throw  new EmptyStackException();
        }
        int topIndex=indexOfTop(stackNum);
        int value=values[topIndex];
        values[topIndex]=0;//clear
        sizes[stackNum]--;//shrink
        return value;
    }
    /*
    peek from the stack
     */
    public int peek(int stackNum){
        if(isEmpty(stackNum)){
            throw  new EmptyStackException();
        }
        int topIndex=indexOfTop(stackNum);
        int value=values[topIndex];
        return value;
    }
    /*
    Return if stack is empty
     */
    public boolean isEmpty(int stackNum){
        return sizes[stackNum]==0;
    }
    /*
    return if stack is full
     */
    public boolean isFull(int stackNum){
        return sizes[stackNum]==stackCapacity;
    }
    /*
    Return index of top of the stack
     */
    private int indexOfTop(int stackNum){
        int offset=stackNum*stackCapacity;
        int size=sizes[stackNum];
        return offset+size-1;
    }

}
