
public class LinkedList {

    private ListElement<T> head;

    public LinkedList() {
        head = null;
    }

    public int size() {
        int size = 0;
        ListElement<T> temp = head;
        while (temp) {
            temp = temp.next;
            size++;
        }
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public T value_at(int index) {
        if (index < 0 || index > size()) {
            System.out.println("Invalid index");
        }

        int i = 0;
        ListElement<T> temp = head;
        while (temp) {
            if (i == index) {
                break;
            }
            temp = temp.next;
            i++;
        }

        return temp.data;
    }

    public void push_front(value) {

    }

    public T pop_front() {
        if (head == null) {
            System.out.println("List is empty");
            return null;
        }
        ListElement<T> temp = head;
        head = head.next;
        return temp.data;
    }

    public void push_back(int value) {

    }

    public T pop_back() {
        if (head == null) {
            System.out.println("List is empty");
            return null;
        }
        ListElement<T> node = null;
        if (head.next == null) {
            node = head;
            head = null;
        }

        ListElement<T> temp = head;
        while (temp) {
            if (temp.next.next == null) {
                node = temp.next;
                temp.setNext(null);
            }
        }
        return node.data;
    }

}