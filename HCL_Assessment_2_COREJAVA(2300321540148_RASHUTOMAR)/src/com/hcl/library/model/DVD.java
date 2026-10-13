package com.hcl.library.model;

public class DVD extends LibraryItem {
    private int durationMinutes;

    public DVD(String title, int year, int durationMinutes) {
        super(title, year);
        if (durationMinutes <= 0) {
            throw new IllegalArgumentException("Duration must be positive");
        }
        this.durationMinutes = durationMinutes;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    @Override
    public double lateFee(int daysLate) {
        return daysLate > 0 ? daysLate * 5.0 : 0.0;
    }

    @Override
    public String toString() {
        return super.toString() + " [" + durationMinutes + " mins]";
    }
}
