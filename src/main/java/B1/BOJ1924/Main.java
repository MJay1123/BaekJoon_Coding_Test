package B1.BOJ1924;

import java.io.*;
import java.util.StringTokenizer;

// 2007년
public class Main {
    static int x, y;    // x월 y일
    static int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String[] daysNames = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        // 2007년 1월 1일 = 월요일

        int day = 0;
        for(int i=1; i<x; i++){
            day += days[i-1];
        }
        day += y;
        int difference = (day-1)%7;
        bw.write(daysNames[difference]);
        bw.flush();
    }
}
