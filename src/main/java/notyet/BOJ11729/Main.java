package notyet.BOJ11729;

import java.io.*;
import java.util.Stack;

public class Main {
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
        System.out.println(stackArray[0]);
        if(N % 2 == 1){
            stackArray[2].push(stackArray[0].pop());
        } else {
            stackArray[1].push(stackArray[0].pop());
        }
        while(!stackArray[0].empty()){
            if(stackArray[1].empty()){
                stackArray[1].push(stackArray[0].pop());
            } else if(stackArray[2].empty()){
                stackArray[2].push(stackArray[0].pop());
            }
        }
    }
}
