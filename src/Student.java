public class Student extends Person implements Comparable<Student> {
    private int matrikelnummer;

    public Student(String name, String surname, int matrikelnummer) {
        super(name, surname);
        this.matrikelnummer = matrikelnummer;
    }

    public int getMatrikelnummer() {
        return this.matrikelnummer;
    }

    public boolean equals(Student otherStudent) {
        if (super.equals(otherStudent)) {
            if (this.matrikelnummer == otherStudent.getMatrikelnummer()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(Student otherStudent) {
        if (this.matrikelnummer == otherStudent.getMatrikelnummer()) {
            return 0;
        } else if (this.matrikelnummer < otherStudent.getMatrikelnummer()) {
            return -1;
        }
        return 1;
    }

    // Print Method
    public String toString() {
        String toReturn = super.toString();
        toReturn += " " + this.matrikelnummer;
        return toReturn;
    }
}
