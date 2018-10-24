package WeekDaysExcludingWeekEndsCalculate;

import java.time.DayOfWeek;
import java.time.LocalDate;
 

public class WeekDaysExcludingWeekEndsCalculate {

	public static void main(String[] args) {
		 LocalDate adate =  LocalDate.of(2018, 10, 27);
		 // Setting the second parameter to a negative values goes back in time
		 // setting the second param to positive value goes forward.
		 System.out.println(calcDate(adate,-7));
	}

	private static LocalDate calcDate(LocalDate adate, int offset) {



		DayOfWeek day = adate.getDayOfWeek();

		boolean weekEnd = (day == DayOfWeek.SATURDAY) || (day == DayOfWeek.SUNDAY);

		if (weekEnd) {
            if (offset <= -1) return calcDate(adate.minusDays(1),offset);
            return calcDate(adate.plusDays(1),offset);
		}
		if (offset == -1) return adate;
        if (offset == 1) return adate;

        if (offset < -1) return calcDate(adate.minusDays(1),++offset);
		return calcDate(adate.plusDays(1),--offset);
	}
}
