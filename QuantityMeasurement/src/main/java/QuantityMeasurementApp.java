package main.java;

public class QuantityMeasurementApp {

    public static class Feet {

        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) {
                return true;
            }

            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            Feet other = (Feet) obj;

            return Double.compare(this.value, other.value) == 0;
        }
    }

    public static class Inches {

        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) {
                return true;
            }

            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            Inches other = (Inches) obj;

            return Double.compare(this.value, other.value) == 0;
        }
    }

    public static boolean checkFeetEquality(
            double firstValue,
            double secondValue) {

        Feet firstFeet = new Feet(firstValue);
        Feet secondFeet = new Feet(secondValue);

        return firstFeet.equals(secondFeet);
    }

    public static boolean checkInchesEquality(
            double firstValue,
            double secondValue) {

        Inches firstInches = new Inches(firstValue);
        Inches secondInches = new Inches(secondValue);

        return firstInches.equals(secondInches);
    }

    public static void main(String[] args) {

        System.out.println(
                "Feet Equality : "
                        + checkFeetEquality(1.0, 1.0)
        );

        System.out.println(
                "Inches Equality : "
                        + checkInchesEquality(1.0, 1.0)
        );
    }
}