package org.nbu.data.items.enums;

public enum DifficultyLevel {
    LOW(1), MEDIUM(2), HIGH(3);
    private int minutesToSew;

    DifficultyLevel(int minutesToSew) {
        this.minutesToSew = minutesToSew;
    }

    public int getMinutesToSew() {
        return minutesToSew;
    }

    public void setMinutesToSew(int minutesToSew) {
        this.minutesToSew = minutesToSew;
    }
}
