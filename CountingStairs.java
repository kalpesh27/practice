//Time Complexity - Branching factor to height .. so 



class CountingStairs{
  
 
  public static void main(String args[]){
    
    
   System.out.println(" Recursion program on counting stairs "); 
    
    int [] steps = {1,2};
    
	int j  = helper(steps,3);
    
    System.out.println(" The output of number of ways to climb stairs " + j);
        
  }
  
  
  
  public static int helper(int [] steps, int totalSteps){
    
    if(totalSteps == 0){
     	return 1;	 
    }
	
    if(totalSteps < 0){
      
      return 0;
    }
    int count = 0;
    	
	for(int i =0; i<steps.length; i++){
		count = count + helper(steps,totalSteps-steps[i]);
    }
    
    return count;
    
  }
  
  
  
}
