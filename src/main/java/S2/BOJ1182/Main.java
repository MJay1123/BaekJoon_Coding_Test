package S2.BOJ1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 부분 수열의 합
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // 1<=N<=20
        int S = Integer.parseInt(st.nextToken());       // |S| <= 1,000,000

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int count = 0;
        List<Integer> list = new ArrayList<Integer>();
        int index = 0;
        while(index < N){
            if(getSum(list) < S){
                list.add(arr[index]);
                index++;
            } else if(getSum(list) > S){
                list.remove(0);
            } else {
                count++;
            }
        }
        System.out.println(count);
    }

    public static int getSum(List<Integer> list){
        int sum = 0;
        for(int i=0; i<list.size(); i++){
            sum += list.get(i);
        }
        return sum;
    }
}
