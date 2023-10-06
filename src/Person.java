public abstract class Person {
    private String name;
    private String vorname;

    public Person(String name, String surname) {
        this.name = name;
        this.vorname = surname;
    }

    public String getName() {
        return this.name;
    }

    public String getVorname() {
        return this.vorname;
    }

    public boolean equals(Person otherPerson) {
        if (this.name.equals(otherPerson.getName()) && this.vorname.equals(otherPerson.getVorname())) {
            return true;
        }
        return false;
    }


    public int ComparatorPersonVornameNachname(Person otherPerson) {
        if (this.name.compareTo(otherPerson.getName()) > 0) {
            return 1;
        } else if (this.name.compareTo(otherPerson.getName()) < 0) {
            return -1;
        } else {
            if (this.vorname.compareTo(otherPerson.getVorname()) > 0) {
                return 1;
            } else if (this.vorname.compareTo(otherPerson.getVorname()) < 0) {
                return -1;
            }
        }
        return 0;
    }


    // Print Method
    public String toString() {
        String toReturn = "";
        toReturn = this.name + ", " + this.vorname;
        return toReturn;
    }
}
