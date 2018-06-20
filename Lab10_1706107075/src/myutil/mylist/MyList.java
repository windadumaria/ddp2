package myutil.mylist;

public class MyList {
    private Node head = null;
    private Node tail = null;
    private int nodes = 0;
    
    public void insertLast(Node node){
        if(head==null){
            head = node;
            tail = node;
        }else{
            node.setPrev(tail);
            tail.setNext(node);
            tail = node;
        }
        nodes += 1;
    }
    
    public Node deleteLast(){
        Node last = tail;
        if(nodes == 0){
            return last;
        }else if(nodes==1){
            head = null;
            tail = null;
        }else{
            tail = tail.getPrev();
            tail.setNext(null);
        }
        last.setPrev(null);
        nodes -= 1;
        return last;
    }
    
    public Node deleteFirst(){
        Node first = head;
        if(nodes == 0){
            return first;
        }else if(nodes==1){
            head = null;
            tail = null;
        }else{
            head = head.getNext();
            head.setPrev(null);
        }
        first.setNext(null);
        nodes -= 1;
        return first;
    }
    
    public void printList(){
        Node pointer = head;
        while(pointer!=null){
            System.out.println(pointer.getData());    
            pointer = pointer.getNext();
        }
    }
    
    public Node getFirst(){
        return head;
    }
    
    public Node getLast(){
        return tail;
    }
    
}
