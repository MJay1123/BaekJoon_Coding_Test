package Silver.S3.BOJ12789;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// 도키도키 간식드리미
public class Main {
    static int N;       // 학생의 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<N; i++){
            queue.offer(Integer.parseInt(st.nextToken()));
        }
        Stack<Integer> stack = new Stack<>();
        int nextPerson = 1;
        while(true){
            if(!queue.isEmpty() && queue.peek()  == nextPerson){
                queue.poll();
                nextPerson++;
            } else if (!stack.isEmpty() && stack.peek() == nextPerson) {
                stack.pop();
                nextPerson++;
            } else {
                if(queue.isEmpty()){
                    break;
                } else {
                    stack.push(queue.poll());
                }
            }
        }
        if(stack.isEmpty() && queue.isEmpty()){
            bw.write("Nice\n");
        } else {
            bw.write("Sad\n");
        }
        bw.flush();
    }
}
