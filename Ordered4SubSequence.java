public class Ordered4SubSequence {

	public static void main(String[] args) {


		int[] array = {12, 11, 10, 5, 6, 2, 30, 35};

		int arrayLength = array.length;

		int large[] = new int[arrayLength];

		int largest = arrayLength - 1;

		large[largest] = -1;

		for(int i = arrayLength - 2; i >= 0; i--) {

			if(array[i] >= array[largest]) {

				largest = i;
				large[i] = -1;
			} else {

				large[i] = largest;
			}
		}


		int small[] = new int[arrayLength];
		small[0] = -1;

		int smallest = 0;

		for(int i = 0; i < arrayLength; i++) {

			if(array[i] <= array[smallest]) {

				smallest = i;
				small[i] = -1;
			} else {

				small[i] = smallest;
			}
		}

		int count = 0;
		int first = 0;
		int second = 0;
		int third = 0; 
		int last = 0;

		for(int i = 0; i < arrayLength; i++) {

			if(small[i] != -1 && large[i] != -1) {

				if(count == 0) {

					first = array[small[i]];
					second = array[i];
					last = array[large[i]];
					count++;

				} else
				{
					third = array[i];
					System.out.println(first + " " + second + " " + third + " " + last);
					return;
				}

			}
		}

		System.out.println("No such sequence found");
		return;

	}
}