class FixedMultiStack {
    private int numberOfStacks;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public FixedMultiStack(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    /* Push value onto stack. */
    public void push(int stackNum, int value) throws FullStackException {
    /* Check that we have space for the next element */
        if (isFull(stackNum) {
            throw new FullStackException();
        }
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    /* Pop item from top stack. */
    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException;
        }
        int val = values[indexOfTop(stackNum)];
        values[indexOfTop(stackNum)] = 0;
        sizes[stackNum]--;
        return val;
    }

    /* Return if stack is empty. */
    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    /* Return if stack is full. */
    public boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }

    /* Return top element. */
    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        return values[indexOfTop(stackNum)];
    }

    /* Returns index of the top of the stack. */
    private int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum);
        return offset + size - 1;
    }

}

public class StackWithMin extends Stack<Integer> {
    Stack<Integer> s2;

    public StackWithMin() {
        s2 = new Stack<Integer>();
    }

    public void push(int value) {
        if (value <= getMin()) {
            s2.push(value);
        }
        super.push(value);
    }

    public int pop() {
        int val = super.pop();
        if (val == getMin()) {
            s2.pop();
        }
        return val;
    }

    public int min() {
        if (s2.empty()) {
            return Integer.MAX_VALUE;
        }
        return s2.peek();
    }
}


