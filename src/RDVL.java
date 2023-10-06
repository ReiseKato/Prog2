import java.util.List;
// still working on it
public class RDVL <T> {
    Listenelement entry = null;
    class Listenelement { // Listenelement als innere Klasse
        T data ;
        Listenelement prev; // Zeiger auf vorheriges Element
        Listenelement next; // Zeiger auf naechstes Element
        Listenelement (T data ) { // Konstruktor
            this.data = data ;
        }
    }

    public boolean isEmpty() {
        if (this.entry == null) {
            return true;
        }
        return false;
    }

    public int size() {
        int size = 0;
        Listenelement temp = this.entry;
        Listenelement tempLast = this.entry.prev;
        while (temp.next != tempLast) {
            size++;
        }
        return size;
    }

    public void add(T e) {
        Listenelement element = new Listenelement(e);
        if (this.entry == null) {
            this.entry = element;
        } else {
            this.entry.prev = element;
            element.next = this.entry;
        }
    }

    public T remove() {
        T removedData = this.entry.data;
        this.entry = this.entry.next;
        return removedData;
    }

    public T element() {
        return this.entry.data;
    }

    public void next(int s) {
        for (int i = 0; i < s; i++) {
            this.entry = this.entry.prev;
        }
    }

    public void prec(int s) {
        for (int i = 0; i < s; i++) {
            this.entry = this.entry.next;
        }
    }

    public String toString() {
        String s = "";
        Listenelement temp = this.entry;
        for (int i = 0; i < this.size(); i++) {
            s += " - " + temp.data;
            temp = temp.next;
        }
        return s;
    }
}
