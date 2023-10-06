public class PufferPaar {
    public static void main(String args[]) {
        Puffer<Paar<Student,String>> servicePoint;
        Puffer<Paar<Boxer,Boxer>> boxEvent;

        servicePoint = new SchlangeMitArray<>(10);
        boxEvent = new StapelMitArray(10);

        Student st1 = new Student("K", "R", 0);
        String frage = "Hallo?";
        Paar st1Frage = new Paar<>(st1, frage);

        Boxer bx1 = new Boxer("J", "W", 50);
        Boxer bx2 = new Boxer("K", "R", 650);
        Paar bxPaar1 = new Paar(bx1, bx2);

        servicePoint.insert(st1Frage);
        System.out.println(servicePoint);

        boxEvent.insert(bxPaar1);
        System.out.println(boxEvent);
    }
}
