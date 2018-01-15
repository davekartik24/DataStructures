public class PositiveAndNegativeArrange {


	public static int partition(int[] array, int start, int end) {

		int i = start;

		for(int j = start; j < end + 1; j++) {

			if(array[j] < 0) {

				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				++i;

			}
		}

		return i;
	}

	public static void main(String[] args) {

		int[] array = {-1, 2, -3, 4, 5, 6, -7, 8, 9};

		int swapPosition = partition(array, 0, array.length - 1);

		int i = 0;
		int j = swapPosition;

		while(j < array.length && i < j && array[i] < 0) {

			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			i += 2;
			++j;
		}

		for(int element : array) {

			System.out.println(element);
		}

	}
}