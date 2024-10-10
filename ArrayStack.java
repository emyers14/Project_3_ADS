public class ArrayStack<E> implements Stack<E> {
    public static final int CAPACITY = 1000;    
    private E[] data;  
    private int t = -1;  
    
    public ArrayStack() {
        this(CAPACITY);
    }

    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];  
    }

    public int size() {
        return t + 1;
    }

    public boolean isEmpty() {
        return t == -1;
    }

    public void push(E e) throws IllegalStateException {
        if (size() == data.length) throw new IllegalStateException("Stack is full.");
        data[++t] = e;
    }

    public E top() {
        if (isEmpty()) return null;
        return data[t];
    }

    public E pop() {
        if (isEmpty()) return null;
        E answer = data[t];
        data[t] = null;
        t--;
        return answer;
    }

    // Method to transfer elements from one stack to another
    public static <E> void transfer(Stack<E> S, Stack<E> T) {
        while (!S.isEmpty()) {
            T.push(S.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> S = new ArrayStack<>();
        Stack<Integer> T = new ArrayStack<>();

        // Add elements to S
        S.push(1);
        S.push(2);
        S.push(3);

        // Transfer elements from S to T
        transfer(S, T);

        // Output contents of T
        while (!T.isEmpty()) {
            System.out.println(T.pop());
        }
    }
}
