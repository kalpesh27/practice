import java.util.*;

class RansomNote{

    public static void main(String args[]){
        System.out.println(" Program on ransom Note ");

        List<String> magazine = new ArrayList();

        magazine.add("give");
        magazine.add("me");
        magazine.add("one");
        magazine.add("grand");
        magazine.add("today");
        magazine.add("night");

        List<String> note = new ArrayList();
        note.add("give");
        note.add("one");
        note.add("grand");
        note.add("today");

        boolean b = checkMagazine(magazine,note);
        System.out.println(b);
    }



    public  static boolean checkMagazine(List<String> magazine, List<String> note){
        boolean flag = true;

        HashMap<String, Integer> magazineMap = new HashMap<>();
        for(String s: magazine){
            magazineMap.put(s, magazineMap.getOrDefault(s,0)+1);
        }

        for(String ss : note){
            if(magazineMap.containsKey(ss)){
                if(magazineMap.get(ss) > 1){
                    int k = magazineMap.get(ss);
                    magazineMap.put(ss,k-1);
                }else{
                    magazineMap.remove(ss);
                }
            }else{
                return false;
            }
        }

        //System.out.println(magazineMap);
        return flag;
    }

}