package interviewbit;

import java.util.ArrayList;

public class LetterPhone {
	public ArrayList<String> letterCombinations(String a) {
		
		return letterCombinationsAux(a, new ArrayList<String>());		
	}
	
	public ArrayList<String> letterCombinationsAux(String rem, ArrayList<String> past) {
		
		ArrayList<String> combinations = new ArrayList<String>();
		
		if (rem.isEmpty())
			return past;
		
		char[] chars = rem.toCharArray();
		if (chars.length == 1)
			return combinationsAux(past, chars[0]);
			
		ArrayList<String> l1 = combinationsAux(past, chars[0]);
		combinations.addAll(letterCombinationsAux(rem.substring(1), l1));
		
		return combinations;
	}
	
	public ArrayList<String> combinationsAux(ArrayList<String> past, char c) {
		System.out.println("Processing.. " + c);
		
		ArrayList<String> l = new ArrayList<String>();
		char[] letters = getLetters(c);
		for (int i = 0; i < past.size(); i++) {
			for (char c1 : letters) {
				l.add(past.get(i)+c1);
			}
		}
		
		if (past.isEmpty()) {
			for (char c1 : letters) {
				l.add(c1+"");
			}
		}
		
		return l;
	}
	
	public char[] getLetters(char c) {
		switch(c) {
		case ('0'):
			return new char[]{'0'};
		case ('1'):
			return new char[]{'1'};
		case ('2'):
			return new char[]{'a', 'b', 'c'};
		case ('3'):
			return new char[]{'d', 'e', 'f'};
		case ('4'):
			return new char[]{'g', 'h', 'i'};
		case ('5'):
			return new char[]{'j', 'k', 'l'};
		case ('6'):
			return new char[]{'m', 'n', 'o'};
		case ('7'):
			return new char[]{'p', 'q', 'r', 's'};
		case ('8'):
			return new char[]{'t', 'u', 'v'};
		case ('9'):
			return new char[]{'w', 'x', 'y', 'z'};
		default:
			return new char[]{};
		}
	}
	
	public static void main(String[] args) {
		
		LetterPhone lp = new LetterPhone();
		ArrayList<String> l1 = new ArrayList<String>();
		l1.add("aa");
		l1.add("ab");
		
		ArrayList<String> l = lp.letterCombinations("21");
		for (String s : l) {
			System.out.println(s);
		}
		
		
	}
}
