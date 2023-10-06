import java.util.NoSuchElementException;

public class EVL <T> {
    Listenelement first = null ; // Zeiger auf erstes Element
    class Listenelement { // Listenelement als innere Klasse
        T data ;
        Listenelement next = null ; // Zeiger auf naechstes Element
        Listenelement (T data ) { // Konstruktor
            this.data = data ;
        }
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public void addFirst(T e) {
        Listenelement element = new Listenelement(e); // neues Listenelement
        if (this.isEmpty()) {
            this.first = element;
        } else {
            element.next = this.first;
            this.first = element;
        }
    }

    public Listenelement getFirst() {
        return this.first;
    }

    public T getLast() {
        Listenelement temp = this.first;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp.data;
    }

    public void addLast(T e) {
        Listenelement element = new Listenelement(e);
        if (this.isEmpty()) {
            this.first = element;
        } else {
            Listenelement temp = this.first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = element;
        }
    }

    public T removeLast() {
        Listenelement temp =this.first;
        if (this.first.next == null && first.data != null) {
            return first.data;
        }
        while (temp.next.next != null) {
            temp = temp.next;
        }
        T tempData = temp.next.data;
        temp.next = null;
        return tempData;
    }

    public boolean contains(T e) {
        Listenelement temp = this.first;
        while (temp.next != null) {
            if (temp.data == e) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int size() {
        int size = 0;
        Listenelement temp = this.first;
        while (temp.next != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }

//    public void zip(EVL<T> other) {
//        if (this.size() == 0) {
//            this.first = other.first;
//            Listenelement temp = this.first;
//            while (other.size() != 0) {
//                temp.next = other.getFirst();
//            }
//        } else if (other.size() != 0 && this.size() != 0) {
//            Listenelement temp = this.first;
//            while (other.size() != 0 || this.size() != 0) {
//                temp.next = this.getFirst();
//                temp.next = other.getFirst();
//            }
//            if (this.size() == 0) {
//                while (other.size() != 0) {
//                    temp.next = other.getFirst();
//                }
//            } else if (other.size() == 0) {
//                temp.next = this.getFirst();
//            }
//        }
//        other = null;
//    }

    public Listenelement removeFirst() throws NoSuchElementException {
        /*
        if (first == null) {
            throw new NoSuchElementException("Speicher leer");
        } else {
            Listenelement removed = first;
            first = first.next;
            size--;
            return removed;
        }

         */
        Listenelement removed = first;
        first = first.next;
        return removed;
    }

    public T removeFirstData() {
        T data = first.data;
        first = first.next;
        return data;
    }

    public void zip(EVL<T> other) {
        if (this.size() == 0) {
            this.first = other.first;
            Listenelement temp = first;
            for (int i = 0; i < other.size(); i++) {
                temp.next = other.removeFirst();
            }
        } else if(other.size() == 0) {
            Listenelement temp = first;
            for (int i = 0; i < this.size(); i++) {
                temp = temp.next;
            }
        } else {
            Listenelement temp = this.removeFirst();
            //Listenelement tempOther = other.first;
            temp.next = other.removeFirst();
            while (other.size() != 0 || this.size() != 0) {
                temp.next = this.removeFirst();
                temp.next = other.removeFirst();
            }
            if (this.size() == 0) {
                while (other.size() != 0) {
                    temp.next = other.removeFirst();
                }
            } else if (other.size() == 0) {
                temp.next = this.removeFirst();
            }
        }
    }

    public String toString() {
        String toReturn = "";
        Listenelement temp = this.first;
        while (temp != null) {
            if (temp == this.first) {
                toReturn += temp.data;
            } else {
                toReturn += " - " + temp.data;
            }
            temp = temp.next;
        }
        return toReturn;
    }

}