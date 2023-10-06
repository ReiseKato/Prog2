public class SchlangeMitEVL <T> implements Schlange {
    EVL schlange;

    public SchlangeMitEVL() {
        this.schlange = new EVL();
    }

    @Override
    public boolean isEmpty() {
        return this.schlange.isEmpty();
    }

    @Override
    public int size() {
        return this.schlange.size();
    }

    @Override
    public int capacity() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void insert(Object e) {
        this.schlange.addLast(e);
    }

    public T remove() {
        return (T)this.schlange.removeLast();
    }

    @Override
    public T front() {
        return (T)this.schlange.first.data;
    }

    public String toString() {
        return this.schlange.toString();
    }
}
