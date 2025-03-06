package Silver.S3.BOJ1063;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 킹
public class Main {

    static int[] king;
    static int[] stone;
    static int moveCount;
    static String[] moveString = {"R", "L", "T", "B", "RT", "LT", "RB", "LB"};
    static int[][] moveInt = {{0,1},{0,-1},{-1,0},{1,0},{-1,1},{-1,-1},{1,1},{1,-1}};
    static char[] alphabet = {'A','B','C','D','E','F','G','H'};
    static int[] number = {1,2,3,4,5,6,7,8};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        String kingStr = st.nextToken();
        String stoneStr = st.nextToken();
        moveCount = Integer.parseInt(st.nextToken());
        king = changeLocation1(kingStr);
        stone = changeLocation1(stoneStr);

        for(int m=0; m<moveCount; m++){
            String moveStr = br.readLine();
            for(int i=0; i<8; i++) {
                if (moveString[i].equals(moveStr)) {
                    int knx = king[0] + moveInt[i][0];
                    int kny = king[1] + moveInt[i][1];
                    if (checkRange(knx, kny)) {
                        if (knx == stone[0] && kny == stone[1]) {
                            int snx = stone[0] + moveInt[i][0];
                            int sny = stone[1] + moveInt[i][1];
                            if(checkRange(snx, sny)){
                                stone[0] = snx;
                                stone[1] = sny;
                                king[0] = knx;
                                king[1] = kny;
                            }
                        } else {
                            king[0] = knx;
                            king[1] = kny;
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(changeLocation2(king)).append("\n").append(changeLocation2(stone));
        bw.write(sb.toString());
        bw.flush();
    }


    public static boolean checkRange(int x, int y){
        return (x >= 1 && x <= 8 && y >= 1 && y <= 8);
    }

    public static String changeLocation2(int[] location){
        StringBuilder sb = new StringBuilder();
        sb.append((char)(64 + location[1]));
        sb.append(9-location[0]);
        return sb.toString();
    }
    // 7,2 -> 2,7 -> B 2
    // 3,4 -> 4,3 -> D 6

    public static int[] changeLocation1(String location){
        int[] newLocation = new int[2];
        int y;
        int x = 0;
        y = '9' - location.charAt(1);
        for(int i=0; i<8; i++){
            if(alphabet[i] == location.charAt(0)){
                x = number[i];
            }
        }
        newLocation[0] = y;
        newLocation[1] = x;
        return newLocation;
    }
}
