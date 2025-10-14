package Gold.G5.BOJ11729;

import java.io.*;
import java.util.Stack;

public class Main {
    static int answer = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer>[] stackArray = new Stack[3];
        for(int i=0; i<3; i++){
            Stack<Integer> stack = new Stack<>();
            stackArray[i] = stack;
        }
        for(int i=N; i>=1; i--){
            stackArray[0].push(i);
        }
        moveOne(stackArray, N, 0, 2);
        bw.write(answer + "\n");
        bw.write(sb.toString());
        bw.flush();
    }

    public static void moveOne(Stack<Integer>[] stackArray, int count, int from, int to){
        Stack<Integer> fromStack = stackArray[from];
        Stack<Integer> toStack = stackArray[to];
        int other = 3 - from - to;
        if(count == 1){
            sb.append((from+1) + " " + (to+1) + "\n");
            toStack.push(fromStack.pop());
            answer++;
            return;
        }
        if(count >= 2){
            moveOne(stackArray, count-1, from, other);
            sb.append((from+1) + " " + (to+1) + "\n");
            toStack.push(fromStack.pop());
            answer++;
            moveOne(stackArray, count-1, other, to);
        }
    }
}
