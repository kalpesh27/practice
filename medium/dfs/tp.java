package dfs;

public class tp {

    public static void main(String argsp[]){

        String s = "21xx3xx";

        StringBuilder sb = new StringBuilder();
        for(Character c : s.toCharArray()){
            sb.append(c);
            sb.append(" ");
            //System.out.print(c);
        }
        //System.out.println(sb.toString());

        String [] split = sb.toString().split(" ");

        for(String ss : split){
            System.out.println(ss);
        }
    }
}
