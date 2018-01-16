import java.util.*;

public class MergeKSortedArrays {


	public static void main(String[] args) {

		int[][] array = { 	{1, 3, 5, 7},
            				{2, 4, 6, 8},
            				{0, 9, 10, 11}
            			};


        TreeSet<Integer> tSet = new TreeSet<Integer>();

        for(int[] subArray : array) {

        	for(int elements : subArray) {

        		tSet.add(elements);
        	}
        }

        System.out.println(tSet);

	}
} 