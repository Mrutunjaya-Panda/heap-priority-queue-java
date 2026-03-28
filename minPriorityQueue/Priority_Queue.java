package minPriorityQueue;
//import java.lang.reflect.Array;
import java.util.ArrayList;
public class Priority_Queue<T> {
    //each element in the priority queue is a pair of (value, priority)
    //heap internally will be represented as an array list of pairs

    private ArrayList<Element<T>> heap;

    public Priority_Queue() {
        heap = new ArrayList<>();
    }

    public void insert(T value, int priority){
        Element<T> newElement = new Element<>(value, priority);
        heap.add(newElement); //add the new element at the end of the heap
        int childIndex = heap.size() - 1; //index of the newly added element
        int parentIndex = (childIndex - 1) / 2; //index of the parent element

        //heapify up process to maintain the min-heap property
        while(childIndex > 0 && heap.get(childIndex).priority < heap.get(parentIndex).priority){
            //swap the child and parent elements
            Element<T> temp = heap.get(childIndex);
            heap.set(childIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp);

            //update the child and parent indices for the next iteration
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
    }

    public int size(){
        return heap.size(); //i.e no. of nodes in the heap
    }

    public T getMin() throws PriorityQueueException{
      if(isEmpty()){
          throw new PriorityQueueException();
      }
      return heap.get(0).value; //since minimum heap is used, the minimum element will be at the root node (index 0)
    }

    public T removeMin() throws PriorityQueueException{
        if(isEmpty()){
            throw new PriorityQueueException();
        }
        T minValue = heap.get(0).value;
        Element<T> lastElement = heap.get(heap.size() - 1);
        heap.set(0, lastElement);
        heap.remove(heap.size() - 1); //remove the last element from the heap
        int parentIndex = 0;
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;

        //heapify down process to maintain the min-heap property
        while(leftChildIndex < heap.size()){
            int minIndex = parentIndex;
            if(heap.get(leftChildIndex).priority < heap.get(minIndex).priority){
                minIndex = leftChildIndex;
            }
            if(rightChildIndex < heap.size() && heap.get(rightChildIndex).priority < heap.get(minIndex).priority){
                minIndex = rightChildIndex;
            }
            if(minIndex == parentIndex){
                break; //the min-heap property is satisfied, so we can stop the process
            }
            //swap the parent and the minimum child elements
            Element<T> temp = heap.get(parentIndex);
            heap.set(parentIndex, heap.get(minIndex));
            heap.set(minIndex, temp);

            //update the parent and child indices for the next iteration
            parentIndex = minIndex;
            leftChildIndex = 2 * parentIndex + 1;
            rightChildIndex = 2 * parentIndex + 2;
        }
        //return the minimum value that was removed from the heap
        return minValue;

    }

    public boolean isEmpty(){
        if(size()==0){
            return true;
        }
        return false;
    }
}
