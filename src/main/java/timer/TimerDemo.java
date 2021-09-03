package timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

class Util {
    public static String getCurrentDateTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(calendar.getTime());
    }
}

class MyTimerTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("MyTimerTask is Running " + Util.getCurrentDateTime());
    }
}


public class TimerDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();

        // 延时0s之后，每隔1s执行一次
        timer.schedule(new MyTimerTask(), 0L, 1000L);
    }
}