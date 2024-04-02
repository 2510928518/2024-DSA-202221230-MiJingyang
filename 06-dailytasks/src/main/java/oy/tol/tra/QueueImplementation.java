package oy.tol.tra;

public class QueueImplementation<E> implements QueueInterface<E>{
    private Object [] itemArray;
    private int capacity;
    private int size = 0;
    private int front = 0;
    private int rear = -1;
    private static final int DEFAULT_QUEUE_SIZE = 10;

    public QueueImplementation() throws QueueAllocationException {
        this(DEFAULT_QUEUE_SIZE);
     }

    public QueueImplementation(int capacity) throws QueueAllocationException {
        if(capacity<2){ 
            throw new QueueAllocationException("Capacity must be at least 2.");
         }else{
         itemArray=new Object[capacity];
         this.capacity=capacity;}
     }

    @Override
    public int capacity() {
        return this.capacity;
    }

    @Override
    public void enqueue(E element) throws QueueAllocationException, NullPointerException {
        if(size==capacity){
            Object[] tmp=new Object[this.capacity*2+1];
            int indexOfItemArray=front;
            int indexOfTmp=0;
            int loopTime=size;
            while(loopTime-->0){
                tmp[indexOfTmp++]=itemArray[indexOfItemArray];
                indexOfItemArray=(indexOfItemArray+1)%capacity;
            }
            front=0;
            rear=indexOfTmp-1;
            itemArray=tmp;
            tmp=null;
            capacity=capacity*2+1;
         }
        else if(element==null){
           throw new NullPointerException();
        }
        rear=(rear+1)%capacity;
        itemArray[rear]=element;
        size++;        
    }


    @Override
    public E dequeue() throws QueueIsEmptyException {
        E returnE =element();
        front=(front+1)%capacity;
        size--;
        return returnE;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E element() throws QueueIsEmptyException {
        if(isEmpty()){
            throw new QueueIsEmptyException("Queue is empty");
        }else{
        return (E)itemArray[front];}
    }

    @Override
    public int size() {
       return size;
    }
  
    @Override
    public void clear() {
       front=0;
       rear=-1;
       size=0;
    }

    @Override
    public boolean isEmpty() {
       return size==0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        if (!isEmpty()) {
            int index = front;
            do {
                builder.append(itemArray[index].toString());
                if (index != rear) {
                    builder.append(", ");
                }
                index = (index + 1) % capacity;
            } while (index != (rear + 1) % capacity);
        }
        builder.append("]");
        return builder.toString();
    }
}