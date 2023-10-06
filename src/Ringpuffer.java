import java.util.NoSuchElementException;

public class Ringpuffer <T> {
    T arr[];

    public Ringpuffer(int capacity) {
        this.arr = (T[]) new Object[capacity];
    }

    public int size() {
        int size = 0;
        for (int i = 0; i < this.arr.length; i++) {
            if (this.arr[i] != null) {
                size++;
            }
        }
        return size;
    }

    public T get(int pos) throws IllegalAccessException{
        if (pos >= this.arr.length || pos < 0 || this.arr[pos] == null) {
            throw new IllegalAccessException();
        } else {
            return this.arr[pos];
        }
    }

    public T set(int pos, T e) throws IllegalAccessException {
        if (pos >= this.arr.length || pos < 0 || this.arr[pos] == null) {
            throw new IllegalAccessException();
        } else {
            T temp = this.arr[pos];
            this.arr[pos] = e;
            return temp;
        }
    }

    public void addFirst(T e) throws IllegalAccessException {
        if (this.size() == this.arr.length) {
            throw new IllegalAccessException();
        } else {
            for (int i = this.size(); i > 0; i--) {
                this.arr[i] = this.arr[i - 1];
            }
            this.arr[0] = e;
        }
    }

    public void addLast(T e) throws IllegalAccessException {
        if (this.size() == this.arr.length) {
            throw new IllegalAccessException();
        } else {
            this.arr[this.size()] = e;
        }
    }

    public T removeFirst() {
        if (this.size() == 0) {
            throw new NoSuchElementException();
        } else {
            T temp = this.arr[0];
            for (int i = 0; i < this.size(); i++) {
                this.arr[i] = this.arr[i + 1];
            }
            this.arr[0] = null;
            return temp;
        }
    }

    public T removeLast() {
        if (this.size() == 0) {
            throw new NoSuchElementException();
        } else {
            T temp = this.arr[this.size() - 1];
            this.arr[this.size() - 1] = null;
            return temp;
        }
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < this.size(); i++) {
            s += " - " + this.arr[i];
        }
        return s;
    }
}
