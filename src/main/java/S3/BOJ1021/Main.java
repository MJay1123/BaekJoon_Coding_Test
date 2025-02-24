package S3.BOJ1021;

import java.io.*;
import java.util.*;

public class Main {

    static int N;           // 큐의 크기
    static int M;           // 뽑아내려는 수의 개수
    static Queue<Integer> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        List<Integer> numbers = new ArrayList<>();          // 뽑아낼 숫자들을 담은 배열
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        // 왼쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 a2, ..., ak, a1이 된다.
        // 오른쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 ak, a1, ..., ak-1이 된다.
        // 2, 3번 연산의 최솟값

        for(int i=1; i<=N; i++){
            queue.offer(i);                                 // 큐 생성
        }

        int count = 0;
        for(int i : numbers){
            count += getOut(i);
        }
        bw.write(count + "\n");
        bw.flush();
    }

    public static int getOut(int num){      // 1 2 3 4 5 6 7 8  6을 빼려면 5 or 3
        int count = 0;
        while(queue.peek() != num){
            int a = queue.poll();
            queue.offer(a);
            count++;
        }
        int result = Math.min(count, queue.size() - count);
        queue.poll();
        return result;
    }
}
