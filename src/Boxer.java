public class Boxer extends Person implements Comparable<Boxer> {
    private int gewicht;

    public Boxer(String name, String surname, int weight) {
        super(name, surname);
        this.gewicht = weight;
    }

    public int getGewicht() {
        return this.gewicht;
    }

    public boolean equals(Boxer otherBoxer) {
        if (super.equals(otherBoxer)) {
            if (this.gewicht == otherBoxer.getGewicht()) {
                return true;
            }
        }
        return false;
    }

    public int compareTo(Boxer otherBoxer) {
        if (this.gewicht > otherBoxer.getGewicht()) {
            return 1;
        } else if (this.gewicht < otherBoxer.getGewicht()) {
            return -1;
        } else {
            if (this.getName().compareTo(otherBoxer.getName()) > 0) {
                return 1;
            } else if (this.getName().compareTo(otherBoxer.getName()) < 0) {
                return -1;
            } else {
                if (this.getVorname().compareTo(otherBoxer.getVorname()) > 0) {
                    return 1;
                } else if (this.getVorname().compareTo(otherBoxer.getVorname()) < 0) {
                    return -1;
                }
            }
        }
        return 0;
    }

    public int ComparatorBoxerGewicht(Boxer otherBoxer) {
        if (this.gewicht > otherBoxer.getGewicht()) {
            return 1;
        } else if (this.gewicht < otherBoxer.getGewicht()) {
            return -1;
        }
        return 0;
    }


    // Print Method
    public String toString() {
        String toReturn = super.toString();
        toReturn += " " + this.gewicht;
        return toReturn;
    }
}
