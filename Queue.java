package practice.linkedlist;

public class Queue<T> extends MyLinkedList<T> {
    // enqueue
    public void enqueue(T data) {
        this.add(data);
    }

    // dequeue
    public T dequeue() {
        T data = this.get(0);
        this.delete(0);
        return data;
    }
    // peek
    public T peek() {
        return this.get(0);
    }
}
