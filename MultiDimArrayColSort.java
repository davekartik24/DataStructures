import java.util.*;

public class MultiDimArrayColSort {

	private int[][] intArray;
	private int shallowPosition;

	public MultiDimArrayColSort(int[][] intArray, int shallowPosition) {

		this.intArray = intArray;
		this.shallowPosition = shallowPosition;

	}

	public void shallowSort() {

		Arrays.sort(intArray, new impShallowSort());
		for (int[] array : intArray) {

			for (int elements : array) {

				System.out.print(elements + " ");
			}

			System.out.println();
		}

	}

	private class impShallowSort implements Comparator<int[]> {


		public int compare(int[] int1, int[] int2) {

			int result;

			if (int1[shallowPosition] < int2[shallowPosition]) {

				result = -1;

			} else if (int1[shallowPosition] > int2[shallowPosition]) {

				result = 1;

			} else {

				result = 0;
			}

			return result;

		}

	}


	public static void main(String[] args) {

		int[][] intArray = { {1,5,2}, 
					 		 {7,2,9}, 
					 		 {12,4,23} };

		int shallowPosition = 1;


		MultiDimArrayColSort testSort = new MultiDimArrayColSort(intArray, shallowPosition);
		testSort.shallowSort();		
	}
}