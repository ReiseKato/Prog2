public class Temperatursensor {
    Ringpuffer<Float> ringpuffer;

    public Temperatursensor() {
        this.ringpuffer = new Ringpuffer<>(24);
    }

    public void neueMessung(Float wert) {
        try {
            ringpuffer.addFirst(wert);
        } catch (IllegalAccessException e) {
            ringpuffer.removeLast();
        }
    }

    public Float aktuelleMessung() {
        Float num;
        try {
            num = ringpuffer.get(0);
        } catch (IllegalAccessException e) {
            return Float.NaN;
        }
        return num;
    }

    public Float durchschnittsTemperatur() {
        Float avg;
        try {
            Float sum = 0.0f;
            for (int i = 0; i < ringpuffer.size(); i++) {
                sum += ringpuffer.get(i);
            }
            avg = sum/ringpuffer.size();
        } catch (IllegalAccessException e) {
            return Float.NaN;
        }
        return avg;
    }

    public void reset() {
        for (int i = 0; i < ringpuffer.size(); i++) {
            ringpuffer.removeFirst();
//            try {
//                ringpuffer.set(i, null);
//            } catch (IllegalAccessException e) {
//                System.out.println("Reset failed");
//            }
        }

    }

    public String toString() {
        return ringpuffer.toString();
    }
}
