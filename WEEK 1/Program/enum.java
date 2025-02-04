enum DaysOfWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class Main {
    public static void main(String[] args) {
        DaysOfWeek day = DaysOfWeek.SATURDAY;
        printHolidayStatus(day);

        day = DaysOfWeek.WEDNESDAY;
        printHolidayStatus(day);
    }

    static void printHolidayStatus(DaysOfWeek day) {
        if (day == DaysOfWeek.SATURDAY || day == DaysOfWeek.SUNDAY) {
            System.out.println(day + ": Holiday");
        } else {
            System.out.println(day + ": Not Holiday");
        }
    }
}
