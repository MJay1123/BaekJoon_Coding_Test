package B2.BOJ1408;

import java.io.*;

// 24
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] now = br.readLine().split(":");
        String[] start = br.readLine().split(":");

        int nowTime = timeToSeconds(now);
        int startTime = timeToSeconds(start);

        int remainTime = 0;
        if(startTime < nowTime) {
            startTime += 60 * 60 * 24;
        }
        remainTime = startTime - nowTime;

        int hour = remainTime / 3600;
        remainTime -= hour * 3600;
        int minute = remainTime / 60;
        int second = remainTime % 60;

        StringBuilder sb = new StringBuilder();
        sb.append(numberToString(hour)).append(":");
        sb.append(numberToString(minute)).append(":");
        sb.append(numberToString(second));
        bw.write(sb.toString());
        bw.flush();
    }

    public static int timeToSeconds(String[] time){
        int seconds = Integer.parseInt(time[0]) * 3600;
        seconds += Integer.parseInt(time[1]) * 60;
        seconds += Integer.parseInt(time[2]);
        return seconds;
    }
    public static String numberToString(int number){
        if(number == 0){
            return "00";
        } else if(number < 10){
            return "0" + number;
        } else {
            return String.valueOf(number);
        }
    }
}
