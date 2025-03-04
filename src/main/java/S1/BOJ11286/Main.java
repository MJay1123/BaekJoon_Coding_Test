package S1.BOJ11286;
// 절댓값 힙

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static List<Integer> list = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(list.size() == 0){
                    bw.write(0 + "\n");
                } else {
                    bw.write(peek() + "\n");
                    poll();
                }
            } else {
                insert(num);
            }
        }
        bw.flush();
    }

    public static int peek(){
        return list.get(0);
    }

    public static void poll(){
        int index = 0;
        change(index, list.size()-1);
        list.remove(list.size()-1);
        while(true){
            int leftChildIndex = index*2 + 1;
            int rightChildIndex = index*2 + 2;
            if (leftChildIndex >= list.size()) {
                return;
            } else if(rightChildIndex >= list.size()) {
                compareToChange(index, leftChildIndex);
                index = leftChildIndex;
            } else {
                if(Math.abs(list.get(leftChildIndex)) < Math.abs(list.get(rightChildIndex))){
                    compareToChange(index, leftChildIndex);
                    index = leftChildIndex;
                } else if(Math.abs(list.get(leftChildIndex)) > Math.abs(list.get(rightChildIndex))) {
                    compareToChange(index, rightChildIndex);
                    index = rightChildIndex;
                } else {
                    int childIndex = (list.get(leftChildIndex) < list.get(rightChildIndex)) ? leftChildIndex : rightChildIndex;
                    compareToChange(index, childIndex);
                    index = childIndex;
                }
            }
        }
    }

    public static void compareToChange(int index, int childIndex){
        if (Math.abs(list.get(index)) > Math.abs(list.get(childIndex))) {
            change(index, childIndex);
        } else if(Math.abs(list.get(index)) == Math.abs(list.get(childIndex))){
            if(list.get(index) > list.get(childIndex)){
                change(index, childIndex);
            }
        } else {
            return;
        }
    }

    public static void insert(int num){
        list.add(num);
        int index = list.size()-1;
        while(index > 0){
            int parentIndex = (index-1)/2;
            if(Math.abs(list.get(parentIndex)) > Math.abs(list.get(index))){
                change(parentIndex, index);
                index = parentIndex;
            } else if(Math.abs(list.get(parentIndex)) == Math.abs(list.get(index))){
                if(list.get(parentIndex) > list.get(index)){
                    change(index, parentIndex);
                    index = parentIndex;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public static void change(int a, int b){
        int temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }
}
