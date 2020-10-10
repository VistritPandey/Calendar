import java.util.Scanner;
   public class PrintCalendar {
     public static void main() {
     Scanner scan = new Scanner (System.in);
     System.out.print("Enter full year: ");
     int year = scan.nextInt();
     System.out.print("Enter month in number b/w 1 and 12: ");
     int month = scan.nextInt();
      if (month < 1 || month > 12 || year < 1)
       System.out.println("Wrong input!");
       else
           printMonth(year, month);
   }

     static void printMonth(int year, int month) {
      printMonthTitle(year, month);
      printMonthBody(year, month);
    }
    static void printMonthTitle(int year, int month) {
    System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    }
    static void printMonthBody(int year, int month) {
      int startDay = getStartDay(year, month);
      int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);
      int i = 0;
      for (i = 0; i < startDay; i++)
        System.out.print("    ");
      for (i = 1; i <= numberOfDaysInMonth; i++) {
        if (i < 10)
          System.out.print("   " + i);
        else
          System.out.print("  " + i);
        if ((i + startDay) % 7 == 0)
          System.out.println();
      }
      System.out.println();
    }
   static int getStartDay(int year, int month) {
      int startDay = 6;
      int totalNumberOfDays = getTotalNumberOfDays(year, month);
      return (totalNumberOfDays + startDay) % 7;
    }
    static int getTotalNumberOfDays(int year, int month) {
     int total = 0;
     for (int i = 1800; i < year; i++)
     if (isLeapYear(i))

        total = total + 366;
      else
        total = total + 365;
      for (int i = 1; i < month; i++)
        total = total + getNumberOfDaysInMonth(year, i);
      return total;
    }
    static int getNumberOfDaysInMonth(int year, int month) {
      if (month == 1 || month == 3 || month == 5 || month == 7 ||
        month == 8 || month == 10 || month == 12)
        return 31;
      if (month == 4 || month == 6 || month == 9 || month == 11)

        return 30;
      if (month == 2) return isLeapYear(year) ? 29 : 28;
      return 0;
    }
    static boolean isLeapYear(int year) {
      return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}
