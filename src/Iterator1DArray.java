import java.util.Iterator;
import java.util.NoSuchElementException;

public class Iterator1DArray <T> implements Iterator<T> {
    private T[] arr;
    int i;
    int start;
    int end;

    public Iterator1DArray(T[] arr) {
        this.arr = arr;
        this.i = 0;
    }

    @Override
    public boolean hasNext() {
        return (i < this.arr.length);
    }

    @Override
    public T next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return this.arr[i++];
    }

    public void next(int start) {
        this.i = start;
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        while (this.i < this.arr.length) {
            System.out.println(this.next());
        }
//        return this.arr[i++];
    }

    public void next(int start, int end) {
        this.i = start;
        if (end == start || end == this.arr.length) {
            throw new NoSuchElementException();
        }
        while (this.i < end) {
            System.out.println(this.next());
        }
    }
}
