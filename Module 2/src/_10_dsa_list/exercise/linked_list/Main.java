package _10_dsa_list.exercise.linked_list;

public class Main {
    public static void main(String[] args) {
        System.out.println("Test");
        MyLinkedList<Integer> ll = new MyLinkedList(10);
        ll.addFirst(11);
        ll.addFirst(12);
        ll.addFirst(13);
        ll.addLast(15);
        ll.remove(2);
        System.out.println(ll.contains(9));
        System.out.println("Index 3: " + ll.indexOf(3));
        System.out.println("Size : " + ll.size());

    }
}
