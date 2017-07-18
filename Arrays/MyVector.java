public class MyVector {

    private int size, capacity;
    private int[] data;

    public MyVector(int capacity) {
        if (capacity < 1) {
            System.out.println("Invalid size");
        }

        int trueCapacity = 16;
        while (capacity > trueCapacity) {
            trueCapacity *= 2;
        }

        capacity = trueCapacity;
        size = 0;
        data = new int[trueCapacity];
    }

    public int getSize() { return size; }
    public int getCapacity() { return capacity; }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int newSize) {
        if (size < newSize) {
            if (size == capacity) {
                increaseSize();
            }
        }
        else if (size > newSize) {
            if (size < capacity / 4) {
                decreaseSize();
            }
        }
    }

    private void increaseSize() {
        int newCapacity = capacity * 2;

        int newData = new int[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        data = newData;
        capacity = newCapacity;
    }

    private void decreaseSize() {
        int newCapacity = capacity / 2;
        if (newCapacity < 16) {
            newCapacity = 16;
        }

        int newData = new int[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        data = newData;
        capacity = newCapacity;
    }

    public int getValueAt(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        return data[index];
    }

    public int findValue(int value) {
        int index = -1;

        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                index = i;
                break;
            }
        }

        return index;;
    }

}