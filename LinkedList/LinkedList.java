
public class LinkedList {

    private ListElement<T> head;

    public LinkedList() {
        head = null;
    }

    public int size() {
        int size = 0;
        ListElement<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public T value_at(int index) {
        if (index < 0 || index >= size()) {
            System.out.println("Invalid index");
        }

        int i = 0;
        ListElement<T> temp = head;
        while (temp.next != null && i < index) {
            temp = temp.next;
            i++;
        }

        return temp.data;
    }

    public void push_front(T value) {
        ListElement<T> node = new ListElement<T>(value);

        node.setNext(head);
        head = node;
    }

    public T pop_front() {
        if (head == null) {
            System.out.println("List is empty");
            return null;
        }
        ListElement<T> temp = head;
        head = head.next;
        return temp.getValue();
    }

    public void push_back(int value) {
        ListElement<T> node = new ListElement<T>(value);
        node.setNext(null);

        ListElement<T> temp = head;
        if (head == null) {
            head = node;
        }

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.setNext(node);
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
        while (temp.next.next != null) {
            temp = temp.next;
        }
        node = temp.next;
        temp.setNext(null);

        return node.getValue();
    }

    public void insert(int index, T value) {
        if (index < 0 || index >= size()) {
            System.out.println("Invalid index");
        }

        ListElement<T> node = new ListElement<T>(value);
        node.setNext(null);

        if (head == null) {
            head = node;
        }

        int i = 0;
        ListElement<T> prev = null;
        ListElement<T> curr = head;
        while (curr.next != null && i < index) {
            prev = curr;
            curr = curr.next;
            i++;
        }

        node.setNext(curr);
        prev.setNext(node);
    }


    public void erase(int index) {
        if (index < 0 || index >= size()) {
            System.out.println("Invalid index");
        }
        if (head == null) {
            System.out.println("Empty list");
        }
        if (head.next == null) {
            head = null;
        }

        int i = 0;
        ListElement<T> prev = null;
        ListElement<T> curr = head;
        while (curr.next != null && i < index) {
            prev = curr;
            curr = curr.next;
            i++;
        }
        prev.setNext(curr.getNext());
    }

    public ListElement<T> removeValue(T value) {
        if (head == null) {
            System.out.println("List is empty");
        }
        ListElement<T> temp = head;

        if (temp.getValue() == value) {
            return head.next;
        }

        while (temp.next != null) {
            if (temp.next.getValue() == value) {
                temp.next = temp.next.next;
                return head;
            }
            temp = temp.next;
        }
        return head;
    }


}