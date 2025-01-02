//WONG YOONG YEE, UM AY2023/2024, WIX1002
import java.io.*;
import java.util.*;

interface Searchable {
    boolean search(String dateStartTime, String dateEndTime);
}

class Appointment implements Searchable {
    private int day, month, year, startTime, endTime;

    public Appointment(int day, int month, int year, int startTime, int endTime) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void saveAppointmentToFile() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("appointments.txt", true))) {
            writer.write(day + "/" + month + "/" + year + " " + startTime + " - " + endTime);
            writer.newLine();
            System.out.println("The appointment has been saved successfully and that there is no error.");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean search(String dateStartTime, String dateEndTime) {
        try {
            int searchStartTime = Integer.parseInt(dateStartTime.split("\\s+")[1].split(":")[0]), searchEndTime = Integer.parseInt(dateEndTime.split("\\s+")[1].split(":")[0]);

            return !(searchStartTime >= endTime || searchEndTime <= startTime);
        } catch(NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.err.println("Invalid date or time format.");
            return false;
        }
    }
}

public class L14Q4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int day = 0, month = 0, year = 0, startTime = 0, endTime = 0, bookingStartDay = 0, bookingStartMonth = 0, bookingStartYear = 0, bookingStartHour = 0, bookingStartMinute = 0, bookingEndDay = 0, bookingEndMonth = 0, bookingEndYear = 0, bookingEndHour = 0, bookingEndMinute = 0;
        //Input for the date of appointment.
        do {
            System.out.println("Enter the year of the date of appointment.");
            year = input.nextInt();
            System.out.println("Enter the month of the date of appointment.");
            month = input.nextInt();
        } while((year < -9999 || year > 9999) || (month < 1 || month > 12));

        if(year % 4 == 0 && month == 2) {
            do {
                System.out.println("Enter the day of the date of appointment.");
                day = input.nextInt();
            } while(day < 1 || day > 29);
        } else if(year % 4 != 0 && month == 2) {
            do {
                System.out.println("Enter the day of the date of appointment.");
                day = input.nextInt();
            } while(day < 1 || day > 28);
        } else if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            do {
                System.out.println("Enter the day of the date of appointment.");
                day = input.nextInt();
            } while(day < 1 || day > 31);
        } else {
            do {
                System.out.println("Enter the day of the date of appointment.");
                day = input.nextInt();
            } while(day < 1 || day > 30);
        }

        do {
            System.out.println("Enter the start time, in hours, of the date of appointment.");
            startTime = input.nextInt();
            System.out.println("Enter the end time, in hours, of the date of appointment.");
            endTime = input.nextInt();
        } while((startTime < 1 || startTime > 23) || (endTime < 1 || endTime > 23));
        Appointment appointment = new Appointment(day, month, year, startTime, endTime);
        appointment.saveAppointmentToFile();
        input.nextLine();
        System.out.println();
        
        //Input for the starting date of booking.
        do {
            System.out.println("Enter the year of the starting date of booking.");
            bookingStartYear = input.nextInt();
            System.out.println("Enter the month of the starting date of booking.");
            bookingStartMonth = input.nextInt();
        } while((bookingStartYear < -9999 || bookingStartYear > 9999) || (bookingStartMonth < 1 || bookingStartMonth > 12));

        if(bookingStartYear % 4 == 0 && bookingStartMonth == 2) {
            do {
                System.out.println("Enter the day of the starting date of booking.");
                bookingStartDay = input.nextInt();
            } while(bookingStartDay < 1 || bookingStartDay > 29);
        } else if(bookingStartYear % 4 != 0 && bookingStartMonth == 2) {
            do {
                System.out.println("Enter the day of the starting date of booking.");
                bookingStartDay = input.nextInt();
            } while(bookingStartDay < 1 || bookingStartDay > 28);
        } else if(bookingStartMonth == 1 || bookingStartMonth == 3 || bookingStartMonth == 5 || bookingStartMonth == 7 || bookingStartMonth == 8 || bookingStartMonth == 10 || bookingStartMonth == 12) {
            do {
                System.out.println("Enter the day of the starting date of booking.");
                bookingStartDay = input.nextInt();
            } while(bookingStartDay < 1 || bookingStartDay > 31);
        } else {
            do {
                System.out.println("Enter the day of the starting date of booking.");
                bookingStartDay = input.nextInt();
            } while(bookingStartDay < 1 || bookingStartDay > 30);
        }

        do {
            System.out.println("Enter the hour of the starting date of booking.");
            bookingStartHour = input.nextInt();
            System.out.println("Enter the minute of the starting date of booking.");
            bookingStartMinute = input.nextInt();
        } while((bookingStartHour < 0 || bookingStartHour > 23) || (bookingStartMinute < 0 || bookingStartMinute > 59));
        System.out.println();

        //Input for the ending date of booking.
        do {
            System.out.println("Enter the year of the ending date of booking.");
            bookingEndYear = input.nextInt();
            System.out.println("Enter the month of the ending date of booking.");
            bookingEndMonth = input.nextInt();
        } while((bookingEndYear < -9999 || bookingEndYear > 9999) || (bookingEndMonth < 1 || bookingEndMonth > 12));

        if(bookingEndYear % 4 == 0 && bookingEndMonth == 2) {
            do {
                System.out.println("Enter the day of the ending date of booking.");
                bookingEndDay = input.nextInt();
            } while (bookingEndDay < 1 || bookingEndDay > 29);
        } else if(bookingEndYear % 4 != 0 && bookingEndMonth == 2) {
            do {
                System.out.println("Enter the day of the ending date of booking.");
                bookingEndDay = input.nextInt();
            } while (bookingEndDay < 1 || bookingEndDay > 28);
        } else if(bookingEndMonth == 1 || bookingEndMonth == 3 || bookingEndMonth == 5 || bookingEndMonth == 7 || bookingEndMonth == 8 || bookingEndMonth == 10 || bookingEndMonth == 12) {
            do {
                System.out.println("Enter the day of the ending date of booking.");
                bookingEndDay = input.nextInt();
            } while(bookingEndDay < 1 || bookingEndDay > 31);
        } else {
            do {
                System.out.println("Enter the day of the ending date of booking.");
                bookingEndDay = input.nextInt();
            } while(bookingEndDay < 1 || bookingEndDay > 30);
        }

        do {
            System.out.println("Enter the hour of the ending date of booking.");
            bookingEndHour = input.nextInt();
            System.out.println("Enter the minute of the ending date of booking.");
            bookingEndMinute = input.nextInt();
        } while((bookingEndHour < 0 || bookingEndHour > 23) || (bookingEndMinute < 0 || bookingEndMinute > 59));

        System.out.println("Is the slot of appointment available? " + isAvailable(appointment, bookingStartYear, bookingStartMonth, bookingStartDay, bookingStartHour, bookingStartMinute, bookingEndYear, bookingEndMonth, bookingEndDay, bookingEndHour, bookingEndMinute));
        input.close();
    }

    private static boolean isAvailable(Searchable searchable, int bookingStartYear, int bookingStartMonth, int bookingStartDay, int bookingStartHour, int bookingStartMinute, int bookingEndYear, int bookingEndMonth, int bookingEndDay, int bookingEndHour, int bookingEndMinute) {
        return searchable.search(formatDateTime(bookingStartYear, bookingStartMonth, bookingStartDay, bookingStartHour, bookingStartMinute), formatDateTime(bookingEndYear, bookingEndMonth, bookingEndDay, bookingEndHour, bookingEndMinute));
    }

    private static String formatDateTime(int year, int month, int day, int hour, int minute) {
        return String.format("%04d-%02d-%02d %02d:%02d", year, month, day, hour, minute);
    }
}