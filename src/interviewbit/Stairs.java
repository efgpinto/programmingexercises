package interviewbit;


public class Stairs {
	
	int[] memo;
	
	public int climbStairs(int a) {
	
		memo = new int[a+1];
		return climbStairsAux(a);
	}
	
	public int climbStairsAux(int a) {
		
		if (a == 1)
			return 1;
		
		if (a == 2)
			return 2;

		if (memo[a] != 0)
			return memo[a];
		
		memo[a] = climbStairsAux(a-1) + climbStairsAux(a-2);
		
		return memo[a];
	}
	
	public static void main(String[] args) {
		Stairs s = new Stairs();
		System.out.println(s.climbStairs(7));
	}

}
