package Silver.S4.BOJ28278;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;
// 스택 2
public class Main {
    static int N;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            /*
                1 X: 정수 X를 스택에 넣는다. (1 ≤ X ≤ 100,000)
                2: 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
                3: 스택에 들어있는 정수의 개수를 출력한다.
                4: 스택이 비어있으면 1, 아니면 0을 출력한다.
                5: 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
            */
            switch(command) {
                case 1:
                    int number = Integer.parseInt(st.nextToken());
                    stack.push(number);
                    break;
                case 2:
                    if(!stack.isEmpty()) {
                        sb.append(stack.pop());
                        sb.append("\n");
                    } else {
                        sb.append("-1\n");
                    }
                    break;
                case 3:
                    sb.append(stack.size());
                    sb.append("\n");
                    break;
                case 4:
                    sb.append(stack.isEmpty() ? "1\n" : "0\n");
                    break;
                case 5:
                    if(!stack.isEmpty()) {
                        sb.append(stack.peek());
                        sb.append("\n");
                    } else {
                        sb.append("-1\n");
                    }
                    break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
