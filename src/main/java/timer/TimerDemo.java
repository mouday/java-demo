package timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

// 自定义任务
class MyTimerTask extends TimerTask {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private int count = 0;

    private Timer timer;

    public MyTimerTask(Timer timer) {
        this.timer = timer;
    }

    @Override
    public void run() {
        System.out.println(dateFormat.format(new Date()));

        // 判断执行满5次就停止
        this.count++;

        if (this.count >= 5) {
            // 停止当前任务
            this.cancel();

            // 停止定时器
            this.timer.cancel();
        }
    }
}

public class TimerDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new MyTimerTask(timer), 0L, 1000L);
    }
}