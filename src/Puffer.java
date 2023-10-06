public interface Puffer <T> {
    boolean isEmpty();
    int size();
    int capacity();
    void insert(T data);
    T remove();
}
