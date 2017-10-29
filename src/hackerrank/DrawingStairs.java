package hackerrank;

public class DrawingStairs {
	public void stairs(int n) {
        for (int i=1; i <= n; i++) {
            for (int j = 0; j < n-i; j++) {
                System.out.print(" ");
            }
            for (int j = n-i; j < n; j++) {
                System.out.print("#");
            }
            System.out.println();   
        }
	}
	
	public static void main(String[] args) {
		DrawingStairs eHackerrankz = new DrawingStairs();
		eHackerrankz.stairs(4);
	}
}
