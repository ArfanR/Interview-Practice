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
}