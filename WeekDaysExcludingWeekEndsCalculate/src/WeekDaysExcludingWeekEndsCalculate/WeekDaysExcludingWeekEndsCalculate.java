package WeekDaysExcludingWeekEndsCalculate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class WeekDaysExcludingWeekEndsCalculate {

	public static void main(String[] args) {
		 LocalDate adate =  LocalDate.of(2018, 10, 28);
		 // Setting the second parameter to a negative values goes back in time
		 // setting the second param to positive value goes forward.
		 System.out.println(calcDate(adate,-11));
	}

	private static LocalDate calcDate(LocalDate adate, int offset) {
		 
		if (offset > -1) {
			if (adate.getDayOfWeek() == DayOfWeek.SATURDAY  || adate.getDayOfWeek() == DayOfWeek.SUNDAY) {
				return calcDate(adate.plusDays(1), offset);
			} else if (offset <= 1)  {
				return adate;
			}
			else {
				return calcDate(adate.plusDays(1), --offset); 
			}
		}
		else {
		 
			if (adate.getDayOfWeek() == DayOfWeek.SATURDAY  || adate.getDayOfWeek() == DayOfWeek.SUNDAY) {
				return calcDate(adate.minusDays(1), offset);
			} else if (Math.abs(offset) <= 1)  {
				return adate;
			}
			else {
				return calcDate(adate.minusDays(1),  ++offset); 
			}
		}
			
	}
}
