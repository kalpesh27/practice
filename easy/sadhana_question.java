import java.util.*;

public class sadhana_question {

    public static void main(String args[]){
        int [] arr1 = {1,3,5};
        int [] arr2 = {2,4};

        List<Integer> list = new ArrayList<>();
//Looping through array 1
        for(int i: arr1){
            list.add(i);
        }
//Looping through array 2
        for(int j: arr2){
            list.add(j);
        }

        Collections.sort(list);
        int [] arr4 = new int [list.size()];

        for(int i =0; i<arr4.length; i++){
            arr4[i] = list.get(i);
        }

        //int [] arr3 = list.stream().mapToInt(i->i).toArray();

        System.out.println(Arrays.toString(arr4));
    }
}
