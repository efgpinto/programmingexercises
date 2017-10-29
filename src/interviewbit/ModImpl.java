package interviewbit;

public class ModImpl {
	
	public int Mod(int a, int b, int c) {
	    
	    if (b == 0)
	        return 1;
	        
	    int ab = a;
	    while (--b > 0)
	        ab *= a;
	    
	    return modaux(ab, c); 
	}
	
	public int modaux(int n, int c) {
		//System.out.println("rec" + n + " c " + c);
	    if (n < 0)
	        return n+c;
	    return modaux(n-c, c);
	}
	
	public static void main(String[] args) {
		ModImpl m = new ModImpl();
		System.out.println(m.Mod(-1, 1, 20));

		System.out.println(m.Mod(2, 3, 3));
	}
}
