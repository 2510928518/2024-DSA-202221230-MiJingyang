package oy.tol.tra;

public class StackImplementation<E> implements StackInterface<E> {

   private Object [] itemArray;
   private int capacity;
   private int currentIndex = -1;
   private static final int DEFAULT_STACK_SIZE = 10;


   public StackImplementation() throws StackAllocationException {
    this (DEFAULT_STACK_SIZE); 
   }

   public StackImplementation(int capacity) throws StackAllocationException {
      if (capacity<2){
         throw new StackAllocationException("Capacity must be at least 2.");
      }else {
         this.capacity = capacity;
         this.itemArray = new Object[capacity];
      }

   }

   public int capacity() {
      return this.capacity;
      
   }

   public void push(E element) throws StackAllocationException, NullPointerException {
      if (this.size() == this.capacity()) {
         Object[] tmp = new Object[this.capacity * 2 + 1];

         for(int i = 0; i < this.itemArray.length; ++i) {
            tmp[i] = this.itemArray[i];
         }

         this.itemArray = tmp;
         tmp = null;
         this.capacity = this.capacity * 2 + 1;
      }

      if (element == null) {
         throw new NullPointerException("Cannot push null element onto the stack.");
      } else {
         this.itemArray[++this.currentIndex] = element;
      }         
   }
   
   @SuppressWarnings("unchecked")
   @Override
   public E pop() throws StackIsEmptyException {
      if (isEmpty()) {
         throw new StackIsEmptyException("Stack is empty.");
     }
   E poppedElement = (E) itemArray[currentIndex];
     currentIndex--;
     return poppedElement;
   }

   @SuppressWarnings("unchecked")
   @Override
   public E peek() throws StackIsEmptyException {
      if (isEmpty()) {
         throw new StackIsEmptyException("Stack is empty.");
     }

     return (E) itemArray[currentIndex]; 
   }

   @Override
   public int size() {
      return this.currentIndex +1;
      
   }

   @Override
   public void clear() {
      currentIndex = -1;
      
   }

   @Override
   public boolean isEmpty() {
      return this.currentIndex == -1;
      
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder("[");
      for (var index = 0; index <= currentIndex; index++) {
         builder.append(itemArray[index].toString());
         if (index < currentIndex) {
            builder.append(", ");
         }
      }
      builder.append("]");
      return builder.toString();
   }
}