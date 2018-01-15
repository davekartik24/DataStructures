public class NegativeAndPositiveOrder {

	public static void main(String[] args) {

		int[] array = {12, 11, -13, -5, 6, -7, 5, -3, -6};

		for(int i = 1; i < array.length; i++) {

			for (int j = i-1; j >= 0; j--) {

				if(array[j] < 0) {

					break;
				}

				if(array[j+1] < 0) {

					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}


			}
		}

		for(int element : array) {

			System.out.println(element);
		}
	}
} 