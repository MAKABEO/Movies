package movies.model.enums;

public enum MovieType {
    REGULAR {
        @Override
        public double calculateRentalAmount(int daysRented) {
            double amount = 2;
            if (daysRented > 2) {
                amount += (daysRented - 2) * 1.5;
            }
            return amount;
        }
        @Override
        public int calculateFrequentRenterPoints(int daysRented) {
            return 0;
        }
    },
    NEW_RELEASE {
        @Override
        public double calculateRentalAmount(int daysRented) {
            return daysRented * 3;
        }

        @Override
        public int calculateFrequentRenterPoints(int daysRented) {
            return (daysRented > 1) ? 2 : 1;
        }
    },
    CHILDREN {
        @Override
        public double calculateRentalAmount(int daysRented) {
            double amount = 1.5;
            if (daysRented > 3) {
                amount += (daysRented - 3) * 1.5;
            }
            return amount;
        }
    };

    public abstract double calculateRentalAmount(int daysRented);

    public int calculateFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
