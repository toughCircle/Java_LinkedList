package practice.linkedlist;

import linkedList.LinkedList;

public class Stack<T> extends LinkedList<T> {
// add
public void add(T data) {
    this.insert(0, data);
}
// pop
public T pop() {
    T data = this.get(0);
    this.delete(0);
    return data;
}
// peek
public T peek() {
    T top = this.get(0);
    return top;
}

}
