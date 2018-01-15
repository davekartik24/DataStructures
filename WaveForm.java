public class WaveForm {

	public static void main(String[] args) {

		int[] array = {10, 5, 6, 3, 2, 20, 100, 80};

		for(int i = 1; i < array.length; i += 2) {

			if(array[i] > array[i-1]) {

				int temp = array[i];
				array[i] = array[i-1];
				array[i-1] = temp;
			}

			if(i != (array.length - 1) && array[i] > array[i+1]) {

				int temp = array[i];
				array[i] = array[i+1];
				array[i+1] = temp;
			}
		}


		for(int elements : array) {

			System.out.println(elements);
		}
	}
}