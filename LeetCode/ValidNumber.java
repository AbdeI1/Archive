import java.util.*;
import java.io.*;

class ValidNumber{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		boolean b = isNumber(s);
		System.out.println(b);
  }
  public static boolean isNumber(String s){
		int n = findChar(s, 'e');
		if(n == -1){n = findChar(s, 'E');}
		if(n == -1){
			return isInteger(s) || isDecimal(s);
		}
		String first = s.substring(0, n);
		String last = s.substring(n + 1, s.length());
		return (isDecimal(first) || isInteger(first)) && isInteger(last);
  }
	public static boolean isInteger(String s){
		int n = s.length();
		if(n == 0){return false;}
		int index = 0;
		if(s.charAt(index) == '+' || s.charAt(index) == '-'){
			index++;
			if(n == 1){return false;}
		}
		for(int i = index; i < n; i++){
			if(!Character.isDigit(s.charAt(i))){
				return false;
			}
		}
		return true;
	}
	public static boolean isDecimal(String s){
		int n = s.length();
		if(n <= 1){return false;}
		int index = 0;
		if(s.charAt(index) == '+' || s.charAt(index) == '-'){
			index++;
			if(n == 2){return false;}
		}
		while(Character.isDigit(s.charAt(index))){
			index++;
			if(index == n){return false;}
		}
		if(s.charAt(index) != '.'){return false;}
		index++;
		if(index == n){return true;}
		while(Character.isDigit(s.charAt(index))){
			index++;
			if(index == n){return true;}
		}
		return false;
	}
	public static int findChar(String s, char c){
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == c){return i;}
		}
		return -1;
	}
}
