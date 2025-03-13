import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {

    static String getDateAndTime(){
        LocalDateTime dateAndTimeNow = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateAndTimeNow.format(formatter);
    }
}
