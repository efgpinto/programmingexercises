package hackerrank;


public class MakingAnagrams {
    public static int numberNeeded(String first, String second) {
        int[] map = new int[26];
        char[] c1 = first.toCharArray(), c2 = second.toCharArray();
        
        for (char c : c1) {
        	map[c-'a']++;
        }
        
        for (char c : c2) {
            map[c-'a']--;
        }
        
        int sum = 0;
        for (int i : map)
        	sum += Math.abs(i);
        
        return sum;
    }
  
    public static void main(String[] args) {
        System.out.println(numberNeeded("addss", "a"));    
        System.out.println(numberNeeded("cde", "abc"));   
    }
}
