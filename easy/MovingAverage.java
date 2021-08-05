//
//import java.util.*;
//
//public class MovingAverage {
//
//
//    Queue<Integer> queue = new LinkedList();
//    int max=0;
//
//    /** Initialize your data structure here. */
//    public MovingAverage(int size) {
//        this.max = size;
//    }
//
//    public double next(int val) {
//        double total = 0;
//
//        if(queue.size() > 0 && queue.size() == max){
//            queue.poll();
//        }
//        queue.offer(val);
//        List<Integer> list = new ArrayList(queue);
//
//        for(int i=0; i<list.size(); i++){
//            total = total + list.get(i);
//        }
//        return total/list.size();
//    }
//
//
//    public static void main(String args[]){
//        System.out.println(" This program is to find the moving average ");
//        //Initialize the moving average with a default value
//        MovingAverage mv = new MovingAverage(3);
//
//        Queue<Integer> queue = new LinkedList();
//
//        queue.off
//
//        ArrayList<Integer> list = new ArrayList<>(queue);
//
//    }
//
//
//
//
//}
