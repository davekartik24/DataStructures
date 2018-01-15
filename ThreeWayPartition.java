public class ThreeWayPartition {

	public static void main(String[] args) {

		int[] array = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};

		int lower = 14;
		int higher = 20;

		int start = 0;
		int end = array.length - 1;

		int i = 0;

		while (i < end) {

			if(array[i] < lower) {

				int temp = array[i];
				array[i] = array[start];
				array[start] = temp;
				++i;
				start++;

			} else if (array[i] > higher) {

				int temp = array[i];
				array[i] = array[end];
				array[end] = temp;
				--end;

			} else ++i;
		}

		for(int element : array) {

			System.out.println(element);

		}
	}
} 