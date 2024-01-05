/** 
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	
	/** 
	 * Prints the calendars of all the years in the 20th century. Also prints the  
	 * number of Sundays that occured on the first day of the month during this period.
	 */
	public static void main(String args[]) {
		// Advances the date and the day-of-the-week from 1/1/1900 till 31/12/1999, inclusive.
	    // Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday, prints "Sunday".
	    // The following variable, used for debugging purposes, counts how many days were advanced so far.
		int yearInput = Integer.parseInt(args[0]);
	    int debugDaysCounter = 0;
		int sundaysOn1stOfMonthCounter = 0;
	    //// Write the necessary initialization code, and replace the condition
	    //// of the while loop with the necessary condition 
	 	while (!(dayOfMonth == 1 && month == 1 && year == yearInput)) {
	 		advance();
        }
		while (!(dayOfMonth == 1 && month == 1 && year == yearInput + 1)) {
	 		System.out.printf("%d/%d/%d%s\n", dayOfMonth, month, year, dayOfWeek == 1 ? " Sunday" : "");
			if (dayOfWeek == 1 && dayOfMonth == 1) {
				sundaysOn1stOfMonthCounter++;
			}

	 		advance();
	 		debugDaysCounter++;
	 		//// If you want to stop the loop after n days, replace the condition of the
	 		//// if statement with the condition (debugDaysCounter == n)
	 		// if (false) {
	 		// 	break;
	 		// }
        }
		System.out.println("During the 20th century, " + sundaysOn1stOfMonthCounter + " Sundays fell on the first day of the month");
	 }
	
	 // Advances the date (day, month, year) and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	 private static void advance() {
		dayOfMonth++;
		dayOfWeek++;

		if (dayOfWeek > 7) {
			dayOfWeek = 1;
		}

		if (dayOfMonth > nDaysInMonth) {
			month++;
			dayOfMonth = 1;
			if (month > 12) {
				year++;
				month = 1;
			}
			nDaysInMonth = nDaysInMonth(month, year);
		}
	 } 
		 
    // Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
	    if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			return true;
		}
		return false;
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	private static int nDaysInMonth(int month, int year) {
		switch (month) {
			case 1:
				return 31;
			case 2:
				if (isLeapYear(year)) return 29;
				else return 28;
			case 3:
				return 31;
			case 4:
				return 30;
			case 5:
				return 31;
			case 6:
				return 30;
			case 7:
				return 31;
			case 8:
				return 31;
			case 9:
				return 30;
			case 10:
				return 31;
			case 11:
				return 30;
			case 12:
				return 31;
			default:
				return -1;
		}
	}
}