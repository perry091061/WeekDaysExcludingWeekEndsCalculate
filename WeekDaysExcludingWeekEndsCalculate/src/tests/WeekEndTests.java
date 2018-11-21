
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;



import java.time.DayOfWeek;
import java.time.LocalDate;
public class WeekEndTests {

        @Test
        public void shouldDisplayDaysExcludingWeekEndsSaturday() {
// Saturday - should joump to monday and count offset
            LocalDate date = LocalDate.of(2018,11,17);
            LocalDate newDate = LocalDate.of(2018,11,26);
            int offset = 5;
            System.out.println(calcDate(date,offset));

            assertEquals(newDate,calcDate(date,offset),"Should be equal");

        }

        @Test
        public void shouldDisplayDaysExcludingWeekEndsSubday() {
// Saturday - should jump to monday and count offset
            LocalDate date = LocalDate.of(2018,11,25);
            LocalDate newDate = LocalDate.of(2018,11,21);
            int offset = -2;
            System.out.println(calcDate(date,offset));

            assertEquals(newDate,calcDate(date,offset),"Should be equal");

        }


        @Test
        public void shouldDisplayDaysExcludingWeekEndsSaturdayPlus5Days() {
// Saturday - should jump to monday and count offset
            LocalDate date = LocalDate.of(2018,11,24);
            LocalDate newDate = LocalDate.of(2018,11,16);
            int offset = -5;
            System.out.println(calcDate(date,offset));

            assertEquals(newDate,calcDate(date,offset),"Should be equal");

        }



        public LocalDate calcDate(LocalDate date, int offset) {
            int count = Math.abs(offset);
            int diff = offset > 0 ? 1 : -1;
            for(int i=0; i <  count; i++) {

                if(date.getDayOfWeek() == DayOfWeek.SATURDAY) {
                    date = (diff > 0) ? date.plusDays(2) : date.minusDays(2);

                }else
                if(date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                    date =  date = (diff > 0) ? date.plusDays(2) : date.minusDays(2);

                }

                    date =  date = (diff > 0) ? date.plusDays(1) : date.minusDays(1);
            }

            return date;
        }
    }


