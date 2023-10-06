public class TimeTestSchlange {
    public static void main(String args[]) {

        // Schlange mit EVL
        long start = System.currentTimeMillis();

        SchlangeMitEVL schlangeMitEVL = new SchlangeMitEVL<Integer>();
        for (int i = 0; i < 100000; i++) {
            schlangeMitEVL.insert(i);
        }
        for (int j = 0; j < 100000; j++) {
            schlangeMitEVL.remove();
        }

        long finish = System.currentTimeMillis();
        long elapsed = finish - start;

        System.out.println("Schlange mit EVL: " + elapsed);

        // Schlange mit Array
        start = System.currentTimeMillis();

        SchlangeMitArray schlangeMitArray = new SchlangeMitArray<Integer>(100000);
        for (int i = 0; i < 100000; i++) {
            schlangeMitArray.insert(i);
        }
        for (int j = 0; j < 100000; j++) {
            schlangeMitArray.remove();
        }

        finish = System.currentTimeMillis();
        elapsed = finish - start;

        System.out.println("Schlange mit Array: " + elapsed);
    }
}
