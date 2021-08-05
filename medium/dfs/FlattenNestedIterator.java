//package dfs;
//
//import java.util.*;
//
//public class FlattenNestedIterator {
//
//    public static class NestedInt{
//        int val;
//
//        public NestedInt(int x){
//            this.val=x;
//        }
//    }
//
//
//    public static void main(String args[]){
//
//
//        int [][] arr = new int [][]{
//                {1,1},
//                {2},
//                {1,1},
//
//        };
//
//        System.out.println("Flatten Nested List ");
//        List<NestedInt> outerList = new ArrayList<>();
//        NestedInt i = new NestedInt(1);
//        outerList.add(i);
//        outerList.add(new NestedInt(2));
//        outerList.add(new NestedInt(3));
//        outerList.add(new NestedInt(4));
//
//        List<NestedInt> list = outerList;
//
//        //System.out.println(list.size());
//        System.out.println(list.get(0).val);
//        list.remove(0);
//
//
//        System.out.println(list.get(0).val);
//        list.remove(0);
//
//
//        System.out.println(list.get(0).val);
//        list.remove(0);
//
//    }
//}
