package practice.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {
  private Node<T> head;
  private int size;

  public MyLinkedList() {
    head = null;
    size = 0;
  }

  // add
  public void add(T data) {
    Node<T> newNode = new Node<>(data);

    if (head == null) {
      head = newNode;
    } else {
      Node<T> current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = newNode;
    }
    size++;
  }

  // get
  public T get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
    Node<T> current = head;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }
    return current.data;
  }

  // delete

  public void delete(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
    if (index == 0) {
      head = head.next;
    } else {
      Node<T> current = head;
      for (int i = 0; i < index; i++) {
        current = current.next;
      }
      current.next = current.next.next;
    }
    size--;
  }

  // Iterator
  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      private Node<T> current = head;
      @Override
      public boolean hasNext() {
        return current != null;
      }

      @Override
      public T next() {
        if (!hasNext()) {
          throw  new NoSuchElementException();
        }
        T data = current.data;
        current = current.next;
        return data;
      }
    };
  }

}
