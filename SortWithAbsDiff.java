import java.util.*;

public class SortWithAbsDiff {


	public static class sortVarDiff implements Comparator<Integer>{

		public int compare(Integer i, Integer j) {

			Integer left = Math.abs(i - 7);
			Integer right = Math.abs(j - 7);
			return left.compareTo(right);
			
		}
	}

	public static void main(String[] args) {

		ArrayList<Integer> array = new ArrayList<Integer>();

		array.add(10);
		array.add(5);
		array.add(3);
		array.add(9);
		array.add(2);	

		Collections.sort(array, new sortVarDiff());	

		System.out.println(array);
	
	} 
} 