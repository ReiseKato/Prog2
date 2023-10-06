import java.util.NoSuchElementException;

public class SchlangeMitArray <T> implements Schlange {
    private int maxGroesse;
    private T arr[];

    public SchlangeMitArray(int maxGroesse) {
        this.maxGroesse = maxGroesse;
        this.arr = (T[]) new Object[this.maxGroesse];
    }

    // Interface Methods from Puffer
    @Override
    public boolean isEmpty() {
        for (int i = 0; i < maxGroesse; i++) {
            if (arr[i] != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        if (this.isEmpty()) {
            return 0;
        } else {
            int size = 0;
            for (int i = 0; i < this.maxGroesse; i++) {
                if (arr[i] != null) {
                    size++;
                }
            }
            return size;
        }
    }

    @Override
    public int capacity() {
        return this.maxGroesse;
    }

    @Override
    public void insert(Object data){
        if (this.size() == this.capacity()) {
            throw new IllegalStateException();
        } else {
            arr[this.size()] = (T)data;
        }
    }
    @Override
    public T remove() {
        if (this.size() == 0) {
            throw new NoSuchElementException();
        } else {
            T tempData = this.arr[0];
            for (int i = 0; i < this.maxGroesse - 1; i++) {
                this.arr[i] = this.arr[i + 1];
            }
            this.arr[this.maxGroesse - 1] = null;
            return tempData;
        }
    }

    //Interface Methods from Schlange
    @Override
    public T front() {
        if (this.size() == 0) {
            throw new NoSuchElementException();
        } else {
            return this.arr[0];
        }
    }

    // Print Method
    public String toString() {
        String result = "";
        for (int i = 0; i < this.maxGroesse; i++) {
            if (i == this.maxGroesse - 1) {
                result += this.arr[i];
            } else {
                result += this.arr[i] + " - ";
            }
        }
        return result;
    }
}
