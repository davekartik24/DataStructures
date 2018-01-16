import java.util.*;

public class KSmallestElement2D {

	public static class chageSort implements Comparator<ArrayList<Integer>> {

		public int compare(ArrayList<Integer> a1, ArrayList<Integer> a2) {

			return a1.get(0).compareTo(a2.get(0));
		}


	}

	public static void main(String[] args) {

		PriorityQueue<ArrayList<Integer>> pQueue = new PriorityQueue<ArrayList<Integer>>(4,new chageSort());

		ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();

		int k = 7;

		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(10);
		a1.add(20);
		a1.add(30);
		a1.add(40);

		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a2.add(15);
		a2.add(25);
		a2.add(35);
		a2.add(45);

		ArrayList<Integer> a3 = new ArrayList<Integer>();
		a3.add(24);
		a3.add(29);
		a3.add(37);
		a3.add(48);

		ArrayList<Integer> a4 = new ArrayList<Integer>();
		a4.add(32);
		a4.add(33);
		a4.add(39);
		a4.add(50);

		array.add(a1);
		array.add(a2);
		array.add(a3);
		array.add(a4);


		for(int i = 0; i < array.get(0).size(); i++) {

			ArrayList<Integer> subArray = new ArrayList<Integer>();
			subArray.add(array.get(0).get(i));
			subArray.add(0);
			subArray.add(i);

			pQueue.add(subArray);

		}

		for(int i = 0; i < k - 1; i++) {

			ArrayList<Integer> pollArray = pQueue.poll();

			int row = pollArray.get(1);
			int column = pollArray.get(2);
			ArrayList<Integer> changeArray = new ArrayList<Integer>();
			changeArray.add(array.get(row + 1).get(column));
			changeArray.add(row+1);
			changeArray.add(column);

			pQueue.add(changeArray);
		}

		System.out.println(pQueue);
 
	}
}