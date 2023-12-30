1185. 一周中的第几天

```java
import java.text.SimpleDateFormat;
import java.util.Calendar;

class Solution {
    private static final Calendar calendar = Calendar.getInstance();
    private static final SimpleDateFormat weekFormat = new SimpleDateFormat("EEEE");

    public String dayOfTheWeek(int day, int month, int year) {
        calendar.set(year, month - 1, day);
        return weekFormat.format(calendar.getTime());
    }
}
```