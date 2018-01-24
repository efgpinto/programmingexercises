import java.util.HashMap;

public class FindFirstSingle {

	public static Character findFirstSingle(String str) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(char c: str.toCharArray()) {
			if (map.containsKey(c)) {
				int i = map.get(c);
				map.put(c, ++i);
			} else {
				map.put(c, 1);
			}
		}
		
		for(char c: str.toCharArray()) {
			if (map.get(c) == 1) {
				return c;
			}
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println("teste: " + findFirstSingle("teste"));
		System.out.println("testesiio: " + findFirstSingle("testesiio"));
		System.out.println("hhassddr: " + findFirstSingle("hhassddr"));
		System.out.println("hhassddraaj: " + findFirstSingle("hhassddraaj"));
	}

}
