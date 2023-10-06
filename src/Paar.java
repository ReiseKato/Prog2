public class Paar <E,Z> {
    private E erstes;
    private Z zweites;

    public Paar(E paar1, Z paar2) {
        this.erstes = paar1;
        this.zweites = paar2;
    }

    public E getErstes() {
        return this.erstes;
    }

    public Z getZweites() {
        return this.zweites;
    }

    public void setErstes(E e) {
        this.erstes = e;
    }

    public void setZweites(Z z) {
        this.zweites = z;
    }

    public void setBeide(E e, Z z) {
        this.erstes = e;
        this.zweites = z;
    }

    public boolean equals(Paar paar) {
        if (this.erstes.equals(paar.getErstes()) && this.zweites.equals(paar.getZweites())) {
            return true;
        }
        return false;
    }


    // Print Method
    public String toString() {
        String toReturn = "(";
        toReturn += this.erstes.toString() + "," + this.zweites.toString() + ")";
        return toReturn;
    }
}
