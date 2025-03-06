package Silver.S4.BOJ1358;

import java.io.*;
import java.util.StringTokenizer;

// 하키
public class Main {
    static int H;               // 세로 길이
    static int W;               // 가로 길이
    static int X;
    static int Y;
    static int P;               // 사람의 수
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        for(int i=0; i<P; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int[] middleLeft = {X, Y+H/2};
            int[] middleRight = {X+W, Y+H/2};
            if(checkCircle(x,y,middleLeft) || checkCircle(x,y,middleRight) || checkRectangle(x,y)){
                count++;
            }
        }
        bw.write(count + "\n");
        bw.flush();
    }

    public static boolean checkCircle(int x, int y, int[] middle){
        double distance = Math.sqrt(Math.pow(middle[0]-x, 2) + Math.pow(middle[1]-y, 2));
        return(distance <= (H/2));
    }

    public static boolean checkRectangle(int x, int y){
        boolean checkX = (x >= X && x <= X + W);
        boolean checkY = (y >= Y && y <= Y + H);
        return(checkX && checkY);
    }
}
