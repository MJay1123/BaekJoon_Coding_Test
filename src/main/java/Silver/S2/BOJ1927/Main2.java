package Silver.S2.BOJ1927;

import java.io.*;
import java.util.*;

// 최소 힙
// 직접 구현해보기
public class Main2 {
    static int N;           // 연산의 개수
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                bw.write(remove() + "\n");
            } else {
                insert(num);
            }
        }
        bw.flush();
    }

    public static int remove(){
        if(list.size() == 0){                           // 반환할 값이 없으면 0 반환
            return 0;
        } else {
            int result = list.get(0);
            exchange(0, list.size() - 1);         // 마지막 노드와 교체
            list.remove(list.size() - 1);
            heapDown();                                 // 재배열
            return result;
        }
    }

    public static void heapDown(){
        int index = 0;
        while(true){
            int leftChildIndex = index*2 + 1;                               // 좌측 자식 노드
            int rightChildIndex = index*2 + 2;                              // 우측 자식 노드
            if(leftChildIndex >= list.size()){                              // 자식 노드가 없으면 break
                return;
            } else if(rightChildIndex >= list.size()){                      // 좌측 자식 노드만 존재
                if(list.get(leftChildIndex) < list.get(index)){
                    exchange(index, leftChildIndex);
                    return;
                } else {
                    return;
                }
            }
            if(list.get(leftChildIndex) <= list.get(rightChildIndex)){      // 더 작은 자식 노드와 교체
                if(list.get(index) > list.get(leftChildIndex)){
                    exchange(index, leftChildIndex);
                    index = leftChildIndex;
                } else {
                    return;
                }
            } else {
                if(list.get(index) > list.get(rightChildIndex)){
                    exchange(index, rightChildIndex);
                    index = rightChildIndex;
                } else {
                    return;
                }
            }
        }
    }

    public static void insert(int num){
        list.add(num);
        int index = list.size() - 1;
        while(index > 0){                                                   // 트리에 도달하면 중단
            int parentIndex = (index-1)/2;
            if(list.get(parentIndex) > list.get(index)){                    // 부모 노드와 비교 후 교체
                exchange(parentIndex, index);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    public static void exchange(int a, int b){
        int temp = list.get(b);
        list.set(b, list.get(a));
        list.set(a, temp);
    }
}
