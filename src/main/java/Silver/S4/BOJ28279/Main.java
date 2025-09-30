package Silver.S4.BOJ28279;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            switch(command){
                case 1:     // 1 X: 정수 X를 덱의 앞에 넣는다. (1 ≤ X ≤ 100,000)
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case 2:     // 2 X: 정수 X를 덱의 뒤에 넣는다. (1 ≤ X ≤ 100,000)
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case 3:     // 3: 덱에 정수가 있다면 맨 앞의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
                    if(deque.isEmpty()){
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(deque.pollFirst() + "\n");
                    }
                    break;
                case 4:     // 4: 덱에 정수가 있다면 맨 뒤의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
                    if(deque.isEmpty()){
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(deque.pollLast() + "\n");
                    }
                    break;
                case 5:     // 5: 덱에 들어있는 정수의 개수를 출력한다.
                    sb.append(deque.size() + "\n");
                    break;
                case 6:     // 6: 덱이 비어있으면 1, 아니면 0을 출력한다.
                    if(deque.isEmpty()){
                        sb.append(1 + "\n");
                    } else {
                        sb.append(0 + "\n");
                    }
                    break;
                case 7:     // 7: 덱에 정수가 있다면 맨 앞의 정수를 출력한다. 없다면 -1을 대신 출력한다.
                    if(deque.isEmpty()){
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(deque.peekFirst() + "\n");
                    }
                    break;
                case 8:     // 8: 덱에 정수가 있다면 맨 뒤의 정수를 출력한다. 없다면 -1을 대신 출력한다.
                    if(deque.isEmpty()){
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(deque.peekLast() + "\n");
                    }
                    break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
