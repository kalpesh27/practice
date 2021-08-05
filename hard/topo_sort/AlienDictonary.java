


class AlienDictonary{
	


	public static class Graph{
		int val; 
		HashMap<Character, List<Character>> map = new HashMap<Character, List<Character>>();

		public Graph(int x){

			this.val = x;



		}

		public void addEdge(){

		}
	}

	public static void main(String args[]){

		System.out.println(" Program on topo Sort ");

			String [] words = {"wrt","wrf","er","ett","rftt"};
			String s = alienOrder(words);
			System.out.println(s);

	}

	public static String alienOrder(String[] words) {
        	
        	Set<Character> set = new HashSet<Character>();

        	for(String s : words){

        		for(Character c : s.toCharArray()){
        				set.add(c);
        		}
        	}
    }

}