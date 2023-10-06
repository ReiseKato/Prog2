//import java.util.NoSuchElementException;
//
//public class FolgeMitDynArray <T> implements Folge <T> {
////    public  static void main(String[] args) {
////        FolgeMitDynArray folge = new FolgeMitDynArray();
////        folge.insert(1, "r");
////        folge.insert(7, "k");
////        folge.insert(2, "z");
////        folge.remove(50);
////        System.out.println(folge);
////    }
//    private T[] dynArray;
//
//    public FolgeMitDynArray() {
//        dynArray = (T[]) new Object[1];
//    }
//
//    @Override
//    public T get(int pos) {
//        return dynArray[pos - 1];
//    }
//
//    @Override
//    public T set(int pos, T e) {
//        T result = dynArray[pos - 1];
//        dynArray[pos - 1] = e;
//        return result;
//    }
//
//    @Override
//    public T remove(int pos) throws NoSuchElementException {
//        if (pos < 1 || pos > dynArray.length) {
//            throw new NoSuchElementException("No such position");
//        }
//        T removed = dynArray[pos - 1];
//        T dynArrayTemp[] = (T[]) new Object[dynArray.length - 2];
//        for (int i = pos - 1; i < dynArray.length - 1; i++) {
//            dynArray[i] = dynArray[i + 1];
//        }
//        dynArray[dynArray.length - 1] = null;
//        for (int i = 0; i < dynArrayTemp.length; i++) {
//            dynArrayTemp[i] = dynArray[i];
//        }
//        dynArray = dynArrayTemp;
//        return removed;
//    }
//
//    @Override
//    public void insert(int pos, T e) {
//        if (pos > dynArray.length) {
//            pos = dynArray.length;
//        }
//        T dynArrayTemp[] = (T[]) new Object[dynArray.length + 1];
//        for (int i = 0; i < pos - 1; i++) {
//            dynArrayTemp[i] = dynArray[i];
//        }
//        dynArrayTemp[pos - 1] = e;
//        for (int i = pos; i < dynArrayTemp.length - 1; i++) {
//            dynArrayTemp[i + 1] = dynArrayTemp[i];
//        }
//        if (pos != dynArray.length) {
//            T lastElement = dynArray[dynArray.length - 2];
//            dynArrayTemp[dynArray.length - 1] = lastElement;
//        }
//        dynArray = dynArrayTemp;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        if (dynArray.length == 0) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    @Override
//    public int size() {
//        return dynArray.length;
//    }
//
//    @Override
//    public int capacity() {
//        return dynArray.length;
//    }
//
//
//    public String toString() {
//        String result = "";
//        int i = 0;
//        while (dynArray[i] != dynArray[dynArray.length - 2]) {
//            result += dynArray[i] + " - ";
//            i++;
//        }
//        result += dynArray[dynArray.length - 2];
//        return result;
//    }
//}
//
