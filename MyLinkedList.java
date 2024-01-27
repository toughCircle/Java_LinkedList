package practice.linkedlist;

import java.util.Iterator;

public class MyLinkedList<E> implements Iterable<E> {
  Node<E> head = null;

  private static class Node<E> {
    E data;
    Node<E> next;

    Node(E data) {
      this.data = data;
      this.next = null;
    }
  }

  private class LinkedListIterator implements Iterator<E> {
    Node<E> curr;
    public LinkedListIterator() {
      curr = head;
    }

    @Override
    public boolean hasNext() {
      return curr != null;
    }

    @Override
    public E next() {
      if (!hasNext()) {
        throw new java.util.NoSuchElementException();
      }
      E data = curr.data;
      curr = curr.next;
      return data;
    }
  }

  @Override
  public Iterator<E> iterator() {
    return new LinkedListIterator();
  }
//    public class MyIterator implements Iterator<T> {
//        // 컬렉션과 관련된 필드들...
//
//        @Override
//        public boolean hasNext() {
//            // 다음 요소가 있는지 확인하는 로직
//        }
//
//        @Override
//        public T next() {
//            // 다음 요소를 반환하는 로직
//        }
//
//        // 필요에 따라 remove() 같은 다른 메서드를 구현할 수도 있음
//    }

  public void add(E data) {
    // 비어있는 경우
    Node<E> newNode = new Node<>(data);
    System.out.println("add : " + String.valueOf(data));
    if (head == null) {
      head = newNode;
      return;
    }
    // 마지막 위치 찾기
    Node<E> curr = head;
    while (curr.next != null) {
      curr = curr.next;
    }
    curr.next = newNode;
  }

  public void insert(int idx, E data) {
    // insert(2, 7);
    Node<E> newNode = new Node<>(data);

    // 비어있는 경우
    if (head == null) {
      System.out.println("List is empty.");
      return;
    }
    System.out.printf("insert [index: %d]: %s\n", idx, String.valueOf(data));
    if (idx == 0) {
      newNode.next = head;
      head = newNode;
      return;
    }
    // i번째 위치 찾기
    int i = 0;
    Node<E> curr = head;
    while (i < idx - 1 && curr.next != null) {
      curr = curr.next;
      i += 1;
    }
    if (i < idx - 1) {
      System.out.println("Index out of range.");
      return;
    }
    newNode.next = curr.next;
    curr.next = newNode;
  }

  public E get(int idx) {
    // 비어있는 경우
    if (head == null) {
      System.out.println("List is empty.");
      return null;
    }
    // i번째 위치 찾기
    int i = 0;
    Node<E> curr = head;
    while (i < idx && curr.next != null) {
      curr = curr.next;
      i += 1;
    }
    if (i < idx) {
      System.out.printf("Index out of range. Last %dth element returned.\n", i);
      return curr.data;
    }
    return curr.data;
  }

  public void delete(int idx) {
    if (head == null) {
      System.out.println("List is empty.");
      return;
    }

    System.out.printf("%dth node deleted \n", idx);
    if (idx == 0) {
      head = head.next;
      return;
    }

    Node<E> prev = null;
    Node<E> curr = head;

    int i = 0;
    while (i < idx && curr.next != null) {
      prev = curr;
      curr = curr.next;
      i += 1;
    }
    if (i < idx) {
      System.out.printf("리스트의 길이를 벗어나는 인덱스입니다. 마지막 {%d}번째 원소를 삭제합니다.\n", i);
    }
    // prev == null 인 경우
    if (prev == null) {
      head = null;
      return;
    }
    prev.next = curr.next;
  }

  public void printList() {
    if (head == null) {
      System.out.println("리스트가 비어있습니다.");
      return;
    }
    // 10 15 20 25
    Node<E> curr = head;
    while (curr != null) {
      System.out.print(String.valueOf(curr.data) + " ");
      curr = curr.next;
    }
    System.out.println();
  }


}
