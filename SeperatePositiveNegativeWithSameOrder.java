public class SeperatePositiveNegativeWithSameOrder {

	public static void main(String[] args) {


		int[] array = {12, 11, -13, -5, 6, -7, 5, -3, -6};

		int i = 0;

		for(int j = 0; j < array.length; j++) {

			if(array[j] < 0) {

				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				++i; 
			}
		}

		for(int elements : array) {

			System.out.println(elements);
		}
	}
}