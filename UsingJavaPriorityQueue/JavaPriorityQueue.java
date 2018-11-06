
import java.util.*;

public class JavaPriorityQueue{


	public static void main(String[] args) {

		Element<Integer> one = new Element<>(1);

		Element<Integer> two = new Element<>(5);

		Element<Integer> three = new Element<>(7);

		Element<Integer> four = new Element<>(10);

		PriorityQueue<Element<Integer>> pq = new PriorityQueue<>(Collections.reverseOrder());

		pq.add(three);
		pq.add(one);
		pq.add(two);
		pq.add(four);
		pq.offer(new Element<Integer>(-1));


		System.out.println(pq.peek());

	}


}