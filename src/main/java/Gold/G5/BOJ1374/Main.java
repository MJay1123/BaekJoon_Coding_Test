package Gold.G5.BOJ1374;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 강의실
public class Main {
    static int N;           // 강의 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        // 시작 시간을 기준으로 정렬
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.offer(new Integer[]{number, start, end});
        }

        // 종료 시간이 빠른 것부터 정렬
        PriorityQueue<Integer[]> pq2 = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for(int i=0; i<N; i++){
            if(pq2.isEmpty()){
                pq2.offer(pq.poll());
            } else {
                Integer[] array1 = pq.poll();
                Integer[] array2 = pq2.poll();
                if(array1[1] >= array2[2]){     // 종료 시간 이후에 시작을 하면
                    int start = array2[1];
                    int end = array1[2];
                    pq2.offer(new Integer[]{0, start, end});    // 앞 수업 시작 시간 ~ 뒷 수업 종료 시간으로 합친다.
                } else {
                    pq2.offer(array1);
                    pq2.offer(array2);
                }
            }
        }
        bw.write(pq2.size() + "\n");
        bw.flush();
    }
}
