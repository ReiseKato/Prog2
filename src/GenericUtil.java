import java.util.Iterator;
import java.util.Random;
import java.util.random.*;

public class GenericUtil <T> {

    public T gambling(T one, T two) {
        Random random = new Random();
        int randNum = random.nextInt(2);
        if (randNum == 1) {
            return one;
        }
        return two;
    }

    public Puffer gambling(Puffer one, Puffer two) {
        Random random = new Random();
        int randNum = random.nextInt(2);
        if (randNum == 1) {
            return one;
        }
        return two;
    }

    public Schlange arrayToSchnlange(T arr[]) {
        Schlange schlange = new SchlangeMitEVL();
        for (int i = 0; i < arr.length; i++) {
            schlange.insert(arr[i]);
        }
        return schlange;
    }

    public void insertInto(Puffer puffer, T[] arr) {
        for (Object o : arr) {
            puffer.insert(o);
        }
    }

    public void insertInto(Puffer one, Puffer two) {
        int sizeOfSecondPuffer = two.size();
        for (int i = 0; i < sizeOfSecondPuffer; i++) {
            one.insert(two.remove());
        }
    }

//    NO NEED TO DO THIS TASK AS IT DOESN'T REALLY MAKE A LOT OF SENSE
//    public Folge getMinima(Puffer one, Puffer two) {
//        Folge folge = new SchlangeMitEVL<>();
//        int size = one.size();
//        int sizeFolge = two.size();
//        if (two.size() < one.size()) {
//            size = two.size();
//            sizeFolge = one.size();
//        }
//        for (int i = 0; i < size; i++) {
//            T data = (T)one.remove();
//
//        }
//    }

    public void printAll(Iterable iterable) {
        for (Object o : iterable) {
            System.out.println(o);
        }
    }
}
