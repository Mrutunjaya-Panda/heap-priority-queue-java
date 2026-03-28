package maxPriorityQueue;
import java.util.ArrayList;

import minPriorityQueue.Element;
import minPriorityQueue.PriorityQueueException;
public class mPriority_Queue<T> {
    private ArrayList<Element<T>> heap;

    //constructor to initialize the heap
    public mPriority_Queue() {
        heap = new ArrayList<>();
    }

    public void insert(T value, int priority){
        Element<T> newElement = new Element<>(value, priority);
        heap.add(newElement); //add the new element at the end of the heap
        int childIndex = heap.size() - 1; //index of the newly added element
        int parentIndex = (childIndex - 1)/2;

        //heapify up process to maintain the max-heap property
        while(childIndex > 0 && heap.get(childIndex).getPriority() > heap.get(parentIndex).getPriority()){
            //swap
            Element<T> temp = heap.get(childIndex);
            heap.set(childIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp);
            //update indices for the next iteration
            childIndex = parentIndex;
            parentIndex = (childIndex - 1)/2;

        }

    }

    public int size(){
        return heap.size(); //i.e no. of nodes in the heap
    }

    public T getMax() throws PriorityQueueException {
        if (isEmpty()) {
            throw new PriorityQueueException();
        }
        return heap.get(0).getValue(); // Since it's a max-heap, the maximum element is at the root (index 0)
    }

    public T removeMax() throws PriorityQueueException {
        if(isEmpty()){
            throw new PriorityQueueException();        
        }
        T maxValue = heap.get(0).getValue();
        Element<T> lasElement = heap.get(heap.size() - 1);
        //replace the root element with the last element and remove the last element from the heap
        heap.set(0, lasElement);
        heap.remove(heap.size() - 1);
        int parentIndex = 0;
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;
        //heapify down process to maintain the max-heap property
        while(leftChildIndex < heap.size()){
            int maxIndex = parentIndex;
            if(heap.get(leftChildIndex).getPriority() > heap.get(maxIndex).getPriority()){
                maxIndex = leftChildIndex;
            }
            if(rightChildIndex < heap.size() && heap.get(rightChildIndex).getPriority() > heap.get(maxIndex).getPriority()){
                maxIndex = rightChildIndex;
            }
            if(maxIndex == parentIndex){
                break; //the max-heap property is satisfied, so we can stop the process
            }
            //swap the parent and the maximum child elements
            Element<T> temp = heap.get(parentIndex);
            heap.set(parentIndex, heap.get(maxIndex));
            heap.set(maxIndex, temp);
            //update indices for the next iteration
            parentIndex = maxIndex;
            leftChildIndex = 2 * parentIndex + 1;
            rightChildIndex = 2 * parentIndex + 2;

        }
        return maxValue;
    }

    public boolean isEmpty(){
        return heap.size() == 0; //if there are no nodes in the heap, then it is empty
    }
}
