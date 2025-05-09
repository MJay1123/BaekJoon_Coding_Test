package Silver.S4.BOJ4949;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

// 균형잡힌 세상
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true) {
            String string = br.readLine();
            if(string.equals(".")) break;
            st = new StringTokenizer(string);
            int count = st.countTokens();
            Stack<String> stack = new Stack<>();
            for(int j=0; j<count; j++){
                String[] input = st.nextToken().split("");
                for (int i = 0; i < input.length; i++) {
                    if (input[i].equals("(") ||
                            input[i].equals(")") ||
                            input[i].equals("[") ||
                            input[i].equals("]")) {
                        if (stack.isEmpty()) {
                            stack.push(input[i]);
                        } else {
                            if (stack.peek().equals("(") && input[i].equals(")")) {
                                stack.pop();
                            } else if (stack.peek().equals("[") && input[i].equals("]")) {
                                stack.pop();
                            } else {
                                stack.push(input[i]);
                            }
                        }
                    }
                }
            }
            if(stack.isEmpty()){
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }
        bw.flush();
    }
}
