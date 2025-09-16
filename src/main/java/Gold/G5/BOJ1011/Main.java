package Gold.G5.BOJ1011;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// Fly me to the Alpha Centauri
public class Main {
    static int T;                               // 테스트 케이스 개수
    static int x;                               // 출발점
    static int y;                               // 도착점

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        ArrayList<Long> list = new ArrayList<>();
        long max = 0;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add((long)y - x);
            max = Math.max(max, y - x);
        }

        for (int i = 0; i < list.size(); i++) {
            bw.write(getCount(list.get(i)) + "\n");
        }
        bw.flush();
    }

    public static long getCount(long number){
        for(long i=1; i<=47000; i++){
            if((i-1)*i < number && number <= i*(i+1)) {
                if(number <= i*i){
                    return 2*i-1;
                } else {
                    return 2*i;
                }
            }
        }
        return 0;
    }
}
