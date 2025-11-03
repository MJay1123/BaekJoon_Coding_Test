package Silver.S2.BOJ1874;

import java.io.*;
import java.util.Stack;

public class Main {
    static int num = 1;
    static boolean answer = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            int next = Integer.parseInt(br.readLine());
            while(stack.isEmpty() || stack.peek() != next){
                push(stack);
                sb.append("+\n");
                if(num > n){
                    break;
                }
            }
            if(stack.peek() == next){
                stack.pop();
                sb.append("-\n");
                continue;
            }
            if(stack.peek() != next && num > n){
                answer = false;
                break;
            }
        }
        if(answer){
            bw.write(sb.toString());
        } else {
            bw.write("NO");
        }
        bw.flush();

    }
    public static void push(Stack<Integer> stack){
        stack.push(num);
        num++;
    }
}
