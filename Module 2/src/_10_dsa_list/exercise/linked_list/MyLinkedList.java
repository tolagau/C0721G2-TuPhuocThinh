package _10_dsa_list.exercise.linked_list;

public class MyLinkedList<E> {
    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }

    }

    private Node head;
    private int numberNode = 0;

    public MyLinkedList() {
    }

    public int size() {
        return numberNode;
    }

    //trả về data theo index
    public Object get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    //phương thức kiểm tra 1 phần tử có tồn tại trong ds hay không?
    public boolean contains(E element) {
        Node temp = head;
        while (temp.next != null) {
            if (temp.data.equals(element)) {
                return true;
            }
            temp = temp.next;
            if (temp.data.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E element) {
        Node temp = head;
        for (int i = 0; i < numberNode; i++) {
            if ((E) temp.getData() == element) {
                return i;

            }
            temp = temp.next;
        }
        return -1;
    }

    public void addLast(E e) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(e);
        numberNode++;
    }

    public void addFirst(E e) {
        Node temp = head;
        head = new Node(e);
        head.next = temp;
        numberNode++;
    }

    public void add(int index, E data) {
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1 && temp != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numberNode++;
    }

    public E remove(int index) {
        if (index < 0 || index > numberNode) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = head;
        Object data;
        if (index == 0) {
            data = temp.data;
            head = head.next;
        } else {
            for (int i = 0; i < index - 1 && temp.next != null; i++) {
                temp = temp.next;
            }
            data = temp.next.data;
            temp.next = temp.next.next;
        }
        numberNode--;
        return (E) data;
    }

    public boolean remove(E element) {
        if (head.data.equals(element)) {
            remove(0);
            return true;
        } else {
            Node temp = head;
            while (temp.next != null) {
                if (temp.next.data.equals(element)) {

                    temp.next = temp.next.next;
                    numberNode--;
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }

    public MyLinkedList<E> clone() {
        if (numberNode == 0) {
            throw new NullPointerException();
        }
        MyLinkedList<E> temp = new MyLinkedList<E>();
        Node tempNode = head;
        temp.addFirst((E) tempNode.data);
        tempNode = tempNode.next;
        while (tempNode != null) {
            temp.addLast((E) tempNode.data);
            tempNode = tempNode.next;
        }
        return temp;
    }
//    public void clear(){
//        numberNode = 0;
//        for (int i = 0; i < ; i++){
//            index[i] = null;
//        }
//    }

}
