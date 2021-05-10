import java.util.*;
import java.io.*;

class LargestRectangle{
  	public static void main(String[] args) {
		int[] heights = {};
		int result = largestRectangleArea(heights);
		System.out.println(result);
	}
	public static int largestRectangleArea(int[] heights){
		int maxHeight = 0;
		for(int i = 0; i < heights.length; i++){
			if(heights[i]*heights.length > maxHeight){
				int first = smallestBefore(heights, i);
				int last = smallestAfter(heights, i);
				int height = (last-first)*heights[i];
				maxHeight = Math.max(height, maxHeight);
			}
		}
		return maxHeight;
	}
	public static int smallestBefore(int[] a, int index){
		for(int i = index; i > -1; i--){
			if(a[i] < a[index]){return i + 1;}
		}
		return 0;
	}
	public static int smallestAfter(int[] a, int index){
		for(int i = index; i < a.length; i++){
			if(a[i] < a[index]){return i;}
		}
		return a.length;
	}
}
