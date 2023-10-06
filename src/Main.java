public class Main {
    public static void main(String[] args) {
        SchlangeMitEVL schlangeMitEVL = new SchlangeMitEVL<>();
        SchlangeMitEVL schlangeMitEVL1 = new SchlangeMitEVL<>();
        for (int i  = 0; i < 10; i++) {
            schlangeMitEVL.insert(i*2);
            schlangeMitEVL1.insert(i*2 + 1);
        }

        System.out.println(schlangeMitEVL);
        System.out.println(schlangeMitEVL1);

        GenericUtil genericUtil = new GenericUtil();
        genericUtil.insertInto(schlangeMitEVL1, schlangeMitEVL);

        System.out.println(schlangeMitEVL1);
    }
}