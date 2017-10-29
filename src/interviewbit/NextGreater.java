package interviewbit;

import java.util.ArrayList;

public class NextGreater {
	
	public ArrayList<Integer> nextGreater(ArrayList<Integer> a) {
	   ArrayList<Integer> great = new ArrayList<Integer>();
	   
	   for (int i = 0; i < a.size(); i++) {
		   int j = i+1;
		   for (; j < a.size(); j++) {
			   
			   if (a.get(j)>a.get(i)) {
				   great.add(a.get(j));
				   break;
			   }
		   }
		   if (j == a.size())
			   great.add(-1);
	   }
	   
	   return great;
	}
	
	public static void main(String[] args) {
		NextGreater k = new NextGreater();
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(4); a.add(5); a.add(2); a.add(10);

		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a2.add(3); a2.add(2); a2.add(1);
		
		System.out.println(k.nextGreater(a2));
	}
}
