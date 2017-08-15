
// A templated Java singly linked list
public class ListElement<T> {

    private ListElement<T> next;
    private T data;

    public ListElement(T value) {
        data = value;
    }
    public ListElement<T> getNext() {
        return next;
    }
    public T getValue() {
        return data;
    }
    public void setNext(ListElement<T> elem) {
        next = elem;
    }
    public void setValue(T value) {
        data = value;
    }

}