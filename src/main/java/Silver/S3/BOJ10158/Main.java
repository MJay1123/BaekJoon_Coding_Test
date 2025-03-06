package Silver.S3.BOJ10158;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 개미
public class Main {
    static int w;           // 가로
    static int h;           // 세로
    static int p;           // 시작 x
    static int q;           // 시작 y
    static int t;           // 시간
    static int[] xArray;
    static int[] yArray;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(br.readLine());
        xArray = new int[2*w];
        yArray = new int[2*h];

        int xMove = t % (2*w);
        int yMove = t % (2*h);

        int index = 0;
        int num = p;
        while(num < w){
            xArray[index] = num;
            index++;
            num++;
        }
        while(num > 0){
            xArray[index] = num;
            index++;
            num--;
        }
        while(index < 2*w){
            xArray[index] = num;
            index++;
            num++;
        }

        index = 0;
        num = q;
        while(num < h){
            yArray[index] = num;
            index++;
            num++;
        }
        while(num > 0){
            yArray[index] = num;
            index++;
            num--;
        }
        while(index < 2*h){
            yArray[index] = num;
            index++;
            num++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(xArray[xMove]).append(" ").append(yArray[yMove]).append("\n");
        bw.write(sb.toString());
        bw.flush();
    }
}
