package myutil.myqueue;

import myutil.mylist.MyList;
import myutil.mylist.Node;

public class MyQueue {
    private MyList data;
    private int dataCounter = 0;
    
    public MyQueue() {
        data = new MyList();
    }
    
    public void add(String item){
        data.insertLast(new Node(item));
        dataCounter += 1;
    }
    
    public String remove(){
        if(!this.isEmpty()){
            Node removed = data.deleteFirst();
            dataCounter -= 1;
            return removed.getData();
        }else{
            return null;
        }
    }
    
    public String peek(){
        return data.getFirst().getData();
    }
    
    public boolean isEmpty(){
        return dataCounter==0;
    }
    
    public void print(){
        data.printList();
    }
    
    
    
    
}
