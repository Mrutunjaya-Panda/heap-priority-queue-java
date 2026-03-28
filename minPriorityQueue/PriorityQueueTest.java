package minPriorityQueue;
import maxPriorityQueue.mPriority_Queue;
public class PriorityQueueTest {
    
    public static void main(String[] args) throws PriorityQueueException {
        Priority_Queue<String> pq = new Priority_Queue<>();
        pq.insert("A", 3);
        pq.insert("B", 1);
        pq.insert("C", 2);

        System.out.println("Size of priority queue: " + pq.size()); // Output: 3
        System.out.println("Minimum element: " + pq.getMin()); // Output: B

        System.out.println("Removing minimum element: " + pq.removeMin()); // Output: B
        System.out.println("Minimum element after removal: " + pq.getMin()); // Output: C

        //for max priority queue
        mPriority_Queue<String> mpq = new mPriority_Queue<>();
        mpq.insert("X", 5);
        mpq.insert("Y", 10);
        mpq.insert("Z", 15);

        System.out.println("Size of max priority queue: " + mpq.size()); // Output: 3
        System.out.println("Maximum element: " + mpq.getMax()); // Output: Z

        System.out.println("Removing maximum element: " + mpq.removeMax()); // Output: Z
        System.out.println("Maximum element after removal: " + mpq.getMax()); // Output: Y

    }
}
