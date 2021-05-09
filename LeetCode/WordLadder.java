import java.util.*;
import java.io.*;

class WordLadder{
	private static class Sequence implements Comparable<Sequence>{
		public String current;
		public int length;
		public Sequence(String s, int l){
			current = s;
			length = l;
		}
		public int compareTo(Sequence s){
			return Integer.compare(length, s.length);
		}
	}
	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
		int result = ladderLength(beginWord, endWord, wordList);
		System.out.println(result);
	}
	public static int ladderLength(String beginWord, String endWord, List<String> wordList){
		PriorityQueue<Sequence> sequences = new PriorityQueue<>();
		for(String s : wordList){
			if(letterDiff(s, beginWord) == 1){
				sequences.add(new Sequence(s, 1));
			}
		}
		HashSet<String> visited = new HashSet<>();
		while(!sequences.isEmpty()){
			Sequence temp = sequences.remove();
			if(temp.current.equals(endWord)){
				return temp.length + 1;
			}
			for(String s : wordList){
				if(letterDiff(s, temp.current) == 1 && !visited.contains(s)){
					sequences.add(new Sequence(s, temp.length + 1));
					visited.add(s);
				}
			}
		}
		return 0;
	}
	public static int letterDiff(String s1, String s2){
		if(s1.length() != s2.length()){return -1;}
		int result = 0;
		for(int i = 0; i < s1.length(); i++){
			if(s1.charAt(i) != s2.charAt(i)){result++;}
		}
		return result;
	}
}