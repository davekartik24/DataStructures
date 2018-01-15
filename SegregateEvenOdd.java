public class SegregateEvenOdd {

	public static void main(String[] args) {

		int[] array = {12, 34, 45, 9, 8, 90, 3};

		int start = 0;

		for(int i = 0; i < array.length; i++) {

			if(array[i] % 2 == 0) {

				int temp = array[i];
				array[i] = array[start];
				array[start] = temp;
				start++;
			}
		}

		for(int elements : array) {

			System.out.println(elements);
		}
	}
}