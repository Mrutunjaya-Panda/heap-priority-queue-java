package minPriorityQueue;

public class Element<T> {
     T value;
     int priority;

    public Element(T value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    public T getValue() {
        return value;
    }

    public int getPriority() {
        return priority;
    }
}
