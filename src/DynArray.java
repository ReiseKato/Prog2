import java.util.NoSuchElementException;

public class DynArray <T> {
    public static void main(String[] args) {
        DynArray dynArray1 = new DynArray();
        dynArray1.addFirst(3);
        dynArray1.addlast(5);
        dynArray1.removeLast();
        System.out.println(dynArray1.toString());
    }
    private T[] dynArray;

    public DynArray() {
        dynArray = (T[]) new Object[1];
    }

    public int size(){
        int size = 0;
        for (int i = 0; i < dynArray.length; i++) {
            if (dynArray[i] != null) {
                size++;
            }
        }
        return size;
    }

    public int capacity() {
        return dynArray.length;
    }

    public T get(int pos) throws NoSuchElementException {
        if(dynArray[pos] == null || pos >= this.size()) {
            throw new NoSuchElementException("No element on this position!");
        } else {
            return dynArray[pos];
        }
    }

    public T set(int pos, T e) {
        T temp;
        if(pos >= this.size()) {
            throw new NoSuchElementException("No element on this position!");
        } else {
            temp = dynArray[pos];
            dynArray[pos] = e;
            return temp;
        }
    }

    public void addFirst(T e) {
        T[] dynArrayTemp = dynArray;
        if (this.size() == this.capacity()) {
            //T[] dynArrayTemp = dynArray;
            dynArray = (T[])new Object[capacity() + capacity()];
            for (int i = 0; i < dynArrayTemp.length; i++) {
                dynArray[i] = dynArrayTemp[i];
            }
        }
        if (dynArray[0] == null) {
            dynArray[0] = e;
        } else {
            for (int i = 0; i < dynArrayTemp.length; i++) {
                dynArray[i+1] = dynArrayTemp[i];
            }
            dynArray[0] = e;
        }
    }

    public void addlast(T e) {
        T[] dynArrayTemp = dynArray;
        if (this.size() == this.capacity()) {
            //T[] dynArrayTemp = dynArray;
            dynArray = (T[])new Object[this.capacity() + this.capacity()];
            for (int i = 0; i < dynArrayTemp.length; i++) {
                dynArray[i] = dynArrayTemp[i];
            }
        }
        for (int i = 0; i < dynArray.length; i++) {
            if (dynArray[i] == null) {
                dynArray[i] = e;
            }
        }
    }

    public T removeFirst() {
        T temp = dynArray[0];
        double sizeCheck = this.capacity()/4.0;
        for (int i = 0; i < dynArray.length - 1; i++) {
            dynArray[i] = dynArray[i+1];
        }
        T[] dynArrayTemp = dynArray;
        if (this.capacity() >= 4) {
            if (this.size() <= sizeCheck) {
                dynArray = (T[])new Object[this.capacity()/2];
                for (int i = 0; i < dynArrayTemp.length; i++) {
                    dynArray[i] = dynArrayTemp[i];
                }
            }
        }
        return temp;
    }

    public T removeLast() {
        T temp;
        T lastElement = dynArray[this.size() - 1];
        int i = 0;
        while (i < dynArray.length) {
            if (dynArray[i] != null) {
                temp = dynArray[i];
            } else {
                break;
            }
            i++;
        }
        i--;
        dynArray[i] = null;
        temp = dynArray[i];
        double sizeCheck = this.capacity()/4.0;
        T[] dynArrayTemp = dynArray;
        if (this.capacity() >= 4) {
            if (this.size() <= sizeCheck) {
                dynArray = (T[])new Object[this.capacity()/2];
                for (int j = 0; j < dynArrayTemp.length; j++) {
                    dynArray[j] = dynArrayTemp[j];
                }
            }
        }
        return lastElement;
    }

    public String toString(){
        String res = "";
        int i = 0;
        while (i < this.size() - 1) {
            res += dynArray[i] + " - ";
            i++;
        }
        res += dynArray[i];
        return res;
    }
}
