
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;



import java.time.DayOfWeek;
import java.time.LocalDate;
public class WeekEndTests {

        @Test
        public void shouldDisplayDaysExcludingWeekEndsSaturday() {
            // Saturday - should jump to monday and count offset
            LocalDate date = LocalDate.of(2018,11,17);
            LocalDate newDate = LocalDate.of(2018,11,26);
            int offset = 5;
            int direction = 1;
            System.out.println(calcDate(date,offset,direction));

            assertEquals(newDate,calcDate(date,offset,direction),"Should be equal");

        }

        @Test
        public void shouldDisplayDaysExcludingWeekEndsSubday() {
            // Saturday - should jump to monday and count offset
            LocalDate date = LocalDate.of(2018,11,25);
            LocalDate newDate = LocalDate.of(2018,11,21);
            int offset = 2;
            int direction = -1;
            System.out.println(calcDate(date,offset,direction));

            assertEquals(newDate,calcDate(date,offset,direction),"Should be equal");

        }


        @Test
        public void shouldDisplayDaysExcludingWeekEndsSaturdayPlus5Days() {
            // Saturday - should jump to monday and count offset to friday
            LocalDate date = LocalDate.of(2018,11,24);
            LocalDate newDate = LocalDate.of(2018,11,16);
            int offset = 5;
            int direction = -1;
            System.out.println(calcDate(date,offset,direction));

            assertEquals(newDate,calcDate(date,offset,direction),"Should be equal");

        }



        public LocalDate calcDate(LocalDate date, int offset,int direction) {
            for(int i=0; i< offset; i++) {

                date = getCalcDate(date,1+check(date,direction),direction);
            }

            return getCalcDate(date,check(date,direction),direction);
        }


    private int check(LocalDate date,int direction) {
        if (date.getDayOfWeek() == DayOfWeek.SATURDAY)
            return direction > 0 ? 2 : 1;
        else
        if (date.getDayOfWeek() == DayOfWeek.SUNDAY)
            return direction > 0 ? 1 : 2;

        return 0;
    }

    private LocalDate getCalcDate(LocalDate date,int offset,int direction) {
        if(direction > 0) return  date.plusDays(offset);
        if(direction < 0) return  date.minusDays(offset);
        return date;
    }
    }


