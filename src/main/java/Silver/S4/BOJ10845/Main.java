package Silver.S4.BOJ10845;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int last = 0;
        for(int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                queue.offer(num);
                last = num;
            }
            if(command.equals("pop")){
                if(queue.isEmpty()){
                    bw.write(-1 + "\n");
                } else {
                    bw.write(queue.poll() + "\n");
                }
            }
            if(command.equals("size")){
                bw.write(queue.size() + "\n");
            }
            if(command.equals("empty")){
                if(queue.isEmpty()){
                    bw.write(1 + "\n");
                } else {
                    bw.write(0 + "\n");
                }
            }
            if(command.equals("front")){
                if(queue.isEmpty()){
                    bw.write(-1 + "\n");
                } else {
                    bw.write(queue.peek() + "\n");
                }
            }
            if(command.equals("back")){
                if(queue.isEmpty()){
                    bw.write(-1 + "\n");
                } else {
                    bw.write(last + "\n");
                }
            }
        }
        bw.flush();
    }
}
