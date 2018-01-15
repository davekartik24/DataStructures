import java.util.*;

public class MinElemInSortRotated {

	public static int getMinNum(ArrayList<Integer> input, int start, int end) {

		if(start > end) {

			return -1;
		}

		if (start == end) {

			return start;
		}

		int mid = (start + end) / 2;

		if((mid > start) && input.get(mid) < input.get(mid - 1)) {

			return mid-1;
		}

		if((mid < end) && input.get(mid) > input.get(mid + 1)) {

			return mid;
		}

		if(input.get(mid) < input.get(start)) {

			return getMinNum(input, start, mid - 1);

		}

		return getMinNum(input, mid + 1 , end);


	}

	public static void main(String[] args) {

		ArrayList<Integer> input = new ArrayList<Integer>();

		input.add(1);
		input.add(2);
		input.add(3);
		input.add(4);
		input.add(5);
		//input.add(6);



		int result = getMinNum(input, 0, input.size() - 1);

		System.out.println(result);

	}
}