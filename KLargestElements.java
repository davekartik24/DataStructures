import java.util.*;

public class KLargestElements {

	public static void main(String[] args) {

		int[] array = {1, 23, 12, 9, 30, 2, 50};

		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(3);

		for(int i = 0; i < 3; i++) {

			pQueue.add(array[i]);
		}

		for(int i = 3; i < array.length; i++) {

			if(array[i] > pQueue.peek()) {

				pQueue.poll();
				pQueue.add(array[i]);

			}
		}


		System.out.println(pQueue);



	}
}