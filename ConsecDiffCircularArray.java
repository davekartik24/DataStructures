import java.util.*;

public class ConsecDiffCircularArray {

	public static void main(String[] args) {

		int[] array = {4, 2, 1, 8};

		int sum = 0;
		int length = array.length;

		Arrays.sort(array);

		for(int i = 0; i < length/2; i++) {

			sum -= (2 * array[i]);
			sum += (2 * array[length - 1 - i]);
		}

		System.out.println(sum);
	}
}