package practice.linkedlist;

public class Main {
  public static void main(String[] args) {
    MyLinkedList<Integer> list = new MyLinkedList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);

    System.out.println(list.get(1));  // 2 출력
    list.delete(1);  // 인덱스 1의 요소 삭제
    list.delete(1);  // 인덱스 1의 요소 삭제


    for (Integer value : list) {
      System.out.print(value);  // 1과 3 출력
    }
  }
}
