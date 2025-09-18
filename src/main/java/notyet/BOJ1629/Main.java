package notyet.BOJ1629;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());
        long answer = 1;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<B; i++){
            answer *= A;
            answer %= C;
            if(!list.contains((int)answer)){
                list.add((int)answer);
            } else {
                answer = (long)list.get((int) ((B-i)%list.size()));
                break;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
