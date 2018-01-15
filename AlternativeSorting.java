import java.util.*;

public class AlternativeSorting {

	public static void main(String[] args) {

		ArrayList<Integer> arrayD = new ArrayList<Integer>();

		arrayD.add(7);
		arrayD.add(1);
		arrayD.add(2);
		arrayD.add(3);
		arrayD.add(4);
		arrayD.add(5);
		arrayD.add(6);

		Collections.sort(arrayD);

		int i = 0;
		int j = arrayD.size() - 1;

		while(!(i==j || i > j)) {

			System.out.println(arrayD.get(i));
			System.out.println(arrayD.get(j));
			++i;
			--j;

		}


	}
}