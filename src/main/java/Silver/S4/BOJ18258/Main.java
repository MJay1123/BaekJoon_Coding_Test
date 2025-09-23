package Silver.S4.BOJ18258;

import java.io.*;
import java.util.*;

// 큐 2
public class Main {
    static int N;   // 명령의 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int last = 0;
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "push":
                    int number = Integer.parseInt(st.nextToken());
                    queue.offer(number);
                    last = number;
                    break;
                case "pop":
                    if(!queue.isEmpty()) {
                        bw.write(queue.poll() + "\n");
                    } else {
                        bw.write("-1\n");
                    }
                    break;
                case "size":
                    bw.write(queue.size() + "\n");
                    break;
                case "empty":
                    if(queue.isEmpty()){
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "front":
                    if(!queue.isEmpty()){
                        bw.write(queue.peek() + "\n");
                    } else {
                        bw.write("-1\n");
                    }
                    break;
                case "back":
                    if(!queue.isEmpty()){
                        bw.write(last + "\n");
                    } else {
                        bw.write("-1\n");
                    }
                    break;
            }
        }
        bw.flush();
    }
}
