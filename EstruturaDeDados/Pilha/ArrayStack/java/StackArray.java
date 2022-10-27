import java.io.IOException;

public class StackArray {

    private int [] stack;
    private int topo;

    public StackArray(int size) {
        if(size <=1)
            stack = new int[10];
        else
            stack = new int[size];
        topo=0;
    }

    public boolean push(int e){
        if(topo==stack.length) grow();

        stack[topo]=e;
        topo++;

        return true;

    }
    private void grow(){
        int [] newStack=new int[stack.length*2];
        for(int i=0; i<stack.length; i++)
            newStack[i]=stack[i];
        stack=newStack;
    }
    public int pop() throws IOException{
        if(topo>0){
            topo--;
            return stack[topo];
        }
        else
            throw new IOException("Pilha vazia");
    }
    public int top() throws IOException{
        if(topo>0)
            return stack[topo-1];
        else
            throw new IOException("Pilha vazia");
    }
    public int size(){
        return topo;
    }
    public int capacity(){
        return stack.length;
    }
    public boolean isEmpty(){
        return (topo==0);
    }
    public void clear(){
        topo=0;
        stack=new int[10];
    }    
}