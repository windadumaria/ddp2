package myutil.mystack;

import myutil.mylist.MyList;
import myutil.mylist.Node;

public class MyStack {
    private MyList data;
    private int dataCounter = 0;
    
    public MyStack() {
        data = new MyList();
    }
    
    public void push(String item){
        data.insertLast(new Node(item));
        dataCounter += 1;
    }
    
    public String pop(){
        if(!this.isEmpty()){
            Node removed = data.deleteLast();
            dataCounter -= 1;
            return removed.getData();
        }else{
            return null;
        }
    }
    
    public String peek(){
        return data.getLast().getData();
    }
    
    public boolean isEmpty(){
        return dataCounter==0;
    }
    
    public void print(){
        data.printList();
    }
    
}
