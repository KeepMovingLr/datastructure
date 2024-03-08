package lc;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        try {
            String time1 = event1[0];
            String time2 = event2[0];
            Date date1 = new SimpleDateFormat("HH:MM").parse(time1);
            Date date2 = new SimpleDateFormat("HH:MM").parse(time2);

            if (date1.compareTo(date2) > 0) {
                String[] temp = event1;
                event1 = event2;
                event2 = temp;
            }
            String time3 = event1[1];
            String time4 = event2[0];

            date1 = new SimpleDateFormat("HH:MM").parse(time3);

            date2 = new SimpleDateFormat("HH:MM").parse(time4);
            if (date1.compareTo(date2) >= 0) {
                return true;
            } else {
                return false;
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

    }
}