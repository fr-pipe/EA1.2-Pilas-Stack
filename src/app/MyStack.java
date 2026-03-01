package app;

public class MyStack<T> {
    private Node<T> top;
    private int size;

    public MyStack() {
        this.top = null;
        this.size = 0;
    }

    public void push(T value) {
        Node<T> n = new Node<>(value);
        n.next = top;
        top = n;
        size++;
    }

    public T pop() {
        if (isEmpty()) return null;
        T val = top.value;
        top = top.next;
        size--;
        return val;
    }

    public T peek() {
        if (isEmpty()) return null;
        return top.value;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    public void clear() {
        top = null;
        size = 0;
    }
}