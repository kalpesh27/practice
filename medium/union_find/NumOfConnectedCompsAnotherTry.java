import java.util.*;

class NumOfConnectedCompsAnotherTry{

	public static class DSU{

		public int [] parent;

		public DSU(int x){
			parent = new int[x];

			for(int i =0; i<parent.length; i++){
				parent[i] =i;
			}
		}

		public int find(int x){

			if(parent[x] != x){
				parent[x] = find(parent[x]);
			}

			return parent[x];
		}

		public void union(int x, int y){
			parent[find(x)] = find(y);
		}

	}

	public static void main(String args[]){
			int [][] edges = new int [][]{
                {0,1},
                {1,2},
                {2,3},
                {3,4}
        };

        int x = countComponents(5,edges);
        System.out.println(x);
	}


	public static int countComponents(int no, int [][] edges){

			//Step 1 create the DSU
			DSU dsu = new DSU(no);

			// Step 2 iterate through the edges and for each 
			// edge call the union method

			for(int [] i: edges){
				dsu.union(i[0], i[1]);
			}
			
			HashSet<Integer> set = new HashSet<Integer>();

			for(int i =0; i<dsu.parent.length; i++){
				set.add(dsu.find(i));
			}

			//System.out.println(set.toString());
			//System.out.println("DSU parent " + Arrays.toString(dsu.parent));
			return set.size();
	}
}

