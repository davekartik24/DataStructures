import java.util.*;

public class KSmallestTerm {

	public static void main(String[] args) {

		int[] array = {7, 10, 4, 3, 20, 15};

		int kValue = 3;

		int result = Integer.MIN_VALUE;

		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();

		for(int elements : array) {

			pQueue.add(elements);
		}	

		for(int i = 0; i < kValue; i++) {

			result = pQueue.poll();

		}

		System.out.println(result);	



	}
}