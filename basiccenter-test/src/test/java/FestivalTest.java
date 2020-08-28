import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Create by TOM on 2020/8/27 23:04
 * @Modify by TOM on 2020/8/27 23:04
 */
public class FestivalTest {

    @Test
    public void fun() throws ParseException {
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());
        long time = date.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(date);
        System.out.println(format);
        System.out.println(sdf.parse(format));
    }
}
