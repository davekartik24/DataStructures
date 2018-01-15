public class Ordered3SubSequence {

	public static void main(String[] args) {

		int[] array = {12, 11, 10, 5, 6, 2, 30};

		int[] small = new int[array.length];

		small[0] = -1;

		int smallest = 0;

		for(int i = 1; i < array.length; i++) {

			if(array[i] <= array[smallest]) {

				smallest = i;
				small[i] = -1;
			} else {

				small[i] = smallest;
			}
		}


		int[] large = new int[array.length];

		large[array.length - 1] = -1;

		int largest = array.length - 1;


		for(int i = array.length - 2; i >= 0; i--) {

			if(array[i] >= array[largest]) {

				largest = i;
				large[i] = -1;
			} else {

				large[i] = largest;
			}
		}


		for(int i = 0; i < array.length; i++) {

			if(small[i] != -1 && large[i] != -1) {

				System.out.println(array[small[i]] + " " + array[i] + " " + array[large[i]]);
				return;
			}

		} 

		System.out.println("No such sequence found");
		return;
	}
}