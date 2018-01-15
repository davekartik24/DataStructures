import java.util.*;

public class ArrayReverseCollections {

	public static void main(String[] args) {

		

		ArrayList<Integer> array = new ArrayList<Integer>();

		array.add(1);
		array.add(5);
		array.add(8);
		array.add(2);
		array.add(99);
		array.add(100);


		//Collections.reverse(array);

		ListIterator iterate = array.listIterator();

		while(iterate.hasNext()) {
			System.out.println("Hi");
			System.out.println(iterate.next());

		}

		while(iterate.hasPrevious()) {
			System.out.println("Bye");
			System.out.println(iterate.previous());

		}

	}
}