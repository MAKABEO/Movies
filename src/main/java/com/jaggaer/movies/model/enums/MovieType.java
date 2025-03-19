package com.jaggaer.movies.model.enums;

public enum MovieType {
    REGULAR(2, 0) {
        private static final int EXTRA_RENTER_POINTS_THRESHOLD = 2;
        private static final double BONUS_RENTER_POINTS = 1.5;

        @Override
        public double calculateRentalAmount(int daysRented) {
            double amount = BASE_RENTAL_AMOUNT;
            if (daysRented > EXTRA_RENTER_POINTS_THRESHOLD) {
                amount += (daysRented - EXTRA_RENTER_POINTS_THRESHOLD) * BONUS_RENTER_POINTS;
            }
            return amount;
        }
    },
    NEW_RELEASE(0, 1) {
        private static final double BONUS_RENTER_POINTS = 3;
        private static final int EXTRA_FREQUENT_POINTS_THRESHOLD = 1;
        private static final int EXTRA_FREQUENT_POINTS = 2;

        @Override
        public double calculateRentalAmount(int daysRented) {
            return daysRented * BONUS_RENTER_POINTS;
        }

        @Override
        public int calculateFrequentRenterPoints(int daysRented) {
            return (daysRented > EXTRA_FREQUENT_POINTS_THRESHOLD) ? EXTRA_FREQUENT_POINTS : BASE_FREQUENT_AMOUNT;
        }
    },
    CHILDREN(1.5, 1) {
        private static final int EXTRA_RENTER_POINTS_THRESHOLD = 3;
        private static final double BONUS_RENTER_POINTS = 1.5;

        @Override
        public double calculateRentalAmount(int daysRented) {
            double amount = BASE_RENTAL_AMOUNT;
            if (daysRented > EXTRA_RENTER_POINTS_THRESHOLD) {
                amount += (daysRented - EXTRA_RENTER_POINTS_THRESHOLD) * BONUS_RENTER_POINTS;
            }
            return amount;
        }
    };

    protected final double BASE_RENTAL_AMOUNT;
    protected final int BASE_FREQUENT_AMOUNT;

    MovieType(double baseRentalAmount, int baseFrequentAmount){
        this.BASE_RENTAL_AMOUNT = baseRentalAmount;
        this.BASE_FREQUENT_AMOUNT = baseFrequentAmount;
    }

    public abstract double calculateRentalAmount(int daysRented);

    public int calculateFrequentRenterPoints(int daysRented) {
        return BASE_FREQUENT_AMOUNT;
    }
}
