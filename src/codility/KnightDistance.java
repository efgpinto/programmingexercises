package codility;


public class KnightDistance {
	
    public int solution(int A, int B) {

    	A = Math.abs(A);
    	B = Math.abs(B);
    	
    	int turns = (A < B) ? A / 3 : B / 3;

    	A -= turns*3;
    	B -= turns*3;
    	turns *= 2;
    	
    	System.out.println("Sobras: A:" + A + " - B:" + B);
    	System.out.println("Turns:" + turns);
    	
    	if (A > 2) {
    		int div = A / 2;
    		A -= div*2;
    		turns += div;
    		
    		if (div % 2 != 0) { // odd
    			B = B > 0 ? B-1 : B+1;
    		}
    	}
    	
    	if (B > 2) {
    		int div = B / 2;
    		B -= div*2;
    		turns += div;
    		
    		if (div % 2 != 0) { // odd
    			A = A > 0 ? A-1 : A+1;
    		}
    	}
    	System.out.println("Sobras (2): A:" + A + " - B:" + B);
    	
    	if (turns >= 100000000)
    		return -2;
    	
    	if ((A == 1 && B == 2) ||
    			(A == 2 && B == 1))
    		return ++turns;
    	
    	return -1;
    	
    }
    
    public static void main(String[] args) {
    	KnightDistance e = new KnightDistance();
    	System.out.println("(5,4):"+e.solution(5,4));
    	System.out.println("(0,4):"+e.solution(0,4));
    	System.out.println("(5,0):"+e.solution(5,0));
    	System.out.println("(5,2):"+e.solution(5,2));
    	System.out.println("(5,2):"+e.solution(-1,-1));
    }
}
