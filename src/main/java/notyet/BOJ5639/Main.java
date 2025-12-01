package notyet.BOJ5639;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int max = 0;
        List<Integer> list = new ArrayList<>();
        while(true){
            String str = br.readLine();
            if(str == null){
                break;
            }
            int num = Integer.parseInt(str);
            max = Math.max(max, num);
            list.add(num);
        }
        int[] numbers = new int[max+1];
        int root = list.get(0);
        Stack<Integer> stack = new Stack<>();
        numbers[root] = -1;
        stack.push(root);
        for(int i=1; i<list.size(); i++){
            int num = list.get(i);
            if(num < stack.peek()){
                numbers[num] = stack.peek();
                stack.push(num);
            }
        }
    }
}
