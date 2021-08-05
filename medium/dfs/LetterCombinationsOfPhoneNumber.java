package dfs;
import java.util.*;

public class LetterCombinationsOfPhoneNumber {

    public static void main(String args[]){
        System.out.println("Letter combination of phone number ");
        List<String> list = letterCombinations("23");
        System.out.println(list);
    }

    public static List<String> letterCombinations(String digits) {
        String [] mapping = {
                "0",
                "1",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };

        ArrayList<String> result = new ArrayList<>();

        dfs(result,mapping,"",0,digits);

        return result;
    }

    public static void dfs(List<String> result, String[] mapping, String current, int index, String digits){

        if(index == digits.length()){
            result.add(current);
            return;
        }

        String ss = mapping[digits.charAt(index) - '0'];

        for(int i =0; i<ss.length(); i++){
            dfs(result, mapping, current+ss.charAt(i), index+1, digits);
        }
    }
}
