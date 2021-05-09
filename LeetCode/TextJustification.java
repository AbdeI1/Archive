import java.util.*;
import java.io.*;

class TextJustification{
	public static void main(String[] args){
		String[] words = {"What","must","be","acknowledgment","shall","be"};
		int maxWidth = 16;
		List<String> justified = fullJustify(words, maxWidth);
		System.out.println(Arrays.toString(justified.toArray()));
	}
	public static List<String> fullJustify(String[] words, int maxWidth){
		List<String> result = new ArrayList<>();
		String temp = words[0];
		int i = 1;
		while(i < words.length){
			if(temp.length() + words[i].length() + 1 > maxWidth){
				result.add(addSpaces(temp, maxWidth));
				temp = words[i];
			} else {
				temp += " ";
				temp += words[i];
			}
			i++;
		}
		result.add(fillSpaces(temp, maxWidth));
		return result;
	}
	public static String addSpaces(String s, int width){
		if(findChar(s, ' ') == -1){return fillSpaces(s, width);}
		System.out.println(s);
		String result = s;
		int i = 0;
		while(result.length() < width){
			if(result.charAt(i) == ' '){
				result = result.substring(0, i) + " " + result.substring(i, result.length());
				while(result.charAt(i) == ' '){
					i++;
				}
				i--;
			}
			i++;
			i %= result.length();
		}
		return result;
	}
	public static String fillSpaces(String s, int width){
		String result = s;
		while(result.length() < width){
			result += " ";
		}
		return result;
	}
	public static int findChar(String s, char c){
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == c){return i;}
		}
		return -1;
	}
}

// This    is    an
// example  of text
// justification.